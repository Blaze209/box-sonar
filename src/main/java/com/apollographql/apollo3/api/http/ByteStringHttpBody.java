package com.apollographql.apollo3.api.http;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: ByteStringHttpBody.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/apollographql/apollo3/api/http/ByteStringHttpBody;", "Lcom/apollographql/apollo3/api/http/HttpBody;", "contentType", "", "string", "(Ljava/lang/String;Ljava/lang/String;)V", "byteString", "Lokio/ByteString;", "(Ljava/lang/String;Lokio/ByteString;)V", "contentLength", "", "getContentLength", "()J", "getContentType", "()Ljava/lang/String;", "writeTo", "", "bufferedSink", "Lokio/BufferedSink;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ByteStringHttpBody implements HttpBody {
    private final ByteString byteString;
    private final String contentType;

    public ByteStringHttpBody(String contentType, ByteString byteString) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        this.contentType = contentType;
        this.byteString = byteString;
    }

    @Override // com.apollographql.apollo3.api.http.HttpBody
    public String getContentType() {
        return this.contentType;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ByteStringHttpBody(String contentType, String string) {
        this(contentType, ByteString.INSTANCE.encodeUtf8(string));
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(string, "string");
    }

    @Override // com.apollographql.apollo3.api.http.HttpBody
    public long getContentLength() {
        return this.byteString.size();
    }

    @Override // com.apollographql.apollo3.api.http.HttpBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSink, "bufferedSink");
        bufferedSink.write(this.byteString);
    }
}
