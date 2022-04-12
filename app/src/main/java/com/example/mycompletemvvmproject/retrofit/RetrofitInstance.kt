package com.example.mycompletemvvmproject.retrofit

import com.example.mycompletemvvmproject.util.ApplicationConstants
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {

    companion object {
        private var mRetrofitInstance: RetrofitInstance? = null
        private var mRetrofit: Retrofit? = null

        val retrofitInstance: Retrofit?
            get() {
                val gson = GsonBuilder()
                    .setLenient()
                    .create()

                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
      val okHttpClient= OkHttpClient().newBuilder()
          .connectTimeout(6,TimeUnit.MINUTES)
          .readTimeout(6,TimeUnit.MINUTES)
          .writeTimeout(6,TimeUnit.MINUTES)
          .addInterceptor(interceptor)
          .build()
                if (mRetrofit==null){
             mRetrofit=Retrofit.Builder()
                 .baseUrl(ApplicationConstants.BaseUrl)
                 .client(okHttpClient)
                 .addConverterFactory(GsonConverterFactory.create(gson))
                 .build()
                 }
                return mRetrofit
            }

    }


}