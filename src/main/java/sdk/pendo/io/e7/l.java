package sdk.pendo.io.e7;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.widget.SeekBar;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.u;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u0007\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/e7/l;", "Lsdk/pendo/io/e7/h;", "Landroid/widget/SeekBar;", "view", "", "trackWidth", "thumbWidth", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/widget/SeekBar;Ljava/lang/Integer;I)I", "id", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class l implements h<SeekBar> {
    @Override // sdk.pendo.io.e7.h
    public v a(int id, SeekBar view, int zIndex, s privacyConfig) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Rect rectB = sdk.pendo.io.b7.j.a.b(view);
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.a;
        int i = id + 1;
        sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar, i, zIndex, new Rect(rectB), view, null, 16, null);
        cVarA.c(16);
        sdk.pendo.io.b7.f fVar = sdk.pendo.io.b7.f.a;
        Bitmap bitmapA = fVar.a(view.getProgressDrawable().getCurrent(), privacyConfig.c(), "SeekbarTrack");
        if (bitmapA != null) {
            i = id + 2;
            sdk.pendo.io.j7.h hVarA = aVar.a(i, zIndex, (Rect) null, bitmapA, "SeekbarTrack");
            bitmap = bitmapA;
            hVarA.a(new y(Integer.valueOf(bitmap.getWidth()), y.a.LENGTH));
            hVarA.a(new sdk.pendo.io.j7.g(Integer.valueOf(bitmap.getHeight()), sdk.pendo.io.j7.g.a.LENGTH));
            hVarA.a(new sdk.pendo.io.j7.o(sdk.pendo.io.j7.o.a.COVER));
            hVarA.a(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
            cVarA.a(hVarA);
        } else {
            bitmap = bitmapA;
        }
        Bitmap bitmapA2 = fVar.a(view.getThumb().getCurrent(), privacyConfig.c(), "Seekbar");
        if (bitmapA2 != null) {
            sdk.pendo.io.j7.h hVarA2 = aVar.a(i + 1, zIndex, (Rect) null, bitmapA2, "Seekbar");
            hVarA2.a(new y(Integer.valueOf(bitmapA2.getWidth()), y.a.LENGTH));
            hVarA2.a(new sdk.pendo.io.j7.g(Integer.valueOf(bitmapA2.getHeight()), sdk.pendo.io.j7.g.a.LENGTH));
            hVarA2.a(new sdk.pendo.io.j7.o(sdk.pendo.io.j7.o.a.COVER));
            hVarA2.a(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
            hVarA2.c(Integer.valueOf(a(view, bitmap != null ? Integer.valueOf(bitmap.getWidth()) : null, bitmapA2.getWidth())));
            hVarA2.a(new u(u.a.ABSOLUTE));
            cVarA.a(hVarA2);
        }
        return cVarA;
    }

    private final int a(SeekBar view, Integer trackWidth, int thumbWidth) {
        float progress;
        try {
            progress = view.getProgress() / view.getMax();
        } catch (Exception unused) {
            progress = 1.0f;
        }
        if (trackWidth == null) {
            return 0;
        }
        return (trackWidth.intValue() * ((int) progress)) - (thumbWidth / 2);
    }
}
