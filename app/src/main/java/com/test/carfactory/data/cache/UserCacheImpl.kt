package com.test.carfactory.data.cache

import com.test.carfactory.data.model.UserEntity
import io.reactivex.Completable
import io.reactivex.Single
import io.realm.Realm
import java.util.concurrent.TimeUnit

class UserCacheImpl: UserCache {
    override fun putUser(name: String, password: String): Completable {
        val result = Completable.timer(2L, TimeUnit.SECONDS)
        return try {
            if (name.isEmpty())
                throw Throwable("Empty username")
            if (password.isEmpty())
                throw Throwable("Empty password")

            val realm = Realm.getDefaultInstance()

            realm.beginTransaction()
            realm.copyToRealmOrUpdate(UserEntity(name, password))
            realm.commitTransaction()

            realm.close()
            result
        } catch (e: Throwable) {
            result.doOnComplete { throw e }
        }
    }

    override fun getUserByName(name: String): Single<UserEntity> {
        val result = Single.timer(2L, TimeUnit.SECONDS)
        return try {
            val realm = Realm.getDefaultInstance()

            val realmResult: UserEntity = realm.where(UserEntity::class.java).equalTo("mName", name).findFirst()!!
            val userEntity = realm.copyFromRealm(realmResult)

            realm.close()
            result.map { userEntity }
        } catch (e: Throwable) {
            result.doOnSuccess { throw Throwable("User not found") }.cast(UserEntity::class.java)
        }
    }

    override fun getAllUsers(): Single<List<UserEntity>> {
        return try {
            val realm = Realm.getDefaultInstance()
            val userEntities = realm.copyFromRealm(realm.where(UserEntity::class.java).findAll())
            realm.close()
            Single.just(userEntities)
        } catch (e: Throwable) {
            Single.error(e)
        }
    }
}