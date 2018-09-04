package micro.apps.shared

import java.math.BigDecimal
import java.time.Instant

// ----------------
//  for Kotlin Gradle NoArg plugin
// ----------------
annotation class NoArg

@NoArg
class Test(val id: Int)

data class Quote(val ticker: String, val price: BigDecimal, val instant: Instant = Instant.now())
