package micro.apps.greeting.controllers

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Single
import micro.apps.greeting.services.GreetingService
import javax.inject.Inject

@Controller("/greeting")
class GreetingController {

    @Inject
    private var greetingService: GreetingService? = null

    @Get("/")
    fun greeting(): Single<String> {
        return greetingService!!.message()
    }

    @Get("/{name}")
    fun greeting(name: String): Single<String> {
        return greetingService!!.message(name)
    }
}
