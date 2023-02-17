package com.example
import com.example.models.ParkingLot

fun main() {
    val output = mutableMapOf<String,String>()
    val parkingLot= ParkingLot()
    val ticket = parkingLot.park()
    val receipt = parkingLot.unPark(ticket)
    println(ticket.entryDateTime)
    output["receiptNumber"]= receipt.receiptNumber.toString()
    output["entryTime"]= receipt.entryDateTime.toString()
    output["exitTime"]= receipt.exitDateTime.toString()
    println(output)

}

