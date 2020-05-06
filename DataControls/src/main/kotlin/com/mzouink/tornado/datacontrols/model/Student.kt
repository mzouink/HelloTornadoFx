package com.mzouink.tornado.datacontrols.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import java.time.LocalDate
import tornadofx.*
import java.time.Period

class Student( id: Int,  firstName: String,  lastName: String,  birthday: LocalDate) {

    val idProperty  = SimpleIntegerProperty(id)
    var id : Int by idProperty

    val firstNameProperty = SimpleStringProperty(firstName)
    var firstName by firstNameProperty

    val lastNameProperty = SimpleStringProperty(lastName)
    var lastName by lastNameProperty

    var birthdayProperty = SimpleObjectProperty(birthday)
    var birthday by birthdayProperty

    val age: Int get() = Period.between(birthday, LocalDate.now()).years
}


class StudentModel : ItemViewModel<Student>(){

    val id = bind { item?.idProperty }
    val firstName = bind { item?.firstNameProperty }
    val lastName = bind { item?.lastNameProperty }
    val birthday = bind { item?.birthdayProperty }

}