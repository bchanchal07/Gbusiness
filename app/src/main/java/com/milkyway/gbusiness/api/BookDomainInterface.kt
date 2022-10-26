package com.milkyway.gbusiness.api

import com.milkyway.gbusiness.models.DomainDetails

interface BookDomainInterface
{
 /*   fun <T> OnClickBookDomain(domain :String, list : ArrayList<T>)*/
    fun  OnClickBookDomain(domain :String,  domain_details: DomainDetails)
}
