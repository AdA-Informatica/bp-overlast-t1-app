package nl.paulkros.safespace.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
    //Create an Empty variable that can house a List of <MunicipalityItem>'s
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


        //We make sure the spinner is found, has the correct ArrayAdapter for the data that is being fetched from the API
        //We fill the List with a placeholder and set the spinner accordingly
        val gemeenteList = mutableListOf("Gemeente's ophalen...")
        val spinner = view.findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, gemeenteList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.setSelection(0)

        //We find the locationButton and asssign it to a variable to be used later on
        val locationButton = view.findViewById<Button>(R.id.locationButton)

        //We find the backButton and add an OnClick to start a transaction to go towards the PreferncesFragment
        val backButton = view.findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener{
            val fragment = PreferencesFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment)
            transaction.commit()
        }

        //We Create an instance of APIController() -> We then get the Municipalities in a call enqueue.
        //If we get a response we store the response body in the earlier declared municipalities variable.
        //We fill the gemeenteList with all the gemeente values in the municipalities variable
        //When a gemeente gets selected from the dropdown we get the corresponding municipalityItem from the municipalities variable and store it in a new one
        //We then wait to see if the user selects another item or if it will submit through the button
        //When it submits we start a transaction to go to the Scorescreen and put the selectedMunicipalityItem as a Serializable in the bundle.
        val api = APIController()
        val call = api.getMunicipalities()
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

                        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                if (municipalities != null) {
                                    val selectedMunicipalityItem = municipalities!![position]

                                    locationButton.setOnClickListener {
                                        val fragment = ScoreFragment()
                                        val bundle = Bundle()
                                        bundle.putSerializable("municipality", selectedMunicipalityItem)
                                        fragment.arguments = bundle
                                        val transaction = parentFragmentManager.beginTransaction()
                                        transaction.replace(R.id.fragmentContainerView, fragment)
                                        transaction.commit()
                                    }
                                }
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {

                            }
                        }
                    } else {
                    }
                }
            }
            //If there's no response or a failure we change the placeholder to an error message
            override fun onFailure(call: Call<List<MunicipalityItem>>, t: Throwable) {
                val gemeenteList = mutableListOf("Er is een fout opgetreden: $t")
                adapter.clear()
                adapter.addAll(gemeenteList)
                adapter.notifyDataSetChanged()
                spinner.setSelection(0)
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