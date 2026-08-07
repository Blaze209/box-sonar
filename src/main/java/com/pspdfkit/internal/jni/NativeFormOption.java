package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;
import com.pspdfkit.internal.z40;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeFormOption {
    final String mLabel;
    final String mValue;

    public NativeFormOption(String str, String str2) {
        this.mLabel = str;
        this.mValue = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NativeFormOption)) {
            return false;
        }
        NativeFormOption nativeFormOption = (NativeFormOption) obj;
        return this.mLabel.equals(nativeFormOption.mLabel) && this.mValue.equals(nativeFormOption.mValue);
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return this.mValue.hashCode() + z40.a(this.mLabel, 527, 31);
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeFormOption{mLabel=").append(this.mLabel).append(",mValue="), this.mValue, "}");
    }
}
