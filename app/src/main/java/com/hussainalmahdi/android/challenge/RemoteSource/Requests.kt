package com.hussainalmahdi.android.challenge.RemoteSource

import retrofit2.Call
import retrofit2.http.GET

interface Requests {
    @GET("/jsonData.html")
    fun fetchData(): Call<Objects>
}