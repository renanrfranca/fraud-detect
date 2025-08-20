package models

import play.api.libs.json.{Format, Json}

final case class FraudAlert(
    id: String,
    transactionId: String,
    reason: String,
    timestamp: Long // epoch
)

object FraudAlert {
  given Format[FraudAlert] = Json.format[FraudAlert]
}