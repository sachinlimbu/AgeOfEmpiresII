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
import com.org.ageofempires2.adapter.TechnologiesAdapter
import com.org.ageofempires2.di.component.DaggerCivilizationComponent
import com.org.ageofempires2.di.component.DaggerTechnologiesComponent
import com.org.ageofempires2.di.module.TechnologiesViewModule
import com.org.ageofempires2.viewModel.technologies.TechnologiesViewModel
import kotlinx.android.synthetic.main.fragment_structures.*
import kotlinx.android.synthetic.main.fragment_technologies.*
import javax.inject.Inject

class TechnologiesFragment : Fragment() {

    @Inject
    lateinit var technologiesViewModule: TechnologiesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerTechnologiesComponent.builder()
            .appComponent((activity?.applicationContext as MyApp).component())
            .technologiesViewModule(TechnologiesViewModule(this))
            .build()
            .inject(this)


        technologiesViewModule.getTechnologies(isConnected())

        technologies_list_recyclerview.layoutManager = LinearLayoutManager(activity)

        technologiesViewModule.updateAo2Base().observe(viewLifecycleOwner, Observer {
                mainOutput ->
            technologies_list_recyclerview.adapter = TechnologiesAdapter(mainOutput)
        })

        technologiesViewModule.getError().observe(viewLifecycleOwner, Observer {
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
        return inflater.inflate(R.layout.fragment_technologies, container, false)
    }
}
