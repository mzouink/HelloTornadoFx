package com.mzouink.tornado.klimatic.app

import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val mainLabel : CssRule by cssclass()
        val heading by cssclass()
        val contentWrapper by cssclass()
    }

    init {
        contentWrapper{
            minWidth = 980.px
            maxWidth = minWidth
            alignment = Pos.CENTER
        }

        mainLabel{
            fontSize = 20.px
            fill = Color.GRAY
        }

        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }
    }
}