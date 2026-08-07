package external.sdk.pendo.io.glide.load.model.stream;

import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.model.GlideUrl;
import external.sdk.pendo.io.glide.load.model.b;
import external.sdk.pendo.io.glide.load.model.e;
import java.io.InputStream;
import java.net.URL;
import sdk.pendo.io.l.d;

/* JADX INFO: loaded from: classes4.dex */
public class UrlLoader implements b<URL, InputStream> {
    private final b<GlideUrl, InputStream> glideUrlLoader;

    public static class StreamFactory implements d<URL, InputStream> {
        @Override // sdk.pendo.io.l.d
        public b<URL, InputStream> build(e eVar) {
            return new UrlLoader(eVar.a(GlideUrl.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public UrlLoader(b<GlideUrl, InputStream> bVar) {
        this.glideUrlLoader = bVar;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(URL url) {
        return true;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<InputStream> buildLoadData(URL url, int i, int i2, Options options) {
        return this.glideUrlLoader.buildLoadData(new GlideUrl(url), i, i2, options);
    }
}
