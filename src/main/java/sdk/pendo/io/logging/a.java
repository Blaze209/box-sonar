package sdk.pendo.io.logging;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxFile;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import sdk.pendo.io.s7.q0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J$\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004J1\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0003\u0010\fJ;\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0007\u0010\fJ;\u0010\u0007\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0007\u0010\u0010J1\u0010\u0011\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0011\u0010\fJ;\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0003\u0010\u0010J1\u0010\u000f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000f\u0010\fJ;\u0010\u0012\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J1\u0010\u0013\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J;\u0010\u0013\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J.\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014R\u001c\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u000f\u0010\u001c\"\u0004\b\u0013\u0010\u001dR\u0011\u0010!\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010 ¨\u0006$"}, d2 = {"Lsdk/pendo/io/logging/a;", "Lsdk/pendo/io/logging/PendoLogger$d;", "", "d", "", "message", "loggingLevel", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "exceptionMessage", "", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;)V", "", "t", "e", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "c", "f", "b", "", LogFactory.PRIORITY_KEY, "tag", "Ljava/util/LinkedList;", "Lsdk/pendo/io/e6/a;", "Ljava/util/LinkedList;", "remoteDebuggingInfo", "I", "()I", "(I)V", "refreshInterval", "Lorg/json/JSONArray;", "()Lorg/json/JSONArray;", "remoteDebuggingInfoAsJSONArray", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a extends PendoLogger.d {
    private static volatile WeakReference<a> e;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final LinkedList<sdk.pendo.io.e6.a> remoteDebuggingInfo;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private int refreshInterval;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object f = new Object();

    /* JADX INFO: renamed from: sdk.pendo.io.logging.a$a, reason: collision with other inner class name and from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/logging/a$a;", "", "Lsdk/pendo/io/logging/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "DEFAULT_INTERVAL_TIME", "I", "Ljava/lang/ref/WeakReference;", "instanceRef", "Ljava/lang/ref/WeakReference;", BoxFile.FIELD_LOCK, "Ljava/lang/Object;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            a aVar;
            a aVar2;
            WeakReference weakReference = a.e;
            if (weakReference != null && (aVar2 = (a) weakReference.get()) != null) {
                return aVar2;
            }
            synchronized (a.f) {
                WeakReference weakReference2 = a.e;
                if (weakReference2 != null && (aVar = (a) weakReference2.get()) != null) {
                    Intrinsics.checkNotNull(aVar);
                    return aVar;
                }
                a aVar3 = new a(null);
                a.e = new WeakReference(aVar3);
                return aVar3;
            }
        }
    }

    private a() {
        this.remoteDebuggingInfo = new LinkedList<>();
        this.refreshInterval = 60;
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    protected void a(int priority, String tag, String message, Throwable t) {
    }

    public final void d() {
        synchronized (this.remoteDebuggingInfo) {
            this.remoteDebuggingInfo.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getRefreshInterval() {
        return this.refreshInterval;
    }

    public final JSONArray f() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.remoteDebuggingInfo) {
            ListIterator<sdk.pendo.io.e6.a> listIterator = this.remoteDebuggingInfo.listIterator();
            Intrinsics.checkNotNullExpressionValue(listIterator, "listIterator(...)");
            while (listIterator.hasNext()) {
                jSONArray.put(String.valueOf(listIterator.next()));
            }
            Unit unit = Unit.INSTANCE;
        }
        return jSONArray;
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(a this$0, String str, Throwable th) {
        String string;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (th == null || (string = th.toString()) == null) {
            string = AbstractJsonLexerKt.NULL;
        }
        this$0.a(str, ExifInterface.LONGITUDE_EAST, string);
    }

    public final void a(String message, String loggingLevel, String exceptionMessage) {
        synchronized (this.remoteDebuggingInfo) {
            this.remoteDebuggingInfo.add(new sdk.pendo.io.e6.a(System.currentTimeMillis() / ((long) 1000), message, exceptionMessage, loggingLevel));
        }
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void b(final String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.a$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                a.b(this.f$0, message);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void d(final Throwable t, final String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.a$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                a.d(this.f$0, message, t);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void e(final Throwable t, final String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                a.e(this.f$0, message, t);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void f(final Throwable t, final String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.a$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                a.f(this.f$0, message, t);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(a this$0, String str, Throwable th) {
        String string;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (th == null || (string = th.toString()) == null) {
            string = AbstractJsonLexerKt.NULL;
        }
        this$0.a(str, "I", string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(a this$0, String str, Throwable th) {
        String string;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (th == null || (string = th.toString()) == null) {
            string = AbstractJsonLexerKt.NULL;
        }
        this$0.a(str, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(a this$0, String str, Throwable th) {
        String string;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (th == null || (string = th.toString()) == null) {
            string = AbstractJsonLexerKt.NULL;
        }
        this$0.a(str, ExifInterface.LONGITUDE_WEST, string);
    }

    public final void a(String message, String loggingLevel) {
        synchronized (this.remoteDebuggingInfo) {
            this.remoteDebuggingInfo.add(new sdk.pendo.io.e6.a(System.currentTimeMillis() / ((long) 1000), message, loggingLevel));
        }
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void b(final Throwable t) {
        final String message = t != null ? t.getMessage() : null;
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.a$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                a.b(this.f$0, message, t);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void c(final String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.a$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                a.c(this.f$0, message);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(a this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(str, "I");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void a(final String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.a$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                a.a(this.f$0, message);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void b(final Throwable t, final String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.a$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                a.c(this.f$0, message, t);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void d(final String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.a$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                a.d(this.f$0, message);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void e(final String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.a$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                a.e(this.f$0, message);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(a this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(str, ExifInterface.LONGITUDE_EAST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(a this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(str, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(a this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(str, ExifInterface.LONGITUDE_WEST);
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void a(final Throwable t, final String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                a.a(this.f$0, message, t);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(str, "D");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(a this$0, String str, Throwable th) {
        String string;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (th == null || (string = th.toString()) == null) {
            string = AbstractJsonLexerKt.NULL;
        }
        this$0.a(str, ExifInterface.LONGITUDE_EAST, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, String str, Throwable th) {
        String string;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (th == null || (string = th.toString()) == null) {
            string = AbstractJsonLexerKt.NULL;
        }
        this$0.a(str, "D", string);
    }

    public final void b(int i) {
        this.refreshInterval = i;
    }
}
