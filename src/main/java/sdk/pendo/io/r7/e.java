package sdk.pendo.io.r7;

import android.graphics.Rect;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0010¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u000b\u0010\nR!\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0007\u0010\u000fR!\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u000e\u001a\u0004\b\r\u0010\u000f¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/r7/e;", "Lsdk/pendo/io/r7/c;", "Landroid/view/View;", "view", "Landroid/graphics/Rect;", "windowBounds", "", "b", "(Landroid/view/View;Landroid/graphics/Rect;)Z", "d", "(Landroid/view/View;)Z", "e", "Ljava/lang/Class;", "c", "Lkotlin/Lazy;", "()Ljava/lang/Class;", "debugOverlayView", "reactModalHostView", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class e extends c {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Lazy debugOverlayView = LazyKt.lazy(a.a);

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Lazy reactModalHostView = LazyKt.lazy(b.a);

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/Class;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/lang/Class;"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function0<Class<?>> {
        public static final a a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Class<?> invoke() {
            try {
                return Class.forName("com.facebook.react.views.debuggingoverlay.DebuggingOverlay");
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/Class;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/lang/Class;"}, k = 3, mv = {1, 9, 0})
    static final class b extends Lambda implements Function0<Class<?>> {
        public static final b a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Class<?> invoke() {
            try {
                return Class.forName("com.facebook.react.views.modal.ReactModalHostView");
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
    }

    private final Class<?> b() {
        return (Class) this.debugOverlayView.getValue();
    }

    private final Class<?> c() {
        return (Class) this.reactModalHostView.getValue();
    }

    public final boolean d(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Class<?> clsB = b();
        return clsB != null && clsB.isInstance(view);
    }

    public final boolean e(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Class<?> clsC = c();
        return clsC != null && clsC.isInstance(view);
    }

    @Override // sdk.pendo.io.r7.c
    public boolean b(View view, Rect windowBounds) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowBounds, "windowBounds");
        return super.b(view, windowBounds) || d(view) || sdk.pendo.io.d7.f.a(view) || e(view);
    }
}
