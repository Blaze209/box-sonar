package external.sdk.pendo.io.glide.load.resource.transcode;

import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.bytes.BytesResource;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawable;
import sdk.pendo.io.h.c;
import sdk.pendo.io.q.a;

/* JADX INFO: loaded from: classes4.dex */
public class GifDrawableBytesTranscoder implements a<GifDrawable, byte[]> {
    @Override // sdk.pendo.io.q.a
    public c<byte[]> transcode(c<GifDrawable> cVar, Options options) {
        return new BytesResource(sdk.pendo.io.y.a.c(cVar.get().getBuffer()));
    }
}
