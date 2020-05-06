package com.mzouink.tornado.datacontrols.app

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val vBox: CssRule by cssclass()


        private val topColor: Color = c("green")
        private val bottomColor: Color = Color.RED
    }

    init {
        vBox{
            padding = box(10.px)
            backgroundColor = multi(Color.DARKBLUE)
        }
        label and heading {

            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }
    }
}
