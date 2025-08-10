import io.kotest.core.spec.style.DescribeSpec

class DebugTest : DescribeSpec() {

    init {
        describe("debug") {
            context("should be debuggable") {
                println("debug")
            }

            context("should be debuggable 2") {
                println("debug")
            }
        }
    }
}