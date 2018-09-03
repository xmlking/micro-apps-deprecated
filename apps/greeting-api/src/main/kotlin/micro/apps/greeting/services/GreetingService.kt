package micro.apps.greeting.services

import io.reactivex.Single
import javax.inject.Singleton

@Singleton
internal class GreetingService {

    fun message(name: String = "World"): Single<String> {
        return Single.just("Hello $name")
    }
}
