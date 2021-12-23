package com.ihuman.apps.corrutinas_flow

object Utils {
    val SEPARATOR = "===================================="

    fun newTopic(topic : String = "") {
        println("\n $SEPARATOR \n $topic \n $SEPARATOR")
    }
}