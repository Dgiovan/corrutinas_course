package com.ihuman.apps.corrutinas_flow

import kotlinx.coroutines.*

fun main(){
    // globalScope()
    //suspendFun()
    newTopic("Constructores de corrutinas")
    //cRunBlocking()
    //cLaunch()
    cAsync()
    readLine()
}

fun cAsync() {
    /**Async esta diseñado para emitir un resultado*/
    runBlocking {
        newTopic("Async")
        val result =  async {
            startMsg()
            delay(someTime())
            println("Async...")
            endMsg()
            obj("hola gioooooo")
        }
        println("result -> ${result.await()}")

    }

}
data class obj(val i : String ="")

fun cLaunch() {
    //solo se ejecuta dentro de una funcion suspendida o dentro de una corrutina
    /**Launch no emite un resultado solo ejectua el precesos puede ser un Trigger para otro evento
     * ejemplo recoleccion de datos*/
    runBlocking {
        newTopic("Launch")
        launch {
            startMsg()
            delay(someTime())
            println("Launch...")
            endMsg()
        }
    }
}

fun cRunBlocking() {
    newTopic("Run blocking")
    /**utilizar construccion para pruebas o educativo*/
    runBlocking {
        startMsg()
        delay(someTime())
        println("runBlocking...")
        endMsg()
    }
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