package com.example.models

class Ticket {
    private var ticketNumber: Int = 1
    private var spotNumber: Int = 1
    private  var dateTimeHours: Int = 0

    fun getTicketNo(): Int {
        return ticketNumber++
    }

    fun getDateTimeHours(): Int {
        return dateTimeHours
    }

    fun getSpotNumber(): Int {
        return spotNumber
    }

    fun setTicketNumber(value: Int) {
        ticketNumber = value
    }
    fun setDateTimeHours(value: Int) {
        dateTimeHours = value
    }

    fun setSpotNumber(value: Int) {
        spotNumber = value
    }

}