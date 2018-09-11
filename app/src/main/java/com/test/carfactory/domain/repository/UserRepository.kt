package com.test.carfactory.domain.repository

import com.test.carfactory.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface UserRepository {
    fun putUser(name: String, password: String): Completable
    fun getUserByName(name: String): Single<User>
    fun getAllUsers(): Single<List<User>>
}