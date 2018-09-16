package com.test.carfactory.internal.di

import com.test.carfactory.data.cache.UserCache
import com.test.carfactory.data.cache.UserCacheImpl
import com.test.carfactory.data.model.mapper.UserMapper
import com.test.carfactory.data.repository.UserDataRepository
import com.test.carfactory.data.repository.source.UserDataStoreFactory
import dagger.Module
import dagger.Provides

@Module
class UserRepositoryModule {
    @Provides
    fun provideUserDataRepository(userDataStoreFactory: UserDataStoreFactory, userMapper: UserMapper): UserDataRepository {
        return UserDataRepository(userDataStoreFactory, userMapper)
    }

    @Provides
    fun provideUserDataStoreFactory(userCache: UserCache): UserDataStoreFactory {
        return UserDataStoreFactory(userCache)
    }

    @Provides
    fun provideUserCache(): UserCache {
        return UserCacheImpl()
    }

    @Provides
    fun provideUserMapper(): UserMapper {
        return UserMapper()
    }
}