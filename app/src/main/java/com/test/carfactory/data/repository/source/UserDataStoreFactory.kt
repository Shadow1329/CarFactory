package com.test.carfactory.data.repository.source

import com.test.carfactory.data.db.UserDB

class UserDataStoreFactory(userDB: UserDB) {
    private val mUserDB = userDB;

    fun create(): UserDataStore {
        return UserLocalDataStore(mUserDB)
    }
}