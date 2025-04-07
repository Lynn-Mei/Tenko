package com.nihonium.tenko.library

class Kanji {
    private var kanji: String = ""
    private var onyomi: MutableList<String> = mutableListOf()
    private var kunyomi: MutableList<String> = mutableListOf()
    private var meanings: MutableMap<Language, String> = mutableMapOf()

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