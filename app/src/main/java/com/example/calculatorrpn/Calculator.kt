package com.example.calculatorrpn
import java.util.ArrayDeque
import kotlin.math.*

class Calculator {

    var stack : ArrayDeque<Float> = ArrayDeque<Float>()

    constructor(){
        stack.push(6f)
        stack.push(7.8f)
        stack.push(3f)
    }

    fun enter(num : Float){
        stack.push(num)
    }

    fun add(){
        var value1 = stack.pop()
        var value2 = stack.pop()
        var result = value1 + value2
        stack.push(result)
    }

    fun subtract(){
        var value1 = stack.pop()
        var value2 = stack.pop()
        var result = value2 - value1
        stack.push(result)
    }

    fun multiply(){
        var value1 = stack.pop()
        var value2 = stack.pop()
        var result = value1 * value2
        stack.push(result)
    }

    fun divide(){
        var value1 = stack.pop()
        var value2 = stack.pop()
        var result = value2 / value1
        stack.push(result)
    }

    fun power(){
        var value1 = stack.pop()
        var value2 = stack.pop()
        var result = value2.pow(value1)
        stack.push(result)
    }

    fun squareRoot(){
        var value1 = stack.pop()
        var result = sqrt(value1)
        stack.push(result)
    }

    fun clear(){
        stack.clear()
    }

    fun swap(){
        var value1 = stack.pop()
        var value2 = stack.pop()
        stack.push(value2)
        stack.push(value1)
    }

    fun drop(){
        stack.pop()
    }

    fun plusMinus(){
        var value1 = stack.pop()
        value1 *= -1
        stack.push(value1)
    }
}