package com.test.carfactory.data.repository

import com.test.carfactory.data.model.mapper.CarMapper
import com.test.carfactory.data.repository.source.CarDataStoreFactory
import com.test.carfactory.domain.model.Car
import com.test.carfactory.domain.repository.CarRepository
import io.reactivex.Single

class CarDataRepository(carDataStoreFactory: CarDataStoreFactory, carMapper: CarMapper) : CarRepository {
    private val mCarDataStoreFactory = carDataStoreFactory
    private val mCarMapper = carMapper

    override fun getCars(): Single<List<Car>> {
        return mCarDataStoreFactory.create().getCars().map {
            mCarMapper.transformList(it)
        }
    }
}