package com.example.marvel.ui

data class Hero(
    val id: Int,
    val name: String,
    val desc: String,
    val imageUrl: String,
)

val Heroes = listOf(
    Hero(
        1,
        "Deadpool",
        "Please don’t make the super suit green...or animated!",
        "https://i.pinimg.com/736x/6f/3a/a5/6f3aa5c8784e60563d787bceab7c8253.jpg"
    ),
    Hero(
        2,
        "Iron Man",
        "I AM IRON MAN",
        "https://cdn1.ozone.ru/s3/multimedia-x/6296330757.jpg"
    ),
    Hero(
        3,
        "Spider Man",
        "In iron suit",
        "https://comicvine.gamespot.com/a/uploads/original/11148/111483657/8268003-spider-man_%28no_way_home%29.jpg"
    )
)