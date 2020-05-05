package com.mzouink.tornado.datacontrols.view

import com.mzouink.tornado.datacontrols.controllers.MainController
import tornadofx.*

class TopView : View("My View") {

    val mainController: MainController by inject()
    override val root = listview(mainController.students) {
        cellFormat {
            text = it
            if (text.contains("Ma")) {
                textFill = c("green", 0.4)
                style {
                    fontSize = 20.px
                }
            }
        }
    }
}
