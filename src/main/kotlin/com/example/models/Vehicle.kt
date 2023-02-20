package com.example.models

class Vehicle {
    private val parkingLot = ParkingLot()
    fun park() : Ticket? {
        return parkingLot.generateTicket()
    }

    fun unPark(ticket: Ticket): Receipt {
        val entryTime = ticket.getDateTimeHours()
        return parkingLot.generateReceipt(entryTime)
    }
}

