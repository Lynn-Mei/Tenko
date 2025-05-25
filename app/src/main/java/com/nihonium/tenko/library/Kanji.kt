package com.nihonium.tenko.library

class Kanji {
    var kanji: String = ""
    var onyomi: MutableList<String> = mutableListOf()
    var kunyomi: MutableList<String> = mutableListOf()
    var meanings: MutableMap<Language, String> = mutableMapOf()

    constructor(kanji: String){
        this.kanji = kanji
    }

    fun addReading(reading: String, isOnyomi: Boolean){
        if(isOnyomi){
            this.onyomi.add(reading)
        }else{
            this.kunyomi.add(reading)
        }
    }

    fun addMeaning(meaning: String, lang: Language){
        meanings[lang] = meaning
    }
}