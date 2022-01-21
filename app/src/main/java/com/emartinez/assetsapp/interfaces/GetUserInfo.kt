package com.emartinez.assetsapp.interfaces

import com.emartinez.assetsapp.model.DataList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.HeaderMap
import retrofit2.http.Query


/**
 ****Creado por: Edison Martinez,
 ****Fecha:20,Thursday,2022,
 ****Hora: 8:29 PM.
 **/
interface GetUserInfo
{

    @GET("/data/v1/user?")
    fun getUserInfo(@Header("app-id") header : String,@Query("created") limit: String): Call<DataList>

}