package nl.paulkros.safespace.api

import nl.paulkros.safespace.classes.SliderValues
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
//Interface for handling the POST functionality of the API Controller and returning the Response.
interface POSTPreferences {
    @POST("api/save-sliders")
    fun postPreferences(@Body sliderValues: SliderValues): Call<ResponseBody>
}
