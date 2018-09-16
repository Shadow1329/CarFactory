package com.test.carfactory.internal.di

import com.test.carfactory.data.repository.UserDataRepository
import com.test.carfactory.domain.interactor.Registration
import com.test.carfactory.presentation.registration.RegistrationPresenter
import dagger.Module
import dagger.Provides

@Module(includes = [(UserRepositoryModule::class)])
class RegistrationModule {
    @Provides
    fun provideRegistrationPresenter(registration: Registration): RegistrationPresenter {
        return RegistrationPresenter(registration)
    }

    @Provides
    fun provideRegistration(userDataRepository: UserDataRepository): Registration {
        return Registration(userDataRepository)
    }
}