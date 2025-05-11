package me.androidbox.dailywordcard

import me.androidbox.dailywordcard.presentation.TextReader
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidSpecificModule = module {
    single<TextReader> {
        TextReaderImp(androidContext())
    }
}