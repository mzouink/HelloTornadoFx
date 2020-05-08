package com.mzouink.tornado.klimatic.model

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import tornadofx.*
import javax.json.JsonObject

class Lista : JsonModel {
    val dtProperty = SimpleIntegerProperty()
    var dt: Int by dtProperty

    val tempProperty = SimpleObjectProperty<Temp>()
    var temp: Temp by tempProperty

    val humidityProperty = SimpleIntegerProperty()
    var humidity: Int by humidityProperty

    val weatherProperty = SimpleListProperty<Weather>()
    var weather: List<Weather> by property(weatherProperty)

    val speedProperty = SimpleDoubleProperty()
    var speed: Double by speedProperty

    override fun updateModel(json: JsonObject) {
        with(json){
            dt = getInt("dt")
            temp = getJsonObject("temp").toModel()
            humidity = getInt("humidity")
            weather = getJsonArray("weather").toModel()
            speed = getDouble("speed")
        }
    }
}