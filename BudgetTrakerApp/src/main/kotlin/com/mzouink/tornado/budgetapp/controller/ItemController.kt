package com.mzouink.tornado.budgetapp.controller

import com.mzouink.tornado.budgetapp.model.ExpensesEntry
import com.mzouink.tornado.budgetapp.model.ExpensesEntryModel
import com.mzouink.tornado.budgetapp.model.ExpensesEntryTbl
import com.mzouink.tornado.budgetapp.model.toExpensesEntry
import com.mzouink.tornado.budgetapp.util.execute
import com.mzouink.tornado.budgetapp.util.toDate
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.PieChart
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update
import tornadofx.*
import java.math.BigDecimal
import java.time.LocalDate

class ItemController : Controller() {
    var expenseModel = ExpensesEntryModel()

    //    get All Items
    private val listOfItems: ObservableList<ExpensesEntryModel> = execute {
        ExpensesEntryTbl.selectAll().map {
            ExpensesEntryModel().apply {
                item = it.toExpensesEntry()
            }
        }.observable()
    }

    var items: ObservableList<ExpensesEntryModel> by singleAssign()
    var pieItemsData = FXCollections.observableArrayList<PieChart.Data>()

    init {
        items = listOfItems
//        add(LocalDate.now(),"New item",4.45)
//        add(LocalDate.now(),"New item2",23.1)
//        add(LocalDate.now(),"New item3",23.3)
//        add(LocalDate.now(),"New item4",2.45)
//        listOfItems.forEach{
//            print("Item :: ${it.itemName.value}")
//        }

        items.forEach {
            pieItemsData.add(PieChart.Data(it.itemName.value,it.itemPrice.value.toDouble()))
        }
    }

    fun add(newEntryDate: LocalDate, newItem: String, newPrice: Double): ExpensesEntry {
        val newEntry = execute {
            ExpensesEntryTbl.insert {
                it[entryDate] = newEntryDate.toDate()
                it[itemName] = newItem
                it[itemPrice] = BigDecimal.valueOf(newPrice)
            }
        }
        listOfItems.add(ExpensesEntryModel().apply {
            item = ExpensesEntry(newEntry[ExpensesEntryTbl.id], newEntryDate, newItem, newPrice)
        })
        pieItemsData.add(PieChart.Data(newItem,newPrice))
        return ExpensesEntry(newEntry[ExpensesEntryTbl.id], newEntryDate, newItem, newPrice)
    }

    fun update(updatedItem: ExpensesEntryModel): Int {
        return execute {
            ExpensesEntryTbl.update({
                ExpensesEntryTbl.id eq (updatedItem.id.value.toInt())
            }) {
                it[entryDate] = updatedItem.entryDate.value.toDate()
                it[itemName] = updatedItem.itemName.value
                it[itemPrice] = BigDecimal.valueOf(updatedItem.itemPrice.value.toDouble())
            }
        }
    }

    fun delete(model: ExpensesEntryModel) {
        execute {
            ExpensesEntryTbl.deleteWhere {
                ExpensesEntryTbl.id eq (model.id.value.toInt())
            }
        }
        listOfItems.remove(model)
        removeModelFromPie(model)
    }

    private fun removeModelFromPie(model: ExpensesEntryModel) {
        var currentIndex = 0
        pieItemsData.forEachIndexed { index, data ->
            if(data.name == model.itemName.value && index != -1){
                currentIndex = index
            }
        }
        pieItemsData.removeAt(currentIndex)
    }
}