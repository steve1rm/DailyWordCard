package me.androidbox.dailywordcard.di

import me.androidbox.dailywordcard.presentation.DailyWordCardViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val dailyWordCardModule = module {

    viewModelOf(::DailyWordCardViewModel)
}