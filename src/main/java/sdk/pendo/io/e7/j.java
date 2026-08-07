package sdk.pendo.io.e7;

import android.R;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e7/j;", "Lsdk/pendo/io/e7/h;", "Landroid/widget/ProgressBar;", "", "id", "view", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class j implements h<ProgressBar> {
    @Override // sdk.pendo.io.e7.h
    public v a(int id, ProgressBar view, int zIndex, s privacyConfig) {
        Drawable drawableFindDrawableByLayerId;
        Bitmap bitmapA;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Rect rectB = sdk.pendo.io.b7.j.a.b(view);
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.a;
        int i = id + 1;
        sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar, i, zIndex, new Rect(rectB), view, null, 16, null);
        cVarA.c(16);
        if (!(view instanceof RatingBar)) {
            Drawable progressDrawable = view.getProgressDrawable();
            LayerDrawable layerDrawable = progressDrawable instanceof LayerDrawable ? (LayerDrawable) progressDrawable : null;
            if (layerDrawable != null && (drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background)) != null && (bitmapA = sdk.pendo.io.b7.f.a.a(drawableFindDrawableByLayerId, privacyConfig.c(), "ProgressBarBackground")) != null) {
                i = id + 2;
                aVar.a(i, zIndex, new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight()), bitmapA, "ProgressBarBackground");
            }
        }
        sdk.pendo.io.b7.f fVar = sdk.pendo.io.b7.f.a;
        Drawable currentDrawable = view.getCurrentDrawable();
        Bitmap bitmapA2 = fVar.a(currentDrawable != null ? currentDrawable.getCurrent() : null, privacyConfig.c(), "ProgressBarDrawable");
        if (bitmapA2 != null) {
            sdk.pendo.io.j7.h hVarA = aVar.a(i + 1, zIndex, (Rect) null, bitmapA2, "ProgressBarDrawable");
            hVarA.a(new y(Integer.valueOf(bitmapA2.getWidth()), y.a.LENGTH));
            hVarA.a(new sdk.pendo.io.j7.g(Integer.valueOf(bitmapA2.getHeight()), sdk.pendo.io.j7.g.a.LENGTH));
            hVarA.a(new sdk.pendo.io.j7.o(sdk.pendo.io.j7.o.a.COVER));
            hVarA.a(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
            cVarA.a(hVarA);
        }
        return cVarA;
    }
}
