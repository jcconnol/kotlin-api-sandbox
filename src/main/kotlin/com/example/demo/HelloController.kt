package com.example.demo.helloworld

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HelloController {

    data class Body(val number1: Int, val number2: Int, val operation: String)

    data class Result(val answer: String)

    @GetMapping("/hello")
    fun sayHello(): String {
        return "Hello, World even more!"
    }

    @PostMapping("/math")
    fun addNumbers(@RequestBody body: Body): Result {
        val number1 = body.number1
        val number2 = body.number2
        var answer = "0.0"

        if (body.operation == "+") {
            answer = (number1 + number2).toString()
        } else if (body.operation == "-") {
            answer = (number1 - number2).toString()
        } else if (body.operation == "/") {
            if (number2 != 0) {
                answer = (number1 / number2).toString()
            } else {
                return Result("Division by zero")
            }
        } else if (body.operation == "*") {
            answer = (number1 * number2).toString()
        } else {
            return Result("Unknown operation")
        }

        return Result(answer)
    }

    @GetMapping("/database-select")
    fun databaseSelect(): String {
        return "Hello, World!"
    }
}
