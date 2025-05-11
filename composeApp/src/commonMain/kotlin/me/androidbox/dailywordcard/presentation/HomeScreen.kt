package me.androidbox.dailywordcard.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dailywordcard.composeapp.generated.resources.Res
import dailywordcard.composeapp.generated.resources.volume_max
import me.androidbox.dailywordcard.presentation.model.WordDefinition
import me.androidbox.dailywordcard.presentation.model.wordList
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    wordDefinition: WordDefinition,
    modifier: Modifier = Modifier,
    onSpeakClicked: (text: String) -> Unit) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            listOf(
                                Color(0xFF6B74F8),
                                Color(0xFFFDE5F3),
                                Color(0xFFFEF7EE)
                            ),
                            start = Offset(0f, 0f),
                            end = Offset(0f, Float.POSITIVE_INFINITY))),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    WordCard(
                        wordDefinition = wordDefinition
                    )

                    Spacer(modifier = Modifier.height(36.dp))

                    IconButton(
                        modifier = Modifier
                            .size(80.dp)
                            .background(color = Color(0xff6B74F8), shape = CircleShape),
                        onClick = {
                            onSpeakClicked("Hello, Steve how are you today")
                        }
                    ) {
                        Icon(
                            imageVector = vectorResource(resource = Res.drawable.volume_max),
                            contentDescription = "Press to read text",
                            tint = Color.Unspecified
                        )
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            wordDefinition = wordList[0],
            onSpeakClicked = {}
        )
    }
}