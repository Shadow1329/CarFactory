package com.test.carfactory.presentation.cars

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.test.carfactory.domain.interactor.CarsListGet
import com.test.carfactory.domain.model.Car
import io.reactivex.observers.DisposableSingleObserver

@InjectViewState
class CarsPresenter(carsListGet: CarsListGet) : MvpPresenter<CarsView>() {
    private val mCarsListGet = carsListGet

    init {
        onLoadData()
    }

    override fun onDestroy() {
        super.onDestroy()
        mCarsListGet.dispose()
    }

    fun onLoadData() {
        viewState.onShowProgress(true)
        mCarsListGet.execute(CarsGetObserver(), null)
    }

    private inner class CarsGetObserver: DisposableSingleObserver<List<Car>>() {
        override fun onSuccess(t: List<Car>) {
            viewState.onShowCars(t)
            viewState.onShowProgress(false)
        }

        override fun onError(e: Throwable) {
            viewState.onShowProgress(false)
            e.message?.let {
                viewState.onShowMessage(it)
            }
        }
    }
}