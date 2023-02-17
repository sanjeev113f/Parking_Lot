package com.example
import com.example.models.ParkingLot

fun main() {
    val receiptGenerated = mutableMapOf<String,String>()
    val parkingLot= ParkingLot()
    val ticket = parkingLot.park()
    val receipt = parkingLot.unPark(ticket)
    receiptGenerated["receiptNumber"] = receipt.receiptNumber.toString()
    receiptGenerated["entryTime"] = receipt.entryDateTimeHours.toString()
    receiptGenerated["exitTime"] = receipt.exitDateTimeHours.toString()
    receiptGenerated["fees"] = receipt.fees.toString()

    println(receiptGenerated)

}

