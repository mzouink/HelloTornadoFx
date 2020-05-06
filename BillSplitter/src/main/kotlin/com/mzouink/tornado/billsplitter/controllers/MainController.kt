package com.mzouink.tornado.billsplitter.controllers

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import tornadofx.*

class MainController : Controller(){
    var totalPerPerson  = SimpleDoubleProperty(0.0)
    var tipPercentageAmount = SimpleDoubleProperty(0.0)
    var sliderPercentageAmount = SimpleIntegerProperty(0)

    fun calculate(billAmount: SimpleDoubleProperty, splitBy: SimpleIntegerProperty, tipPercentage:SimpleIntegerProperty){
        tipPercentageAmount.cleanBind( (billAmount*tipPercentage/100))
        totalPerPerson.cleanBind(((tipPercentageAmount.value.toProperty()+billAmount)/splitBy))
        sliderPercentageAmount.cleanBind(tipPercentage)
    }

}