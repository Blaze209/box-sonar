package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeXMPMetadataRecord {
    final boolean mLocalizedText;
    final ArrayList<HashMap<String, String>> mMultipleValues;
    final String mSingleValue;

    public NativeXMPMetadataRecord(String str, ArrayList<HashMap<String, String>> arrayList, boolean z) {
        this.mSingleValue = str;
        this.mMultipleValues = arrayList;
        this.mLocalizedText = z;
    }

    public boolean equals(Object obj) {
        ArrayList<HashMap<String, String>> arrayList;
        if (!(obj instanceof NativeXMPMetadataRecord)) {
            return false;
        }
        NativeXMPMetadataRecord nativeXMPMetadataRecord = (NativeXMPMetadataRecord) obj;
        String str = this.mSingleValue;
        return ((str == null && nativeXMPMetadataRecord.mSingleValue == null) || (str != null && str.equals(nativeXMPMetadataRecord.mSingleValue))) && (((arrayList = this.mMultipleValues) == null && nativeXMPMetadataRecord.mMultipleValues == null) || (arrayList != null && arrayList.equals(nativeXMPMetadataRecord.mMultipleValues))) && this.mLocalizedText == nativeXMPMetadataRecord.mLocalizedText;
    }

    public boolean getLocalizedText() {
        return this.mLocalizedText;
    }

    public ArrayList<HashMap<String, String>> getMultipleValues() {
        return this.mMultipleValues;
    }

    public String getSingleValue() {
        return this.mSingleValue;
    }

    public int hashCode() {
        String str = this.mSingleValue;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
        ArrayList<HashMap<String, String>> arrayList = this.mMultipleValues;
        return ((iHashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31) + (this.mLocalizedText ? 1 : 0);
    }

    public String toString() {
        return "NativeXMPMetadataRecord{mSingleValue=" + this.mSingleValue + ",mMultipleValues=" + this.mMultipleValues + ",mLocalizedText=" + this.mLocalizedText + "}";
    }
}
