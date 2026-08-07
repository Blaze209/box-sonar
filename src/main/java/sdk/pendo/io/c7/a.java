package sdk.pendo.io.c7;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\nH\u0002J \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u000eH\u0002J\f\u0010\t\u001a\u00020\u0010*\u00020\u000fH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/c7/a;", "", "Landroid/view/View;", "view", "Lsdk/pendo/io/h7/a;", "c", "b", "Landroid/graphics/drawable/Drawable;", "drawable", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/graphics/drawable/GradientDrawable;", "Lkotlin/Pair;", "", "", "Landroid/graphics/drawable/ShapeDrawable;", "Lcom/google/android/material/button/MaterialButton;", "", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {
    public static final a a = new a();

    private a() {
    }

    private final sdk.pendo.io.h7.a b(View view) {
        Iterator<Drawable> it = sdk.pendo.io.b7.c.a.b(view.getBackground()).iterator();
        sdk.pendo.io.h7.a aVar = null;
        while (it.hasNext()) {
            sdk.pendo.io.h7.a aVarA = a(view, it.next());
            if (aVarA != null) {
                aVar = aVarA;
            }
        }
        return aVar;
    }

    private final sdk.pendo.io.h7.a c(View view) {
        if (view instanceof Chip) {
            ColorStateList chipStrokeColor = ((Chip) view).getChipStrokeColor();
            Integer numValueOf = chipStrokeColor != null ? Integer.valueOf(chipStrokeColor.getDefaultColor()) : null;
            if (numValueOf != null) {
                return new sdk.pendo.io.h7.a(numValueOf.intValue());
            }
        } else if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            if (a(materialButton)) {
                ColorStateList strokeColor = materialButton.getStrokeColor();
                Integer numValueOf2 = strokeColor != null ? Integer.valueOf(strokeColor.getDefaultColor()) : null;
                if (numValueOf2 != null) {
                    return new sdk.pendo.io.h7.a(numValueOf2.intValue());
                }
            }
        } else if (view instanceof MaterialCardView) {
            ColorStateList strokeColorStateList = ((MaterialCardView) view).getStrokeColorStateList();
            Integer numValueOf3 = strokeColorStateList != null ? Integer.valueOf(strokeColorStateList.getDefaultColor()) : null;
            if (numValueOf3 != null) {
                return new sdk.pendo.io.h7.a(numValueOf3.intValue());
            }
        }
        return null;
    }

    public final sdk.pendo.io.h7.a a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        sdk.pendo.io.h7.a aVarC = c(view);
        if (aVarC != null) {
            return aVarC;
        }
        Drawable background = view.getBackground();
        MaterialShapeDrawable materialShapeDrawable = background instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background : null;
        if (materialShapeDrawable != null) {
            ColorStateList strokeColor = materialShapeDrawable.getStrokeColor();
            Integer numValueOf = strokeColor != null ? Integer.valueOf(strokeColor.getDefaultColor()) : null;
            if (numValueOf != null) {
                return new sdk.pendo.io.h7.a(numValueOf.intValue());
            }
            return null;
        }
        if (r.a.b() != Pendo.PendoOptions.Framework.REACT_NATIVE) {
            return b(view);
        }
        d dVar = d.a;
        Integer numA = dVar.a(view, sdk.pendo.io.d7.b.ALL);
        int iIntValue = numA != null ? numA.intValue() : 0;
        if (iIntValue != 0 && iIntValue != -16777216) {
            return new sdk.pendo.io.h7.a(iIntValue);
        }
        Integer numA2 = dVar.a(view, sdk.pendo.io.d7.b.TOP);
        int iIntValue2 = numA2 != null ? numA2.intValue() : 0;
        Integer numA3 = dVar.a(view, sdk.pendo.io.d7.b.RIGHT);
        int iIntValue3 = numA3 != null ? numA3.intValue() : 0;
        Integer numA4 = dVar.a(view, sdk.pendo.io.d7.b.BOTTOM);
        int iIntValue4 = numA4 != null ? numA4.intValue() : 0;
        Integer numA5 = dVar.a(view, sdk.pendo.io.d7.b.LEFT);
        return new sdk.pendo.io.h7.a(iIntValue2, iIntValue3, iIntValue4, numA5 != null ? numA5.intValue() : 0);
    }

    private final sdk.pendo.io.h7.a a(View view, Drawable drawable) {
        if (drawable instanceof MaterialShapeDrawable) {
            ColorStateList strokeColor = ((MaterialShapeDrawable) drawable).getStrokeColor();
            Integer numValueOf = strokeColor != null ? Integer.valueOf(strokeColor.getDefaultColor()) : null;
            if (numValueOf != null) {
                return new sdk.pendo.io.h7.a(numValueOf.intValue());
            }
        } else if (drawable instanceof GradientDrawable) {
            Pair<Float, Integer> pairA = a(view, (GradientDrawable) drawable);
            Integer second = pairA != null ? pairA.getSecond() : null;
            if (second != null) {
                return new sdk.pendo.io.h7.a(second.intValue());
            }
        } else if (drawable instanceof ShapeDrawable) {
            Pair<Float, Integer> pairA2 = a((ShapeDrawable) drawable);
            Integer second2 = pairA2 != null ? pairA2.getSecond() : null;
            if (second2 != null) {
                return new sdk.pendo.io.h7.a(second2.intValue());
            }
        } else if (!(drawable instanceof ColorDrawable) && (drawable instanceof RippleDrawable)) {
            RippleDrawable rippleDrawable = (RippleDrawable) drawable;
            Drawable drawable2 = rippleDrawable.getDrawable(0);
            if (drawable2 == null) {
                drawable2 = rippleDrawable.findDrawableByLayerId(R.id.mask);
            }
            if (drawable2 != null) {
                return a(view, drawable2);
            }
        }
        return null;
    }

    private final Pair<Float, Integer> a(View view, GradientDrawable drawable) {
        try {
            g gVar = g.a;
            Object objA = gVar.a(drawable, "mStrokePaint");
            Paint paint = objA instanceof Paint ? (Paint) objA : null;
            Float fValueOf = paint != null ? Float.valueOf(paint.getStrokeWidth()) : null;
            Integer numValueOf = paint != null ? Integer.valueOf(paint.getColor()) : null;
            Object constantState = drawable.getConstantState();
            if (constantState == null && (constantState = gVar.a(drawable, "mGradientState")) == null) {
                return null;
            }
            if (fValueOf == null || fValueOf.floatValue() <= 0.0f) {
                Object objA2 = gVar.a(constantState, "mStrokeWidth");
                Integer num = objA2 instanceof Integer ? (Integer) objA2 : null;
                fValueOf = Float.valueOf(num != null ? num.intValue() : -1);
            }
            if (fValueOf.floatValue() <= 0.0f) {
                return null;
            }
            if (numValueOf == null || numValueOf.intValue() == 0) {
                Object objA3 = gVar.a(constantState, "mStrokeColors");
                ColorStateList colorStateList = objA3 instanceof ColorStateList ? (ColorStateList) objA3 : null;
                numValueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(view.getDrawableState(), colorStateList.getDefaultColor())) : null;
            }
            return TuplesKt.to(fValueOf, numValueOf);
        } catch (Exception unused) {
            return null;
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
