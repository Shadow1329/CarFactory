package com.test.carfactory.data.cache

import com.test.carfactory.data.model.UserEntity
import io.reactivex.Completable
import io.reactivex.Single
import io.realm.Realm

class UserCacheImpl: UserCache {
    override fun putUser(name: String, password: String): Completable {
        try {
            val realm = Realm.getDefaultInstance()

            val userEntity: UserEntity = realm.createObject(UserEntity::class.java)
            userEntity.mName = name
            userEntity.mPassword = password

            realm.beginTransaction()
            realm.copyToRealmOrUpdate(userEntity)
            realm.commitTransaction()
            realm.close()

            return Completable.complete()
        } catch (e: Throwable) {
            return Completable.error(e)
        }
    }

    override fun getUserByName(name: String): Single<UserEntity> {
        try {
            val realm = Realm.getDefaultInstance()
            val userEntity: UserEntity  = realm.copyFromRealm(realm.where(UserEntity::class.java).equalTo("mName", name).findFirst())!!
            realm.close()
            return Single.just(userEntity)
        } catch (e: Throwable) {
            return Single.error(e)
        }
    }

    override fun getAllUsers(): Single<List<UserEntity>> {
        val realm = Realm.getDefaultInstance()
        val userEntities: List<UserEntity>  = realm.copyFromRealm(realm.where(UserEntity::class.java).findAll())
        realm.close()
        return Single.just(userEntities)
    }

    override fun clear() {
        val realm = Realm.getDefaultInstance()
        realm.delete(UserEntity::class.java)
        realm.close()
    }
}