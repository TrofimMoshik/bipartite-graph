package com.intterra

fun main(args: Array<String>) {

    val reader = InputReader(System.`in`)

    println("Введите пользователей в формате \"user1: email1, email2\" (для завершения ввода введите пустую строку):")
    while (reader.hasNext()) {
        reader.getNextUser()?.let(reader.input::add)
    }

    UserPrinter().print(MergeService().merge(reader.input))

}