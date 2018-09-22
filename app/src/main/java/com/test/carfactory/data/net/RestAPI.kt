package com.test.carfactory.data.net

import com.test.carfactory.data.model.response.CarsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RestAPI {

    @GET("/api/vehicles/GetMakesForVehicleType/car?format=json")
    fun getCars(): Single<CarsResponse>

    companion object {
        val BASE_URL = "https://vpic.nhtsa.dot.gov/"
    }
}