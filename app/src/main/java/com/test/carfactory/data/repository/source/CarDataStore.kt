package com.test.carfactory.data.repository.source

import com.test.carfactory.data.model.CarEntity
import io.reactivex.Single

interface CarDataStore {
    fun getCars(): Single<List<CarEntity>>
}