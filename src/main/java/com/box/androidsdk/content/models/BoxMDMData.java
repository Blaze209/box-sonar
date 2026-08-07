package com.box.androidsdk.content.models;

import android.content.Context;
import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxMDMData extends BoxJsonObject {
    public static final String BILLING_ID = "billing_id";
    public static final String BOX_MDM_DATA = "box_mdm_data";
    public static final String BUNDLE_ID = "bundle_id";
    public static final String EMAIL_ID = "email_id";
    public static final String FEDRAMP_COMPLIANT = "fedramp_high";
    public static final String MANAGEMENT_ID = "management_id";
    public static final String PUBLIC_ID = "public_id";

    public BoxMDMData() {
    }

    public BoxMDMData(JsonObject jsonObject) {
        super(jsonObject);
    }

    public void setValue(String str, String str2) {
        set(str, str2);
    }

    public void setValue(String str, Boolean bool) {
        set(str, bool);
    }

    public void setBundleId(String str) {
        setValue(BUNDLE_ID, str);
    }

    public void setPublicId(String str) {
        setValue(PUBLIC_ID, str);
    }

    public void setManagementId(String str) {
        setValue(MANAGEMENT_ID, str);
    }

    public void setEmailId(String str) {
        setValue(EMAIL_ID, str);
    }

    public void setBillingId(String str) {
        setValue(BILLING_ID, str);
    }

    public String getBundleId() {
        return getPropertyAsString(PUBLIC_ID);
    }

    public String getPublicId() {
        return getPropertyAsString(PUBLIC_ID);
    }

    public String getManagementId() {
        return getPropertyAsString(MANAGEMENT_ID);
    }

    public String getEmailId() {
        return getPropertyAsString(EMAIL_ID);
    }

    public String getBillingIdId() {
        return getPropertyAsString(BILLING_ID);
    }

    public static BoxMDMData createMdmData(Context context, String str, String str2, String str3, String str4) {
        BoxMDMData boxMDMData = new BoxMDMData();
        boxMDMData.setPublicId(str);
        boxMDMData.setManagementId(str2);
        boxMDMData.setEmailId(str3);
        boxMDMData.setBillingId(str4);
        boxMDMData.setBundleId(context.getPackageName());
        return boxMDMData;
    }
}
