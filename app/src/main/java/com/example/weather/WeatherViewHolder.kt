package com.example.weather

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeatherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val rootLayout: LinearLayout = itemView.findViewById(R.id.rootLayout)
    private val tvDay: TextView = itemView.findViewById(R.id.tvDay)
    private val ivClouds: ImageView = itemView.findViewById(R.id.ivClouds)
    private val tvTemperature: TextView = itemView.findViewById(R.id.tvTemperature)


    fun bind(item: DailyWeather) {
        val temp = item.temperature
        val tempString =
            if (temp > 0) R.string.plus_temperature
            else R.string.minus_temperature
        val celsius = R.string.celsius
        val tempColor = when {
            temp < -20 -> R.color.less_then_minus_20
            temp in -20..-10 -> R.color.minus_20_to_minus_10
            temp in -9..-1 -> R.color.minus_9_to_minus_1
            temp in 0..10 -> R.color.from_0_to_10
            temp in 11..12 -> R.color.from_11_to_21
            else -> R.color.more_then_plus_22
        }
        val cloudsIcon = if (item.clouds) R.drawable.ic_cloud else R.drawable.ic_sun

        tvDay.text = item.day
        ivClouds.setImageResource(cloudsIcon)
        tvTemperature.text = itemView.context.getString(tempString, temp, celsius)
        rootLayout.setBackgroundColor(itemView.context.getColor(tempColor))
    }
}