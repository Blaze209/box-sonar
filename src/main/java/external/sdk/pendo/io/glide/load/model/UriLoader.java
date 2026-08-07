package external.sdk.pendo.io.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.facebook.common.util.UriUtil;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import external.sdk.pendo.io.glide.load.data.FileDescriptorLocalUriFetcher;
import external.sdk.pendo.io.glide.load.data.StreamLocalUriFetcher;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class UriLoader<Data> implements b<Uri, Data> {
    private static final Set<String> SCHEMES = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", UriUtil.QUALIFIED_RESOURCE_SCHEME)));
    private final a<Data> factory;

    public static final class AssetFileDescriptorFactory implements sdk.pendo.io.l.d<Uri, AssetFileDescriptor>, a<AssetFileDescriptor> {
        private final ContentResolver contentResolver;
        private final boolean useMediaStoreApisIfAvailable;

        public AssetFileDescriptorFactory(ContentResolver contentResolver) {
            this(contentResolver, false);
        }

        @Override // external.sdk.pendo.io.glide.load.model.UriLoader.a
        public external.sdk.pendo.io.glide.load.data.a<AssetFileDescriptor> build(Uri uri) {
            return new AssetFileDescriptorLocalUriFetcher(this.contentResolver, uri, this.useMediaStoreApisIfAvailable);
        }

        public void teardown() {
        }

        public AssetFileDescriptorFactory(ContentResolver contentResolver, boolean z) {
            this.contentResolver = contentResolver;
            this.useMediaStoreApisIfAvailable = z;
        }

        @Override // sdk.pendo.io.l.d
        public b<Uri, AssetFileDescriptor> build(e eVar) {
            return new UriLoader(this);
        }
    }

    public static class FileDescriptorFactory implements sdk.pendo.io.l.d<Uri, ParcelFileDescriptor>, a<ParcelFileDescriptor> {
        private final ContentResolver contentResolver;
        private final boolean useMediaStoreApisIfAvailable;

        public FileDescriptorFactory(ContentResolver contentResolver) {
            this(contentResolver, false);
        }

        @Override // external.sdk.pendo.io.glide.load.model.UriLoader.a
        public external.sdk.pendo.io.glide.load.data.a<ParcelFileDescriptor> build(Uri uri) {
            return new FileDescriptorLocalUriFetcher(this.contentResolver, uri, this.useMediaStoreApisIfAvailable);
        }

        public void teardown() {
        }

        public FileDescriptorFactory(ContentResolver contentResolver, boolean z) {
            this.contentResolver = contentResolver;
            this.useMediaStoreApisIfAvailable = z;
        }

        @Override // sdk.pendo.io.l.d
        public b<Uri, ParcelFileDescriptor> build(e eVar) {
            return new UriLoader(this);
        }
    }

    public static class StreamFactory implements sdk.pendo.io.l.d<Uri, InputStream>, a<InputStream> {
        private final ContentResolver contentResolver;
        private final boolean useMediaStoreApisIfAvailable;

        public StreamFactory(ContentResolver contentResolver) {
            this(contentResolver, false);
        }

        @Override // external.sdk.pendo.io.glide.load.model.UriLoader.a
        public external.sdk.pendo.io.glide.load.data.a<InputStream> build(Uri uri) {
            return new StreamLocalUriFetcher(this.contentResolver, uri, this.useMediaStoreApisIfAvailable);
        }

        public void teardown() {
        }

        public StreamFactory(ContentResolver contentResolver, boolean z) {
            this.contentResolver = contentResolver;
            this.useMediaStoreApisIfAvailable = z;
        }

        @Override // sdk.pendo.io.l.d
        public b<Uri, InputStream> build(e eVar) {
            return new UriLoader(this);
        }
    }

    public interface a<Data> {
        external.sdk.pendo.io.glide.load.data.a<Data> build(Uri uri);
    }

    public UriLoader(a<Data> aVar) {
        this.factory = aVar;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<Data> buildLoadData(Uri uri, int i, int i2, Options options) {
        return new b.a<>(new ObjectKey(uri), this.factory.build(uri));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Uri uri) {
        return SCHEMES.contains(uri.getScheme());
    }
}
