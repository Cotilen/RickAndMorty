package br.senai.sp.jandira.ryckandmorty.service

import br.senai.sp.jandira.ryckandmorty.model.CharacterList
import retrofit2.Call
import retrofit2.http.GET

interface CharacterService {

    @GET("character")
    fun getCharacters():Call<CharacterList>

    @GET("character/{id}")
    fun getCharater():Call<br.senai.sp.jandira.ryckandmorty.model.Character>
}
