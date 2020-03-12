package com.org.ageofempires2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.ageofempires2.MyApp
import com.org.ageofempires2.R
import com.org.ageofempires2.adapter.CivilizationAdapter
import com.org.ageofempires2.di.component.DaggerSearchComponent
import com.org.ageofempires2.di.module.Aoe2ViewModule
import com.org.ageofempires2.viewModel.civilization.CivilizationsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Navigation.findNavController(this,R.id.nav_host_fragment_container)
    }
}
