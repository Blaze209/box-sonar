package com.pspdfkit.internal;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: loaded from: classes3.dex */
public final class tj extends RequestBody {
    public final /* synthetic */ MediaType a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ wj c;

    public tj(wj wjVar, MediaType mediaType, byte[] bArr) {
        this.c = wjVar;
        this.a = mediaType;
        this.b = bArr;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return this.b.length;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentType */
    public final MediaType getMediaType() {
        return this.a;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        wj wjVar = this.c;
        byte[] bArr = this.b;
        wjVar.a(Okio.source(new ByteArrayInputStream(bArr, 0, bArr.length)), bufferedSink);
    }
}
