package nl.paulkros.safespace.api

import android.util.Log
import nl.paulkros.safespace.classes.Municipalities
import nl.paulkros.safespace.classes.MunicipalityItem
import nl.paulkros.safespace.classes.SliderValues
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIController {
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://www.bpsafespace.nl:3001/")
        .build()

    fun getMunicipalities(): Call<List<MunicipalityItem>> {
        val gemeenteApi = retrofit.create(GETMunicipalities::class.java)
        val call = gemeenteApi.getData()
        return gemeenteApi.getData()
    }

    fun sendPreferences(sliderValues: SliderValues) {
        val api = retrofit.create(POSTPreferences::class.java)
        val call = api.postPreferences(sliderValues)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val message = response.body()?.string()
                    if (message != null) {
                        Log.d("API", message)
                    }
                } else {
                    Log.d("API", "No Response")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("API", t.toString())
            }
        })
    }

}