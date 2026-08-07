package com.pspdfkit.document.providers;

/* JADX INFO: loaded from: classes3.dex */
public interface DataProvider {
    public static final int FILE_SIZE_UNKNOWN = -1;
    public static final byte[] NO_DATA_AVAILABLE = new byte[0];

    long getSize();

    String getTitle();

    String getUid();

    byte[] read(long j, long j2);

    void release();
}
