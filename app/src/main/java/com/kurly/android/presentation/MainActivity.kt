package com.kurly.android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.kurly.android.R
import com.kurly.android.databinding.ActivityMainBinding
import com.kurly.android.presentation.adapter.SectionWithProductAdapter
import com.kurly.android.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.uiStateLiveData.observe(this) { uiState ->
            when (uiState) {
                is UIState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is UIState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    val adapter = SectionWithProductAdapter()
                    binding.recyclerView.adapter = adapter

                    lifecycleScope.launch {
                        uiState.data.collectLatest { pagingData ->
                            adapter.submitData(pagingData)
                        }
                    }
                }
                is UIState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Snackbar.make(
                        binding.progressBar,
                        uiState.throwable.message ?: "서버에 문제가 발생했습니다. 관리자에게 문의하세요.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        viewModel.getSectionWithProducts()
    }
}