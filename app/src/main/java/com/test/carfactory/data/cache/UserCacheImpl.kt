package com.test.carfactory.data.cache

import com.test.carfactory.data.model.UserEntity
import io.reactivex.Completable
import io.reactivex.Single
import io.realm.Realm

class UserCacheImpl: UserCache {
    override fun putUser(name: String, password: String): Completable {
        try {
            val realm = Realm.getDefaultInstance()

            val userEntity: UserEntity = realm.createObject(UserEntity::class.java, name)
            userEntity.mPassword = password

            realm.beginTransaction()
            realm.copyToRealmOrUpdate(userEntity)
            realm.commitTransaction()
            realm.close()
        } catch (e: Throwable) {
            return Completable.error(e)
        }
        return Completable.complete()
    }

    override fun getUserByName(name: String): Single<UserEntity> {
        val userEntity: UserEntity
        try {
            val realm = Realm.getDefaultInstance()
            val realmResult: UserEntity = realm.where(UserEntity::class.java).equalTo("mName", name).findFirst()!!
            userEntity = realm.copyFromRealm(realmResult)
            realm.close()
        } catch (e: Throwable) {
            return Single.error(Throwable("User not found"))
        }
        return Single.just(userEntity)
    }

    override fun getAllUsers(): Single<List<UserEntity>> {
        val userEntities: List<UserEntity>
        try {
            val realm = Realm.getDefaultInstance()
            userEntities = realm.copyFromRealm(realm.where(UserEntity::class.java).findAll())
            realm.close()
        } catch (e: Throwable) {
            return Single.error(e)
        }
        return Single.just(userEntities)
    }
}