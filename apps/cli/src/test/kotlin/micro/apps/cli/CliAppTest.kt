package micro.apps.cli

import kotlin.test.Test
import kotlin.test.assertNotNull

class CliAppTest {
    @Test fun testAppHasAGreeting() {
        val classUnderTest = CliApp()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }
}
