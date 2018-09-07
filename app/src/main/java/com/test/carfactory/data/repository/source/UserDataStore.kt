package com.test.carfactory.data.repository.source

import com.test.carfactory.data.model.UserEntity
import io.reactivex.Single

interface UserDataStore {
    fun getUserByName(name: String): Single<UserEntity>
    fun getAllUsers(): Single<List<UserEntity>>
}