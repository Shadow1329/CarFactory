package com.test.carfactory.data.db

import com.test.carfactory.data.model.UserEntity
import io.reactivex.Observable

interface UserDB {
    fun get(): Observable<List<UserEntity>>
    fun put(userEntities: List<UserEntity>)
    fun clear()
}