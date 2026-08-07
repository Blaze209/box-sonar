package sdk.pendo.io.y;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class h<T, Y> {
    private final Map<T, a<Y>> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    static final class a<Y> {
        final Y a;
        final int b;

        a(Y y, int i) {
            this.a = y;
            this.b = i;
        }
    }

    public h(long j) {
        this.initialMaxSize = j;
        this.maxSize = j;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0L);
    }

    public synchronized boolean contains(T t) {
        return this.cache.containsKey(t);
    }

    public synchronized Y get(T t) {
        a<Y> aVar;
        aVar = this.cache.get(t);
        return aVar != null ? aVar.a : null;
    }

    protected synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    protected int getSize(Y y) {
        return 1;
    }

    protected void onItemEvicted(T t, Y y) {
    }

    public synchronized Y put(T t, Y y) {
        int size = getSize(y);
        long j = size;
        if (j >= this.maxSize) {
            onItemEvicted(t, y);
            return null;
        }
        if (y != null) {
            this.currentSize += j;
        }
        a<Y> aVarPut = this.cache.put(t, y == null ? null : new a<>(y, size));
        if (aVarPut != null) {
            this.currentSize -= (long) aVarPut.b;
            if (!aVarPut.a.equals(y)) {
                onItemEvicted(t, aVarPut.a);
            }
        }
        evict();
        return aVarPut != null ? aVarPut.a : null;
    }

    public synchronized Y remove(T t) {
        a<Y> aVarRemove = this.cache.remove(t);
        if (aVarRemove == null) {
            return null;
        }
        this.currentSize -= (long) aVarRemove.b;
        return aVarRemove.a;
    }

    public synchronized void setSizeMultiplier(float f) {
        try {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Multiplier must be >= 0");
            }
            this.maxSize = Math.round(this.initialMaxSize * f);
            evict();
        } catch (Throwable th) {
            throw th;
        }
    }

    protected synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            Iterator<Map.Entry<T, a<Y>>> it = this.cache.entrySet().iterator();
            Map.Entry<T, a<Y>> next = it.next();
            a<Y> value = next.getValue();
            this.currentSize -= (long) value.b;
            T key = next.getKey();
            it.remove();
            onItemEvicted(key, value.a);
        }
    }
}
