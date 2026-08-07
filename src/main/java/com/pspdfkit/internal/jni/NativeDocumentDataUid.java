package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDocumentDataUid {
    final String mDocumentUid;
    final long mLastAccessed;
    final long mLastUpdated;

    public NativeDocumentDataUid(String str, long j, long j2) {
        this.mDocumentUid = str;
        this.mLastUpdated = j;
        this.mLastAccessed = j2;
    }

    public String getDocumentUid() {
        return this.mDocumentUid;
    }

    public long getLastAccessed() {
        return this.mLastAccessed;
    }

    public long getLastUpdated() {
        return this.mLastUpdated;
    }

    public String toString() {
        return "NativeDocumentDataUid{mDocumentUid=" + this.mDocumentUid + ",mLastUpdated=" + this.mLastUpdated + ",mLastAccessed=" + this.mLastAccessed + "}";
    }
}
