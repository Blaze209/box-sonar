package dev.chrisbanes.haze;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: SimpleLruCache.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Ldev/chrisbanes/haze/CacheEntry;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "lastAccessTime", "", "getLastAccessTime", "()J", "setLastAccessTime", "(J)V", "updateAccessTime", "", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class CacheEntry<V> {
    private long lastAccessTime = Time_androidKt.epochTimeMillis();
    private final V value;

    public CacheEntry(V v) {
        this.value = v;
    }

    public final V getValue() {
        return this.value;
    }

    public final long getLastAccessTime() {
        return this.lastAccessTime;
    }

    public final void setLastAccessTime(long j) {
        this.lastAccessTime = j;
    }

    public final void updateAccessTime() {
        this.lastAccessTime = Time_androidKt.epochTimeMillis();
    }
}
