package com.milkyway.gbusiness.models

data class Sale(
    val amount: Amount,
    val create_time: String,
    val id: String,
    val links: List<Link>,
    val parent_payment: String,
    val payment_mode: String,
    val protection_eligibility: String,
    val protection_eligibility_type: String,
    val state: String,
    val transaction_fee: TransactionFee,
    val update_time: String
)