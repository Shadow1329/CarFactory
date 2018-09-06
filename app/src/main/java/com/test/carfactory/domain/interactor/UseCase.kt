package com.test.carfactory.domain.interactor

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, Param> {
    private val mDisposables = CompositeDisposable()

    abstract fun buildUseCaseObservable(param: Param): Observable<T>

    fun execute(observer: DisposableObserver<T>, param: Param) {
        val observable: Observable<T> = buildUseCaseObservable(param)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        addDisposable(observable.subscribeWith(observer))
    }

    fun dispose() {
        if (!mDisposables.isDisposed) {
            mDisposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        mDisposables.add(disposable)
    }
}