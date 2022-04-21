package com.example.calculatorrpn

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorrpn.databinding.ActivityMainBinding
import kotlin.math.*
import kotlin.text.*


class MainActivity : AppCompatActivity() {

    var calculator : Calculator = Calculator()
    var enteredValue : String = ""
    var rounding: Int = 1
    lateinit var binding: ActivityMainBinding
    lateinit var adapter : ArrayAdapter<Float>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, calculator.stack.toList())
        binding.stackList.adapter = adapter

        binding.textEntered.text = enteredValue
        binding.buttonNum0.setOnClickListener(){inputNumber("0")}
        binding.buttonNum1.setOnClickListener(){inputNumber("1")}
        binding.buttonNum2.setOnClickListener(){inputNumber("2")}
        binding.buttonNum3.setOnClickListener(){inputNumber("3")}
        binding.buttonNum4.setOnClickListener(){inputNumber("4")}
        binding.buttonNum5.setOnClickListener(){inputNumber("5")}
        binding.buttonNum6.setOnClickListener(){inputNumber("6")}
        binding.buttonNum7.setOnClickListener(){inputNumber("7")}
        binding.buttonNum8.setOnClickListener(){inputNumber("8")}
        binding.buttonNum9.setOnClickListener(){inputNumber("9")}
        binding.buttonUndo.setOnClickListener() {undo()}
        binding.buttonEnter.setOnClickListener(){enterNumber()}
        binding.buttonPlus.setOnClickListener(){calculator.add();refreshStack()}
        binding.buttonMinus.setOnClickListener(){calculator.subtract();refreshStack()}
        binding.buttonMultiply.setOnClickListener(){calculator.multiply();refreshStack()}
        binding.buttonDivide.setOnClickListener(){calculator.divide();refreshStack()}
        binding.buttonPower.setOnClickListener(){calculator.power();refreshStack()}
        binding.buttonSqrt.setOnClickListener(){calculator.squareRoot();refreshStack()}
        binding.buttonAC.setOnClickListener(){calculator.clear();refreshStack()}
        binding.buttonSwap.setOnClickListener(){calculator.swap();refreshStack()}
        binding.buttonDrop.setOnClickListener(){calculator.drop();refreshStack()}
        binding.buttonPlusMinus.setOnClickListener(){calculator.plusMinus();refreshStack()}
        binding.buttonSettings.setOnClickListener(){openSettings()}

    }

    private fun inputNumber(num : String){
        enteredValue += num
        binding.textEntered.text = enteredValue
        //Log.i("debug", enteredValue)
    }

    private fun enterNumber(){
        if(binding.textEntered.text.isEmpty() == true){
            calculator.duplicate()
        }
        else{
            calculator.enter(binding.textEntered.text.toString().toFloat())
        }
        enteredValue = ""
        binding.textEntered.text = ""
        refreshStack()
    }

    private fun refreshStack(){
        fun roundFloat(num : Float, decimals : Int): Float {
            var multiplier = 1f
            repeat(decimals) { multiplier *= 10 }
            return round(num * multiplier) / multiplier
        }
        adapter.clear()
        adapter.addAll(calculator.stack.map{roundFloat(it, rounding)})
        adapter.notifyDataSetChanged()
    }

    private fun undo(){
        enteredValue = enteredValue.dropLast(1)
        binding.textEntered.text = enteredValue
    }

    private fun openSettings(){
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)

        val settings = getSharedPreferences("General", 0)
        rounding = settings.getInt("Rounding", rounding)
    }




}