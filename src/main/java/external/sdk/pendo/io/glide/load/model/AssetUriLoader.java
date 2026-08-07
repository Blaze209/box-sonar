package external.sdk.pendo.io.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.FileDescriptorAssetPathFetcher;
import external.sdk.pendo.io.glide.load.data.StreamAssetPathFetcher;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class AssetUriLoader<Data> implements b<Uri, Data> {
    private static final String ASSET_PATH_SEGMENT = "android_asset";
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final int ASSET_PREFIX_LENGTH = 22;
    private final AssetManager assetManager;
    private final a<Data> factory;

    public static class FileDescriptorFactory implements sdk.pendo.io.l.d<Uri, AssetFileDescriptor>, a<AssetFileDescriptor> {
        private final AssetManager assetManager;

        public FileDescriptorFactory(AssetManager assetManager) {
            this.assetManager = assetManager;
        }

        @Override // sdk.pendo.io.l.d
        public b<Uri, AssetFileDescriptor> build(e eVar) {
            return new AssetUriLoader(this.assetManager, this);
        }

        @Override // external.sdk.pendo.io.glide.load.model.AssetUriLoader.a
        public external.sdk.pendo.io.glide.load.data.a<AssetFileDescriptor> buildFetcher(AssetManager assetManager, String str) {
            return new FileDescriptorAssetPathFetcher(assetManager, str);
        }

        public void teardown() {
        }
    }

    public static class StreamFactory implements sdk.pendo.io.l.d<Uri, InputStream>, a<InputStream> {
        private final AssetManager assetManager;

        public StreamFactory(AssetManager assetManager) {
            this.assetManager = assetManager;
        }

        @Override // sdk.pendo.io.l.d
        public b<Uri, InputStream> build(e eVar) {
            return new AssetUriLoader(this.assetManager, this);
        }

        @Override // external.sdk.pendo.io.glide.load.model.AssetUriLoader.a
        public external.sdk.pendo.io.glide.load.data.a<InputStream> buildFetcher(AssetManager assetManager, String str) {
            return new StreamAssetPathFetcher(assetManager, str);
        }

        public void teardown() {
        }
    }

    public interface a<Data> {
        external.sdk.pendo.io.glide.load.data.a<Data> buildFetcher(AssetManager assetManager, String str);
    }

    public AssetUriLoader(AssetManager assetManager, a<Data> aVar) {
        this.assetManager = assetManager;
        this.factory = aVar;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<Data> buildLoadData(Uri uri, int i, int i2, Options options) {
        return new b.a<>(new ObjectKey(uri), this.factory.buildFetcher(this.assetManager, uri.toString().substring(ASSET_PREFIX_LENGTH)));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && ASSET_PATH_SEGMENT.equals(uri.getPathSegments().get(0));
    }
}
