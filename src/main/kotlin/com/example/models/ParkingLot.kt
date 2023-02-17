package com.example.models
import com.example.services.ParkingService

class ParkingLot{
    private val slotsCount = 100
    private val rate = 10
    private val currentCountOfVehicle=0
    private var vehicle = Vehicle("car")
    private val parkingService = ParkingService()

    fun park() :Ticket{
        val vacantSpot = parkingService.findSpot()
        parkingService.assignSpot(vacantSpot)
        return parkingService.generateTicket()
    }

    fun unPark(ticket: Ticket): Receipt {
        var entryTime = ticket.entryDateTime
        return parkingService.generateReceipt(entryTime)

    }
}