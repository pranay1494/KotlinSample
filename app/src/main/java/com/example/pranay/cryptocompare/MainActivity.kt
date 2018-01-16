package com.example.pranay.cryptocompare

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    lateinit var api:ApiCalls
    lateinit var adapter:Adapter
    lateinit var rvName:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvName = findViewById(R.id.rvGitName)

        api = RetroFitClient.getClient()!!.create(ApiCalls::class.java)
        api.getUserDetails("pranay1494").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe({
                    result ->
                    Toast.makeText(this,"data recieved sucessfully",Toast.LENGTH_SHORT).show();
                    adapter = Adapter(this,result.login)
                    rvName.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))
                    rvName.adapter = adapter
                }, {
                    Toast.makeText(this,"error",Toast.LENGTH_SHORT).show();
                })

    }
}
