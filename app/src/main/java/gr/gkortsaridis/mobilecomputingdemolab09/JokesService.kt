package gr.gkortsaridis.mobilecomputingdemolab09

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface JokesService {
    @GET("jokes/ten")
    suspend fun fetchJokes(): List<Joke>
}

object JokesApi {
    private const val BASE_URL = "https://official-joke-api.appspot.com/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: JokesService by lazy {
        retrofit.create(JokesService::class.java)
    }
}