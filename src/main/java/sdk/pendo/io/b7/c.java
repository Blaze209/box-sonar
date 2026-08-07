package sdk.pendo.io.b7;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.widget.CompoundButton;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/b7/c;", "", "Landroid/widget/CompoundButton;", "view", "Landroid/graphics/drawable/Drawable;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/widget/CompoundButton;)Landroid/graphics/drawable/Drawable;", "drawable", "", "(Landroid/graphics/drawable/Drawable;)Ljava/lang/Integer;", "", "d", "(Landroid/graphics/drawable/Drawable;)Z", "", "b", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class c {
    public static final c a = new c();

    private c() {
    }

    private static final Drawable c(Drawable drawable) {
        Object objM14780constructorimpl;
        Object objM14780constructorimpl2;
        Object objM14780constructorimpl3;
        Object objM14780constructorimpl4;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(drawable.getClass().getMethod("getWrappedDrawable", new Class[0]));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m14786isFailureimpl(objM14780constructorimpl)) {
            objM14780constructorimpl = null;
        }
        Method method = (Method) objM14780constructorimpl;
        if (method != null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Object objInvoke = method.invoke(drawable, new Object[0]);
                objM14780constructorimpl4 = Result.m14780constructorimpl(objInvoke instanceof Drawable ? (Drawable) objInvoke : null);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM14780constructorimpl4 = Result.m14780constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m14786isFailureimpl(objM14780constructorimpl4)) {
                objM14780constructorimpl4 = null;
            }
            Drawable drawable2 = (Drawable) objM14780constructorimpl4;
            if (drawable2 != null) {
                return drawable2;
            }
        }
        try {
            Result.Companion companion5 = Result.INSTANCE;
            Field declaredField = drawable.getClass().getDeclaredField("mDrawable");
            declaredField.setAccessible(true);
            objM14780constructorimpl2 = Result.m14780constructorimpl(declaredField);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.INSTANCE;
            objM14780constructorimpl2 = Result.m14780constructorimpl(ResultKt.createFailure(th3));
        }
        if (Result.m14786isFailureimpl(objM14780constructorimpl2)) {
            objM14780constructorimpl2 = null;
        }
        Field field = (Field) objM14780constructorimpl2;
        if (field != null) {
            try {
                Result.Companion companion7 = Result.INSTANCE;
                Object obj = field.get(drawable);
                objM14780constructorimpl3 = Result.m14780constructorimpl(obj instanceof Drawable ? (Drawable) obj : null);
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM14780constructorimpl3 = Result.m14780constructorimpl(ResultKt.createFailure(th4));
            }
            if (Result.m14786isFailureimpl(objM14780constructorimpl3)) {
                objM14780constructorimpl3 = null;
            }
            Drawable drawable3 = (Drawable) objM14780constructorimpl3;
            if (drawable3 != null) {
                return drawable3;
            }
        }
        return null;
    }

    public final Drawable a(CompoundButton view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.getButtonDrawable();
    }

    public final List<Drawable> b(Drawable drawable) {
        if (drawable == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(4);
        a(arrayList, drawable);
        return arrayList;
    }

    public final boolean d(Drawable drawable) {
        if (drawable == null) {
            return false;
        }
        List<Drawable> listB = b(drawable);
        if (!(listB instanceof Collection) || !listB.isEmpty()) {
            for (Drawable drawable2 : listB) {
                if (((drawable2 instanceof BitmapDrawable) && ((BitmapDrawable) drawable2).getBitmap() != null) || (drawable2 instanceof NinePatchDrawable)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Integer a(Drawable drawable) {
        int color;
        if (drawable == null) {
            return null;
        }
        for (Drawable drawable2 : b(drawable)) {
            if (drawable2 instanceof ColorDrawable) {
                color = ((ColorDrawable) drawable2).getColor();
            } else if (drawable2 instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) drawable2;
                ColorStateList color2 = gradientDrawable.getColor();
                if (color2 != null) {
                    color = color2.getDefaultColor();
                } else {
                    int[] colors = gradientDrawable.getColors();
                    if (colors == null) {
                        continue;
                    } else if (!(colors.length == 0)) {
                        color = colors[colors.length / 2];
                    }
                }
            } else if (drawable2 instanceof ChipDrawable) {
                color = ((ChipDrawable) drawable2).getResolvedTintColor();
            } else if (drawable2 instanceof MaterialShapeDrawable) {
                color = ((MaterialShapeDrawable) drawable2).getResolvedTintColor();
            } else if (drawable2 instanceof ShapeDrawable) {
                Paint paint = ((ShapeDrawable) drawable2).getPaint();
                if (paint.getStyle() == Paint.Style.FILL) {
                    color = paint.getColor();
                }
            } else {
                continue;
            }
            return Integer.valueOf(color);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        if (r0 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        if (r0 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
    
        if (r0 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008b, code lost:
    
        if (r0 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a0, code lost:
    
        if (r0 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c5, code lost:
    
        if (r0 != r7) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c7, code lost:
    
        a(r6, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ca, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void a(java.util.ArrayList<android.graphics.drawable.Drawable> r6, android.graphics.drawable.Drawable r7) {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.b7.c.a(java.util.ArrayList, android.graphics.drawable.Drawable):void");
    }
}
