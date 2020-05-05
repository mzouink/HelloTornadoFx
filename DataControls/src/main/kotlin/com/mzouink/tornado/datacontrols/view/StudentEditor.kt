package com.mzouink.tornado.datacontrols.view

import com.mzouink.tornado.datacontrols.controllers.MainController
import com.mzouink.tornado.datacontrols.model.Student
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDate

class StudentEditor : View("My View") {
    val mainController: MainController by inject()
    val firstname = SimpleStringProperty()
    val lastname = SimpleStringProperty()
    val dob = SimpleObjectProperty<LocalDate>()

    override val root = form {
        fieldset {
            field("First Name") {
                textfield(firstname) { }
            }
            field("Last Name") {
                textfield(lastname) { }
            }
            field("Date of Birth") {
                datepicker(dob) { }
            }
        }
        button("Save") {
            action {
                if (firstname.value.isNullOrEmpty() || lastname.value.isNullOrEmpty()) {

                } else {
                    val student = Student(1, firstname.value, lastname.value, dob.value)
                    mainController.addStudent(student)
                }
            }
        }

    }
}
