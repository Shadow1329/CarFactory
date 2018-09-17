package com.test.carfactory.presentation.cars

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.test.carfactory.domain.model.Car

@StateStrategyType(AddToEndSingleStrategy::class)
interface CarsView : MvpView {
    fun onShowProgress(show: Boolean)
    fun onShowCars(cars: List<Car>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun onShowMessage(message: String)
}