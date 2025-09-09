package com.iie.st10032501.kentonskoffee

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class OrderEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    var productName: String,
    var customerName: String,
    var customerCell: String,
    var orderDate: String
)