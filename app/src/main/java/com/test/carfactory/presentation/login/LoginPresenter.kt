package com.test.carfactory.presentation.login

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.test.carfactory.domain.interactor.LoginCheck
import io.reactivex.observers.DisposableCompletableObserver

@InjectViewState
class LoginPresenter(loginCheck: LoginCheck) : MvpPresenter<LoginView>() {
    private val mLoginCheck = loginCheck

    override fun onDestroy() {
        super.onDestroy()
        mLoginCheck.dispose()
    }

    fun onLoginClick(username: String, password: String) {
        viewState.onShowProgress(true)
        mLoginCheck.execute(LoginCheckObserver(), Pair(username, password))
    }

    fun onRegistrationClick() {
        viewState.onStartRegistration()
    }

    private inner class LoginCheckObserver: DisposableCompletableObserver() {
        override fun onComplete() {
            viewState.onShowProgress(false)
            viewState.onStartMain()
        }

        override fun onError(e: Throwable) {
            viewState.onShowProgress(false)
            e.message?.let {
                viewState.onShowMessage(it)
            }
        }
    }
}