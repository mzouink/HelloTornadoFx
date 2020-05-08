package com.mzouink.tornado.budgetapp.app

import com.mzouink.tornado.budgetapp.util.createTables
import javafx.scene.control.TabPane
import org.jetbrains.exposed.sql.Database
import tornadofx.*

class BudgetTrackerWorkspace : Workspace("Budget Tracker Workspace", NavigationMode.Tabs) {
  init {
      // init db
      Database.connect("jdbc:sqlite:./app-budget-tracker.db","org.sqlite.JDBC")
      createTables()
      // controller(es)

      // doc our views

      tabContainer.tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
  }
}
