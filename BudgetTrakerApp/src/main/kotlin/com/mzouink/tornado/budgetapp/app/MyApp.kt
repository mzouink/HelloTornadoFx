package com.mzouink.tornado.budgetapp.app

import com.mzouink.tornado.budgetapp.view.MainView
import javafx.stage.Stage
import tornadofx.App

class MyApp: App(BudgetTrackerWorkspace::class, Styles::class){
    override fun start(stage: Stage) {
        with(stage){
            width = 1200.0
            height = 600.0
            super.start(stage)
        }
    }
}