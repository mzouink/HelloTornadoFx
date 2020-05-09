package com.mzouink.tornado.budgetapp.model

import com.mzouink.tornado.budgetapp.util.toJavaLocalDate
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import tornadofx.*
import java.time.LocalDate

fun ResultRow.toExpensesEntry() = ExpensesEntry(
        this[ExpensesEntryTbl.id],
        this[ExpensesEntryTbl.entryDate].toJavaLocalDate(),
        this[ExpensesEntryTbl.itemName],
        this[ExpensesEntryTbl.itemPrice].toDouble()

)

object ExpensesEntryTbl : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val entryDate = date("entry_date")
    val itemName = varchar("name", length = 50)
    val itemPrice = decimal("price", scale = 2, precision = 9)
}

class ExpensesEntry(id: Int, entryDate: LocalDate, itemName: String, itemPrice: Double) {
    val idProperty = SimpleIntegerProperty(id)
    var id by idProperty

    val entryDateProperty = SimpleObjectProperty<LocalDate>(entryDate)
    var entryDate by entryDateProperty

    val itemPriceProperty = SimpleDoubleProperty(itemPrice)
    var itemPrice by itemPriceProperty

    val itemNameProperty = SimpleStringProperty(itemName)
    var itemName by itemNameProperty

    override fun toString(): String {
        return "ExpensesEntry(id=$id, entryDate=$entryDate, itemName=$itemName, itemPrice=$itemPrice"
    }
}

class ExpensesEntryModel : ItemViewModel<ExpensesEntry>() {
    val id = bind { item?.idProperty }
    val entryDate = bind { item?.entryDateProperty }
    val itemPrice = bind { item?.itemPriceProperty }
    val itemName = bind { item?.itemNameProperty }
}