package com.microsoft.identity.common.java.cache;

import com.box.android.observability.DiagnosisParams;
import com.google.gson.Gson;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public abstract class NameValueStorageFileManagerSimpleCacheImpl<T> implements ISimpleCache<T>, IListTypeToken {
    private static final String EMTPY_ARRAY = "[]";
    private static final String TAG = "NameValueStorageFileManagerSimpleCacheImpl";
    private static final String TIMING_TAG = "execWithTiming";
    private final IPlatformComponents mComponents;
    private final boolean mForceReinsertionOfDuplicates;
    private final Gson mGson;
    private final String mKeySingleEntry;
    private final INameValueStorage<String> mStorage;

    private interface NamedRunnable<V> extends Callable<V> {
        String getName();
    }

    public NameValueStorageFileManagerSimpleCacheImpl(IPlatformComponents iPlatformComponents, String str, String str2) {
        this(iPlatformComponents, str, str2, false);
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("singleKey is marked non-null but is null");
        }
    }

    public NameValueStorageFileManagerSimpleCacheImpl(IPlatformComponents iPlatformComponents, String str, String str2, boolean z) {
        this.mGson = new Gson();
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("singleKey is marked non-null but is null");
        }
        Logger.verbose(TAG + "::ctor", "Init");
        this.mComponents = iPlatformComponents;
        this.mStorage = iPlatformComponents.getStorageSupplier().getUnencryptedNameValueStore(str, String.class);
        this.mKeySingleEntry = str2;
        this.mForceReinsertionOfDuplicates = z;
    }

    private <V> V execWithTiming(NamedRunnable<V> namedRunnable) {
        if (namedRunnable == null) {
            throw new NullPointerException("runnable is marked non-null but is null");
        }
        long nanosecondTime = this.mComponents.getPlatformUtil().getNanosecondTime();
        try {
            try {
                V vCall = namedRunnable.call();
                Logger.verbose(TAG + TIMING_TAG, namedRunnable.getName() + " finished in: " + (this.mComponents.getPlatformUtil().getNanosecondTime() - nanosecondTime) + " " + TimeUnit.NANOSECONDS.name());
                return vCall;
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                StringBuilder sb = new StringBuilder();
                String str = TAG;
                Logger.error(sb.append(str).append(TIMING_TAG).toString(), "Error during operation", e);
                Logger.verbose(str + TIMING_TAG, namedRunnable.getName() + " finished in: " + (this.mComponents.getPlatformUtil().getNanosecondTime() - nanosecondTime) + " " + TimeUnit.NANOSECONDS.name());
                return null;
            }
        } catch (Throwable th) {
            Logger.verbose(TAG + TIMING_TAG, namedRunnable.getName() + " finished in: " + (this.mComponents.getPlatformUtil().getNanosecondTime() - nanosecondTime) + " " + TimeUnit.NANOSECONDS.name());
            throw th;
        }
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public boolean insert(final T t) {
        return ((Boolean) execWithTiming(new NamedRunnable<Boolean>() { // from class: com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.1
            @Override // com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.NamedRunnable
            public String getName() {
                return SemanticAttributes.FaasDocumentOperationValues.INSERT;
            }

            @Override // java.util.concurrent.Callable
            public Boolean call() {
                HashSet hashSet = new HashSet(NameValueStorageFileManagerSimpleCacheImpl.this.getAll());
                if (NameValueStorageFileManagerSimpleCacheImpl.this.mForceReinsertionOfDuplicates) {
                    hashSet.remove(t);
                }
                hashSet.add(t);
                NameValueStorageFileManagerSimpleCacheImpl.this.mStorage.put(NameValueStorageFileManagerSimpleCacheImpl.this.mKeySingleEntry, NameValueStorageFileManagerSimpleCacheImpl.this.mGson.toJson(hashSet));
                return true;
            }
        })).booleanValue();
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public boolean remove(final T t) {
        return ((Boolean) execWithTiming(new NamedRunnable<Boolean>() { // from class: com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.2
            @Override // com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.NamedRunnable
            public String getName() {
                return "remove";
            }

            @Override // java.util.concurrent.Callable
            public Boolean call() {
                HashSet hashSet = new HashSet(NameValueStorageFileManagerSimpleCacheImpl.this.getAll());
                hashSet.remove(t);
                NameValueStorageFileManagerSimpleCacheImpl.this.mStorage.put(NameValueStorageFileManagerSimpleCacheImpl.this.mKeySingleEntry, NameValueStorageFileManagerSimpleCacheImpl.this.mGson.toJson(hashSet));
                return true;
            }
        })).booleanValue();
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public List<T> getAll() {
        return (List) execWithTiming(new NamedRunnable<List<T>>() { // from class: com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.3
            @Override // com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.NamedRunnable
            public String getName() {
                return "getAll";
            }

            @Override // java.util.concurrent.Callable
            public List<T> call() {
                String str = (String) NameValueStorageFileManagerSimpleCacheImpl.this.mStorage.get(NameValueStorageFileManagerSimpleCacheImpl.this.mKeySingleEntry);
                if (StringUtil.isNullOrEmpty(str)) {
                    str = "[]";
                }
                return (List) NameValueStorageFileManagerSimpleCacheImpl.this.mGson.fromJson(str, NameValueStorageFileManagerSimpleCacheImpl.this.getListTypeToken());
            }
        });
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public boolean clear() {
        return ((Boolean) execWithTiming(new NamedRunnable<Boolean>() { // from class: com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.4
            @Override // com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.NamedRunnable
            public String getName() {
                return DiagnosisParams.CLEAR_ON_LOGOUT;
            }

            @Override // java.util.concurrent.Callable
            public Boolean call() {
                NameValueStorageFileManagerSimpleCacheImpl.this.mStorage.clear();
                return true;
            }
        })).booleanValue();
    }
}
