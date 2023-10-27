package nl.paulkros.safespace.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import nl.paulkros.safespace.R

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        //We find the Info Button and add a listener to change towards About Fragment on Click
        val infoButton = view.findViewById<ImageView>(R.id.infoButton)
        infoButton.setOnClickListener{
            val fragment = AboutFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment)
            transaction.commit()
        }

        //We find the Start Button and add a listener to change towards Preferences Fragment on Click
        val startButton = view.findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener{
            val preferencesFragment = PreferencesFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, preferencesFragment)
            transaction.commit()
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}