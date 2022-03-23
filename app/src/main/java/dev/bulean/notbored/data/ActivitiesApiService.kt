package dev.bulean.notbored.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.boredapi.com/api/"

val retrofit: Retrofit = Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(BASE_URL)
                            .build()

interface ActivitiesApiService {

    @GET("activity/")
    suspend fun getActivityRandom() : Response<ActivityItem>

    @GET("activity?")
    suspend fun getActivityByType(@Query("type") type: String
    ) : Response<ActivityItem>

    @GET("activity?")
    suspend fun getActivityByParticipants(@Query("participants") participants: Int
    ) : Response<ActivityItem>

    @GET("activity?")
    suspend fun getActivityByParticipantsAndType(@Query("participants") participants: Int,
                                                 @Query("type") type: String
    ) : Response<ActivityItem>

}

object ActivitiesApi {
    val retrofitService : ActivitiesApiService by lazy {
        retrofit.create(ActivitiesApiService::class.java)
    }
}
