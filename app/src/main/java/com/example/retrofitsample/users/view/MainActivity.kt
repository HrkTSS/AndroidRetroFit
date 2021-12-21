package com.example.retrofitsample.users.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitsample.R
import com.example.retrofitsample.networking.RetrofitBuilder
import com.example.retrofitsample.networking.ViewModelFactory
import com.example.retrofitsample.users.Common
import com.example.retrofitsample.users.viewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModel()
        observeData()
        launchUI()
    }

    private fun launchUI() {
        btn_fetch.setOnClickListener {
            pg_bar.isVisible = true
            userViewModel.fetchUsers()
        }
    }

    private fun setUpViewModel() {
        userViewModel = ViewModelProvider(
            this,
            ViewModelFactory(RetrofitBuilder.apiService)
        )[UserViewModel::class.java]
    }

    private fun observeData() {
        userViewModel.getUserLiveData().observe(this, { response ->
            loadUI(response)
        })
    }

    private fun loadUI(response: Common) {
        pg_bar.isVisible = false
        rv.adapter = UserAdapter(response)
    }
}