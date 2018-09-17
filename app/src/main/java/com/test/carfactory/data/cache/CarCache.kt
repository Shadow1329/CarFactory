package com.test.carfactory.data.cache

import com.test.carfactory.data.model.CarEntity
import io.reactivex.Single

interface CarCache {
    fun isCached(): Boolean
    fun getCars(): Single<List<CarEntity>>
    fun putCars(carEntities: List<CarEntity>)
}