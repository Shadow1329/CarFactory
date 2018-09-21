package com.test.carfactory.data.repository.source

import com.test.carfactory.data.cache.UserCache

class UserDataStoreFactory(userCache: UserCache) {
    private val mUserCache = userCache

    fun create(): UserDataStore {
        return UserLocalDataStore(mUserCache)
    }
}