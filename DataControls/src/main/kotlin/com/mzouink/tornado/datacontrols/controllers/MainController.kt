package com.mzouink.tornado.datacontrols.controllers

import com.mzouink.tornado.datacontrols.model.Student
import javafx.collections.FXCollections
import tornadofx.*
import java.time.LocalDate

class MainController : Controller() {
    val students = FXCollections.observableArrayList<String>(
            "Marwan","Majdi","Mohsen","Mokdad","Mala"
    )

    val studentsData = FXCollections.observableArrayList<Student>(
            Student(1, "Marwan", "Zouikhi", LocalDate.of(1992, 4, 6)),
            Student(1, "Majdi", "Zouikhi", LocalDate.of(2000, 10, 25)),
            Student(1, "Marwa", "Zouikhi", LocalDate.of(1990, 4, 16)),
            Student(1, "Arij", "Missaoui", LocalDate.of(1998, 8, 14))
    )

    fun addStudent(student: Student) {
        studentsData.add(student)
    }

}