package com.microsoft.identity.common.components;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager;
import com.microsoft.identity.common.internal.util.SharedPrefStringNameValueStorage;
import com.microsoft.identity.common.internal.util.SharedPreferenceLongStorage;
import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.crypto.StorageEncryptionManager;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IStorageSupplier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidStorageSupplier.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/microsoft/identity/common/components/AndroidStorageSupplier;", "Lcom/microsoft/identity/common/java/interfaces/IStorageSupplier;", "context", "Landroid/content/Context;", "storageEncryptionManager", "Lcom/microsoft/identity/common/java/crypto/StorageEncryptionManager;", "(Landroid/content/Context;Lcom/microsoft/identity/common/java/crypto/StorageEncryptionManager;)V", "getEncryptedFileStore", "Lcom/microsoft/identity/common/java/cache/IMultiTypeNameValueStorage;", "storeName", "", "getEncryptedNameValueStore", "Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "getUnencryptedFileStore", "getUnencryptedNameValueStore", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidStorageSupplier implements IStorageSupplier {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private final StorageEncryptionManager storageEncryptionManager;

    public AndroidStorageSupplier(Context context, StorageEncryptionManager storageEncryptionManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageEncryptionManager, "storageEncryptionManager");
        this.context = context;
        this.storageEncryptionManager = storageEncryptionManager;
    }

    /* JADX INFO: compiled from: AndroidStorageSupplier.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/microsoft/identity/common/components/AndroidStorageSupplier$Companion;", "", "()V", "getNameValueStore", "Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;", ExifInterface.GPS_DIRECTION_TRUE, "context", "Landroid/content/Context;", "storeName", "", "clazz", "Ljava/lang/Class;", "storageEncryptionManager", "Lcom/microsoft/identity/common/java/crypto/StorageEncryptionManager;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> INameValueStorage<T> getNameValueStore(Context context, String storeName, Class<T> clazz, StorageEncryptionManager storageEncryptionManager) {
            SharedPreferencesFileManager sharedPreferences = SharedPreferencesFileManager.getSharedPreferences(context, storeName, storageEncryptionManager);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(con…storageEncryptionManager)");
            SharedPreferencesFileManager sharedPreferencesFileManager = sharedPreferences;
            if (Long.TYPE.isAssignableFrom(clazz) || Long.class.isAssignableFrom(clazz)) {
                return new SharedPreferenceLongStorage(sharedPreferencesFileManager);
            }
            if (String.class.isAssignableFrom(clazz) || String.class.isAssignableFrom(clazz)) {
                return new SharedPrefStringNameValueStorage(sharedPreferencesFileManager);
            }
            throw new UnsupportedOperationException("Only Long and String are natively supported as types");
        }
    }

    @Override // com.microsoft.identity.common.java.interfaces.IStorageSupplier
    public <T> INameValueStorage<T> getUnencryptedNameValueStore(String storeName, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(storeName, "storeName");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return INSTANCE.getNameValueStore(this.context, storeName, clazz, null);
    }

    @Override // com.microsoft.identity.common.java.interfaces.IStorageSupplier
    public <T> INameValueStorage<T> getEncryptedNameValueStore(String storeName, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(storeName, "storeName");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return INSTANCE.getNameValueStore(this.context, storeName, clazz, this.storageEncryptionManager);
    }

    @Override // com.microsoft.identity.common.java.interfaces.IStorageSupplier
    public IMultiTypeNameValueStorage getUnencryptedFileStore(String storeName) {
        Intrinsics.checkNotNullParameter(storeName, "storeName");
        SharedPreferencesFileManager sharedPreferences = SharedPreferencesFileManager.getSharedPreferences(this.context, storeName, null);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(context, storeName, null)");
        return sharedPreferences;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IStorageSupplier
    public IMultiTypeNameValueStorage getEncryptedFileStore(String storeName) {
        Intrinsics.checkNotNullParameter(storeName, "storeName");
        SharedPreferencesFileManager sharedPreferences = SharedPreferencesFileManager.getSharedPreferences(this.context, storeName, this.storageEncryptionManager);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(con…storageEncryptionManager)");
        return sharedPreferences;
    }
}
