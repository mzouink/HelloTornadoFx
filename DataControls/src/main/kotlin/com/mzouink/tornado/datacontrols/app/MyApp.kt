package com.mzouink.tornado.datacontrols.app

import com.mzouink.tornado.datacontrols.view.MainView
import javafx.stage.Stage
import tornadofx.*

class MyApp: App(MainView::class, Styles::class){

    init {
        reloadStylesheetsOnFocus()
        reloadViewsOnFocus()
    }
    override fun start(stage: Stage) {
        with(stage){
            width = 800.0
            height= 1000.0
        }
        super.start(stage)
    }
}