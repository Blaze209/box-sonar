package sdk.pendo.io.f7;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b7.i;
import sdk.pendo.io.b7.j;
import sdk.pendo.io.c7.b;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.c;
import sdk.pendo.io.j7.f;
import sdk.pendo.io.j7.h;
import sdk.pendo.io.j7.u;
import sdk.pendo.io.j7.w;
import sdk.pendo.io.j7.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J9\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010\rJ9\u0010\f\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\f\u0010\u0014J;\u0010\f\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00152\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\f\u0010\u0017JC\u0010\f\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\f\u0010\u001e¨\u0006!"}, d2 = {"Lsdk/pendo/io/f7/a;", "", "", "id", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Landroid/graphics/Rect;", FirebaseAnalytics.Param.LOCATION, "Landroid/widget/TextView;", "view", "Lsdk/pendo/io/j7/x;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(IILsdk/pendo/io/h7/s;Landroid/graphics/Rect;Landroid/widget/TextView;)Lsdk/pendo/io/j7/x;", "locationOnScreen", "Landroid/graphics/Bitmap;", "bitmap", "", "elementName", "Lsdk/pendo/io/j7/h;", "(IILandroid/graphics/Rect;Landroid/graphics/Bitmap;Ljava/lang/String;)Lsdk/pendo/io/j7/h;", "Landroid/view/View;", "Lsdk/pendo/io/j7/c;", "(IILandroid/graphics/Rect;Landroid/view/View;Ljava/lang/String;)Lsdk/pendo/io/j7/c;", "nodeId", "width", "height", "backgroundColor", "", "backgroundColorOpacity", "(IIIIIF)Lsdk/pendo/io/j7/c;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final c a(int id, int zIndex, Rect locationOnScreen, View view, String elementName) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        c cVar = new c(id, zIndex, elementName);
        cVar.a(locationOnScreen);
        cVar.a(sdk.pendo.io.b7.a.a.a(view));
        cVar.a(sdk.pendo.io.c7.c.a.a(view));
        cVar.a(b.a.a(view));
        cVar.a(sdk.pendo.io.c7.a.a.a(view));
        cVar.b(Integer.valueOf((int) view.getElevation()));
        cVar.a(Float.valueOf(view.getAlpha()));
        return cVar;
    }

    public static /* synthetic */ c a(a aVar, int i, int i2, Rect rect, View view, String str, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str = view.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(str, "getSimpleName(...)");
        }
        return aVar.a(i, i2, rect, view, str);
    }

    public final h a(int id, int zIndex, Rect locationOnScreen, Bitmap bitmap, String elementName) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        h hVar = new h(id, zIndex, bitmap, elementName);
        hVar.a(locationOnScreen);
        hVar.a((u) null);
        return hVar;
    }

    public final x a(int id, int zIndex, s privacyConfig, Rect location, TextView view) {
        int i;
        Bitmap bitmapA;
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Intrinsics.checkNotNullParameter(view, "view");
        String simpleName = view.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        x xVar = new x(id, zIndex, simpleName, null, 8, null);
        i iVar = i.a;
        String strA = iVar.a(view, privacyConfig);
        if (strA == null) {
            strA = "";
        }
        if (iVar.a(strA) && (bitmapA = sdk.pendo.io.b7.b.a(view)) != null) {
            f fVar = new f(id, zIndex, bitmapA, "FontIcon");
            fVar.a(location);
            return fVar;
        }
        xVar.e(strA);
        float fA = (int) i.a(iVar, view, 0, 2, (Object) null);
        xVar.a((fA / Resources.getSystem().getDisplayMetrics().heightPixels) * 90.0f);
        xVar.d(iVar.c(view));
        xVar.a(iVar.d(view));
        xVar.a(iVar.e(view));
        xVar.d(Integer.valueOf(iVar.f(view)));
        xVar.b(Float.valueOf(view.getLetterSpacing() * fA));
        xVar.l(view.getGravity());
        xVar.k(view.getGravity());
        j jVar = j.a;
        xVar.f(jVar.b(view));
        w wVarA = jVar.a(view);
        xVar.a(wVarA);
        String value = wVarA.getValue();
        if (Intrinsics.areEqual(value, w.a.LEFT.getCss())) {
            i = 3;
        } else {
            if (!Intrinsics.areEqual(value, w.a.CENTER.getCss())) {
                if (Intrinsics.areEqual(value, w.a.RIGHT.getCss())) {
                    i = 5;
                }
                xVar.a("1");
                xVar.g(iVar.b(view));
                xVar.o(view.getLineHeight());
                xVar.f(Integer.valueOf(view.getLayout().getLineCount()));
                xVar.a(location);
                xVar.a((u) null);
                return xVar;
            }
            i = 17;
        }
        xVar.b(i);
        xVar.a("1");
        xVar.g(iVar.b(view));
        xVar.o(view.getLineHeight());
        xVar.f(Integer.valueOf(view.getLayout().getLineCount()));
        xVar.a(location);
        xVar.a((u) null);
        return xVar;
    }

    public final c a(int nodeId, int zIndex, int width, int height, int backgroundColor, float backgroundColorOpacity) {
        c cVar = new c(nodeId, zIndex, "touch_outside");
        cVar.a(new Rect(0, 0, width, height));
        cVar.a(Integer.valueOf(backgroundColor));
        cVar.a(Float.valueOf(backgroundColorOpacity));
        return cVar;
    }

    public static /* synthetic */ c a(a aVar, int i, int i2, int i3, int i4, int i5, float f, int i6, Object obj) {
        if ((i6 & 16) != 0) {
            i5 = -16777216;
        }
        int i7 = i5;
        if ((i6 & 32) != 0) {
            f = 0.5f;
        }
        return aVar.a(i, i2, i3, i4, i7, f);
    }
}
