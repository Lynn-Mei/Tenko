package com.nihonium.tenko.library

class Page {
    var number: Int = -1
    var name: String = ""
    private var kanjis: MutableList<Kanji> = mutableListOf()
    private var words: MutableList<Word> = mutableListOf()

    constructor(pageNumber: Int){
        this.number = pageNumber
        this.name = "Page scan $pageNumber"
    }

    fun Scan(){
        //Take a picture
        //Extract content to string
        val content: String = ""
        //Parse content string to single out words and add them to words
        this.parseWordFrom(content)
        //Remove all kana/romaji/punctuation/numbers and add all to kanjis (unique)
        this.extractKanjiFrom(content)
    }

    private fun parseWordFrom(content: String){
    }

    private fun extractKanjiFrom(content: String){

    }
}