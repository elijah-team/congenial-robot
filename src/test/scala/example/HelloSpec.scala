package example

class HelloSpec extends munit.FunSuite {
  test("say hello") {
    assertEquals(Hello2.greeting, "hello")
  }
}
