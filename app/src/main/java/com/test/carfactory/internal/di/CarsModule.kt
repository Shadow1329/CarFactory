package com.test.carfactory.internal.di

import com.test.carfactory.data.repository.CarDataRepository
import com.test.carfactory.domain.interactor.CarsListGet
import com.test.carfactory.presentation.cars.CarsPresenter
import dagger.Module
import dagger.Provides

@Module(includes = [(CarRepositoryModule::class)])
class CarsModule {
    @Provides
    fun provideCarsPresenter(carsListGet: CarsListGet): CarsPresenter {
        return CarsPresenter(carsListGet)
    }

    @Provides
    fun provideCarsListGet(carDataRepository: CarDataRepository): CarsListGet {
        return CarsListGet(carDataRepository)
    }
}