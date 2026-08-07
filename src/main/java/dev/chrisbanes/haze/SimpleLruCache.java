package dev.chrisbanes.haze;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.observability.DiagnosisParams;
import com.box.androidsdk.content.models.BoxIterator;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: SimpleLruCache.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ldev/chrisbanes/haze/SimpleLruCache;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", BoxIterator.FIELD_LIMIT, "", "<init>", "(I)V", "map", "", "Ldev/chrisbanes/haze/CacheEntry;", PasskeyWebListener.GET_UNIQUE_KEY, "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "set", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", DiagnosisParams.CLEAR_ON_LOGOUT, "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimpleLruCache<K, V> {
    public static final int $stable = 8;
    private final int limit;
    private final Map<K, CacheEntry<V>> map = new LinkedHashMap();

    public SimpleLruCache(int i) {
        this.limit = i;
    }

    public final V get(K key) {
        CacheEntry<V> cacheEntry = this.map.get(key);
        if (cacheEntry == null) {
            return null;
        }
        cacheEntry.updateAccessTime();
        return cacheEntry.getValue();
    }

    public final void set(K key, V value) {
        Object obj;
        this.map.put(key, new CacheEntry<>(value));
        while (this.map.size() > this.limit) {
            Iterator<T> it = this.map.entrySet().iterator();
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    long lastAccessTime = ((CacheEntry) ((Map.Entry) next).getValue()).getLastAccessTime();
                    do {
                        Object next2 = it.next();
                        long lastAccessTime2 = ((CacheEntry) ((Map.Entry) next2).getValue()).getLastAccessTime();
                        if (lastAccessTime > lastAccessTime2) {
                            next = next2;
                            lastAccessTime = lastAccessTime2;
                        }
                    } while (it.hasNext());
                }
                obj = next;
            } else {
                obj = null;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (entry != null) {
                this.map.remove(entry.getKey());
            }
        }
    }

    public final void clear() {
        this.map.clear();
    }
}
