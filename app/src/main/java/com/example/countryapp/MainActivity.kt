package com.example.countryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.countryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var provinces: Array<String>
    private val countries = arrayOf(
        "Indonesia",
        "United States",
        "United Kingdom",
        "Germany",
        "France",
        "Australia",
        "Japan",
        "China",
        "Brazil",
        "Canada"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        provinces = resources.getStringArray(R.array.provinces)
        with(binding) {
            val adapterCountry = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_dropdown_item, countries
            )
            adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCountry.adapter = adapterCountry
            val adapterProvinces = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_dropdown_item, provinces
            )
            adapterProvinces.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerProvinces.adapter = adapterProvinces

            var selectedDate = ""
            datePick.init(
                datePick.year,
                datePick.month,
                datePick.dayOfMonth
            ) { _, year, month, day ->
                selectedDate = "$day/${month + 1}/$year"
                Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()
            }

            var selectedTime =""
            timePick.setOnTimeChangedListener{
                _, timeOfDay, minute ->
                selectedTime = String.format("%2d:%02d", timeOfDay, minute)
                Toast.makeText(this@MainActivity, selectedTime, Toast.LENGTH_SHORT).show()
            }
        }
    }
}























//        dataPicker.init(
//            datePicker.year,
//            datePicker.month,
//            datePicker.dayOfMonth
//        ) { _, year, montYear, dayOfMonth ->
//            val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
//            Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()
//
//        }


