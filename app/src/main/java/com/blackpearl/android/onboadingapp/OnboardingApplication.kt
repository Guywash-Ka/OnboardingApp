package com.blackpearl.android.onboadingapp

import android.app.Application

class OnboardingApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        DataStoreRepository.initialize(this)
    }
}