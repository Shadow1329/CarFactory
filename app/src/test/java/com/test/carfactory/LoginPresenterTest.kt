package com.test.carfactory

import com.test.carfactory.domain.interactor.LoginCheck
import com.test.carfactory.domain.model.User
import com.test.carfactory.domain.repository.UserRepository
import com.test.carfactory.presentation.login.LoginPresenter
import com.test.carfactory.presentation.login.LoginView
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

class LoginPresenterTest {
    private val mUsername = "Name"
    private val mPassword = "Pass"

    private lateinit var mView : LoginView
    private lateinit var mPresenter: LoginPresenter

    @Before
    fun setup() {
        val repo = mock(UserRepository::class.java)
        val loginCheck = LoginCheck(repo)

        Mockito.`when`(repo.getUserByName(mUsername)).thenReturn(Single.just(User(mUsername, mPassword)))

        mPresenter = LoginPresenter(loginCheck)
        mView = mock(LoginView::class.java)
        mPresenter.attachView(mView)
    }

    @Test
    fun testRegistrationClick() {
        mPresenter.onRegistrationClick()
        verify(mView, times(1)).onStartRegistration()
    }
}