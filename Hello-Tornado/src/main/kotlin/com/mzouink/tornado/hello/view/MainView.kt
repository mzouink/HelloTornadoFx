package com.mzouink.tornado.hello.view

import tornadofx.*

class MainView : View("Hello TornadoFX") {
    override fun onUndock() {
        println("Undock")
        super.onUndock()
    }

    override fun onDock() {
        println("onDock")
        super.onDock()
    }

    override fun onCreate() {
        println("onCreate")
        super.onCreate()
    }

    override fun onBeforeShow() {
        println("onBeforeDock")
        super.onBeforeShow()
    }

    // by inject and find do the same objective
    val topView: TopView by inject()

    val centerView = find(CenterView::class)

    override val root = borderpane {
        top = topView.root

        center = centerView.root
    }

}