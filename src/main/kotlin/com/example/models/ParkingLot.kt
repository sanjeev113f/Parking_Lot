package com.example.models

class ParkingLot{
    private val slotsCount = 100
    private val rate = 10
    private val slots = IntArray(slotsCount)

    fun getSlotsCount(): Int {
        return slotsCount
    }
    fun getRate(): Int {
        return rate
    }
    fun getSlots(): IntArray {
        return slots
    }


}