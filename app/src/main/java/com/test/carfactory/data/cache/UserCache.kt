package com.test.carfactory.data.cache

import com.test.carfactory.data.model.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

interface UserCache {
    fun putUser(name: String, password: String): Completable
    fun getUserByName(name: String): Single<UserEntity>
    fun getAllUsers(): Single<List<UserEntity>>
}