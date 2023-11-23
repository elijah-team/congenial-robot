package example

import tripleo.elijah.Main

//import tripleo.elijah.Main

class Hello /*App*/ extends xsbti.AppMain {
  def run(configuration: xsbti.AppConfiguration): xsbti.MainResult = {
    // get the version of Scala used to launch the application
    val scalaVersion = configuration.provider.scalaProvider.version

    // Print a message and the arguments to the application
    println("Hello world!  Running Scala " + scalaVersion)
    configuration.arguments.foreach(println)

    Main.main(Array("nothing"))

    new Exit(0)
  }
  private class Exit(val code: Int) extends xsbti.Exit
}
