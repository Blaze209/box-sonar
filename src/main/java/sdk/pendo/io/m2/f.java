package sdk.pendo.io.m2;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.analytics.Analytics;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.logging.LogFactory;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u009e\u00012\u00020\u0001:\u0004\n\u0014\u0010FB\u0015\b\u0000\u0012\b\u0010\u009b\u0001\u001a\u00030\u009a\u0001¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\n\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0002J\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007J-\u0010\n\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\n\u0010\u0018J(\u0010\n\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0012J\u001f\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u0010\u0010\u001eJ\u001f\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u0014\u0010\u001eJ\u001f\u0010\n\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0012H\u0000¢\u0006\u0004\b\n\u0010!J\u001e\u0010\n\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0002J\u0006\u0010%\u001a\u00020\rJ\u000e\u0010\n\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001cJ\b\u0010&\u001a\u00020\rH\u0016J)\u0010\n\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\n\u0010*J\u001c\u0010\n\u001a\u00020\r2\b\b\u0002\u0010+\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020,H\u0007J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0012J\u000f\u0010/\u001a\u00020\rH\u0000¢\u0006\u0004\b/\u00100J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0014\u00101J%\u0010\n\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\n\u00102J-\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u00103\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0014\u00104J/\u0010\n\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00106\u001a\u0002052\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u00107J\u001f\u0010\n\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\n\u0010\u001eR\u001a\u0010:\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u00108\u001a\u0004\b\u0014\u00109R\u001a\u0010?\u001a\u00020;8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010<\u001a\u0004\b=\u0010>R&\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0@8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010A\u001a\u0004\bB\u0010CR\u001a\u0010I\u001a\u00020E8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\b\u0010\u0010HR\"\u0010M\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010J\u001a\u0004\bF\u0010K\"\u0004\bF\u0010LR\"\u0010P\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bN\u0010J\u001a\u0004\bN\u0010K\"\u0004\bO\u0010LR\u0016\u0010R\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u00108R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010VR\u0014\u0010Y\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010VR\u0014\u0010[\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010VR\u0014\u0010^\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010]R\u0016\u0010a\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010`R\u0016\u0010e\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010`R\u0016\u0010g\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010`R\u0016\u0010i\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010`R\u0016\u0010k\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010`R\u0017\u0010q\u001a\u00020l8\u0006¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR\"\u0010v\u001a\u00020l8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010n\u001a\u0004\bs\u0010p\"\u0004\bt\u0010uR$\u0010{\u001a\u00020\u00122\u0006\u0010w\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bx\u0010`\u001a\u0004\by\u0010zR$\u0010~\u001a\u00020\u00122\u0006\u0010w\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b|\u0010`\u001a\u0004\b}\u0010zR&\u0010\u0081\u0001\u001a\u00020\u00122\u0006\u0010w\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\r\n\u0004\b\u007f\u0010`\u001a\u0005\b\u0080\u0001\u0010zR&\u0010\u0083\u0001\u001a\u00020\u00122\u0006\u0010w\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\r\n\u0005\b\u0082\u0001\u0010`\u001a\u0004\bX\u0010zR \u0010\u0089\u0001\u001a\u00030\u0084\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001d\u0010\u008f\u0001\u001a\u00030\u008a\u00018\u0006¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R!\u0010\u0095\u0001\u001a\u00070\u0090\u0001R\u00020\u00008\u0006¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001e\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001¨\u0006\u009f\u0001"}, d2 = {"Lsdk/pendo/io/m2/f;", "Ljava/io/Closeable;", "", "associatedStreamId", "", "Lsdk/pendo/io/m2/c;", "requestHeaders", "", "out", "Lsdk/pendo/io/m2/i;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/io/IOException;", "e", "", "id", "streamId", "c", "(I)Lsdk/pendo/io/m2/i;", "", "read", "b", "(J)V", "outFinished", "alternating", "(IZLjava/util/List;)V", "Lsdk/pendo/io/s2/d;", "buffer", "byteCount", "Lsdk/pendo/io/m2/b;", "errorCode", "(ILsdk/pendo/io/m2/b;)V", "statusCode", "unacknowledgedBytesRead", "(IJ)V", Gen204FileActivityEventLogger.ACTION_REPLY, "payload1", "payload2", "flush", HeaderElements.CLOSE, "connectionCode", "streamCode", "cause", "(Lsdk/pendo/io/m2/b;Lsdk/pendo/io/m2/b;Ljava/io/IOException;)V", "sendConnectionPreface", "Lsdk/pendo/io/i2/e;", "taskRunner", "nowNs", CmcdData.STREAM_TYPE_LIVE, "()V", "(I)Z", "(ILjava/util/List;)V", "inFinished", "(ILjava/util/List;Z)V", "Lsdk/pendo/io/s2/f;", "source", "(ILsdk/pendo/io/s2/f;IZ)V", "Z", "()Z", "client", "Lsdk/pendo/io/m2/f$c;", "Lsdk/pendo/io/m2/f$c;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "Ljava/util/Map;", "i", "()Ljava/util/Map;", "streams", "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "connectionName", "I", "()I", "(I)V", "lastGoodStreamId", "f", "setNextStreamId$okhttp", "nextStreamId", "g", "isShutdown", CmcdData.STREAMING_FORMAT_HLS, "Lsdk/pendo/io/i2/e;", "Lsdk/pendo/io/i2/d;", "Lsdk/pendo/io/i2/d;", "writerQueue", "j", "pushQueue", "k", "settingsListenerQueue", "Lsdk/pendo/io/m2/l;", "Lsdk/pendo/io/m2/l;", "pushObserver", CmcdData.OBJECT_TYPE_MANIFEST, "J", "intervalPingsSent", "n", "intervalPongsReceived", "o", "degradedPingsSent", "p", "degradedPongsReceived", "q", "awaitPongsReceived", "r", "degradedPongDeadlineNs", "Lsdk/pendo/io/m2/m;", "s", "Lsdk/pendo/io/m2/m;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "okHttpSettings", "t", "getPeerSettings", "setPeerSettings", "(Lokhttp3/internal/http2/Settings;)V", "peerSettings", "<set-?>", "u", "getReadBytesTotal", "()J", "readBytesTotal", "v", "getReadBytesAcknowledged", "readBytesAcknowledged", "w", "getWriteBytesTotal", "writeBytesTotal", "x", "writeBytesMaximum", "Ljava/net/Socket;", "y", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "socket", "Lsdk/pendo/io/m2/j;", "z", "Lsdk/pendo/io/m2/j;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "writer", "Lsdk/pendo/io/m2/f$d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lsdk/pendo/io/m2/f$d;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "readerRunnable", "", "B", "Ljava/util/Set;", "currentPushRequests", "Lsdk/pendo/io/m2/f$a;", "builder", "<init>", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "C", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class f implements Closeable {

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final m D;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private final d readerRunnable;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private final Set<Integer> currentPushRequests;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final boolean client;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final c listener;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Map<Integer, sdk.pendo.io.m2.i> streams;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String connectionName;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private int lastGoodStreamId;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private int nextStreamId;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private boolean isShutdown;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final sdk.pendo.io.i2.e taskRunner;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final sdk.pendo.io.i2.d writerQueue;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final sdk.pendo.io.i2.d pushQueue;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final sdk.pendo.io.i2.d settingsListenerQueue;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final sdk.pendo.io.m2.l pushObserver;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private long intervalPingsSent;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private long intervalPongsReceived;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private long degradedPingsSent;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private long degradedPongsReceived;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private long awaitPongsReceived;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private long degradedPongDeadlineNs;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private final m okHttpSettings;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private m peerSettings;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private long readBytesTotal;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private long readBytesAcknowledged;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private long writeBytesTotal;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private long writeBytesMaximum;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    private final Socket socket;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    private final sdk.pendo.io.m2.j writer;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\bD\u0010EJ.\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\n\u001a\u00020\u000fR\"\u0010\u0016\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b\n\u0010 R\"\u0010%\u001a\u00020\u00048\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u001c\u0010#\"\u0004\b\n\u0010$R\"\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\f\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010>\u001a\u0002088\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010\u000e\u001a\u00020\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\b&\u0010A\"\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lsdk/pendo/io/m2/f$a;", "", "Ljava/net/Socket;", "socket", "", "peerName", "Lsdk/pendo/io/s2/f;", "source", "Lsdk/pendo/io/s2/e;", "sink", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/m2/f$c;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "pingIntervalMillis", "Lsdk/pendo/io/m2/f;", "", "Z", "b", "()Z", "setClient$okhttp", "(Z)V", "client", "Lsdk/pendo/io/i2/e;", "Lsdk/pendo/io/i2/e;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "c", "Ljava/net/Socket;", CmcdData.STREAMING_FORMAT_HLS, "()Ljava/net/Socket;", "(Ljava/net/Socket;)V", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "connectionName", "e", "Lsdk/pendo/io/s2/f;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "f", "Lsdk/pendo/io/s2/e;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", "g", "Lsdk/pendo/io/m2/f$c;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "Lsdk/pendo/io/m2/l;", "Lsdk/pendo/io/m2/l;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "pushObserver", "i", "I", "()I", "setPingIntervalMillis$okhttp", "(I)V", "<init>", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private boolean client;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final sdk.pendo.io.i2.e taskRunner;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public Socket socket;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public String connectionName;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public sdk.pendo.io.s2.f source;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public sdk.pendo.io.s2.e sink;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        private c listener;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        private sdk.pendo.io.m2.l pushObserver;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        private int pingIntervalMillis;

        public a(boolean z, sdk.pendo.io.i2.e taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            this.client = z;
            this.taskRunner = taskRunner;
            this.listener = c.b;
            this.pushObserver = sdk.pendo.io.m2.l.b;
        }

        public final f a() {
            return new f(this);
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final boolean getClient() {
            return this.client;
        }

        public final String c() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            return null;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final c getListener() {
            return this.listener;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final int getPingIntervalMillis() {
            return this.pingIntervalMillis;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final sdk.pendo.io.m2.l getPushObserver() {
            return this.pushObserver;
        }

        public final sdk.pendo.io.s2.e g() {
            sdk.pendo.io.s2.e eVar = this.sink;
            if (eVar != null) {
                return eVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sink");
            return null;
        }

        public final Socket h() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            return null;
        }

        public final sdk.pendo.io.s2.f i() {
            sdk.pendo.io.s2.f fVar = this.source;
            if (fVar != null) {
                return fVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("source");
            return null;
        }

        /* JADX INFO: renamed from: j, reason: from getter */
        public final sdk.pendo.io.i2.e getTaskRunner() {
            return this.taskRunner;
        }

        public final a a(c listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final a a(int pingIntervalMillis) {
            this.pingIntervalMillis = pingIntervalMillis;
            return this;
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.connectionName = str;
        }

        public final void a(sdk.pendo.io.s2.e eVar) {
            Intrinsics.checkNotNullParameter(eVar, "<set-?>");
            this.sink = eVar;
        }

        public final void a(Socket socket) {
            Intrinsics.checkNotNullParameter(socket, "<set-?>");
            this.socket = socket;
        }

        public final void a(sdk.pendo.io.s2.f fVar) {
            Intrinsics.checkNotNullParameter(fVar, "<set-?>");
            this.source = fVar;
        }

        public final a a(Socket socket, String peerName, sdk.pendo.io.s2.f source, sdk.pendo.io.s2.e sink) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            a(socket);
            a((this.client ? new StringBuilder().append(sdk.pendo.io.f2.b.i).append(' ') : new StringBuilder("MockWebServer ")).append(peerName).toString());
            a(source);
            a(sink);
            return this;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.m2.f$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/m2/f$b;", "", "", "AWAIT_PING", "I", "Lsdk/pendo/io/m2/m;", "DEFAULT_SETTINGS", "Lsdk/pendo/io/m2/m;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final m a() {
            return f.D;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lsdk/pendo/io/m2/f$c;", "", "Lsdk/pendo/io/m2/i;", "stream", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/m2/f;", "connection", "Lsdk/pendo/io/m2/m;", BoxAnalyticsParams.CATEGORY_SETTINGS, "<init>", "()V", "b", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static abstract class c {
        public static final c b = new a();

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"sdk/pendo/io/m2/f$c$a", "Lsdk/pendo/io/m2/f$c;", "Lsdk/pendo/io/m2/i;", "stream", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class a extends c {
            a() {
            }

            @Override // sdk.pendo.io.m2.f.c
            public void a(sdk.pendo.io.m2.i stream) {
                Intrinsics.checkNotNullParameter(stream, "stream");
                stream.a(b.REFUSED_STREAM, (IOException) null);
            }
        }

        public void a(f connection, m settings) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        public abstract void a(sdk.pendo.io.m2.i stream);
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0000\u0012\u0006\u0010-\u001a\u00020)¢\u0006\u0004\b.\u0010/J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J(\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J.\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0017\u001a\u00020\u0003H\u0016J \u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0016J(\u0010%\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0005H\u0016J&\u0010(\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u001a\u0010-\u001a\u00020)8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010*\u001a\u0004\b+\u0010,¨\u00060"}, d2 = {"Lsdk/pendo/io/m2/f$d;", "Lsdk/pendo/io/m2/h$c;", "Lkotlin/Function0;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "inFinished", "", "streamId", "Lsdk/pendo/io/s2/f;", "source", Analytics.Data.LENGTH, "associatedStreamId", "", "Lsdk/pendo/io/m2/c;", "headerBlock", "headers", "Lsdk/pendo/io/m2/b;", "errorCode", "clearPrevious", "Lsdk/pendo/io/m2/m;", BoxAnalyticsParams.CATEGORY_SETTINGS, "b", "ackSettings", "ack", "payload1", "payload2", "ping", "lastGoodStreamId", "Lsdk/pendo/io/s2/g;", "debugData", "", "windowSizeIncrement", "windowUpdate", "streamDependency", "weight", "exclusive", LogFactory.PRIORITY_KEY, "promisedStreamId", "requestHeaders", "pushPromise", "Lsdk/pendo/io/m2/h;", "Lsdk/pendo/io/m2/h;", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "reader", "<init>", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public final class d implements sdk.pendo.io.m2.h.c, Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final sdk.pendo.io.m2.h reader;
        final /* synthetic */ f b;

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/i2/c", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class a extends sdk.pendo.io.i2.a {
            final /* synthetic */ f e;
            final /* synthetic */ Ref.ObjectRef f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z, f fVar, Ref.ObjectRef objectRef) {
                super(str, z);
                this.e = fVar;
                this.f = objectRef;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // sdk.pendo.io.i2.a
            public long e() {
                this.e.getListener().a(this.e, (m) this.f.element);
                return -1L;
            }
        }

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/i2/c", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class b extends sdk.pendo.io.i2.a {
            final /* synthetic */ f e;
            final /* synthetic */ sdk.pendo.io.m2.i f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z, f fVar, sdk.pendo.io.m2.i iVar) {
                super(str, z);
                this.e = fVar;
                this.f = iVar;
            }

            @Override // sdk.pendo.io.i2.a
            public long e() {
                try {
                    this.e.getListener().a(this.f);
                    return -1L;
                } catch (IOException e) {
                    sdk.pendo.io.n2.h.INSTANCE.d().a("Http2Connection.Listener failure for " + this.e.getConnectionName(), 4, e);
                    try {
                        this.f.a(sdk.pendo.io.m2.b.PROTOCOL_ERROR, e);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/i2/c", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class c extends sdk.pendo.io.i2.a {
            final /* synthetic */ f e;
            final /* synthetic */ int f;
            final /* synthetic */ int g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z, f fVar, int i, int i2) {
                super(str, z);
                this.e = fVar;
                this.f = i;
                this.g = i2;
            }

            @Override // sdk.pendo.io.i2.a
            public long e() {
                this.e.a(true, this.f, this.g);
                return -1L;
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.m2.f$d$d, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/i2/c", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class C0419d extends sdk.pendo.io.i2.a {
            final /* synthetic */ d e;
            final /* synthetic */ boolean f;
            final /* synthetic */ m g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0419d(String str, boolean z, d dVar, boolean z2, m mVar) {
                super(str, z);
                this.e = dVar;
                this.f = z2;
                this.g = mVar;
            }

            @Override // sdk.pendo.io.i2.a
            public long e() {
                this.e.b(this.f, this.g);
                return -1L;
            }
        }

        public d(f fVar, sdk.pendo.io.m2.h reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            this.b = fVar;
            this.reader = reader;
        }

        @Override // sdk.pendo.io.m2.h.c
        public void a(boolean inFinished, int streamId, sdk.pendo.io.s2.f source, int length) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.b.b(streamId)) {
                this.b.a(streamId, source, length, inFinished);
                return;
            }
            sdk.pendo.io.m2.i iVarA = this.b.a(streamId);
            if (iVarA == null) {
                this.b.c(streamId, sdk.pendo.io.m2.b.PROTOCOL_ERROR);
                long j = length;
                this.b.b(j);
                source.skip(j);
                return;
            }
            iVarA.a(source, length);
            if (inFinished) {
                iVarA.a(sdk.pendo.io.f2.b.b, true);
            }
        }

        @Override // sdk.pendo.io.m2.h.c
        public void ackSettings() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v1 */
        /* JADX WARN: Type inference failed for: r12v2, types: [T, sdk.pendo.io.m2.m] */
        /* JADX WARN: Type inference failed for: r12v3 */
        public final void b(boolean clearPrevious, m settings) {
            ?? r12;
            long jB;
            int i;
            sdk.pendo.io.m2.i[] iVarArr;
            Intrinsics.checkNotNullParameter(settings, "settings");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            sdk.pendo.io.m2.j writer = this.b.getWriter();
            f fVar = this.b;
            synchronized (writer) {
                synchronized (fVar) {
                    m peerSettings = fVar.getPeerSettings();
                    if (clearPrevious) {
                        r12 = settings;
                    } else {
                        m mVar = new m();
                        mVar.a(peerSettings);
                        mVar.a(settings);
                        r12 = mVar;
                    }
                    objectRef.element = r12;
                    jB = ((long) r12.b()) - ((long) peerSettings.b());
                    iVarArr = (jB == 0 || fVar.i().isEmpty()) ? null : (sdk.pendo.io.m2.i[]) fVar.i().values().toArray(new sdk.pendo.io.m2.i[0]);
                    fVar.a((m) objectRef.element);
                    fVar.settingsListenerQueue.a(new a(fVar.getConnectionName() + " onSettings", true, fVar, objectRef), 0L);
                    Unit unit = Unit.INSTANCE;
                }
                try {
                    fVar.getWriter().a((m) objectRef.element);
                } catch (IOException e) {
                    fVar.a(e);
                }
                Unit unit2 = Unit.INSTANCE;
            }
            if (iVarArr != null) {
                for (sdk.pendo.io.m2.i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.a(jB);
                        Unit unit3 = Unit.INSTANCE;
                    }
                }
            }
        }

        @Override // sdk.pendo.io.m2.h.c
        public void headers(boolean inFinished, int streamId, int associatedStreamId, List<sdk.pendo.io.m2.c> headerBlock) {
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            if (this.b.b(streamId)) {
                this.b.b(streamId, headerBlock, inFinished);
                return;
            }
            f fVar = this.b;
            synchronized (fVar) {
                sdk.pendo.io.m2.i iVarA = fVar.a(streamId);
                if (iVarA != null) {
                    Unit unit = Unit.INSTANCE;
                    iVarA.a(sdk.pendo.io.f2.b.a(headerBlock), inFinished);
                    return;
                }
                if (fVar.isShutdown) {
                    return;
                }
                if (streamId <= fVar.getLastGoodStreamId()) {
                    return;
                }
                if (streamId % 2 == fVar.getNextStreamId() % 2) {
                    return;
                }
                sdk.pendo.io.m2.i iVar = new sdk.pendo.io.m2.i(streamId, fVar, false, inFinished, sdk.pendo.io.f2.b.a(headerBlock));
                fVar.d(streamId);
                fVar.i().put(Integer.valueOf(streamId), iVar);
                fVar.taskRunner.e().a(new b(fVar.getConnectionName() + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] onStream", true, fVar, iVar), 0L);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws Throwable {
            a();
            return Unit.INSTANCE;
        }

        @Override // sdk.pendo.io.m2.h.c
        public void ping(boolean ack, int payload1, int payload2) {
            if (!ack) {
                this.b.writerQueue.a(new c(this.b.getConnectionName() + " ping", true, this.b, payload1, payload2), 0L);
                return;
            }
            f fVar = this.b;
            synchronized (fVar) {
                try {
                    if (payload1 == 1) {
                        fVar.intervalPongsReceived++;
                    } else if (payload1 != 2) {
                        if (payload1 == 3) {
                            fVar.awaitPongsReceived++;
                            Intrinsics.checkNotNull(fVar, "null cannot be cast to non-null type java.lang.Object");
                            fVar.notifyAll();
                        }
                        Unit unit = Unit.INSTANCE;
                    } else {
                        fVar.degradedPongsReceived++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // sdk.pendo.io.m2.h.c
        public void priority(int streamId, int streamDependency, int weight, boolean exclusive) {
        }

        @Override // sdk.pendo.io.m2.h.c
        public void pushPromise(int streamId, int promisedStreamId, List<sdk.pendo.io.m2.c> requestHeaders) throws Throwable {
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            this.b.a(promisedStreamId, requestHeaders);
        }

        @Override // sdk.pendo.io.m2.h.c
        public void windowUpdate(int streamId, long windowSizeIncrement) {
            f fVar = this.b;
            if (streamId == 0) {
                synchronized (fVar) {
                    fVar.writeBytesMaximum = fVar.getWriteBytesMaximum() + windowSizeIncrement;
                    Intrinsics.checkNotNull(fVar, "null cannot be cast to non-null type java.lang.Object");
                    fVar.notifyAll();
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            sdk.pendo.io.m2.i iVarA = fVar.a(streamId);
            if (iVarA != null) {
                synchronized (iVarA) {
                    iVarA.a(windowSizeIncrement);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }

        @Override // sdk.pendo.io.m2.h.c
        public void a(int lastGoodStreamId, sdk.pendo.io.m2.b errorCode, sdk.pendo.io.s2.g debugData) {
            int i;
            Object[] array;
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            Intrinsics.checkNotNullParameter(debugData, "debugData");
            debugData.j();
            f fVar = this.b;
            synchronized (fVar) {
                array = fVar.i().values().toArray(new sdk.pendo.io.m2.i[0]);
                fVar.isShutdown = true;
                Unit unit = Unit.INSTANCE;
            }
            for (sdk.pendo.io.m2.i iVar : (sdk.pendo.io.m2.i[]) array) {
                if (iVar.getId() > lastGoodStreamId && iVar.p()) {
                    iVar.b(sdk.pendo.io.m2.b.REFUSED_STREAM);
                    this.b.c(iVar.getId());
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable, sdk.pendo.io.m2.h] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void a() throws Throwable {
            Throwable th;
            sdk.pendo.io.m2.b bVar;
            sdk.pendo.io.m2.b bVar2 = sdk.pendo.io.m2.b.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.reader.a(this);
                    while (this.reader.a(false, (sdk.pendo.io.m2.h.c) this)) {
                    }
                    sdk.pendo.io.m2.b bVar3 = sdk.pendo.io.m2.b.NO_ERROR;
                    try {
                        bVar2 = sdk.pendo.io.m2.b.CANCEL;
                        this.b.a(bVar3, bVar2, (IOException) null);
                        bVar = bVar3;
                    } catch (IOException e2) {
                        e = e2;
                        bVar2 = sdk.pendo.io.m2.b.PROTOCOL_ERROR;
                        f fVar = this.b;
                        fVar.a(bVar2, bVar2, e);
                        bVar = fVar;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.b.a(bVar, bVar2, e);
                    sdk.pendo.io.f2.b.a(this.reader);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
                bVar = bVar2;
                this.b.a(bVar, bVar2, e);
                sdk.pendo.io.f2.b.a(this.reader);
                throw th;
            }
            this = this.reader;
            sdk.pendo.io.f2.b.a((Closeable) this);
        }

        @Override // sdk.pendo.io.m2.h.c
        public void a(int streamId, sdk.pendo.io.m2.b errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            boolean zB = this.b.b(streamId);
            f fVar = this.b;
            if (zB) {
                fVar.a(streamId, errorCode);
                return;
            }
            sdk.pendo.io.m2.i iVarC = fVar.c(streamId);
            if (iVarC != null) {
                iVarC.b(errorCode);
            }
        }

        @Override // sdk.pendo.io.m2.h.c
        public void a(boolean clearPrevious, m settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            this.b.writerQueue.a(new C0419d(this.b.getConnectionName() + " applyAndAckSettings", true, this, clearPrevious, settings), 0L);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/i2/c", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class e extends sdk.pendo.io.i2.a {
        final /* synthetic */ f e;
        final /* synthetic */ int f;
        final /* synthetic */ sdk.pendo.io.s2.d g;
        final /* synthetic */ int h;
        final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, boolean z, f fVar, int i, sdk.pendo.io.s2.d dVar, int i2, boolean z2) {
            super(str, z);
            this.e = fVar;
            this.f = i;
            this.g = dVar;
            this.h = i2;
            this.i = z2;
        }

        @Override // sdk.pendo.io.i2.a
        public long e() {
            try {
                boolean zA = this.e.pushObserver.a(this.f, this.g, this.h, this.i);
                if (zA) {
                    this.e.getWriter().a(this.f, b.CANCEL);
                }
                if (!zA && !this.i) {
                    return -1L;
                }
                synchronized (this.e) {
                    this.e.currentPushRequests.remove(Integer.valueOf(this.f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.m2.f$f, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/i2/c", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class C0420f extends sdk.pendo.io.i2.a {
        final /* synthetic */ f e;
        final /* synthetic */ int f;
        final /* synthetic */ List g;
        final /* synthetic */ boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0420f(String str, boolean z, f fVar, int i, List list, boolean z2) {
            super(str, z);
            this.e = fVar;
            this.f = i;
            this.g = list;
            this.h = z2;
        }

        @Override // sdk.pendo.io.i2.a
        public long e() {
            boolean zOnHeaders = this.e.pushObserver.onHeaders(this.f, this.g, this.h);
            if (zOnHeaders) {
                try {
                    this.e.getWriter().a(this.f, b.CANCEL);
                } catch (IOException unused) {
                    return -1L;
                }
            }
            if (!zOnHeaders && !this.h) {
                return -1L;
            }
            synchronized (this.e) {
                this.e.currentPushRequests.remove(Integer.valueOf(this.f));
            }
            return -1L;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/i2/c", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class g extends sdk.pendo.io.i2.a {
        final /* synthetic */ f e;
        final /* synthetic */ int f;
        final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, boolean z, f fVar, int i, List list) {
            super(str, z);
            this.e = fVar;
            this.f = i;
            this.g = list;
        }

        @Override // sdk.pendo.io.i2.a
        public long e() {
            if (!this.e.pushObserver.onRequest(this.f, this.g)) {
                return -1L;
            }
            try {
                this.e.getWriter().a(this.f, b.CANCEL);
                synchronized (this.e) {
                    this.e.currentPushRequests.remove(Integer.valueOf(this.f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/i2/c", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class h extends sdk.pendo.io.i2.a {
        final /* synthetic */ f e;
        final /* synthetic */ int f;
        final /* synthetic */ b g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z, f fVar, int i, b bVar) {
            super(str, z);
            this.e = fVar;
            this.f = i;
            this.g = bVar;
        }

        @Override // sdk.pendo.io.i2.a
        public long e() {
            this.e.pushObserver.a(this.f, this.g);
            synchronized (this.e) {
                this.e.currentPushRequests.remove(Integer.valueOf(this.f));
                Unit unit = Unit.INSTANCE;
            }
            return -1L;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/i2/c", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class i extends sdk.pendo.io.i2.a {
        final /* synthetic */ f e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, boolean z, f fVar) {
            super(str, z);
            this.e = fVar;
        }

        @Override // sdk.pendo.io.i2.a
        public long e() {
            this.e.a(false, 2, 0);
            return -1L;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"sdk/pendo/io/m2/f$j", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class j extends sdk.pendo.io.i2.a {
        final /* synthetic */ f e;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, f fVar, long j) {
            super(str, false, 2, null);
            this.e = fVar;
            this.f = j;
        }

        @Override // sdk.pendo.io.i2.a
        public long e() {
            boolean z;
            synchronized (this.e) {
                if (this.e.intervalPongsReceived < this.e.intervalPingsSent) {
                    z = true;
                } else {
                    this.e.intervalPingsSent++;
                    z = false;
                }
            }
            if (z) {
                this.e.a((IOException) null);
                return -1L;
            }
            this.e.a(false, 1, 0);
            return this.f;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/i2/c", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class k extends sdk.pendo.io.i2.a {
        final /* synthetic */ f e;
        final /* synthetic */ int f;
        final /* synthetic */ b g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str, boolean z, f fVar, int i, b bVar) {
            super(str, z);
            this.e = fVar;
            this.f = i;
            this.g = bVar;
        }

        @Override // sdk.pendo.io.i2.a
        public long e() {
            try {
                this.e.b(this.f, this.g);
                return -1L;
            } catch (IOException e) {
                this.e.a(e);
                return -1L;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/i2/c", "Lsdk/pendo/io/i2/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class l extends sdk.pendo.io.i2.a {
        final /* synthetic */ f e;
        final /* synthetic */ int f;
        final /* synthetic */ long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, boolean z, f fVar, int i, long j) {
            super(str, z);
            this.e = fVar;
            this.f = i;
            this.g = j;
        }

        @Override // sdk.pendo.io.i2.a
        public long e() {
            try {
                this.e.getWriter().a(this.f, this.g);
                return -1L;
            } catch (IOException e) {
                this.e.a(e);
                return -1L;
            }
        }
    }

    static {
        m mVar = new m();
        mVar.a(7, 65535);
        mVar.a(5, 16384);
        D = mVar;
    }

    public f(a builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        boolean client = builder.getClient();
        this.client = client;
        this.listener = builder.getListener();
        this.streams = new LinkedHashMap();
        String strC = builder.c();
        this.connectionName = strC;
        this.nextStreamId = builder.getClient() ? 3 : 2;
        sdk.pendo.io.i2.e taskRunner = builder.getTaskRunner();
        this.taskRunner = taskRunner;
        sdk.pendo.io.i2.d dVarE = taskRunner.e();
        this.writerQueue = dVarE;
        this.pushQueue = taskRunner.e();
        this.settingsListenerQueue = taskRunner.e();
        this.pushObserver = builder.getPushObserver();
        m mVar = new m();
        if (builder.getClient()) {
            mVar.a(7, 16777216);
        }
        this.okHttpSettings = mVar;
        m mVar2 = D;
        this.peerSettings = mVar2;
        this.writeBytesMaximum = mVar2.b();
        this.socket = builder.h();
        this.writer = new sdk.pendo.io.m2.j(builder.g(), client);
        this.readerRunnable = new d(this, new sdk.pendo.io.m2.h(builder.i(), client));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis());
            dVarE.a(new j(strC + " ping", this, nanos), nanos);
        }
    }

    public final boolean b(int streamId) {
        return streamId != 0 && (streamId & 1) == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(b.NO_ERROR, b.CANCEL, (IOException) null);
    }

    public final void flush() {
        this.writer.flush();
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final sdk.pendo.io.m2.j getWriter() {
        return this.writer;
    }

    public final void l() {
        synchronized (this) {
            long j2 = this.degradedPongsReceived;
            long j3 = this.degradedPingsSent;
            if (j2 < j3) {
                return;
            }
            this.degradedPingsSent = j3 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + ((long) 1000000000);
            Unit unit = Unit.INSTANCE;
            this.writerQueue.a(new i(this.connectionName + " ping", true, this), 0L);
        }
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getNextStreamId() {
        return this.nextStreamId;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final m getOkHttpSettings() {
        return this.okHttpSettings;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final m getPeerSettings() {
        return this.peerSettings;
    }

    public final Map<Integer, sdk.pendo.io.m2.i> i() {
        return this.streams;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getClient() {
        return this.client;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getConnectionName() {
        return this.connectionName;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getLastGoodStreamId() {
        return this.lastGoodStreamId;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final c getListener() {
        return this.listener;
    }

    public final void b(int streamId, List<sdk.pendo.io.m2.c> requestHeaders, boolean inFinished) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        this.pushQueue.a(new C0420f(this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] onHeaders", true, this, streamId, requestHeaders, inFinished), 0L);
    }

    public final synchronized sdk.pendo.io.m2.i c(int streamId) {
        sdk.pendo.io.m2.i iVarRemove;
        iVarRemove = this.streams.remove(Integer.valueOf(streamId));
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return iVarRemove;
    }

    public final void d(int i2) {
        this.lastGoodStreamId = i2;
    }

    public final void c(int streamId, b errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.writerQueue.a(new k(this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] writeSynReset", true, this, streamId, errorCode), 0L);
    }

    public final void a(b connectionCode, b streamCode, IOException cause) {
        int i2;
        Object[] array;
        Intrinsics.checkNotNullParameter(connectionCode, "connectionCode");
        Intrinsics.checkNotNullParameter(streamCode, "streamCode");
        if (sdk.pendo.io.f2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        try {
            a(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.streams.isEmpty()) {
                array = null;
            } else {
                array = this.streams.values().toArray(new sdk.pendo.io.m2.i[0]);
                this.streams.clear();
            }
            Unit unit = Unit.INSTANCE;
        }
        sdk.pendo.io.m2.i[] iVarArr = (sdk.pendo.io.m2.i[]) array;
        if (iVarArr != null) {
            for (sdk.pendo.io.m2.i iVar : iVarArr) {
                try {
                    iVar.a(streamCode, cause);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.i();
        this.pushQueue.i();
        this.settingsListenerQueue.i();
    }

    public final synchronized void b(long read) {
        long j2 = this.readBytesTotal + read;
        this.readBytesTotal = j2;
        long j3 = j2 - this.readBytesAcknowledged;
        if (j3 >= this.okHttpSettings.b() / 2) {
            a(0, j3);
            this.readBytesAcknowledged += j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(IOException e2) {
        b bVar = b.PROTOCOL_ERROR;
        a(bVar, bVar, e2);
    }

    public final void b(int streamId, b statusCode) {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        this.writer.a(streamId, statusCode);
    }

    public final synchronized sdk.pendo.io.m2.i a(int id) {
        return this.streams.get(Integer.valueOf(id));
    }

    public final synchronized boolean a(long nowNs) {
        if (this.isShutdown) {
            return false;
        }
        return this.degradedPongsReceived >= this.degradedPingsSent || nowNs < this.degradedPongDeadlineNs;
    }

    private final sdk.pendo.io.m2.i a(int associatedStreamId, List<sdk.pendo.io.m2.c> requestHeaders, boolean out) {
        Throwable th;
        sdk.pendo.io.m2.i iVar;
        boolean z;
        boolean z2 = !out;
        synchronized (this.writer) {
            synchronized (this) {
                try {
                    if (this.nextStreamId > 1073741823) {
                        try {
                            a(b.REFUSED_STREAM);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    try {
                        if (this.isShutdown) {
                            throw new sdk.pendo.io.m2.a();
                        }
                        int i2 = this.nextStreamId;
                        this.nextStreamId = i2 + 2;
                        iVar = new sdk.pendo.io.m2.i(i2, this, z2, false, null);
                        z = !out || this.writeBytesTotal >= this.writeBytesMaximum || iVar.getWriteBytesTotal() >= iVar.getWriteBytesMaximum();
                        if (iVar.q()) {
                            this.streams.put(Integer.valueOf(i2), iVar);
                        }
                        Unit unit = Unit.INSTANCE;
                        if (associatedStreamId == 0) {
                            this.writer.a(z2, i2, requestHeaders);
                        } else {
                            if (this.client) {
                                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
                            }
                            this.writer.a(associatedStreamId, i2, requestHeaders);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
                th = th;
                throw th;
            }
        }
        if (z) {
            this.writer.flush();
        }
        return iVar;
    }

    public final sdk.pendo.io.m2.i a(List<sdk.pendo.io.m2.c> requestHeaders, boolean out) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        return a(0, requestHeaders, out);
    }

    public final void a(int streamId, sdk.pendo.io.s2.f source, int byteCount, boolean inFinished) {
        Intrinsics.checkNotNullParameter(source, "source");
        sdk.pendo.io.s2.d dVar = new sdk.pendo.io.s2.d();
        long j2 = byteCount;
        source.require(j2);
        source.b(dVar, j2);
        this.pushQueue.a(new e(this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] onData", true, this, streamId, dVar, byteCount, inFinished), 0L);
    }

    public final void a(int streamId, List<sdk.pendo.io.m2.c> requestHeaders) throws Throwable {
        Throwable th;
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        synchronized (this) {
            try {
                if (!this.currentPushRequests.contains(Integer.valueOf(streamId))) {
                    this.currentPushRequests.add(Integer.valueOf(streamId));
                    this.pushQueue.a(new g(this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] onRequest", true, this, streamId, requestHeaders), 0L);
                    return;
                } else {
                    try {
                        c(streamId, b.PROTOCOL_ERROR);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
            throw th;
        }
    }

    public final void a(int streamId, b errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.pushQueue.a(new h(this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] onReset", true, this, streamId, errorCode), 0L);
    }

    public final void a(m mVar) {
        Intrinsics.checkNotNullParameter(mVar, "<set-?>");
        this.peerSettings = mVar;
    }

    public final void a(b statusCode) {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        synchronized (this.writer) {
            Ref.IntRef intRef = new Ref.IntRef();
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                int i2 = this.lastGoodStreamId;
                intRef.element = i2;
                Unit unit = Unit.INSTANCE;
                this.writer.a(i2, statusCode, sdk.pendo.io.f2.b.a);
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public final void a(boolean sendConnectionPreface, sdk.pendo.io.i2.e taskRunner) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        if (sendConnectionPreface) {
            this.writer.a();
            this.writer.b(this.okHttpSettings);
            int iB = this.okHttpSettings.b();
            if (iB != 65535) {
                this.writer.a(0, iB - 65535);
            }
        }
        taskRunner.e().a(new sdk.pendo.io.i2.c(this.connectionName, true, this.readerRunnable), 0L);
    }

    public static /* synthetic */ void a(f fVar, boolean z, sdk.pendo.io.i2.e eVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            eVar = sdk.pendo.io.i2.e.i;
        }
        fVar.a(z, eVar);
    }

    public final void a(int streamId, boolean outFinished, sdk.pendo.io.s2.d buffer, long byteCount) {
        long j2;
        long j3;
        int iMin;
        long j4;
        if (byteCount == 0) {
            this.writer.a(outFinished, streamId, buffer, 0);
            return;
        }
        while (byteCount > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        j2 = this.writeBytesTotal;
                        j3 = this.writeBytesMaximum;
                        if (j2 >= j3) {
                            if (!this.streams.containsKey(Integer.valueOf(streamId))) {
                                throw new IOException("stream closed");
                            }
                            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                            wait();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(byteCount, j3 - j2), this.writer.getMaxFrameSize());
                j4 = iMin;
                this.writeBytesTotal += j4;
                Unit unit = Unit.INSTANCE;
            }
            byteCount -= j4;
            this.writer.a(outFinished && byteCount == 0, streamId, buffer, iMin);
        }
    }

    public final void a(int streamId, boolean outFinished, List<sdk.pendo.io.m2.c> alternating) {
        Intrinsics.checkNotNullParameter(alternating, "alternating");
        this.writer.a(outFinished, streamId, alternating);
    }

    public final void a(boolean reply, int payload1, int payload2) {
        try {
            this.writer.a(reply, payload1, payload2);
        } catch (IOException e2) {
            a(e2);
        }
    }

    public final void a(int streamId, long unacknowledgedBytesRead) {
        this.writerQueue.a(new l(this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + streamId + "] windowUpdate", true, this, streamId, unacknowledgedBytesRead), 0L);
    }
}
