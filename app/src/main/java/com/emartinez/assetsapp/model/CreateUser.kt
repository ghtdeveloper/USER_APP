package com.emartinez.assetsapp.model

import com.google.gson.annotations.SerializedName


/**
 ****Creado por: Edison Martinez,
 ****Fecha:21,Friday,2022,
 ****Hora: 11:31 AM.
 **/
data class CreateUser(
    @SerializedName("lastName")
    val lastName : String,
    @SerializedName("firstName")
    val firstName : String,
    @SerializedName("email")
    val email : String
)
