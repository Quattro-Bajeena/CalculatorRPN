package com.example.calculatorrpn

import android.R
import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorrpn.databinding.ActivitySettingsBinding
import kotlin.text.*


class SettingsActivity : AppCompatActivity() {

    lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var roundingOptions = arrayOf(1, 2, 3, 4)
        var colorOptions = arrayOf("Violet", "Red", "Green", "Blue")
        binding.spinnerRounding.adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, roundingOptions)
        binding.spinnerColor.adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, colorOptions)

        val settings = getSharedPreferences("General", 0)
        var rounding = settings.getInt("Rounding", 1)
        var color = settings.getString("Color", "Violet")

        binding.spinnerRounding.setSelection(roundingOptions.indexOf(rounding))
        binding.spinnerColor.setSelection(colorOptions.indexOf(color))

        binding.buttonSave.setOnClickListener(){saveSettings()}
    }

    private fun saveSettings(){
        var roundingValue = binding.spinnerRounding.selectedItem.toString().toInt()
        var colorValue = binding.spinnerColor.selectedItem.toString()

        val settings = getSharedPreferences("General", 0)
        val editor = settings.edit()
        editor.putInt("Rounding", roundingValue)
        editor.putString("Color", colorValue)
        editor.commit()
        setResult(Activity.RESULT_OK)
        finish()
    }
}