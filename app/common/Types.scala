package common

import scala.math.BigDecimal
import scala.math.BigDecimal.RoundingMode

opaque type Money = BigDecimal
object Money:
    def apply(value: String): Money =
        BigDecimal(value).setScale(2, RoundingMode.HALF_UP)
    def apply(value: Double): Money =
        BigDecimal(value).setScale(2, RoundingMode.HALF_UP)
    extension (m: Money)
        def underlying: BigDecimal = m
        def +(other: Money): Money = m + other.underlying
        def >(other: Money): Boolean = m > other.underlying

enum Country:
    case US, UK, BR, JP