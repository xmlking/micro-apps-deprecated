package micro.apps.guestbook

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.boot.runApplication

// Since shared lib's package layout is not at the same level of this class, we need to specify `scanBasePackages`
@SpringBootApplication(scanBasePackages = ["micro.apps.guestbook"])
class GuestbookApi {

    @Bean
    fun commonTags(): MeterRegistryCustomizer<MeterRegistry> {
        return MeterRegistryCustomizer { registry ->
            registry.config()
                .commonTags("application", "Guestbook-app")
        }
    }

}

fun main(args: Array<String>) {
    runApplication<GuestbookApi>(*args)
}
