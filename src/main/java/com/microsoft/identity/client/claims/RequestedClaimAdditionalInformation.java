package com.microsoft.identity.client.claims;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class RequestedClaimAdditionalInformation {

    @SerializedName("essential")
    private Boolean mEssential = false;

    @SerializedName("values")
    private List<Object> mValues = new ArrayList();

    @SerializedName("value")
    private Object mValue = null;

    public static final class SerializedNames {
        static final String ESSENTIAL = "essential";
        static final String VALUE = "value";
        static final String VALUES = "values";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestedClaimAdditionalInformation)) {
            return false;
        }
        RequestedClaimAdditionalInformation requestedClaimAdditionalInformation = (RequestedClaimAdditionalInformation) obj;
        Boolean bool = this.mEssential;
        if (bool == null ? requestedClaimAdditionalInformation.mEssential != null : !bool.equals(requestedClaimAdditionalInformation.mEssential)) {
            return false;
        }
        List<Object> list = this.mValues;
        if (list == null ? requestedClaimAdditionalInformation.mValues != null : !list.equals(requestedClaimAdditionalInformation.mValues)) {
            return false;
        }
        Object obj2 = this.mValue;
        if (obj2 != null) {
            return obj2.equals(requestedClaimAdditionalInformation.mValue);
        }
        return requestedClaimAdditionalInformation.mValue == null;
    }

    public int hashCode() {
        Boolean bool = this.mEssential;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        List<Object> list = this.mValues;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Object obj = this.mValue;
        return iHashCode2 + (obj != null ? obj.hashCode() : 0);
    }

    public void setEssential(Boolean bool) {
        this.mEssential = bool;
    }

    public Boolean getEssential() {
        return this.mEssential;
    }

    public List<Object> getValues() {
        return this.mValues;
    }

    public Object getValue() {
        return this.mValue;
    }

    public void setValue(Object obj) {
        this.mValue = obj;
    }

    public void setValues(List<Object> list) {
        this.mValues = list;
    }
}
