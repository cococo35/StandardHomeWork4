package com.android.helldivers2.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.helldivers2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainadapter: MainAdapter
    private val mainViewModel by viewModels<MainViewModel> { MainViewModelFactory() }
    private var countId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerview()
        observeData()

        binding.btnMainData.setOnClickListener {
            loadData()
        }
    }

    private fun initRecyclerview() {
        binding.mainRecyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
        mainadapter = MainAdapter()
        binding.mainRecyclerview.adapter = mainadapter
    }

    private fun observeData() {
        mainViewModel.getStratagemLiveData.observe(this@MainActivity) {stratagemList ->
            Log.d("MainActivity", "Data: $stratagemList")
            mainadapter.updateData(stratagemList)
        }
    }

    private fun loadData() {
        Log.d("MainActivity", "Loading: $countId")
        mainViewModel.getStratagemList(countId)
        Toast.makeText(this, "$countId 번째 스트라타젬", Toast.LENGTH_SHORT).show()
        countId++
    }
}