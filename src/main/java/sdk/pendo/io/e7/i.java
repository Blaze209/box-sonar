package sdk.pendo.io.e7;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.h7.r;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.x;
import sdk.pendo.io.j7.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u000b*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u000bB\u0007¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/e7/i;", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/e7/h;", "", "id", "view", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(ILandroid/view/View;ILsdk/pendo/io/h7/s;)Lsdk/pendo/io/j7/v;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class i<T extends View> implements h<T> {
    @Override // sdk.pendo.io.e7.h
    public v a(int id, T view, int zIndex, s privacyConfig) {
        v cVar;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Rect rectB = sdk.pendo.io.b7.j.a.b(view);
        if (view.getClass().getSimpleName().equals("View")) {
            sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.a;
            sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar, id + 1, zIndex, rectB, view, null, 16, null);
            Bitmap bitmapA = sdk.pendo.io.b7.f.a.a(view, privacyConfig.c(), "ViewBackground");
            if (bitmapA != null) {
                sdk.pendo.io.j7.h hVarA = aVar.a(id + 2, zIndex, (Rect) null, bitmapA, "ViewBackground");
                hVarA.a(new y(100, y.a.PERCENT));
                hVarA.a(new sdk.pendo.io.j7.g(100, sdk.pendo.io.j7.g.a.PERCENT));
                hVarA.a(new sdk.pendo.io.j7.o(sdk.pendo.io.j7.o.a.FILL));
                cVarA.a(hVarA);
            }
            return cVarA;
        }
        if (r.a.i()) {
            String simpleName = view.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            x xVar = new x(id + 1, zIndex, simpleName, null, 8, null);
            xVar.e(view.getClass().getSimpleName());
            xVar.e(Integer.valueOf(Math.min(40, view.getHeight())));
            xVar.n(17);
            cVar = xVar;
        } else {
            String simpleName2 = view.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
            cVar = new sdk.pendo.io.j7.c(id + 1, zIndex, simpleName2);
        }
        cVar.a(rectB);
        cVar.a((Integer) (-3355444));
        return cVar;
    }
}
