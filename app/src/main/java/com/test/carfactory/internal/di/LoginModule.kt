package com.test.carfactory.internal.di

import com.test.carfactory.data.repository.UserDataRepository
import com.test.carfactory.domain.interactor.LoginCheck
import com.test.carfactory.presentation.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module(includes = [(UserRepositoryModule::class)])
class LoginModule {
    @Provides
    fun provideLoginPresenter(loginCheck: LoginCheck): LoginPresenter {
        return LoginPresenter(loginCheck)
    }

    @Provides
    fun provideLoginCheck(userDataRepository: UserDataRepository): LoginCheck {
        return LoginCheck(userDataRepository)
    }
}