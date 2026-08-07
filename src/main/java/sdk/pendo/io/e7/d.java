package sdk.pendo.io.e7;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.u;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/e7/d;", "Lsdk/pendo/io/e7/h;", "Landroid/widget/EditText;", "editText", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "id", "view", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class d implements h<EditText> {
    @Override // sdk.pendo.io.e7.h
    public v a(int id, EditText view, int zIndex, s privacyConfig) {
        sdk.pendo.io.f7.a aVar;
        CharSequence hint;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Rect rectB = sdk.pendo.io.b7.j.a.b((View) view);
        sdk.pendo.io.f7.a aVar2 = sdk.pendo.io.f7.a.a;
        int i = id + 1;
        TextInputLayout textInputLayout = null;
        sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar2, i, zIndex, rectB, view, null, 16, null);
        Drawable background = view.getBackground();
        if (background != null) {
            Bitmap bitmapA = sdk.pendo.io.b7.f.a.a(background.getCurrent(), false, "EditTextUnderLine");
            int i2 = id + 2;
            Intrinsics.checkNotNull(bitmapA);
            aVar = aVar2;
            sdk.pendo.io.j7.h hVarA = aVar.a(i2, zIndex, new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight()), bitmapA, "EditTextUnderLine");
            hVarA.l(80);
            hVarA.a(new u(u.a.ABSOLUTE));
            cVarA.a(hVarA);
            cVarA.a((sdk.pendo.io.h7.c) null);
            cVarA.a((sdk.pendo.io.h7.a) null);
            cVarA.a((Integer) null);
            i = i2;
        } else {
            aVar = aVar2;
        }
        x xVarA = aVar.a(i + 1, zIndex, privacyConfig, rectB, view);
        xVarA.g(view.getCompoundPaddingLeft());
        xVarA.f(view.getCompoundPaddingRight());
        Editable text = view.getText();
        boolean z = text == null || StringsKt.isBlank(text);
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent != null ? parent.getParent() : null;
        if (parent instanceof TextInputLayout) {
            textInputLayout = (TextInputLayout) parent;
        } else if (parent2 instanceof TextInputLayout) {
            textInputLayout = (TextInputLayout) parent2;
        }
        if (z && textInputLayout != null && (hint = textInputLayout.getHint()) != null) {
            Intrinsics.checkNotNull(hint);
            if ((!StringsKt.isBlank(hint)) && view.isFocused()) {
                xVarA.d(Integer.valueOf(view.getHighlightColor()));
                xVarA.a((a(view) / Resources.getSystem().getDisplayMetrics().heightPixels) * 100.0f);
                xVarA.l(48);
                xVarA.c(48);
                xVarA.b(3);
                xVarA.h(0);
            }
        }
        cVarA.a(xVarA);
        return cVarA;
    }

    private final int a(EditText editText) {
        float textSize = editText.getTextSize();
        float f = editText.getContext().getResources().getDisplayMetrics().density;
        return RangesKt.coerceIn((int) (textSize * 0.75f), (int) (12 * f), (int) (16 * f));
    }
}
