package com.test.carfactory.data.repository.source

import com.test.carfactory.data.cache.CarCache

class CarDataStoreFactory(carCache: CarCache) {
    private val mCarCache = carCache

    fun create(): CarDataStore {
        return when(mCarCache.isCached()){
            true -> CarLocalDataStore(mCarCache)
            false -> CarCloudDataStore(mCarCache)
        }
    }
}