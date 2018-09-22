package com.test.carfactory.internal

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
                .restModule(RestModule())
                .loginModule(LoginModule())
                .registrationModule(RegistrationModule())
                .carsModule(CarsModule())
                .build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return mApplicationComponent
    }
}