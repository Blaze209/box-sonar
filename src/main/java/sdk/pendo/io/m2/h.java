package sdk.pendo.io.m2;

import androidx.collection.SieveCacheKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import com.pspdfkit.analytics.Analytics;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import org.apache.commons.logging.LogFactory;
import org.apache.hc.core5.http.HeaderElements;
import sdk.pendo.io.s2.a0;
import sdk.pendo.io.s2.b0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0003\r\u0013\tB\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u0015¢\u0006\u0004\b#\u0010$J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J.\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0017\u001a\u00020\bH\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010!¨\u0006%"}, d2 = {"Lsdk/pendo/io/m2/h;", "Ljava/io/Closeable;", "Lsdk/pendo/io/m2/h$c;", "handler", "", Analytics.Data.LENGTH, "flags", "streamId", "", "c", ViewProps.PADDING, "", "Lsdk/pendo/io/m2/c;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "e", "g", CmcdData.STREAMING_FORMAT_HLS, "f", "d", "b", "i", "", "requireSettings", HeaderElements.CLOSE, "Lsdk/pendo/io/s2/f;", "Lsdk/pendo/io/s2/f;", "source", "Z", "client", "Lsdk/pendo/io/m2/h$b;", "Lsdk/pendo/io/m2/h$b;", "continuation", "Lsdk/pendo/io/m2/d$a;", "Lsdk/pendo/io/m2/d$a;", "hpackReader", "<init>", "(Lokio/BufferedSource;Z)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class h implements Closeable {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Logger f;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.f source;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final boolean client;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final b continuation;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final d.a hpackReader;

    /* JADX INFO: renamed from: sdk.pendo.io.m2.h$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\n¨\u0006\r"}, d2 = {"Lsdk/pendo/io/m2/h$a;", "", "", Analytics.Data.LENGTH, "flags", ViewProps.PADDING, CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/util/logging/Logger;", "logger", "Ljava/util/logging/Logger;", "()Ljava/util/logging/Logger;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Logger a() {
            return h.f;
        }

        public final int a(int length, int flags, int padding) throws IOException {
            if ((flags & 8) != 0) {
                length--;
            }
            if (padding <= length) {
                return length - padding;
            }
            throw new IOException("PROTOCOL_ERROR padding " + padding + " > remaining length " + length);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\f\u0010\u0014R\"\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\f\u0010\u0012\"\u0004\b\u0003\u0010\u0014R\"\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006\""}, d2 = {"Lsdk/pendo/io/m2/h$b;", "Lsdk/pendo/io/s2/a0;", "", "b", "Lsdk/pendo/io/s2/d;", "sink", "", "byteCount", "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, HeaderElements.CLOSE, "Lsdk/pendo/io/s2/f;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/f;", "source", "", "I", "getLength", "()I", "c", "(I)V", Analytics.Data.LENGTH, "getFlags", "flags", "d", "getStreamId", "e", "streamId", "left", "f", "getPadding", ViewProps.PADDING, "<init>", "(Lokio/BufferedSource;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class b implements a0 {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final sdk.pendo.io.s2.f source;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private int length;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private int flags;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private int streamId;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private int left;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private int padding;

        public b(sdk.pendo.io.s2.f source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getLeft() {
            return this.left;
        }

        @Override // sdk.pendo.io.s2.a0
        public long b(sdk.pendo.io.s2.d sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            while (true) {
                int i = this.left;
                if (i != 0) {
                    long jB = this.source.b(sink, Math.min(byteCount, i));
                    if (jB == -1) {
                        return -1L;
                    }
                    this.left -= (int) jB;
                    return jB;
                }
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                b();
            }
        }

        public final void c(int i) {
            this.length = i;
        }

        @Override // sdk.pendo.io.s2.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public final void d(int i) {
            this.padding = i;
        }

        public final void e(int i) {
            this.streamId = i;
        }

        @Override // sdk.pendo.io.s2.a0
        /* JADX INFO: renamed from: timeout */
        public b0 getTimeout() {
            return this.source.getTimeout();
        }

        private final void b() throws IOException {
            int i = this.streamId;
            int iA = sdk.pendo.io.f2.b.a(this.source);
            this.left = iA;
            this.length = iA;
            int iA2 = sdk.pendo.io.f2.b.a(this.source.readByte(), 255);
            this.flags = sdk.pendo.io.f2.b.a(this.source.readByte(), 255);
            Companion companion = h.INSTANCE;
            if (companion.a().isLoggable(Level.FINE)) {
                companion.a().fine(e.a.a(true, this.streamId, this.length, iA2, this.flags));
            }
            int i2 = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = i2;
            if (iA2 != 9) {
                throw new IOException(iA2 + " != TYPE_CONTINUATION");
            }
            if (i2 != i) {
                throw new IOException("TYPE_CONTINUATION streamId changed");
            }
        }

        public final void a(int i) {
            this.flags = i;
        }

        public final void b(int i) {
            this.left = i;
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&J.\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0015\u001a\u00020\tH&J \u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H&J \u0010\n\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001bH&J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH&J(\u0010#\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0002H&J&\u0010&\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¨\u0006'"}, d2 = {"Lsdk/pendo/io/m2/h$c;", "", "", "inFinished", "", "streamId", "Lsdk/pendo/io/s2/f;", "source", Analytics.Data.LENGTH, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "associatedStreamId", "", "Lsdk/pendo/io/m2/c;", "headerBlock", "headers", "Lsdk/pendo/io/m2/b;", "errorCode", "clearPrevious", "Lsdk/pendo/io/m2/m;", BoxAnalyticsParams.CATEGORY_SETTINGS, "ackSettings", "ack", "payload1", "payload2", "ping", "lastGoodStreamId", "Lsdk/pendo/io/s2/g;", "debugData", "", "windowSizeIncrement", "windowUpdate", "streamDependency", "weight", "exclusive", LogFactory.PRIORITY_KEY, "promisedStreamId", "requestHeaders", "pushPromise", "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface c {
        void a(int streamId, sdk.pendo.io.m2.b errorCode);

        void a(int lastGoodStreamId, sdk.pendo.io.m2.b errorCode, sdk.pendo.io.s2.g debugData);

        void a(boolean inFinished, int streamId, sdk.pendo.io.s2.f source, int length);

        void a(boolean clearPrevious, m settings);

        void ackSettings();

        void headers(boolean inFinished, int streamId, int associatedStreamId, List<sdk.pendo.io.m2.c> headerBlock);

        void ping(boolean ack, int payload1, int payload2);

        void priority(int streamId, int streamDependency, int weight, boolean exclusive);

        void pushPromise(int streamId, int promisedStreamId, List<sdk.pendo.io.m2.c> requestHeaders);

        void windowUpdate(int streamId, long windowSizeIncrement);
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(Http2::class.java.name)");
        f = logger;
    }

    public h(sdk.pendo.io.s2.f source, boolean z) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.client = z;
        b bVar = new b(source);
        this.continuation = bVar;
        this.hpackReader = new d.a(bVar, 4096, 0, 4, null);
    }

    private final void b(c handler, int length, int flags, int streamId) throws IOException {
        if (length < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + length);
        }
        if (streamId != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i = this.source.readInt();
        int i2 = this.source.readInt();
        int i3 = length - 8;
        sdk.pendo.io.m2.b bVarA = sdk.pendo.io.m2.b.INSTANCE.a(i2);
        if (bVarA == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + i2);
        }
        sdk.pendo.io.s2.g byteString = sdk.pendo.io.s2.g.e;
        if (i3 > 0) {
            byteString = this.source.readByteString(i3);
        }
        handler.a(i, bVarA, byteString);
    }

    private final void c(c handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z = (flags & 1) != 0;
        int iA = (flags & 8) != 0 ? sdk.pendo.io.f2.b.a(this.source.readByte(), 255) : 0;
        if ((flags & 32) != 0) {
            a(handler, streamId);
            length -= 5;
        }
        handler.headers(z, streamId, -1, a(INSTANCE.a(length, flags, iA), iA, flags, streamId));
    }

    private final void d(c handler, int length, int flags, int streamId) throws IOException {
        if (length != 8) {
            throw new IOException("TYPE_PING length != 8: " + length);
        }
        if (streamId != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.ping((flags & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private final void e(c handler, int length, int flags, int streamId) throws IOException {
        if (length != 5) {
            throw new IOException("TYPE_PRIORITY length: " + length + " != 5");
        }
        if (streamId == 0) {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        a(handler, streamId);
    }

    private final void f(c handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iA = (flags & 8) != 0 ? sdk.pendo.io.f2.b.a(this.source.readByte(), 255) : 0;
        handler.pushPromise(streamId, this.source.readInt() & Integer.MAX_VALUE, a(INSTANCE.a(length - 4, flags, iA), iA, flags, streamId));
    }

    private final void g(c handler, int length, int flags, int streamId) throws IOException {
        if (length != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + length + " != 4");
        }
        if (streamId == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i = this.source.readInt();
        sdk.pendo.io.m2.b bVarA = sdk.pendo.io.m2.b.INSTANCE.a(i);
        if (bVarA == null) {
            throw new IOException("TYPE_RST_STREAM unexpected error code: " + i);
        }
        handler.a(streamId, bVarA);
    }

    private final void h(c handler, int length, int flags, int streamId) throws IOException {
        if (streamId != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((flags & 1) != 0) {
            if (length != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            handler.ackSettings();
            return;
        }
        if (length % 6 != 0) {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + length);
        }
        m mVar = new m();
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, length), 6);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                int iA = sdk.pendo.io.f2.b.a(this.source.readShort(), 65535);
                int i = this.source.readInt();
                if (iA != 2) {
                    if (iA == 3) {
                        iA = 4;
                    } else if (iA != 4) {
                        if (iA == 5 && (i < 16384 || i > 16777215)) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + i);
                        }
                    } else {
                        if (i < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        iA = 7;
                    }
                } else if (i != 0 && i != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                mVar.a(iA, i);
                if (first != last) {
                    first += step;
                }
            }
        }
        handler.a(false, mVar);
    }

    private final void i(c handler, int length, int flags, int streamId) throws IOException {
        if (length != 4) {
            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + length);
        }
        long jA = sdk.pendo.io.f2.b.a(this.source.readInt(), SieveCacheKt.NodeLinkMask);
        if (jA == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        handler.windowUpdate(streamId, jA);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.source.close();
    }

    public final boolean a(boolean requireSettings, c handler) throws IOException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        try {
            this.source.require(9L);
            int iA = sdk.pendo.io.f2.b.a(this.source);
            if (iA > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + iA);
            }
            int iA2 = sdk.pendo.io.f2.b.a(this.source.readByte(), 255);
            int iA3 = sdk.pendo.io.f2.b.a(this.source.readByte(), 255);
            int i = this.source.readInt() & Integer.MAX_VALUE;
            Logger logger = f;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a.a(true, i, iA, iA2, iA3));
            }
            if (requireSettings && iA2 != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + e.a.a(iA2));
            }
            switch (iA2) {
                case 0:
                    a(handler, iA, iA3, i);
                    return true;
                case 1:
                    c(handler, iA, iA3, i);
                    return true;
                case 2:
                    e(handler, iA, iA3, i);
                    return true;
                case 3:
                    g(handler, iA, iA3, i);
                    return true;
                case 4:
                    h(handler, iA, iA3, i);
                    return true;
                case 5:
                    f(handler, iA, iA3, i);
                    return true;
                case 6:
                    d(handler, iA, iA3, i);
                    return true;
                case 7:
                    b(handler, iA, iA3, i);
                    return true;
                case 8:
                    i(handler, iA, iA3, i);
                    return true;
                default:
                    this.source.skip(iA);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void a(c handler) throws IOException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.client) {
            if (!a(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        sdk.pendo.io.s2.f fVar = this.source;
        sdk.pendo.io.s2.g gVar = e.CONNECTION_PREFACE;
        sdk.pendo.io.s2.g byteString = fVar.readByteString(gVar.j());
        Logger logger = f;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(sdk.pendo.io.f2.b.a("<< CONNECTION " + byteString.f(), new Object[0]));
        }
        if (!Intrinsics.areEqual(gVar, byteString)) {
            throw new IOException("Expected a connection header but was " + byteString.m());
        }
    }

    private final void a(c handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z = (flags & 1) != 0;
        if ((flags & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iA = (flags & 8) != 0 ? sdk.pendo.io.f2.b.a(this.source.readByte(), 255) : 0;
        handler.a(z, streamId, this.source, INSTANCE.a(length, flags, iA));
        this.source.skip(iA);
    }

    private final List<sdk.pendo.io.m2.c> a(int length, int padding, int flags, int streamId) throws IOException {
        this.continuation.b(length);
        b bVar = this.continuation;
        bVar.c(bVar.getLeft());
        this.continuation.d(padding);
        this.continuation.a(flags);
        this.continuation.e(streamId);
        this.hpackReader.f();
        return this.hpackReader.c();
    }

    private final void a(c handler, int streamId) {
        int i = this.source.readInt();
        handler.priority(streamId, i & Integer.MAX_VALUE, sdk.pendo.io.f2.b.a(this.source.readByte(), 255) + 1, (Integer.MIN_VALUE & i) != 0);
    }
}
