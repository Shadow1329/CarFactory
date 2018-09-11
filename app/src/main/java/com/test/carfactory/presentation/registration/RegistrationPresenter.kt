package com.test.carfactory.presentation.registration

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.test.carfactory.data.cache.UserCacheImpl
import com.test.carfactory.data.model.mapper.UserMapper
import com.test.carfactory.data.repository.UserDataRepository
import com.test.carfactory.data.repository.source.UserDataStoreFactory
import com.test.carfactory.domain.interactor.Registration
import io.reactivex.observers.DisposableCompletableObserver

@InjectViewState
class RegistrationPresenter : MvpPresenter<RegistrationView>() {

    private val mUserMapper = UserMapper()
    private val mUserCache = UserCacheImpl()
    private val mUserDataStoreFactory = UserDataStoreFactory(mUserCache)
    private val mUserDataRepository = UserDataRepository(mUserDataStoreFactory, mUserMapper)
    private val mRegistration = Registration(mUserDataRepository)

    fun onCreateClick(username: String, password: String) {
        viewState.onShowProgress(true)
        mRegistration.execute(RegistrationObserver(), Pair(username, password))
    }

    fun onCancelClick() {
        viewState.onBack()
    }

    inner class RegistrationObserver: DisposableCompletableObserver() {

        override fun onComplete() {
            viewState.onShowProgress(false)
            viewState.onBack()
        }

        override fun onError(e: Throwable) {
            viewState.onShowProgress(false)
            e.message?.let {
                viewState.onShowError(it)
            }
        }
    }
}