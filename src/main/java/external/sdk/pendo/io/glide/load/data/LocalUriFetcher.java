package external.sdk.pendo.io.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LocalUriFetcher<T> implements a<T> {
    private static final String TAG = "LocalUriFetcher";
    private final ContentResolver contentResolver;
    private T data;
    private final Uri uri;
    protected final boolean useMediaStoreApisIfAvailable;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this(contentResolver, uri, false);
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void cancel() {
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void cleanup() {
        T t = this.data;
        if (t != null) {
            try {
                close(t);
            } catch (IOException unused) {
            }
        }
    }

    protected abstract void close(T t);

    @Override // external.sdk.pendo.io.glide.load.data.a
    public abstract /* synthetic */ Class getDataClass();

    @Override // external.sdk.pendo.io.glide.load.data.a
    public sdk.pendo.io.e.a getDataSource() {
        return sdk.pendo.io.e.a.LOCAL;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public final void loadData(sdk.pendo.io.c.b bVar, a.InterfaceC0307a<? super T> interfaceC0307a) {
        try {
            T tLoadResource = loadResource(this.uri, this.contentResolver);
            this.data = tLoadResource;
            interfaceC0307a.a(tLoadResource);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to open Uri", e);
            }
            interfaceC0307a.a((Exception) e);
        }
    }

    protected abstract T loadResource(Uri uri, ContentResolver contentResolver);

    protected AssetFileDescriptor openAssetFileDescriptor(Uri uri) {
        return (this.useMediaStoreApisIfAvailable && sdk.pendo.io.g.a.c(uri) && sdk.pendo.io.g.a.a()) ? sdk.pendo.io.g.a.a(uri, this.contentResolver) : MAMContentResolverManagement.openAssetFileDescriptor(this.contentResolver, uri, "r");
    }

    LocalUriFetcher(ContentResolver contentResolver, Uri uri, boolean z) {
        this.contentResolver = contentResolver;
        this.uri = uri;
        this.useMediaStoreApisIfAvailable = z;
    }
}
