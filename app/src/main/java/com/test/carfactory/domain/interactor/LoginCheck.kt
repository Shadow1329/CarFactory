package com.test.carfactory.domain.interactor

import com.test.carfactory.domain.interactor.base.SingleUseCase
import com.test.carfactory.domain.model.User
import com.test.carfactory.domain.repository.UserRepository
import io.reactivex.Single

class LoginCheck(userRepository: UserRepository): SingleUseCase<User, Pair<String, String>>() {
    private val mUserRepository = userRepository

    override fun buildUseCaseSingle(param: Pair<String,String>): Single<User> {
        return mUserRepository.getUserByName(param.first)
    }
}