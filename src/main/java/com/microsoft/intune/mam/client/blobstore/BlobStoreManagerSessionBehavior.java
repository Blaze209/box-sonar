package com.microsoft.intune.mam.client.blobstore;

import android.app.blob.BlobStoreManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public interface BlobStoreManagerSessionBehavior {
    void abandon(BlobStoreManager.Session session) throws IOException;

    void allowPackageAccess(BlobStoreManager.Session session, String str, byte[] bArr) throws IOException;

    void allowPublicAccess(BlobStoreManager.Session session) throws IOException;

    void allowSameSignatureAccess(BlobStoreManager.Session session) throws IOException;

    void close(BlobStoreManager.Session session) throws IOException;

    void commit(BlobStoreManager.Session session, Executor executor, Consumer<Integer> consumer) throws IOException;

    long getSize(BlobStoreManager.Session session) throws IOException;

    boolean isPackageAccessAllowed(BlobStoreManager.Session session, String str, byte[] bArr) throws IOException;

    boolean isPublicAccessAllowed(BlobStoreManager.Session session) throws IOException;

    boolean isSameSignatureAccessAllowed(BlobStoreManager.Session session) throws IOException;

    ParcelFileDescriptor openRead(BlobStoreManager.Session session) throws IOException;

    ParcelFileDescriptor openWrite(BlobStoreManager.Session session, long j, long j2) throws IOException;
}
