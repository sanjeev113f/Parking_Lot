package com.example.models
import com.example.services.ParkingService

class ParkingLot{
    private val parkingService = ParkingService()

    fun park() :Ticket{
        return parkingService.generateTicket()
    }

    fun unPark(ticket: Ticket): Receipt {
        val entryTime = ticket.entryDateTimeHours
        return parkingService.generateReceipt(entryTime)

    }
}