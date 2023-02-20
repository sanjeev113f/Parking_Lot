package com.example.models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ParkingLotTest {
    private val parkingLot = ParkingLot()

    @BeforeEach
    fun clear() {
        parkingLot.cleanSpots()
    }

    @Test
    fun `should return false if vacant spot is available`() {
        val slotAvailability = parkingLot.isSpotNotAvailable()

        assertEquals(slotAvailability, false)
    }

    @Test
    fun `should return true when no slot is vacant`() {
        parkingLot.assignAllSpot()
        val slotAvailability = parkingLot.isSpotNotAvailable()

        assertEquals(slotAvailability, true)
    }

    @Test
    fun `should be able to assign a spot`() {
        parkingLot.assignSpot(1)
        val nextAvailableSpot = parkingLot.findSpot()

        assertEquals(nextAvailableSpot, 2)
    }

    @Test
    fun `should be able to unAssign spot`() {
        parkingLot.assignSpot(1)
        parkingLot.assignSpot(2)
        parkingLot.unAssignSpot(2)
        val nextAvailableSpot = parkingLot.findSpot()

        assertEquals(nextAvailableSpot, 2)
    }

    @Test
    fun `should be able to generate ticket`() {
        val ticketGenerated = parkingLot.generateTicket()

        if (ticketGenerated != null) {
            assertEquals(ticketGenerated.getDateTimeHours(), 7)
            assertEquals(ticketGenerated.getTicketNo(), 1)
            assertEquals(ticketGenerated.getSpotNumber(), 1)
        }
    }

    @Test
    fun `should be able to generate a receipt`() {
        val ticket = parkingLot.generateTicket()
        if(ticket!= null)
        {
            val receipt = parkingLot.generateReceipt(ticket.getDateTimeHours())
            assertEquals(receipt.getReceiptsNo() , 1)
            assertEquals(receipt.getFees(), 0)
            assertEquals(receipt.getEntryDateTimeHours(), 7)
            assertEquals(receipt.getExitDateTimeHours(), 7)
        }
    }
}