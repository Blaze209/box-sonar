package com.pspdfkit.forms;

import com.pspdfkit.internal.jni.NativeFormOption;
import com.pspdfkit.internal.nv;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public class FormOption {
    private final String label;
    private final String value;

    public FormOption(String str, String str2) {
        uw.a(str, "label", null);
        uw.a(str2, "value", null);
        this.label = str;
        this.value = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormOption)) {
            return false;
        }
        FormOption formOption = (FormOption) obj;
        return this.value.equals(formOption.value) && this.label.equals(formOption.label);
    }

    public String getLabel() {
        return this.label;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.label.hashCode() + (this.value.hashCode() * 31);
    }

    public String toString() {
        return nv.a(new StringBuilder("FormOption{value='").append(this.value).append("', label='"), this.label, "'}");
    }

    public FormOption(NativeFormOption nativeFormOption) {
        this.value = nativeFormOption.getValue();
        this.label = nativeFormOption.getLabel();
    }
}
