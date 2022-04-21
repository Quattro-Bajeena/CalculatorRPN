package com.example.calculatorrpn
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.registerForResult(onResult : (resultCode:Int, data: Intent?) -> Unit):
        ActivityResultLauncher<Intent>{
    return this.registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
        onResult(result.resultCode, result.data)
    }
}

