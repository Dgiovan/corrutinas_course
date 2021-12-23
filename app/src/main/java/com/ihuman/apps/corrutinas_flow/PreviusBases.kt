package com.ihuman.apps.corrutinas_flow

import com.ihuman.apps.corrutinas_flow.Utils.SEPARATOR
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.security.auth.callback.Callback
import kotlin.concurrent.thread
import kotlin.random.Random

fun main(){


   // lambda()
   // threads()
    coroutinesVsThreads()
}
fun coroutinesVsThreads() {
    newTopic("corutines vs threads")
   /* (1..1_000_000).forEach{
        thread{
            Thread.sleep(someTime())
            println("*")
        }
    }*/
    runBlocking { (1..1_000_000).forEach {
        launch {
            delay(someTime())
            print("*")
        }
    } }
}

fun newTopic(topic : String = "") {
    println("\n $SEPARATOR \n $topic \n $SEPARATOR")
}

fun threads() {
   // print(multiThread(2,3))
    multiThreadLambda(2,6){result ->
        print("resultado thread y lambda $result")
    }
}

fun multiThread(x: Int, y: Int): Int {
    //Sincrono en hilo principal
    var result = 0
    thread {
        Thread.sleep(someTime())
        result = x*y
    }
    Thread.sleep(2_100)
    return result
}
fun multiThreadLambda(x: Int, y: Int, callback : (result: Int) ->Unit) {
    //asincrono (multitareas)
    var result = 0
    thread {
        Thread.sleep(someTime())
        result = x*y
        callback(result)
    }

}

fun someTime(): Long = Random.nextLong(500,2_000)

fun lambda() {
    println(multi(2,3))

    multiLambda(2,3){ result ->
        print(result)
    }
}
//funciones de tipo
fun multiLambda(i: Int, i1: Int,callback : (result :Int) -> Unit){
    callback(i*i1)
}

fun multi(x: Int, y: Int): Int = x*y


//