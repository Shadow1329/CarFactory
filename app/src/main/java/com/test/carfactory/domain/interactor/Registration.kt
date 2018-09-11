package com.test.carfactory.domain.interactor

import com.test.carfactory.domain.interactor.base.CompletableUseCase
import com.test.carfactory.domain.repository.UserRepository
import io.reactivex.Completable

class Registration(userRepository: UserRepository): CompletableUseCase<Pair<String, String>>() {
    private val mUserRepository = userRepository

    override fun buildUseCaseCompletable(param: Pair<String,String>): Completable {
        return mUserRepository.putUser(param.first, param.second)
    }
}