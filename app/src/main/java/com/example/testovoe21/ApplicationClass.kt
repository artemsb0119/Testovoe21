package com.example.testovoe21

import android.app.Application
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "8e598612-0c7b-4e99-9ee3-91b35f2ee9cb"

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}