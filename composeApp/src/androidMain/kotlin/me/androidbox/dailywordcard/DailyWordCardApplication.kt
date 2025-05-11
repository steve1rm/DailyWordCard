package me.androidbox.dailywordcard

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class DailyWordCardApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin(
            config = {
                androidLogger()
                androidContext(this@DailyWordCardApplication)
            },
            platformSpecificModules = arrayOf(androidSpecificModule)
        )
    }
}