package com.test.carfactory.data.repository.source

import com.test.carfactory.data.cache.CarCache
import com.test.carfactory.data.model.CarEntity
import com.test.carfactory.data.net.RestAPI
import io.reactivex.Single

class CarCloudDataStore(restApi: RestAPI, carCache: CarCache): CarDataStore {
    private val mRestApi = restApi
    private val mCarCache = carCache

    override fun getCars(): Single<List<CarEntity>> {
        return mRestApi.getCars().map {
            it.mResults
        }.doOnSuccess {
            mCarCache.putCars(it)
        }
    }
}