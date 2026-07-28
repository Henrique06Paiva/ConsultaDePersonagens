package dev.henrique.consultadepersonagens.data.remote

import dev.henrique.consultadepersonagens.data.model.CharacterResponse
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}