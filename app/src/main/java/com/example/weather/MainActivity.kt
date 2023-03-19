package com.example.weather

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class MainActivity : AppCompatActivity() {

    private val imageUrl = "https://i.pinimg.com/736x/d2/ff/25/d2ff252008f7601bbea4556a526443a0--sydney-breakfast.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val image = findViewById<ImageView>(R.id.image)
        image.setBackgroundColor(getColor(R.color.black))
        image.scaleType = ImageView.ScaleType.CENTER_CROP
        image.setImageResource(R.drawable.barsik)

        val weatherAdapter = WeatherAdapter(
            listOf(
                DailyWeather("Понедельник", true, -21),
                DailyWeather("Вторник", true, -12),
                DailyWeather("Среда", false, +15),
                DailyWeather("Четверг", true, +3),
                DailyWeather("Пятница", false, +11),
                DailyWeather("Суббота", false, -5),
                DailyWeather("Воскресение", true, +22),
            ) )

        val rvWeather = findViewById<RecyclerView>(R.id.rvWeather)
        rvWeather.adapter = weatherAdapter

        val image2 = findViewById<ImageView>(R.id.image2)
        Glide.with(applicationContext)
            .load(imageUrl)
            .placeholder(R.drawable.barsik)
            .centerInside()
            .transform(RoundedCorners(30))
            .into(image2)

    }
}