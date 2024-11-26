package com.inari.rent.data

data class RealEstate(
    val id: Long,
    val name: String,
    var address: String,
    var city: String,
    var state: String,
    val type: EstateType,
    var description: String? = null
)
