package sdk.pendo.io.e2;

import androidx.collection.SieveCacheKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000 \r2\u00020\u0001:\u0002\t\rB\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\nH&J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/e2/e0;", "Ljava/io/Closeable;", "Ljava/nio/charset/Charset;", "d", "Lsdk/pendo/io/e2/x;", "f", "", "e", "Ljava/io/InputStream;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/f;", "g", "", "b", "Ljava/io/Reader;", "c", "", CmcdData.STREAMING_FORMAT_HLS, "", HeaderElements.CLOSE, "Ljava/io/Reader;", "reader", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public abstract class e0 implements Closeable {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private Reader reader;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/e2/e0$a;", "Ljava/io/Reader;", "", "cbuf", "", "off", "len", "read", "", HeaderElements.CLOSE, "Lsdk/pendo/io/s2/f;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/f;", "source", "Ljava/nio/charset/Charset;", "b", "Ljava/nio/charset/Charset;", "charset", "", "c", "Z", "closed", "d", "Ljava/io/Reader;", "delegate", "<init>", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a extends Reader {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final sdk.pendo.io.s2.f source;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final Charset charset;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private boolean closed;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private Reader delegate;

        public a(sdk.pendo.io.s2.f source, Charset charset) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Unit unit;
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cbuf, int off, int len) throws IOException {
            Intrinsics.checkNotNullParameter(cbuf, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.delegate;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.source.inputStream(), sdk.pendo.io.f2.b.a(this.source, this.charset));
                this.delegate = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, off, len);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.e2.e0$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\tJ)\u0010\u0006\u001a\u00020\u0005*\u00020\n2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0006\u0010\rJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0007J\"\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/e2/e0$b;", "", "", "Lsdk/pendo/io/e2/x;", "contentType", "Lsdk/pendo/io/e2/e0;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/String;Lsdk/pendo/io/e2/x;)Lsdk/pendo/io/e2/e0;", "", "([BLsdk/pendo/io/e2/x;)Lsdk/pendo/io/e2/e0;", "Lsdk/pendo/io/s2/f;", "", "contentLength", "(Lsdk/pendo/io/s2/f;Lsdk/pendo/io/e2/x;J)Lsdk/pendo/io/e2/e0;", "content", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: sdk.pendo.io.e2.e0$b$a */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"sdk/pendo/io/e2/e0$b$a", "Lsdk/pendo/io/e2/e0;", "Lsdk/pendo/io/e2/x;", "f", "", "e", "Lsdk/pendo/io/s2/f;", "g", "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class a extends e0 {
            final /* synthetic */ x c;
            final /* synthetic */ long d;
            final /* synthetic */ sdk.pendo.io.s2.f e;

            a(x xVar, long j, sdk.pendo.io.s2.f fVar) {
                this.c = xVar;
                this.d = j;
                this.e = fVar;
            }

            @Override // sdk.pendo.io.e2.e0
            /* JADX INFO: renamed from: e, reason: from getter */
            public long getD() {
                return this.d;
            }

            @Override // sdk.pendo.io.e2.e0
            /* JADX INFO: renamed from: f, reason: from getter */
            public x getC() {
                return this.c;
            }

            @Override // sdk.pendo.io.e2.e0
            /* JADX INFO: renamed from: g, reason: from getter */
            public sdk.pendo.io.s2.f getE() {
                return this.e;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final e0 a(String str, x xVar) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Charset charsetA = Charsets.UTF_8;
            if (xVar != null && (charsetA = x.a(xVar, null, 1, null)) == null) {
                charsetA = Charsets.UTF_8;
                xVar = x.INSTANCE.b(xVar + "; charset=utf-8");
            }
            sdk.pendo.io.s2.d dVarA = new sdk.pendo.io.s2.d().a(str, charsetA);
            return a(dVarA, xVar, dVarA.getSize());
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"external.sdk.pendo.io.okhttp3.ResponseBody.Companion.asResponseBody"}))
        @JvmStatic
        public final e0 a(x contentType, long contentLength, sdk.pendo.io.s2.f content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return a(content, contentType, contentLength);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"external.sdk.pendo.io.okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        public final e0 a(x contentType, String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return a(content, contentType);
        }

        @JvmStatic
        public final e0 a(sdk.pendo.io.s2.f fVar, x xVar, long j) {
            Intrinsics.checkNotNullParameter(fVar, "<this>");
            return new a(xVar, j, fVar);
        }

        @JvmStatic
        public final e0 a(byte[] bArr, x xVar) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            return a(new sdk.pendo.io.s2.d().write(bArr), xVar, bArr.length);
        }

        public static /* synthetic */ e0 a(Companion companion, byte[] bArr, x xVar, int i, Object obj) {
            if ((i & 1) != 0) {
                xVar = null;
            }
            return companion.a(bArr, xVar);
        }
    }

    private final Charset d() {
        Charset charsetA;
        x c = getC();
        return (c == null || (charsetA = c.a(Charsets.UTF_8)) == null) ? Charsets.UTF_8 : charsetA;
    }

    public final InputStream a() {
        return getE().inputStream();
    }

    public final byte[] b() throws IOException {
        long d = getD();
        if (d > SieveCacheKt.NodeLinkMask) {
            throw new IOException("Cannot buffer entire body for content length: " + d);
        }
        sdk.pendo.io.s2.f e = getE();
        try {
            byte[] byteArray = e.readByteArray();
            CloseableKt.closeFinally(e, null);
            int length = byteArray.length;
            if (d == -1 || d == length) {
                return byteArray;
            }
            throw new IOException("Content-Length (" + d + ") and stream length (" + length + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(e, th);
                throw th2;
            }
        }
    }

    public final Reader c() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        a aVar = new a(getE(), d());
        this.reader = aVar;
        return aVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        sdk.pendo.io.f2.b.a((Closeable) getE());
    }

    /* JADX INFO: renamed from: e */
    public abstract long getD();

    /* JADX INFO: renamed from: f */
    public abstract x getC();

    /* JADX INFO: renamed from: g */
    public abstract sdk.pendo.io.s2.f getE();

    public final String h() throws IOException {
        sdk.pendo.io.s2.f e = getE();
        try {
            String string = e.readString(sdk.pendo.io.f2.b.a(e, d()));
            CloseableKt.closeFinally(e, null);
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(e, th);
                throw th2;
            }
        }
    }

    @JvmStatic
    public static final e0 a(String str, x xVar) {
        return INSTANCE.a(str, xVar);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"external.sdk.pendo.io.okhttp3.ResponseBody.Companion.asResponseBody"}))
    @JvmStatic
    public static final e0 a(x xVar, long j, sdk.pendo.io.s2.f fVar) {
        return INSTANCE.a(xVar, j, fVar);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"external.sdk.pendo.io.okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final e0 a(x xVar, String str) {
        return INSTANCE.a(xVar, str);
    }
}
