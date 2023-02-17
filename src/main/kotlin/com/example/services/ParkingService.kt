package com.example.services
import com.example.models.Ticket
import com.example.models.Receipt
import java.util.*

class ParkingService {
    private val slotsCount = 100
    private val slots = IntArray(slotsCount)
    private var ticketNumber = 1
    private var hourRate:Int = 10
    private var receiptNumber = 1
    private val now = Calendar.getInstance()

    fun findSpot(): Int {
        var spotIndex = 1
        while (spotIndex < slotsCount) {
            if (slots[spotIndex] == 0) return spotIndex
            spotIndex++
        }
        return spotIndex
    }

    fun isSpotAvailable(): Boolean {
        var spotIndex = 1
        while (spotIndex < slotsCount) {
            if (slots[spotIndex] == 0) return true
            spotIndex++
        }
        return false
    }

    fun cleanSpots() {
        for (spot in 0 until slotsCount) {
            slots[spot] = 0
        }
        ticketNumber=1
        receiptNumber=1
    }

    fun assignAllSpot()
    {
        for (spot in 0 until slotsCount) {
            slots[spot] = 1
        }
    }

    fun assignSpot(spotNumber: Int) {
        slots[spotNumber ] = 1
    }

    fun unAssignSpot(spotNumber: Int) {
        slots[spotNumber ] = 0
    }

    fun generateTicket(): Ticket {
        val spotNumber = findSpot()
        val ticketNumber = getTicketNo()
        var hours:Int = now.get(Calendar.HOUR_OF_DAY)
        val min = now.get(Calendar.MINUTE)
        if(min>0) hours++
        assignSpot(spotNumber)
        return Ticket(ticketNumber, spotNumber, hours)
    }

    fun generateReceipt(entryTime: Int): Receipt {
        val receipt = Receipt()
        receipt.receiptNumber = getReceiptsNo()
        receipt.entryDateTimeHours = entryTime
        var hours = now.get(Calendar.HOUR_OF_DAY)
        val min = now.get(Calendar.MINUTE)
        if(min>0) hours++
        receipt.exitDateTimeHours = hours
        receipt.fees = hourRate* (hours- entryTime)
        return receipt
    }

    private fun getTicketNo(): Int {
        return ticketNumber++
    }

    private fun getReceiptsNo(): Int {
        return receiptNumber++
    }

}