package com.learning

import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

@Location("/book/list")
data class BookListLocation(val sortBy: String, val asc: Boolean)

fun Route.books() {

    val dataManager = DataManager()

    get<BookListLocation>() {
        call.respond(dataManager.sortByBooks(it.sortBy, it.asc))
    }

    route("/book") {
        get("/") {
            call.respond(dataManager.addBooks())
        }

        post("/{id}") {
            val id = call.parameters["id"]
            val book = call.receive(Book::class)
            val updateBook = dataManager.updateBook(book)
            call.respond(updateBook)
        }

        put("/") {
            val book = call.receive(Book::class)
            val newBook = dataManager.newBook(book)
            call.respond(newBook)
        }

        delete("/{id}") {
            val id = call.parameters["id"].toString()
            val deleteBook = dataManager.deleteBook(id)
            call.respond(deleteBook)
        }
    }
}