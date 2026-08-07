package sdk.pendo.io.logging;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxFile;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.s7.q0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J1\u0010\u0005\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0005\u0010\u000bJ9\u0010\u0005\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0005\u0010\u000eJ1\u0010\u000f\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ9\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ1\u0010\u0011\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ9\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ1\u0010\u0013\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J9\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0013\u0010\u000e¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/logging/b;", "Lsdk/pendo/io/logging/PendoLogger$b;", "Ljava/lang/StackTraceElement;", "element", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "message", "", "", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "", "t", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "c", "d", "e", "f", "b", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b extends PendoLogger.b {
    private static volatile WeakReference<b> c;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object d = new Object();

    /* JADX INFO: renamed from: sdk.pendo.io.logging.b$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/logging/b$a;", "", "Lsdk/pendo/io/logging/b;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/ref/WeakReference;", "instanceRef", "Ljava/lang/ref/WeakReference;", BoxFile.FIELD_LOCK, "Ljava/lang/Object;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            b bVar;
            b bVar2;
            WeakReference weakReference = b.c;
            if (weakReference != null && (bVar2 = (b) weakReference.get()) != null) {
                return bVar2;
            }
            synchronized (b.d) {
                WeakReference weakReference2 = b.c;
                if (weakReference2 != null && (bVar = (b) weakReference2.get()) != null) {
                    Intrinsics.checkNotNull(bVar);
                    return bVar;
                }
                b bVar3 = new b(null);
                b.c = new WeakReference(bVar3);
                return bVar3;
            }
        }
    }

    private b() {
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void b(Throwable t) {
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void d(final Throwable t, final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.b$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                b.b(this.f$0, t, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void e(String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void f(Throwable t, String message, Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.b
    public String a(StackTraceElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        String className = element.getClassName();
        String methodName = element.getMethodName();
        int lineNumber = element.getLineNumber();
        Matcher matcher = PendoLogger.ANONYMOUS_CLASS.matcher(className);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        String str = className;
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNull(str);
        String strSubstring = str.substring(StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return "Pendo::" + strSubstring + ":" + methodName + "():" + lineNumber + ":";
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void b(String message, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void c(final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.b$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                b.b(this.f$0, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void a(final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.b$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                b.a(this.f$0, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void a(final Throwable t, final String message, final Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
        q0.a(new PendoLogger.c(new Runnable() { // from class: sdk.pendo.io.logging.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                b.a(this.f$0, t, message, args);
            }
        }));
    }

    @Override // sdk.pendo.io.logging.PendoLogger.d
    public void b(Throwable t, String message, Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(args, "args");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(b this$0, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(args, "$args");
        super.a(str, Arrays.copyOf(args, args.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(b this$0, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(args, "$args");
        super.c(str, Arrays.copyOf(args, args.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(b this$0, Throwable t, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(t, "$t");
        Intrinsics.checkNotNullParameter(args, "$args");
        super.a(t, str, Arrays.copyOf(args, args.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(b this$0, Throwable t, String str, Object[] args) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(t, "$t");
        Intrinsics.checkNotNullParameter(args, "$args");
        super.d(t, str, Arrays.copyOf(args, args.length));
    }
}
