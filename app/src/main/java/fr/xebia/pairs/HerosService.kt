package fr.xebia.pairs

import fr.xebia.HeroOuterClass
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.protobuf.ProtoConverterFactory


object HerosService {
    private const val SERVER_END_POINT = "http://10.0.2.2:8080"

    private val mGamesRequestInterface = Retrofit.Builder()
            .baseUrl(SERVER_END_POINT)
            .addConverterFactory(ProtoConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(Service::class.java)

    fun getGames(): Observable<HeroOuterClass.Hero> {
        return mGamesRequestInterface.getGame()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }
}