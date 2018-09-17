package com.test.carfactory.domain.repository

import com.test.carfactory.domain.model.Car
import io.reactivex.Single

interface CarRepository {
    fun getCars(): Single<List<Car>>
}