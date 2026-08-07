package external.sdk.pendo.io.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class FileDescriptorAssetPathFetcher extends AssetPathFetcher<AssetFileDescriptor> {
    public FileDescriptorAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // external.sdk.pendo.io.glide.load.data.AssetPathFetcher
    public void close(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // external.sdk.pendo.io.glide.load.data.AssetPathFetcher, external.sdk.pendo.io.glide.load.data.a
    public Class<AssetFileDescriptor> getDataClass() {
        return AssetFileDescriptor.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // external.sdk.pendo.io.glide.load.data.AssetPathFetcher
    public AssetFileDescriptor loadResource(AssetManager assetManager, String str) {
        return assetManager.openFd(str);
    }
}
