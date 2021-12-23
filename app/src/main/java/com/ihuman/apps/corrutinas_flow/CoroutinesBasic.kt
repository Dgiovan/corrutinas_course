package com.ihuman.apps.corrutinas_flow

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(){
   // globalScope()
    suspendFun()
    readLine()
}

fun suspendFun() {
    newTopic("suspend")
    /**thread.sleep boquea temporamente el hilo esperando un resultado*/
    Thread.sleep(someTime())
    /**Cuando existe la palabra reservada suspend fun quiere decir que el metodo podra ser pausado
     * hasta  obtener un resultado y el hilo principal podra seguirse ejcutando*/
    //delay(someTime())
    GlobalScope.launch {
    //delay proviene de una suspend fun
        delay(someTime())
    }
}

/**Global scope es una forma de crear una corrutina de la forma mas basica*/
fun globalScope() {
    newTopic("Global Scope")
    //se ejecuta en segundo plano no se recomienda este tipo gasta recursos
    GlobalScope.launch {
        startMsg()
        delay(someTime())
        println("mi corrutina")
        endMsg()
    }
}

fun startMsg() {
    println("comensando corrutina -${Thread.currentThread().name}-")
}
fun endMsg() {
    println("corrutina -${Thread.currentThread().name}- Finalizada ")
}