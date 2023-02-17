package com.example.services

import com.example.models.ParkingLot

class ParkingService {
    private val parkingLot = ParkingLot()
    private val slotCount = parkingLot.getSlotsCount()
    private val slots = parkingLot.getSlots()

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

    }


}