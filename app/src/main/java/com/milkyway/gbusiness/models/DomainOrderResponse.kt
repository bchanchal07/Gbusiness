package com.milkyway.gbusiness.models


data class DomainOrderResponse(
    val numreturned: Int, // 25
    val orders: Orders,
    val result: String, // success
    val startnumber: Int, // 0
    val totalresults: Int // 44
) {
    data class Orders(
        val order: List<Order>
    ) {
        data class Order(
            val amount: String, // 940.86
            val contactid: Int, // 0
            val currencyprefix: String, // ₹
            val currencysuffix: String, //  INR
            val date: String, // 2022-01-14 12:33:19
            val frauddata: String,
            val fraudmodule: String,
            val fraudoutput: String,
            val id: Int, // 236
            val invoiceid: Int, // 185
            val ipaddress: String, // 13.211.182.77
            val lineitems: Lineitems,
            val name: String, // milky way
            val nameservers: String, // ns1.www.gbusiness.co,ns2.www.gbusiness.co
            val notes: String,
            val orderdata: String, // []
            val ordernum: Long, // 8779590071
            val paymentmethod: String, // razorpay
            val paymentmethodname: String, // Razorpay
            val paymentstatus: String, // Unpaid
            val promocode: String,
            val promotype: String,
            val promovalue: String,
            val renewals: String,
            val status: String, // Pending
            val transfersecret: String,
            val userid: Int // 61
        ) {
            data class Lineitems(
                val lineitem: List<Lineitem>
            ) {
                data class Lineitem(
                    val amount: String, // ₹797.34 INR
                    val billingcycle: Int, // 1
                    val dnsmanagement: Int, // 0
                    val domain: String, // dsdsdsdsdsd.co.in
                    val emailforwarding: Int, // 0
                    val idprotection: Int, // 0
                    val product: String, // Register
                    val producttype: String, // Domain
                    val relid: Int, // 283
                    val status: String, // Pending
                    val type: String // domain
                )
            }
        }
    }
}