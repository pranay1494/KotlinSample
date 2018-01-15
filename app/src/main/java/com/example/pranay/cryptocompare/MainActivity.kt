package com.example.pranay.cryptocompare

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    lateinit var api:ApiCalls

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        api = RetroFitClient.getClient()!!.create(ApiCalls::class.java)
        api.getUserDetails("pranay1494").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe({
                    Toast.makeText(this,"data recieved sucessfully",Toast.LENGTH_SHORT).show();
                }, {
                    Toast.makeText(this,"error",Toast.LENGTH_SHORT).show();
                })

    }
}
