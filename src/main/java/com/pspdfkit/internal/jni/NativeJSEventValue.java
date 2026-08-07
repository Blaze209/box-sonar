package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSEventValue {
    final Double mNumberValue;
    final String mStringValue;

    public NativeJSEventValue(Double d, String str) {
        this.mNumberValue = d;
        this.mStringValue = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NativeJSEventValue)) {
            return false;
        }
        NativeJSEventValue nativeJSEventValue = (NativeJSEventValue) obj;
        Double d = this.mNumberValue;
        if ((d == null && nativeJSEventValue.mNumberValue == null) || (d != null && d.equals(nativeJSEventValue.mNumberValue))) {
            String str = this.mStringValue;
            if (str == null && nativeJSEventValue.mStringValue == null) {
                return true;
            }
            if (str != null && str.equals(nativeJSEventValue.mStringValue)) {
                return true;
            }
        }
        return false;
    }

    public Double getNumberValue() {
        return this.mNumberValue;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public int hashCode() {
        Double d = this.mNumberValue;
        int iHashCode = ((d == null ? 0 : d.hashCode()) + 527) * 31;
        String str = this.mStringValue;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeJSEventValue{mNumberValue=").append(this.mNumberValue).append(",mStringValue="), this.mStringValue, "}");
    }
}
