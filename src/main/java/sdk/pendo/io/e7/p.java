package sdk.pendo.io.e7;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e7/p;", "Lsdk/pendo/io/e7/h;", "Landroid/widget/TextView;", "", "id", "view", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class p implements h<TextView> {
    /* JADX WARN: Type inference failed for: r12v4, types: [T, java.lang.Object, sdk.pendo.io.j7.h, sdk.pendo.io.j7.v] */
    /* JADX WARN: Type inference failed for: r12v6, types: [T, java.lang.Object, sdk.pendo.io.j7.h, sdk.pendo.io.j7.v] */
    @Override // sdk.pendo.io.e7.h
    public v a(int id, TextView view, int zIndex, s privacyConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Rect rectB = sdk.pendo.io.b7.j.a.b((View) view);
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.a;
        int i = id + 1;
        sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar, i, zIndex, rectB, view, null, 16, null);
        cVarA.b(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        sdk.pendo.io.b7.f fVar = sdk.pendo.io.b7.f.a;
        Bitmap bitmapA = fVar.a(view.getCompoundDrawables()[0], privacyConfig.c(), "CheckedTextViewStartDrawable");
        if (bitmapA != null) {
            int i2 = id + 2;
            ?? A = aVar.a(i2, zIndex, (Rect) null, bitmapA, "CheckedTextViewStartDrawable");
            A.a(new y(Integer.valueOf(bitmapA.getWidth()), y.a.LENGTH));
            A.a(new sdk.pendo.io.j7.g(Integer.valueOf(bitmapA.getHeight()), sdk.pendo.io.j7.g.a.LENGTH));
            A.a(new sdk.pendo.io.j7.o(sdk.pendo.io.j7.o.a.COVER));
            A.l(16);
            A.f(view.getCompoundDrawablePadding());
            objectRef.element = A;
            Intrinsics.checkNotNull(A);
            cVarA.a((v) A);
            i = i2;
        }
        cVarA.a(aVar.a(i + 1, zIndex, privacyConfig, (Rect) null, view));
        Bitmap bitmapA2 = fVar.a(view.getCompoundDrawables()[2], privacyConfig.c(), "CheckedTextViewEndDrawable");
        if (bitmapA2 != null) {
            ?? A2 = aVar.a(i + 2, zIndex, (Rect) null, bitmapA2, "CheckedTextViewEndDrawable");
            A2.a(new y(Integer.valueOf(bitmapA2.getWidth()), y.a.LENGTH));
            A2.a(new sdk.pendo.io.j7.g(Integer.valueOf(bitmapA2.getHeight()), sdk.pendo.io.j7.g.a.LENGTH));
            A2.a(new sdk.pendo.io.j7.o(sdk.pendo.io.j7.o.a.COVER));
            A2.l(16);
            A2.g(view.getCompoundDrawablePadding());
            objectRef2.element = A2;
            Intrinsics.checkNotNull(A2);
            cVarA.a((v) A2);
        }
        return cVarA;
    }
}
