package com.inari.rent.service

import com.inari.rent.data.RealEstate

interface RealEstateService {

    fun create(id: Long, name: String, address: String): RealEstate
    fun updateAddress(id: Long, address: String): RealEstate
}