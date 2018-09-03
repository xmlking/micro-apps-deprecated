package micro.apps.guestbook

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.boot.runApplication

@SpringBootApplication
class GuestbookApp {

    @Bean
    fun commonTags(): MeterRegistryCustomizer<MeterRegistry> {
        return MeterRegistryCustomizer { registry ->
            registry.config()
                .commonTags("application", "Guestbook-app")
        }
    }

}

fun main(args: Array<String>) {
    runApplication<GuestbookApp>(*args)
}
