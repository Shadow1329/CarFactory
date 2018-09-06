package com.test.carfactory.presentation.login

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface LoginView  : MvpView {
    fun onStartMain()
    fun onShowError(error: String)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun onShowProgress(show: Boolean)
}