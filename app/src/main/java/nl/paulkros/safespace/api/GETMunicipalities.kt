package nl.paulkros.safespace.api

import nl.paulkros.safespace.classes.MunicipalityItem
import retrofit2.Call
import retrofit2.http.GET

interface GETMunicipalities {
    @GET("api")
    fun getData(): Call<List<MunicipalityItem>>
}