package com.test.carfactory.data.repository.source

import com.test.carfactory.data.model.UserEntity
import io.reactivex.Observable

interface UserDataStore {
    fun getUsers(): Observable<List<UserEntity>>
}