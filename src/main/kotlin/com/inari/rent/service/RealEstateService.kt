package com.inari.rent.service

import com.inari.rent.data.EstateType
import com.inari.rent.data.RealEstate

interface RealEstateService {

    fun create(id: Long, name: String, address: String, city: String, state: String, estateType: EstateType): RealEstate
    fun updateAddress(id: Long, address: String): RealEstate
    fun getEstateTypeAsString(id: Long): String

}