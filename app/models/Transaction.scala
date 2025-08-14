import common.Money
import common.Country

final case class Transaction(
    id: String,
    userId: String,
    amount: Money,
    merchantId: String,
    countryCode: Country,
    timestamp: Long // epoch
)
