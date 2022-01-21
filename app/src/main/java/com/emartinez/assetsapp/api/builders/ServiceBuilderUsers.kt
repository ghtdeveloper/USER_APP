package com.emartinez.assetsapp.api.builders

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 ****Creado por: Edison Martinez,
 ****Fecha:20,Thursday,2022,
 ****Hora: 8:26 PM.
 **/
object ServiceBuilderUsers
{
    private val client = OkHttpClient.Builder().build()
    //Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    fun<T> buildService(service:Class<T>) : T{
        return retrofit.create(service)
    }

}