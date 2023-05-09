package br.senai.sp.jandira.ryckandmorty.service

import br.senai.sp.jandira.ryckandmorty.model.CharacterList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    //https://rickandmortyapi.com/api/
    @GET("character")
    fun getCharacters():Call<CharacterList>

    //https://rickandmortyapi.com/api/character
    @GET("character/{id}")
    // O nome dentro do path tem que ser o mesmo passado no get, ja o do chamado da função não tem a necessidade disso
    // A função desse jeito diz que o id passado na chamada da função sera convertido para o id do Path
    fun getCharater(@Path("id") id: Int):Call<br.senai.sp.jandira.ryckandmorty.model.Character>

    //https://rickandmortyapi.com/api/character/?page=
    @GET("character/")
    fun getCharactersByPage(@Query("page") page: Int):Call<CharacterList>
}
