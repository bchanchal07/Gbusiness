package com.milkyway.gbusiness.api

interface OnServiceAdapterClick
{
    fun onClickServiceItem(service_id : String,name : String, enqri : String, price : String,first_heading : String, second_heading : String, serviceType : String,image:String)
}