package me.will.coroutinesspecific

import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.Ignore

class AsynchronousCodeTest {
    @Test
    @Ignore("Not ready yet")
    fun `some test`() {
        val sysout = spyk(System.out)
        println("test of tests")
        verify { sysout.println("test of tests") }
    }
}
