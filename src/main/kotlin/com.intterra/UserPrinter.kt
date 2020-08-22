package com.intterra

import java.util.function.Consumer

class UserPrinter {

    fun print(users: MutableSet<User>) {
        users.forEach(Consumer { user: User -> println(user.name + ": " + user.emails.joinToString (", ")) })
    }

}