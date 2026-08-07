package com.microsoft.identity.common.java.util;

import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes14.dex */
public class ClockSkewManager implements IClockSkewManager {
    private final INameValueStorage<Long> mClockSkewStorage;

    private static final class PreferencesMetadata {
        private static final String KEY_SKEW = "skew";

        private PreferencesMetadata() {
        }
    }

    public ClockSkewManager(INameValueStorage<Long> iNameValueStorage) {
        if (iNameValueStorage == null) {
            throw new NullPointerException("storage is marked non-null but is null");
        }
        this.mClockSkewStorage = iNameValueStorage;
    }

    @Override // com.microsoft.identity.common.java.util.IClockSkewManager
    public void onTimestampReceived(long j) {
        this.mClockSkewStorage.put("skew", Long.valueOf(getCurrentClientTime().getTime() - j));
    }

    @Override // com.microsoft.identity.common.java.util.IClockSkewManager
    public long getSkewMillis() {
        return this.mClockSkewStorage.get("skew").longValue();
    }

    @Override // com.microsoft.identity.common.java.util.IClockSkewManager
    public Date toClientTime(long j) {
        return new Date(j + getSkewMillis());
    }

    @Override // com.microsoft.identity.common.java.util.IClockSkewManager
    public Date toReferenceTime(long j) {
        return new Date(j - getSkewMillis());
    }

    @Override // com.microsoft.identity.common.java.util.IClockSkewManager
    public Date getCurrentClientTime() {
        return Calendar.getInstance().getTime();
    }

    @Override // com.microsoft.identity.common.java.util.IClockSkewManager
    public Date getAdjustedReferenceTime() {
        return toReferenceTime(getCurrentClientTime().getTime());
    }
}
