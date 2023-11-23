import sbt._

object Dependencies {
  private val kotlin_version = "1.7.10"
  private val scalaTest_version = "3.2.11"


  lazy val munit = "org.scalameta" %% "munit" % "0.7.29"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % scalaTest_version

  lazy val depMutiny = "io.smallrye.reactive" % "mutiny" % "2.5.1"
  lazy val depJavaxAnnotation = "javax.annotation" % "javax.annotation-api" % "1.3.2"
  lazy val depCommonsLang3 = "org.apache.commons" % "commons-lang3" % "3.12.0"
  lazy val depSlf4jSimple = "org.slf4j" % "slf4j-simple" % "2.0.5"
  lazy val depSlf4jApi = "org.slf4j" % "slf4j-api" % "2.0.5"
  lazy val depSpotbugs = "com.github.spotbugs" % "spotbugs-annotations" % "4.7.3"
  lazy val depGuava = "com.google.guava" % "guava" % "32.0.0-jre"
  lazy val depTripleoBuffers = "tripleo.buffers" % "buffers-v1" % "0.0.3"
  lazy val depTripleoRange = "tripleo.util.range" % "range-v1" % "0.0.3b"

  lazy val depKotlinStdlibJdk8 = "org.jetbrains.kotlin" % "kotlin-stdlib-jdk8" % kotlin_version
  lazy val depKotlinStdlib = "org.jetbrains.kotlin" % "kotlin-stdlib" % kotlin_version % Runtime
  lazy val depKotlinReflect = "org.jetbrains.kotlin" % "kotlin-reflect" % kotlin_version % Runtime
  lazy val depKotlinXSJJ = "org.jetbrains.kotlinx" % "kotlinx-serialization-json-jvm" % "1.6.1" % Runtime
  lazy val depKotlinXCCJ = "org.jetbrains.kotlinx" % "kotlinx-coroutines-core-jvm" % "1.7.3" % Runtime
  lazy val depKotlinXCS = "org.jetbrains.kotlinx" % "kotlinx-coroutines-swing" % "1.6.4" % Runtime
  lazy val depKotlinXCJ = "org.jetbrains.kotlinx" % "kotlinx-coroutines-jdk8" % "1.6.4" % Runtime
  lazy val depKotlinXCSlf4J = "org.jetbrains.kotlinx" % "kotlinx-coroutines-slf4j" % "1.6.4" % Runtime
  lazy val depKotlinXCD = "org.jetbrains.kotlinx" % "kotlinx-coroutines-debug" % "1.6.4" % Runtime

  lazy val depLogBackClassic = "ch.qos.logback" % "logback-classic" % "1.4.5"

  lazy val depMockito = "org.mockito" % "mockito-core" % "5.2.0" % Test
  lazy val depKotlinTest = "org.jetbrains.kotlin" % "kotlin-test-junit" % "1.8.20" % Test

  lazy val depLombok = "org.projectlombok" % "lombok" % "1.18.28" % Compile

  val conventionsDepsKotlin = Seq(
    depKotlinStdlibJdk8,
    depKotlinStdlib,
    depKotlinReflect,
    depKotlinXSJJ,
    depKotlinXCCJ,
    depKotlinXCS,
    depKotlinXCJ,
    depKotlinXCSlf4J,
    depKotlinXCD
  )

  val conventionsDeps = Seq(
    depMutiny,
    depJavaxAnnotation,
    depCommonsLang3,
    depSlf4jSimple,
    depSlf4jApi,
    depSpotbugs,
    depGuava,
    depTripleoBuffers,
    depTripleoRange,

    depLogBackClassic,

    depMockito,
    depKotlinTest,

    depLombok
  ) ++ conventionsDepsKotlin

}


