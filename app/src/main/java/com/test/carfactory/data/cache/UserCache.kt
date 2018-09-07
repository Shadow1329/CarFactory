package com.test.carfactory.data.cache

import com.test.carfactory.data.model.UserEntity
import io.reactivex.Single

interface UserCache {
    fun putUser(userEntity: UserEntity)
    fun getUserByName(name: String): Single<UserEntity>
    fun getAllUsers(): Single<List<UserEntity>>
    fun clear()
}