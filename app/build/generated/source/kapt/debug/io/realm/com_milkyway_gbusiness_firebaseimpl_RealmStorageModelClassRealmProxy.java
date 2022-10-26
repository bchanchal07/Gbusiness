package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxy extends com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass
    implements RealmObjectProxy, com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface {

    static final class RealmStorageModelClassColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long payMethodIndex;
        long paytypeIndex;
        long pay_idIndex;
        long invoice_idIndex;
        long user_idIndex;
        long capturedIndex;
        long transaction_idIndex;
        long bank_ref_noIndex;
        long order_statusIndex;
        long failure_messageIndex;
        long payment_modeIndex;
        long card_nameIndex;
        long currencyIndex;
        long amountIndex;
        long created_atIndex;
        long domain_nameIndex;
        long statusIndex;
        long workingStageIndex;

        RealmStorageModelClassColumnInfo(OsSchemaInfo schemaInfo) {
            super(18);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmStorageModelClass");
            this.payMethodIndex = addColumnDetails("payMethod", "payMethod", objectSchemaInfo);
            this.paytypeIndex = addColumnDetails("paytype", "paytype", objectSchemaInfo);
            this.pay_idIndex = addColumnDetails("pay_id", "pay_id", objectSchemaInfo);
            this.invoice_idIndex = addColumnDetails("invoice_id", "invoice_id", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.capturedIndex = addColumnDetails("captured", "captured", objectSchemaInfo);
            this.transaction_idIndex = addColumnDetails("transaction_id", "transaction_id", objectSchemaInfo);
            this.bank_ref_noIndex = addColumnDetails("bank_ref_no", "bank_ref_no", objectSchemaInfo);
            this.order_statusIndex = addColumnDetails("order_status", "order_status", objectSchemaInfo);
            this.failure_messageIndex = addColumnDetails("failure_message", "failure_message", objectSchemaInfo);
            this.payment_modeIndex = addColumnDetails("payment_mode", "payment_mode", objectSchemaInfo);
            this.card_nameIndex = addColumnDetails("card_name", "card_name", objectSchemaInfo);
            this.currencyIndex = addColumnDetails("currency", "currency", objectSchemaInfo);
            this.amountIndex = addColumnDetails("amount", "amount", objectSchemaInfo);
            this.created_atIndex = addColumnDetails("created_at", "created_at", objectSchemaInfo);
            this.domain_nameIndex = addColumnDetails("domain_name", "domain_name", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", "status", objectSchemaInfo);
            this.workingStageIndex = addColumnDetails("workingStage", "workingStage", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        RealmStorageModelClassColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmStorageModelClassColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmStorageModelClassColumnInfo src = (RealmStorageModelClassColumnInfo) rawSrc;
            final RealmStorageModelClassColumnInfo dst = (RealmStorageModelClassColumnInfo) rawDst;
            dst.payMethodIndex = src.payMethodIndex;
            dst.paytypeIndex = src.paytypeIndex;
            dst.pay_idIndex = src.pay_idIndex;
            dst.invoice_idIndex = src.invoice_idIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.capturedIndex = src.capturedIndex;
            dst.transaction_idIndex = src.transaction_idIndex;
            dst.bank_ref_noIndex = src.bank_ref_noIndex;
            dst.order_statusIndex = src.order_statusIndex;
            dst.failure_messageIndex = src.failure_messageIndex;
            dst.payment_modeIndex = src.payment_modeIndex;
            dst.card_nameIndex = src.card_nameIndex;
            dst.currencyIndex = src.currencyIndex;
            dst.amountIndex = src.amountIndex;
            dst.created_atIndex = src.created_atIndex;
            dst.domain_nameIndex = src.domain_nameIndex;
            dst.statusIndex = src.statusIndex;
            dst.workingStageIndex = src.workingStageIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private RealmStorageModelClassColumnInfo columnInfo;
    private ProxyState<com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass> proxyState;

    com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmStorageModelClassColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$payMethod() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.payMethodIndex);
    }

    @Override
    public void realmSet$payMethod(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.payMethodIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.payMethodIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.payMethodIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.payMethodIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$paytype() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.paytypeIndex);
    }

    @Override
    public void realmSet$paytype(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.paytypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.paytypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.paytypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.paytypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$pay_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.pay_idIndex);
    }

    @Override
    public void realmSet$pay_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.pay_idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.pay_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.pay_idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.pay_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$invoice_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.invoice_idIndex);
    }

    @Override
    public void realmSet$invoice_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.invoice_idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.invoice_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.invoice_idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.invoice_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$user_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.user_idIndex);
    }

    @Override
    public void realmSet$user_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.user_idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.user_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.user_idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.user_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$captured() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.capturedIndex);
    }

    @Override
    public void realmSet$captured(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.capturedIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.capturedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.capturedIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.capturedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$transaction_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.transaction_idIndex);
    }

    @Override
    public void realmSet$transaction_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.transaction_idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.transaction_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.transaction_idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.transaction_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$bank_ref_no() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.bank_ref_noIndex);
    }

    @Override
    public void realmSet$bank_ref_no(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.bank_ref_noIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.bank_ref_noIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.bank_ref_noIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.bank_ref_noIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$order_status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.order_statusIndex);
    }

    @Override
    public void realmSet$order_status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.order_statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.order_statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.order_statusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.order_statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$failure_message() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.failure_messageIndex);
    }

    @Override
    public void realmSet$failure_message(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.failure_messageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.failure_messageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.failure_messageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.failure_messageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$payment_mode() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.payment_modeIndex);
    }

    @Override
    public void realmSet$payment_mode(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.payment_modeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.payment_modeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.payment_modeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.payment_modeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$card_name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.card_nameIndex);
    }

    @Override
    public void realmSet$card_name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.card_nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.card_nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.card_nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.card_nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$currency() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.currencyIndex);
    }

    @Override
    public void realmSet$currency(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.currencyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.currencyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.currencyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.currencyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$amount() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.amountIndex);
    }

    @Override
    public void realmSet$amount(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.amountIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.amountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.amountIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.amountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$created_at() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.created_atIndex);
    }

    @Override
    public void realmSet$created_at(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.created_atIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.created_atIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.created_atIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.created_atIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$domain_name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.domain_nameIndex);
    }

    @Override
    public void realmSet$domain_name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.domain_nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.domain_nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.domain_nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.domain_nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusIndex);
    }

    @Override
    public void realmSet$status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$workingStage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.workingStageIndex);
    }

    @Override
    public void realmSet$workingStage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.workingStageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.workingStageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.workingStageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.workingStageIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmStorageModelClass", 18, 0);
        builder.addPersistedProperty("payMethod", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("paytype", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("pay_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("invoice_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("captured", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("transaction_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("bank_ref_no", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("order_status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("failure_message", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("payment_mode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("card_name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("currency", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("amount", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("created_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("domain_name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("workingStage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmStorageModelClassColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmStorageModelClassColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmStorageModelClass";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RealmStorageModelClass";
    }

    @SuppressWarnings("cast")
    public static com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass obj = realm.createObjectInternal(com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass.class, true, excludeFields);

        final com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface objProxy = (com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) obj;
        if (json.has("payMethod")) {
            if (json.isNull("payMethod")) {
                objProxy.realmSet$payMethod(null);
            } else {
                objProxy.realmSet$payMethod((String) json.getString("payMethod"));
            }
        }
        if (json.has("paytype")) {
            if (json.isNull("paytype")) {
                objProxy.realmSet$paytype(null);
            } else {
                objProxy.realmSet$paytype((String) json.getString("paytype"));
            }
        }
        if (json.has("pay_id")) {
            if (json.isNull("pay_id")) {
                objProxy.realmSet$pay_id(null);
            } else {
                objProxy.realmSet$pay_id((String) json.getString("pay_id"));
            }
        }
        if (json.has("invoice_id")) {
            if (json.isNull("invoice_id")) {
                objProxy.realmSet$invoice_id(null);
            } else {
                objProxy.realmSet$invoice_id((String) json.getString("invoice_id"));
            }
        }
        if (json.has("user_id")) {
            if (json.isNull("user_id")) {
                objProxy.realmSet$user_id(null);
            } else {
                objProxy.realmSet$user_id((String) json.getString("user_id"));
            }
        }
        if (json.has("captured")) {
            if (json.isNull("captured")) {
                objProxy.realmSet$captured(null);
            } else {
                objProxy.realmSet$captured((String) json.getString("captured"));
            }
        }
        if (json.has("transaction_id")) {
            if (json.isNull("transaction_id")) {
                objProxy.realmSet$transaction_id(null);
            } else {
                objProxy.realmSet$transaction_id((String) json.getString("transaction_id"));
            }
        }
        if (json.has("bank_ref_no")) {
            if (json.isNull("bank_ref_no")) {
                objProxy.realmSet$bank_ref_no(null);
            } else {
                objProxy.realmSet$bank_ref_no((String) json.getString("bank_ref_no"));
            }
        }
        if (json.has("order_status")) {
            if (json.isNull("order_status")) {
                objProxy.realmSet$order_status(null);
            } else {
                objProxy.realmSet$order_status((String) json.getString("order_status"));
            }
        }
        if (json.has("failure_message")) {
            if (json.isNull("failure_message")) {
                objProxy.realmSet$failure_message(null);
            } else {
                objProxy.realmSet$failure_message((String) json.getString("failure_message"));
            }
        }
        if (json.has("payment_mode")) {
            if (json.isNull("payment_mode")) {
                objProxy.realmSet$payment_mode(null);
            } else {
                objProxy.realmSet$payment_mode((String) json.getString("payment_mode"));
            }
        }
        if (json.has("card_name")) {
            if (json.isNull("card_name")) {
                objProxy.realmSet$card_name(null);
            } else {
                objProxy.realmSet$card_name((String) json.getString("card_name"));
            }
        }
        if (json.has("currency")) {
            if (json.isNull("currency")) {
                objProxy.realmSet$currency(null);
            } else {
                objProxy.realmSet$currency((String) json.getString("currency"));
            }
        }
        if (json.has("amount")) {
            if (json.isNull("amount")) {
                objProxy.realmSet$amount(null);
            } else {
                objProxy.realmSet$amount((String) json.getString("amount"));
            }
        }
        if (json.has("created_at")) {
            if (json.isNull("created_at")) {
                objProxy.realmSet$created_at(null);
            } else {
                objProxy.realmSet$created_at((String) json.getString("created_at"));
            }
        }
        if (json.has("domain_name")) {
            if (json.isNull("domain_name")) {
                objProxy.realmSet$domain_name(null);
            } else {
                objProxy.realmSet$domain_name((String) json.getString("domain_name"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                objProxy.realmSet$status(null);
            } else {
                objProxy.realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("workingStage")) {
            if (json.isNull("workingStage")) {
                objProxy.realmSet$workingStage(null);
            } else {
                objProxy.realmSet$workingStage((String) json.getString("workingStage"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass obj = new com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass();
        final com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface objProxy = (com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("payMethod")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$payMethod((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$payMethod(null);
                }
            } else if (name.equals("paytype")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$paytype((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$paytype(null);
                }
            } else if (name.equals("pay_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$pay_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$pay_id(null);
                }
            } else if (name.equals("invoice_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$invoice_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$invoice_id(null);
                }
            } else if (name.equals("user_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$user_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$user_id(null);
                }
            } else if (name.equals("captured")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$captured((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$captured(null);
                }
            } else if (name.equals("transaction_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$transaction_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$transaction_id(null);
                }
            } else if (name.equals("bank_ref_no")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$bank_ref_no((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$bank_ref_no(null);
                }
            } else if (name.equals("order_status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$order_status((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$order_status(null);
                }
            } else if (name.equals("failure_message")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$failure_message((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$failure_message(null);
                }
            } else if (name.equals("payment_mode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$payment_mode((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$payment_mode(null);
                }
            } else if (name.equals("card_name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$card_name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$card_name(null);
                }
            } else if (name.equals("currency")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$currency((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$currency(null);
                }
            } else if (name.equals("amount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$amount((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$amount(null);
                }
            } else if (name.equals("created_at")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$created_at((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$created_at(null);
                }
            } else if (name.equals("domain_name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$domain_name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$domain_name(null);
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$status(null);
                }
            } else if (name.equals("workingStage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$workingStage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$workingStage(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating uexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass.class), false, Collections.<String>emptyList());
        io.realm.com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxy obj = new io.realm.com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass copyOrUpdate(Realm realm, RealmStorageModelClassColumnInfo columnInfo, com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass copy(Realm realm, RealmStorageModelClassColumnInfo columnInfo, com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass) cachedRealmObject;
        }

        com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface realmObjectSource = (com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) newObject;

        Table table = realm.getTable(com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.payMethodIndex, realmObjectSource.realmGet$payMethod());
        builder.addString(columnInfo.paytypeIndex, realmObjectSource.realmGet$paytype());
        builder.addString(columnInfo.pay_idIndex, realmObjectSource.realmGet$pay_id());
        builder.addString(columnInfo.invoice_idIndex, realmObjectSource.realmGet$invoice_id());
        builder.addString(columnInfo.user_idIndex, realmObjectSource.realmGet$user_id());
        builder.addString(columnInfo.capturedIndex, realmObjectSource.realmGet$captured());
        builder.addString(columnInfo.transaction_idIndex, realmObjectSource.realmGet$transaction_id());
        builder.addString(columnInfo.bank_ref_noIndex, realmObjectSource.realmGet$bank_ref_no());
        builder.addString(columnInfo.order_statusIndex, realmObjectSource.realmGet$order_status());
        builder.addString(columnInfo.failure_messageIndex, realmObjectSource.realmGet$failure_message());
        builder.addString(columnInfo.payment_modeIndex, realmObjectSource.realmGet$payment_mode());
        builder.addString(columnInfo.card_nameIndex, realmObjectSource.realmGet$card_name());
        builder.addString(columnInfo.currencyIndex, realmObjectSource.realmGet$currency());
        builder.addString(columnInfo.amountIndex, realmObjectSource.realmGet$amount());
        builder.addString(columnInfo.created_atIndex, realmObjectSource.realmGet$created_at());
        builder.addString(columnInfo.domain_nameIndex, realmObjectSource.realmGet$domain_name());
        builder.addString(columnInfo.statusIndex, realmObjectSource.realmGet$status());
        builder.addString(columnInfo.workingStageIndex, realmObjectSource.realmGet$workingStage());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass.class);
        long tableNativePtr = table.getNativePtr();
        RealmStorageModelClassColumnInfo columnInfo = (RealmStorageModelClassColumnInfo) realm.getSchema().getColumnInfo(com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$payMethod = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$payMethod();
        if (realmGet$payMethod != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.payMethodIndex, rowIndex, realmGet$payMethod, false);
        }
        String realmGet$paytype = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$paytype();
        if (realmGet$paytype != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paytypeIndex, rowIndex, realmGet$paytype, false);
        }
        String realmGet$pay_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$pay_id();
        if (realmGet$pay_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pay_idIndex, rowIndex, realmGet$pay_id, false);
        }
        String realmGet$invoice_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$invoice_id();
        if (realmGet$invoice_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.invoice_idIndex, rowIndex, realmGet$invoice_id, false);
        }
        String realmGet$user_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$user_id();
        if (realmGet$user_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.user_idIndex, rowIndex, realmGet$user_id, false);
        }
        String realmGet$captured = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$captured();
        if (realmGet$captured != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.capturedIndex, rowIndex, realmGet$captured, false);
        }
        String realmGet$transaction_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$transaction_id();
        if (realmGet$transaction_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.transaction_idIndex, rowIndex, realmGet$transaction_id, false);
        }
        String realmGet$bank_ref_no = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$bank_ref_no();
        if (realmGet$bank_ref_no != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bank_ref_noIndex, rowIndex, realmGet$bank_ref_no, false);
        }
        String realmGet$order_status = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$order_status();
        if (realmGet$order_status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.order_statusIndex, rowIndex, realmGet$order_status, false);
        }
        String realmGet$failure_message = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$failure_message();
        if (realmGet$failure_message != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.failure_messageIndex, rowIndex, realmGet$failure_message, false);
        }
        String realmGet$payment_mode = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$payment_mode();
        if (realmGet$payment_mode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.payment_modeIndex, rowIndex, realmGet$payment_mode, false);
        }
        String realmGet$card_name = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$card_name();
        if (realmGet$card_name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.card_nameIndex, rowIndex, realmGet$card_name, false);
        }
        String realmGet$currency = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$currency();
        if (realmGet$currency != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.currencyIndex, rowIndex, realmGet$currency, false);
        }
        String realmGet$amount = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$amount();
        if (realmGet$amount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.amountIndex, rowIndex, realmGet$amount, false);
        }
        String realmGet$created_at = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        }
        String realmGet$domain_name = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$domain_name();
        if (realmGet$domain_name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.domain_nameIndex, rowIndex, realmGet$domain_name, false);
        }
        String realmGet$status = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        String realmGet$workingStage = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$workingStage();
        if (realmGet$workingStage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.workingStageIndex, rowIndex, realmGet$workingStage, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass.class);
        long tableNativePtr = table.getNativePtr();
        RealmStorageModelClassColumnInfo columnInfo = (RealmStorageModelClassColumnInfo) realm.getSchema().getColumnInfo(com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass.class);
        com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass object = null;
        while (objects.hasNext()) {
            object = (com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$payMethod = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$payMethod();
            if (realmGet$payMethod != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.payMethodIndex, rowIndex, realmGet$payMethod, false);
            }
            String realmGet$paytype = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$paytype();
            if (realmGet$paytype != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.paytypeIndex, rowIndex, realmGet$paytype, false);
            }
            String realmGet$pay_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$pay_id();
            if (realmGet$pay_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pay_idIndex, rowIndex, realmGet$pay_id, false);
            }
            String realmGet$invoice_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$invoice_id();
            if (realmGet$invoice_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.invoice_idIndex, rowIndex, realmGet$invoice_id, false);
            }
            String realmGet$user_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$user_id();
            if (realmGet$user_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.user_idIndex, rowIndex, realmGet$user_id, false);
            }
            String realmGet$captured = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$captured();
            if (realmGet$captured != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.capturedIndex, rowIndex, realmGet$captured, false);
            }
            String realmGet$transaction_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$transaction_id();
            if (realmGet$transaction_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.transaction_idIndex, rowIndex, realmGet$transaction_id, false);
            }
            String realmGet$bank_ref_no = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$bank_ref_no();
            if (realmGet$bank_ref_no != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.bank_ref_noIndex, rowIndex, realmGet$bank_ref_no, false);
            }
            String realmGet$order_status = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$order_status();
            if (realmGet$order_status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.order_statusIndex, rowIndex, realmGet$order_status, false);
            }
            String realmGet$failure_message = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$failure_message();
            if (realmGet$failure_message != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.failure_messageIndex, rowIndex, realmGet$failure_message, false);
            }
            String realmGet$payment_mode = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$payment_mode();
            if (realmGet$payment_mode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.payment_modeIndex, rowIndex, realmGet$payment_mode, false);
            }
            String realmGet$card_name = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$card_name();
            if (realmGet$card_name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.card_nameIndex, rowIndex, realmGet$card_name, false);
            }
            String realmGet$currency = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$currency();
            if (realmGet$currency != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.currencyIndex, rowIndex, realmGet$currency, false);
            }
            String realmGet$amount = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$amount();
            if (realmGet$amount != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.amountIndex, rowIndex, realmGet$amount, false);
            }
            String realmGet$created_at = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$created_at();
            if (realmGet$created_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
            }
            String realmGet$domain_name = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$domain_name();
            if (realmGet$domain_name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.domain_nameIndex, rowIndex, realmGet$domain_name, false);
            }
            String realmGet$status = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            }
            String realmGet$workingStage = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$workingStage();
            if (realmGet$workingStage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.workingStageIndex, rowIndex, realmGet$workingStage, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass.class);
        long tableNativePtr = table.getNativePtr();
        RealmStorageModelClassColumnInfo columnInfo = (RealmStorageModelClassColumnInfo) realm.getSchema().getColumnInfo(com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$payMethod = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$payMethod();
        if (realmGet$payMethod != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.payMethodIndex, rowIndex, realmGet$payMethod, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.payMethodIndex, rowIndex, false);
        }
        String realmGet$paytype = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$paytype();
        if (realmGet$paytype != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paytypeIndex, rowIndex, realmGet$paytype, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.paytypeIndex, rowIndex, false);
        }
        String realmGet$pay_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$pay_id();
        if (realmGet$pay_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pay_idIndex, rowIndex, realmGet$pay_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pay_idIndex, rowIndex, false);
        }
        String realmGet$invoice_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$invoice_id();
        if (realmGet$invoice_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.invoice_idIndex, rowIndex, realmGet$invoice_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.invoice_idIndex, rowIndex, false);
        }
        String realmGet$user_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$user_id();
        if (realmGet$user_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.user_idIndex, rowIndex, realmGet$user_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.user_idIndex, rowIndex, false);
        }
        String realmGet$captured = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$captured();
        if (realmGet$captured != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.capturedIndex, rowIndex, realmGet$captured, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.capturedIndex, rowIndex, false);
        }
        String realmGet$transaction_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$transaction_id();
        if (realmGet$transaction_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.transaction_idIndex, rowIndex, realmGet$transaction_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.transaction_idIndex, rowIndex, false);
        }
        String realmGet$bank_ref_no = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$bank_ref_no();
        if (realmGet$bank_ref_no != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bank_ref_noIndex, rowIndex, realmGet$bank_ref_no, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.bank_ref_noIndex, rowIndex, false);
        }
        String realmGet$order_status = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$order_status();
        if (realmGet$order_status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.order_statusIndex, rowIndex, realmGet$order_status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.order_statusIndex, rowIndex, false);
        }
        String realmGet$failure_message = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$failure_message();
        if (realmGet$failure_message != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.failure_messageIndex, rowIndex, realmGet$failure_message, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.failure_messageIndex, rowIndex, false);
        }
        String realmGet$payment_mode = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$payment_mode();
        if (realmGet$payment_mode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.payment_modeIndex, rowIndex, realmGet$payment_mode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.payment_modeIndex, rowIndex, false);
        }
        String realmGet$card_name = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$card_name();
        if (realmGet$card_name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.card_nameIndex, rowIndex, realmGet$card_name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.card_nameIndex, rowIndex, false);
        }
        String realmGet$currency = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$currency();
        if (realmGet$currency != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.currencyIndex, rowIndex, realmGet$currency, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.currencyIndex, rowIndex, false);
        }
        String realmGet$amount = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$amount();
        if (realmGet$amount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.amountIndex, rowIndex, realmGet$amount, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.amountIndex, rowIndex, false);
        }
        String realmGet$created_at = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
        }
        String realmGet$domain_name = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$domain_name();
        if (realmGet$domain_name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.domain_nameIndex, rowIndex, realmGet$domain_name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.domain_nameIndex, rowIndex, false);
        }
        String realmGet$status = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        String realmGet$workingStage = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$workingStage();
        if (realmGet$workingStage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.workingStageIndex, rowIndex, realmGet$workingStage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.workingStageIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass.class);
        long tableNativePtr = table.getNativePtr();
        RealmStorageModelClassColumnInfo columnInfo = (RealmStorageModelClassColumnInfo) realm.getSchema().getColumnInfo(com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass.class);
        com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass object = null;
        while (objects.hasNext()) {
            object = (com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$payMethod = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$payMethod();
            if (realmGet$payMethod != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.payMethodIndex, rowIndex, realmGet$payMethod, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.payMethodIndex, rowIndex, false);
            }
            String realmGet$paytype = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$paytype();
            if (realmGet$paytype != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.paytypeIndex, rowIndex, realmGet$paytype, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.paytypeIndex, rowIndex, false);
            }
            String realmGet$pay_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$pay_id();
            if (realmGet$pay_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pay_idIndex, rowIndex, realmGet$pay_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.pay_idIndex, rowIndex, false);
            }
            String realmGet$invoice_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$invoice_id();
            if (realmGet$invoice_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.invoice_idIndex, rowIndex, realmGet$invoice_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.invoice_idIndex, rowIndex, false);
            }
            String realmGet$user_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$user_id();
            if (realmGet$user_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.user_idIndex, rowIndex, realmGet$user_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.user_idIndex, rowIndex, false);
            }
            String realmGet$captured = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$captured();
            if (realmGet$captured != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.capturedIndex, rowIndex, realmGet$captured, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.capturedIndex, rowIndex, false);
            }
            String realmGet$transaction_id = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$transaction_id();
            if (realmGet$transaction_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.transaction_idIndex, rowIndex, realmGet$transaction_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.transaction_idIndex, rowIndex, false);
            }
            String realmGet$bank_ref_no = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$bank_ref_no();
            if (realmGet$bank_ref_no != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.bank_ref_noIndex, rowIndex, realmGet$bank_ref_no, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.bank_ref_noIndex, rowIndex, false);
            }
            String realmGet$order_status = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$order_status();
            if (realmGet$order_status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.order_statusIndex, rowIndex, realmGet$order_status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.order_statusIndex, rowIndex, false);
            }
            String realmGet$failure_message = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$failure_message();
            if (realmGet$failure_message != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.failure_messageIndex, rowIndex, realmGet$failure_message, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.failure_messageIndex, rowIndex, false);
            }
            String realmGet$payment_mode = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$payment_mode();
            if (realmGet$payment_mode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.payment_modeIndex, rowIndex, realmGet$payment_mode, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.payment_modeIndex, rowIndex, false);
            }
            String realmGet$card_name = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$card_name();
            if (realmGet$card_name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.card_nameIndex, rowIndex, realmGet$card_name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.card_nameIndex, rowIndex, false);
            }
            String realmGet$currency = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$currency();
            if (realmGet$currency != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.currencyIndex, rowIndex, realmGet$currency, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.currencyIndex, rowIndex, false);
            }
            String realmGet$amount = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$amount();
            if (realmGet$amount != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.amountIndex, rowIndex, realmGet$amount, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.amountIndex, rowIndex, false);
            }
            String realmGet$created_at = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$created_at();
            if (realmGet$created_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
            }
            String realmGet$domain_name = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$domain_name();
            if (realmGet$domain_name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.domain_nameIndex, rowIndex, realmGet$domain_name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.domain_nameIndex, rowIndex, false);
            }
            String realmGet$status = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
            }
            String realmGet$workingStage = ((com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) object).realmGet$workingStage();
            if (realmGet$workingStage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.workingStageIndex, rowIndex, realmGet$workingStage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.workingStageIndex, rowIndex, false);
            }
        }
    }

    public static com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass createDetachedCopy(com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass) cachedObject.object;
            }
            unmanagedObject = (com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface unmanagedCopy = (com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) unmanagedObject;
        com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface realmSource = (com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$payMethod(realmSource.realmGet$payMethod());
        unmanagedCopy.realmSet$paytype(realmSource.realmGet$paytype());
        unmanagedCopy.realmSet$pay_id(realmSource.realmGet$pay_id());
        unmanagedCopy.realmSet$invoice_id(realmSource.realmGet$invoice_id());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());
        unmanagedCopy.realmSet$captured(realmSource.realmGet$captured());
        unmanagedCopy.realmSet$transaction_id(realmSource.realmGet$transaction_id());
        unmanagedCopy.realmSet$bank_ref_no(realmSource.realmGet$bank_ref_no());
        unmanagedCopy.realmSet$order_status(realmSource.realmGet$order_status());
        unmanagedCopy.realmSet$failure_message(realmSource.realmGet$failure_message());
        unmanagedCopy.realmSet$payment_mode(realmSource.realmGet$payment_mode());
        unmanagedCopy.realmSet$card_name(realmSource.realmGet$card_name());
        unmanagedCopy.realmSet$currency(realmSource.realmGet$currency());
        unmanagedCopy.realmSet$amount(realmSource.realmGet$amount());
        unmanagedCopy.realmSet$created_at(realmSource.realmGet$created_at());
        unmanagedCopy.realmSet$domain_name(realmSource.realmGet$domain_name());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$workingStage(realmSource.realmGet$workingStage());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmStorageModelClass = proxy[");
        stringBuilder.append("{payMethod:");
        stringBuilder.append(realmGet$payMethod() != null ? realmGet$payMethod() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{paytype:");
        stringBuilder.append(realmGet$paytype() != null ? realmGet$paytype() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{pay_id:");
        stringBuilder.append(realmGet$pay_id() != null ? realmGet$pay_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{invoice_id:");
        stringBuilder.append(realmGet$invoice_id() != null ? realmGet$invoice_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user_id:");
        stringBuilder.append(realmGet$user_id() != null ? realmGet$user_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{captured:");
        stringBuilder.append(realmGet$captured() != null ? realmGet$captured() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{transaction_id:");
        stringBuilder.append(realmGet$transaction_id() != null ? realmGet$transaction_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bank_ref_no:");
        stringBuilder.append(realmGet$bank_ref_no() != null ? realmGet$bank_ref_no() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{order_status:");
        stringBuilder.append(realmGet$order_status() != null ? realmGet$order_status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{failure_message:");
        stringBuilder.append(realmGet$failure_message() != null ? realmGet$failure_message() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{payment_mode:");
        stringBuilder.append(realmGet$payment_mode() != null ? realmGet$payment_mode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{card_name:");
        stringBuilder.append(realmGet$card_name() != null ? realmGet$card_name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{currency:");
        stringBuilder.append(realmGet$currency() != null ? realmGet$currency() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{amount:");
        stringBuilder.append(realmGet$amount() != null ? realmGet$amount() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{created_at:");
        stringBuilder.append(realmGet$created_at() != null ? realmGet$created_at() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{domain_name:");
        stringBuilder.append(realmGet$domain_name() != null ? realmGet$domain_name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{workingStage:");
        stringBuilder.append(realmGet$workingStage() != null ? realmGet$workingStage() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxy aRealmStorageModelClass = (com_milkyway_gbusiness_firebaseimpl_RealmStorageModelClassRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmStorageModelClass.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmStorageModelClass.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmStorageModelClass.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
