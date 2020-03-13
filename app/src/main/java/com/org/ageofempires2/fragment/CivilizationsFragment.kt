package com.org.ageofempires2.fragment

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.ageofempires2.MyApp
import com.org.ageofempires2.R
import com.org.ageofempires2.adapter.CivilizationAdapter
import com.org.ageofempires2.di.component.DaggerCivilizationComponent
import com.org.ageofempires2.di.module.CivilizationViewModule
import com.org.ageofempires2.viewModel.civilization.CivilizationsViewModel
import kotlinx.android.synthetic.main.fragment_civilizations.*
import javax.inject.Inject

@Suppress("DEPRECATION")
class CivilizationsFragment : Fragment() {

    @Inject
    lateinit var civilizationsViewModel: CivilizationsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerCivilizationComponent.builder()
            .appComponent((activity?.applicationContext as MyApp).component())
            .civilizationViewModule(CivilizationViewModule(this))
            .build()
            .inject(this)

        civilizationsViewModel.getCivlization(isConnected())

        civilization_list_recyclerview.layoutManager = LinearLayoutManager(activity)

        civilizationsViewModel.updateAo2Base().observe(viewLifecycleOwner, Observer {
                mainOutput ->
            civilization_list_recyclerview.adapter = CivilizationAdapter(mainOutput)

        })

        civilizationsViewModel.getError().observe(viewLifecycleOwner, Observer {
            civilizations_progressBar.visibility = View.VISIBLE
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
        return inflater.inflate(R.layout.fragment_civilizations, container, false)
    }
}
