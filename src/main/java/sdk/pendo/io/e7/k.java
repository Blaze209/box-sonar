package sdk.pendo.io.e7;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RadioButton;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e7/k;", "Lsdk/pendo/io/e7/h;", "Landroid/widget/RadioButton;", "", "id", "view", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class k implements h<RadioButton> {
    @Override // sdk.pendo.io.e7.h
    public v a(int id, RadioButton view, int zIndex, s privacyConfig) {
        int paddingEnd;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        boolean z = view.getLayoutDirection() == 1;
        Rect rectB = sdk.pendo.io.b7.j.a.b((View) view);
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.a;
        int i = id + 1;
        sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar, i, zIndex, new Rect(rectB), view, null, 16, null);
        cVarA.c(view.getGravity());
        sdk.pendo.io.b7.f fVar = sdk.pendo.io.b7.f.a;
        Drawable drawableA = sdk.pendo.io.b7.c.a.a(view);
        sdk.pendo.io.j7.h hVarA = null;
        Bitmap bitmapA = fVar.a(drawableA != null ? drawableA.getCurrent() : null, privacyConfig.c(), "RadioButtonDrawable");
        if (bitmapA != null) {
            i = id + 2;
            hVarA = aVar.a(i, zIndex, new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight()), bitmapA, "RadioButtonDrawable");
        }
        sdk.pendo.io.j7.h hVar = hVarA;
        x xVarA = aVar.a(i + 1, zIndex, privacyConfig, (Rect) null, view);
        if (z) {
            xVarA.g(view.getPaddingEnd());
            paddingEnd = view.getPaddingStart();
        } else {
            xVarA.g(view.getPaddingStart());
            paddingEnd = view.getPaddingEnd();
        }
        xVarA.f(paddingEnd);
        xVarA.h(view.getPaddingTop());
        xVarA.e(view.getPaddingBottom());
        if (z) {
            cVarA.a(xVarA);
            if (hVar != null) {
                cVarA.a(hVar);
            }
            return cVarA;
        }
        if (hVar != null) {
            cVarA.a(hVar);
        }
        cVarA.a(xVarA);
        return cVarA;
    }
}
