package com.mzouink.tornado.hello.app

import com.mzouink.tornado.hello.view.MainView
import javafx.stage.Stage
import tornadofx.App

class MyApp: App(MainView::class, Styles::class){
    override fun start(stage: Stage) {
        super.start(stage)
        with(stage){
            width = 1200.0
            height = 600.0
        }
    }
}
