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
    val completeAlg : Array<Int> = Array(Constants.kolAlgTopics,{0})
    val completeGeom = Array(Constants.kolGeomTopics,{0})
}