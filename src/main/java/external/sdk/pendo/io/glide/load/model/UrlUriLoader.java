package external.sdk.pendo.io.glide.load.model;

import android.net.Uri;
import external.sdk.pendo.io.glide.load.Options;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class UrlUriLoader<Data> implements b<Uri, Data> {
    private static final Set<String> SCHEMES = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    private final b<GlideUrl, Data> urlLoader;

    public static class StreamFactory implements sdk.pendo.io.l.d<Uri, InputStream> {
        @Override // sdk.pendo.io.l.d
        public b<Uri, InputStream> build(e eVar) {
            return new UrlUriLoader(eVar.a(GlideUrl.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public UrlUriLoader(b<GlideUrl, Data> bVar) {
        this.urlLoader = bVar;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<Data> buildLoadData(Uri uri, int i, int i2, Options options) {
        return this.urlLoader.buildLoadData(new GlideUrl(uri.toString()), i, i2, options);
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Uri uri) {
        return SCHEMES.contains(uri.getScheme());
    }
}
