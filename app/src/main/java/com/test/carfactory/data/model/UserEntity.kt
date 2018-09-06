package com.test.carfactory.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

class UserEntity(name: String, password: String): RealmObject() {
    @PrimaryKey
    var mName = name
    var mPassword = password
}