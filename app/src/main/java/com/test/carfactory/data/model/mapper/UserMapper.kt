package com.test.carfactory.data.model.mapper

import com.test.carfactory.data.model.UserEntity
import com.test.carfactory.domain.model.User

class UserMapper {
    fun transform(userEntity: UserEntity): User {
        return User(userEntity.mName, userEntity.mPassword)
    }

    fun transformList(userEntities: List<UserEntity>): List<User>{
        val users = arrayListOf<User>()
        for (userEntity in userEntities){
            users.add(transform(userEntity))
        }
        return users
    }
}