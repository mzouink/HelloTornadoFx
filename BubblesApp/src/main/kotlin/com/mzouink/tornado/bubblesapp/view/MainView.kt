package com.mzouink.tornado.bubblesapp.view

import com.mzouink.tornado.bubblesapp.app.Styles
import com.mzouink.tornado.bubblesapp.controllers.BubbleController
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.input.MouseDragEvent
import tornadofx.*

class MainView : View("Hello TornadoFX") {
    private val bubbleController : BubbleController by inject()
    private  var myLabel : Label by singleAssign()
    override val root = borderpane() {
        setPrefSize(1000.0,500.0)
        center{
            label {
                myLabel = this
                style {
                    fontSize = 21.px
                }
                bind(bubbleController.mText)
            }
        }

        bottom{
            label("Click anywhere .."){
                alignment = Pos.BOTTOM_CENTER
                paddingAll = 19.0
            }.apply {
                style{
                    opacity = 0.3
                    fontSize = 25.px
                }
            }
        }
    }.apply {
        style {
            backgroundColor += c("#E0EEEE")
        }

        addEventFilter(MouseDragEvent.MOUSE_DRAGGED){
            bubbleController.addCircle(it,this)
        }
        addEventFilter(MouseDragEvent.MOUSE_CLICKED){
            bubbleController.addCircle(it,this)
            bubbleController.addRandomText()
        }
    }
}