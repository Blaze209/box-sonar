package com.microsoft.intune.mam.log;

/* JADX INFO: loaded from: classes3.dex */
public class PIIADAL implements PIIObj {
    public static final String HIDDEN_ADAL_LOG = "<hidden ADAL log>";
    private static final String NULL_LOG = "<null ADAL log>";
    private String mMessage;

    public PIIADAL(String str) {
        if (str == null) {
            this.mMessage = NULL_LOG;
        } else {
            this.mMessage = str;
        }
    }

    @Override // com.microsoft.intune.mam.log.PIIObj
    public String toString() {
        return HIDDEN_ADAL_LOG;
    }

    @Override // com.microsoft.intune.mam.log.PIIObj
    public String toStringPIIfull() {
        return this.mMessage;
    }
}
