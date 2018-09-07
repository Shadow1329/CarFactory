package com.test.carfactory.data.repository

import com.test.carfactory.data.model.mapper.UserMapper
import com.test.carfactory.data.repository.source.UserDataStoreFactory
import com.test.carfactory.domain.model.User
import com.test.carfactory.domain.repository.UserRepository
import io.reactivex.Single

class UserDataRepository(userDataStoreFactory: UserDataStoreFactory, userMapper: UserMapper): UserRepository {
    private val mTownshipDataStoreFactory = userDataStoreFactory
    private val mUserMapper = userMapper

    override fun getUserByName(name: String): Single<User> {
        return mTownshipDataStoreFactory.create().getUserByName(name).map {
            mUserMapper.transform(it)
        }
    }

    override fun getAllUsers(): Single<List<User>> {
        return mTownshipDataStoreFactory.create().getAllUsers().map {
            mUserMapper.transformList(it)
        }
    }
}