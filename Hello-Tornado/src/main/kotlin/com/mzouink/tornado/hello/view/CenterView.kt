package com.mzouink.tornado.hello.view

import com.mzouink.tornado.hello.app.Styles
import com.mzouink.tornado.hello.controller.MainController
import javafx.geometry.Pos
import javafx.scene.layout.VBox
import tornadofx.*

class CenterView : View("My View") {
    val mainController: MainController by inject()
    override val root = vbox {
        alignment = Pos.CENTER

        label(mainController.labelText) {
//            bind(mainController.labelText)
            addClass(Styles.heading)
        }
        button {
            this.text = "Click me !"
            action {
                mainController.getRandomName()
            }
        }
    }
}
