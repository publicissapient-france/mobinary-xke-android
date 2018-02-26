package fr.xebia.pairs

import fr.xebia.HeroOuterClass
import io.reactivex.Observable
import retrofit2.http.GET


interface Service {
    @GET("/")
    fun getGame(): Observable<HeroOuterClass.Hero>
}