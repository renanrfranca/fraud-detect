package common

import scala.math.BigDecimal
import scala.math.BigDecimal.RoundingMode
import play.api.libs.json.*
import scala.util.Try

opaque type Money = BigDecimal
object Money:
    def apply(value: String): Money =
        BigDecimal(value).setScale(2, RoundingMode.HALF_UP)
    def apply(value: Double): Money =
        BigDecimal(value).setScale(2, RoundingMode.HALF_UP)
    def apply(value: BigDecimal): Money = 
        value.setScale(2, RoundingMode.HALF_UP)
    extension (m: Money)
        def underlying: BigDecimal = m
        def +(other: Money): Money = m + other.underlying
        def >(other: Money): Boolean = m > other.underlying

enum Country:
    case US, UK, BR, JP

given Format[Money] = Format[Money](
  Reads { js =>
    js.validate[String].flatMap { str =>
      Try(BigDecimal(str)).toOption match {
        case Some(bd) => JsSuccess(Money(bd))
        case None => JsError(s"Invalid Money format: $str")
      }
    }
  },

  Writes { money =>
    JsString(money.underlying.toString)
  }
)

given Format[Country] = Format[Country](
  Reads { js =>
    js.validate[String].flatMap { str =>
      Try(Country.valueOf(str)).toOption match {
        case Some(country) => JsSuccess(country)
        case None => JsError(s"Invalid Country value: $str")
      }
    }
  },
  Writes { country =>
    JsString(country.toString)
  }
)