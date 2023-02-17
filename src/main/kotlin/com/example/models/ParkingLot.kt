package com.example.models
import com.example.services.ParkingService

class ParkingLot{
    private val parkingService = ParkingService()

    fun park() :Ticket{
        val vacantSpot = parkingService.findSpot()
        parkingService.assignSpot(vacantSpot)
        return parkingService.generateTicket()
    }

    fun unPark(ticket: Ticket): Receipt {
        val entryTime = ticket.entryDateTimeHours
        return parkingService.generateReceipt(entryTime)

    }
}