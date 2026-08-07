package sdk.pendo.io.r2;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.net.HttpHeaders;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.hc.core5.http.HeaderElements;
import sdk.pendo.io.e2.a0;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.h0;
import sdk.pendo.io.e2.i0;
import sdk.pendo.io.e2.r;
import sdk.pendo.io.e2.z;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 s2\u00020\u00012\u00020\u0002:\u0005\u0005\u001c\u0017\u000b$BA\u0012\u0006\u0010p\u001a\u00020o\u0012\u0006\u0010,\u001a\u00020*\u0012\u0006\u00101\u001a\u00020-\u0012\u0006\u00104\u001a\u000202\u0012\u0006\u00106\u001a\u00020\"\u0012\b\u00108\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00109\u001a\u00020\"¢\u0006\u0004\bq\u0010rJ\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0005\u001a\u00020\nH\u0016J\u000e\u0010\u0005\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ!\u0010\u0005\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0004\b\u0005\u0010\u0012J\u0016\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\nJ\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0013H\u0016J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010#\u001a\u00020\"J\u000f\u0010$\u001a\u00020\u0004H\u0000¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\nH\u0000¢\u0006\u0004\b&\u0010'J\u001c\u0010\u0005\u001a\u00020\n2\n\u0010$\u001a\u00060(j\u0002`)2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+R\u001a\u00101\u001a\u00020-8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b/\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u00103R\u0014\u00106\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u00107R\u0016\u00109\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u00105R\u0014\u0010<\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010;R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00060T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020X0T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010VR\u0016\u0010\\\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u00105R\u0016\u0010_\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010d\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010;R\u0016\u0010f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010^R\u0016\u0010h\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010aR\u0016\u0010j\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010aR\u0016\u0010l\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010aR\u0016\u0010n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010^¨\u0006t"}, d2 = {"Lsdk/pendo/io/r2/d;", "Lsdk/pendo/io/e2/h0;", "Lsdk/pendo/io/r2/g$a;", "Lsdk/pendo/io/r2/e;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/g;", "data", "", "formatOpcode", "", "d", "Lsdk/pendo/io/e2/z;", "client", "Lsdk/pendo/io/e2/d0;", "response", "Lsdk/pendo/io/j2/c;", "exchange", "(Lsdk/pendo/io/e2/d0;Lsdk/pendo/io/j2/c;)V", "", "name", "Lsdk/pendo/io/r2/d$d;", "streams", "c", "text", "onReadMessage", "bytes", "payload", "b", "code", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "onReadClose", "send", HeaderElements.CLOSE, "", "cancelAfterCloseMillis", "e", "()Z", "f", "()V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lsdk/pendo/io/e2/b0;", "Lsdk/pendo/io/e2/b0;", "originalRequest", "Lsdk/pendo/io/e2/i0;", "Lsdk/pendo/io/e2/i0;", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Ljava/util/Random;", "Ljava/util/Random;", "random", "J", "pingIntervalMillis", "Lsdk/pendo/io/r2/e;", "extensions", "minimumDeflateSize", "g", "Ljava/lang/String;", "key", "Lsdk/pendo/io/e2/e;", CmcdData.STREAMING_FORMAT_HLS, "Lsdk/pendo/io/e2/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/i2/a;", "i", "Lsdk/pendo/io/i2/a;", "writerTask", "Lsdk/pendo/io/r2/g;", "j", "Lsdk/pendo/io/r2/g;", "reader", "Lsdk/pendo/io/r2/h;", "k", "Lsdk/pendo/io/r2/h;", "writer", "Lsdk/pendo/io/i2/d;", CmcdData.STREAM_TYPE_LIVE, "Lsdk/pendo/io/i2/d;", "taskQueue", CmcdData.OBJECT_TYPE_MANIFEST, "n", "Lsdk/pendo/io/r2/d$d;", "Ljava/util/ArrayDeque;", "o", "Ljava/util/ArrayDeque;", "pongQueue", "", "p", "messageAndCloseQueue", "q", "queueSize", "r", "Z", "enqueuedClose", "s", "I", "receivedCloseCode", "t", "receivedCloseReason", "u", TelemetryEventStrings.Value.FAILED, "v", "sentPingCount", "w", "receivedPingCount", "x", "receivedPongCount", "y", "awaitingPong", "Lsdk/pendo/io/i2/e;", "taskRunner", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "z", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class d implements h0, sdk.pendo.io.r2.g.a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final b0 originalRequest;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final i0 listener;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Random random;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final long pingIntervalMillis;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private sdk.pendo.io.r2.e extensions;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private long minimumDeflateSize;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final String key;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private sdk.pendo.io.e2.e call;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private sdk.pendo.io.i2.a writerTask;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private sdk.pendo.io.r2.g reader;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private sdk.pendo.io.r2.h writer;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private sdk.pendo.io.i2.d taskQueue;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private String name;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private AbstractC0471d streams;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final ArrayDeque<sdk.pendo.io.s2.g> pongQueue;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final ArrayDeque<Object> messageAndCloseQueue;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private long queueSize;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private boolean enqueuedClose;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private int receivedCloseCode;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private String receivedCloseReason;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private boolean failed;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private int sentPingCount;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private int receivedPingCount;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private int receivedPongCount;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    private boolean awaitingPong;
    private static final List<a0> A = CollectionsKt.listOf(a0.HTTP_1_1);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0003\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/r2/d$a;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "I", "b", "()I", "code", "Lsdk/pendo/io/s2/g;", "Lsdk/pendo/io/s2/g;", "getReason", "()Lokio/ByteString;", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "", "c", "J", "()J", "cancelAfterCloseMillis", "<init>", "(ILokio/ByteString;J)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int code;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final sdk.pendo.io.s2.g reason;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final long cancelAfterCloseMillis;

        public a(int i, sdk.pendo.io.s2.g gVar, long j) {
            this.code = i;
            this.reason = gVar;
            this.cancelAfterCloseMillis = j;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final sdk.pendo.io.s2.g getReason() {
            return this.reason;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/r2/d$c;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "I", "b", "()I", "formatOpcode", "Lsdk/pendo/io/s2/g;", "Lsdk/pendo/io/s2/g;", "getData", "()Lokio/ByteString;", "data", "<init>", "(ILokio/ByteString;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int formatOpcode;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final sdk.pendo.io.s2.g data;

        public c(int i, sdk.pendo.io.s2.g data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.formatOpcode = i;
            this.data = data;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final sdk.pendo.io.s2.g getData() {
            return this.data;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.r2.d$d, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/r2/d$d;", "Ljava/io/Closeable;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Z", "()Z", "client", "Lsdk/pendo/io/s2/f;", "b", "Lsdk/pendo/io/s2/f;", "getSource", "()Lokio/BufferedSource;", "source", "Lsdk/pendo/io/s2/e;", "c", "Lsdk/pendo/io/s2/e;", "getSink", "()Lokio/BufferedSink;", "sink", "<init>", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static abstract class AbstractC0471d implements Closeable {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final boolean client;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final sdk.pendo.io.s2.f source;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final sdk.pendo.io.s2.e sink;

        public AbstractC0471d(boolean z, sdk.pendo.io.s2.f source, sdk.pendo.io.s2.e sink) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            this.client = z;
            this.source = source;
            this.sink = sink;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final boolean getClient() {
            return this.client;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final sdk.pendo.io.s2.e getSink() {
            return this.sink;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final sdk.pendo.io.s2.f getSource() {
            return this.source;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/r2/d$e;", "Lsdk/pendo/io/i2/a;", "", "e", "<init>", "(Lokhttp3/internal/ws/RealWebSocket;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private final class e extends sdk.pendo.io.i2.a {
        public e() {
            super(d.this.name + " writer", false, 2, null);
        }

        @Override // sdk.pendo.io.i2.a
        public long e() {
            try {
                return d.this.e() ? 0L : -1L;
            } catch (IOException e) {
                d.this.a(e, (d0) null);
                return -1L;
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"sdk/pendo/io/r2/d$f", "Lsdk/pendo/io/e2/f;", "Lsdk/pendo/io/e2/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/e2/d0;", "response", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/io/IOException;", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class f implements sdk.pendo.io.e2.f {
        final /* synthetic */ b0 b;

        f(b0 b0Var) {
            this.b = b0Var;
        }

        @Override // sdk.pendo.io.e2.f
        public void a(sdk.pendo.io.e2.e call, IOException e) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e, "e");
            d.this.a(e, (d0) null);
        }

        @Override // sdk.pendo.io.e2.f
        public void a(sdk.pendo.io.e2.e call, d0 response) throws Throwable {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            sdk.pendo.io.j2.c exchange = response.getExchange();
            try {
                d.this.a(response, exchange);
                Intrinsics.checkNotNull(exchange);
                AbstractC0471d abstractC0471dL = exchange.l();
                sdk.pendo.io.r2.e eVarA = sdk.pendo.io.r2.e.INSTANCE.a(response.getHeaders());
                d.this.extensions = eVarA;
                if (!d.this.a(eVarA)) {
                    d dVar = d.this;
                    synchronized (dVar) {
                        dVar.messageAndCloseQueue.clear();
                        dVar.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                    }
                }
                try {
                    d.this.a(sdk.pendo.io.f2.b.i + " WebSocket " + this.b.i().n(), abstractC0471dL);
                    d.this.getListener().a(d.this, response);
                    d.this.c();
                } catch (Exception e) {
                    d.this.a(e, (d0) null);
                }
            } catch (IOException e2) {
                d.this.a(e2, response);
                sdk.pendo.io.f2.b.a((Closeable) response);
                if (exchange != null) {
                    exchange.p();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"sdk/pendo/io/r2/d$g", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class g extends sdk.pendo.io.i2.a {
        final /* synthetic */ d e;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, d dVar, long j) {
            super(str, false, 2, null);
            this.e = dVar;
            this.f = j;
        }

        @Override // sdk.pendo.io.i2.a
        public long e() {
            this.e.f();
            return this.f;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/i2/c", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class h extends sdk.pendo.io.i2.a {
        final /* synthetic */ d e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z, d dVar) {
            super(str, z);
            this.e = dVar;
        }

        @Override // sdk.pendo.io.i2.a
        public long e() {
            this.e.a();
            return -1L;
        }
    }

    public d(sdk.pendo.io.i2.e taskRunner, b0 originalRequest, i0 listener, Random random, long j, sdk.pendo.io.r2.e eVar, long j2) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(random, "random");
        this.originalRequest = originalRequest;
        this.listener = listener;
        this.random = random;
        this.pingIntervalMillis = j;
        this.extensions = eVar;
        this.minimumDeflateSize = j2;
        this.taskQueue = taskRunner.e();
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if (!Intrinsics.areEqual("GET", originalRequest.getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String())) {
            throw new IllegalArgumentException(("Request must be GET: " + originalRequest.getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String()).toString());
        }
        sdk.pendo.io.s2.g.Companion companion = sdk.pendo.io.s2.g.INSTANCE;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        Unit unit = Unit.INSTANCE;
        this.key = sdk.pendo.io.s2.g.Companion.a(companion, bArr, 0, 0, 3, null).a();
    }

    public final void c() {
        while (this.receivedCloseCode == -1) {
            sdk.pendo.io.r2.g gVar = this.reader;
            Intrinsics.checkNotNull(gVar);
            gVar.a();
        }
    }

    @Override // sdk.pendo.io.e2.h0
    public boolean close(int code, String reason) {
        return a(code, reason, 60000L);
    }

    @Override // sdk.pendo.io.r2.g.a
    public void d(sdk.pendo.io.s2.g bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.listener.a(this, bytes);
    }

    public final boolean e() {
        String str;
        sdk.pendo.io.r2.g gVar;
        sdk.pendo.io.r2.h hVar;
        int i;
        AbstractC0471d abstractC0471d;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            sdk.pendo.io.r2.h hVar2 = this.writer;
            sdk.pendo.io.s2.g gVarPoll = this.pongQueue.poll();
            Object obj = null;
            if (gVarPoll == null) {
                Object objPoll = this.messageAndCloseQueue.poll();
                if (objPoll instanceof a) {
                    i = this.receivedCloseCode;
                    str = this.receivedCloseReason;
                    if (i != -1) {
                        abstractC0471d = this.streams;
                        this.streams = null;
                        gVar = this.reader;
                        this.reader = null;
                        hVar = this.writer;
                        this.writer = null;
                        this.taskQueue.i();
                    } else {
                        long cancelAfterCloseMillis = ((a) objPoll).getCancelAfterCloseMillis();
                        this.taskQueue.a(new h(this.name + " cancel", true, this), TimeUnit.MILLISECONDS.toNanos(cancelAfterCloseMillis));
                        abstractC0471d = null;
                        gVar = null;
                        hVar = null;
                    }
                } else {
                    if (objPoll == null) {
                        return false;
                    }
                    str = null;
                    gVar = null;
                    hVar = null;
                    i = -1;
                    abstractC0471d = null;
                }
                obj = objPoll;
            } else {
                str = null;
                gVar = null;
                hVar = null;
                i = -1;
                abstractC0471d = null;
            }
            Unit unit = Unit.INSTANCE;
            try {
                if (gVarPoll != null) {
                    Intrinsics.checkNotNull(hVar2);
                    hVar2.c(gVarPoll);
                } else if (obj instanceof c) {
                    c cVar = (c) obj;
                    Intrinsics.checkNotNull(hVar2);
                    hVar2.c(cVar.getFormatOpcode(), cVar.getData());
                    synchronized (this) {
                        this.queueSize -= (long) cVar.getData().j();
                        Unit unit2 = Unit.INSTANCE;
                    }
                } else {
                    if (!(obj instanceof a)) {
                        throw new AssertionError();
                    }
                    a aVar = (a) obj;
                    Intrinsics.checkNotNull(hVar2);
                    hVar2.a(aVar.getCode(), aVar.getReason());
                    if (abstractC0471d != null) {
                        i0 i0Var = this.listener;
                        Intrinsics.checkNotNull(str);
                        i0Var.a(this, i, str);
                    }
                }
                if (abstractC0471d != null) {
                    sdk.pendo.io.f2.b.a(abstractC0471d);
                }
                if (gVar != null) {
                    sdk.pendo.io.f2.b.a(gVar);
                }
                if (hVar != null) {
                    sdk.pendo.io.f2.b.a(hVar);
                }
                return true;
            } catch (Throwable th) {
                if (abstractC0471d != null) {
                    sdk.pendo.io.f2.b.a(abstractC0471d);
                }
                if (gVar != null) {
                    sdk.pendo.io.f2.b.a(gVar);
                }
                if (hVar != null) {
                    sdk.pendo.io.f2.b.a(hVar);
                }
                throw th;
            }
        }
    }

    public final void f() {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            sdk.pendo.io.r2.h hVar = this.writer;
            if (hVar == null) {
                return;
            }
            int i = this.awaitingPong ? this.sentPingCount : -1;
            this.sentPingCount++;
            this.awaitingPong = true;
            Unit unit = Unit.INSTANCE;
            if (i != -1) {
                a(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i - 1) + " successful ping/pongs)"), (d0) null);
                return;
            }
            try {
                hVar.b(sdk.pendo.io.s2.g.e);
            } catch (IOException e2) {
                a(e2, (d0) null);
            }
        }
    }

    @Override // sdk.pendo.io.r2.g.a
    public void onReadClose(int code, String reason) {
        AbstractC0471d abstractC0471d;
        sdk.pendo.io.r2.g gVar;
        sdk.pendo.io.r2.h hVar;
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (code == -1) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                throw new IllegalStateException("already closed".toString());
            }
            this.receivedCloseCode = code;
            this.receivedCloseReason = reason;
            abstractC0471d = null;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                AbstractC0471d abstractC0471d2 = this.streams;
                this.streams = null;
                gVar = this.reader;
                this.reader = null;
                hVar = this.writer;
                this.writer = null;
                this.taskQueue.i();
                abstractC0471d = abstractC0471d2;
            } else {
                gVar = null;
                hVar = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        try {
            this.listener.b(this, code, reason);
            if (abstractC0471d != null) {
                this.listener.a(this, code, reason);
            }
        } finally {
            if (abstractC0471d != null) {
                sdk.pendo.io.f2.b.a(abstractC0471d);
            }
            if (gVar != null) {
                sdk.pendo.io.f2.b.a(gVar);
            }
            if (hVar != null) {
                sdk.pendo.io.f2.b.a(hVar);
            }
        }
    }

    @Override // sdk.pendo.io.r2.g.a
    public void onReadMessage(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.listener.a(this, text);
    }

    @Override // sdk.pendo.io.e2.h0
    public boolean send(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return a(sdk.pendo.io.s2.g.INSTANCE.b(text), 1);
    }

    private final void d() {
        if (sdk.pendo.io.f2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        sdk.pendo.io.i2.a aVar = this.writerTask;
        if (aVar != null) {
            sdk.pendo.io.i2.d.a(this.taskQueue, aVar, 0L, 2, null);
        }
    }

    @Override // sdk.pendo.io.r2.g.a
    public synchronized void c(sdk.pendo.io.s2.g payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public void a() {
        sdk.pendo.io.e2.e eVar = this.call;
        Intrinsics.checkNotNull(eVar);
        eVar.cancel();
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final i0 getListener() {
        return this.listener;
    }

    public final void a(d0 response, sdk.pendo.io.j2.c exchange) throws ProtocolException {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.getCode() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.getCode() + ' ' + response.getMessage() + '\'');
        }
        String strA = d0.a(response, "Connection", null, 2, null);
        if (!StringsKt.equals("Upgrade", strA, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strA + '\'');
        }
        String strA2 = d0.a(response, "Upgrade", null, 2, null);
        if (!StringsKt.equals("websocket", strA2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strA2 + '\'');
        }
        String strA3 = d0.a(response, HttpHeaders.SEC_WEBSOCKET_ACCEPT, null, 2, null);
        String strA4 = sdk.pendo.io.s2.g.INSTANCE.b(this.key + WebSocketProtocol.ACCEPT_MAGIC).h().a();
        if (!Intrinsics.areEqual(strA4, strA3)) {
            throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strA4 + "' but was '" + strA3 + '\'');
        }
        if (exchange == null) {
            throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
        }
    }

    @Override // sdk.pendo.io.r2.g.a
    public synchronized void b(sdk.pendo.io.s2.g payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(payload);
            d();
            this.receivedPingCount++;
        }
    }

    public final synchronized boolean a(int code, String reason, long cancelAfterCloseMillis) {
        sdk.pendo.io.s2.g gVarB;
        sdk.pendo.io.r2.f.a.b(code);
        if (reason != null) {
            gVarB = sdk.pendo.io.s2.g.INSTANCE.b(reason);
            if (gVarB.j() > 123) {
                throw new IllegalArgumentException(("reason.size() > 123: " + reason).toString());
            }
        } else {
            gVarB = null;
        }
        if (!this.failed && !this.enqueuedClose) {
            this.enqueuedClose = true;
            this.messageAndCloseQueue.add(new a(code, gVarB, cancelAfterCloseMillis));
            d();
            return true;
        }
        return false;
    }

    public final void a(z client) {
        Intrinsics.checkNotNullParameter(client, "client");
        if (this.originalRequest.a(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS) != null) {
            a(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), (d0) null);
            return;
        }
        z zVarA = client.v().a(r.b).a(A).a();
        b0 b0VarA = this.originalRequest.h().b("Upgrade", "websocket").b("Connection", "Upgrade").b(HttpHeaders.SEC_WEBSOCKET_KEY, this.key).b(HttpHeaders.SEC_WEBSOCKET_VERSION, "13").b(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, "permessage-deflate").a();
        sdk.pendo.io.j2.e eVar = new sdk.pendo.io.j2.e(zVarA, b0VarA, true);
        this.call = eVar;
        Intrinsics.checkNotNull(eVar);
        eVar.a(new f(b0VarA));
    }

    public final void a(Exception e2, d0 response) {
        Intrinsics.checkNotNullParameter(e2, "e");
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            AbstractC0471d abstractC0471d = this.streams;
            this.streams = null;
            sdk.pendo.io.r2.g gVar = this.reader;
            this.reader = null;
            sdk.pendo.io.r2.h hVar = this.writer;
            this.writer = null;
            this.taskQueue.i();
            Unit unit = Unit.INSTANCE;
            try {
                this.listener.a(this, e2, response);
            } finally {
                if (abstractC0471d != null) {
                    sdk.pendo.io.f2.b.a(abstractC0471d);
                }
                if (gVar != null) {
                    sdk.pendo.io.f2.b.a(gVar);
                }
                if (hVar != null) {
                    sdk.pendo.io.f2.b.a(hVar);
                }
            }
        }
    }

    public final void a(String name, AbstractC0471d streams) throws Throwable {
        Throwable th;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(streams, "streams");
        sdk.pendo.io.r2.e eVar = this.extensions;
        Intrinsics.checkNotNull(eVar);
        synchronized (this) {
            try {
                this.name = name;
                this.streams = streams;
                this.writer = new sdk.pendo.io.r2.h(streams.getClient(), streams.getSink(), this.random, eVar.perMessageDeflate, eVar.a(streams.getClient()), this.minimumDeflateSize);
                this.writerTask = new e();
                long j = this.pingIntervalMillis;
                if (j != 0) {
                    try {
                        long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                        this.taskQueue.a(new g(name + " ping", this, nanos), nanos);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    d();
                }
                Unit unit = Unit.INSTANCE;
                this.reader = new sdk.pendo.io.r2.g(streams.getClient(), streams.getSource(), this, eVar.perMessageDeflate, eVar.a(!streams.getClient()));
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(sdk.pendo.io.r2.e eVar) {
        if (!eVar.unknownValues && eVar.clientMaxWindowBits == null) {
            return eVar.serverMaxWindowBits == null || new IntRange(8, 15).contains(eVar.serverMaxWindowBits.intValue());
        }
        return false;
    }

    @Override // sdk.pendo.io.e2.h0
    public boolean a(sdk.pendo.io.s2.g bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return a(bytes, 2);
    }

    private final synchronized boolean a(sdk.pendo.io.s2.g data, int formatOpcode) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + ((long) data.j()) > 16777216) {
                close(1001, null);
                return false;
            }
            this.queueSize += (long) data.j();
            this.messageAndCloseQueue.add(new c(formatOpcode, data));
            d();
            return true;
        }
        return false;
    }
}
