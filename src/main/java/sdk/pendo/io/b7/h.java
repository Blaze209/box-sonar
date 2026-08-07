package sdk.pendo.io.b7;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.material.button.MaterialButton;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a \u0010\u0003\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002\u001a\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0003\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroid/view/View;", "view", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/view/View;)Ljava/lang/Integer;", "Lsdk/pendo/io/b7/e;", "options", "(Landroid/view/View;Lsdk/pendo/io/b7/e;)Ljava/lang/Integer;", "Landroid/graphics/Bitmap;", "bmp", "w", CmcdData.STREAMING_FORMAT_HLS, "", "c", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)Ljava/lang/Integer;", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class h {

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\n\u0010\u000fR\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u0014\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0011\u0010\u000fR\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019\"\u0004\b\n\u0010\u001a¨\u0006\u001e"}, d2 = {"sdk/pendo/io/b7/h$a", "", "", "toString", "", "hashCode", "other", "", "equals", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "D", "f", "()D", "e", "(D)V", "wSum", "b", "aSum", "c", "d", "rSum", "gSum", "bSum", "I", "()I", "(I)V", "n", "<init>", "(DDDDDI)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final /* data */ class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private double wSum;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private double aSum;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private double rSum;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private double gSum;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private double bSum;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private int n;

        public a(double d, double d2, double d3, double d4, double d5, int i) {
            this.wSum = d;
            this.aSum = d2;
            this.rSum = d3;
            this.gSum = d4;
            this.bSum = d5;
            this.n = i;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final double getASum() {
            return this.aSum;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final double getBSum() {
            return this.bSum;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final double getGSum() {
            return this.gSum;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final int getN() {
            return this.n;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final double getRSum() {
            return this.rSum;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return Double.compare(this.wSum, aVar.wSum) == 0 && Double.compare(this.aSum, aVar.aSum) == 0 && Double.compare(this.rSum, aVar.rSum) == 0 && Double.compare(this.gSum, aVar.gSum) == 0 && Double.compare(this.bSum, aVar.bSum) == 0 && this.n == aVar.n;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final double getWSum() {
            return this.wSum;
        }

        public int hashCode() {
            return (((((((((Double.hashCode(this.wSum) * 31) + Double.hashCode(this.aSum)) * 31) + Double.hashCode(this.rSum)) * 31) + Double.hashCode(this.gSum)) * 31) + Double.hashCode(this.bSum)) * 31) + Integer.hashCode(this.n);
        }

        public String toString() {
            return "Acc(wSum=" + this.wSum + ", aSum=" + this.aSum + ", rSum=" + this.rSum + ", gSum=" + this.gSum + ", bSum=" + this.bSum + ", n=" + this.n + ")";
        }

        public /* synthetic */ a(double d, double d2, double d3, double d4, double d5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0.0d : d, (i2 & 2) != 0 ? 0.0d : d2, (i2 & 4) != 0 ? 0.0d : d3, (i2 & 8) != 0 ? 0.0d : d4, (i2 & 16) != 0 ? 0.0d : d5, (i2 & 32) != 0 ? 0 : i);
        }

        public final void a(double d) {
            this.aSum = d;
        }

        public final void b(double d) {
            this.bSum = d;
        }

        public final void c(double d) {
            this.gSum = d;
        }

        public final void d(double d) {
            this.rSum = d;
        }

        public final void e(double d) {
            this.wSum = d;
        }

        public final void a(int i) {
            this.n = i;
        }
    }

    private static final float[] a(Bitmap bitmap, int i, int i2) {
        float[] fArr = new float[i * i2];
        if (i >= 3 && i2 >= 3) {
            int i3 = i2 - 1;
            for (int i4 = 1; i4 < i3; i4++) {
                int i5 = i - 1;
                int i6 = 1;
                while (i6 < i5) {
                    int i7 = i6 - 1;
                    int i8 = i4 - 1;
                    int iB = b(bitmap, i7, i8);
                    int iB2 = b(bitmap, i6, i8);
                    int i9 = i6 + 1;
                    int iB3 = b(bitmap, i9, i8);
                    int iB4 = b(bitmap, i7, i4);
                    int iB5 = b(bitmap, i9, i4);
                    int i10 = i4 + 1;
                    int iB6 = b(bitmap, i7, i10);
                    int iB7 = b(bitmap, i6, i10);
                    int iB8 = b(bitmap, i9, i10);
                    int i11 = -iB;
                    fArr[(i4 * i) + i6] = Math.abs(i11 + iB3 + (iB4 * (-2)) + (iB5 * 2) + (-iB6) + iB8) + Math.abs(i11 + (iB2 * (-2)) + (-iB3) + iB6 + (iB7 * 2) + iB8);
                    i6 = i9;
                }
            }
        }
        return fArr;
    }

    private static final int b(Bitmap bitmap, int i, int i2) {
        return a(bitmap.getPixel(i, i2));
    }

    private static final Integer a(Drawable drawable) {
        int defaultColor;
        if (!(drawable instanceof ColorDrawable)) {
            if (drawable instanceof GradientDrawable) {
                ColorStateList color = ((GradientDrawable) drawable).getColor();
                if (color != null) {
                    defaultColor = color.getDefaultColor();
                }
            } else if (drawable instanceof RippleDrawable) {
                try {
                    return a(((RippleDrawable) drawable).getDrawable(0));
                } catch (Throwable unused) {
                    return null;
                }
            }
            try {
                Class<?> cls = Class.forName("com.google.android.material.shape.MaterialShapeDrawable");
                if (cls.isInstance(drawable)) {
                    Object objInvoke = cls.getMethod("getFillColor", new Class[0]).invoke(drawable, new Object[0]);
                    ColorStateList colorStateList = objInvoke instanceof ColorStateList ? (ColorStateList) objInvoke : null;
                    if (colorStateList != null) {
                        return Integer.valueOf(colorStateList.getDefaultColor());
                    }
                }
            } catch (Throwable unused2) {
            }
            return null;
        }
        defaultColor = ((ColorDrawable) drawable).getColor();
        return Integer.valueOf(defaultColor);
    }

    private static final int a(int i) {
        return RangesKt.coerceIn(MathKt.roundToInt((((double) Color.red(i)) * 0.2126d) + (((double) Color.green(i)) * 0.7152d) + (((double) Color.blue(i)) * 0.0722d)), 0, 255);
    }

    public static final Integer a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return a(view, new e(0, 0.0f, 0.0d, 0, 0.0d, false, false, false, false, false, 0.0f, 2047, null));
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0331 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:113:0x0332 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x0128  */
    /* JADX WARN: Code duplicated, block: B:51:0x012d  */
    /* JADX WARN: Code duplicated, block: B:60:0x0179  */
    /* JADX WARN: Code duplicated, block: B:61:0x0198  */
    /* JADX WARN: Code duplicated, block: B:68:0x0229  */
    /* JADX WARN: Code duplicated, block: B:70:0x022f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x0230 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:72:0x0231  */
    /* JADX WARN: Code duplicated, block: B:74:0x023f  */
    /* JADX WARN: Code duplicated, block: B:75:0x0242  */
    /* JADX WARN: Code duplicated, block: B:78:0x024d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0271  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Integer a(View view, e eVar) {
        Integer numValueOf;
        TextView textView;
        HashMap map;
        Integer num;
        double gamma;
        int i;
        Integer num2;
        Integer num3;
        Iterator it;
        Object next;
        double wSum;
        Object next2;
        double wSum2;
        Map.Entry entry;
        a aVar;
        int iArgb;
        int i2;
        int pixel;
        int iAlpha;
        Integer numValueOf2;
        Object obj;
        Integer numA;
        int iIntValue;
        Integer numA2;
        Intrinsics.checkNotNullParameter(view, "view");
        e options = eVar;
        Intrinsics.checkNotNullParameter(options, "options");
        int width = view.getWidth();
        int height = view.getHeight();
        Integer num4 = 0;
        if (width <= 0 || height <= 0) {
            if (eVar.getReturnTransparentWhenNoSignal()) {
                return num4;
            }
            return null;
        }
        if (!options.getExcludeImageViewContent() || !(view instanceof ImageView)) {
            if (!options.getEnableFastBackgroundPath() || (numA = a(view.getBackground())) == null) {
                float targetSize = options.getTargetSize();
                float f = width;
                float f2 = height;
                float fCoerceAtMost = RangesKt.coerceAtMost(Math.min(targetSize / f, targetSize / f2), 1.0f);
                boolean z = true;
                int iMax = Math.max(1, (int) (f * fCoerceAtMost));
                int iMax2 = Math.max(1, (int) (f2 * fCoerceAtMost));
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                int iSave = canvas.save();
                canvas.scale(fCoerceAtMost, fCoerceAtMost, 0.0f, 0.0f);
                try {
                    view.draw(canvas);
                    canvas.restoreToCount(iSave);
                    float[] fArrA = options.getSuppressEdges() ? a(bitmapCreateBitmap, iMax, iMax2) : null;
                    int iCoerceAtMost = RangesKt.coerceAtMost(Math.max(1, (int) (iMax * options.getBorderFraction())), iMax - 1);
                    int iCoerceAtMost2 = RangesKt.coerceAtMost(Math.max(1, (int) (iMax2 * options.getBorderFraction())), iMax2 - 1);
                    int iCoerceAtLeast = RangesKt.coerceAtLeast(iMax - iCoerceAtMost, iCoerceAtMost + 1);
                    int iCoerceAtLeast2 = RangesKt.coerceAtLeast(iMax2 - iCoerceAtMost2, iCoerceAtMost2 + 1);
                    if (view instanceof MaterialButton) {
                        textView = (MaterialButton) view;
                    } else {
                        if (view instanceof TextView) {
                            textView = (TextView) view;
                        } else {
                            numValueOf = null;
                        }
                        map = new HashMap(64);
                        int alphaIgnoreBelow = options.getAlphaIgnoreBelow();
                        num = null;
                        gamma = options.getGamma();
                        i = 0;
                        while (iCoerceAtMost2 < iCoerceAtLeast2) {
                            boolean z2 = z;
                            i2 = iCoerceAtMost;
                            while (i2 < iCoerceAtLeast) {
                                Integer num5 = num;
                                pixel = bitmapCreateBitmap.getPixel(i2, iCoerceAtMost2);
                                int i3 = iMax;
                                iAlpha = Color.alpha(pixel);
                                if ((fArrA != null || fArrA[(iCoerceAtMost2 * i3) + i2] <= options.getEdgeThreshold()) && iAlpha >= alphaIgnoreBelow && !a(pixel, numValueOf)) {
                                    int iRed = Color.red(pixel);
                                    int iGreen = Color.green(pixel);
                                    int iBlue = Color.blue(pixel);
                                    numValueOf2 = Integer.valueOf(((iRed >> 3) << 10) | ((iGreen >> 3) << 5) | (iBlue >> 3));
                                    obj = map.get(numValueOf2);
                                    if (obj == null) {
                                        a aVar2 = new a(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, 63, null);
                                        map.put(numValueOf2, aVar2);
                                        obj = aVar2;
                                    }
                                    a aVar3 = (a) obj;
                                    double d = iAlpha;
                                    double dPow = Math.pow(d / 255.0d, gamma);
                                    aVar3.e(aVar3.getWSum() + dPow);
                                    aVar3.a(aVar3.getASum() + d);
                                    aVar3.d(aVar3.getRSum() + (((double) iRed) * dPow));
                                    aVar3.c(aVar3.getGSum() + (((double) iGreen) * dPow));
                                    aVar3.b(aVar3.getBSum() + (((double) iBlue) * dPow));
                                    aVar3.a(aVar3.getN() + 1);
                                    i++;
                                } else {
                                    num4 = num4;
                                }
                                i2++;
                                num = num5;
                                options = eVar;
                                iMax = i3;
                                numValueOf = numValueOf;
                                fArrA = fArrA;
                                iCoerceAtLeast2 = iCoerceAtLeast2;
                                num4 = num4;
                                gamma = gamma;
                            }
                            iCoerceAtMost2++;
                            options = eVar;
                            z = z2;
                        }
                        num2 = num4;
                        num3 = num;
                        bitmapCreateBitmap.recycle();
                        if (i == 0) {
                            if (eVar.getReturnTransparentWhenNoSignal()) {
                                return num2;
                            }
                            return num3;
                        }
                        it = map.entrySet().iterator();
                        if (it.hasNext()) {
                            next = it.next();
                            if (it.hasNext()) {
                                wSum = ((a) ((Map.Entry) next).getValue()).getWSum();
                                do {
                                    next2 = it.next();
                                    wSum2 = ((a) ((Map.Entry) next2).getValue()).getWSum();
                                    if (Double.compare(wSum, wSum2) < 0) {
                                        next = next2;
                                        wSum = wSum2;
                                    }
                                } while (it.hasNext());
                            }
                        } else {
                            next = num3;
                        }
                        entry = (Map.Entry) next;
                        if (entry != null || (aVar = (a) entry.getValue()) == null) {
                            if (eVar.getReturnTransparentWhenNoSignal()) {
                                return num2;
                            }
                            return num3;
                        }
                        Collection collectionValues = map.values();
                        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
                        Iterator it2 = collectionValues.iterator();
                        double wSum3 = 0.0d;
                        while (it2.hasNext()) {
                            wSum3 += ((a) it2.next()).getWSum();
                        }
                        double wSum4 = aVar.getWSum();
                        Double dValueOf = Double.valueOf(wSum3);
                        double dDoubleValue = dValueOf.doubleValue();
                        Double d2 = dValueOf;
                        if (dDoubleValue <= 0.0d) {
                            d2 = num3;
                        }
                        if (wSum4 / (d2 != 0 ? d2.doubleValue() : 1.0d) < eVar.getMinCoverage()) {
                            return eVar.getReturnTransparentWhenNoSignal() ? num2 : num3;
                        }
                        iArgb = Color.argb(eVar.getPreserveAlphaInResult() ? RangesKt.coerceIn(MathKt.roundToInt(aVar.getASum() / ((double) aVar.getN())), 0, 255) : 255, RangesKt.coerceIn(MathKt.roundToInt(aVar.getRSum() / aVar.getWSum()), 0, 255), RangesKt.coerceIn(MathKt.roundToInt(aVar.getGSum() / aVar.getWSum()), 0, 255), RangesKt.coerceIn(MathKt.roundToInt(aVar.getBSum() / aVar.getWSum()), 0, 255));
                    }
                    numValueOf = Integer.valueOf(textView.getCurrentTextColor());
                    map = new HashMap(64);
                    int alphaIgnoreBelow2 = options.getAlphaIgnoreBelow();
                    num = null;
                    gamma = options.getGamma();
                    i = 0;
                    while (iCoerceAtMost2 < iCoerceAtLeast2) {
                        boolean z3 = z;
                        i2 = iCoerceAtMost;
                        while (i2 < iCoerceAtLeast) {
                            Integer num6 = num;
                            pixel = bitmapCreateBitmap.getPixel(i2, iCoerceAtMost2);
                            int i4 = iMax;
                            iAlpha = Color.alpha(pixel);
                            if (fArrA != null) {
                                int iRed2 = Color.red(pixel);
                                int iGreen2 = Color.green(pixel);
                                int iBlue2 = Color.blue(pixel);
                                numValueOf2 = Integer.valueOf(((iRed2 >> 3) << 10) | ((iGreen2 >> 3) << 5) | (iBlue2 >> 3));
                                obj = map.get(numValueOf2);
                                if (obj == null) {
                                    a aVar4 = new a(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, 63, null);
                                    map.put(numValueOf2, aVar4);
                                    obj = aVar4;
                                }
                                a aVar5 = (a) obj;
                                double d3 = iAlpha;
                                double dPow2 = Math.pow(d3 / 255.0d, gamma);
                                aVar5.e(aVar5.getWSum() + dPow2);
                                aVar5.a(aVar5.getASum() + d3);
                                aVar5.d(aVar5.getRSum() + (((double) iRed2) * dPow2));
                                aVar5.c(aVar5.getGSum() + (((double) iGreen2) * dPow2));
                                aVar5.b(aVar5.getBSum() + (((double) iBlue2) * dPow2));
                                aVar5.a(aVar5.getN() + 1);
                                i++;
                            } else {
                                int iRed3 = Color.red(pixel);
                                int iGreen3 = Color.green(pixel);
                                int iBlue3 = Color.blue(pixel);
                                numValueOf2 = Integer.valueOf(((iRed3 >> 3) << 10) | ((iGreen3 >> 3) << 5) | (iBlue3 >> 3));
                                obj = map.get(numValueOf2);
                                if (obj == null) {
                                    a aVar6 = new a(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, 63, null);
                                    map.put(numValueOf2, aVar6);
                                    obj = aVar6;
                                }
                                a aVar7 = (a) obj;
                                double d4 = iAlpha;
                                double dPow3 = Math.pow(d4 / 255.0d, gamma);
                                aVar7.e(aVar7.getWSum() + dPow3);
                                aVar7.a(aVar7.getASum() + d4);
                                aVar7.d(aVar7.getRSum() + (((double) iRed3) * dPow3));
                                aVar7.c(aVar7.getGSum() + (((double) iGreen3) * dPow3));
                                aVar7.b(aVar7.getBSum() + (((double) iBlue3) * dPow3));
                                aVar7.a(aVar7.getN() + 1);
                                i++;
                            }
                            i2++;
                            num = num6;
                            options = eVar;
                            iMax = i4;
                            numValueOf = numValueOf;
                            fArrA = fArrA;
                            iCoerceAtLeast2 = iCoerceAtLeast2;
                            num4 = num4;
                            gamma = gamma;
                        }
                        iCoerceAtMost2++;
                        options = eVar;
                        z = z3;
                    }
                    num2 = num4;
                    num3 = num;
                    bitmapCreateBitmap.recycle();
                    if (i == 0) {
                        if (eVar.getReturnTransparentWhenNoSignal()) {
                            return num2;
                        }
                        return num3;
                    }
                    it = map.entrySet().iterator();
                    if (it.hasNext()) {
                        next = num3;
                    } else {
                        next = it.next();
                        if (it.hasNext()) {
                            wSum = ((a) ((Map.Entry) next).getValue()).getWSum();
                            do {
                                next2 = it.next();
                                wSum2 = ((a) ((Map.Entry) next2).getValue()).getWSum();
                                if (Double.compare(wSum, wSum2) < 0) {
                                    next = next2;
                                    wSum = wSum2;
                                }
                            } while (it.hasNext());
                        }
                    }
                    entry = (Map.Entry) next;
                    if (entry != null) {
                    }
                    if (eVar.getReturnTransparentWhenNoSignal()) {
                        return num2;
                    }
                    return num3;
                } catch (Throwable th) {
                    canvas.restoreToCount(iSave);
                    throw th;
                }
            }
            iIntValue = numA.intValue();
            if (options.getPreserveAlphaInResult()) {
                return Integer.valueOf(iIntValue);
            }
            return Integer.valueOf(iArgb);
        }
        if (!options.getEnableFastBackgroundPath() || (numA2 = a(((ImageView) view).getBackground())) == null) {
            if (options.getReturnTransparentWhenNoSignal()) {
                return num4;
            }
            return null;
        }
        iIntValue = numA2.intValue();
        if (options.getPreserveAlphaInResult()) {
            return Integer.valueOf(iIntValue);
        }
        iArgb = (iIntValue & ViewCompat.MEASURED_SIZE_MASK) | (-16777216);
        return Integer.valueOf(iArgb);
    }

    private static final boolean a(int i, Integer num) {
        if (num == null) {
            return false;
        }
        double dRed = Color.red(i) - Color.red(num.intValue());
        double dGreen = Color.green(i) - Color.green(num.intValue());
        double dBlue = Color.blue(i) - Color.blue(num.intValue());
        return ((dRed * dRed) + (dGreen * dGreen)) + (dBlue * dBlue) < 576.0d;
    }
}
