package sdk.pendo.io.logging;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxFile;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.s7.q0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J$\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J1\u0010\u000b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0006\u0010\fJ9\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0006\u0010\u0010J1\u0010\u0011\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0011\u0010\fJ9\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\u0010J1\u0010\u000f\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\fJ9\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J1\u0010\u0013\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J9\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J.\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/logging/e;", "Lsdk/pendo/io/logging/PendoLogger$d;", "", "message", "loggingLevel", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "exceptionMessage", "", "", "args", "d", "(Ljava/lang/String;[Ljava/lang/Object;)V", "", "t", "e", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "c", "f", "b", "", LogFactory.PRIORITY_KEY, "tag", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class e extends PendoLogger.d {
    private static volatile WeakReference<e> c;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object d = new Object();

    /* JADX INFO: renamed from: sdk.pendo.io.logging.e$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/logging/e$a;", "", "Lsdk/pendo/io/logging/e;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/ref/WeakReference;", "instanceRef", "Ljava/lang/ref/WeakReference;", BoxFile.FIELD_LOCK, "Ljava/lang/Object;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            e eVar;
            e eVar2;
            WeakReference weakReference = e.c;
            if (weakReference != null && (eVar2 = (e) weakReference.get()) != null) {
                return eVar2;
            }
            synchronized (e.d) {
                WeakReference weakReference2 = e.c;
                if (weakReference2 != null && (eVar = (e) weakReference2.get()) != null) {
                    Intrinsics.checkNotNull(eVar);
                    return eVar;
                }
                e eVar3 = new e(null);
                e.c = new WeakReference(eVar3);
                return eVar3;
            }
        }
    }

    private e() {
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    protected void a(int priority, String tag, String message, Throwable t) {
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void d(final Throwable t, final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.e$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                e.c(this.f$0, t, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void e(final Throwable t, final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.e$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                e.d(this.f$0, t, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void f(final Throwable t, final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.e$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                e.e(this.f$0, t, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void a(final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.e$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                e.a(this.f$0, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void b(final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.e$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                e.b(this.f$0, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void c(final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.e$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                e.c(this.f$0, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void d(final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.e$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                e.d(this.f$0, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void e(final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.e$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                e.e(this.f$0, message, args);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(e this$0, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(args, "$args");
        this$0.a(this$0.c((Throwable) null, str, Arrays.copyOf(args, args.length)), "I");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(e this$0, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(args, "$args");
        this$0.a(this$0.c((Throwable) null, str, Arrays.copyOf(args, args.length)), ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(e this$0, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(args, "$args");
        this$0.a(this$0.c((Throwable) null, str, Arrays.copyOf(args, args.length)), ExifInterface.LONGITUDE_WEST);
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void a(final Throwable t, final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.e$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                e.a(this.f$0, t, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void b(final Throwable t) {
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.e$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                e.a(this.f$0, t);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(e this$0, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(args, "$args");
        this$0.a(this$0.c((Throwable) null, str, Arrays.copyOf(args, args.length)), "D");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(e this$0, Throwable t, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(t, "$t");
        Intrinsics.checkNotNullParameter(args, "$args");
        this$0.a(this$0.c(t, str, Arrays.copyOf(args, args.length)), "I", t.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(e this$0, Throwable t, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(t, "$t");
        Intrinsics.checkNotNullParameter(args, "$args");
        this$0.a(this$0.c(t, str, Arrays.copyOf(args, args.length)), ExifInterface.GPS_MEASUREMENT_INTERRUPTED, t.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(e this$0, Throwable t, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(t, "$t");
        Intrinsics.checkNotNullParameter(args, "$args");
        this$0.a(this$0.c(t, str, Arrays.copyOf(args, args.length)), ExifInterface.LONGITUDE_WEST, t.toString());
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void b(final Throwable t, final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.e$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                e.b(this.f$0, t, message, args);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(e this$0, Throwable t, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(t, "$t");
        Intrinsics.checkNotNullParameter(args, "$args");
        this$0.a(this$0.c(t, str, Arrays.copyOf(args, args.length)), "D", t.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(e this$0, Throwable t, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(t, "$t");
        Intrinsics.checkNotNullParameter(args, "$args");
        this$0.a(this$0.c(t, str, Arrays.copyOf(args, args.length)), ExifInterface.LONGITUDE_EAST, t.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(e this$0, Throwable th) {
        String string;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String strC = this$0.c(th, (String) null, null);
        if (th == null || (string = th.toString()) == null) {
            string = "";
        }
        this$0.a(strC, ExifInterface.LONGITUDE_EAST, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(e this$0, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(args, "$args");
        this$0.a(this$0.c((Throwable) null, str, Arrays.copyOf(args, args.length)), ExifInterface.LONGITUDE_EAST);
    }

    public final void a(String message, String loggingLevel, String exceptionMessage) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FirebaseAnalytics.Param.LEVEL, loggingLevel);
            jSONObject.put("data", message);
            jSONObject.put("exception", exceptionMessage);
            sdk.pendo.io.p6.b.b(jSONObject);
        } catch (JSONException unused) {
        }
    }

    public final void a(String message, String loggingLevel) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FirebaseAnalytics.Param.LEVEL, loggingLevel);
            jSONObject.put("message", message);
            sdk.pendo.io.p6.b.b(jSONObject);
        } catch (JSONException unused) {
        }
    }
}
