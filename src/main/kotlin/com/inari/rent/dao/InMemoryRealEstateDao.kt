package com.inari.rent.dao

import com.inari.rent.data.RealEstate

class InMemoryRealEstateDao: RealEstateDao {
    private val data = mutableMapOf<Long, RealEstate>()

    override fun create(realEstate: RealEstate): RealEstate {
        data[realEstate.id] = realEstate
        return realEstate
    }

    override fun get(id: Long) = data[id]

    override fun update(realEstate: RealEstate): RealEstate {
        if (data[realEstate.id] == null){
            throw Exception("Data does not exist")
        }
        data[realEstate.id] = realEstate
        return realEstate
    }

    override fun listByCity(city: String, state: String) = data
        .filter {
            it.value.city == city && it.value.state == state
        }
        .values
        .toList()

    override fun listCities() = data
        .map {
            it.value.city
        }
        .distinct()
}