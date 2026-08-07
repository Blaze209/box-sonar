package com.box.android.data.jobs;

import kotlin.Metadata;

/* JADX INFO: compiled from: DownloadFileJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"MIN_CHUNK_SIZE", "", "MAX_CHUNKS", "", "chunkSize", "fileSize", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DownloadFileJobKt {
    public static final int MAX_CHUNKS = 50;
    public static final long MIN_CHUNK_SIZE = 10000000;

    public static final long chunkSize(long j) {
        return j / MIN_CHUNK_SIZE > 50 ? j / ((long) 50) : MIN_CHUNK_SIZE;
    }
}
