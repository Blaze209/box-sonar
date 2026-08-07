package external.sdk.pendo.io.glide.load.engine.bitmap_recycle;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public final class LruArrayPool implements sdk.pendo.io.i.a {
    private static final int DEFAULT_SIZE = 4194304;
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    private final Map<Class<?>, external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a<?>> adapters;
    private int currentSize;
    private final d<a, Object> groupedMap;
    private final b keyPool;
    private final int maxSize;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> sortedSizes;

    private static final class a implements f {
        private final b a;
        int b;
        private Class<?> c;

        a(b bVar) {
            this.a = bVar;
        }

        void a(int i, Class<?> cls) {
            this.b = i;
            this.c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.b == aVar.b && this.c == aVar.c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i = this.b * 31;
            Class<?> cls = this.c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.b + "array=" + this.c + AbstractJsonLexerKt.END_OBJ;
        }

        @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.f
        public void a() {
            this.a.a(this);
        }
    }

    private static final class b extends c<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a a(int i, Class<?> cls) {
            a aVarB = b();
            aVarB.a(i, cls);
            return aVarB;
        }
    }

    public LruArrayPool() {
        this.groupedMap = new d<>();
        this.keyPool = new b();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = 4194304;
    }

    private void decrementArrayOfSize(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
        Integer num = (Integer) sizesForAdapter.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        }
        if (num.intValue() == 1) {
            sizesForAdapter.remove(Integer.valueOf(i));
        } else {
            sizesForAdapter.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    private void evict() {
        evictToSize(this.maxSize);
    }

    private void evictToSize(int i) {
        while (this.currentSize > i) {
            Object objA = this.groupedMap.a();
            k.a(objA);
            external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a adapterFromObject = getAdapterFromObject(objA);
            this.currentSize -= adapterFromObject.getArrayLength(objA) * adapterFromObject.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromObject.getArrayLength(objA), objA.getClass());
            if (Log.isLoggable(adapterFromObject.getTag(), 2)) {
                Log.v(adapterFromObject.getTag(), "evicted: " + adapterFromObject.getArrayLength(objA));
            }
        }
    }

    private <T> external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a<T> getAdapterFromObject(T t) {
        return getAdapterFromType(t.getClass());
    }

    private <T> external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a<T> getAdapterFromType(Class<T> cls) {
        external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a<T> byteArrayAdapter;
        external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a<T> aVar = (external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a) this.adapters.get(cls);
        if (aVar != null) {
            return aVar;
        }
        if (cls.equals(int[].class)) {
            byteArrayAdapter = new IntegerArrayAdapter();
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            byteArrayAdapter = new ByteArrayAdapter();
        }
        this.adapters.put(cls, byteArrayAdapter);
        return byteArrayAdapter;
    }

    private <T> T getArrayForKey(a aVar) {
        return (T) this.groupedMap.a(aVar);
    }

    private <T> T getForKey(a aVar, Class<T> cls) {
        external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a<T> adapterFromType = getAdapterFromType(cls);
        T t = (T) getArrayForKey(aVar);
        if (t != null) {
            this.currentSize -= adapterFromType.getArrayLength(t) * adapterFromType.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromType.getArrayLength(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(adapterFromType.getTag(), 2)) {
            Log.v(adapterFromType.getTag(), "Allocated " + aVar.b + " bytes");
        }
        return adapterFromType.newArray(aVar.b);
    }

    private NavigableMap<Integer, Integer> getSizesForAdapter(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.sortedSizes.put(cls, treeMap);
        return treeMap;
    }

    private boolean isNoMoreThanHalfFull() {
        int i = this.currentSize;
        return i == 0 || this.maxSize / i >= 2;
    }

    private boolean isSmallEnoughForReuse(int i) {
        return i <= this.maxSize / 2;
    }

    private boolean mayFillRequest(int i, Integer num) {
        if (num != null) {
            return isNoMoreThanHalfFull() || num.intValue() <= i * 8;
        }
        return false;
    }

    @Override // sdk.pendo.io.i.a
    public synchronized void clearMemory() {
        evictToSize(0);
    }

    @Override // sdk.pendo.io.i.a
    public synchronized <T> T get(int i, Class<T> cls) {
        Integer numCeilingKey;
        numCeilingKey = getSizesForAdapter(cls).ceilingKey(Integer.valueOf(i));
        return (T) getForKey(mayFillRequest(i, numCeilingKey) ? this.keyPool.a(numCeilingKey.intValue(), cls) : this.keyPool.a(i, cls), cls);
    }

    int getCurrentSize() {
        int iIntValue = 0;
        for (Class<?> cls : this.sortedSizes.keySet()) {
            for (Integer num : this.sortedSizes.get(cls).keySet()) {
                iIntValue += num.intValue() * ((Integer) this.sortedSizes.get(cls).get(num)).intValue() * getAdapterFromType(cls).getElementSizeInBytes();
            }
        }
        return iIntValue;
    }

    @Override // sdk.pendo.io.i.a
    public synchronized <T> T getExact(int i, Class<T> cls) {
        return (T) getForKey(this.keyPool.a(i, cls), cls);
    }

    @Override // sdk.pendo.io.i.a
    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a<T> adapterFromType = getAdapterFromType(cls);
        int arrayLength = adapterFromType.getArrayLength(t);
        int elementSizeInBytes = adapterFromType.getElementSizeInBytes() * arrayLength;
        if (isSmallEnoughForReuse(elementSizeInBytes)) {
            a aVarA = this.keyPool.a(arrayLength, cls);
            this.groupedMap.a(aVarA, t);
            NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
            Integer num = (Integer) sizesForAdapter.get(Integer.valueOf(aVarA.b));
            Integer numValueOf = Integer.valueOf(aVarA.b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            sizesForAdapter.put(numValueOf, Integer.valueOf(iIntValue));
            this.currentSize += elementSizeInBytes;
            evict();
        }
    }

    @Override // sdk.pendo.io.i.a
    public synchronized void trimMemory(int i) {
        try {
            if (i >= 40) {
                clearMemory();
            } else if (i >= 20 || i == 15) {
                evictToSize(this.maxSize / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public LruArrayPool(int i) {
        this.groupedMap = new d<>();
        this.keyPool = new b();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = i;
    }

    @Deprecated
    public <T> void put(T t, Class<T> cls) {
        put(t);
    }
}
