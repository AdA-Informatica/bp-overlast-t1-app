package nl.paulkros.safespace.classes

import java.io.Serializable

data class MunicipalityItem(
    val _id: String,
    val gemeente: String,
    val key: String,
    val score: List<Score>,
    val voorspellingScore: Int
) : Serializable