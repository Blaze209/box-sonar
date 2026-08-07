package com.microsoft.identity.common.java.interfaces;

import androidx.exifinterface.media.ExifInterface;
import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import kotlin.Metadata;

/* JADX INFO: compiled from: IStorageSupplier.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH&¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/java/interfaces/IStorageSupplier;", "", "getEncryptedFileStore", "Lcom/microsoft/identity/common/java/cache/IMultiTypeNameValueStorage;", "storeName", "", "getEncryptedNameValueStore", "Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "getUnencryptedFileStore", "getUnencryptedNameValueStore", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IStorageSupplier {
    IMultiTypeNameValueStorage getEncryptedFileStore(String storeName);

    <T> INameValueStorage<T> getEncryptedNameValueStore(String storeName, Class<T> clazz);

    IMultiTypeNameValueStorage getUnencryptedFileStore(String storeName);

    <T> INameValueStorage<T> getUnencryptedNameValueStore(String storeName, Class<T> clazz);
}
