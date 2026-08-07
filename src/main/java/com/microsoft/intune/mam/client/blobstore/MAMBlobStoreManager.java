package com.microsoft.intune.mam.client.blobstore;

import android.app.blob.BlobHandle;
import android.app.blob.BlobStoreManager;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.CachedBehaviorProvider;
import com.microsoft.intune.mam.client.app.LazyInit;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMBlobStoreManager {
    private static CachedBehaviorProvider<BlobStoreManagerBehavior> sCachedBehavior = new CachedBehaviorProvider<>(BlobStoreManagerBehavior.class);

    public static long createSession(BlobStoreManager blobStoreManager, BlobHandle blobHandle) throws IOException {
        return getBehavior().createSession(blobStoreManager, blobHandle);
    }

    public static BlobStoreManager.Session openSession(BlobStoreManager blobStoreManager, long j) throws IOException {
        return getBehavior().openSession(blobStoreManager, j);
    }

    public static void abandonSession(BlobStoreManager blobStoreManager, long j) throws IOException {
        getBehavior().abandonSession(blobStoreManager, j);
    }

    public static ParcelFileDescriptor openBlob(BlobStoreManager blobStoreManager, BlobHandle blobHandle) throws IOException {
        return getBehavior().openBlob(blobStoreManager, blobHandle);
    }

    public static void acquireLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle, int i, long j) throws IOException {
        getBehavior().acquireLease(blobStoreManager, blobHandle, i, j);
    }

    public static void acquireLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle, CharSequence charSequence, long j) throws IOException {
        getBehavior().acquireLease(blobStoreManager, blobHandle, charSequence, j);
    }

    public static void acquireLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle, int i) throws IOException {
        getBehavior().acquireLease(blobStoreManager, blobHandle, i);
    }

    public static void acquireLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle, CharSequence charSequence) throws IOException {
        getBehavior().acquireLease(blobStoreManager, blobHandle, charSequence);
    }

    public static void releaseLease(BlobStoreManager blobStoreManager, BlobHandle blobHandle) throws IOException {
        getBehavior().releaseLease(blobStoreManager, blobHandle);
    }

    public static List<BlobHandle> getLeasedBlobs(BlobStoreManager blobStoreManager) throws IOException {
        return getBehavior().getLeasedBlobs(blobStoreManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BlobStoreManagerBehavior getBehavior() {
        return sCachedBehavior.get();
    }

    private MAMBlobStoreManager() {
    }

    public static final class Session {
        private static LazyInit.Provider<BlobStoreManagerSessionBehavior> sCachedSessionBehavior = new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.blobstore.MAMBlobStoreManager$Session$$ExternalSyntheticLambda0
            @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
            public final Object get() {
                return MAMBlobStoreManager.getBehavior().getSessionBehavior();
            }
        };

        private Session() {
        }

        private static BlobStoreManagerSessionBehavior getSessionBehavior() {
            return sCachedSessionBehavior.get();
        }

        public static ParcelFileDescriptor openWrite(BlobStoreManager.Session session, long j, long j2) throws IOException {
            return getSessionBehavior().openWrite(session, j, j2);
        }

        public static ParcelFileDescriptor openRead(BlobStoreManager.Session session) throws IOException {
            return getSessionBehavior().openRead(session);
        }

        public static long getSize(BlobStoreManager.Session session) throws IOException {
            return getSessionBehavior().getSize(session);
        }

        public static void close(BlobStoreManager.Session session) throws IOException {
            getSessionBehavior().close(session);
        }

        public static void abandon(BlobStoreManager.Session session) throws IOException {
            getSessionBehavior().abandon(session);
        }

        public static void allowPackageAccess(BlobStoreManager.Session session, String str, byte[] bArr) throws IOException {
            getSessionBehavior().allowPackageAccess(session, str, bArr);
        }

        public static boolean isPackageAccessAllowed(BlobStoreManager.Session session, String str, byte[] bArr) throws IOException {
            return getSessionBehavior().isPackageAccessAllowed(session, str, bArr);
        }

        public static void allowSameSignatureAccess(BlobStoreManager.Session session) throws IOException {
            getSessionBehavior().allowSameSignatureAccess(session);
        }

        public static boolean isSameSignatureAccessAllowed(BlobStoreManager.Session session) throws IOException {
            return getSessionBehavior().isSameSignatureAccessAllowed(session);
        }

        public static void allowPublicAccess(BlobStoreManager.Session session) throws IOException {
            getSessionBehavior().allowPublicAccess(session);
        }

        public static boolean isPublicAccessAllowed(BlobStoreManager.Session session) throws IOException {
            return getSessionBehavior().isPublicAccessAllowed(session);
        }

        public static void commit(BlobStoreManager.Session session, Executor executor, Consumer<Integer> consumer) throws IOException {
            getSessionBehavior().commit(session, executor, consumer);
        }
    }
}
