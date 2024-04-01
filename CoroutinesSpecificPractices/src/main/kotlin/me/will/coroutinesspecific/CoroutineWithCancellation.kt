package me.will.coroutinesspecific

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("Weather forecast")
        println(getWeatherReport())
        println("Have a good day!")
    }
}

private suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }

    delay(200)
    temperature.cancel()
    forecast.await()
}

private suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

private suspend fun getTemperature(): String {
    delay(1000)
    return "30\u00b0C"
}