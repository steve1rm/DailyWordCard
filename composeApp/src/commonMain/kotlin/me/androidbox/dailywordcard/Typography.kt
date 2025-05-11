package me.androidbox.dailywordcard


import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import dailywordcard.composeapp.generated.resources.Montserrat_Regular
import dailywordcard.composeapp.generated.resources.PoltawskiNowy_Bold
import dailywordcard.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font


val poltawskiNowy: FontFamily
    @Composable
    get() {
        return FontFamily(
            Font(resource = Res.font.PoltawskiNowy_Bold, weight = FontWeight.Bold)
        )
    }

val montserrat: FontFamily
    @Composable
    get() {
        return FontFamily(
            Font(resource = Res.font.Montserrat_Regular, weight = FontWeight.Normal)
        )
    }


