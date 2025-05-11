package me.androidbox.dailywordcard

import me.androidbox.dailywordcard.presentation.TextReader
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual class TextReaderImp() : TextReader {
    private val synthesizer = AVSpeechSynthesizer()

    actual override fun readText(text: String) {
        // Create an AVSpeechUtterance with the text
        val utterance = AVSpeechUtterance(string = text)

        // Optionally, set the voice and other properties
        // You can get a list of available voices with AVSpeechSynthesisVoice.speechVoices()
        // For example, to use the default language voice:
        utterance.voice = AVSpeechSynthesisVoice.voiceWithLanguage(NSLocale.currentLocale.languageCode)

        // You can adjust rate, pitch, and volume:
        // utterance.rate = 0.5 // Slower
        // utterance.pitchMultiplier = 1.2 // Higher pitch
        // utterance.volume = 0.8 // Lower volume

        // Speak the utterance
        synthesizer.speakUtterance(utterance)
    }

    actual override fun shutdown() {
        // Stop any ongoing speech
        synthesizer.stopSpeakingAtBoundary(platform.AVFoundation.AVSpeechBoundary.AVSpeechBoundaryImmediate)
        // AVSpeechSynthesizer doesn't have an explicit shutdown like Android's TextToSpeech.
        // Releasing the instance and letting ARC handle it is sufficient.
    }
}