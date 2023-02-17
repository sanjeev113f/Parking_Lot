package com.example.services
import com.example.models.Ticket
import com.example.models.Receipt
import java.util.*

class ParkingService {
    private val slotsCount = 100
    private val slots = IntArray(slotsCount)
    private var ticketNumber=0
    private var receiptNumber=0

    fun findSpot(): Int {
        var i = 1
        while (i < slotsCount) {
            if (slots[i] == 0) return i
            i++
        }
        return i
    }
    fun isSpotAvailable(): Boolean {
        var i = 1
        while (i < slotsCount) {
            if (slots[i] == 0) return true
            i++
        }
        return false
    }

    fun cleanSpots() {
        for (i in 0 until slotsCount) {
            slots[i] = 0
        }
    }

    fun assignAllSpot()
    {
        for (i in 0..slotsCount) {
            slots[i] = 1
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
        val date = Date()
        assignSpot(spotNumber)
        return Ticket(ticketNumber, spotNumber, date)
    }
    fun generateReceipt(entryTime: Date): Receipt {
        val receipt = Receipt()
        receipt.receiptNumber= getReceiptsNo()
        receipt.entryDateTime= entryTime
        receipt.exitDateTime = Date()
        receipt.fees = 10
        return receipt
    }
    private fun getTicketNo(): Int {
        ticketNumber++
        return ticketNumber
    }
    private fun getReceiptsNo(): Int {
        receiptNumber++
        return receiptNumber

    }

}