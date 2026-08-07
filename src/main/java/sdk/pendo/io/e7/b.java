package sdk.pendo.io.e7;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.checkbox.MaterialCheckBox;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.u;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e7/b;", "Lsdk/pendo/io/e7/h;", "Landroid/widget/CheckBox;", "", "id", "view", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b implements h<CheckBox> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v18, types: [T, sdk.pendo.io.j7.c, sdk.pendo.io.j7.v] */
    /* JADX WARN: Type inference failed for: r3v13, types: [T, sdk.pendo.io.j7.c, sdk.pendo.io.j7.v] */
    @Override // sdk.pendo.io.e7.h
    public v a(int id, CheckBox view, int zIndex, s privacyConfig) {
        Ref.ObjectRef objectRef;
        sdk.pendo.io.f7.a aVar;
        int paddingEnd;
        Drawable buttonIconDrawable;
        Bitmap bitmapA;
        Bitmap bitmapA2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        boolean z = view.getLayoutDirection() == 1;
        Rect rectB = sdk.pendo.io.b7.j.a.b((View) view);
        sdk.pendo.io.f7.a aVar2 = sdk.pendo.io.f7.a.a;
        int i = id + 1;
        sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar2, i, zIndex, rectB, view, null, 16, null);
        cVarA.c(view.getGravity());
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Drawable drawableA = sdk.pendo.io.b7.c.a.a(view);
        if (drawableA != null && (bitmapA2 = sdk.pendo.io.b7.f.a.a(drawableA.getCurrent(), privacyConfig.c(), "CheckBoxDrawable")) != null) {
            ?? cVar = new sdk.pendo.io.j7.c(id + 2, zIndex, "CheckBoxGraphicContainer");
            cVar.a(new u(u.a.RELATIVE));
            cVar.a(new Rect(0, 0, bitmapA2.getWidth(), bitmapA2.getHeight()));
            objectRef2.element = cVar;
            i = id + 3;
            sdk.pendo.io.j7.h hVarA = aVar2.a(i, zIndex, new Rect(0, 0, bitmapA2.getWidth(), bitmapA2.getHeight()), bitmapA2, "CheckBoxDrawable");
            hVarA.a(new u(u.a.ABSOLUTE));
            sdk.pendo.io.j7.c cVar2 = (sdk.pendo.io.j7.c) objectRef2.element;
            if (cVar2 != null) {
                cVar2.a(hVarA);
            }
        }
        if (!(view instanceof MaterialCheckBox) || (buttonIconDrawable = ((MaterialCheckBox) view).getButtonIconDrawable()) == null || (bitmapA = sdk.pendo.io.b7.f.a.a(buttonIconDrawable.getCurrent(), privacyConfig.c(), "CheckBoxIconDrawable")) == null) {
            objectRef = objectRef2;
            aVar = aVar2;
        } else {
            if (objectRef2.element == 0) {
                i++;
                ?? cVar3 = new sdk.pendo.io.j7.c(i, zIndex, "CheckBoxGraphicContainer");
                cVar3.a(new u(u.a.RELATIVE));
                cVar3.a(new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight()));
                objectRef2.element = cVar3;
            }
            int i2 = i + 1;
            objectRef = objectRef2;
            aVar = aVar2;
            sdk.pendo.io.j7.h hVarA2 = aVar.a(i2, zIndex + 1, new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight()), bitmapA, "CheckBoxIconDrawable");
            hVarA2.a(new u(u.a.ABSOLUTE));
            sdk.pendo.io.j7.c cVar4 = (sdk.pendo.io.j7.c) objectRef.element;
            if (cVar4 != null) {
                cVar4.a(hVarA2);
            }
            i = i2;
        }
        CharSequence text = view.getText();
        if (text == null || text.length() == 0) {
            sdk.pendo.io.j7.c cVar5 = (sdk.pendo.io.j7.c) objectRef.element;
            if (cVar5 != null) {
                cVarA.a(cVar5);
            }
            cVarA.b(1);
            return cVarA;
        }
        x xVarA = aVar.a(i + 1, zIndex, privacyConfig, (Rect) null, view);
        if (z) {
            xVarA.g(view.getPaddingEnd());
            paddingEnd = view.getPaddingStart();
        } else {
            xVarA.g(view.getPaddingStart());
            paddingEnd = view.getPaddingEnd();
        }
        xVarA.f(paddingEnd);
        if (z) {
            cVarA.a(xVarA);
            sdk.pendo.io.j7.c cVar6 = (sdk.pendo.io.j7.c) objectRef.element;
            if (cVar6 != null) {
                cVarA.a(cVar6);
            }
            return cVarA;
        }
        sdk.pendo.io.j7.c cVar7 = (sdk.pendo.io.j7.c) objectRef.element;
        if (cVar7 != null) {
            cVarA.a(cVar7);
        }
        cVarA.a(xVarA);
        return cVarA;
    }
}
