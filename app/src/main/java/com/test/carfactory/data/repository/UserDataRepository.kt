package com.test.carfactory.data.repository

import com.test.carfactory.data.model.mapper.UserMapper
import com.test.carfactory.data.repository.source.UserDataStoreFactory
import com.test.carfactory.domain.model.User
import com.test.carfactory.domain.repository.UserRepository
import io.reactivex.Completable
import io.reactivex.Single

class UserDataRepository(userDataStoreFactory: UserDataStoreFactory, userMapper: UserMapper) : UserRepository {
    private val mUserDataStoreFactory = userDataStoreFactory
    private val mUserMapper = userMapper

    override fun putUser(name: String, password: String): Completable {
        return mUserDataStoreFactory.create().putUser(name, password)
    }

    override fun getUserByName(name: String): Single<User> {
        return mUserDataStoreFactory.create().getUserByName(name).map {
            mUserMapper.transform(it)
        }
    }

    override fun getAllUsers(): Single<List<User>> {
        return mUserDataStoreFactory.create().getAllUsers().map {
            mUserMapper.transformList(it)
        }
    }
}