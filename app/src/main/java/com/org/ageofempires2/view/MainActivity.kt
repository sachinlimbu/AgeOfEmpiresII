package com.org.ageofempires2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.ageofempires2.MyApp
import com.org.ageofempires2.R
import com.org.ageofempires2.adapter.CivilizationAdapter
import com.org.ageofempires2.di.component.DaggerSearchComponent
import com.org.ageofempires2.di.module.Aoe2ViewModule
import com.org.ageofempires2.viewModel.CivilizationsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var civilizationsViewModel: CivilizationsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSearchComponent.builder()
            .appComponent((application as MyApp).component())
            .aoe2ViewModule(Aoe2ViewModule(this))
            .build()
            .inject(this)

        civilizationsViewModel.getCivlization()

        main_RecyclingView.layoutManager = LinearLayoutManager(parent)

        civilizationsViewModel.updateAo2Base().observe(this, Observer {
            mainOutput ->
            main_RecyclingView.adapter = CivilizationAdapter(mainOutput)
        })
    }
}
