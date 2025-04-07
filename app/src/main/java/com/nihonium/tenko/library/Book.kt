package com.nihonium.tenko.library

class Book {
    var isbn: String = ""
    var title: String = ""
    private var pages: MutableList<Page> = mutableListOf()

    constructor(id: String, title:String){
        this.isbn = id
        this.title = title
    }
}