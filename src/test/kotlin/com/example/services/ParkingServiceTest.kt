package com.example.services
import com.example.models.ParkingLot
import com.example.models.Ticket
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

@MicronautTest
class ParkingTest {
    private val parkingService = ParkingService()
    private val parkingLot = ParkingLot()
    private val now = Calendar.getInstance()
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
        var hours:Int = now.get(Calendar.HOUR_OF_DAY)
        val min = now.get(Calendar.MINUTE)
        if(min>0) hours++
        val ticketGenerated = parkingLot.park()
        val expectedTicket = Ticket(1,1,ticketGenerated.entryDateTimeHours)
        assertEquals(expectedTicket, ticketGenerated)
    }
}