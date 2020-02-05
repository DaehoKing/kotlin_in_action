package com.pi.big._5_lambda

import java.lang.StringBuilder

fun withSample() {
    val numbers = mutableListOf("one", "two", "three")
    val firstAndLast = with(numbers) {
        "The first element is ${first()}," +
                " the last element is ${last()}"
    }
    println(firstAndLast)
}

fun applySample() {
    println(mutableListOf("one", "two", "three").apply {
        "The first element is ${first()}," +
                " the last element is ${last()}"
    }.toString())
}

fun runSample() {
    println(mutableListOf("one", "two", "three").run {
        "The first element is ${first()}," +
                " the last element is ${last()}"
    })
}

fun main() {
    withSample()
    applySample()
    runSample()
}