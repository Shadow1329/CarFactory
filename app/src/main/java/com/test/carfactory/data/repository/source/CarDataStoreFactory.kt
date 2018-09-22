package com.test.carfactory.data.repository.source

import com.test.carfactory.data.cache.CarCache
import com.test.carfactory.data.net.RestAPI

class CarDataStoreFactory(restApi: RestAPI, carCache: CarCache) {
    private val mRestApi = restApi
    private val mCarCache = carCache

    fun create(): CarDataStore {
        return when(mCarCache.isCached()){
            true -> CarLocalDataStore(mCarCache)
            false -> CarCloudDataStore(mRestApi, mCarCache)
        }
    }
}