package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.interfaces.IStorageSupplier;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.microsoft.identity.common.logging.Logger;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WebAppsAccountIdRegistry.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0002J\u0016\u0010\u0017\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/microsoft/identity/common/internal/cache/WebAppsAccountIdRegistry;", "", "storage", "Lcom/microsoft/identity/common/java/cache/IMultiTypeNameValueStorage;", "(Lcom/microsoft/identity/common/java/cache/IMultiTypeNameValueStorage;)V", "addClient", "", "homeAccountId", "", "clientId", "contains", "", "deserializeSet", "", "raw", "getClients", "", "loadClientIdsForAccount", ArgumentException.REMOVE_ACCOUNT_OPERATION_NAME, "removeAccountStorage", "removeClient", "saveAccount", "set", "serializeSet", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebAppsAccountIdRegistry {
    private static final String WEBAPPS_ACCOUNT_ID_REGISTRY_STORAGE_KEY = "WebAppsAccountIdRegistryStorageKey";
    private final IMultiTypeNameValueStorage storage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "WebAppsAccountIdRegistry";
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public /* synthetic */ WebAppsAccountIdRegistry(IMultiTypeNameValueStorage iMultiTypeNameValueStorage, DefaultConstructorMarker defaultConstructorMarker) {
        this(iMultiTypeNameValueStorage);
    }

    private WebAppsAccountIdRegistry(IMultiTypeNameValueStorage iMultiTypeNameValueStorage) {
        this.storage = iMultiTypeNameValueStorage;
    }

    /* JADX INFO: compiled from: WebAppsAccountIdRegistry.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/internal/cache/WebAppsAccountIdRegistry$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "WEBAPPS_ACCOUNT_ID_REGISTRY_STORAGE_KEY", "rwLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/microsoft/identity/common/internal/cache/WebAppsAccountIdRegistry;", "supplier", "Lcom/microsoft/identity/common/java/interfaces/IStorageSupplier;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WebAppsAccountIdRegistry create(IStorageSupplier supplier) {
            Intrinsics.checkNotNullParameter(supplier, "supplier");
            return new WebAppsAccountIdRegistry(supplier.getEncryptedFileStore(WebAppsAccountIdRegistry.WEBAPPS_ACCOUNT_ID_REGISTRY_STORAGE_KEY), null);
        }
    }

    private final Set<String> deserializeSet(String raw) {
        String str = raw;
        if (str == null || StringsKt.isBlank(str)) {
            return new LinkedHashSet();
        }
        try {
            Object objDeserializeJsonStringToObject = ObjectMapper.deserializeJsonStringToObject(raw, String[].class);
            Intrinsics.checkNotNullExpressionValue(objDeserializeJsonStringToObject, "deserializeJsonStringToO…rray<String>::class.java)");
            return ArraysKt.toMutableSet((Object[]) objDeserializeJsonStringToObject);
        } catch (Exception e) {
            Logger.warn(TAG, "Failed to deserialize set: " + e.getMessage());
            return new LinkedHashSet();
        }
    }

    private final String serializeSet(Set<String> set) {
        String strSerializeObjectToJsonString = ObjectMapper.serializeObjectToJsonString(set);
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToJsonString, "serializeObjectToJsonString(set)");
        return strSerializeObjectToJsonString;
    }

    private final Set<String> loadClientIdsForAccount(String homeAccountId) {
        return deserializeSet(this.storage.getString(homeAccountId));
    }

    private final void saveAccount(String homeAccountId, Set<String> set) {
        this.storage.putString(homeAccountId, serializeSet(set));
    }

    private final void removeAccountStorage(String homeAccountId) {
        try {
            this.storage.remove(homeAccountId);
        } catch (Exception unused) {
            this.storage.putString(homeAccountId, null);
        }
    }

    public final void addClient(String homeAccountId, String clientId) {
        Intrinsics.checkNotNullParameter(homeAccountId, "homeAccountId");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        ReentrantReadWriteLock reentrantReadWriteLock = rwLock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            Set<String> setLoadClientIdsForAccount = loadClientIdsForAccount(homeAccountId);
            if (setLoadClientIdsForAccount.add(clientId)) {
                saveAccount(homeAccountId, setLoadClientIdsForAccount);
            }
            Unit unit = Unit.INSTANCE;
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
        } finally {
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final void removeClient(String homeAccountId, String clientId) {
        Intrinsics.checkNotNullParameter(homeAccountId, "homeAccountId");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        ReentrantReadWriteLock reentrantReadWriteLock = rwLock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            Set<String> setLoadClientIdsForAccount = loadClientIdsForAccount(homeAccountId);
            if (!setLoadClientIdsForAccount.remove(clientId)) {
                while (i < readHoldCount) {
                    lock.lock();
                    i++;
                }
                writeLock.unlock();
                return;
            }
            if (setLoadClientIdsForAccount.isEmpty()) {
                removeAccountStorage(homeAccountId);
            } else {
                saveAccount(homeAccountId, setLoadClientIdsForAccount);
            }
            Unit unit = Unit.INSTANCE;
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
        } catch (Throwable th) {
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final Set<String> getClients(String homeAccountId) {
        Intrinsics.checkNotNullParameter(homeAccountId, "homeAccountId");
        ReentrantReadWriteLock.ReadLock lock = rwLock.readLock();
        lock.lock();
        try {
            return CollectionsKt.toSet(loadClientIdsForAccount(homeAccountId));
        } finally {
            lock.unlock();
        }
    }

    public final boolean contains(String homeAccountId, String clientId) {
        Intrinsics.checkNotNullParameter(homeAccountId, "homeAccountId");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        ReentrantReadWriteLock.ReadLock lock = rwLock.readLock();
        lock.lock();
        try {
            return loadClientIdsForAccount(homeAccountId).contains(clientId);
        } finally {
            lock.unlock();
        }
    }

    public final void removeAccount(String homeAccountId) {
        Intrinsics.checkNotNullParameter(homeAccountId, "homeAccountId");
        ReentrantReadWriteLock reentrantReadWriteLock = rwLock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            if (loadClientIdsForAccount(homeAccountId).isEmpty()) {
                while (i < readHoldCount) {
                    lock.lock();
                    i++;
                }
                writeLock.unlock();
                return;
            }
            removeAccountStorage(homeAccountId);
            Unit unit = Unit.INSTANCE;
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
        } catch (Throwable th) {
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
            throw th;
        }
    }
}
