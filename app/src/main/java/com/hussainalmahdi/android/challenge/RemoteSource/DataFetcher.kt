package com.hussainalmahdi.android.challenge.RemoteSource

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataFetcher {

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://hussainalmahdi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val requests: Requests = retrofit.create(Requests::class.java)

    fun fetchData(): LiveData<List<Senator>> {
        val responseLiveData: MutableLiveData<List<Senator>> = MutableLiveData()

        requests.fetchData().enqueue(
            object :Callback<Objects>{
                override fun onResponse(call: Call<Objects>, response: Response<Objects>) {
                    responseLiveData.value = response.body()?.objects

                    Log.d("response", response.body().toString())
                }
                override fun onFailure(call: Call<Objects>, t: Throwable) {
                    Log.d("response", t.toString())
                }
            }
        )
        return responseLiveData
    }




}