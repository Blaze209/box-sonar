package sdk.pendo.io.r7;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.SieveCacheKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u001f\u0010\b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\b\u0010\fJ\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\b\t\u0010\u000f¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/r7/b;", "Lsdk/pendo/io/r7/c;", "Landroid/view/View;", "view", "", "d", "e", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "", "currentZIndex", "(ILandroid/view/View;)I", "Landroid/graphics/Rect;", "windowBounds", "(Landroid/view/View;Landroid/graphics/Rect;)Z", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b extends c {
    private final boolean d(View view) {
        String name = view.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.contains$default((CharSequence) name, (CharSequence) ".PlatformGraphicsView", false, 2, (Object) null);
    }

    private final boolean e(View view) {
        String name = view.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.contains$default((CharSequence) name, (CharSequence) ".ShellFlyoutLayout", false, 2, (Object) null);
    }

    @Override // sdk.pendo.io.r7.c
    public int a(int currentZIndex, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return e(view) ? currentZIndex + 3 : a(super.a(currentZIndex, view), (long) view.getZ());
    }

    @Override // sdk.pendo.io.r7.c
    public boolean b(View view, Rect windowBounds) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowBounds, "windowBounds");
        return super.b(view, windowBounds) || d(view);
    }

    private final int a(long a, long b) {
        return (int) RangesKt.coerceIn(a + b, SieveCacheKt.NodeMetaAndPreviousMask, SieveCacheKt.NodeLinkMask);
    }
}
