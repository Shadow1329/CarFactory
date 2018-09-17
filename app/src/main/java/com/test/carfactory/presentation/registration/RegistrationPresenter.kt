package com.test.carfactory.presentation.registration

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.test.carfactory.domain.interactor.Registration
import io.reactivex.observers.DisposableCompletableObserver

@InjectViewState
class RegistrationPresenter(registration: Registration) : MvpPresenter<RegistrationView>() {
    private val mRegistration = registration

    override fun onDestroy() {
        super.onDestroy()
        mRegistration.dispose()
    }

    fun onCreateClick(username: String, password: String) {
        viewState.onShowProgress(true)
        mRegistration.execute(RegistrationObserver(), Pair(username, password))
    }

    inner class RegistrationObserver: DisposableCompletableObserver() {
        override fun onComplete() {
            viewState.onShowProgress(false)
            viewState.onShowMessage("Successfully created")
            viewState.onFinish()
        }

        override fun onError(e: Throwable) {
            viewState.onShowProgress(false)
            e.message?.let {
                viewState.onShowMessage(it)
            }
        }
    }
}