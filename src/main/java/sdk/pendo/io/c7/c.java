package sdk.pendo.io.c7;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.b7.g;
import sdk.pendo.io.d7.d;
import sdk.pendo.io.h7.r;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\nH\u0002J \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u000eH\u0002J\f\u0010\t\u001a\u00020\u0010*\u00020\u000fH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/c7/c;", "", "Landroid/view/View;", "view", "Lsdk/pendo/io/h7/c;", "c", "b", "Landroid/graphics/drawable/Drawable;", "drawable", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/graphics/drawable/GradientDrawable;", "Lkotlin/Pair;", "", "", "Landroid/graphics/drawable/ShapeDrawable;", "Lcom/google/android/material/button/MaterialButton;", "", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class c {
    public static final c a = new c();

    private c() {
    }

    private final sdk.pendo.io.h7.c b(View view) {
        Iterator<Drawable> it = sdk.pendo.io.b7.c.a.b(view.getBackground()).iterator();
        sdk.pendo.io.h7.c cVar = null;
        while (it.hasNext()) {
            sdk.pendo.io.h7.c cVarA = a(view, it.next());
            if (cVarA != null) {
                cVar = cVar == null ? cVarA : new sdk.pendo.io.h7.c(Math.max(cVar.getTop(), cVarA.getTop()), Math.max(cVar.getRight(), cVarA.getRight()), Math.max(cVar.getCom.facebook.react.uimanager.ViewProps.BOTTOM java.lang.String(), cVarA.getCom.facebook.react.uimanager.ViewProps.BOTTOM java.lang.String()), Math.max(cVar.getLeft(), cVarA.getLeft()));
            }
        }
        return cVar;
    }

    private final sdk.pendo.io.h7.c c(View view) {
        if (view instanceof Chip) {
            float chipStrokeWidth = ((Chip) view).getChipStrokeWidth();
            if (chipStrokeWidth > 0.0f) {
                return new sdk.pendo.io.h7.c(chipStrokeWidth);
            }
            return null;
        }
        if (!(view instanceof MaterialButton)) {
            if (!(view instanceof MaterialCardView)) {
                return null;
            }
            float strokeWidth = ((MaterialCardView) view).getStrokeWidth();
            if (strokeWidth > 0.0f) {
                return new sdk.pendo.io.h7.c(strokeWidth);
            }
            return null;
        }
        MaterialButton materialButton = (MaterialButton) view;
        if (!a(materialButton)) {
            return null;
        }
        float strokeWidth2 = materialButton.getStrokeWidth();
        if (strokeWidth2 > 0.0f) {
            return new sdk.pendo.io.h7.c(strokeWidth2);
        }
        return null;
    }

    public final sdk.pendo.io.h7.c a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        sdk.pendo.io.h7.c cVarC = c(view);
        if (cVarC != null) {
            return cVarC;
        }
        Drawable background = view.getBackground();
        MaterialShapeDrawable materialShapeDrawable = background instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background : null;
        if (materialShapeDrawable != null) {
            float strokeWidth = materialShapeDrawable.getStrokeWidth();
            if (strokeWidth > 0.0f) {
                return new sdk.pendo.io.h7.c(strokeWidth);
            }
            return null;
        }
        if (r.a.b() != Pendo.PendoOptions.Framework.REACT_NATIVE) {
            return b(view);
        }
        d dVar = d.a;
        Float fB = dVar.b(view, sdk.pendo.io.d7.b.ALL);
        if (fB != null) {
            return new sdk.pendo.io.h7.c(fB.floatValue());
        }
        Float fB2 = dVar.b(view, sdk.pendo.io.d7.b.TOP);
        float fFloatValue = fB2 != null ? fB2.floatValue() : 0.0f;
        Float fB3 = dVar.b(view, sdk.pendo.io.d7.b.RIGHT);
        float fFloatValue2 = fB3 != null ? fB3.floatValue() : 0.0f;
        Float fB4 = dVar.b(view, sdk.pendo.io.d7.b.BOTTOM);
        float fFloatValue3 = fB4 != null ? fB4.floatValue() : 0.0f;
        Float fB5 = dVar.b(view, sdk.pendo.io.d7.b.LEFT);
        return new sdk.pendo.io.h7.c(fFloatValue, fFloatValue2, fFloatValue3, fB5 != null ? fB5.floatValue() : 0.0f);
    }

    private final sdk.pendo.io.h7.c a(View view, Drawable drawable) {
        if (drawable instanceof MaterialShapeDrawable) {
            float strokeWidth = ((MaterialShapeDrawable) drawable).getStrokeWidth();
            if (strokeWidth > 0.0f) {
                return new sdk.pendo.io.h7.c(strokeWidth);
            }
        } else if (drawable instanceof GradientDrawable) {
            Pair<Float, Integer> pairA = a(view, (GradientDrawable) drawable);
            Float first = pairA != null ? pairA.getFirst() : null;
            if (first != null && first.floatValue() > 0.0f) {
                return new sdk.pendo.io.h7.c(first.floatValue());
            }
        } else if (drawable instanceof ShapeDrawable) {
            Pair<Float, Integer> pairA2 = a((ShapeDrawable) drawable);
            Float first2 = pairA2 != null ? pairA2.getFirst() : null;
            if (first2 != null && first2.floatValue() > 0.0f) {
                return new sdk.pendo.io.h7.c(first2.floatValue());
            }
        }
        return null;
    }

    private final Pair<Float, Integer> a(View view, GradientDrawable drawable) {
        float fFloatValue;
        Integer numValueOf;
        try {
            Object constantState = drawable.getConstantState();
            if (constantState == null && (constantState = g.a.a(drawable, "mGradientState")) == null) {
                return null;
            }
            g gVar = g.a;
            Object objA = gVar.a(constantState, "mStrokeWidth");
            Integer num = objA instanceof Integer ? (Integer) objA : null;
            if (num != null) {
                fFloatValue = num.intValue();
            } else {
                Object objA2 = gVar.a(constantState, "mStrokeWidth");
                Float f = objA2 instanceof Float ? (Float) objA2 : null;
                fFloatValue = f != null ? f.floatValue() : 0.0f;
            }
            if (fFloatValue <= 0.0f) {
                return null;
            }
            Object objA3 = gVar.a(constantState, "mStrokeColor");
            if (objA3 instanceof ColorStateList) {
                numValueOf = Integer.valueOf(((ColorStateList) objA3).getColorForState(view.getDrawableState(), ((ColorStateList) objA3).getDefaultColor()));
            } else {
                numValueOf = objA3 instanceof Integer ? (Integer) objA3 : null;
            }
            return TuplesKt.to(Float.valueOf(fFloatValue), numValueOf);
        } catch (Throwable th) {
            try {
                Object objA4 = g.a.a(drawable, "mFillPaint");
                Paint paint = objA4 instanceof Paint ? (Paint) objA4 : null;
                float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
                Integer numValueOf2 = paint != null ? Integer.valueOf(paint.getColor()) : null;
                if ((paint != null ? paint.getStyle() : null) != Paint.Style.STROKE || strokeWidth <= 0.0f) {
                    return null;
                }
                return TuplesKt.to(Float.valueOf(strokeWidth), numValueOf2);
            } catch (Throwable unused) {
                PendoLogger.v("BorderWidthExtractor", "extractGradientStroke failed: " + th);
                return null;
            }
        }
    }

    private final Pair<Float, Integer> a(ShapeDrawable drawable) {
        Paint paint = drawable.getPaint();
        if (paint == null || paint.getStyle() != Paint.Style.STROKE) {
            return null;
        }
        float strokeWidth = paint.getStrokeWidth();
        if (strokeWidth <= 0.0f) {
            return null;
        }
        return TuplesKt.to(Float.valueOf(strokeWidth), Integer.valueOf(paint.getColor()));
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
}
