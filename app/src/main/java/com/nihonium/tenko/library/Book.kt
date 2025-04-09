package com.nihonium.tenko.library

import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import com.nihonium.tenko.R

class Book : java.io.Serializable {
    var isbn: String = ""
    var title: String = ""
    var author:String = ""
    var cover: Int = 0
    var pages: MutableList<Page> = mutableListOf()

    constructor(id: String, title:String, author: String){
        this.isbn = id
        this.title = title
        this.author = author
        this.cover = R.drawable.nishinomajou
    }

    private fun loadFakeTestPage(){
        this.pages.add(Page(1))
    }
}