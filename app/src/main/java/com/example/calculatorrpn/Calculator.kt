package com.example.calculatorrpn
import java.util.*
import kotlin.math.*

class Calculator {

    var stack : Deque<Float> = ArrayDeque()

    constructor(){
        stack.push(3f)
    }

    fun enter(num : Float){
        stack.push(num)
    }

    fun add(){
        if(stack.size < 2)
            return

        var value1 = stack.pop()
        var value2 = stack.pop()
        var result = value1 + value2
        stack.push(result)
    }

    fun subtract(){
        if(stack.size < 2)
            return

        var value1 = stack.pop()
        var value2 = stack.pop()
        var result = value2 - value1
        stack.push(result)
    }

    fun multiply(){
        if(stack.size < 2)
            return

        var value1 = stack.pop()
        var value2 = stack.pop()
        var result = value1 * value2
        stack.push(result)
    }

    fun divide(){
        if(stack.size < 2)
            return

        var value1 = stack.pop()
        var value2 = stack.pop()
        var result = value2 / value1
        stack.push(result)
    }

    fun power(){
        if(stack.size < 2)
            return

        var value1 = stack.pop()
        var value2 = stack.pop()
        var result = value2.pow(value1)
        stack.push(result)
    }

    fun squareRoot(){
        if(stack.size == 0)
            return
        var value1 = stack.pop()
        var result = sqrt(value1)
        stack.push(result)
    }

    fun clear(){
        stack.clear()
    }

    fun swap(){
        if(stack.size < 2)
            return

        var value1 = stack.pop()
        var value2 = stack.pop()
        stack.push(value1)
        stack.push(value2)
    }

    fun drop(){
        if(stack.size == 0)
            return
        stack.pop()
    }

    fun plusMinus(){
        if(stack.size == 0)
            return

        var value1 = stack.pop()
        value1 *= -1
        stack.push(value1)
    }

    fun duplicate(){
        stack.push(stack.first)
    }
}