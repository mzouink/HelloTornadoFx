package com.mzouink.tornado.datacontrols.view

import com.mzouink.tornado.datacontrols.controllers.MainController
import com.mzouink.tornado.datacontrols.model.Student
import com.mzouink.tornado.datacontrols.model.StudentModel
import tornadofx.*

class StudentEditor : View("My View") {
    val mainController: MainController by inject()

    //    val firstname = SimpleStringProperty()
//    val lastname = SimpleStringProperty()
//    val dob = SimpleObjectProperty<LocalDate>()
    val model: StudentModel by inject()

    override val root = form {
        fieldset {
            field("First Name") {
                textfield(model.firstName) {
                    required()
//                    or use
//                    validator {
//                        if(it.isNullOrBlank()) error("This is required") else null
//                    }
                }
            }
            field("Last Name") {
                textfield(model.lastName).required()
            }
            field("Date of Birth") {

                datepicker(model.birthday).required()
            }
        }
        hbox {
            button("Save") {
                enableWhen(model.dirty)
                action {
                    model.commit {
                        val student = Student(1, model.firstName.value, model.lastName.value, model.birthday.value)
                        mainController.addStudent(student)
                    }
                }
            }
            button("Reset") {
                enableWhen(model.dirty)
                action { model.rollback() }
            }
        }
    }
}
