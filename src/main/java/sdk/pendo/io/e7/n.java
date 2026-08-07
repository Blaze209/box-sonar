package sdk.pendo.io.e7;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Switch;
import androidx.core.view.GravityCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\b\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/e7/n;", "Lsdk/pendo/io/e7/h;", "Landroid/widget/Switch;", "Landroid/graphics/Bitmap;", "trackBitmap", "thumbBitmap", "", "gravity", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "id", "view", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class n implements h<Switch> {
    @Override // sdk.pendo.io.e7.h
    public v a(int id, Switch view, int zIndex, s privacyConfig) {
        s sVar;
        Switch r12;
        x xVarA;
        Drawable current;
        Drawable current2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Rect rectB = sdk.pendo.io.b7.j.a.b((View) view);
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.a;
        int i = id + 1;
        sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar, i, zIndex, new Rect(rectB), view, null, 16, null);
        cVarA.b(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
        cVarA.c(view.getGravity());
        CharSequence text = view.getText();
        Bitmap bitmapA = null;
        if (text == null || text.length() == 0) {
            sVar = privacyConfig;
            r12 = view;
            xVarA = null;
        } else {
            i = id + 2;
            sVar = privacyConfig;
            xVarA = aVar.a(i, zIndex, sVar, (Rect) null, view);
            r12 = view;
            cVarA.a(xVarA);
        }
        Drawable trackDrawable = r12.getTrackDrawable();
        Bitmap bitmapA2 = (trackDrawable == null || (current2 = trackDrawable.getCurrent()) == null) ? null : sdk.pendo.io.b7.f.a.a(current2, sVar.c(), "trackDrawable");
        Drawable thumbDrawable = r12.getThumbDrawable();
        if (thumbDrawable != null && (current = thumbDrawable.getCurrent()) != null) {
            bitmapA = sdk.pendo.io.b7.f.a.a(current, sVar.c(), "thumbDrawable");
        }
        if (bitmapA2 != null && bitmapA != null) {
            Bitmap bitmapA3 = a(bitmapA2, bitmapA, r12.isChecked() ? 8388613 : GravityCompat.START);
            sdk.pendo.io.j7.h hVarA = aVar.a(i + 1, zIndex, new Rect(0, 0, bitmapA3.getWidth(), bitmapA3.getHeight()), bitmapA3, "switchDrawable");
            hVarA.g(r12.getSwitchPadding());
            if (xVarA == null) {
                cVarA.b(GravityCompat.END);
            }
            cVarA.a(hVarA);
        }
        return cVarA;
    }

    private final Bitmap a(Bitmap trackBitmap, Bitmap thumbBitmap, int gravity) {
        int width = (int) (((double) trackBitmap.getWidth()) * 1.5d);
        int height = thumbBitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(trackBitmap, (width - trackBitmap.getWidth()) / 2.0f, (height - trackBitmap.getHeight()) / 2.0f, (Paint) null);
        canvas.drawBitmap(thumbBitmap, gravity == 8388613 ? width - thumbBitmap.getWidth() : 0.0f, (height - thumbBitmap.getHeight()) / 2.0f, (Paint) null);
        return bitmapCreateBitmap;
    }
}
