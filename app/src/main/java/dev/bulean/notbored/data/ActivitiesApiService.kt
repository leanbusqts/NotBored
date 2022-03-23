package dev.bulean.notbored.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

private const val BASE_URL = "https://www.boredapi.com/api/"

val retrofit: Retrofit = Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(BASE_URL)
                            .build()

interface ActivitiesApiService {
    @GET
    suspend fun getActivities(@Url url: String) : Response<ActivityItem>
}
