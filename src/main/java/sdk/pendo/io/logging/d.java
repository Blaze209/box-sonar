package sdk.pendo.io.logging;

import android.util.Log;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxFile;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.logging.LogFactory;
import sdk.pendo.io.r5.g;
import sdk.pendo.io.s7.q0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ9\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ1\u0010\u000e\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ9\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\rJ1\u0010\u0010\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\tJ9\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\rJ1\u0010\u0011\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\tJ9\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\rJ1\u0010\u000f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\tJ9\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\rJ1\u0010\u0013\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\tJ\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J9\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\rJ.\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/logging/d;", "Lsdk/pendo/io/logging/PendoLogger$d;", "", "message", "", "", "args", "", "g", "(Ljava/lang/String;[Ljava/lang/Object;)V", "", "t", CmcdData.STREAMING_FORMAT_HLS, "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "d", "e", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "c", "f", "b", "", LogFactory.PRIORITY_KEY, "tag", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class d extends PendoLogger.d {
    private static volatile WeakReference<d> c;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object d = new Object();

    /* JADX INFO: renamed from: sdk.pendo.io.logging.d$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/logging/d$a;", "", "Lsdk/pendo/io/logging/d;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/ref/WeakReference;", "instanceRef", "Ljava/lang/ref/WeakReference;", BoxFile.FIELD_LOCK, "Ljava/lang/Object;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            d dVar;
            d dVar2;
            WeakReference weakReference = d.c;
            if (weakReference != null && (dVar2 = (d) weakReference.get()) != null) {
                return dVar2;
            }
            synchronized (d.d) {
                WeakReference weakReference2 = d.c;
                if (weakReference2 != null && (dVar = (d) weakReference2.get()) != null) {
                    Intrinsics.checkNotNull(dVar);
                    return dVar;
                }
                d dVar3 = new d(null);
                d.c = new WeakReference(dVar3);
                return dVar3;
            }
        }
    }

    private d() {
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void g(String message, Object... args) {
        if (sdk.pendo.io.f6.a.d().f()) {
            sdk.pendo.io.s7.d.a(g.b.ERROR_REASON_CONFIGURATION, message, Arrays.copyOf(args, args.length));
        }
    }

    private final void h(Throwable t, String message, Object... args) {
        Object obj;
        if (t instanceof SSLPeerUnverifiedException) {
            PendoLogger.d("Cannot send SSLPeerUnverifiedException to server yet.", new Object[0]);
        } else if (sdk.pendo.io.f6.a.d().f()) {
            sdk.pendo.io.s7.d.a(t, ((args.length == 0) || (obj = args[0]) == null) ? null : obj.toString(), message);
        }
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void d(Throwable t, String message, Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void e(Throwable t, String message, Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void f(final Throwable t, final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.d$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                d.b(this.f$0, t, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void a(String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void b(final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.d$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                d.a(this.f$0, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void c(String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void d(String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void e(final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.d$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                d.b(this.f$0, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void a(Throwable t, String message, Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void b(final Throwable t) {
        if (t == null) {
            return;
        }
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                d.a(this.f$0, t);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(d this$0, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(args, "$args");
        super.b(str, Arrays.copyOf(args, args.length));
        this$0.g(str, Arrays.copyOf(args, args.length));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void b(final Throwable t, final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.d$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                d.a(this.f$0, t, message, args);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(d this$0, Throwable th) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.b(th);
        this$0.h(th, th.getMessage(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(d this$0, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(args, "$args");
        super.e(str, Arrays.copyOf(args, args.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(d this$0, Throwable t, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(t, "$t");
        Intrinsics.checkNotNullParameter(args, "$args");
        super.b(t, str, Arrays.copyOf(args, args.length));
        this$0.h(t, str, Arrays.copyOf(args, args.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(d this$0, Throwable t, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(t, "$t");
        Intrinsics.checkNotNullParameter(args, "$args");
        super.f(t, str, Arrays.copyOf(args, args.length));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    protected void a(int priority, String tag, String message, Throwable t) {
        if (message == null) {
            return;
        }
        if (message.length() < 4000) {
            if (priority == 7) {
                Log.wtf("Pendo", message);
                return;
            } else {
                Log.println(priority, "Pendo", message);
                return;
            }
        }
        int length = message.length();
        int iMin = 0;
        while (true) {
            int i = iMin;
            if (i >= length) {
                return;
            }
            String str = message;
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, '\n', i, false, 4, (Object) null);
            if (iIndexOf$default == -1) {
                iIndexOf$default = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf$default, i + 4000);
                String strSubstring = str.substring(i, iMin);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                if (priority == 7) {
                    Log.wtf("Pendo", strSubstring);
                } else {
                    Log.println(priority, "Pendo", strSubstring);
                }
                if (iMin >= iIndexOf$default) {
                    break;
                } else {
                    i = iMin;
                }
            }
            message = str;
        }
    }
}
