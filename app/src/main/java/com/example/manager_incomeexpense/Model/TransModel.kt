package com.example.manager_incomeexpense.Model

class TransModel {

    var id = 0
    var amount = 0
     var category = ""
     var note = ""
    var isExpense = 0

    constructor(id: Int, amount: Int, category: String, note: String, isExpense: Int) {
        this.id = id
        this.amount = amount
        this.category = category
        this.note = note
        this.isExpense = isExpense
    }
}