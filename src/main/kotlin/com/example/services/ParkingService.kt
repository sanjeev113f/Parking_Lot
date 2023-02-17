package com.example.services
import com.example.models.Ticket
import com.example.models.Receipt
import java.util.*
import kotlin.math.max

class ParkingService {
    private val slotsCount = 100
    private val slots = IntArray(slotsCount)
    private var ticketNumber=0
    private var hourRate:Int = 10
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
        for (i in 0 until slotsCount) {
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
        val now = Calendar.getInstance()
        val hours:Int= now.get(Calendar.HOUR_OF_DAY)
        assignSpot(spotNumber)
        return Ticket(ticketNumber, spotNumber, hours)
    }
    fun generateReceipt(entryTime: Int): Receipt {
        val receipt = Receipt()
        receipt.receiptNumber= getReceiptsNo()
        receipt.entryDateTimeHours= entryTime
        val now = Calendar.getInstance()
        val hours = now.get(Calendar.HOUR_OF_DAY)
        receipt.exitDateTimeHours =hours
        receipt.fees = hourRate* max(1,receipt.exitDateTimeHours!! -entryTime)
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