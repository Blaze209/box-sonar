package com.microsoft.identity.common.internal.cache;

import com.box.androidsdk.content.models.BoxFile;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IStorageSupplier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: ClientActiveBrokerCache.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001\tB\u001d\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/microsoft/identity/common/internal/cache/ClientActiveBrokerCache;", "Lcom/microsoft/identity/common/internal/cache/BaseActiveBrokerCache;", "Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;", "storage", "Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;", "", BoxFile.FIELD_LOCK, "Lkotlinx/coroutines/sync/Mutex;", "(Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;Lkotlinx/coroutines/sync/Mutex;)V", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClientActiveBrokerCache extends BaseActiveBrokerCache implements IClientActiveBrokerCache {
    private static final String BROKER_METADATA_CACHE_STORE_ON_BROKER_SDK_SIDE_STORAGE_NAME = "BROKER_METADATA_CACHE_STORE_ON_BROKER_SDK_SIDE";
    private static final String BROKER_METADATA_CACHE_STORE_ON_CLIENT_SDK_SIDE_STORAGE_NAME = "BROKER_METADATA_CACHE_STORE_ON_CLIENT_SDK_SIDE";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Mutex sBrokerSdkSideLock = MutexKt.Mutex$default(false, 1, null);
    private static final Mutex sClientSdkSideLock = MutexKt.Mutex$default(false, 1, null);
    private final Mutex lock;
    private final INameValueStorage<String> storage;

    @JvmStatic
    public static final IClientActiveBrokerCache getBrokerSdkCache(IStorageSupplier iStorageSupplier) {
        return INSTANCE.getBrokerSdkCache(iStorageSupplier);
    }

    @JvmStatic
    public static final IClientActiveBrokerCache getClientSdkCache(IStorageSupplier iStorageSupplier) {
        return INSTANCE.getClientSdkCache(iStorageSupplier);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientActiveBrokerCache(INameValueStorage<String> storage, Mutex lock) {
        super(storage, lock);
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(lock, "lock");
        this.storage = storage;
        this.lock = lock;
    }

    /* JADX INFO: compiled from: ClientActiveBrokerCache.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/microsoft/identity/common/internal/cache/ClientActiveBrokerCache$Companion;", "", "()V", "BROKER_METADATA_CACHE_STORE_ON_BROKER_SDK_SIDE_STORAGE_NAME", "", "BROKER_METADATA_CACHE_STORE_ON_CLIENT_SDK_SIDE_STORAGE_NAME", "sBrokerSdkSideLock", "Lkotlinx/coroutines/sync/Mutex;", "sClientSdkSideLock", "getBrokerSdkCache", "Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;", "storageSupplier", "Lcom/microsoft/identity/common/java/interfaces/IStorageSupplier;", "getClientSdkCache", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IClientActiveBrokerCache getBrokerSdkCache(IStorageSupplier storageSupplier) {
            Intrinsics.checkNotNullParameter(storageSupplier, "storageSupplier");
            return new ClientActiveBrokerCache(storageSupplier.getEncryptedNameValueStore(ClientActiveBrokerCache.BROKER_METADATA_CACHE_STORE_ON_BROKER_SDK_SIDE_STORAGE_NAME, String.class), ClientActiveBrokerCache.sBrokerSdkSideLock);
        }

        @JvmStatic
        public final IClientActiveBrokerCache getClientSdkCache(IStorageSupplier storageSupplier) {
            Intrinsics.checkNotNullParameter(storageSupplier, "storageSupplier");
            return new ClientActiveBrokerCache(storageSupplier.getEncryptedNameValueStore(ClientActiveBrokerCache.BROKER_METADATA_CACHE_STORE_ON_CLIENT_SDK_SIDE_STORAGE_NAME, String.class), ClientActiveBrokerCache.sClientSdkSideLock);
        }
    }
}
