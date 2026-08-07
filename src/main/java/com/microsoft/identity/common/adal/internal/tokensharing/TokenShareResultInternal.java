package com.microsoft.identity.common.adal.internal.tokensharing;

import com.microsoft.identity.common.java.cache.ICacheRecord;

/* JADX INFO: loaded from: classes14.dex */
public class TokenShareResultInternal implements ITokenShareResultInternal {
    private final ICacheRecord mCacheRecord;
    private final String mFormat;
    private final String mRefreshToken;

    protected TokenShareResultInternal(ICacheRecord iCacheRecord, String str, String str2) {
        this.mCacheRecord = iCacheRecord;
        this.mRefreshToken = str;
        this.mFormat = str2;
    }

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareResultInternal
    public ICacheRecord getCacheRecord() {
        return this.mCacheRecord;
    }

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareResultInternal
    public String getFormat() {
        return this.mFormat;
    }

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareResultInternal
    public String getRefreshToken() {
        return this.mRefreshToken;
    }
}
