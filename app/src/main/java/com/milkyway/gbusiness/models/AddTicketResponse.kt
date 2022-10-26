package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class AddTicketResponse(
    val `data`: Data,
    val message: String, // Ticket add Successfully and Email Sent Successfully!
    val success: Boolean // true
) {
    data class Data(
        val content: String, // This is the text query
        @SerializedName("created_at")
        val createdAt: String, // 2022-02-04T03:48:11.000000Z
        val filenames: String, // a:0:{}
        val id: Int, // 57
        @SerializedName("issue_id")
        val issueId: String, // 7
        val status: Int, // 0
        @SerializedName("ticket_no")
        val ticketNo: String, // TK1723802835878922
        @SerializedName("updated_at")
        val updatedAt: String, // 2022-02-04T03:48:11.000000Z
        @SerializedName("user_id")
        val userId: String // 1417
    )
}