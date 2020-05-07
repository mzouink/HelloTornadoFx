package com.mzouink.tornado.shapesapp.view

import javafx.animation.Interpolator
import javafx.scene.paint.Color
import tornadofx.*


class MainView : View("Hello TornadoFX") {
    override val root = stackpane {
        group {

//                 line {
//                      startX = 23.0
//                     startY = 23.0
//                     endX = 120.0
//                     endY = 100.0
//                 }
//                 rectangle {
//                     width = 300.0
//                     height = 130.0
//                     x = 200.0
//                     y = 100.0
//                    // isManaged = false
//                     style {
//                         fill = Color.DARKGOLDENROD
//                     }

            // }

            /*
             Timeline,
              Keyframe, key-value
             */
            val myCirc = circle {
                // isManaged = false
                radius = 1.0
                centerX = 150.0
                centerY = 150.0
                fill = Color.PINK
            }
            myCirc.radiusProperty().animate(endValue = 100, duration = 3.seconds,
                    interpolator = Interpolator.EASE_BOTH)
//                 timeline {
//                      keyframe(Duration.seconds(1.6)) {
//                            keyvalue(myCirc.radiusProperty(), 100, Interpolator.EASE_BOTH)
//                      }
//                     isAutoReverse = true
//                     cycleCount = 4
//
//                 }

        }
    }
}