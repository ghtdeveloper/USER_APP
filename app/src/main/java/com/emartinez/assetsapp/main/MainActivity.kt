package com.emartinez.assetsapp.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.emartinez.assetsapp.R
import com.emartinez.assetsapp.adapter.AdapterUser
import com.emartinez.assetsapp.api.builders.ServiceBuilderUsers
import com.emartinez.assetsapp.databinding.ActivityMainBinding
import com.emartinez.assetsapp.interfaces.GetUserInfo
import com.emartinez.assetsapp.interfaces.PostCreateUser
import com.emartinez.assetsapp.model.ArrayResultUser
import com.emartinez.assetsapp.model.CreateUser
import com.emartinez.assetsapp.model.DataList
import com.emartinez.assetsapp.model.DataModalPostCreate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity()
{
    //Binding
    private lateinit var binding: ActivityMainBinding
    //Objects
    private lateinit var dataList : ArrayList<ArrayResultUser>
    private lateinit var adapterUser: AdapterUser
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var alertDialog: AlertDialog
    private lateinit var createUser: CreateUser


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerViewData.layoutManager = linearLayoutManager
        binding.floatingActionButton.setOnClickListener {
            showDialogAddUser()
        }
        setContentView(view)
    }

    @Override
    override fun onStart() {
        super.onStart()
        loadRecyclerview()
    }

    private fun loadRecyclerview()
    {
        dataList = ArrayList()
        val retrofit = ServiceBuilderUsers.buildService(GetUserInfo :: class.java)
        val header = "61e9f2d5e7eefe3067006303"
        retrofit.getUserInfo(header,"1").enqueue(object : Callback<DataList>
        {
            override fun onResponse(call: Call<DataList>, response: Response<DataList>)
            {
                if(response.isSuccessful)
                {

                    if(response.body()?.getArrayResultStats().isNullOrEmpty())
                    {
                        Log.d("DATA WS","NO DATA TO SHOW")
                        binding.imgNoData.visibility = View.VISIBLE
                        binding.textViewNoData.visibility = View.VISIBLE
                    }
                    else
                    {
                        binding.imgNoData.visibility = View.INVISIBLE
                        binding.textViewNoData.visibility = View.INVISIBLE
                        Log.d("DATA",call.request().toString())
                        dataList.addAll(response.body()?.getArrayResultStats()!!)
                        adapterUser = AdapterUser(dataList)
                        binding.recyclerViewData.adapter = adapterUser
                    }
                }
                else
                {
                    Log.d("DATA WS","ERROR EN EL WEBSERVICE")
                }

            }
            override fun onFailure(call: Call<DataList>, t: Throwable) {
                Log.e("ERROR WS",t.toString())
            }

        })
    }

    private fun showDialogAddUser()
    {
        //Dialog
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogview = inflater.inflate(R.layout.diaglog_add_user,null)
        dialogBuilder.setView(dialogview)
        dialogBuilder.setCancelable(false)
        //Cast a las vistas
        val textFirtName = dialogview.findViewById(R.id.eTextFirstName) as EditText
        val textLastName = dialogview.findViewById(R.id.eTextLastName) as EditText
        val textEmail = dialogview.findViewById(R.id.eTextEmail) as EditText
        val btnSave = dialogview.findViewById(R.id.btnSave) as Button
        val btnClose = dialogview.findViewById(R.id.imgBtnClose) as ImageButton

        //Events
        btnClose.setOnClickListener {
            alertDialog.dismiss()
        }
        btnSave.setOnClickListener {
            //Toast.makeText(baseContext,"Save data...",Toast.LENGTH_LONG).show()
            if(textFirtName.text.isNullOrEmpty() || textLastName.text.isNullOrEmpty() ||
                textEmail.text.isNullOrEmpty())
            {
                Toast.makeText(baseContext,"Complete all fields",
                    Toast.LENGTH_LONG).show()

            }else
            {
                val retrofit = ServiceBuilderUsers.buildService(PostCreateUser::class.java)
                val headers ="61e9f2d5e7eefe3067006303"
                createUser = CreateUser(textLastName.text.toString(),
                    textFirtName.text.toString(),textEmail.text.toString())
                retrofit.createPost(headers,createUser).enqueue(object :Callback<DataModalPostCreate>
                {
                    override fun onResponse(call: Call<DataModalPostCreate>, response:
                    Response<DataModalPostCreate>)
                    {
                        if(response.isSuccessful)
                        {
                            Log.d("DATA WS RESPONSE","User Created")
                            Log.d("DATA  WS POST",response.body().toString())
                            alertDialog.dismiss()
                            loadRecyclerview()
                        }
                        else
                        {
                            Log.d("RESPONSE ERROR","Error with the response " +
                                    "or request")
                        }

                    }
                    override fun onFailure(call: Call<DataModalPostCreate>, t: Throwable)
                    {
                        Log.e("ERROR WS",t.toString())
                    }
                })
            }
        }
        alertDialog = dialogBuilder.create()
        alertDialog.show()
    }


}//End of the class MainActivity