package com.mzouink.tornado.datacontrols.view

import com.mzouink.tornado.datacontrols.controllers.MainController
import com.mzouink.tornado.datacontrols.model.Student
import com.mzouink.tornado.datacontrols.model.StudentModel
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDate

class StudentEditor : View("My View") {
    val mainController: MainController by inject()

    val model : StudentModel by inject()

    override val root = form {
        fieldset {
            field("First Name") {
                textfield(model.firstName) { }
            }
            field("Last Name") {
                textfield(model.lastName) { }
            }
            field("Date of Birth") {
                datepicker(model.birthday) { }
            }
        }
        button("Save") {
            action {
                if (model.firstName.value.isNullOrEmpty() || model.lastName.value.isNullOrEmpty()) {

                } else {
                    val student = Student(1, model.firstName.value, model.lastName.value, model.birthday.value)
                    mainController.addStudent(student)
                }
            }
        }

    }
}
