package com.example.manager_incomeexpense

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(
    context: Context?

) : SQLiteOpenHelper(context, "Naman.db", null, 1) {

    var TABLE_NAME = "Trans"
    var ID = "id"
    var AMOUNT = "amount"
    var CATEGORY = "category"
    var NOTE = "note"
    var IS_EXPENSE = "isExpense"
    override fun onCreate(p0: SQLiteDatabase?) {

        var que = "CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY AUTOINCREMENT, $AMOUNT INTEGER, $CATEGORY TEXT, $NOTE TEXT, $IS_EXPENSE INTEGER)"
        p0?.execSQL(que)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}