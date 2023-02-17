package com.example.models

class Ticket(private var ticketNumber: Int?, private var spotNumber: Int?, var entryDateTimeHours: Int) {
    fun getTicketNo(): Int? {
        return ticketNumber
    }
    fun getSpotNo(): Int? {
        return spotNumber
    }

    fun entryDateNo(): Int {
        return entryDateTimeHours
    }
}