package sdk.pendo.io.t6;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.s7.l0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0007R$\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019¨\u0006\u001e"}, d2 = {"Lsdk/pendo/io/t6/a;", "Lsdk/pendo/io/q3/e;", "", "value", "", "accept", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "c", "", "sessionTimeoutInSeconds", "", "time", "b", "currentTime", "<set-?>", "J", "getEnterBackgroundStateTime", "()J", "enterBackgroundStateTime", "Lsdk/pendo/io/w6/b$c;", "Lsdk/pendo/io/w6/b$c;", "getCurrentState", "()Lsdk/pendo/io/w6/b$c;", "currentState", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "firstTimeSinceLaunch", "<init>", "()V", "d", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a implements e<Object> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private long enterBackgroundStateTime;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private sdk.pendo.io.w6.b.c currentState = sdk.pendo.io.w6.b.c.IN_FOREGROUND;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final AtomicBoolean firstTimeSinceLaunch = new AtomicBoolean(true);

    public final void a() throws JSONException {
        sdk.pendo.io.s7.d.c();
        sdk.pendo.io.s7.d.d();
        sdk.pendo.io.s7.d.a(sdk.pendo.io.w6.b.c.IN_FOREGROUND);
    }

    @Override // sdk.pendo.io.q3.e
    public synchronized void accept(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        sdk.pendo.io.w6.b.c cVarD = value instanceof sdk.pendo.io.w6.b.c ? (sdk.pendo.io.w6.b.c) value : sdk.pendo.io.w6.b.e().d();
        if (this.firstTimeSinceLaunch.getAndSet(false) && cVarD == sdk.pendo.io.w6.b.c.IN_FOREGROUND) {
            PendoLogger.d("ForegroundBackgroundObserver", "AppInForeground first time since a new session");
            a();
            return;
        }
        sdk.pendo.io.w6.b.c cVar = this.currentState;
        if (cVarD == cVar) {
            PendoLogger.d("ForegroundBackgroundObserver", "App state remains the same: " + cVar.b());
            return;
        }
        PendoLogger.d("ForegroundBackgroundObserver", "App state changed from: " + cVar.b() + " to: " + cVarD.b());
        Intrinsics.checkNotNull(cVarD);
        this.currentState = cVarD;
        if (cVarD == sdk.pendo.io.w6.b.c.IN_BACKGROUND) {
            c();
        } else {
            a(PendoInternal.C());
        }
    }

    public final void b() {
        this.enterBackgroundStateTime = 0L;
        l0.a();
    }

    public final void c() {
        sdk.pendo.io.s7.d.a(sdk.pendo.io.w6.b.c.IN_BACKGROUND);
        b(System.currentTimeMillis());
    }

    public final long a(long currentTime) {
        if (this.enterBackgroundStateTime == 0) {
            this.enterBackgroundStateTime = l0.d();
        }
        long j = this.enterBackgroundStateTime;
        if (j > 0) {
            return (currentTime - j) / ((long) 1000);
        }
        return 0L;
    }

    public final void b(long time) {
        this.enterBackgroundStateTime = time;
        l0.a(time);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x003e  */
    public final void a(int sessionTimeoutInSeconds) {
        boolean z;
        sdk.pendo.io.s7.d.a(sdk.pendo.io.w6.b.c.IN_FOREGROUND);
        if (sessionTimeoutInSeconds > 0) {
            long jA = a(System.currentTimeMillis());
            PendoLogger.d("ForegroundBackgroundObserver", "App state is now IN_FOREGROUND after " + jA + "s IN_BACKGROUND, checking against sessionTimeout of: " + sessionTimeoutInSeconds + "s");
            if (jA >= sessionTimeoutInSeconds) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        long j = this.enterBackgroundStateTime;
        b();
        if (z) {
            PendoInternal.a(j);
            PendoInternal.T();
        }
    }
}
