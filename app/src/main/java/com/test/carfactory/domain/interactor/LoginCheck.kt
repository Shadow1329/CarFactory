package com.test.carfactory.domain.interactor

import com.test.carfactory.domain.model.User
import com.test.carfactory.domain.repository.UserRepository
import io.reactivex.Observable

class LoginCheck(userRepository: UserRepository): UseCase<User, Pair<String,String>>() {
    private val mUserRepository = userRepository

    override fun buildUseCaseObservable(param: Pair<String,String>): Observable<User> {
        return mUserRepository.getUserByName(param.first).toObservable()
    }
}