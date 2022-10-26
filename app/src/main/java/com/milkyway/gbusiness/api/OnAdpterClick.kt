package com.milkyway.gbusiness.api

interface OnAdpterClick
{
    fun OnClick(cartId : String)
    fun onClickBtn(cart_id : String,price : String,domainName : String,services : String,currency : String)
}