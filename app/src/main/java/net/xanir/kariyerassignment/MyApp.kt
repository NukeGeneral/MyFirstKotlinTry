package net.xanir.kariyerassignment

import android.app.Application


/**
 * Created by Umur Kaya on 20-Sep-19.
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: MyApp
            private set
    }
}