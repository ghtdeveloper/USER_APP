package com.emartinez.assetsapp.model

import com.google.gson.annotations.SerializedName


/**
 ****Creado por: Edison Martinez,
 ****Fecha:21,Friday,2022,
 ****Hora: 11:37 AM.
 **/
class DataModalPostCreate
{
    //Objects JSON
    @SerializedName("firstName")
    lateinit var firstName: String

    @SerializedName("lastName")
    lateinit var lastName : String

    @SerializedName("email")
    lateinit var email: String

}