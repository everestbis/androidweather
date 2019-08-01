package infodevelopers.com.np.weatherapp.model.repository

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import infodevelopers.com.np.weatherapp.common.api_key;
import infodevelopers.com.np.weatherapp.model.api.ApiInterface


object ApiFactory{

val BASE_URL="http://dataservice.accuweather.com/"
    fun Retrofit(): Retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiInterface= Retrofit().create(ApiInterface::class.java)



}