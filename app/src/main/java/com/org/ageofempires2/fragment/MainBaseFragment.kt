package com.org.ageofempires2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.org.ageofempires2.R
import kotlinx.android.synthetic.main.fragment_main_base.*

/**
 * A simple [Fragment] subclass.
 */
class MainBaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_civilizations.setOnClickListener {
            view?.let{
                it.findNavController().navigate(R.id.action_mainBaseFragment_to_civilizationsFragment)
            }
        }

        btn_structures.setOnClickListener {
            view?.let {
                it.findNavController().navigate(R.id.action_mainBaseFragment_to_structuresFragment)
            }
        }
        btn_technologies.setOnClickListener {
            view?.let{
                it.findNavController().navigate(R.id.action_mainBaseFragment_to_technologiesFragment)
            }
        }
        btn_units.setOnClickListener {
            view?.let {
                it.findNavController().navigate(R.id.action_mainBaseFragment_to_unitsFragment)
            }
        }
    }

}
