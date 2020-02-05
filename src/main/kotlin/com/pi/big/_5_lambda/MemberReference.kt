package com.pi.big._5_lambda

class Person

val action = {person:Person, message:String -> sendEmail(person, message)}
val nextAction = ::sendEmail

fun sendEmail(person: Person, message: String) {

}

fun main() {

}
