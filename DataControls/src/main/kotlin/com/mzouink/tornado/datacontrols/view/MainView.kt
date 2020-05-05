package com.mzouink.tornado.datacontrols.view

import com.mzouink.tornado.datacontrols.controllers.MainController
import javafx.scene.layout.BorderPane
import tornadofx.*

class MainView : View("Hello TornadoFX") {

    val mainController: MainController by inject()
    val bottomView: BottomView by inject()
    val topView: TopView by inject()
    val centerView : CenterView by inject()
    val studentEditor : StudentEditor by inject()
    override val root: BorderPane = borderpane {

        bottom = bottomView.root
        top = topView.root
        center = centerView.root
        left = studentEditor.root
    }
}