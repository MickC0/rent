package com.inari.rent.dao

interface PaymentDao {
    val totalCreditCard: Float
    val totalPaymentByType: Map<String,Float>
}