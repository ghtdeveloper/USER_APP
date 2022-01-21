package com.emartinez.assetsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emartinez.assetsapp.R
import com.emartinez.assetsapp.model.ArrayResultUser
import com.emartinez.assetsapp.viewAdapter.ViewAdapterUser


/**
 ****Creado por: Edison Martinez,
 ****Fecha:20,Thursday,2022,
 ****Hora: 8:21 PM.
 **/
class AdapterUser(private val dataset : ArrayList<ArrayResultUser>) :
    RecyclerView.Adapter<ViewAdapterUser>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAdapterUser {
        val  view = LayoutInflater.from(parent.context).inflate(
            R.layout.lis_item_data_user,parent,false)
        return ViewAdapterUser(view)
    }

    override fun onBindViewHolder(holder: ViewAdapterUser, position: Int) {
        val datamodel = dataset.get(position)
        //Count
        holder.textValueFirstName.text = datamodel.firstName
        holder.textValueLastName.text = datamodel.lastName
        holder.textValueId.text = datamodel.id
    }

    override fun getItemCount() = dataset.size


}//Fin de la class AdapterUser