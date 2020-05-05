package com.mzouink.tornado.datacontrols.controllers

import javafx.collections.FXCollections
import tornadofx.*

class MainController : Controller(){
    val students = FXCollections.observableArrayList<String>(
            "Marwan","Majdi","Mohsen","Mokdad","Mala"
    )

    fun addStudent(fullName : String){
        students.add(fullName)
    }

}