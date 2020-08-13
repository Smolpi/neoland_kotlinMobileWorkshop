package com.example.swapi

import kotlinx.serialization.Serializable

@Serializable
data class Planet(var name: String, var diameter: String, var gravity: String, var population: String, var climate: String, var terrain: String, var created: String, var edited: String, var url: String)

