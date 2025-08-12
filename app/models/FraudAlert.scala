final case class FraudAlert(
    id: String,
    transactionId: String,
    reason: String,
    timestamp: Long // epoch
)
