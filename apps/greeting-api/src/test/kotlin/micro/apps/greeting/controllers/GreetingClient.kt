package micro.apps.greeting.controllers

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.Client
import io.reactivex.Single
import javax.validation.constraints.NotBlank

@Client("/greeting")
interface GreetingClient {

    @Get("/{name}")
    fun greeting(@NotBlank name: String): Single<String>
}
