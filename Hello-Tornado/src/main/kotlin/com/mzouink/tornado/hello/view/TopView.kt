package com.mzouink.tornado.hello.view

import tornadofx.*

class TopView : View("My View") {

    override val root = hbox {
        label("My view")
        button("Menu")
        button("File")
    }
}
