package nl.paulkros.safespace.classes

import java.io.Serializable
//Data Class for the retrieved Municipalities from the API contains all the value's of a single entry in the 'Gemeentes' database.
data class MunicipalityItem(
    val _id: String,
    val gemeente: String,
    val key: String,
    val score: List<Score>,
    val voorspellingScore: Int
) : Serializable