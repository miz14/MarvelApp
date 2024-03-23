package com.example.marvel.network

import com.example.marvel.models.Hero
import com.example.marvel.models.HeroesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.math.BigInteger
import java.security.MessageDigest

interface MarvelApiInterface {
    @GET("characters")
    suspend fun getHeroes(
        @Query("limit") limit: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String
    ) : HeroesResponse

    @GET("characters/{id}")
    suspend fun getHero(
        @Path("id") id: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String
    ) : HeroesResponse
}

object MarvelApiService {
    private const val BASE_URL = "http://gateway.marvel.com/v1/public/"

    private const val API_KEY = "630c1dbbe7aaab305f8f9ff432d5cf02"
    private const val PRIVATE_KEY = "567f2cc5f2c91937a93c06a177c4b0c31e598f50"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: MarvelApiInterface by lazy {
        retrofit.create(MarvelApiInterface::class.java)
    }
    private fun generateTs() : String {
        return System.currentTimeMillis().toString()
    }

    private fun generateHash(ts: String) : String {
        val input = "${ts}$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    suspend fun getHeroes(limit: Int): List<Hero> {
        val ts = generateTs()
        val hash = generateHash(ts)
        val response = retrofitService.getHeroes(limit, API_KEY, ts, hash)
        return response.data.heroesList
    }
    suspend fun getHero(id: Int): Hero {
        val ts = generateTs()
        val hash = generateHash(ts)
        val response = retrofitService.getHero(id, API_KEY, ts, hash)
        return response.data.heroesList[0]
    }
}

