package com.emartinez.assetsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 ****Creado por: Edison Martinez,
 ****Fecha:20,Thursday,2022,
 ****Hora: 8:38 PM.
 **/
class ArrayResultUser
{
    @SerializedName("id")
    @Expose
    lateinit var id: String

    @SerializedName("firstName")
    @Expose
    lateinit var  firstName: String

    @SerializedName("lastName")
    @Expose
    lateinit var  lastName: String

}