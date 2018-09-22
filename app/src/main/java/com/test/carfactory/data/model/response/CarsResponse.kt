package com.test.carfactory.data.model.response

import com.google.gson.annotations.SerializedName
import com.test.carfactory.data.model.CarEntity

class CarsResponse {
    @SerializedName("Count")
    var mCount: Int = -1

    @SerializedName("Message")
    var mMessage: String = ""

    @SerializedName("SearchCriteria")
    var mSearchCriteria: String = ""

    @SerializedName("Results")
    var mResults: List<CarEntity> = listOf()
}