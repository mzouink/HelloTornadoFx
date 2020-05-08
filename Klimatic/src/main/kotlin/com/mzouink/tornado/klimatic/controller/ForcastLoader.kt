package com.mzouink.tornado.klimatic.controller

import com.mzouink.tornado.klimatic.model.CityModel
import com.mzouink.tornado.klimatic.model.ForcastPayload
import com.mzouink.tornado.klimatic.util.jsonPath
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.*
import java.io.StringReader
import java.text.SimpleDateFormat
import java.util.*
import javax.json.Json

class ForcastLoader : Controller() {
    val selectedCity: CityModel by inject()

    var allWeather = FXCollections.emptyObservableList<ForcastPayload>()

    fun getIcon(iconString: String) = when (iconString) {
        "Rain" -> "rain"
        "Clouds" -> "clouds"
        "Snow" -> "snow"
        "Clear" -> "clear"
        "Drizzle" -> "rain"
        "fog" -> "fog"
        else -> "clear"
    }

    fun getFormattedData(date: Long) = SimpleDateFormat("EEE, d MMM, YYYY").format(Date(date * 1000))
    fun getDay(date: Long) = SimpleDateFormat("EEE").format(Date(date * 1000))

    fun listPayload(cityName: String = selectedCity.name.value): ObservableList<ForcastPayload> {

        val jsonString: String = java.io.File(jsonPath).readText(Charsets.UTF_8)
        val json = Json.createReader(StringReader(jsonString))
        val forcast = json.readArray().toModel<ForcastPayload>()

        return forcast
    }
}