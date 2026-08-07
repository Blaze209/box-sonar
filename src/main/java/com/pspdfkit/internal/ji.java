package com.pspdfkit.internal;

import android.graphics.PointF;
import android.graphics.RectF;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.annotations.configuration.FreeTextAnnotationConfiguration;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.utils.EdgeInsets;
import com.pspdfkit.utils.ScaleMode;
import com.pspdfkit.utils.Size;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ji {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ScaleMode.values().length];
            try {
                iArr[ScaleMode.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScaleMode.EXPAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScaleMode.SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004b  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    public static final void a(FreeTextAnnotation freeTextAnnotation, AnnotationConfigurationRegistry annotationConfigurationRegistry, Size size, TextPaint textPaint, String str) {
        ScaleMode scaleMode;
        ScaleMode scaleMode2;
        freeTextAnnotation.getClass();
        annotationConfigurationRegistry.getClass();
        size.getClass();
        FreeTextAnnotationConfiguration freeTextAnnotationConfiguration = (FreeTextAnnotationConfiguration) annotationConfigurationRegistry.get(freeTextAnnotation.getType(), FreeTextAnnotationConfiguration.class);
        ScaleMode scaleMode3 = ScaleMode.FIXED;
        FreeTextAnnotation.FreeTextAnnotationIntent intent = freeTextAnnotation.getIntent();
        FreeTextAnnotation.FreeTextAnnotationIntent freeTextAnnotationIntent = FreeTextAnnotation.FreeTextAnnotationIntent.FREE_TEXT_CALLOUT;
        if (intent != freeTextAnnotationIntent) {
            if (freeTextAnnotationConfiguration != null) {
                ScaleMode scaleMode4 = freeTextAnnotationConfiguration.isHorizontalResizingEnabled() ? ScaleMode.SCALE : scaleMode3;
                if (freeTextAnnotationConfiguration.isVerticalResizingEnabled()) {
                    scaleMode3 = ScaleMode.SCALE;
                }
                scaleMode = scaleMode3;
                scaleMode2 = scaleMode4;
            }
            a(freeTextAnnotation, size, scaleMode2, scaleMode, textPaint, str);
            if (freeTextAnnotation.getIntent() == freeTextAnnotationIntent) {
                a(freeTextAnnotation, false);
            }
        }
        scaleMode3 = ScaleMode.SCALE;
        scaleMode2 = scaleMode3;
        scaleMode = scaleMode2;
        a(freeTextAnnotation, size, scaleMode2, scaleMode, textPaint, str);
        if (freeTextAnnotation.getIntent() == freeTextAnnotationIntent) {
            a(freeTextAnnotation, false);
        }
    }

    public static final void a(FreeTextAnnotation freeTextAnnotation, Size size, ScaleMode scaleMode, ScaleMode scaleMode2, TextPaint textPaint, String str) {
        float f;
        float fA;
        freeTextAnnotation.getClass();
        size.getClass();
        scaleMode.getClass();
        scaleMode2.getClass();
        ScaleMode scaleMode3 = ScaleMode.FIXED;
        if (scaleMode == scaleMode3 && scaleMode2 == scaleMode3) {
            return;
        }
        RectF boundingBox = freeTextAnnotation.getBoundingBox();
        boolean z = freeTextAnnotation.getRotation() == 90 || freeTextAnnotation.getRotation() == 270;
        float f2 = z ? size.height : size.width;
        EdgeInsets textInsets = freeTextAnnotation.getTextInsets();
        textInsets.getClass();
        if (z) {
            f = textInsets.left + textInsets.right;
            fA = a(freeTextAnnotation.getBorderWidth());
        } else {
            f = textInsets.top + textInsets.bottom;
            fA = a(freeTextAnnotation.getBorderWidth());
        }
        float f3 = (fA * 2) + f;
        Size sizeA = a(freeTextAnnotation, scaleMode == scaleMode3 ? boundingBox.width() - f3 : f2 - f3, textPaint, str);
        float fMax = sizeA.width;
        float fWidth = boundingBox.width();
        int[] iArr = a.a;
        int i = iArr[scaleMode.ordinal()];
        if (i == 1) {
            fMax = fWidth;
        } else if (i == 2) {
            fMax = Math.max(fMax, Math.abs(fWidth));
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        float fMin = Math.min(size.width, fMax);
        float fMax2 = sizeA.height;
        float fHeight = boundingBox.height();
        int i2 = iArr[scaleMode2.ordinal()];
        if (i2 == 1) {
            fMax2 = fHeight;
        } else if (i2 == 2) {
            fMax2 = Math.max(fMax2, Math.abs(fHeight));
        } else if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        float fMin2 = Math.min(size.height, fMax2);
        if (freeTextAnnotation.getIntent() == FreeTextAnnotation.FreeTextAnnotationIntent.FREE_TEXT_CALLOUT) {
            EdgeInsets textInsets2 = freeTextAnnotation.getTextInsets();
            textInsets2.getClass();
            boolean z2 = freeTextAnnotation.getRotation() == 90 || freeTextAnnotation.getRotation() == 270;
            float f4 = z2 ? fMin2 : fMin;
            if (!z2) {
                fMin = fMin2;
            }
            freeTextAnnotation.setBoundingBox(a(f4 + textInsets2.left + textInsets2.right, fMin + textInsets2.top + textInsets2.bottom, boundingBox, size));
            return;
        }
        freeTextAnnotation.setContentSize(new RectF(0.0f, fMin2, fMin, 0.0f), false);
        freeTextAnnotation.adjustBoundsForRotation();
        RectF boundingBox2 = freeTextAnnotation.getBoundingBox();
        RectF rectFA = a(boundingBox2.width(), boundingBox2.height(), boundingBox, size);
        float f5 = rectFA.left;
        if (f5 < 0.0f) {
            float f6 = -f5;
            rectFA.left = f5 + f6;
            rectFA.right += f6;
        }
        freeTextAnnotation.setBoundingBox(rectFA);
    }

    public static final RectF a(float f, float f2, RectF rectF, Size size) {
        float fAbs;
        float f3 = rectF.left;
        float f4 = f3 + f;
        if (f4 > size.width) {
            f4 = rectF.right;
            f3 = f4 - f;
        }
        float fAbs2 = 0.0f;
        if (rectF.top - Math.abs(f2) < 0.0f) {
            fAbs = Math.abs(f2);
        } else {
            fAbs = rectF.top;
            fAbs2 = fAbs - Math.abs(f2);
        }
        return new RectF(f3, fAbs, f4, fAbs2);
    }

    public static final Size a(FreeTextAnnotation freeTextAnnotation, float f, TextPaint textPaint, String str) {
        freeTextAnnotation.getClass();
        if (textPaint == null) {
            textPaint = new TextPaint();
            String fontName = freeTextAnnotation.getFontName();
            if (fontName != null) {
                e50 e50VarC = ar.c();
                e50VarC.getClass();
                Font fontByName = e50VarC.getFontByName(fontName);
                if (fontByName != null && fontByName.getDefaultTypeface() != null) {
                    textPaint.setTypeface(fontByName.getDefaultTypeface());
                } else {
                    textPaint.setTypeface(e50VarC.b().getDefaultTypeface());
                }
            }
            textPaint.setTextSize(freeTextAnnotation.getTextSize());
            textPaint.setAntiAlias(true);
        }
        if (str == null && (str = freeTextAnnotation.getContents()) == null) {
            str = "";
        }
        DynamicLayout dynamicLayoutA = a(freeTextAnnotation, str, textPaint, (int) f);
        dynamicLayoutA.getLineCount();
        float fAbs = (Math.abs(textPaint.getFontMetrics().top) + textPaint.getFontMetrics().bottom) * dynamicLayoutA.getLineCount();
        float lineRight = dynamicLayoutA.getLineRight(0) - dynamicLayoutA.getLineLeft(0);
        int lineCount = dynamicLayoutA.getLineCount();
        for (int i = 1; i < lineCount; i++) {
            lineRight = Math.max(lineRight, dynamicLayoutA.getLineRight(i) - dynamicLayoutA.getLineLeft(i));
        }
        float fA = a(freeTextAnnotation.getBorderWidth()) * 2.0f;
        return new Size(lineRight + fA + (freeTextAnnotation.getTextSize() * 0.1f), fAbs + fA);
    }

    public static final void a(FreeTextAnnotation freeTextAnnotation, boolean z) {
        if (freeTextAnnotation.getCallOutPoints().isEmpty()) {
            return;
        }
        List<PointF> callOutPoints = freeTextAnnotation.getCallOutPoints();
        callOutPoints.getClass();
        RectF rectF = new RectF();
        EdgeInsets textInsets = freeTextAnnotation.getTextInsets();
        textInsets.getClass();
        RectF boundingBox = freeTextAnnotation.getBoundingBox(rectF);
        RectF rectF2 = new RectF(boundingBox.left + textInsets.left, boundingBox.top - textInsets.top, boundingBox.right - textInsets.right, boundingBox.bottom + textInsets.bottom);
        PointF pointF = new PointF(rectF2.centerX(), rectF2.centerY());
        PointF pointF2 = callOutPoints.get(0);
        boolean z2 = callOutPoints.size() == 3;
        PointF pointF3 = z2 ? callOutPoints.get(1) : null;
        PointF pointF4 = z2 ? callOutPoints.get(2) : callOutPoints.get(1);
        pointF4.getClass();
        PointF pointF5 = pointF4;
        PointF pointF6 = (z2 && z && pointF3 != null) ? pointF3 : pointF2;
        double d = 360;
        double degrees = (Math.toDegrees(Math.atan2(pointF6.y - pointF.y, pointF6.x - pointF.x)) + d) % d;
        if (degrees > 45.0d && degrees <= 135.0d) {
            pointF5.set(pointF.x, rectF2.top);
            if (!z && pointF3 != null) {
                float f = pointF5.x;
                float f2 = pointF5.y;
                pointF3.set(f, f2 - ((f2 - pointF2.y) / 2));
            }
        } else if (degrees > 135.0d && degrees <= 225.0d) {
            pointF5.set(rectF2.left, pointF.y);
            if (!z && pointF3 != null) {
                float f3 = pointF5.x;
                pointF3.set(f3 - ((f3 - pointF2.x) / 2), pointF5.y);
            }
        } else if (degrees > 225.0d && degrees <= 315.0d) {
            pointF5.set(pointF.x, rectF2.bottom);
            if (!z && pointF3 != null) {
                float f4 = pointF5.x;
                float f5 = pointF5.y;
                pointF3.set(f4, f5 - ((f5 - pointF2.y) / 2));
            }
        } else {
            pointF5.set(rectF2.right, pointF.y);
            if (!z && pointF3 != null) {
                float f6 = pointF5.x;
                pointF3.set(f6 - ((f6 - pointF2.x) / 2), pointF5.y);
            }
        }
        float fMax = (Math.max(freeTextAnnotation.getBorderWidth(), 1.0f) * 1.5f) + 10;
        float fMax2 = Math.max(freeTextAnnotation.getBorderWidth(), 1.0f) * 1.5f;
        List listMutableListOf = CollectionsKt.mutableListOf(new Pair(pointF2, Float.valueOf(fMax)));
        if (pointF3 != null) {
            listMutableListOf.add(new Pair(pointF3, Float.valueOf(fMax2)));
        }
        Iterator it = listMutableListOf.iterator();
        if (it.hasNext()) {
            Pair pair = (Pair) it.next();
            float fFloatValue = ((PointF) pair.component1()).x - ((Number) pair.component2()).floatValue();
            while (it.hasNext()) {
                Pair pair2 = (Pair) it.next();
                fFloatValue = Math.min(fFloatValue, ((PointF) pair2.component1()).x - ((Number) pair2.component2()).floatValue());
            }
            Iterator it2 = listMutableListOf.iterator();
            if (it2.hasNext()) {
                Pair pair3 = (Pair) it2.next();
                float fFloatValue2 = ((PointF) pair3.component1()).x + ((Number) pair3.component2()).floatValue();
                while (it2.hasNext()) {
                    Pair pair4 = (Pair) it2.next();
                    fFloatValue2 = Math.max(fFloatValue2, ((PointF) pair4.component1()).x + ((Number) pair4.component2()).floatValue());
                }
                Iterator it3 = listMutableListOf.iterator();
                if (it3.hasNext()) {
                    Pair pair5 = (Pair) it3.next();
                    float fFloatValue3 = ((PointF) pair5.component1()).y - ((Number) pair5.component2()).floatValue();
                    while (it3.hasNext()) {
                        Pair pair6 = (Pair) it3.next();
                        fFloatValue3 = Math.min(fFloatValue3, ((PointF) pair6.component1()).y - ((Number) pair6.component2()).floatValue());
                    }
                    Iterator it4 = listMutableListOf.iterator();
                    if (it4.hasNext()) {
                        Pair pair7 = (Pair) it4.next();
                        float fFloatValue4 = ((PointF) pair7.component1()).y + ((Number) pair7.component2()).floatValue();
                        while (it4.hasNext()) {
                            Pair pair8 = (Pair) it4.next();
                            fFloatValue4 = Math.max(fFloatValue4, ((PointF) pair8.component1()).y + ((Number) pair8.component2()).floatValue());
                        }
                        float fMax3 = Math.max(rectF2.left - fFloatValue, 0.0f);
                        float fMax4 = Math.max(fFloatValue4 - rectF2.top, 0.0f);
                        float fMax5 = Math.max(fFloatValue2 - rectF2.right, 0.0f);
                        float fMax6 = Math.max(rectF2.bottom - fFloatValue3, 0.0f);
                        freeTextAnnotation.setBoundingBox(new RectF(rectF2.left - fMax3, rectF2.top + fMax4, rectF2.right + fMax5, rectF2.bottom - fMax6));
                        freeTextAnnotation.setTextInsets(new EdgeInsets(fMax4, fMax3, fMax6, fMax5));
                        freeTextAnnotation.setCallOutPoints(callOutPoints);
                        return;
                    }
                    throw new NoSuchElementException();
                }
                throw new NoSuchElementException();
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    public static final DynamicLayout a(FreeTextAnnotation freeTextAnnotation, CharSequence charSequence, TextPaint textPaint, int i) {
        freeTextAnnotation.getClass();
        textPaint.getClass();
        DynamicLayout dynamicLayoutBuild = DynamicLayout.Builder.obtain(charSequence, textPaint, Math.max(1, i)).setAlignment(Layout.Alignment.ALIGN_NORMAL).setTextDirection(TextDirectionHeuristics.LTR).setLineSpacing(0.0f, a(freeTextAnnotation)).setIncludePad(false).setUseLineSpacingFromFallbacks(true).setBreakStrategy(0).setHyphenationFrequency(1).setJustificationMode(0).setEllipsize(null).build();
        dynamicLayoutBuild.getClass();
        return dynamicLayoutBuild;
    }

    public static final Size a(FreeTextAnnotation freeTextAnnotation, RectF rectF) {
        freeTextAnnotation.getClass();
        RectF boundingBox = freeTextAnnotation.getBoundingBox(rectF);
        EdgeInsets textInsets = freeTextAnnotation.getTextInsets();
        textInsets.getClass();
        boundingBox.sort();
        return new Size(boundingBox.width() - (textInsets.left + textInsets.right), boundingBox.height() - (textInsets.top + textInsets.bottom));
    }

    public static final float a(float f) {
        return (f / 2) + (Math.max(f, 1.0f) * 1.5f);
    }

    public static final float a(Annotation annotation) {
        Float lineHeightFactor;
        annotation.getClass();
        NativeAnnotation nativeAnnotation = annotation.getInternal().getNativeAnnotation();
        if (nativeAnnotation == null || (lineHeightFactor = nativeAnnotation.getLineHeightFactor()) == null) {
            return 1.0f;
        }
        return lineHeightFactor.floatValue() * 0.86f;
    }
}
