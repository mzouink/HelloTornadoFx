package com.mzouink.tornado.billsplitter.app

import com.mzouink.tornado.billsplitter.view.MainView
import javafx.stage.Stage
import tornadofx.*

class MyApp: App(MainView::class, Styles::class){
    init {
        reloadStylesheetsOnFocus()
        reloadViewsOnFocus()
    }
    override fun start(stage: Stage) {
        with(stage){
            height = 300.0
            width = 250.0
        }
        super.start(stage)
    }
}