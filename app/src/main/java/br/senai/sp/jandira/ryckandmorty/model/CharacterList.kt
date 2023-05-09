package br.senai.sp.jandira.ryckandmorty.model

data class CharacterList(

    //Pega os objetos contidos na URL da API
    val info: Info,
    val results :List<Character>

)
