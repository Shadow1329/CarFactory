package com.test.carfactory.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CarEntity(makeId: Int = -1, makeName: String = "", vehicleTypeId: Int = -1, vehicleTypeName: String = ""): RealmObject() {
    @PrimaryKey
    @SerializedName("MakeId")
    var mMakeId = makeId

    @SerializedName("MakeName")
    var mMakeName = makeName

    @SerializedName("VehicleTypeId")
    var mVehicleTypeId = vehicleTypeId

    @SerializedName("VehicleTypeName")
    var mVehicleTypeName = vehicleTypeName
}