package com.taskailleronjanbober.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.domain.entities.model.StationSensorsStationId
import com.taskailleronjanbober.databinding.StationSensorsStationIdItemBinding

class StationSensorsStationIdAdapter : RecyclerView.Adapter<StationSensorsStationIdAdapter.StationSensorsStationIdViewHolder>() {

    private val stationSensorsStationId = mutableListOf<StationSensorsStationId>()

    fun addListStationSensorsStationId(listStationSensorsStationId: List<StationSensorsStationId>) {
        stationSensorsStationId.clear()
        stationSensorsStationId.addAll(listStationSensorsStationId)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StationSensorsStationIdViewHolder(
        StationSensorsStationIdItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: StationSensorsStationIdViewHolder, position: Int) {
        holder.bind(
            stationSensorsStationId[position]
        )
    }

    override fun getItemCount(): Int = stationSensorsStationId.size

    class StationSensorsStationIdViewHolder(
        private val binding: StationSensorsStationIdItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            root: StationSensorsStationId
        ) {
            binding.paramName = root.param?.paramName ?: ""
            binding.paramFormula = root.param?.paramFormula ?: ""
        }
    }
}