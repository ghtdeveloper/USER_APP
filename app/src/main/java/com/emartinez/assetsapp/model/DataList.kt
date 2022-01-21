package com.emartinez.assetsapp.model

import com.google.gson.annotations.SerializedName


/**
 ****Creado por: Edison Martinez,
 ****Fecha:20,Thursday,2022,
 ****Hora: 8:34 PM.
 **/
class DataList {

    //Object Json
    @SerializedName("data")
    lateinit var arrayResultUserInfo : List<ArrayResultUser>

    fun getArrayResultStats() : List<ArrayResultUser>
    { return arrayResultUserInfo }

}