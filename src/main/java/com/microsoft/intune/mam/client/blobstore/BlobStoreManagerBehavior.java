package com.microsoft.intune.mam.client.blobstore;

import android.app.blob.BlobHandle;
import android.app.blob.BlobStoreManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface BlobStoreManagerBehavior {
    void abandonSession(BlobStoreManager blobStoreManager, long j) throws IOException;

    void acquireLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle, int i) throws IOException;

    void acquireLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle, int i, long j) throws IOException;

    void acquireLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle, CharSequence charSequence) throws IOException;

    void acquireLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle, CharSequence charSequence, long j) throws IOException;

    long createSession(BlobStoreManager blobStoreManager, BlobHandle blobHandle) throws IOException;

    List<BlobHandle> getLeasedBlobs(BlobStoreManager blobStoreManager) throws IOException;

    BlobStoreManagerSessionBehavior getSessionBehavior();

    ParcelFileDescriptor openBlob(BlobStoreManager blobStoreManager, BlobHandle blobHandle) throws IOException;

    BlobStoreManager.Session openSession(BlobStoreManager blobStoreManager, long j) throws IOException;

    void releaseLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle) throws IOException;
}
