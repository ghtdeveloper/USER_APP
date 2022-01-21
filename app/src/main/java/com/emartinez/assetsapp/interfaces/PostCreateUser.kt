package com.emartinez.assetsapp.interfaces

import com.emartinez.assetsapp.model.CreateUser
import com.emartinez.assetsapp.model.DataModalPostCreate
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

/**
 ****Creado por: Edison Martinez,
 ****Fecha:21,Friday,2022,
 ****Hora: 11:33 AM.
 **/
interface PostCreateUser
{
    @POST("/data/v1/user/create")
    fun createPost(@Header("app-id") header : String, @Body user: CreateUser):
            Call<DataModalPostCreate>
}