package com.test.carfactory.data.repository

import com.test.carfactory.data.model.UserEntity
import com.test.carfactory.data.model.mapper.UserMapper
import com.test.carfactory.data.repository.source.UserDataStoreFactory
import com.test.carfactory.domain.model.User
import com.test.carfactory.domain.repository.UserRepository
import io.reactivex.Observable

class UserDataRepository(userDataStoreFactory: UserDataStoreFactory, userMapper: UserMapper): UserRepository {
    private val mTownshipDataStoreFactory = userDataStoreFactory
    private val mUserMapper = userMapper

    override fun getUsers(): Observable<List<User>> {
        return mTownshipDataStoreFactory.create().getUsers().map {
            mUserMapper.transformList(it)
        }
    }
}