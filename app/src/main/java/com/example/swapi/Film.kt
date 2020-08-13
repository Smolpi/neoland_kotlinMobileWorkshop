package com.example.swapi

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Film(
    var title: String,
    @SerializedName("episode_id")var episodeId : Int,
    @SerializedName("opening_crawl")var openingCrawl: String,
    var director: String,
    var producer: String,
    var url: String,
    var created: String,
    var edited: String,
    @SerializedName("species") val speciesUrls: List<String>?,
    @SerializedName("starships")  var starshipsUrls: List<String>?,
    @SerializedName("vehicles") var vehiclesUrls: List<String>?,
    @SerializedName("planets")var planetsUrls: List<String>?,
    @SerializedName("characters")var charactersUrls: List<String>?) {

    fun getUrlImage() : String {
        return when (episodeId) {
            1 -> "https://upload.wikimedia.org/wikipedia/en/4/40/Star_Wars_Phantom_Menace_poster.jpg"
            2 -> "https://upload.wikimedia.org/wikipedia/en/3/32/Star_Wars_-_Episode_II_Attack_of_the_Clones_%28movie_poster%29.jpg"
            3 -> "https://upload.wikimedia.org/wikipedia/en/9/93/Star_Wars_Episode_III_Revenge_of_the_Sith_poster.jpg"
            4 -> "https://upload.wikimedia.org/wikipedia/en/8/87/StarWarsMoviePoster1977.jpg"
            5 -> "https://upload.wikimedia.org/wikipedia/en/3/3c/SW_-_Empire_Strikes_Back.jpg"
            6 -> "https://upload.wikimedia.org/wikipedia/en/b/b2/ReturnOfTheJediPoster1983.jpg"
            else -> "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/George_Lucas.jpg/330px-George_Lucas.jpg"
        }
    }
}

