package com.mzouink.tornado.hello.view

import tornadofx.*

class MainView : View("Hello TornadoFX") {

    // by inject and find do the same objective
    val topView: TopView by inject()

    val centerView = find(CenterView::class)

    override val root = borderpane {
        top = topView.root

        center = centerView.root
    }

}