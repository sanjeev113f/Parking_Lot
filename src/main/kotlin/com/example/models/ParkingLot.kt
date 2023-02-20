package com.example.models
import java.util.*

class ParkingLot{
    private val slotsCount = 100
    private val slots = IntArray(slotsCount)
    private var hourRate:Int = 10
    private val now = Calendar.getInstance()

    fun findSpot(): Int {
        var startIndex = 1
        while (startIndex < slotsCount) {
            if (slots[startIndex] == 0) return startIndex
            startIndex++
        }
        return startIndex
    }

    fun isSpotNotAvailable(): Boolean {
        var startIndex = 1
        while (startIndex < slotsCount) {
            if (slots[startIndex] == 0) return false
            startIndex++
        }
        return true
    }

    fun assignAllSpot()
    {
        for (spot in 0 until slotsCount) {
            slots[spot] = 1
        }
    }

    fun generateTicket(): Ticket? {
        if(isSpotNotAvailable()) return null
        val spotNumber = findSpot()
        val ticket = Ticket()
        val ticketNumber = Ticket().getTicketNo()
        val hours:Int = getHours()
        assignSpot(spotNumber)
        ticket.setTicketNumber(ticketNumber)
        ticket.setSpotNumber(spotNumber)
        ticket.setDateTimeHours(hours)
        return ticket
    }

    fun generateReceipt(entryTime: Int): Receipt {
        val receipt = Receipt()
        receipt.setReceiptsNo(receipt.getReceiptsNo())
        receipt.setEntryDateTimeHours(entryTime)
        val hours = getHours()
        receipt.setExitDateTimeHours(hours)
        receipt.setFees(hourRate* (hours- entryTime))
        return receipt
    }

    fun cleanSpots() {
        for (spot in 0 until slotsCount) {
            slots[spot] = 0
        }
        Ticket().setTicketNumber(1)
        Receipt().setReceiptsNo(1)
    }

    fun assignSpot(spotNumber: Int) {
        slots[spotNumber]=1
    }

    fun unAssignSpot(spotNumber: Int) {
        slots[spotNumber ] = 0
    }

    fun getHours(): Int
    {
        var hour = now.get(Calendar.HOUR_OF_DAY)
        val min = now.get(Calendar.MINUTE)
        if(min>0) hour++
        return hour
    }

}