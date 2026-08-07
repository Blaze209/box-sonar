package com.microsoft.intune.mam.log;

import android.content.Intent;
import com.j256.ormlite.stmt.query.SimpleComparison;

/* JADX INFO: loaded from: classes3.dex */
public class PIIIntent implements PIIObj {
    private static final String NULL_INTENT = "<null intent>";
    private final String mIntentPIIFreeString;
    private final String mIntentPIIString;

    public PIIIntent(String str) {
        this.mIntentPIIString = piiString(str);
        this.mIntentPIIFreeString = nonPIIString(str);
    }

    public PIIIntent(Intent intent) {
        this.mIntentPIIString = piiString(intent);
        this.mIntentPIIFreeString = nonPIIString(intent);
    }

    @Override // com.microsoft.intune.mam.log.PIIObj
    public String toString() {
        return this.mIntentPIIFreeString;
    }

    @Override // com.microsoft.intune.mam.log.PIIObj
    public String toStringPIIfull() {
        return this.mIntentPIIString;
    }

    private String piiString(String str) {
        return str == null ? NULL_INTENT : str;
    }

    private String piiString(Intent intent) {
        if (intent == null) {
            return piiString((String) null);
        }
        return "<action=" + intent.getAction() + ", type=" + intent.getType() + ", data=" + (intent.getData() == null ? "<null>" : intent.getData().toString()) + SimpleComparison.GREATER_THAN_OPERATION;
    }

    private String nonPIIString(String str) {
        if (str == null) {
            return NULL_INTENT;
        }
        return "Intent" + str.hashCode();
    }

    private String nonPIIString(Intent intent) {
        if (intent == null) {
            return nonPIIString((String) null);
        }
        return "<action=" + intent.getAction() + ", type=" + intent.getType() + ", scheme=" + (intent.getData() == null ? "<null>" : intent.getData().getScheme()) + SimpleComparison.GREATER_THAN_OPERATION;
    }
}
