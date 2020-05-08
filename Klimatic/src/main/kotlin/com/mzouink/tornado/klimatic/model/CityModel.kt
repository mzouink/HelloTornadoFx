package com.mzouink.tornado.klimatic.model

import tornadofx.*

class CityModel : ItemViewModel<City>() {
    val id = bind(City::idProperty)
    val name = bind(City::name)
    val country = bind(City::country)
    val population = bind(City::population)
}