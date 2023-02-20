package com.example.models

class Receipt {
    private var receiptNumber = 1
    private var entryDateTimeHours: Int = 1
    private var exitDateTimeHours: Int = 1
    private var fees: Int = 0

    fun getReceiptsNo(): Int {
        return receiptNumber++
    }

    fun getEntryDateTimeHours(): Int {
        return entryDateTimeHours
    }

    fun getExitDateTimeHours(): Int {
        return exitDateTimeHours
    }

    fun getFees(): Int {
        return fees
    }

    fun setReceiptsNo(value: Int) {
        receiptNumber = value
    }

    fun setEntryDateTimeHours(value: Int) {
        entryDateTimeHours = value
    }

    fun setExitDateTimeHours(value: Int) {
        exitDateTimeHours = value
    }

    fun setFees(value: Int)
    {
        fees = value
    }
}