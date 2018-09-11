package com.test.carfactory.data.repository.source

import com.test.carfactory.data.cache.UserCache
import com.test.carfactory.data.model.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

class UserLocalDataStore(userCache: UserCache): UserDataStore {
    private val mUserCache = userCache

    override fun putUser(name: String, password: String): Completable {
        return mUserCache.putUser(name, password)
    }

    override fun getUserByName(name: String): Single<UserEntity> {
        return mUserCache.getUserByName(name)
    }

    override fun getAllUsers(): Single<List<UserEntity>> {
        return mUserCache.getAllUsers()
    }
}