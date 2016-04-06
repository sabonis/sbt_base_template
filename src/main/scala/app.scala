import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object app {
  def main(args: Array[String]) {
    println("Hello World!")

    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()

    //val route = complete("fuck")

    val route =
      path("hello" / Segment) { param =>
        (get | put) {
          complete("fuck" + param)
        }
      } ~
      pathPrefix("js") {
        getFromResourceDirectory("js")
      }


    /*
    pathPrefix("hello") {
      complete("dkk")
    }
    */


    Http().bindAndHandle(route, "localhost", 8080)

    test {
      println("gg")
      "kk"
    }

    test2 {
      println("gg2")
      "kk"
    }


    val a = 3 + 2

    val b = 3.+(2)

  }

  def test(a: String) = a + a

  def test2(a: => String) = a + a

}
