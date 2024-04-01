package me.will.coroutinesspecific

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
//        testLaunch()
//        println("============")
//        testAsync()
        testCoroutineScope()
    }
    println("Execution time: ${time / 1000.0} seconds")
}

// coroutineScope {}
fun testCoroutineScope() {
    runBlocking {
        println("Weather forecast")
        println(getWeatherReport())
        println("Have a good day!")
    }
}

// traits: it acts like a synchronous operation from the caller's view, because it won't return until all works
// are done, even asynchronous ones.
private suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }
    "${forecast.await()} ${temperature.await()}"
}

// async {} + await()
fun testAsync() {
    runBlocking {
        println("Weather forecast")
        val forecast: Deferred<String> = async {
            getForecast()
        }
        val temperature: Deferred<String> = async {
            getTemperature()
        }
        println("${forecast.await()} ${temperature.await()}")
        println("Have a good day!")
    }
}

private suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

private suspend fun getTemperature(): String {
    delay(1000)
    return "30\u00b0C"
}

// launch {}
fun testLaunch() {
    runBlocking {  // for local tests or other testing purposes only
        println("Weather forecast")
        launch {
            printForecast()
        }
        launch {
            printTemperature()
        }
        println("Have a good day!")
    }
}

private suspend fun printForecast() {
    delay(1000)
    println("Sunny")
}

private suspend fun printTemperature() {
    delay(1000)
    println("30\u00b0C")
}