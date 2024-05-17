package com.example.famgithubuser

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.famgithubuser.adapter.ListUserAdapter
import com.example.famgithubuser.databinding.ActivityMainBinding
import com.example.famgithubuser.model.StatusProgress
import com.example.famgithubuser.model.response.UserModel
import com.google.android.material.appbar.AppBarLayout


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the toolbar
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        // Ensure SearchView is expanded by default
        val searchView = findViewById<SearchView>(R.id.search_view)
        if (searchView != null) {
            searchView.setIconifiedByDefault(false)
        }
    }

    private fun showSearchingResult(result: StatusProgress<ArrayList<UserModel>>) {
        when (result) {
            is StatusProgress.Loading -> showLoading(true)
            is StatusProgress.Error -> {
                errorAction()
                showLoading(false)
            }
            is StatusProgress.Success -> {
                // binding.tvResultCount.text = getString(R.string.showing_results, result.data.size)
                val listUserAdapter = ListUserAdapter(result.data)

                binding.home.recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = listUserAdapter
                    setHasFixedSize(true)
                }

//                listUserAdapter.setOnItemClickCallback(object :
//                    ListUserAdapter.OnItemClickCallback {
//                    override fun onItemClicked(user: UserModel) {
//                        goToDetailUser(user)
//                    }
//
//                })
                showLoading(false)
//                EspressoIdlingResource.decrement()
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
            binding.home.recyclerView.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.home.recyclerView.visibility = View.VISIBLE
        }
    }

    private fun errorAction() {
        Toast.makeText(this@MainActivity, "An Error is Occurred", Toast.LENGTH_SHORT).show()
    }
}