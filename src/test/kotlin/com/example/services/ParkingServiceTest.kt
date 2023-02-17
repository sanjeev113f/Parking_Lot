package com.example.services
import com.example.models.ParkingLot
import com.example.models.Ticket
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@MicronautTest
class ParkingTest {
    private val parkingService = ParkingService()
    private val parkingLot = ParkingLot()

    @BeforeEach
    fun clear() {
        parkingService.cleanSpots()
    }

    @Test
    fun `should return true if vacant spot is available`() {
        val slotAvailability = parkingService.isSpotAvailable()

        assertEquals(true, slotAvailability)
    }

    @Test
    fun `should return false when no slot is vacant`() {
        parkingService.assignAllSpot()
        val slotAvailability = parkingService.isSpotAvailable()

        assertEquals(false, slotAvailability)
    }

    @Test
    fun `should be able to assign a spot`() {
        parkingService.assignSpot(1)
        val nextAvailableSpot = parkingService.findSpot()

        assertEquals(2,nextAvailableSpot)
    }

    @Test
    fun `should be able to unAssign spot`() {
        parkingService.assignSpot(1)
        parkingService.assignSpot(2)
        parkingService.unAssignSpot(2)
        val nextAvailableSpot = parkingService.findSpot()

        assertEquals(2,nextAvailableSpot)
    }

    @Test
    fun `should be able to generate ticket`() {
        val  ticketGenerated = parkingService.generateTicket()

        assertEquals(ticketGenerated.getDateTimeHours, 16)
        assertEquals(ticketGenerated.ticketNumber, 1)
        assertEquals(ticketGenerated.spotNumber, 1)
    }

    @Test
    fun `should be able to generate a receipt`() {
        val ticket = Ticket(1, 1, 10)
        val receipt = parkingLot.unPark(ticket)

        assertEquals(receipt.receiptNumber , 1)
        assertEquals(receipt.fees, 60)
        assertEquals(receipt.entryDateTimeHours, 10)
        assertEquals(receipt.exitDateTimeHours, 16)
    }
}