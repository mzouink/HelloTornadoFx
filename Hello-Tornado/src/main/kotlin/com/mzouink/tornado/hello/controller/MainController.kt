package com.mzouink.tornado.hello.controller

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class MainController : Controller() {

    val list = listOf("Marwan", "Majdi", "Fathi", "Taher")
    var labelText = SimpleStringProperty()

    fun getRandomName() {
        val randomInteger: Int = (0..(list.size - 1)).shuffled().first()
        print("Random $randomInteger")
        labelText.value = list[randomInteger]
    }
}