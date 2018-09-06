package com.test.carfactory.data.repository.source

import com.test.carfactory.data.db.UserDB
import com.test.carfactory.data.model.UserEntity
import io.reactivex.Observable

class UserLocalDataStore(userDB: UserDB): UserDataStore {
    private val mUserDB = userDB

    override fun getUsers(): Observable<List<UserEntity>> {
        return mUserDB.get()
    }
}