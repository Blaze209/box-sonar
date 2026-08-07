package sdk.pendo.io.e7;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e7/f;", "Lsdk/pendo/io/e7/h;", "Lcom/google/android/material/button/MaterialButton;", "", "id", "view", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class f implements h<MaterialButton> {
    /* JADX WARN: Code duplicated, block: B:35:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:68:0x0169  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [T, sdk.pendo.io.j7.h, sdk.pendo.io.j7.v] */
    @Override // sdk.pendo.io.e7.h
    public v a(int id, MaterialButton view, int zIndex, s privacyConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Rect rectB = sdk.pendo.io.b7.j.a.b((View) view);
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.a;
        int i = id + 1;
        sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar, i, zIndex, rectB, view, null, 16, null);
        cVarA.b(view.getPaddingStart(), view.getPaddingTop() - view.getInsetTop(), view.getPaddingEnd(), view.getPaddingBottom() - view.getInsetBottom());
        cVarA.c(view.getGravity());
        Bitmap bitmapA = sdk.pendo.io.b7.f.a.a(view.getIcon(), privacyConfig.c(), "MaterialButtonIcon");
        if (bitmapA != null) {
            int i2 = id + 2;
            ?? A = aVar.a(i2, zIndex, new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight()), bitmapA, "MaterialButtonIcon");
            A.l(16);
            objectRef.element = A;
            i = i2;
        }
        CharSequence text = view.getText();
        boolean z = text == null || text.length() == 0;
        x xVarA = !z ? aVar.a(i + 1, zIndex, privacyConfig, (Rect) null, view) : null;
        if (objectRef.element != 0) {
            int iconGravity = view.getIconGravity();
            if (iconGravity == 16) {
                sdk.pendo.io.j7.h hVar = (sdk.pendo.io.j7.h) objectRef.element;
                if (hVar != null) {
                    hVar.e(view.getIconPadding());
                }
                T t = objectRef.element;
                Intrinsics.checkNotNull(t);
                cVarA.a((v) t);
                if (xVarA != null) {
                    cVarA.a(xVarA);
                }
            } else if (iconGravity == 32) {
                sdk.pendo.io.j7.h hVar2 = (sdk.pendo.io.j7.h) objectRef.element;
                if (hVar2 != null) {
                    hVar2.e(view.getIconPadding());
                }
                T t2 = objectRef.element;
                Intrinsics.checkNotNull(t2);
                cVarA.a((v) t2);
                if (xVarA != null) {
                    cVarA.a(xVarA);
                }
            } else {
                if (iconGravity != 1) {
                    if (iconGravity != 2) {
                        if (iconGravity == 3) {
                            sdk.pendo.io.j7.h hVar3 = (sdk.pendo.io.j7.h) objectRef.element;
                            if (hVar3 != null) {
                                hVar3.g(view.getIconPadding());
                            }
                            if (xVarA != null) {
                                cVarA.a(xVarA);
                            }
                        } else if (iconGravity == 4) {
                            sdk.pendo.io.j7.h hVar4 = (sdk.pendo.io.j7.h) objectRef.element;
                            if (hVar4 != null) {
                                hVar4.g(view.getIconPadding());
                            }
                            if (xVarA != null) {
                                cVarA.a(xVarA);
                            }
                        }
                        T t3 = objectRef.element;
                        Intrinsics.checkNotNull(t3);
                        cVarA.a((v) t3);
                        return cVarA;
                    }
                    if (z) {
                        sdk.pendo.io.j7.h hVar5 = (sdk.pendo.io.j7.h) objectRef.element;
                        if (hVar5 != null) {
                            hVar5.k(1);
                        }
                        cVarA.b(17);
                        T t4 = objectRef.element;
                        Intrinsics.checkNotNull(t4);
                        cVarA.a((v) t4);
                        return cVarA;
                    }
                    sdk.pendo.io.j7.h hVar6 = (sdk.pendo.io.j7.h) objectRef.element;
                    if (hVar6 != null) {
                        hVar6.f(view.getIconPadding());
                    }
                    T t5 = objectRef.element;
                    Intrinsics.checkNotNull(t5);
                    cVarA.a((v) t5);
                    Intrinsics.checkNotNull(xVarA);
                    cVarA.a(xVarA);
                    return cVarA;
                }
                sdk.pendo.io.j7.h hVar7 = (sdk.pendo.io.j7.h) objectRef.element;
                if (hVar7 != null) {
                    hVar7.f(view.getIconPadding());
                }
                T t6 = objectRef.element;
                Intrinsics.checkNotNull(t6);
                cVarA.a((v) t6);
                if (xVarA != null) {
                    cVarA.a(xVarA);
                }
            }
        } else if (xVarA != null) {
            cVarA.a(xVarA);
        }
        return cVarA;
    }
}
