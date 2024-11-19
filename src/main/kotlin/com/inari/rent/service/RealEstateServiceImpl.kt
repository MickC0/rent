package com.inari.rent.service

import com.inari.rent.dao.RealEstateDao
import com.inari.rent.data.RealEstate

class RealEstateServiceImpl(val dao: RealEstateDao): RealEstateService {
    override fun create(id: Long, name: String, address: String) = dao
        .create(
            RealEstate(id, name, address)
        )

    override fun updateAddress(id: Long, address: String): RealEstate {
        val realEstate = dao.get(id) ?: throw Exception("No real Estate")
        realEstate.address = address
        return dao.update(realEstate)
    }
}