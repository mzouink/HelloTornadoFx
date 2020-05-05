package com.mzouink.tornado.hello.view

import javafx.geometry.Pos
import tornadofx.*

class TopView : View("My View") {

    override val root = hbox {
        alignment = Pos.CENTER
        spacing = 16.0
        label("My view")
        button("Menu")
        button("File")
    }
}
