package com.milkyway.gbusiness.fragments

import com.milkyway.gbusiness.models.Invoice_slip

data class BillingDataClass(
    val currency: String,
    val message: String,
    val domain_created_id: Int,
    val invoice_id: Int,
    val payAmount: String,
    val success: Boolean,
    val walletAmount: WalletAmount,
    val invoice_slip: Invoice_slip
)