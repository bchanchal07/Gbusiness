package com.milkyway.gbusiness.models

data class SearchDomainDataDetailsClass(
    val domainPriceList: List<DomainList>,
) {
    data class DomainList(
        val domainName: String,
        val domainPrice: String,
        var subscriptionYr: Int,
        val subscriptionTotalAmount: String,
    )
}
/*{
    data class RegPrice(
        @SerializedName("name")
        val name: String,
        @SerializedName("yr_value")
        val yearValue: String,
    )
}*/