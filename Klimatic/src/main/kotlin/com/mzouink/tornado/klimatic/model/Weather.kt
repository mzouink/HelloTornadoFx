package com.mzouink.tornado.klimatic.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import javax.json.JsonObject

class Weather : JsonModel {

    val idProperty = SimpleIntegerProperty()
    var id: Int by idProperty

    val mainProperty = SimpleStringProperty()
    var main: String by mainProperty

    val descriptionProperty = SimpleStringProperty()
    var description: String by descriptionProperty

    val iconProperty = SimpleStringProperty()
    var icon: String by iconProperty

    override fun updateModel(json: JsonObject) {
        with(json){
            id = getInt("id")
            main = getString("main")
            description = getString("description")
            icon = getString("icon")
        }
    }

}