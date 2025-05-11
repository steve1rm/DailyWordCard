package me.androidbox.dailywordcard

import me.androidbox.dailywordcard.presentation.TextReader
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual class TextReaderImp() : TextReader {
    actual override fun readText(text: String) {
        TODO("Not yet implemented")
    }
}