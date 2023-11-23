import Dependencies._

ThisBuild / scalaVersion := "2.13.12"
ThisBuild / version := "0.1.0-SNAPSHOT"


lazy val printHello = taskKey[Unit]("prints hello")
printHello := println("hello")

lazy val one = taskKey[Int]("one")
one := 1

lazy val oneTimesTwo = taskKey[Unit]("one times two")
oneTimesTwo := println(s"2 * 1 = ${2 * one.value}")

lazy val helloCommand = Command.command("helloCommand")(state => {
  println("hello from command")
  state
})

lazy val helloCommand2 = Command.command("helloCommand2")(state => {
  println("hello from command 2")
  state.copy(definedCommands = state.definedCommands :+ helloCommand)
})


resolvers ++= Seq(
  "Typesafe" at "https://repo.typesafe.com/typesafe/releases/"
  //  ,"Java.net Maven2 Repository" at "https://download.java.net/maven/2/"
  //  ,"Central" at "https://repo.maven.apache.org/maven2/"

  //  ,"Almost Rider" at "https://git.sr.ht/~tripleo/el-almost-rider/tree/main/item/flum-mainline-k-230416-rel/lib"

  //  , "tripleo-buffers" at "https://gitlab.com/api/v4/projects/20346374/packages"
  //  , "tripleo-range" at "https://gitlab.com/api/v4/projects/21223510/packages"
  //  , Resolver.mavenLocal
  //  , Resolver.mavenCentral
)

resolvers += Resolver.url("https://gitlab.com/api/v4/projects/20346374/packages/maven")
resolvers += Resolver.url("https://gitlab.com/api/v4/projects/21223510/packages/maven")

//resolvers += "tripleo-buffers" at "https://gitlab.com/api/v4/projects/20346374/packages/maven"
//resolvers += "tripleo-range" at "https://gitlab.com/api/v4/projects/21223510/packages/maven"


addCommandAlias("compileAndTest", "compile;test;")
addCommandAlias("R", "reload;clean;compile;test;")


//lazy val module_1 = (project in file("annotation-processing"))
//lazy val module_2 = (project in file("annotations"))
//lazy val module_3 = (project in file("annotation-user"))

//lazy val module_4 = (project in file("elijah-compiler-gen"))

lazy val module_12 = (project in file("tripleo-small"))
  .settings(
    name := "tripleo-small",
  )

lazy val module_10 = (project in file("elijah-stateful")).settings(
  name := "elijah-stateful",
  libraryDependencies ++= conventionsDeps ++ Seq(
    "org.jetbrains" % "annotations" % "24.0.1",
    //    "org.typelevel" %% "cats-effect" % "3.3.0"

    "junit" % "junit" % "4.13.2" % Test,
    "com.google.auto.service" % "auto-service" % "1.0-rc2" % Compile
  )
).dependsOn(module_12)

lazy val module_11 = (project in file("tripleo-reactive")).settings(
  name := "tripleo-reactive",
  libraryDependencies ++= conventionsDeps ++ Seq(
    "org.jetbrains" % "annotations" % "24.0.1",
    "junit" % "junit" % "4.13.2" % Test,
    //compileOnly 
    "com.google.auto.service" % "auto-service" % "1.0-rc2" % Compile
  )
).dependsOn(module_12)

lazy val module_7 = (project in file("elijah-nextgen-outputstatement"))
  .settings(
    name := "elijah-nextgen-outputstatement",
    libraryDependencies ++= conventionsDeps ++ Seq(
      "org.jetbrains" % "annotations" % "24.0.1",
      "junit" % "junit" % "4.13.2" % Test,
    )
  ).dependsOn(module_12)

lazy val module_8 = (project in file("elijah-sourcemodel-api"))
  .settings(
    name := "elijah-sourcemodel-api",
    libraryDependencies ++= conventionsDeps ++ Seq(
      "org.jetbrains" % "annotations" % "24.0.1",

      "commons-codec" % "commons-codec" % "1.15",

      "junit" % "junit" % "4.13.2" % Test,

      "com.tngtech.archunit" % "archunit-junit4" % "1.2.0" % Test
    )
  ).dependsOn(module_12, module_7, module_10, module_11)


lazy val module_9 = (project in file("elijah-sourcemodel-impl"))
  .settings(
    name := "elijah-sourcemodel-impl",
  )
  .dependsOn(module_12, module_7, module_10, module_11, module_8)

lazy val module_6 = (project in file("elijah-good-api"))
  .settings(
    name := "elijah-sourcemodel-api",
    libraryDependencies ++= conventionsDeps ++ Seq(
      "org.jetbrains" % "annotations" % "24.0.1",
      "org.jdeferred.v2" % "jdeferred-core" % "2.0.0",

      "commons-codec" % "commons-codec" % "1.15",

      "junit" % "junit" % "4.13.2" % Test,

      "com.tngtech.archunit" % "archunit-junit4" % "1.2.0" % Test
    )
  ).dependsOn(module_12, module_7, module_10, module_11, module_8, module_9)

lazy val module_5 = (project in file("elijah-core"))
  .settings(
    name := "elijah-congenial-robot",
    libraryDependencies ++= conventionsDeps ++ Seq(
      "org.jetbrains" % "annotations" % "24.0.1",
      "org.jdeferred.v2" % "jdeferred-core" % "2.0.0",

      "commons-codec" % "commons-codec" % "1.15",

      "junit" % "junit" % "4.13.2" % Test,

      "io.reactivex.rxjava3" % "rxjava" % "3.1.6",
      "org.reactivestreams" % "reactive-streams" % "1.0.4",

      "antlr" % "antlr" % "20030911",


      "com.tngtech.archunit" % "archunit-junit4" % "1.2.0" % Test
    )
  ).dependsOn(module_12, module_7, module_10, module_11, module_8, module_9)

//noinspection SpellCheckingInspection
//lazy val module_13 = (project in file("typeinf"))

lazy val root = (project in file("."))
  .enablePlugins(ConscriptPlugin)
  .enablePlugins()
  .settings(
    name := "congenial-robot"
    , libraryDependencies += scalaTest % Test
    , commands ++= Seq(helloCommand2)
//    , scalaVersion := scalaVersion
  )
  .aggregate(module_12, module_10, module_11)
  .dependsOn(module_5)
  
