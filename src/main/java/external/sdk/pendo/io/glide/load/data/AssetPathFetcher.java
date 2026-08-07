package external.sdk.pendo.io.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AssetPathFetcher<T> implements a<T> {
    private static final String TAG = "AssetPathFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private T data;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.assetManager = assetManager;
        this.assetPath = str;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void cancel() {
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void cleanup() {
        T t = this.data;
        if (t == null) {
            return;
        }
        try {
            close(t);
        } catch (IOException unused) {
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
    public void loadData(sdk.pendo.io.c.b bVar, a.InterfaceC0307a<? super T> interfaceC0307a) {
        try {
            T tLoadResource = loadResource(this.assetManager, this.assetPath);
            this.data = tLoadResource;
            interfaceC0307a.a(tLoadResource);
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to load data from asset manager", e);
            }
            interfaceC0307a.a((Exception) e);
        }
    }

    protected abstract T loadResource(AssetManager assetManager, String str);
}
