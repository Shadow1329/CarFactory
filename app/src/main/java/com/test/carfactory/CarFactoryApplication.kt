package com.test.carfactory

import android.app.Application
import com.test.carfactory.internal.di.*

class CarFactoryApplication : Application() {
    private lateinit var mApplicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .realmModule(RealmModule(this))
                .loginModule(LoginModule())
                .registrationModule(RegistrationModule())
                .build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return mApplicationComponent
    }
}