package com.intterra

import java.io.InputStream
import java.util.*
import kotlin.NoSuchElementException
import kotlin.collections.HashSet

class InputReader(inputStream : InputStream) {

    private val scanner = Scanner(inputStream)
    private var nextUser: User? = null
    val input: MutableSet<User> = HashSet()

    fun getNextUser(): User? {
        return nextUser
    }

    fun hasNext(): Boolean {
        nextUser = parseUser()
        return nextUser != null
    }

    private fun parseUser(): User? {
        val splittedArray = getNextLine().split(":")
        if (splittedArray.size == 2) {
            val username = splittedArray[0].trim()
            val emails = splittedArray[1].trim().split(",").map{ email -> email.trim() }
            if (username.isNotEmpty() && emails.isNotEmpty()) {
                return User(username, emails.toHashSet())
            }
        }
        return null
    }

    private fun getNextLine(): String {
        return try {
            scanner.nextLine()
        } catch (e : NoSuchElementException) {
            ""
        }
    }

}