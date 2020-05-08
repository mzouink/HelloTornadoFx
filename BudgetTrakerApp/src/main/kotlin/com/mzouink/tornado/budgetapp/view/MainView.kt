package com.mzouink.tornado.budgetapp.view

import com.mzouink.tornado.budgetapp.app.Styles
import tornadofx.*

class MainView : View("Hello TornadoFX") {
    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
    }
}