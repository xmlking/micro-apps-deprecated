package micro.apps.guestbook

import io.micronaut.runtime.Micronaut

object GuestbookApp {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
            .packages("micro.apps.guestbook")
            .mainClass(GuestbookApp.javaClass)
            .start()
    }
}
