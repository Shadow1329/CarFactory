package com.test.carfactory.data.cache

import com.test.carfactory.data.model.CarEntity
import io.reactivex.Single
import io.realm.Realm

class CarCacheImpl : CarCache {
    override fun isCached(): Boolean {
        return try {
            val carEntities = getAllCars()
            carEntities.isNotEmpty()
        } catch (e: Throwable) {
            false
        }
    }

    override fun getCars(): Single<List<CarEntity>> {
        return try {
            val carEntities = getAllCars()
            Single.just(carEntities)
        } catch (e: Throwable) {
            Single.error(e)
        }
    }

    override fun putCars(carEntities: List<CarEntity>) {
        try {
            val realm = Realm.getDefaultInstance()
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(carEntities);
            realm.commitTransaction();
            realm.close()
        } catch (e: Throwable) {

        }
    }

    private fun getAllCars(): List<CarEntity>  {
        val realm = Realm.getDefaultInstance()
        val carEntities = realm.copyFromRealm(realm.where(CarEntity::class.java).findAll())
        realm.close()
        return carEntities
    }
}