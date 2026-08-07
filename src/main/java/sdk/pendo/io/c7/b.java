package sdk.pendo.io.c7;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.b7.g;
import sdk.pendo.io.d7.d;
import sdk.pendo.io.h7.r;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\fH\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\b\u001a\u00020\u000e*\u00020\rH\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/c7/b;", "", "Landroid/view/View;", "view", "Lsdk/pendo/io/h7/b;", "b", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "shape", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/google/android/material/shape/MaterialShapeDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "Lcom/google/android/material/button/MaterialButton;", "", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b {
    public static final b a = new b();

    private b() {
    }

    private final sdk.pendo.io.h7.b b(View view) {
        Iterator<Drawable> it = sdk.pendo.io.b7.c.a.b(view.getBackground()).iterator();
        sdk.pendo.io.h7.b bVarA = null;
        while (it.hasNext()) {
            sdk.pendo.io.h7.b bVarA2 = a(view, it.next());
            if (bVarA2 != null) {
                bVarA = bVarA == null ? bVarA2 : a(bVarA, bVarA2);
            }
        }
        return bVarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final sdk.pendo.io.h7.b a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            if ((view instanceof MaterialButton) && !a((MaterialButton) view)) {
                return null;
            }
            Drawable background = view.getBackground();
            MaterialShapeDrawable materialShapeDrawable = background instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background : null;
            if (materialShapeDrawable != null) {
                return a.a(materialShapeDrawable);
            }
            if (r.a.b() == Pendo.PendoOptions.Framework.REACT_NATIVE) {
                d dVar = d.a;
                Float fB = dVar.b(view);
                return fB != null ? new sdk.pendo.io.h7.b(fB.floatValue()) : new sdk.pendo.io.h7.b(dVar.e(view), dVar.f(view), dVar.d(view), dVar.c(view));
            }
            sdk.pendo.io.h7.b bVarB = b(view);
            if (bVarB != null) {
                return bVarB;
            }
            if (view instanceof CardView) {
                return new sdk.pendo.io.h7.b(((CardView) view).getRadius(), ((CardView) view).getRadius(), ((CardView) view).getRadius(), ((CardView) view).getRadius());
            }
            if (!(view instanceof Shapeable)) {
                return null;
            }
            ShapeAppearanceModel shapeAppearanceModel = ((Shapeable) view).getShapeAppearanceModel();
            Intrinsics.checkNotNullExpressionValue(shapeAppearanceModel, "getShapeAppearanceModel(...)");
            return a(view, shapeAppearanceModel);
        } catch (Throwable th) {
            PendoLogger.v("BorderRadiusExtractor", "extract failed: " + th);
            return null;
        }
    }

    private final sdk.pendo.io.h7.b a(GradientDrawable drawable) {
        float[] cornerRadii = drawable.getCornerRadii();
        if (cornerRadii != null && cornerRadii.length >= 8) {
            return new sdk.pendo.io.h7.b(Math.max(cornerRadii[0], cornerRadii[1]), Math.max(cornerRadii[2], cornerRadii[3]), Math.max(cornerRadii[4], cornerRadii[5]), Math.max(cornerRadii[6], cornerRadii[7]));
        }
        float cornerRadius = drawable.getCornerRadius();
        if (cornerRadius > 0.0f) {
            return new sdk.pendo.io.h7.b(cornerRadius);
        }
        return null;
    }

    private final sdk.pendo.io.h7.b a(MaterialShapeDrawable drawable) {
        return new sdk.pendo.io.h7.b(drawable.getTopLeftCornerResolvedSize(), drawable.getTopRightCornerResolvedSize(), drawable.getBottomRightCornerResolvedSize(), drawable.getBottomLeftCornerResolvedSize());
    }

    private final sdk.pendo.io.h7.b a(View view, ShapeAppearanceModel shape) {
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        return new sdk.pendo.io.h7.b(shape.getTopLeftCornerSize().getCornerSize(rectF), shape.getTopRightCornerSize().getCornerSize(rectF), shape.getBottomRightCornerSize().getCornerSize(rectF), shape.getBottomLeftCornerSize().getCornerSize(rectF));
    }

    private final sdk.pendo.io.h7.b a(View view, Drawable drawable) {
        if (drawable instanceof MaterialShapeDrawable) {
            return a((MaterialShapeDrawable) drawable);
        }
        if (drawable instanceof GradientDrawable) {
            return a((GradientDrawable) drawable);
        }
        return null;
    }

    private final boolean a(MaterialButton materialButton) {
        try {
            g gVar = g.a;
            Object objA = gVar.a(gVar.a(MaterialButton.class, "isUsingOriginalBackground", new Class[0]), materialButton, new Object[0]);
            Boolean bool = objA instanceof Boolean ? (Boolean) objA : null;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private final sdk.pendo.io.h7.b a(sdk.pendo.io.h7.b a2, sdk.pendo.io.h7.b b) {
        return new sdk.pendo.io.h7.b(Math.max(a2.getTopLeft(), b.getTopLeft()), Math.max(a2.getTopRight(), b.getTopRight()), Math.max(a2.getBottomRight(), b.getBottomRight()), Math.max(a2.getBottomLeft(), b.getBottomLeft()));
    }
}
