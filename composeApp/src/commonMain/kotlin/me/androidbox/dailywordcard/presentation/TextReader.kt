package me.androidbox.dailywordcard.presentation

interface TextReader {
    fun readText(text: String)
    fun shutdown()
}