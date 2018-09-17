package com.test.carfactory.data.repository.source

import com.test.carfactory.data.cache.CarCache
import com.test.carfactory.data.model.CarEntity
import io.reactivex.Single

class CarCloudDataStore(carCache: CarCache): CarDataStore {
    private val mCarCache = carCache

    override fun getCars(): Single<List<CarEntity>> {

        val carList = mutableListOf<CarEntity>()
        carList.add(CarEntity("Audi", "A30"))
        carList.add(CarEntity("Mercedes", "Benz"))

        return Single.just(carList.toList()).doOnSuccess {
            mCarCache.putCars(carList)
        }
    }
}