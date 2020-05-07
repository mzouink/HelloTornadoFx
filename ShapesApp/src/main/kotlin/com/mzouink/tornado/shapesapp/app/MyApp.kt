package com.mzouink.tornado.shapesapp.app

import com.mzouink.tornado.shapesapp.view.MainView
import javafx.stage.Stage
import tornadofx.*

class MyApp: App(MainView::class, Styles::class){
    init {
        reloadViewsOnFocus()
        reloadStylesheetsOnFocus()
    }

    override fun start(stage: Stage) {
        with(stage){
            minWidth = 800.0
            minHeight = 600.0
            super.start(stage)
        }
    }
}