package com.mzouink.tornado.klimatic.view

import com.mzouink.tornado.klimatic.app.Styles
import com.mzouink.tornado.klimatic.controller.ForcastLoader
import com.mzouink.tornado.klimatic.model.ForcastPayload
import com.mzouink.tornado.klimatic.model.Lista
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import javafx.beans.binding.Bindings
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.input.KeyCode
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.FontPosture
import tornadofx.*
import java.io.File

class WeatherForcast : View("Klimatic") {

    val controller: ForcastLoader by inject()

    var forcastPayload = ForcastPayload()

    var cityLabel: Label by singleAssign()
    var todayTemp: Label by singleAssign()

    var todayIcon: Label by singleAssign()

    var forcastView : DataGrid<Lista> by singleAssign()
    var sevenDayLabel : Label by singleAssign()
    var dividerHB: HBox by singleAssign()

    init {
        controller.listPayload(cityName = "Boston")
    }

    override val root = borderpane() {
        style {
            backgroundColor += c("#666699")
        }

        center = vbox {
            addClass(Styles.contentWrapper)
            currentWeatherView()
            vbox(alignment = Pos.CENTER) {
                cityLabel = label()
                todayIcon = label()
                todayTemp = label()
                sevenDayLabel = label()
                dividerHB = hbox()
                forcastView = datagrid()
            }
        }
    }

    private fun VBox.currentWeatherView() = vbox {
        form {
            paddingAll = 20.0
            fieldset {
                field("Enter city ", Orientation.VERTICAL) {
                    textfield(controller.selectedCity.name) {
                        this.required()
                        validator {
                            if (it.isNullOrBlank()) error("City field cannot be null")
                            else null
                        }
                        setOnKeyPressed {
                            if (it.code == KeyCode.ENTER) {
                                controller.selectedCity.commit {
                                    runAsync {
                                        controller.allWeather = controller.listPayload(controller.selectedCity.name.value)
                                    } ui {
                                        forcastPayload = controller.allWeather[0]
                                        vbox {
                                            cityLabel.text = forcastPayload.city.name + " , " +
                                                    forcastPayload.city.country + " , " +
                                                    controller.getFormattedData(forcastPayload.lista[0].dt.toLong())
                                            cityLabel.apply {
                                                addClass(Styles.mainLabel)
                                            }
                                            val file = File("src/main/resources/icons/${controller.getIcon(
                                                    forcastPayload.lista[0].weather[0].main
                                            )}.png")
                                            todayIcon.graphic = imageview(file.toURI().toURL().toExternalForm(), lazyload = true){
                                                fitHeight = 200.0
                                                fitWidth = 200.0
                                            }
                                            paddingBottom = 10.0

                                            todayTemp.text = "${forcastPayload.lista[0].temp.day} F " +
                                                    forcastPayload.lista[0].weather[0].description
                                            todayTemp.apply {
                                                addClass(Styles.mainLabel)
                                            }

                                            dividerHB.style{
                                                borderColor += box(Color.TRANSPARENT, Color.TRANSPARENT,
                                                Color.GRAY, Color.TRANSPARENT)
                                            }
                                            sevenDayLabel.text = " 7-Day Weather Forecast"
                                            sevenDayLabel.style{
                                                fill = Color.GREY
                                                fontStyle = FontPosture.ITALIC
                                                opacity = 0.7
                                            }

                                            forcastView.items = forcastPayload.lista.observable()
                                            forcastView.apply {
                                                cellWidth = 120.0
                                                cellHeight = 200.0
                                                cellCache{
                                                    stackpane {
                                                        vbox(alignment = Pos.TOP_CENTER) {
                                                            paddingAll = 10.0
                                                            label(controller.getDay(it.dtProperty.value.toLong()))
                                                        label{
                                                            val file = File("src/main/resources/icons/${controller.getIcon(
                                                                    it.weather[0].main
                                                            )}.png")
                                                            graphic = imageview(file.toURI().toURL().toExternalForm(), lazyload = true){
                                                                fitHeight = 70.0
                                                                fitWidth = 70.0
                                                            }
                                                        }

                                                        }
                                                        vbox(alignment = Pos.CENTER){
                                                            paddingTop = 80.0
                                                            label(it.temp.minProperty).apply {
                                                                graphic = FontAwesomeIconView(FontAwesomeIcon.LONG_ARROW_DOWN)
                                                            }
                                                            label(it.temp.maxProperty).apply {
                                                                graphic = FontAwesomeIconView(FontAwesomeIcon.LONG_ARROW_UP)
                                                            }
                                                            label{
                                                                this.textProperty().bind(Bindings.concat("Hum: ", it.humidityProperty ))
                                                            }
                                                        }

                                                    }
                                                }
                                             }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}