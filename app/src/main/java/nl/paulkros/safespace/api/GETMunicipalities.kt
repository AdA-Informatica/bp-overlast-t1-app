package nl.paulkros.safespace.api

import nl.paulkros.safespace.classes.MunicipalityItem
import retrofit2.Call
import retrofit2.http.GET

//Interface for handling the GET functionality of the API Controller and returning the Response.
interface GETMunicipalities {
    @GET("api")
    fun getData(): Call<List<MunicipalityItem>>
}