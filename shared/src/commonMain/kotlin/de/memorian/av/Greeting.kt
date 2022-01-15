package de.memorian.av

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}