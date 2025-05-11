package me.androidbox.dailywordcard.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.androidbox.dailywordcard.presentation.model.WordDefinition
import me.androidbox.dailywordcard.presentation.model.wordList

class DailyWordCardViewModel(
    private val textReader: TextReader
) : ViewModel() {

    var wordDefinition = mutableStateOf(WordDefinition("", ""))
        private set

    init {
        loadDailyWord()
    }

    fun loadDailyWord() {
        viewModelScope.launch {
            wordDefinition.value = wordList.random()
        }
    }

    fun speak(text: String) {
        textReader.readText(text)
    }
}