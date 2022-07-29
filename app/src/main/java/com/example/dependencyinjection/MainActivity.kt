package com.example.dependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencyinjection.adapter.ImageAdapter
import com.example.dependencyinjection.databinding.ActivityMainBinding
import com.example.dependencyinjection.viewModel.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var imageAdapter: ImageAdapter
    private val viewModel: ImageViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        imageAdapter = ImageAdapter()
        binding.recyclerView.apply {
            adapter = imageAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }

        viewModel.imageResponse.observe(this, { response ->

            if (response != null) {
                imageAdapter.submitList(response)
            }
        })
    }

}