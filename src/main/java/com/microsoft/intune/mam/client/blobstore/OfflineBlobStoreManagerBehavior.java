package com.microsoft.intune.mam.client.blobstore;

import android.app.blob.BlobHandle;
import android.app.blob.BlobStoreManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineBlobStoreManagerBehavior implements BlobStoreManagerBehavior {
    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerBehavior
    public long createSession(BlobStoreManager blobStoreManager, BlobHandle blobHandle) throws IOException {
        return blobStoreManager.createSession(blobHandle);
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerBehavior
    public BlobStoreManager.Session openSession(BlobStoreManager blobStoreManager, long j) throws IOException {
        return blobStoreManager.openSession(j);
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerBehavior
    public void abandonSession(BlobStoreManager blobStoreManager, long j) throws IOException {
        blobStoreManager.abandonSession(j);
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerBehavior
    public ParcelFileDescriptor openBlob(BlobStoreManager blobStoreManager, BlobHandle blobHandle) throws IOException {
        return blobStoreManager.openBlob(blobHandle);
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerBehavior
    public void acquireLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle, int i, long j) throws IOException {
        blobStoreManager.acquireLease(blobHandle, i, j);
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerBehavior
    public void acquireLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle, CharSequence charSequence, long j) throws IOException {
        blobStoreManager.acquireLease(blobHandle, charSequence, j);
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerBehavior
    public void acquireLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle, int i) throws IOException {
        blobStoreManager.acquireLease(blobHandle, i);
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerBehavior
    public void acquireLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle, CharSequence charSequence) throws IOException {
        blobStoreManager.acquireLease(blobHandle, charSequence);
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerBehavior
    public void releaseLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle) throws IOException {
        blobStoreManager.releaseLease(blobHandle);
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerBehavior
    public List<BlobHandle> getLeasedBlobs(BlobStoreManager blobStoreManager) throws IOException {
        return blobStoreManager.getLeasedBlobs();
    }

    @Override // com.microsoft.intune.mam.client.blobstore.BlobStoreManagerBehavior
    public BlobStoreManagerSessionBehavior getSessionBehavior() {
        return new OfflineBlobStoreManagerSessionBehavior();
    }
}
