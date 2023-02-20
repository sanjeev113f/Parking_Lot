package com.example
import com.example.models.ParkingLot
import com.example.models.Vehicle

fun main() {
    val receiptGenerated = mutableMapOf<String,String>()
    val parkingLot= ParkingLot()
    val vehicle = Vehicle()
    val ticket = vehicle.park()
    if(ticket == null)
        println("parking slot is full")
    else {

        val receipt = vehicle.unPark(ticket)
        receiptGenerated["receiptNumber"] = receipt.getReceiptsNo().toString()
        receiptGenerated["entryTime"] = receipt.getEntryDateTimeHours().toString()
        receiptGenerated["exitTime"] = receipt.getExitDateTimeHours().toString()
        receiptGenerated["fees"] = receipt.getFees().toString()

        println(receiptGenerated)
    }

}

