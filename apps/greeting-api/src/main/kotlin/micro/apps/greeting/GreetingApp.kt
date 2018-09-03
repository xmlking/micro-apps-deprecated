package micro.apps.greeting

import io.micronaut.runtime.Micronaut

object GreetingApp {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
            .packages("micro.apps.greeting")
            .mainClass(GreetingApp.javaClass)
            .start()
    }
}
