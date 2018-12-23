package com.example.titovtima.mathgame

fun numToAlgTopic(n : Int) =
    when (n){
        1 -> "Тема 1"
        2 -> "Тема 2"
        else -> ""
    }

fun numToGeomTopic(n : Int) =
    when (n){
        1 -> "Тема 1"
        2 -> "Тема 2"
        else -> ""
    }

object StatusCode{
    var xp = 0
    val completeAlg : Array<Array<Boolean>> = Array(Constants.kolAlgTopics, { i -> Array(Constants.kolAlgTasks[i], {false})})
    val completeGeom : Array<Array<Boolean>> = Array(Constants.kolGeomTopics, { i -> Array(Constants.kolGeomTasks[i], {false})})
//    val completeGeom = Array(Constants.kolGeomTopics,{0})
}