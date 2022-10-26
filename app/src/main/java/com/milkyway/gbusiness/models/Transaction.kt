package com.milkyway.gbusiness.models

data class Transaction(
    val amount: Amount,
    val description: String,
    val item_list: ItemList,
    val payee: Payee,
    val related_resources: List<RelatedResource>
)