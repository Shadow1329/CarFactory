package com.test.carfactory.data.repository.source

import com.test.carfactory.data.cache.CarCache
import com.test.carfactory.data.model.CarEntity
import io.reactivex.Single

class CarLocalDataStore(carCache: CarCache): CarDataStore {
    private val mCarCache = carCache

    override fun getCars(): Single<List<CarEntity>> {
        return mCarCache.getCars()
    }
}