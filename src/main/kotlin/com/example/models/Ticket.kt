package com.example.models
import java.util.Date

class Ticket(private var ticketNumber: Int?, private var spotNumber: Int?, var entryDateTime: Date) {
    fun getTicketNo(): Int? {
        return ticketNumber
    }
    fun getSpotNo(): Int? {
        return spotNumber
    }

    fun entryDateNo(): Date {
        return entryDateTime
    }
}