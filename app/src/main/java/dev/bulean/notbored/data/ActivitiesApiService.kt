package dev.bulean.notbored.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.boredapi.com/api/"

private val retrofit = Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(BASE_URL)
                            .build()


interface ActivitiesApiService {
    @GET("activity/")
    suspend fun getActivities() : Response<ActivityItem>
}

object ActivitiesApi {
    val retrofitService : ActivitiesApiService by lazy {
        retrofit.create(ActivitiesApiService::class.java)
    }
}

