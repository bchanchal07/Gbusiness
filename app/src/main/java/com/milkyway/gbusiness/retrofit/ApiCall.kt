package com.milkyway.gbusiness.retrofit

import com.google.gson.JsonObject
import com.milkyway.gbusiness.models.*
import com.milkyway.gbusiness.fragments.BillingDataClass
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface ApiCall {

    @FormUrlEncoded
    @POST(AppConstants.REGISTRATION)
    @Headers("Accept:application/json")
    fun userRegistration(
        @Field("first_name") first_name: String,
        @Field("last_name") last_name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("country_code") country_code: String,
        @Field("phone") phone: String,
    ): Call<Any>

    @FormUrlEncoded
    @POST("login")
    fun getLogin(
        @Header("Accept") Accept: String,
        //  @Header("Content-Type") contentType : String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("isfirst") otp: String,
        @Field("deviceid") deviceId: String,
    ): Call<Any>


    @FormUrlEncoded
    @POST("verifyUser")
    fun getOtpVerification(
        @Field("verification_code") verificationCode: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<OtpVerificationDataClass>

    @FormUrlEncoded
    @POST("logout")
    //  @Headers("Content-Type: application/json")
    fun getLogout(
        @Field("token") token: String,
        @Header("Accept") accept: String,
    ): Call<LogoutDataClass>

    //MyDirectResponse
    @FormUrlEncoded
    @POST("my-connection-earning")
    fun getMyDirect(
        @Header("Authorization") authorization: String, @Header("Accept") accept: String,
        @Field("userid") user_id: String,
    ): Call<MyDirectResponse>

    @FormUrlEncoded
    @POST("myearning")
    fun getEarning(
        @Header("Authorization") authorization: String, @Header("Accept") accept: String,
        @Field("user_id") user_id: String,
    ): Call<EarningDataClass>

    @FormUrlEncoded
    @POST("datewise_earning")
    fun getEarningByDate(
        @Header("Authorization") authorization: String, @Header("Accept") accept: String,
        @Field("from_date") from_date: String,
        @Field("to_date") to_date: String,
        @Field("user_id") user_id: String, @Field("type") type: String,
    ): Call<EarningDateWiseDataClass>


    @FormUrlEncoded
    @POST("userProfile")
    fun getUserProfile(
        @Header("Authorization") authorization: String, @Header("Accept") accept: String,
        @Field("user_id") user_id: String,
    ): Call<Any>

    @FormUrlEncoded
    @POST("updateuserimage")
    fun getUpdateProfileImage(
        @Header("Authorization") authorization: String,
        @Header("Accept") accept: String,
        @Field("user_id") user_id: String,
        @Field("user_image") user_image: String,
    ): Call<UpdateUserDetailsDataClass>

    @GET("services")
    fun getServices(
        @Header("Authorization") authorization: String,
        @Header("Accept") accept: String,
    ): Call<ServicesDataClass>


    @FormUrlEncoded
    @POST("getCartdetails")
    fun getCartDetails(
        @Header("Authorization") authorization: String,
        @Field("user_id") user_id: String,
    ): Call<CartDataClass>

    @FormUrlEncoded
    @POST("cartDelete")
    fun getCartDelete(
        @Header("Authorization") authorization: String,
        @Field("cart_id") user_id: String,
    ): Call<CartDeleteDataClass>

    @FormUrlEncoded
    @POST("walletWithdrawal")
    fun getWalletBalance(
        @Header("Authorization") authorization: String,
        @Field("user_id") user_id: String,
    ): Call<WalletBalanceDataClass>

    @FormUrlEncoded
    @POST("Orderlist")
    fun getDomainOrderedList(
        @Header("Authorization") authorization: String,
        @Field("user_id") user_id: String,
        @Field("whmcs_client_id") whmcs_client_id: String,
    ): Call<DomainOrderResponse>

    @FormUrlEncoded
    @POST("api.php")
    fun getDomainOrderList(
        @Field("action") action: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("userid") userid: String,
        @Field("responsetype") responsetype: String,
    ): Call<DomainOrderResponse>

    @FormUrlEncoded
    @POST("paymentAndInvoices")
    fun getPaymentAndInvoice(
        @Header("Authorization") authorization: String,
        @Field("user_id") user_id: String,
    ): Call<PaymentINvoiceDataClass>


    @FormUrlEncoded
    @POST("withdrawalRequest")
    fun getWithdrawalRequest(
        @Header("Authorization") authorization: String,
        @Field("user_id") user_id: String,
        @Field("withdrawaamount") withdrawaamount: String,
        @Field("paymentmode") paymentmode: String,
        @Field("payment_mode_id") payment_mode_id: String,
    ): Call<PaynowDataClass>


    @FormUrlEncoded
    @POST("getWithdrawalhistory")
    fun getWithdrawalhistory(
        @Header("Authorization") authorization: String,
        @Field("user_id") user_id: String,
    ): Call<WithDrawHistoryDataClass>

    @FormUrlEncoded
    @POST("activatessl")
    fun activateSSL(
        @Header("Authorization") authorization: String,
        @Field("domainname") domainname: String,
    ): Call<SSLactivsteDataClass>

    @FormUrlEncoded
    @POST("withdrawalHistory")
    fun getWallethistory(
        @Header("Authorization") authorization: String,
        @Field("user_id") user_id: String,
    ): Call<WalletHistoryDataClass>


    @FormUrlEncoded
    @POST("SearchSubdomain")
    fun searchSubDomain(
        @Header("Accept") accept: String,
        @Field("name") searchSubdomain: String,
    ): Call<SubdomainResponse>

    /*@FormUrlEncoded
    @POST("buynewDomain")
    fun getBuySubDomain(
        @Header("Authorization") authorization: String, @Header("Accept") accept: String,
        @Field("serach_domain") serach_domain: String, @Field("user_id") user_id: String,
    ): Call<BookDomainDataClass>*/

    @FormUrlEncoded
    @POST("book_sub_domain")
    fun bookSubDomain(
        @Header("Authorization") authorization: String, @Header("Accept") accept: String,
        @Field("name") searchSubdomain: String, @Field("user_id") user_id: String,
    ): Call<SubdomainResponse>

    @FormUrlEncoded
    @POST("upadteQuestion")
    fun getUpdateAnswer(
        @Header("Authorization") authorization: String, @Field("user_id") user_id: String,
        @Field("ques_ans") ques_ans: String, @Field("ques_id") ques_id: String,
    ): Call<UpdateUserDetailsDataClass>


    @GET("questionList")
    fun getSecrutyQuestionList(@Header("Authorization") authorization: String): Call<QuestionListDataClass>


    @FormUrlEncoded
    @POST("accountRecovery")
    fun accountRecovery(
        @Field("recovery_type") recovery_type: String,
        @Field("email") email: String,
    ): Call<ForgetPasswordDataClass>

    @FormUrlEncoded
    @POST("accRecoveryfinal")
    fun accountRecoverywithQustn(
        @Field("user_id") user_id: String,
        @Field("otp") otp: String,
        @Field("new_password") new_password: String,
    ): Call<ForgetPasswordDataClass>


    @FormUrlEncoded
    @POST("siteDeatils")
    fun getMySite(
        @Header("Authorization") authorization: String,
        @Field("user_id") user_id: String,
    ): Call<MysiteDetailsDataClass>

    @GET("profession")
    fun getProfession(
        @Header("Authorization") authorization: String,
        @Header("Accept") accept: String,
    ): Call<ProfessionDataClass>

    @GET("issuesList")
    fun getIssuesList(
        @Header("Authorization") authorization: String,
        @Header("Accept") accept: String,
    ): Call<ProfessionDataClass>

    @FormUrlEncoded
    @POST("trashSites")
    fun getTrashList(
        @Header("Authorization") authorization: String,
        @Field("user_id") user_id: String,
    ): Call<TrashListDataClass>

    @FormUrlEncoded
    @POST("userupdate")
    fun getuserUpdate(
        @Header("Authorization") authorization: String,
        @Header("Accept") accept: String,
        @Field("user_id") user_id: String,
        @Field("first_name") first_name: String,
        @Field("last_name") last_name: String,
        @Field("profession_id") profession_id: String,
        @Field("country_id") country_id: String,
        @Field("state_id") state_id: String,
        @Field("city") city: String,
        @Field("zip_code") zip_code: String,
        @Field("address") address: String,
    ): Call<UpdateUserDetailsDataClass>


    @FormUrlEncoded
    @POST("razorpay/express-order")
    fun getRazorPayOrderId(
        @Header("Authorization") authorization: String,
        @Field("invoice") invoice: String,
        @Field("name") name: String,
        @Field("wallet_pay") wallet_pay: String,
        @Field("amount") amount: String,
        @Field("currency") currency: String,
    ): Call<RazorPayOrderId>


    @FormUrlEncoded
    @POST("razorpay/success")
    fun sendRazorPayDetails(
        @Header("Authorization") authorization: String,
        @Field("pay_id") pay_id: String,
        @Field("invoice_id") invoice_id: String,
        @Field("user_id") user_id: String,
        @Field("captured") captured: String,
        @Field("transaction_id") transaction_id: String,
        @Field("bank_ref_no") bank_ref_no: String,
        @Field("order_status") order_status: String,
        @Field("failure_message") failure_message: String,
        @Field("payment_mode") payment_mode: String,
        @Field("card_name") card_name: String,
        @Field("currency") currency: String,
        @Field("amount") amount: String,
        @Field("created_at") created_at: String,
        @Field("domain_name") domain_name: String,
        @Field("status") status: String,
    ): Call<RazorPayStatusINdb>


    @FormUrlEncoded
    @POST("wallet/paynow")
    fun payWithWallet(
        @Header("Authorization") authorization: String,
        @Field("card_pay") card_pay: String,
        @Field("wallet_amount") wallet_amount: String,
        @Field("services") services: String,
        @Field("invoice_id") invoice_id: String,
        @Field("user_id") user_id: String,
    ): Call<PayWithWalletResponse>

    @FormUrlEncoded
    @POST("coupon/verify")
    fun applyCoupn(
        @Header("Authorization") authorization: String,
        @Field("user_id") user_id: String,
        @Field("invoice_id") invoice_id: String,
        @Field("coupon") coupon: String,
    ): Call<ApplyCouponResponse>


    @FormUrlEncoded
    @POST("changepassword")
    fun getChangePassword(
        @Header("Authorization") authorization: String, @Header("Accept") accept: String,
        @Field("user_id") user_id: String,
        @Field("password") first_name: String,
        @Field("password_confirmation") last_name: String,
        @Field("current_password") profession_id: String,
    ): Call<UpdateUserDetailsDataClass>

    @FormUrlEncoded
    @POST("socialRegister")
    fun getSignUp(
        @Header("Authorization") authorization: String, @Header("Accept") accept: String,
        @Field("first_name") first_name: String,
        @Field("email") email: String,
        @Field("socail_id") socail_id: String,
        @Field("provider") provider: String,
        @Field("image") image: String,
    ): Call<SignUpDataClass>

    @FormUrlEncoded
    @POST("paypal/express-checkout")
    fun getChackOutPaypal(
        @Header("Authorization") authorization: String,
        @Field("card_pay") card_pay: String,
        @Field("wallet_amount") wallet_amount: String,
        @Field("user_id") user_id: String,
        @Field("services") services: String,
        @Field("invoice_id") invoice_id: String,
        @Field("cart_id") cart_id: String,
    ): Call<expressChackOutPaypalDataClass>


    @FormUrlEncoded
    @POST("paypal/get-response-token")
    fun sendPaypalDetailsTOServer(
        @Header("Authorization") authorization: String,
        @Field("token") tokens: String,
        @Field("payerid") payerids: String,
        @Field("link") links: String,
        @Field("invoiceid") invoiceids: String,
    ): Call<sendPayalCredentailsToServerDataClass>


    @FormUrlEncoded
    @POST("getSupportQuery")
    fun getSupportedQuery(
        @Header("Authorization") authorization: String, @Header("Accept") accept: String,
        @Field("user_id") user_id: String,
    ): Call<UserQueryListDataClass>


    @FormUrlEncoded
    @POST("billing")
    fun getBilling(
        @Header("Authorization") authorization: String, @Header("Accept") accept: String,
        @Field("user_id") user_id: String,
        @Field("domain_name") domain_name: String,
        @Field("price") price: String,
        @Field("services") services: String,
        @Field("currency") currency: String,
        @Field("cart_id") cart_id: String,
        @Field("profession_id") profession_id: String,
    ): Call<BillingDataClass>


    @FormUrlEncoded
    @POST("sendEnqueyAndBuy")
    fun getSendEnqueyAndBuy(
        @Header("Authorization") authorization: String, @Header("Accept") accept: String,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("services_name") services_name: String,
        @Field("comment") comment: String,
        @Field("services_id") services_id: String,
        @Field("services_type") services_type: String,
    ): Call<SendEnqueyAndBuyDataClass>


    @FormUrlEncoded
    @POST("socialRegisterPhone")
    fun getPhoneVerification(
        @Header("Authorization") authorization: String, @Header("Accept") accept: String,
        @Field("phone") phone: String,
        @Field("profession") profession: String,
        @Field("referral_code") referral_code: String,
        @Field("user_id") user_id: String,
        @Field("country_code") country_code: String,
        @Field("referral_type") referral_type: String,
    ): Call<PhoneVerificationDataClass>


    //g mail verification otp
    @FormUrlEncoded
    @POST("socialRegisterOtp")
    fun getOtpVerification(
        @Field("otp") otp: String,
        @Field("user_id") user_id: String,
    ): Call<OptBySignUPGmailDataClass>


    //DomainListDataClass
    @FormUrlEncoded
    @POST("subdomainList")
    fun subdomainList(
        @Header("Authorization") authorization: String,
        @Field("user_id") user_id: String,
    ): Call<DomainListDataClass>

    //PublishORUnPublishWebSiteDataClass
    @FormUrlEncoded
    @POST("publish")
    fun getPublishWebSite(
        @Header("Authorization") authorization: String,
        @Field("selected_template") selected_template: String,
        @Field("select_domain") select_domain: String,
    ): Call<PublishORUnPublishWebSiteDataClass>

    @FormUrlEncoded
    @POST("unpublish")
    fun getUnPublishWebSite(
        @Header("Authorization") authorization: String,
        @Field("projectId") projectId: String,
    ): Call<PublishORUnPublishWebSiteDataClass>

    @FormUrlEncoded
    @POST("getAllNotifaication")
    fun getAllNotifaication(
        @Header("Authorization") authorization: String,
        @Field("user_id") user_id: String,
    ): Call<NotificationDataClass>


    @FormUrlEncoded
    @POST("activatessl")
    fun getActivateSSL(
        @Header("Authorization") authorization: String, @Field("domainname") domainname: String,
        @Field("active") active: String,
    ): Call<SSLactivateDataclass>

    @FormUrlEncoded
    @POST("user/createwebmail")
    fun creatWebmail(
        @Header("Authorization") authorization: String,
        @Field("email") email: String,
        @Field("userid") userid: String,
        @Field("domain") domain: String,
    ): Call<SSLactivateDataclass>

    @FormUrlEncoded
    @POST("sentOtpPhoneUpdate")
    fun changePoneNumber(
        @Header("Authorization") Authorization: String,
        @Field("user_id") user_id: String,
        @Field("phone") phone: String,
        @Field("country_code") country_code: String,
    ): Call<UpdatePhone>

    @FormUrlEncoded
    @POST("phoneUpdate")
    fun verifyMobileNumber(
        @Header("Authorization") Authorization: String,
        @Field("user_id") user_id: String,
        @Field("otp") otp: String,
        @Field("new_phone_no") new_phone_no: String,
    ): Call<UpdatePhone>

    @FormUrlEncoded
    @POST("domainListstatus")
    fun domainListToPublishSite(
        @Header("Authorization") Authorization: String,
        @Field("user_id") user_id: String,
        @Field("templateId") templateId: String,
    ): Call<DomainListAvalableDataClass>

    @FormUrlEncoded
    @POST("user/activateanddeactivate")
    fun accouAcivateAndDeactivate(
        @Header("Authorization") Authorization: String,
        @Field("delete") delete: String,
    ): Call<UpdatePhone>


    @FormUrlEncoded
    @POST("trash")
    fun moveToTrash(
        @Header("Authorization") Authorization: String,
        @Field("projectId") delete: String,
    ): Call<UpdatePhone>

    @FormUrlEncoded
    @POST("deleteProject")
    fun removeProjectFromTrast(
        @Header("Authorization") Authorization: String,
        @Field("projectId") delete: String,
    ): Call<UpdatePhone>

    @FormUrlEncoded
    @POST("restoreProject")
    fun reStoreProjectFromTrast(
        @Header("Authorization") Authorization: String,
        @Field("projectId") delete: String,
    ): Call<UpdatePhone>

    @GET("business-category")
    fun getCategoryList(
    ): Call<CategoryDataClass>

    @FormUrlEncoded
    @POST("getsubcategory")
    fun getSubCategoryList(
        @Field("categories_id") categories_id: Int,
    ): Call<SubCategoryDataClass>

    @GET("business-directory/{temp_category_id}")
    fun getCategoryDetails(
        @Path("temp_category_id") cat_id: Int,
    ): Call<CategoryDataDetailsClass>

    @GET("business-directory/{category_slug}")
    fun getBusinessListByCategoryDetails(
        @Path("category_slug") cat_slug: String,
    ): Call<BusinessDirectoryDataClass>

    @GET("getAllBusinessListing")
    fun getAllBusinessListing(
    ): Call<BusinessDirectoryDataClass>

    @FormUrlEncoded
    @POST("business-directory-enquiry")
    fun businessEnquiry(
        @Header("Authorization") Authorization: String,
        @Field("user_id") user_id: Int,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("mobile_number") mobile_number: String,
        @Field("query") query: String,
    ): Call<Any>

    @GET("get-my-business-page")
    fun getBusinessData(
        @Header("Authorization") authorization: String,
        @Header("Accept") accept: String,
    ): Call<GetBusinessDataClass>

    @Multipart
    @POST("update-my-business-page")
    fun updateBusinessPage(
        @Header("Authorization") authorization: String,
        @Header("Accept") accept: String,
        @Part("b_email") b_email: RequestBody,
        @Part("b_url") b_url: RequestBody,
        @Part("b_about_us") b_about_us: RequestBody,
        @Part imageFile: MultipartBody.Part,
    ): Call<BusinessUpdateDataClass>

    @FormUrlEncoded
    @POST("api.php")
    fun searchDomain(
        @Field("action") action: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("domain") domain: String,
        @Field("responsetype") responsetype: String,
    ): Call<Any>

    @FormUrlEncoded
    @POST("api.php")
    fun searchDomainPricing(
        @Field("action") action: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("currencyid") domain: String,
        @Field("responsetype") responsetype: String,
    ): Call<String>

    @GET("getcountries")
    fun getCountries(): Call<CountryDataClass>

    @FormUrlEncoded
    @POST("getstates")
    fun getStates(
        @Field("country_id") country_id: Int,
    ): Call<StateDataClass>

    @FormUrlEncoded
    @POST("getcities")
    fun getCities(
        @Field("state_id") state_id: Int,
    ): Call<CityDataClass>

    @GET("get_issue_list")
    fun getIssueSpinnerList(): Call<IssueSpinnerResponse>

    @FormUrlEncoded
    @POST("business_listing_details")
    fun getBusinessListData(
        @Header("Authorization") authorization: String,
        @Field("user_id") user_id: String,
    ): Call<BusinessListingResponse>

    @POST("business_listing_details_delete/{id}")
    fun deleteBusinessListItem(
        @Header("Authorization") authorization: String,
        @Path("id") id: Int,
    ): Call<DeleteBusinessListResponse>

    @Multipart
    @POST("business_listing_details_update/{id}")
    fun updateBusinessListData(
        @Header("Authorization") authorization: String,
        @Path("id") id: Int,
        @Part("user_id") user_id: RequestBody,
        @Part("business_name") business_name: RequestBody,
        @Part("b_email") b_email: RequestBody,
        @Part("b_url") b_url: RequestBody,
        @Part("b_about_us") b_about_us: RequestBody,
        @Part("category") category: RequestBody,
        @Part("sub_category") sub_category: RequestBody,
        @Part imageFile: MultipartBody.Part,
    ): Call<BusinessListEditResponse>

    @Multipart
    @POST("business_listing_details_add")
    fun createBusinessListData(
        @Header("Authorization") authorization: String,
        @Part("user_id") user_id: RequestBody,
        @Part("business_name") business_name: RequestBody,
        @Part("b_email") b_email: RequestBody,
        @Part("b_url") b_url: RequestBody,
        @Part("b_about_us") b_about_us: RequestBody,
        @Part("category") category: RequestBody,
        @Part("sub_category") sub_category: RequestBody,
        @Part imageFile: MultipartBody.Part,
    ): Call<BusinessListEditResponse>

    @Multipart
    @POST("add_new_Ticket")
    fun addNewTicket(
        @Header("Authorization") authorization: String,
        @Part("user_id") user_id: RequestBody,
        @Part("issue_id") issue_id: RequestBody,
        @Part("comment") comment: RequestBody,
        @Part imageFile: MultipartBody.Part,
    ): Call<AddTicketResponse>

    @FormUrlEncoded
    @POST("autologinwhcms")
    fun autoLoginWHMCS(
        @Field("email") email: String,
    ): Call<AutoLoginWhmcsResponse>

    @POST("go_to_checkout")
    fun goCheckoutForDomainBuy(
        @Body jsonObject: JsonObject,
    ): Call<DomainCartCheckout>

    @GET("get_business_gallery")
    fun getGalleryList(): Call<GalleryResponseDataClass>

    @GET("business_services_get")
    fun getBusinessServiceList(): Call<BusinessServiceDataClass>

    @GET("business_payment_get")
    fun getBusinessPaymentList(): Call<BusinessPaymentDataClass>

    @FormUrlEncoded
    @POST("add_review_business")
    fun addBusinessReviewRating(
        @Field("post_id") post_id: Int,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("comments") comments: String,
        @Field("star_rating") star_rating: String
    ): Call<AddReviewsDataClass>

    @FormUrlEncoded
    @POST("getAllBusinessListingReviews")
    fun getBusinessReviewRating(
        @Field("business_id") post_id: Int
    ): Call<GetReviewsDataClass>


    @Multipart
    @POST("want_say_something")
    fun wantSaySomething(
        @Header("Authorization") authorization: String,
        @Part("query_message") query: RequestBody,
        @Part("business_email") business_email: RequestBody,
        @Part("business_name") business_name: RequestBody,
        @Part imageFile: MultipartBody.Part,
    ): Call<WantSaySomethingDataClass>

    //todo ------------------------------------------

    //todo step -1 ddd new item api body..
    @Multipart
    @POST("business_listing_add_step_one")
    fun addBusinessListingStepOne(
        @Header("Authorization") authorization: String,
        @Part("user_id") user_id: RequestBody,
        @Part("title") title: RequestBody,
        @Part("email") email: RequestBody,
        @Part("payment_url") payment_url: RequestBody,
        @Part("bank_details") bank_details: RequestBody,
        @Part("business_id") business_id: RequestBody,
        @Part pmethod_image: MultipartBody.Part,
    ): Call<BusinessListStepOneModel>

    //todo show step-1 item list...
    @GET("business-step-one-get/{id}")
    fun getBusinessStepOneItemList(
        @Header("Authorization") authorization: String,
        @Path("id")id: String
    ): Call<StepOneItemListsModel>

    //todo step -1 update item api body..
    @Multipart
    @POST("business_listing_update_step_one")
    fun updateStepOneItem(
        @Header("Authorization") authorization: String,
        @Part("id") id: RequestBody,
        @Part("name") name: RequestBody,
        @Part("user_id") user_id: RequestBody,
        @Part("email") email: RequestBody,
        @Part("payment_url") payment_url: RequestBody,
        @Part("bank_details") bank_details: RequestBody,
        @Part("business_id") business_id: RequestBody,
        @Part("old_images") old_images: RequestBody,
        @Part pmethod_image: MultipartBody.Part,
    ): Call<BusinessListStepOneModel>

    //todo step-1 delete item list...
    @GET("business_listing_delete_step_one/{id}")
    fun deleteStepOneItems(
        @Header("Authorization") authorization: String,
        @Path("id")id: String
    ): Call<StepOneItemListsModel>

    //todo -----------------------------------------

    //todo step -2 api body..
    @Multipart
    @POST("business-listing-add-step-two")
    fun addBusinessListingAddStepTwo(
        @Header("Authorization") authorization: String,
        @Part("user_id") user_id: RequestBody,
        @Part("name") name: RequestBody,
        @Part("business_id") business_id: RequestBody,
        @Part files: List<MultipartBody.Part>,
    ): Call<BusinessListStepOneModel>

    //todo step-2 item list...
    @GET("business-step-two-get/{id}")
    fun getBusinessStepTwoItemList(
        @Header("Authorization") authorization: String,
        @Path("id")id: String
    ): Call<StepOneItemListsModel>

    //todo step -2 update item api body..
    @Multipart
    @POST("business_listing_update_step_two")
    fun updateStepTwoItem(
        @Header("Authorization") authorization: String,
        @Part("id") id: RequestBody,
        @Part("name") name: RequestBody,
        @Part("user_id") user_id: RequestBody,
        @Part("business_id") business_id: RequestBody,
        @Part files: List<MultipartBody.Part>,
    ): Call<BusinessListStepOneModel>

    //todo step-1 delete item list...
    @GET("business_listing_delete_step_two/{id}")
    fun deleteStepTwoItems(
        @Header("Authorization") authorization: String,
        @Path("id")id: String
    ): Call<StepOneItemListsModel>

}