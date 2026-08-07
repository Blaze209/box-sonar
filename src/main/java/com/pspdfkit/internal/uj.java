package com.pspdfkit.internal;

import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: loaded from: classes3.dex */
public final class uj extends RequestBody {
    public final /* synthetic */ MediaType a;
    public final /* synthetic */ File b;
    public final /* synthetic */ wj c;

    public uj(wj wjVar, MediaType mediaType, File file) {
        this.c = wjVar;
        this.a = mediaType;
        this.b = file;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return this.b.length();
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentType */
    public final MediaType getMediaType() {
        return this.a;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        this.c.a(Okio.source(this.b), bufferedSink);
    }
}
