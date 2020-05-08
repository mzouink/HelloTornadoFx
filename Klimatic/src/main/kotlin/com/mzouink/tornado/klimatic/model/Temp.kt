package com.mzouink.tornado.klimatic.model

import javafx.beans.property.SimpleDoubleProperty
import tornadofx.*
import javax.json.JsonObject

class Temp : JsonModel {

    val dayProperty = SimpleDoubleProperty()
    var day: Double by dayProperty

    val minProperty = SimpleDoubleProperty()
    var min: Double by minProperty

    val maxProperty = SimpleDoubleProperty()
    var max: Double by maxProperty

    val eveProperty = SimpleDoubleProperty()
    var eve: Double by eveProperty

    val nightProperty = SimpleDoubleProperty()
    var night: Double by nightProperty

    val mornProperty = SimpleDoubleProperty()
    var morn: Double by mornProperty


    override fun updateModel(json: JsonObject) {
        with(json) {
            day = getDouble("day")
            min = getDouble("min")
            max = getDouble("max")
            night = getDouble("night")
            eve = getDouble("eve")
            morn = getDouble("morn")
        }
    }
}