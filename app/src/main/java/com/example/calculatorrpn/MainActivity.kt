package com.example.calculatorrpn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.calculatorrpn.Calculator
import com.example.calculatorrpn.databinding.ActivityMainBinding
import android.util.Log
import kotlin.text.*

class MainActivity : AppCompatActivity() {

    var calculator : Calculator = Calculator()
    var enteredValue : String = "test"
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textEntered.text = enteredValue
        binding.buttonNum0.setOnClickListener(){enterNumber("0")}
        binding.buttonNum1.setOnClickListener(){enterNumber("1")}
        binding.buttonNum2.setOnClickListener(){enterNumber("2")}
        binding.buttonNum3.setOnClickListener(){enterNumber("3")}
        binding.buttonNum4.setOnClickListener(){enterNumber("4")}
        binding.buttonNum5.setOnClickListener(){enterNumber("5")}
        binding.buttonNum6.setOnClickListener(){enterNumber("6")}
        binding.buttonNum7.setOnClickListener(){enterNumber("7")}
        binding.buttonNum8.setOnClickListener(){enterNumber("8")}
        binding.buttonNum9.setOnClickListener(){enterNumber("9")}
        binding.buttonUndo.setOnClickListener() {undo()}
        binding.buttonEnter.setOnClickListener(){calculator.enter(binding.textEntered.text.toString().toFloat())}
        binding.buttonPlus.setOnClickListener(){calculator.add()}
        binding.buttonMinus.setOnClickListener(){calculator.subtract()}
        binding.buttonMultiply.setOnClickListener(){calculator.multiply()}
        binding.buttonDivide.setOnClickListener(){calculator.divide()}
        binding.buttonPower.setOnClickListener(){calculator.power()}
        binding.buttonSqrt.setOnClickListener(){calculator.squareRoot()}
        binding.buttonAC.setOnClickListener(){calculator.clear()}
        binding.buttonSwap.setOnClickListener(){calculator.swap()}
        binding.buttonDrop.setOnClickListener(){calculator.drop()}
        binding.buttonPlusMinus.setOnClickListener(){calculator.plusMinus()}

    }

    fun enterNumber(num : String){
        enteredValue += num
        binding.textEntered.text = enteredValue
        //Log.i("debug", enteredValue)
    }

    fun undo(){
        enteredValue = enteredValue.dropLast(1)
        binding.textEntered.text = enteredValue
        //Log.i("debug", enteredValue)
    }




}