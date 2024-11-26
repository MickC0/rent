package com.inari.rent.service

import com.inari.rent.dao.RealEstateDao
import com.inari.rent.data.EstateType
import com.inari.rent.data.RealEstate

private const val HOUSE = "HOUSE"
private const val APARTMENT = "APARTMENT"
private const val LAND = "LAND"

class RealEstateServiceImpl(val dao: RealEstateDao): RealEstateService {
    override fun create(id: Long, name: String, address: String, city: String, state: String, estateType: EstateType) = dao
        .create(
            RealEstate(id, name, address, city, state, estateType)
        )

    override fun updateAddress(id: Long, address: String): RealEstate {
        val realEstate = dao.get(id) ?: throw Exception("No real Estate")
        realEstate.address = address
/*
        val desc = realEstate.description?.lowercase() ?: ""
*/
        return dao.update(realEstate)
    }

    override fun getEstateTypeAsString(id: Long) = when(dao.get(id)?.type) {
        EstateType.HOUSE -> HOUSE
        EstateType.APARTMENT -> APARTMENT
        EstateType.LAND -> LAND
        null -> throw Exception("No Estate")
    }

/*    companion object {
        private const val HOUSE = "HOUSE"
        private const val APARTMENT = "APARTMENT"
        private const val LAND = "LAND"
    }*/
}
