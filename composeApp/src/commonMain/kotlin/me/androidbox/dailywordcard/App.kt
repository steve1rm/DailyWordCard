package me.androidbox.dailywordcard

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import me.androidbox.dailywordcard.presentation.DailyWordCardViewModel
import me.androidbox.dailywordcard.presentation.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val dailyWordCardViewModel = koinViewModel<DailyWordCardViewModel>()
        val wordDefinition by dailyWordCardViewModel.wordDefinition

        HomeScreen(
            wordDefinition = wordDefinition,
            onSpeakClicked = { text ->
                dailyWordCardViewModel.speak(text)
            }
        )
    }
}