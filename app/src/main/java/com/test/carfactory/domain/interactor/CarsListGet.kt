package com.test.carfactory.domain.interactor

import com.test.carfactory.domain.interactor.base.SingleUseCase
import com.test.carfactory.domain.model.Car
import com.test.carfactory.domain.repository.CarRepository
import io.reactivex.Single

class CarsListGet(carRepository: CarRepository): SingleUseCase<List<Car>, Void?>() {
    private val mCarRepository = carRepository

    override fun buildUseCaseSingle(param: Void?): Single<List<Car>> {
        return mCarRepository.getCars()
    }
}