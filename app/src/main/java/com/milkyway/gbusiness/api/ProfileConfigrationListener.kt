package com.milkyway.gbusiness.api

interface ProfileConfigrationListener  {

    fun getSslListener(domainName : String)
    {}

    fun creatWebmailListener(domainName : String,emailAdress : String)
    {}
}