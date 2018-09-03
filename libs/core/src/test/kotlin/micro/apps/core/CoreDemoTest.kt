package micro.apps.core

import kotlin.test.Test
import kotlin.test.assertTrue

class CoreDemoTest {
    @Test fun testSomeLibraryMethod() {
        val classUnderTest = CoreDemo()
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'")
    }
}
