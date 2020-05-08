package com.mzouink.tornado.klimatic.app

import com.mzouink.tornado.klimatic.view.WeatherForcast
import javafx.stage.Stage
import tornadofx.App

class MyApp: App(WeatherForcast::class, Styles::class){
    override fun start(stage: Stage) {
        with(stage){
            width = 1200.0
            height = 600.0
            super.start(stage)
        }
    }
}