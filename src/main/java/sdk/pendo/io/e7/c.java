package sdk.pendo.io.e7;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e7/c;", "Lsdk/pendo/io/e7/h;", "Lcom/google/android/material/chip/Chip;", "", "id", "view", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class c implements h<Chip> {
    @Override // sdk.pendo.io.e7.h
    public v a(int id, Chip view, int zIndex, s privacyConfig) {
        Drawable closeIcon;
        Bitmap bitmapA;
        Drawable chipIcon;
        Bitmap bitmapA2;
        Drawable checkedIcon;
        Bitmap bitmapA3;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Rect rectB = sdk.pendo.io.b7.j.a.b((View) view);
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.a;
        int i = id + 1;
        sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar, i, zIndex, rectB, view, null, 16, null);
        cVarA.j((int) view.getChipStartPadding());
        cVarA.i((int) view.getChipEndPadding());
        cVarA.c(16);
        boolean z = view.isChecked() && view.isCheckedIconVisible();
        boolean z2 = view.getChipIcon() != null && view.isChipIconVisible();
        boolean z3 = view.getCloseIcon() != null && view.isCloseIconVisible();
        if (z) {
            Drawable chipDrawable = view.getChipDrawable();
            ChipDrawable chipDrawable2 = chipDrawable instanceof ChipDrawable ? (ChipDrawable) chipDrawable : null;
            if (chipDrawable2 != null && (checkedIcon = chipDrawable2.getCheckedIcon()) != null && (bitmapA3 = sdk.pendo.io.b7.f.a.a(checkedIcon, privacyConfig.c(), "ChipCheckedIcon")) != null) {
                int i2 = id + 2;
                cVarA.a(aVar.a(i2, zIndex, new Rect(0, 0, bitmapA3.getWidth(), bitmapA3.getHeight()), bitmapA3, "ChipCheckedIcon"));
                i = i2;
            }
        }
        if (z2 && (chipIcon = view.getChipIcon()) != null && (bitmapA2 = sdk.pendo.io.b7.f.a.a(chipIcon, privacyConfig.c(), "ChipIcon")) != null) {
            int i3 = i + 1;
            sdk.pendo.io.j7.h hVarA = aVar.a(i3, zIndex, new Rect(0, 0, bitmapA2.getWidth(), bitmapA2.getHeight()), bitmapA2, "ChipIcon");
            hVarA.g((int) view.getIconStartPadding());
            hVarA.f((int) view.getIconEndPadding());
            cVarA.a(hVarA);
            i = i3;
        }
        x xVarA = aVar.a(i + 1, zIndex, privacyConfig, (Rect) null, view);
        xVarA.g((int) view.getTextStartPadding());
        xVarA.f((int) view.getTextEndPadding());
        cVarA.a(xVarA);
        if (z3 && (closeIcon = view.getCloseIcon()) != null && (bitmapA = sdk.pendo.io.b7.f.a.a(closeIcon, privacyConfig.c(), "ChipCloseIcon")) != null) {
            sdk.pendo.io.j7.h hVarA2 = aVar.a(i + 2, zIndex, new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight()), bitmapA, "ChipCloseIcon");
            hVarA2.g((int) view.getCloseIconStartPadding());
            hVarA2.f((int) view.getCloseIconEndPadding());
            cVarA.a(hVarA2);
        }
        return cVarA;
    }
}
