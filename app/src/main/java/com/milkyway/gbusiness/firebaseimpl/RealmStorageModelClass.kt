package com.milkyway.gbusiness.firebaseimpl

import io.realm.RealmObject

open class RealmStorageModelClass(var payMethod: String?= null,
                                  var paytype: String?= null,
                                  var pay_id: String?= null,
                                  var invoice_id: String?= null,
                                  var user_id: String?= null,
                                  var captured: String?= null,
                                  var transaction_id: String?= null,
                                  var bank_ref_no: String?= null,
                                  var order_status: String?= null,
                                  var failure_message: String?= null,
                                  var payment_mode: String?= null,
                                  var card_name: String?= null,
                                  var currency: String?= null,
                                  var amount: String?= null,
                                  var created_at: String?= null,
                                  var domain_name: String?= null,
                                  var status: String?= null,
                                  var workingStage: String?= null) : RealmObject()