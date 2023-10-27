package nl.paulkros.safespace.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import nl.paulkros.safespace.R
import nl.paulkros.safespace.api.APIController
import nl.paulkros.safespace.classes.MunicipalityItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationFragment : Fragment() {
    private var municipalities: List<MunicipalityItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_location, container, false)
        val api = APIController()
        val call = api.getMunicipalities()

        val gemeenteList = mutableListOf("Gemeente's ophalen...")
        val backButton = view.findViewById<ImageView>(R.id.backButton)
        val locationButton = view.findViewById<Button>(R.id.locationButton)
        val spinner = view.findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, gemeenteList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.setSelection(0)

        backButton.setOnClickListener{
            val fragment = PreferencesFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment)
            transaction.commit()
        }

        call.enqueue(object : Callback<List<MunicipalityItem>> {
            override fun onResponse(call: Call<List<MunicipalityItem>>, response: Response<List<MunicipalityItem>>) {
                if (response.isSuccessful) {
                    municipalities = response.body()
                    if (municipalities != null) {
                        val gemeenteList = municipalities!!.map { it.gemeente }
                        adapter.clear()
                        adapter.addAll(gemeenteList)
                        adapter.notifyDataSetChanged()
                        spinner.setSelection(0)
                        Log.d("LocationFragment", gemeenteList.toString())
                        // TODO CHATGPT
                        //spinner.onItemSelectedListener --FIX ITEMSSELECTED LISTENER

                        //--> WHEN ITEM SELECTED : Get Selected Municipality --> Soort through the municipalities and find the municipalityItem with the corresponding .gemeente --> start fragment transaction towards ScoreFragment() anbd pass along the corresponding municipalityitem as parameter or bundle :)
                    } else {
                    }
                }
            }

            override fun onFailure(call: Call<List<MunicipalityItem>>, t: Throwable) {
                Log.d("LocationFragment", t.toString())
            }
        })


        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LocationFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}