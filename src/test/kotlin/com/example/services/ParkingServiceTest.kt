package com.example.services
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@MicronautTest
class ParkingTest {
    private val parkingService = ParkingService()

    @BeforeEach
    fun clear() {
        parkingService.cleanSpots()
    }
    @Test
    fun `should be able to check if vacant spot is available`() {
        val slotAvailability = parkingService.isSpotAvailable()

        assertEquals(true, slotAvailability)
    }
    @Test
    fun `should not be able to find spot when no slot is vacant`() {
        parkingService.assignAllSpot()
        val slotAvailability = parkingService.isSpotAvailable()

        assertEquals(false, slotAvailability)
    }

}