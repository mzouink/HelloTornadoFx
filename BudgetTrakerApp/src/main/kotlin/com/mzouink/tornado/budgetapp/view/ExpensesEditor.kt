package com.mzouink.tornado.budgetapp.view

import com.mzouink.tornado.budgetapp.controller.ItemController
import com.mzouink.tornado.budgetapp.model.ExpensesEntryModel
import javafx.geometry.Pos
import javafx.scene.input.KeyCode
import tornadofx.*

class ExpensesEditor : View("Expenses") {
    val model = ExpensesEntryModel()
    val controller: ItemController by inject()

    var mTableView : TableViewEditModel<ExpensesEntryModel> by singleAssign()

    override val root = borderpane {
        center = vbox {
            form {
                fieldset {
                    field("Entry date ") {
                        maxWidth = 220.0
                        datepicker(model.entryDate) {
                            required()
//                            validator {
//                                when {
//                                    it?.dayOfMonth.toString().isEmpty() || it?.dayOfMonth.toString().isNotEmpty() || it?.dayOfYear.toString().isEmpty()
//                                    -> error("The date entry cannot be blank")
//                                    else -> null
//                                }
//                            }
                        }
                    }
                }
                fieldset {
                    field("Item") {
                        maxWidth = 220.0
                        textfield(model.itemName) {
                            required()
                            validator {
                                when {
                                    it.isNullOrEmpty() -> error("Field cannot be empty")
                                    it!!.length < 3 -> error("Too short")
                                    else -> null
                                }
                            }
                        }
                    }
                }
                fieldset {
                    field("Price") {
                        maxWidth = 220.0
                        textfield(model.itemPrice) {
                            required()
                            validator {
                                when (it) {
                                    null -> error("Price cannot be empty")
                                    else -> null
                                }
                            }
                            setOnKeyPressed {
                                if (it.code == KeyCode.ENTER) {
                                    add(model)
                                }
                            }
                        }
                    }
                }
                hbox(10.0) {
                    button("Add item") {
                        enableWhen(model.valid)
                        action {
                            add(model)
                        }
                    }
                    button("Delete") {
                        action {
                            val selectedItem = mTableView.tableView.selectedItem
                            controller.delete(selectedItem!!)
                        }
                    }
                    button("Reset") {
                        enableWhen(model.dirty)
                        action {

                        }
                    }
                }
                fieldset {
                    tableview<ExpensesEntryModel> {
                        items = controller.items
                        mTableView = editModel
                        column("ID", ExpensesEntryModel::id)
                        column("Added", ExpensesEntryModel::entryDate).makeEditable()
                        column("Name", ExpensesEntryModel::itemName).makeEditable()
                        column("Price", ExpensesEntryModel::itemPrice).makeEditable()

                        onEditCommit {
                            controller.update(it)
                            controller.updatePiecePie(it)
                        }
                    }
                }
            }
        }
right = vbox {
    alignment = Pos.CENTER
    piechart {
        data = controller.pieItemsData
//        data("Bananas", 120.0)
//        data("Baanas", 200.0)
//        data("B2nanas", 12.0)
//        data("Ban1anas", 150.0)
    }
}
    }


    private fun add(model: ExpensesEntryModel) {
        model.commit {
            addItem()
            model.rollback()
        }
    }

    private fun addItem() {
        controller.add(model.entryDate.value, model.itemName.value, model.itemPrice.value.toDouble())
    }
}