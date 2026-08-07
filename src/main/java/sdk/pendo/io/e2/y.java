package sdk.pendo.io.e2;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxUploadSessionPart;
import com.google.common.base.Ascii;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0003\u0007\t\u000eB'\b\u0000\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b \u0010!J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0007¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001f\u001a\u00020\u001d8G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001e¨\u0006#"}, d2 = {"Lsdk/pendo/io/e2/y;", "Lsdk/pendo/io/e2/c0;", "Lsdk/pendo/io/s2/e;", "sink", "", "countBytes", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/x;", "b", "", "Lsdk/pendo/io/s2/g;", "Lsdk/pendo/io/s2/g;", "boundaryByteString", "c", "Lsdk/pendo/io/e2/x;", "type", "()Lokhttp3/MediaType;", "", "Lsdk/pendo/io/e2/y$c;", "d", "Ljava/util/List;", "parts", "()Ljava/util/List;", "e", "contentType", "f", "J", "contentLength", "", "()Ljava/lang/String;", "boundary", "<init>", "(Lokio/ByteString;Lokhttp3/MediaType;Ljava/util/List;)V", "g", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class y extends c0 {
    public static final x h;
    public static final x i;
    public static final x j;
    public static final x k;
    public static final x l;
    private static final byte[] m;
    private static final byte[] n;
    private static final byte[] o;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.g boundaryByteString;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final x type;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final List<c> parts;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final x contentType;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private long contentLength;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0004\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u0004\u001a\u00020\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/e2/y$a;", "", "Lsdk/pendo/io/e2/x;", "type", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/u;", "headers", "Lsdk/pendo/io/e2/c0;", "body", "Lsdk/pendo/io/e2/y$c;", BoxUploadSessionPart.FIELD_PART, "Lsdk/pendo/io/e2/y;", "Lsdk/pendo/io/s2/g;", "Lsdk/pendo/io/s2/g;", "boundary", "b", "Lsdk/pendo/io/e2/x;", "", "c", "Ljava/util/List;", "parts", "", "<init>", "(Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final sdk.pendo.io.s2.g boundary;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private x type;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final List<c> parts;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final a a(u headers, c0 body) {
            Intrinsics.checkNotNullParameter(body, "body");
            a(c.INSTANCE.a(headers, body));
            return this;
        }

        public a(String boundary) {
            Intrinsics.checkNotNullParameter(boundary, "boundary");
            this.boundary = sdk.pendo.io.s2.g.INSTANCE.b(boundary);
            this.type = y.h;
            this.parts = new ArrayList();
        }

        public final a a(c part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.parts.add(part);
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ a(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                str = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
            }
            this(str);
        }

        public final y a() {
            if (this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.".toString());
            }
            return new y(this.boundary, this.type, sdk.pendo.io.f2.b.b(this.parts));
        }

        public final a a(x type) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (!Intrinsics.areEqual(type.getType(), "multipart")) {
                throw new IllegalArgumentException(("multipart != " + type).toString());
            }
            this.type = type;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u001b\b\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/e2/y$c;", "", "Lsdk/pendo/io/e2/u;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/u;", "headers", "()Lokhttp3/Headers;", "Lsdk/pendo/io/e2/c0;", "b", "Lsdk/pendo/io/e2/c0;", "body", "()Lokhttp3/RequestBody;", "<init>", "(Lokhttp3/Headers;Lokhttp3/RequestBody;)V", "c", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class c {

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final u headers;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final c0 body;

        /* JADX INFO: renamed from: sdk.pendo.io.e2.y$c$a, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lsdk/pendo/io/e2/y$c$a;", "", "Lsdk/pendo/io/e2/u;", "headers", "Lsdk/pendo/io/e2/c0;", "body", "Lsdk/pendo/io/e2/y$c;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final c a(u headers, c0 body) {
                Intrinsics.checkNotNullParameter(body, "body");
                DefaultConstructorMarker defaultConstructorMarker = null;
                if ((headers != null ? headers.a("Content-Type") : null) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
                }
                if ((headers != null ? headers.a("Content-Length") : null) == null) {
                    return new c(headers, body, defaultConstructorMarker);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            }
        }

        private c(u uVar, c0 c0Var) {
            this.headers = uVar;
            this.body = c0Var;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final c0 getBody() {
            return this.body;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final u getHeaders() {
            return this.headers;
        }

        public /* synthetic */ c(u uVar, c0 c0Var, DefaultConstructorMarker defaultConstructorMarker) {
            this(uVar, c0Var);
        }
    }

    static {
        x.Companion companion = x.INSTANCE;
        h = companion.a("multipart/mixed");
        i = companion.a("multipart/alternative");
        j = companion.a("multipart/digest");
        k = companion.a("multipart/parallel");
        l = companion.a(ShareTarget.ENCODING_TYPE_MULTIPART);
        m = new byte[]{CtapException.ERR_ACTION_TIMEOUT, 32};
        n = new byte[]{Ascii.CR, 10};
        o = new byte[]{CtapException.ERR_KEEPALIVE_CANCEL, CtapException.ERR_KEEPALIVE_CANCEL};
    }

    public y(sdk.pendo.io.s2.g boundaryByteString, x type, List<c> parts) {
        Intrinsics.checkNotNullParameter(boundaryByteString, "boundaryByteString");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(parts, "parts");
        this.boundaryByteString = boundaryByteString;
        this.type = type;
        this.parts = parts;
        this.contentType = x.INSTANCE.a(type + "; boundary=" + e());
        this.contentLength = -1L;
    }

    @Override // sdk.pendo.io.e2.c0
    public long a() throws EOFException {
        long j2 = this.contentLength;
        if (j2 != -1) {
            return j2;
        }
        long jA = a((sdk.pendo.io.s2.e) null, true);
        this.contentLength = jA;
        return jA;
    }

    @Override // sdk.pendo.io.e2.c0
    /* JADX INFO: renamed from: b, reason: from getter */
    public x getContentType() {
        return this.contentType;
    }

    public final String e() {
        return this.boundaryByteString.m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long a(sdk.pendo.io.s2.e sink, boolean countBytes) throws EOFException {
        sdk.pendo.io.s2.d dVar;
        if (countBytes) {
            sink = new sdk.pendo.io.s2.d();
            dVar = sink;
        } else {
            dVar = 0;
        }
        int size = this.parts.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = this.parts.get(i2);
            u headers = cVar.getHeaders();
            c0 body = cVar.getBody();
            Intrinsics.checkNotNull(sink);
            sink.write(o);
            sink.a(this.boundaryByteString);
            sink.write(n);
            if (headers != null) {
                int size2 = headers.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    sink.writeUtf8(headers.a(i3)).write(m).writeUtf8(headers.b(i3)).write(n);
                }
            }
            x contentType = body.getContentType();
            if (contentType != null) {
                sink.writeUtf8("Content-Type: ").writeUtf8(contentType.getMediaType()).write(n);
            }
            long jA = body.a();
            if (jA != -1) {
                sink.writeUtf8("Content-Length: ").writeDecimalLong(jA).write(n);
            } else if (countBytes) {
                Intrinsics.checkNotNull(dVar);
                dVar.a();
                return -1L;
            }
            byte[] bArr = n;
            sink.write(bArr);
            if (countBytes) {
                j2 += jA;
            } else {
                body.a(sink);
            }
            sink.write(bArr);
        }
        Intrinsics.checkNotNull(sink);
        byte[] bArr2 = o;
        sink.write(bArr2);
        sink.a(this.boundaryByteString);
        sink.write(bArr2);
        sink.write(n);
        if (!countBytes) {
            return j2;
        }
        Intrinsics.checkNotNull(dVar);
        long size3 = j2 + dVar.getSize();
        dVar.a();
        return size3;
    }

    @Override // sdk.pendo.io.e2.c0
    public void a(sdk.pendo.io.s2.e sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        a(sink, false);
    }
}
