package com.mzouink.tornado.hello.view

import com.mzouink.tornado.hello.app.Styles
import com.mzouink.tornado.hello.controller.MainController
import tornadofx.*

class MainView : View("Hello TornadoFX") {

    val mainController: MainController by inject()

    override val root = borderpane {
//                alignment = Pos.CENTER
//        spacing = 10.0
        top<TopView>()
        center {
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

}