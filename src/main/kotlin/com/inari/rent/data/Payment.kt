package com.inari.rent.data

sealed interface Payment {
    val amount: Float
}

data class Cash(override val amount: Float): Payment
data class CreditCard(override val amount: Float): Payment
data class BankTransfer(override val amount: Float): Payment