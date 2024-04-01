package me.will.coroutinesspecific

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("${Thread.currentThread().name} - runBlocking function")

        launch {
            println("${Thread.currentThread().name} - launch function")

            withContext(Dispatchers.Default) {
                println("${Thread.currentThread().name} - withContext function")
                delay(1000)
                println("100 results found.")
            }

            println("${Thread.currentThread().name} - end of launch function")
        }
        println("Loading...")
    }
}