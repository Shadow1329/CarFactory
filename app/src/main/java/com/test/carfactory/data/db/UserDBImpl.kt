package com.test.carfactory.data.db

import com.test.carfactory.data.model.UserEntity
import io.reactivex.Observable
import io.realm.Realm

class UserDBImpl: UserDB {
    override fun get(): Observable<List<UserEntity>> {
        val realm = Realm.getDefaultInstance()
        val userEntities: List<UserEntity>  = realm.copyFromRealm(realm.where(UserEntity::class.java).findAll())
        realm.close()
        return Observable.just(userEntities)
    }

    override fun put(userEntities: List<UserEntity>) {
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(userEntities)
        realm.commitTransaction()
        realm.close()
    }

    override fun clear() {
        val realm = Realm.getDefaultInstance()
        realm.delete(UserEntity::class.java)
        realm.close()
    }
}