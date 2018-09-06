package com.test.carfactory.domain.interactor

import io.reactivex.observers.DisposableObserver

open class DefaultObserver<T>: DisposableObserver<T>() {
    override fun onComplete() {}

    override fun onNext(item: T) {}

    override fun onError(e: Throwable) {}
}