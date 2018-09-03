package micro.apps.guestbook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GuestbookApp


fun main(args: Array<String>) {
    runApplication<GuestbookApp>(*args)
}
