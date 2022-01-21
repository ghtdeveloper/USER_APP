package com.emartinez.assetsapp.viewAdapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emartinez.assetsapp.R


/**
 ****Creado por: Edison Martinez,
 ****Fecha:20,Thursday,2022,
 ****Hora: 8:19 PM.
 **/
class ViewAdapterUser(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    //Views
    val textValueId : TextView = itemView.findViewById(R.id.textValueId)
    val textValueFirstName : TextView = itemView.findViewById(R.id.textvalueFirstName)
    val textValueLastName : TextView = itemView.findViewById(R.id.textValueLastName)

}