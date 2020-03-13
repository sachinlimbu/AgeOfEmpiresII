package com.org.ageofempires2.fragment

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.ageofempires2.MyApp

import com.org.ageofempires2.R
import com.org.ageofempires2.adapter.StructuresAdapter
import com.org.ageofempires2.di.component.DaggerCivilizationComponent
import com.org.ageofempires2.di.component.DaggerStructuresComponent
import com.org.ageofempires2.di.module.StructuresViewModule
import com.org.ageofempires2.viewModel.structures.StructuresViewModel
import kotlinx.android.synthetic.main.fragment_structures.*
import javax.inject.Inject

class StructuresFragment : Fragment() {

    @Inject
    lateinit var structuresViewModel: StructuresViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       DaggerStructuresComponent.builder()
           .appComponent((activity?.applicationContext as MyApp).component())
         .structuresViewModule(StructuresViewModule(this))
          .build()
         .inject(this)

        structuresViewModel.getStructures(isConnected())

        structures_list_recyclerview.layoutManager = LinearLayoutManager(activity)

        structuresViewModel.updateAo2Base().observe(viewLifecycleOwner, Observer {
            mainOutput ->
            structures_list_recyclerview.adapter = StructuresAdapter(mainOutput)
        })

        structuresViewModel.getError().observe(viewLifecycleOwner, Observer {
            structures_progressBar.visibility = View.VISIBLE
        })

    }

    private fun isConnected(): Boolean {
        return try {
            val mConnectivityManager =
                activity!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val mNetworkInfo = mConnectivityManager.activeNetworkInfo
            mNetworkInfo != null
        } catch (e: NullPointerException) {
            false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_structures, container, false)
    }

}
