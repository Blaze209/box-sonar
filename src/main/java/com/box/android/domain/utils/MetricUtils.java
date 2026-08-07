package com.box.android.domain.utils;

import com.box.android.data.persistence.legacy.PreviewStorage;
import kotlin.Metadata;

/* JADX INFO: compiled from: MetricUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/domain/utils/MetricUtils;", "", "<init>", "()V", "convertBytesToKBytes", "", "size", "", "(Ljava/lang/Long;)Ljava/lang/Double;", "convertKBytesToBytes", "convertBytesToBucket", "", "(Ljava/lang/Long;)Ljava/lang/String;", "KILOBYTE", "", "MEGABYTE", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetricUtils {
    public static final MetricUtils INSTANCE = new MetricUtils();
    private static final int KILOBYTE = 1024;
    private static final int MEGABYTE = 1048576;

    public final long convertKBytesToBytes(long size) {
        return size * ((long) 1024);
    }

    private MetricUtils() {
    }

    public final Double convertBytesToKBytes(Long size) {
        if (size == null) {
            return null;
        }
        size.longValue();
        return Double.valueOf(size.longValue() / ((double) 1024));
    }

    public final String convertBytesToBucket(Long size) {
        if (size == null) {
            return null;
        }
        long jLongValue = size.longValue();
        if (jLongValue < 102400) {
            return "lt-100KB";
        }
        if (jLongValue < 1048576) {
            return "100KB-1MB";
        }
        if (jLongValue < 5242880) {
            return "1MB-5MB";
        }
        if (jLongValue < 104857600) {
            return "5MB-100MB";
        }
        if (jLongValue < PreviewStorage.MAX_CACHE_SIZE) {
            return "100MB-500MB";
        }
        return "gte-500MB";
    }
}
