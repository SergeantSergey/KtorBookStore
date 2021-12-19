package com.learning

class DataManager {

    var bookList = ArrayList<Book>()

    fun gimmeId(): String {
        return this.bookList.size.toString()
    }

    init {
        this.bookList.add(Book(this.gimmeId(), "How to grow apple", "Mr. Appleton", 100.0F))
        this.bookList.add(Book(this.gimmeId(), "How to grow oranges", "Mr. Orangeton", 00.0F))
        this.bookList.add(Book(this.gimmeId(), "How to grow lemon", "Mr. Lemon", 110.0F))
        this.bookList.add(Book(this.gimmeId(), "How to grow pineapples", "Mr. Pineapple", 100.0F))
        this.bookList.add(Book(this.gimmeId(), "How to grow pears", "Mr. Pear", 110.0F))
        this.bookList.add(Book(this.gimmeId(), "How to grow coconuts", "Mr. Coconut", 130.0F))
        this.bookList.add(Book(this.gimmeId(), "How to grow bananas", "Mr. Appleton", 120.0F))
    }

    fun newBook(book: Book): Book {
        this.bookList.add(book)
        return book
    }

    fun updateBook(book: Book): Book {
        return this.bookList.find {
            it.id == book.id
        }?.apply {
            title = book.title
            author = book.author
            price = book.price
        }!!
    }

    fun deleteBook(id: String): Book {
        val findBook = this.bookList.find {
            it.id == id
        }
        this.bookList.remove(findBook)
        return findBook!!
    }

    fun addBooks(): ArrayList<Book> {
        return this.bookList
    }
}