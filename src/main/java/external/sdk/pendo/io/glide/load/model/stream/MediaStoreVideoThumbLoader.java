package external.sdk.pendo.io.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.mediastore.ThumbFetcher;
import external.sdk.pendo.io.glide.load.model.b;
import external.sdk.pendo.io.glide.load.model.e;
import external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.InputStream;
import sdk.pendo.io.g.a;
import sdk.pendo.io.l.d;

/* JADX INFO: loaded from: classes4.dex */
public class MediaStoreVideoThumbLoader implements b<Uri, InputStream> {
    private final Context context;

    public static class Factory implements d<Uri, InputStream> {
        private final Context context;

        public Factory(Context context) {
            this.context = context;
        }

        @Override // sdk.pendo.io.l.d
        public b<Uri, InputStream> build(e eVar) {
            return new MediaStoreVideoThumbLoader(this.context);
        }

        public void teardown() {
        }
    }

    public MediaStoreVideoThumbLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    private boolean isRequestingDefaultFrame(Options options) {
        Long l = (Long) options.get(VideoDecoder.TARGET_FRAME);
        return l != null && l.longValue() == -1;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<InputStream> buildLoadData(Uri uri, int i, int i2, Options options) {
        if (a.a(i, i2) && isRequestingDefaultFrame(options)) {
            return new b.a<>(new ObjectKey(uri), ThumbFetcher.buildVideoFetcher(this.context, uri));
        }
        return null;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Uri uri) {
        return a.d(uri);
    }
}
