package com.taskailleronjanbober.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.taskailleronjanbober.R
import com.taskailleronjanbober.base.ktx.showSnackBar
import com.taskailleronjanbober.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainAdapter: MainAdapter
    private lateinit var stationSensorsStationIdAdapter: StationSensorsStationIdAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
            .also {
                it.lifecycleOwner = this
                it.viewModel = mainActivityViewModel
            }
        mainAdapter = MainAdapter()
            .apply {
                onClick = {mainActivityViewModel.repositoryClicked(it)}
            }
        binding.getList.recyclerView.adapter = mainAdapter
        stationSensorsStationIdAdapter = StationSensorsStationIdAdapter()
        binding.getItem.recyclerView.adapter = stationSensorsStationIdAdapter

        mainActivityViewModel.fetchFindAllApi()
        mainActivityViewModel.action.observe(this) {
            when(it) {
                is MainActivityViewModel.Action.DownloadStationSensorsStationId -> {
                    stationSensorsStationIdAdapter.addListStationSensorsStationId(it.stationSensorsStationId)
                }
                is MainActivityViewModel.Action.DownloadAqIndexGetIndexStationId -> {
                    mainAdapter.addListAirQualityState(it.airQualityState)
                }
                MainActivityViewModel.Action.GoToFormItemFlipper -> {
                    binding.viewNavigationFlipper.displayedChild =
                        binding.viewNavigationFlipper.indexOfChild(findViewById(R.id.get_item))
                }
                MainActivityViewModel.Action.Back ->
                    startMainActivityFlipper()
            }
        }
        mainActivityViewModel.error.observe(this) {
            when(it) {
                is MainActivityViewModel.Errors.ErrorException -> {
                    it.exception.message?.let { message ->
                        showSnackBar(message)
                    }
                }
            }
        }
    }

    private fun startMainActivityFlipper() {
        binding.viewNavigationFlipper.displayedChild =
            binding.viewNavigationFlipper.indexOfChild(findViewById(R.id.get_list))
    }
}