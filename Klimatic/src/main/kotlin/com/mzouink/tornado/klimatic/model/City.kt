package com.mzouink.tornado.klimatic.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import javax.json.JsonObject

class City : JsonModel {

    val idProperty = SimpleIntegerProperty()
    var id: Int by idProperty

    val nameProperty = SimpleStringProperty()
    var name: String by nameProperty

    val countryProperty = SimpleStringProperty()
    var country: String by countryProperty

    val populationProperty = SimpleIntegerProperty()
    var population: Int by populationProperty

    override fun updateModel(json: JsonObject) {
        with(json) {
            id = getInt("geoname_id")
            name = getString("name")
            country = getString("country")
            population = getInt("population")
        }
    }

    override fun toString() = name!!
}

