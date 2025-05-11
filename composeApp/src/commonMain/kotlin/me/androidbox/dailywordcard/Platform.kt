package me.androidbox.dailywordcard

import me.androidbox.dailywordcard.presentation.TextReader

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect class TextReaderImp : TextReader {
    override fun readText(text: String)
    override fun shutdown()
}