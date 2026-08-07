package com.microsoft.intune.mam.log;

import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: loaded from: classes3.dex */
public class MAMErrorLogRecord extends LogRecord {
    private final MAMErrorId mErrorId;

    public MAMErrorLogRecord(MAMErrorId mAMErrorId, String str) {
        super(Level.SEVERE, str);
        this.mErrorId = mAMErrorId;
    }

    public MAMErrorId getErrorId() {
        return this.mErrorId;
    }
}
