package com.example.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherAdapter = WeatherAdapter(
            listOf(
                DailyWeather("Понедельник", true, -21),
                DailyWeather("Вторник", true, -12),
                DailyWeather("Среда", false, -5),
                DailyWeather("Четверг", true, +3),
                DailyWeather("Пятница", false, +11),
                DailyWeather("Суббота", false, -16),
                DailyWeather("Воскресение", true, +22),
            ) )

        val rvWeather = findViewById<RecyclerView>(R.id.rvWeather)
        rvWeather.adapter = weatherAdapter
    }
}