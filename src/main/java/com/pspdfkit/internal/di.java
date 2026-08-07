package com.pspdfkit.internal;

import com.pspdfkit.annotations.measurements.MeasurementMode;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.annotations.measurements.SecondaryMeasurementUnit;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class di {
    public static final DecimalFormat a;
    public static final DecimalFormat b;
    public static final DecimalFormat c;
    public static final DecimalFormat d;
    public static final DecimalFormat e;
    public static final Map<String, String> f;

    static {
        DecimalFormat decimalFormat = new DecimalFormat("#");
        a = decimalFormat;
        DecimalFormat decimalFormat2 = new DecimalFormat("#.#");
        b = decimalFormat2;
        DecimalFormat decimalFormat3 = new DecimalFormat("#.##");
        c = decimalFormat3;
        DecimalFormat decimalFormat4 = new DecimalFormat("#.###");
        d = decimalFormat4;
        DecimalFormat decimalFormat5 = new DecimalFormat("#.####");
        e = decimalFormat5;
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        decimalFormat.setRoundingMode(roundingMode);
        decimalFormat2.setRoundingMode(roundingMode);
        decimalFormat3.setRoundingMode(roundingMode);
        decimalFormat4.setRoundingMode(roundingMode);
        decimalFormat5.setRoundingMode(roundingMode);
        f = MapsKt.mapOf(TuplesKt.to("1/2", "½"), TuplesKt.to("1/4", "¼"), TuplesKt.to("3/4", "¾"), TuplesKt.to("1/8", "⅛"), TuplesKt.to("3/8", "⅜"), TuplesKt.to("5/8", "⅝"), TuplesKt.to("7/8", "⅞"));
    }

    public static final class a {

        /* JADX INFO: renamed from: com.pspdfkit.internal.di$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0264a {
            public static final /* synthetic */ int[] a;
            public static final /* synthetic */ int[] b;

            static {
                int[] iArr = new int[MeasurementPrecision.values().length];
                try {
                    iArr[MeasurementPrecision.WHOLE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MeasurementPrecision.ONE_DP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MeasurementPrecision.TWO_DP.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[MeasurementPrecision.THREE_DP.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[MeasurementPrecision.FOUR_DP.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[MeasurementPrecision.WHOLE_INCH.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[MeasurementPrecision.HALVES_INCH.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[MeasurementPrecision.QUARTERS_INCH.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[MeasurementPrecision.EIGHTHS_INCH.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[MeasurementPrecision.SIXTEENTHS_INCH.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                a = iArr;
                int[] iArr2 = new int[Scale.UnitTo.values().length];
                try {
                    iArr2[Scale.UnitTo.FT.ordinal()] = 1;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr2[Scale.UnitTo.YD.ordinal()] = 2;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr2[Scale.UnitTo.IN.ordinal()] = 3;
                } catch (NoSuchFieldError unused13) {
                }
                b = iArr2;
            }
        }

        public static String a(xp xpVar, float f, boolean z) {
            MeasurementPrecision precision;
            if (z) {
                SecondaryMeasurementUnit secondaryMeasurementUnit = xpVar.d;
                if (secondaryMeasurementUnit == null || (precision = secondaryMeasurementUnit.getPrecision()) == null) {
                    precision = MeasurementPrecision.TWO_DP;
                }
            } else {
                precision = xpVar.b;
            }
            switch (C0264a.a[precision.ordinal()]) {
                case 1:
                    return di.a.format(Float.valueOf(f)) + a(xpVar, z);
                case 2:
                    return di.b.format(Float.valueOf(f)) + a(xpVar, z);
                case 3:
                    return di.c.format(Float.valueOf(f)) + a(xpVar, z);
                case 4:
                    return di.d.format(Float.valueOf(f)) + a(xpVar, z);
                case 5:
                    return di.e.format(Float.valueOf(f)) + a(xpVar, z);
                case 6:
                    return a(xpVar, f, 1, z);
                case 7:
                    return a(xpVar, f, 2, z);
                case 8:
                    return a(xpVar, f, 4, z);
                case 9:
                    return a(xpVar, f, 8, z);
                case 10:
                    return a(xpVar, f, 16, z);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public static String a(xp xpVar, float f, int i, boolean z) {
            Scale.UnitTo unit;
            if (z) {
                SecondaryMeasurementUnit secondaryMeasurementUnit = xpVar.d;
                if (secondaryMeasurementUnit == null || (unit = secondaryMeasurementUnit.getUnit()) == null) {
                    unit = Scale.UnitTo.IN;
                }
            } else {
                unit = xpVar.a.unitTo;
            }
            return a(xpVar.c, unit, f, i);
        }

        public static String a(xp xpVar, boolean z) {
            Scale.UnitTo unit;
            if (z) {
                SecondaryMeasurementUnit secondaryMeasurementUnit = xpVar.d;
                if (secondaryMeasurementUnit == null || (unit = secondaryMeasurementUnit.getUnit()) == null) {
                    unit = Scale.UnitTo.IN;
                }
            } else {
                unit = xpVar.a.unitTo;
            }
            return qp.a(xpVar.c, unit);
        }

        public static String a(String str) {
            String str2 = di.f.get(str);
            if (str2 == null) {
                str2 = str;
            }
            return !Intrinsics.areEqual(str2, str) ? str2 : "\u2009" + str;
        }

        public static String a(xp xpVar, float f) {
            xpVar.getClass();
            String strA = a(xpVar, f, false);
            SecondaryMeasurementUnit secondaryMeasurementUnit = xpVar.d;
            if (secondaryMeasurementUnit == null) {
                return strA;
            }
            Map<Scale.UnitTo, Float> map = tb.a;
            Scale.UnitTo unitTo = xpVar.a.unitTo;
            Scale.UnitTo unit = secondaryMeasurementUnit.getUnit();
            unit.getClass();
            return strA + " (" + a(xpVar, tb.a(unitTo, unit, f, xpVar.c == MeasurementMode.AREA), true) + ")";
        }

        public static String a(MeasurementMode measurementMode, Scale.UnitTo unitTo, float f, int i) {
            int i2;
            String str;
            if (measurementMode == MeasurementMode.AREA) {
                return di.c.format(Float.valueOf(f)) + qp.a(measurementMode, unitTo);
            }
            int i3 = (int) f;
            float f2 = 1;
            float f3 = f % f2;
            int[] iArr = C0264a.b;
            int i4 = iArr[unitTo.ordinal()];
            int i5 = 0;
            if (i4 == 1) {
                float f4 = f3 * 12.0f;
                int i6 = (int) f4;
                f3 = f4 % f2;
                i2 = i3;
                i3 = i6;
            } else if (i4 != 2) {
                i2 = 0;
            } else {
                float f5 = f3 * 3.0f;
                i2 = (int) f5;
                float f6 = (f5 % f2) * 12.0f;
                int i7 = (int) f6;
                f3 = f6 % f2;
                i5 = i3;
                i3 = i7;
            }
            String strValueOf = i3 != 0 ? String.valueOf(i3) : "";
            String strA = a(f3, i);
            if (strValueOf.length() == 0) {
                strValueOf = "";
            }
            if (strA.length() > 0) {
                strValueOf = strValueOf + strA;
            }
            String str2 = i5 != 0 ? i5 + "\u2009yd\u2009" : "";
            if (i2 == 0) {
                str = "";
            } else if (strValueOf.length() > 0) {
                str = i2 + "'-";
            } else {
                str = i2 + "'";
            }
            String str3 = strValueOf.length() > 0 ? strValueOf + "\"" : "";
            int i8 = iArr[unitTo.ordinal()];
            if (i8 == 1) {
                return str + str3;
            }
            if (i8 == 2) {
                return str2 + str + str3;
            }
            if (i8 != 3) {
                return strValueOf + qp.a(measurementMode, unitTo);
            }
            return str3;
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0047 A[PHI: r1
          0x0047: PHI (r1v4 int) = (r1v3 int), (r1v6 int) binds: [B:3:0x000b, B:7:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
        public static String a(float f, int i) {
            String strA;
            float f2 = f % 1;
            int i2 = (int) (i * f2);
            if (f2 > 0.0f) {
                BigInteger bigIntegerValueOf = BigInteger.valueOf(i2);
                bigIntegerValueOf.getClass();
                BigInteger bigIntegerValueOf2 = BigInteger.valueOf(i);
                bigIntegerValueOf2.getClass();
                int iIntValue = bigIntegerValueOf.gcd(bigIntegerValueOf2).intValue();
                if (iIntValue > 1) {
                    i /= iIntValue;
                    i2 /= iIntValue;
                }
                if (i2 != i) {
                    strA = a(i2 + "/" + i);
                } else {
                    strA = "";
                }
            } else {
                strA = "";
            }
            return i2 != 0 ? strA : "";
        }
    }
}
