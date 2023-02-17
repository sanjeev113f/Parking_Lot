package com.example.services

import com.example.models.ParkingLot

class ParkingService {
    private val parkingLot = ParkingLot()
    private val slotCount = parkingLot.getSlotsCount()
    private val slots = parkingLot.getSlots()

    fun findSpot(): Int {
        var i = 1
        while (i < slotCount) {
            if (slots[i] == 0) return i
            i++
        }
        return i
    }
    fun isSpotAvailable(): Boolean {
        var i = 1
        while (i < slotCount) {
            if (slots[i] == 0) return true
            i++
        }
        return false
    }

    fun cleanSpots() {
        for (i in 0 until slotCount) {
            slots[i] = 0
        }
    }

    fun assignAllSpot()
    {
        for (i in 0..slotCount) {
            slots[i] = 1
        }
    }

    fun assignSpot(spotNumber: Int) {
        slots[spotNumber ] = 1
    }

    fun unAssignSpot(spotNumber: Int) {
        slots[spotNumber ] = 0
    }


}