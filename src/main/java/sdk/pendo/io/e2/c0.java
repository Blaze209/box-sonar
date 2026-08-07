package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/e2/c0;", "", "Lsdk/pendo/io/e2/x;", "b", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/e;", "sink", "", "", "c", "d", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: sdk.pendo.io.e2.c0$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\tJ3\u0010\u0006\u001a\u00020\u0005*\u00020\n2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0006\u0010\u000eJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0007J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\bH\u0007J.\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0007¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/e2/c0$a;", "", "", "Lsdk/pendo/io/e2/x;", "contentType", "Lsdk/pendo/io/e2/c0;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/String;Lsdk/pendo/io/e2/x;)Lsdk/pendo/io/e2/c0;", "Lsdk/pendo/io/s2/g;", "(Lsdk/pendo/io/s2/g;Lsdk/pendo/io/e2/x;)Lsdk/pendo/io/e2/c0;", "", "", "offset", "byteCount", "([BLsdk/pendo/io/e2/x;II)Lsdk/pendo/io/e2/c0;", "content", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: sdk.pendo.io.e2.c0$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"sdk/pendo/io/e2/c0$a$a", "Lsdk/pendo/io/e2/c0;", "Lsdk/pendo/io/e2/x;", "b", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/e;", "sink", "", "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class C0377a extends c0 {
            final /* synthetic */ x b;
            final /* synthetic */ sdk.pendo.io.s2.g c;

            C0377a(x xVar, sdk.pendo.io.s2.g gVar) {
                this.b = xVar;
                this.c = gVar;
            }

            @Override // sdk.pendo.io.e2.c0
            public long a() {
                return this.c.j();
            }

            @Override // sdk.pendo.io.e2.c0
            /* JADX INFO: renamed from: b, reason: from getter */
            public x getB() {
                return this.b;
            }

            @Override // sdk.pendo.io.e2.c0
            public void a(sdk.pendo.io.s2.e sink) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                sink.a(this.c);
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.e2.c0$a$b */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"sdk/pendo/io/e2/c0$a$b", "Lsdk/pendo/io/e2/c0;", "Lsdk/pendo/io/e2/x;", "b", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/e;", "sink", "", "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class b extends c0 {
            final /* synthetic */ x b;
            final /* synthetic */ int c;
            final /* synthetic */ byte[] d;
            final /* synthetic */ int e;

            b(x xVar, int i, byte[] bArr, int i2) {
                this.b = xVar;
                this.c = i;
                this.d = bArr;
                this.e = i2;
            }

            @Override // sdk.pendo.io.e2.c0
            public long a() {
                return this.c;
            }

            @Override // sdk.pendo.io.e2.c0
            /* JADX INFO: renamed from: b, reason: from getter */
            public x getB() {
                return this.b;
            }

            @Override // sdk.pendo.io.e2.c0
            public void a(sdk.pendo.io.s2.e sink) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                sink.write(this.d, this.e, this.c);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final c0 a(String str, x xVar) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Charset charsetA = Charsets.UTF_8;
            if (xVar != null && (charsetA = x.a(xVar, null, 1, null)) == null) {
                charsetA = Charsets.UTF_8;
                xVar = x.INSTANCE.b(xVar + "; charset=utf-8");
            }
            byte[] bytes = str.getBytes(charsetA);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return a(bytes, xVar, 0, bytes.length);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final c0 a(x contentType, String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return a(content, contentType);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final c0 a(x contentType, sdk.pendo.io.s2.g content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return a(content, contentType);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final c0 a(x xVar, byte[] content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return a(this, xVar, content, 0, 0, 12, (Object) null);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final c0 a(x contentType, byte[] content, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(content, "content");
            return a(content, contentType, offset, byteCount);
        }

        @JvmStatic
        public final c0 a(sdk.pendo.io.s2.g gVar, x xVar) {
            Intrinsics.checkNotNullParameter(gVar, "<this>");
            return new C0377a(xVar, gVar);
        }

        @JvmStatic
        public final c0 a(byte[] bArr, x xVar, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            sdk.pendo.io.f2.b.a(bArr.length, i, i2);
            return new b(xVar, i2, bArr, i);
        }

        public static /* synthetic */ c0 a(Companion companion, String str, x xVar, int i, Object obj) {
            if ((i & 1) != 0) {
                xVar = null;
            }
            return companion.a(str, xVar);
        }

        public static /* synthetic */ c0 a(Companion companion, x xVar, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return companion.a(xVar, bArr, i, i2);
        }

        public static /* synthetic */ c0 a(Companion companion, byte[] bArr, x xVar, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                xVar = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return companion.a(bArr, xVar, i, i2);
        }
    }

    public long a() {
        return -1L;
    }

    public abstract void a(sdk.pendo.io.s2.e sink);

    /* JADX INFO: renamed from: b */
    public abstract x getB();

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final c0 a(x xVar, String str) {
        return INSTANCE.a(xVar, str);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final c0 a(x xVar, sdk.pendo.io.s2.g gVar) {
        return INSTANCE.a(xVar, gVar);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"external.sdk.pendo.io.okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final c0 a(x xVar, byte[] bArr) {
        return INSTANCE.a(xVar, bArr);
    }
}
