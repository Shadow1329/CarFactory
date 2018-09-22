package com.test.carfactory.internal.di

import com.test.carfactory.presentation.cars.CarsFragment
import com.test.carfactory.presentation.login.LoginActivity
import com.test.carfactory.presentation.registration.RegistrationActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class), (RealmModule::class), (RestModule::class), (LoginModule::class), (RegistrationModule::class), (CarsModule::class)])
interface ApplicationComponent {
    fun inject(activity: LoginActivity)
    fun inject(activity: RegistrationActivity)
    fun inject(fragment: CarsFragment)
}