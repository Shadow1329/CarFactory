package com.test.carfactory.internal.di

import com.test.carfactory.data.cache.CarCache
import com.test.carfactory.data.cache.CarCacheImpl
import com.test.carfactory.data.model.mapper.CarMapper
import com.test.carfactory.data.net.RestAPI
import com.test.carfactory.data.repository.CarDataRepository
import com.test.carfactory.data.repository.source.CarDataStoreFactory
import dagger.Module
import dagger.Provides

@Module
class CarRepositoryModule {
    @Provides
    fun provideCarDataRepository(carDataStoreFactory: CarDataStoreFactory, carMapper: CarMapper): CarDataRepository {
        return CarDataRepository(carDataStoreFactory, carMapper)
    }

    @Provides
    fun provideCarDataStoreFactory(restApi: RestAPI, carCache: CarCache): CarDataStoreFactory {
        return CarDataStoreFactory(restApi, carCache)
    }

    @Provides
    fun provideCarCache(): CarCache {
        return CarCacheImpl()
    }

    @Provides
    fun provideCarMapper(): CarMapper {
        return CarMapper()
    }
}