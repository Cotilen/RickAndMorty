package br.senai.sp.jandira.ryckandmorty.model

data class Info(
    val count:Int,
    val pages:Int,
    //A interrogação significa que esses valores podem ser nulos
    val next:String?,
    val prev:String?
)
