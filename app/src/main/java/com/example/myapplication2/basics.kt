package com.example.myapplication2




    fun main() {
        println("Simple Calculator")
        println("Enter first number:")
        val num1 = readLine()!!.toDouble()

        println("Enter second number:")
        val num2 = readLine()!!.toDouble()

        println("Choose an operation (+, -, *, /):")
        val operator = readLine()

        val result = when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> {
                if (num2 != 0.0) {
                    num1 / num2
                } else {
                    println("Error: Division by zero is not allowed.")
                    return
                }
            }
            else -> {
                println("Error: Invalid operator.")
                return
            }
        }

        println("Result: $result")
    }
