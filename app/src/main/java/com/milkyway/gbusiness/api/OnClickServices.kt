package com.milkyway.gbusiness.api

interface OnClickServices {
    fun onClick(id: String, name: String)

    fun onClickDownload(webUrl: String) {}
    fun onClickTrash(id: String, name: String) {}
    fun onClickPublish(templateID: String, name: String) {}
    fun nowPublishWebSite(templateID: String, domainId: String) {}
    fun nowUnPublishWebSite(projectId: String) {}
    fun editSites(webUrl: String) {}

}