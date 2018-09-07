package com.test.carfactory.presentation.login

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.test.carfactory.data.cache.UserCacheImpl
import com.test.carfactory.data.model.mapper.UserMapper
import com.test.carfactory.data.repository.UserDataRepository
import com.test.carfactory.data.repository.source.UserDataStoreFactory
import com.test.carfactory.domain.interactor.DefaultObserver
import com.test.carfactory.domain.interactor.LoginCheck
import com.test.carfactory.domain.model.User

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {

    private val mUserMapper = UserMapper()
    private val mUserCache = UserCacheImpl()
    private val mUserDataStoreFactory = UserDataStoreFactory(mUserCache)
    private val mUserDataRepository = UserDataRepository(mUserDataStoreFactory, mUserMapper);
    private val mLoginCheck = LoginCheck(mUserDataRepository)

    fun onLoginClick(username: String, password: String) {
        viewState.onShowProgress(true)
        mLoginCheck.execute(LoginCheckObserver(), Pair(username, password));
    }

    inner class LoginCheckObserver: DefaultObserver<User>() {

        override fun onComplete() {
            viewState.onShowProgress(false)
        }

        override fun onError(e: Throwable) {
            viewState.onShowProgress(false)
            e.message?.let {
                viewState.onShowError(it)
            }
        }

        override fun onNext(item: User) {
            viewState.onStartMain()
        }
    }
}