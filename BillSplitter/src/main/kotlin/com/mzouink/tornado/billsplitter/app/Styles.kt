package com.mzouink.tornado.billsplitter.app

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val vBoxx: CssRule by cssclass()


        private val topColor: Color = c("green")
        private val bottomColor: Color = Color.RED
    }

    init {
        vBoxx{
            padding = box(10.px)
            backgroundColor = multi(Color.LIGHTGRAY)
        }
        label and heading {

            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }
    }
}