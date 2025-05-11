package me.androidbox.dailywordcard.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.androidbox.dailywordcard.montserrat
import me.androidbox.dailywordcard.poltawskiNowy
import me.androidbox.dailywordcard.presentation.model.WordDefinition
import me.androidbox.dailywordcard.presentation.model.wordList
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun WordCard(
    wordDefinition: WordDefinition,
    modifier: Modifier = Modifier
        .size(364.dp)) {

    Card(
        modifier = modifier,
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = wordDefinition.word,
                fontFamily = poltawskiNowy,
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFf13182C)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = wordDefinition.definition,
                textAlign = TextAlign.Center,
                fontSize = 19.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight.Normal,
                color = Color(0xFf4C4F59)
            )
        }
    }
}

@Preview()
@Composable
fun WordCardPreview() {
    MaterialTheme {
        WordCard(
            wordDefinition = wordList[0]
        )
    }
}