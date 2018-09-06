package com.test.carfactory.domain.repository

import com.test.carfactory.domain.model.User
import io.reactivex.Observable

interface UserRepository {
    fun getUsers(): Observable<List<User>>
}