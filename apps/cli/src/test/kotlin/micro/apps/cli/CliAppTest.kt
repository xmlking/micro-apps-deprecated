package micro.apps.cli

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertEquals

class CliAppTest {
    @Test fun `test app has a greeting`() {
        val classUnderTest = CliApp()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }

    @Test fun `test app greeting is - Hello world`() {
        val classUnderTest = CliApp()
        assertEquals(classUnderTest.greeting, "Hello World")
    }
}
