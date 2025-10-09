package models

import common.{*, given}
import play.api.libs.json.{Format, Json}

final case class User(
    _id: String,
    usualLocation: Country
)

object User {
  given Format[User] = Json.format[User]
}