package com.example.famgithubuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.ui.AppBarConfiguration
import com.example.famgithubuser.databinding.ActivityMainBinding
import com.google.android.material.appbar.AppBarLayout


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

// Set up the toolbar
        // Set up the toolbar
//        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        // Ensure SearchView is expanded by default
        val searchView = findViewById<SearchView>(R.id.search_view)
        if (searchView != null) {
            searchView.setIconifiedByDefault(false)
        }

//        setSupportActionBar(binding.appBarMain.toolbar)


    }
}