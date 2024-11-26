package com.inari.rent.dao

import com.inari.rent.data.BankTransfer
import com.inari.rent.data.Cash
import com.inari.rent.data.CreditCard
import com.inari.rent.data.Payment

class InMemoryPaymentDao : PaymentDao {
    private val payments = mutableListOf<Payment>()
/*    private val paymentLazyCount by lazy {
        payments.size
    }*/
    override val totalCreditCard: Float
        get() = payments.filterIsInstance<CreditCard>()
            .map { it.amount }
            .sum()
    override val totalPaymentByType: Map<String, Float>
        get() {
            val result = mutableMapOf<String,Float>()
            result["CreditCard"] = 0f
            result["Cash"] = 0f
            result["BankTransfer"] = 0f
            for (payment in payments) {
                when(payment) {
                    is Cash -> result["Cash"] = result["Cash"]!! + payment.amount
                    is CreditCard -> result["CreditCard"] = result["CreditCard"]!! + payment.amount
                    is BankTransfer -> result["BankTransfer"] = result["BankTransfer"]!! + payment.amount
                }
            }
            return result
        }
}