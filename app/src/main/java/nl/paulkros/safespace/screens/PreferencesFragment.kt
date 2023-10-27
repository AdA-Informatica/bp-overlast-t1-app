package nl.paulkros.safespace.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import nl.paulkros.safespace.R
import nl.paulkros.safespace.api.APIController
import nl.paulkros.safespace.classes.SliderValues

class PreferencesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_preferences, container, false)

        //We find all the seekerbars and assign them to a variable
        val verwardSeekbar = view.findViewById<SeekBar>(R.id.verwardSeekbar)
        val hangjeugdSeekbar = view.findViewById<SeekBar>(R.id.hangjeugdSeekbar)
        val drugsSeekbar = view.findViewById<SeekBar>(R.id.drugsSeekbar)
        val zwerverSeekbar = view.findViewById<SeekBar>(R.id.zwerverSeekbar)
        val geluidSeekBar = view.findViewById<SeekBar>(R.id.geluidSeekbar)
        val inbraakSeekBar = view.findViewById<SeekBar>(R.id.inbraakSeekbar)
        val zakkenrollerSeekBar = view.findViewById<SeekBar>(R.id.zakkenrollerSeekbar)
        val geweldSeekBar = view.findViewById<SeekBar>(R.id.geweldSeekbar)
        val moordSeekBar = view.findViewById<SeekBar>(R.id.moordSeekbar)

        //We then assign the save button to a variable and when it is clicked we map the seekbar.progress values in a variable
        val saveButton = view.findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener{
            val seekbarValues = mapOf(
                "verwardPersoon" to verwardSeekbar.progress,
                "hangJongeren" to hangjeugdSeekbar.progress,
                "drugsEnAlcohol" to drugsSeekbar.progress,
                "zwervers" to zwerverSeekbar.progress,
                "geluidshinder" to geluidSeekBar.progress,
                "inbraak" to inbraakSeekBar.progress,
                "diefstal" to zakkenrollerSeekBar.progress,
                "geweld" to geweldSeekBar.progress,
                "moord" to moordSeekBar.progress
            )

            //We then create an instance of SliderValues and pass the seekbarvalues as a parameter.
            //In a coroutine we start a POST call and send the slidervalues to the API which in turn stores it in the MongoDB
            //We start a transaction to head towards the LocationFragment()
            val sendValues = SliderValues(seekbarValues)
            val api = APIController()
            lifecycleScope.launch {
                api.sendPreferences(sendValues)
            }
            val locationFragment = LocationFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, locationFragment)
            transaction.commit()
        }

        //We find the backbutton and attach an OnClicklistener to it.
        //When pressed we navigate towards the HomeFragment()
        val backButton = view.findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            val homeFragment = HomeFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, homeFragment)
            transaction.commit()
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PreferencesFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}