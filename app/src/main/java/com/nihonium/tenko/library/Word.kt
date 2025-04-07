package com.nihonium.tenko.library

import java.util.Dictionary

class Word {
    private var word: String = ""
    private var translations: MutableMap<Language, String> = mutableMapOf()
    private var samples: MutableList<String> = mutableListOf()

    constructor(word: String)
    {
        this.word = word
    }

    fun addSample(sample: String){
        samples.add(sample)
    }

    fun setTranslation(translation: String, lang: Language){
        translations[lang] = translation
    }
}