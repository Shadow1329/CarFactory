package com.test.carfactory.data.repository.source

import com.test.carfactory.data.model.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

interface UserDataStore {
    fun putUser(name: String, password: String): Completable
    fun getUserByName(name: String): Single<UserEntity>
    fun getAllUsers(): Single<List<UserEntity>>
}