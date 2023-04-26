package com.kurly.android.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.kurly.android.databinding.ActivityMainBinding
import com.kurly.android.presentation.adapter.SectionWithProductAdapter
import com.kurly.android.presentation.prefs.ProductSharedPreference
import com.kurly.android.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val mContext = this

    @Inject
    lateinit var prefs: ProductSharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = SectionWithProductAdapter(prefs)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(mContext)
            setItemViewCacheSize(5)
            this.adapter = adapter
        }

        adapter.addLoadStateListener { loadState ->
            if (loadState.source.refresh is LoadState.Loading) {
                if (!binding.swipeRefreshLayout.isRefreshing) {
                    binding.progressBar.visibility = View.VISIBLE
                }
            } else if (loadState.source.refresh is LoadState.NotLoading) {
                binding.progressBar.visibility = View.GONE
                binding.swipeRefreshLayout.isRefreshing = false
            }
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            lifecycleScope.launch {
                adapter.refresh()
            }
        }

        lifecycleScope.launch {
            viewModel.getSectionWithProducts().collect {
                Log.d("woo", "submitData")
                adapter.submitData(it)
            }
        }
    }
}