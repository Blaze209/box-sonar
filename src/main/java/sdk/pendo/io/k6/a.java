package sdk.pendo.io.k6;

import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxSimpleMessage;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.z;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.n6.c;
import sdk.pendo.io.n6.d;
import sdk.pendo.io.n6.f;
import sdk.pendo.io.n6.h;
import sdk.pendo.io.n6.i;
import sdk.pendo.io.n6.j;
import sdk.pendo.io.n6.k;
import sdk.pendo.io.n6.l;
import sdk.pendo.io.n6.m;
import sdk.pendo.io.n6.n;
import sdk.pendo.io.n6.o;
import sdk.pendo.io.n6.p;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.views.listener.FloatingListenerButton;
import sdk.pendo.io.z4.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J1\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0002J\u001c\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lsdk/pendo/io/k6/a;", "", "", "d", "f", "", "event", "", "args", "Lsdk/pendo/io/a5/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/String;[Ljava/lang/Object;)Lsdk/pendo/io/a5/a;", "e", "Lsdk/pendo/io/a5/a$a;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "b", "c", "Lsdk/pendo/io/z4/e;", "Lsdk/pendo/io/z4/e;", "mSocket", "Lsdk/pendo/io/n6/l;", "Lsdk/pendo/io/n6/l;", "mOnConnectedListener", "Lsdk/pendo/io/n6/m;", "Lsdk/pendo/io/n6/m;", "mOnDisconnectedListener", "Lsdk/pendo/io/n6/n;", "Lsdk/pendo/io/n6/n;", "mOnTerminateListener", "Lsdk/pendo/io/n6/i;", "Lsdk/pendo/io/n6/i;", "mPairedModeUpdateListener", "Lsdk/pendo/io/n6/k;", "g", "Lsdk/pendo/io/n6/k;", "mResetStateListener", "Lsdk/pendo/io/n6/j;", CmcdData.STREAMING_FORMAT_HLS, "Lsdk/pendo/io/n6/j;", "mPreviewOnDeviceListener", "Lsdk/pendo/io/n6/a;", "i", "Lsdk/pendo/io/n6/a;", "mCaptureModeEnterListener", "Lsdk/pendo/io/n6/b;", "j", "Lsdk/pendo/io/n6/b;", "mCaptureModeExitListener", "Lsdk/pendo/io/n6/c;", "k", "Lsdk/pendo/io/n6/c;", "mCaptureModeScreenRecievedListener", "Lsdk/pendo/io/n6/o;", CmcdData.STREAM_TYPE_LIVE, "Lsdk/pendo/io/n6/o;", "mOnTestModeEnterListener", "Lsdk/pendo/io/n6/p;", CmcdData.OBJECT_TYPE_MANIFEST, "Lsdk/pendo/io/n6/p;", "mOnTestModeExitListener", "Lsdk/pendo/io/n6/e;", "n", "Lsdk/pendo/io/n6/e;", "mDebugModeEnterListener", "Lsdk/pendo/io/n6/f;", "o", "Lsdk/pendo/io/n6/f;", "mDebugModeExitListener", "Lsdk/pendo/io/n6/h;", "p", "Lsdk/pendo/io/n6/h;", "mOnErrorListener", "Lsdk/pendo/io/n6/d;", "q", "Lsdk/pendo/io/n6/d;", "mOnConnectionErrorListener", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static volatile e mSocket;
    public static final a a = new a();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final l mOnConnectedListener = new l();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static final m mOnDisconnectedListener = new m();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private static final n mOnTerminateListener = new n();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private static final i mPairedModeUpdateListener = new i();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private static final k mResetStateListener = new k();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private static final j mPreviewOnDeviceListener = new j();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private static final sdk.pendo.io.n6.a mCaptureModeEnterListener = new sdk.pendo.io.n6.a();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private static final sdk.pendo.io.n6.b mCaptureModeExitListener = new sdk.pendo.io.n6.b();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private static final c mCaptureModeScreenRecievedListener = new c();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private static final o mOnTestModeEnterListener = new o();

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private static final p mOnTestModeExitListener = new p();

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private static final sdk.pendo.io.n6.e mDebugModeEnterListener = new sdk.pendo.io.n6.e();

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private static final f mDebugModeExitListener = new f();

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private static final h mOnErrorListener = new h();

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private static final d mOnConnectionErrorListener = new d();

    static {
        sdk.pendo.io.o6.a.d();
    }

    private a() {
    }

    private final void d() {
        if (sdk.pendo.io.d6.c.h().a() != null) {
            FloatingListenerButton.Builder.removeActiveInstances();
        }
    }

    public final sdk.pendo.io.a5.a a(String event, sdk.pendo.io.a5.a.InterfaceC0343a listener) {
        e eVar = mSocket;
        if (eVar != null) {
            return eVar.b(event, listener);
        }
        return null;
    }

    public final synchronized void b() {
        e eVar = mSocket;
        if (eVar != null) {
            eVar.e();
            a.c();
        }
    }

    public final void c() {
        e eVar = mSocket;
        if (eVar != null) {
            eVar.a();
            eVar.b();
            mSocket = null;
        }
    }

    public final synchronized void e() {
        b();
        e eVar = mSocket;
        if (eVar != null) {
            eVar.a();
        }
        sdk.pendo.io.z4.b.a aVar = new sdk.pendo.io.z4.b.a();
        aVar.r = true;
        aVar.t = TimeUnit.SECONDS.toMillis(2L);
        aVar.z = false;
        String str = "token=" + sdk.pendo.io.network.interfaces.a.b() + "&sessionToken=" + sdk.pendo.io.p6.b.c() + "&version=v2&appVersion=" + AndroidUtils.d();
        PendoLogger.d("sending this query to the socket " + str, new Object[0]);
        aVar.p = str;
        try {
            URI uri = new URI(sdk.pendo.io.p6.b.b().toString());
            String scheme = uri.getScheme();
            if (!TextUtils.isEmpty(scheme) && Intrinsics.areEqual(scheme, "https")) {
                aVar.d = true;
                try {
                    z zVarF = sdk.pendo.io.network.interfaces.a.f();
                    aVar.k = zVarF;
                    aVar.j = zVarF;
                } catch (Exception e) {
                    PendoLogger.e(e, e.getMessage(), new Object[0]);
                }
            }
            aVar.l = new String[]{"websocket"};
            aVar.y = 10000L;
            aVar.b = "/ws/socket.io";
            PendoLogger.d("opening socket to " + uri, new Object[0]);
            mSocket = sdk.pendo.io.z4.b.a(uri, aVar);
            e eVar2 = mSocket;
            if (eVar2 != null) {
                l lVar = mOnConnectedListener;
                eVar2.b("connect", lVar);
                eVar2.b(BoxSimpleMessage.MESSAGE_RECONNECT, lVar);
                h hVar = mOnErrorListener;
                eVar2.b("connect_timeout", hVar);
                eVar2.b("disconnect", mOnDisconnectedListener);
                d dVar = mOnConnectionErrorListener;
                eVar2.b("connect_error", dVar);
                eVar2.b("reconnect_error", dVar);
                eVar2.b("reconnect_failed", dVar);
                eVar2.b("error", hVar);
                b.a(eVar2, sdk.pendo.io.m6.a.EVENT_PAIRED_MODE_UPDATE, mPairedModeUpdateListener);
                b.a(eVar2, sdk.pendo.io.m6.a.EVENT_RESET_STATE, mResetStateListener);
                b.a(eVar2, sdk.pendo.io.m6.a.EVENT_PREVIEW_ON_DEVICE, mPreviewOnDeviceListener);
                b.a(eVar2, sdk.pendo.io.m6.a.EVENT_CAPTURE_MODE_ENTER, mCaptureModeEnterListener);
                b.a(eVar2, sdk.pendo.io.m6.a.EVENT_CAPTURE_MODE_EXIT, mCaptureModeExitListener);
                b.a(eVar2, sdk.pendo.io.m6.a.EVENT_CAPTURE_MODE_SCREEN_RECEIVED, mCaptureModeScreenRecievedListener);
                b.a(eVar2, sdk.pendo.io.m6.a.EVENT_TEST_MODE_ENTER, mOnTestModeEnterListener);
                b.a(eVar2, sdk.pendo.io.m6.a.EVENT_TEST_MODE_EXIT, mOnTestModeExitListener);
                b.a(eVar2, sdk.pendo.io.m6.a.EVENT_TERMINATE, mOnTerminateListener);
                b.a(eVar2, sdk.pendo.io.m6.a.EVENT_INVALID, hVar);
                b.a(eVar2, sdk.pendo.io.m6.a.EVENT_DEBUG_MODE_ENTER, mDebugModeEnterListener);
                b.a(eVar2, sdk.pendo.io.m6.a.EVENT_DEBUG_MODE_EXIT, mDebugModeExitListener);
            }
        } catch (Exception e2) {
            PendoLogger.e(e2, "setupSocket():" + e2.getMessage(), new Object[0]);
        }
    }

    public final void f() {
        d();
        sdk.pendo.io.o6.a.d().v();
    }

    public final synchronized void a() {
        try {
            e();
        } catch (URISyntaxException e) {
            PendoLogger.e(e, "Error while trying to setup socket", new Object[0]);
        }
        e eVar = mSocket;
        if (eVar != null) {
            eVar.c();
        }
    }

    public final sdk.pendo.io.a5.a a(String event, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        e eVar = mSocket;
        if (eVar != null) {
            return eVar.a(event, Arrays.copyOf(args, args.length));
        }
        return null;
    }

    public final sdk.pendo.io.a5.a a(String event) {
        e eVar = mSocket;
        if (eVar != null) {
            return eVar.a(event);
        }
        return null;
    }
}
