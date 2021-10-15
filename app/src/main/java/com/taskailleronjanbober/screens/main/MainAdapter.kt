package com.taskailleronjanbober.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.domain.entities.model.AirQualityState
import com.domain.entities.model.Root
import com.taskailleronjanbober.R
import com.taskailleronjanbober.databinding.AirCityItemBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var onClick: (AirQualityState) -> Unit = {}
    private val airQualityState = mutableListOf<AirQualityState>()

    fun addListAirQualityState(airQualityState: AirQualityState) {
        this.airQualityState.add(airQualityState)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainViewHolder(
        AirCityItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(
            airQualityState[position],
            onClick
        )
    }

    override fun getItemCount(): Int = airQualityState.size

    class MainViewHolder(
        private val binding: AirCityItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            airQualityState: AirQualityState,
            onClick:(AirQualityState) -> Unit
        ) {
            with(binding) {
                cityName = airQualityState.city
                stIndexLevelId.setImageResource(levelAirQuality(airQualityState.stIndexLevel))
                so2IndexLevelId.setImageResource(levelAirQuality(airQualityState.so2IndexLevel))
                no2IndexLevelId.setImageResource(levelAirQuality(airQualityState.no2IndexLevel))
                pm10IndexLevelId.setImageResource(levelAirQuality(airQualityState.pm10IndexLevel))
                pm25IndexLevelId.setImageResource(levelAirQuality(airQualityState.pm25IndexLevel))
                o3IndexLevelId.setImageResource(levelAirQuality(airQualityState.o3IndexLevel))
                root.setOnClickListener {
                    onClick(airQualityState)
                }
            }
        }

        private fun levelAirQuality(level: Int?): Int {
            return when (level) {
                -1 -> R.color.no_index
                0 -> R.color.very_good
                1 -> R.color.good
                2 -> R.color.moderate
                3 -> R.color.fair
                4 -> R.color.bad
                5 -> R.color.very_bad
                else -> R.color.no_index
            }
        }
    }
}