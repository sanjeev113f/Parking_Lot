package com.example.models

data class Ticket(private var ticketNumber: Int, private var spotNumber: Int, var getDateTimeHours: Int) {
    fun getTicketNo(): Int {
        return ticketNumber
    }
    fun getSpotNo(): Int {
        return spotNumber
    }

    fun entryDateNo(): Int {
        return getDateTimeHours
    }
}