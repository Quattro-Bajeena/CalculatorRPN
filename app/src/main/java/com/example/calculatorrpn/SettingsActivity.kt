package com.example.calculatorrpn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

    private fun saveSettings(){


        val settings = getSharedPreferences("General", 0)
        val editor = settings.edit()
        editor.putInt("Rounding", 5)
        editor.commit()
    }
}