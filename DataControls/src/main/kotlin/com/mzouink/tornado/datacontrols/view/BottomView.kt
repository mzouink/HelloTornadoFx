package com.mzouink.tornado.datacontrols.view

import com.mzouink.tornado.datacontrols.controllers.MainController
import javafx.beans.property.SimpleStringProperty
import tornadofx.*


class BottomView : View(" My view") {

    val mainController: MainController by inject()

    val firstname = SimpleStringProperty()
    val lastname = SimpleStringProperty()

    override val root: Form = form {
        fieldset {
            field("Add First Name") {
                textfield(firstname)
            }
            field("Add last name") {
                textfield(lastname)
            }
        }

        hbox {
            button {
                text = " Save Student"
                action {
                    if(firstname.value.isNullOrEmpty() || lastname.value.isNullOrEmpty()){

                    }else{
                        val fullname : String = firstname.value + " " + lastname.value
                        mainController.addStudent(fullname)
                        firstname.value = ""
                        lastname.value = ""

                    }
                }
            }
        }
    }
}