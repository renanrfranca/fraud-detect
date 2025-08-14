package models

import common.Country

final case class User(
    id: String,
    usualLocation: Country
)
