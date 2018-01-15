package com.example.pranay.cryptocompare

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by kuliza-336 on 16/01/18.
 */
interface ApiCalls {
    @GET("{user}")
    fun getUserDetails(@Path("user") user: String): Observable<GitPojo>
}