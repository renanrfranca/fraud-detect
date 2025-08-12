final case class Transaction(
    id: String,
    userId: String,
    amount: BigDecimal,
    merchantId: String,
    countryCode: String,
    timestamp: Long // epoch
)
