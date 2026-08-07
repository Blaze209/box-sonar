package sdk.pendo.io.e7;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e7/a;", "Lsdk/pendo/io/e7/h;", "Landroidx/appcompat/widget/AppCompatToggleButton;", "", "id", "view", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a implements h<AppCompatToggleButton> {
    @Override // sdk.pendo.io.e7.h
    public v a(int id, AppCompatToggleButton view, int zIndex, s privacyConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Rect rectB = sdk.pendo.io.b7.j.a.b((View) view);
        Drawable background = view.getBackground();
        Drawable drawable = null;
        Drawable current = background != null ? background.getCurrent() : null;
        InsetDrawable insetDrawable = current instanceof InsetDrawable ? (InsetDrawable) current : null;
        Drawable drawable2 = insetDrawable != null ? insetDrawable.getDrawable() : null;
        LayerDrawable layerDrawable = drawable2 instanceof LayerDrawable ? (LayerDrawable) drawable2 : null;
        if (layerDrawable != null) {
            Rect rect = new Rect();
            layerDrawable.getPadding(rect);
            rectB.left += rect.left;
            rectB.top += rect.top;
            rectB.right -= rect.right;
            rectB.bottom -= rect.bottom;
            if (layerDrawable.getNumberOfLayers() > 1) {
                drawable = layerDrawable.getDrawable(layerDrawable.getNumberOfLayers() - 1);
            }
        }
        Drawable drawable3 = drawable;
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.a;
        sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar, id + 1, zIndex, rectB, view, null, 16, null);
        x xVarA = aVar.a(id + 2, zIndex, privacyConfig, (Rect) null, view);
        xVarA.a(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
        cVarA.a(xVarA);
        if (drawable3 instanceof GradientDrawable) {
            Rect bounds = ((GradientDrawable) drawable3).getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            sdk.pendo.io.j7.c cVar = new sdk.pendo.io.j7.c(id + 3, zIndex, "ToggleDrawable");
            cVar.a(new sdk.pendo.io.j7.g(Integer.valueOf(rectB.bottom - bounds.top), sdk.pendo.io.j7.g.a.LENGTH));
            cVar.l(80);
            cVar.a(sdk.pendo.io.b7.c.a.a(drawable3));
            cVarA.a(cVar);
        }
        return cVarA;
    }
}
