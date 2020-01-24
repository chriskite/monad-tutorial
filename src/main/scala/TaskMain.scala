import sttp.client.Response
import sttp.client.asynchttpclient.zio.AsyncHttpClientZioBackend
import sttp.client.quick._
import zio.console._
import zio.duration._
import zio.{DefaultRuntime, Schedule, Task}

object TaskMain extends App {

  val numTask = Task.succeed(2)
  val effectTask: Task[Unit] = Task.effect { println("Hello") }
  val httpTask: Task[Response[String]] = AsyncHttpClientZioBackend().flatMap {
    implicit backend =>
      quickRequest
        .get(uri"https://www.pcmag.com/")
        .send()
  }

  val program = for {
    num <- numTask
    _ <- effectTask
    response <- httpTask.race(putStr(".").delay(5.milliseconds).forever)
    firstLine <- Task.effect { response.body.split("\n").head }
    _ <- putStrLn(firstLine)
    _ <- putStrLn("Done")
  } yield ()

  val runtime = new DefaultRuntime {}
  runtime.unsafeRun(program)
}
