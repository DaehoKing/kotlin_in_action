package com.pi.big._5_lambda

fun printProblemCounts(response: Collection<String>) {
    var clientErrors = 0
    var serverError = 0;

    response.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverError++
        }
    }
}