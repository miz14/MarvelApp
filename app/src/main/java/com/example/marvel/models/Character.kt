package com.example.marvel.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Hero(
    val id: Int,
    val name: String,
    @SerializedName("description")
    val desc: String,
    @SerializedName("thumbnail")
    val image: HeroImage
)

@Serializable
data class HeroImage(
    val path: String,
    @SerializedName("extension")
    val format: String
)

@Serializable
data class HeroesResponse(
    @SerializedName("data")
    val data: HeroesData
)

@Serializable
data class HeroesData(
    @SerializedName("results")
    val heroesList: List<Hero>
)
