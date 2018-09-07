package com.test.carfactory.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserEntity(): RealmObject() {
    @PrimaryKey
    var mName: String = ""
    var mPassword: String = ""
}