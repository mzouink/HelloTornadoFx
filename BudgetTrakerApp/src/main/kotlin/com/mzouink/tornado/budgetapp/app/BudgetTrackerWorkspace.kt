package com.mzouink.tornado.budgetapp.app

import com.mzouink.tornado.budgetapp.controller.ItemController
import com.mzouink.tornado.budgetapp.model.ExpensesEntryTbl
import com.mzouink.tornado.budgetapp.util.createTables
import com.mzouink.tornado.budgetapp.util.enableConsoleLogger
import com.mzouink.tornado.budgetapp.util.execute
import com.mzouink.tornado.budgetapp.util.toDate
import com.mzouink.tornado.budgetapp.view.ExpensesEditor
import javafx.scene.control.TabPane
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import tornadofx.*
import java.math.BigDecimal
import java.time.LocalDate

class BudgetTrackerWorkspace : Workspace("Budget Tracker Workspace", NavigationMode.Tabs) {
    init {
        // Initialize DB
        enableConsoleLogger()
        Database.connect("jdbc:sqlite:./app-budget-tracker.db", "org.sqlite.JDBC")
        createTables()

        // controller(es)
        ItemController()

        // doc our views
        dock<ExpensesEditor>()

        tabContainer.tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
    }
}
