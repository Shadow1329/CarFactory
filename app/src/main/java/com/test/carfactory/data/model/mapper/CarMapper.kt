package com.test.carfactory.data.model.mapper

import com.test.carfactory.data.model.CarEntity
import com.test.carfactory.domain.model.Car

class CarMapper {
    fun transform(carEntity: CarEntity): Car {
        return Car(carEntity.mMakeName, carEntity.mVehicleTypeName)
    }

    fun transformList(carEntities: List<CarEntity>): List<Car>{
        val cars = arrayListOf<Car>()
        for (carEntity in carEntities){
            cars.add(transform(carEntity))
        }
        return cars
    }
}