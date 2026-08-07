package sdk.pendo.io.e7;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.GravityCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.materialswitch.MaterialSwitch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0011\u0010\u0012J<\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\u000b\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/e7/o;", "Lsdk/pendo/io/e7/h;", "Landroidx/appcompat/widget/SwitchCompat;", "view", "Landroid/graphics/Bitmap;", "trackBitmap", "thumbBitmap", "trackDecorationBitmap", "thumbIconBitmap", "", "gravity", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "id", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class o implements h<SwitchCompat> {
    @Override // sdk.pendo.io.e7.h
    public v a(int id, SwitchCompat view, int zIndex, s privacyConfig) {
        x xVarA;
        Bitmap bitmapA;
        Bitmap bitmapA2;
        Drawable current;
        Drawable current2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Rect rectB = sdk.pendo.io.b7.j.a.b((View) view);
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.a;
        int i = id + 1;
        sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar, i, zIndex, new Rect(rectB), view, null, 16, null);
        SwitchCompat switchCompat = view;
        cVarA.b(switchCompat.getPaddingStart(), switchCompat.getPaddingTop(), switchCompat.getPaddingEnd(), switchCompat.getPaddingBottom());
        cVarA.c(switchCompat.getGravity());
        CharSequence text = switchCompat.getText();
        if (text == null || text.length() == 0) {
            xVarA = null;
        } else {
            i = id + 2;
            xVarA = aVar.a(i, zIndex, privacyConfig, (Rect) null, switchCompat);
            switchCompat = switchCompat;
            cVarA.a(xVarA);
        }
        Drawable trackDrawable = switchCompat.getTrackDrawable();
        Bitmap bitmapA3 = (trackDrawable == null || (current2 = trackDrawable.getCurrent()) == null) ? null : sdk.pendo.io.b7.f.a.a(current2, privacyConfig.c(), "trackDrawable");
        Drawable thumbDrawable = switchCompat.getThumbDrawable();
        Bitmap bitmapA4 = (thumbDrawable == null || (current = thumbDrawable.getCurrent()) == null) ? null : sdk.pendo.io.b7.f.a.a(current, privacyConfig.c(), "thumbDrawable");
        if (switchCompat instanceof MaterialSwitch) {
            MaterialSwitch materialSwitch = (MaterialSwitch) switchCompat;
            Drawable trackDecorationDrawable = materialSwitch.getTrackDecorationDrawable();
            bitmapA = trackDecorationDrawable != null ? sdk.pendo.io.b7.f.a.a(trackDecorationDrawable, privacyConfig.c(), "trackDecorationDrawable") : null;
            Drawable thumbIconDrawable = materialSwitch.getThumbIconDrawable();
            bitmapA2 = thumbIconDrawable != null ? sdk.pendo.io.b7.f.a.a(thumbIconDrawable, privacyConfig.c(), "thumbIconDrawable") : null;
        } else {
            bitmapA = null;
            bitmapA2 = null;
        }
        if (bitmapA3 != null && bitmapA4 != null) {
            Bitmap bitmapA5 = a(switchCompat, bitmapA3, bitmapA4, bitmapA, bitmapA2, switchCompat.isChecked() ? 8388613 : 8388611);
            sdk.pendo.io.j7.h hVarA = aVar.a(i + 1, zIndex, new Rect(0, 0, bitmapA5.getWidth(), bitmapA5.getHeight()), bitmapA5, "SwitchCompatDrawable");
            hVarA.g(switchCompat.getCompoundDrawablePadding());
            if (xVarA == null) {
                cVarA.b(GravityCompat.END);
            }
            cVarA.a(hVarA);
        }
        return cVarA;
    }

    private final Bitmap a(SwitchCompat view, Bitmap trackBitmap, Bitmap thumbBitmap, Bitmap trackDecorationBitmap, Bitmap thumbIconBitmap, int gravity) {
        float width = trackBitmap.getWidth() * (view instanceof MaterialSwitch ? 1.0f : 1.5f);
        int height = thumbBitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float width2 = (width - trackBitmap.getWidth()) / 2.0f;
        float height2 = (height - trackBitmap.getHeight()) / 2.0f;
        canvas.drawBitmap(trackBitmap, width2, height2, (Paint) null);
        if (trackDecorationBitmap != null) {
            canvas.drawBitmap(trackDecorationBitmap, width2, height2, (Paint) null);
        }
        float width3 = gravity == 8388613 ? width - thumbBitmap.getWidth() : 0.0f;
        float height3 = (height - thumbBitmap.getHeight()) / 2.0f;
        canvas.drawBitmap(thumbBitmap, width3, height3, (Paint) null);
        if (thumbIconBitmap != null) {
            canvas.drawBitmap(thumbIconBitmap, width3 + ((thumbBitmap.getWidth() - thumbIconBitmap.getWidth()) / 2.0f), height3 + ((thumbBitmap.getHeight() - thumbIconBitmap.getHeight()) / 2.0f), (Paint) null);
        }
        return bitmapCreateBitmap;
    }
}
