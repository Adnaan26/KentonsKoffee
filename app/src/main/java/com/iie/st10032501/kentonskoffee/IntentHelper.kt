package com.iie.st10032501.kentonskoffee

import android.content.Context
import android.content.Intent
import android.os.Bundle


fun openIntent(context: Context, order: String, activityToOpen: Class<*>){
    val intent = Intent(context, activityToOpen)
    intent.putExtra("order", order)

    if(context !is android.app.Activity){
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    context.startActivity(intent)
}

fun shareIntent(context: Context, order: String){
    val sendIntent = Intent()

    sendIntent.action= Intent.ACTION_SEND
    sendIntent.putExtra(Intent.EXTRA_TEXT, order)
    sendIntent.type = "text/plain"

    val shareIntent = Intent.createChooser(sendIntent, null)

    if(context !is android.app.Activity){
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    context.startActivity(shareIntent)
}

fun shareIntent(context: Context, order: Order){
    val sendIntent = Intent()
    sendIntent.action = Intent.ACTION_SEND

    val shareOrderDetails = Bundle() // Using Bundle to share multiple details
    shareOrderDetails.putString("productName", order.productName)// Assuming Order has a productName property
    shareOrderDetails.putString("customerName", order.customerName)// Assuming Order has a customerName property
    shareOrderDetails.putString("customerCell", order.customerCell)// Assuming Order has a customerCell property

    sendIntent.putExtra(Intent.EXTRA_TEXT, shareOrderDetails)// Convert Bundle to String or use a custom format
    sendIntent.type = "text/plain"

    val shareIntent = Intent.createChooser(sendIntent, null)

    // Check if the context is not an Activity to avoid crashing
    if(context !is android.app.Activity){
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    context.startActivity(shareIntent)

}