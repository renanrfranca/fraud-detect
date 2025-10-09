package models

import common.{*, given}
import play.api.libs.json.{Format, Json}

final case class Transaction(
    _id: String,
    userId: String,
    amount: Money,
    merchantId: String,
    countryCode: Country,
    timestamp: Long // epoch
)

object Transaction {
  given Format[Transaction] = Json.format[Transaction]
}