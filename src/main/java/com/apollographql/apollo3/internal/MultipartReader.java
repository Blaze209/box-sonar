package com.apollographql.apollo3.internal;

import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.exception.ApolloException;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.Source;
import okio.Timeout;
import org.apache.commons.io.IOUtils;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: MultipartReader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00060\u0001j\u0002`\u0002:\u0003\u001d\u001e\u001fB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/apollographql/apollo3/internal/MultipartReader;", "Ljava/io/Closeable;", "Lokio/Closeable;", "source", "Lokio/BufferedSource;", "boundary", "", "(Lokio/BufferedSource;Ljava/lang/String;)V", "afterBoundaryOptions", "Lokio/Options;", "getBoundary", "()Ljava/lang/String;", "closed", "", "crlfDashDashBoundary", "Lokio/ByteString;", "currentPart", "Lcom/apollographql/apollo3/internal/MultipartReader$PartSource;", "dashDashBoundary", "noMoreParts", "partCount", "", HeaderElements.CLOSE, "", "currentPartBytesRemaining", "", "maxResult", "nextPart", "Lcom/apollographql/apollo3/internal/MultipartReader$Part;", "Companion", "Part", "PartSource", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MultipartReader implements Closeable {
    private static final Companion Companion = new Companion(null);
    private final Options afterBoundaryOptions;
    private final String boundary;
    private boolean closed;
    private final ByteString crlfDashDashBoundary;
    private PartSource currentPart;
    private final ByteString dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final BufferedSource source;

    public MultipartReader(BufferedSource source, String boundary) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        this.source = source;
        this.boundary = boundary;
        this.dashDashBoundary = new Buffer().writeUtf8("--").writeUtf8(boundary).readByteString();
        this.crlfDashDashBoundary = new Buffer().writeUtf8("\r\n--").writeUtf8(boundary).readByteString();
        this.afterBoundaryOptions = Options.INSTANCE.of(ByteString.INSTANCE.encodeUtf8("\r\n--" + boundary + "--"), ByteString.INSTANCE.encodeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS), ByteString.INSTANCE.encodeUtf8("--"), ByteString.INSTANCE.encodeUtf8(" "), ByteString.INSTANCE.encodeUtf8("\t"));
    }

    public final String getBoundary() {
        return this.boundary;
    }

    public final Part nextPart() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.noMoreParts) {
            return null;
        }
        if (this.partCount == 0 && this.source.rangeEquals(0L, this.dashDashBoundary)) {
            this.source.skip(this.dashDashBoundary.size());
        } else {
            while (true) {
                long jCurrentPartBytesRemaining = currentPartBytesRemaining(8192L);
                if (jCurrentPartBytesRemaining == 0) {
                    break;
                }
                this.source.skip(jCurrentPartBytesRemaining);
            }
            this.source.skip(this.crlfDashDashBoundary.size());
        }
        boolean z = false;
        while (true) {
            int iSelect = this.source.select(this.afterBoundaryOptions);
            if (iSelect == -1) {
                throw new ApolloException("unexpected characters after boundary", null, 2, null);
            }
            if (iSelect == 0) {
                if (this.partCount == 0) {
                    throw new ApolloException("expected at least 1 part", null, 2, null);
                }
                this.noMoreParts = true;
                return null;
            }
            if (iSelect == 1) {
                this.partCount++;
                List headers = Companion.readHeaders(this.source);
                PartSource partSource = new PartSource();
                this.currentPart = partSource;
                return new Part(headers, Okio.buffer(partSource));
            }
            if (iSelect == 2) {
                if (z) {
                    throw new ApolloException("unexpected characters after boundary", null, 2, null);
                }
                if (this.partCount == 0) {
                    throw new ApolloException("expected at least 1 part", null, 2, null);
                }
                this.noMoreParts = true;
                return null;
            }
            if (iSelect == 3 || iSelect == 4) {
                z = true;
            }
        }
    }

    /* JADX INFO: compiled from: MultipartReader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/apollographql/apollo3/internal/MultipartReader$PartSource;", "Lokio/Source;", "(Lcom/apollographql/apollo3/internal/MultipartReader;)V", HeaderElements.CLOSE, "", "read", "", "sink", "Lokio/Buffer;", "byteCount", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "Lokio/Timeout;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class PartSource implements Source {
        public PartSource() {
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (Intrinsics.areEqual(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        @Override // okio.Source
        public long read(Buffer sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (byteCount >= 0) {
                if (Intrinsics.areEqual(MultipartReader.this.currentPart, this)) {
                    long jCurrentPartBytesRemaining = MultipartReader.this.currentPartBytesRemaining(byteCount);
                    if (jCurrentPartBytesRemaining == 0) {
                        return -1L;
                    }
                    return MultipartReader.this.source.read(sink, jCurrentPartBytesRemaining);
                }
                throw new IllegalStateException("closed".toString());
            }
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: timeout */
        public Timeout getTimeout() {
            return MultipartReader.this.source.getTimeout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentPartBytesRemaining(long maxResult) throws IOException {
        this.source.require(this.crlfDashDashBoundary.size());
        long jIndexOf = this.source.getBuffer().indexOf(this.crlfDashDashBoundary);
        if (jIndexOf == -1) {
            return Math.min(maxResult, (this.source.getBuffer().size() - ((long) this.crlfDashDashBoundary.size())) + 1);
        }
        return Math.min(maxResult, jIndexOf);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    /* JADX INFO: compiled from: MultipartReader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u000eH\u0096\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/apollographql/apollo3/internal/MultipartReader$Part;", "Ljava/io/Closeable;", "Lokio/Closeable;", "headers", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "body", "Lokio/BufferedSource;", "(Ljava/util/List;Lokio/BufferedSource;)V", "getBody", "()Lokio/BufferedSource;", "getHeaders", "()Ljava/util/List;", HeaderElements.CLOSE, "", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Part implements Closeable {
        private final BufferedSource body;
        private final List<HttpHeader> headers;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.body.close();
        }

        public Part(List<HttpHeader> headers, BufferedSource body) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(body, "body");
            this.headers = headers;
            this.body = body;
        }

        public final List<HttpHeader> getHeaders() {
            return this.headers;
        }

        public final BufferedSource getBody() {
            return this.body;
        }
    }

    /* JADX INFO: compiled from: MultipartReader.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"Lcom/apollographql/apollo3/internal/MultipartReader$Companion;", "", "()V", "readHeaders", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "source", "Lokio/BufferedSource;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<HttpHeader> readHeaders(BufferedSource source) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (true) {
                String utf8LineStrict = source.readUtf8LineStrict();
                String str = utf8LineStrict;
                if (str.length() == 0) {
                    return arrayList;
                }
                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, AbstractJsonLexerKt.COLON, 0, false, 6, (Object) null);
                if (iIndexOf$default == -1) {
                    throw new IllegalStateException(("Unexpected header: " + utf8LineStrict).toString());
                }
                String strSubstring = utf8LineStrict.substring(0, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String string = StringsKt.trim((CharSequence) strSubstring).toString();
                String strSubstring2 = utf8LineStrict.substring(iIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                arrayList.add(new HttpHeader(string, StringsKt.trim((CharSequence) strSubstring2).toString()));
            }
        }
    }
}
