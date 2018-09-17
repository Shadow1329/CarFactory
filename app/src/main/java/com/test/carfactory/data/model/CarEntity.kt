package com.test.carfactory.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CarEntity(name: String = "", description: String = ""): RealmObject() {
    @PrimaryKey
    var mName = name
    var mDescription = description
}