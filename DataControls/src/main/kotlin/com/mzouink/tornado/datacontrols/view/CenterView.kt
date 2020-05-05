package com.mzouink.tornado.datacontrols.view

import com.mzouink.tornado.datacontrols.controllers.MainController
import com.mzouink.tornado.datacontrols.model.Student
import tornadofx.*

class CenterView : View("My View") {

    val mainController : MainController by inject()

    override val root = tableview<Student> {
        items = mainController.studentsData

        isEditable = true
        column("ID",Student::idProperty)
        column("First name",Student::firstNameProperty)
        column("Last name",Student::lastNameProperty)
        readonlyColumn("Age",Student::age)
    }
}
