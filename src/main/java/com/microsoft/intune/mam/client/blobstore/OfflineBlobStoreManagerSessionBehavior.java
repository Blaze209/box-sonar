package com.microsoft.intune.mam.client.blobstore;

import android.app.blob.BlobStoreManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineBlobStoreManagerSessionBehavior implements BlobStoreManagerSessionBehavior {
    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerSessionBehavior
    public ParcelFileDescriptor openWrite(BlobStoreManager.Session session, long j, long j2) throws IOException {
        return session.openWrite(j, j2);
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerSessionBehavior
    public ParcelFileDescriptor openRead(BlobStoreManager.Session session) throws IOException {
        return session.openRead();
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerSessionBehavior
    public long getSize(BlobStoreManager.Session session) throws IOException {
        return session.getSize();
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerSessionBehavior
    public void close(BlobStoreManager.Session session) throws IOException {
        session.close();
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerSessionBehavior
    public void abandon(BlobStoreManager.Session session) throws IOException {
        session.abandon();
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerSessionBehavior
    public void allowPackageAccess(BlobStoreManager.Session session, String str, byte[] bArr) throws IOException {
        session.allowPackageAccess(str, bArr);
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerSessionBehavior
    public boolean isPackageAccessAllowed(BlobStoreManager.Session session, String str, byte[] bArr) throws IOException {
        return session.isPackageAccessAllowed(str, bArr);
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerSessionBehavior
    public void allowSameSignatureAccess(BlobStoreManager.Session session) throws IOException {
        session.allowSameSignatureAccess();
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerSessionBehavior
    public boolean isSameSignatureAccessAllowed(BlobStoreManager.Session session) throws IOException {
        return session.isSameSignatureAccessAllowed();
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerSessionBehavior
    public void allowPublicAccess(BlobStoreManager.Session session) throws IOException {
        session.allowPublicAccess();
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerSessionBehavior
    public boolean isPublicAccessAllowed(BlobStoreManager.Session session) throws IOException {
        return session.isPublicAccessAllowed();
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerSessionBehavior
    public void commit(BlobStoreManager.Session session, Executor executor, Consumer<Integer> consumer) throws IOException {
        session.commit(executor, consumer);
    }
}
