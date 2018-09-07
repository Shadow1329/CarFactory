package com.test.carfactory.data.cache

import com.test.carfactory.data.model.UserEntity
import io.reactivex.Single
import io.realm.Realm

class UserCacheImpl: UserCache {
    override fun putUser(userEntity: UserEntity) {
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(userEntity)
        realm.commitTransaction()
        realm.close()
    }

    override fun getUserByName(name: String): Single<UserEntity> {
        val realm = Realm.getDefaultInstance()
        val userEntities: UserEntity  = realm.copyFromRealm(realm.where(UserEntity::class.java).equalTo("mName", name).findFirst())!!
        realm.close()
        return Single.just(userEntities)
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