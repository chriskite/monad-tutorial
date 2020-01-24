import cats.syntax.either._
import io.circe.parser._

val json = """
  {
    "id": "c730433b-082c-4984-9d66-855c243266f0",
    "name": "John Smith",
    "details": {
      "alive": true,
      "weight": 100.001,
      "aliases": ["James Smith", "Rusty Shackleford"]
    }
  }
"""
