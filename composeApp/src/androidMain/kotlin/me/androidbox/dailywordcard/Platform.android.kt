package me.androidbox.dailywordcard

import android.content.Context
import android.os.Build
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import me.androidbox.dailywordcard.presentation.TextReader
import java.util.Locale

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual class TextReaderImp(private val context: Context) : TextReader, DefaultLifecycleObserver {
    private var textToSpeech: TextToSpeech? = null

    init {
        textToSpeech = TextToSpeech(context) { status ->
            if(status == TextToSpeech.SUCCESS) {
                val result = textToSpeech?.setLanguage(Locale.getDefault())

                when(result) {
                    TextToSpeech.LANG_MISSING_DATA -> {
                        Log.e(
                            TextReaderImp::class.simpleName,
                            "Language data missing for default locale"
                        )
                        textToSpeech = null
                    }

                    TextToSpeech.LANG_NOT_SUPPORTED -> {
                        Log.e(
                            TextReaderImp::class.simpleName,
                            "Language not supported for default locale"
                        )
                        textToSpeech = null
                    }

                    TextToSpeech.LANG_AVAILABLE -> {
                        Log.d(
                            TextReaderImp::class.simpleName,
                            "Language available for default locale"
                        )
                    }
                }
            }
            else {
                textToSpeech = null
            }
        }
    }

    actual override fun readText(text: String) {
        if(textToSpeech != null) {
            textToSpeech?.speak(text, TextToSpeech.QUEUE_ADD, null, "")
        }
        else {
            Log.e(TextReaderImp::class.simpleName, "Failed to setup TTS")
        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d(
            TextReaderImp::class.simpleName,
            "onDestroy"
        )
        shutdown()
        super.onDestroy(owner)
    }

    actual override fun shutdown() {
        Log.d(
            TextReaderImp::class.simpleName,
            "shutdown"
        )
        textToSpeech?.stop()
        textToSpeech?.shutdown()
        textToSpeech = null
    }
}