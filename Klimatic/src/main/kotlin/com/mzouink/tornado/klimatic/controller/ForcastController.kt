package com.mzouink.tornado.klimatic.controller

import com.mzouink.tornado.klimatic.model.CityModel
import com.mzouink.tornado.klimatic.model.ForcastPayload
import com.mzouink.tornado.klimatic.util.appid
import javafx.collections.FXCollections
import tornadofx.*

class ForcastController : Controller() {
    val selectedCity: CityModel by inject()

    var allWeather = FXCollections.emptyObservableList<ForcastPayload>()

    val api: Rest by inject()

    init {
        api.baseURI = "https://samples.openweathermap.org/data/2.5/forecast/daily/"
    }

    fun listPayload(cityName: String = selectedCity.name.value): List<ForcastPayload> {
        val forcast = api.get("?q=$cityName&appid=$appid&units=imperial").list().toModel<ForcastPayload>()
        println("Load forcast:::::: ${forcast[0].city.name}")
        forcast[0].lista.forEach {
            print(it.humidity)
        }
        return forcast
    }
}