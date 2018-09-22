package com.test.carfactory

import com.test.carfactory.domain.interactor.LoginCheck
import com.test.carfactory.presentation.login.LoginPresenter
import com.test.carfactory.presentation.login.LoginView
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class LoginPresenterTest {
    private val mUsername = "Name"
    private val mPassword = "Pass"

    private lateinit var mView : LoginView
    private lateinit var mPresenter: LoginPresenter

    @Before
    fun setup() {
        val loginCheck = mock(LoginCheck::class.java)

        mPresenter = LoginPresenter(loginCheck)
        mView = mock(LoginView::class.java)
        mPresenter.attachView(mView)
    }

    @Test
    fun testLoginClick() {
        mPresenter.onLoginClick(mUsername, mPassword)
        verify(mView, times(1)).onShowProgress(true)
    }

    @Test
    fun testRegistrationClick() {
        mPresenter.onRegistrationClick()
        verify(mView, times(1)).onStartRegistration()
    }
}