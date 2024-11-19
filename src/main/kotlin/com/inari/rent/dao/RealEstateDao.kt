package com.inari.rent.dao

import com.inari.rent.data.RealEstate

interface RealEstateDao {

    fun create(realEstate: RealEstate): RealEstate
    fun get(id: Long): RealEstate?
    fun update(realEstate: RealEstate): RealEstate
    fun listByCity(city: String, state: String): List<RealEstate>
    fun listCities(): List<String>
}

