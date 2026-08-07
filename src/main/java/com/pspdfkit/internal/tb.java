package com.pspdfkit.internal;

import com.pspdfkit.annotations.measurements.Scale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class tb {
    public static final Map<Scale.UnitTo, Float> a;
    public static final Map<Scale.UnitTo, Float> b;

    static {
        Scale.UnitTo unitTo = Scale.UnitTo.IN;
        Pair pair = TuplesKt.to(unitTo, Float.valueOf(0.025400002f));
        Scale.UnitTo unitTo2 = Scale.UnitTo.FT;
        Pair pair2 = TuplesKt.to(unitTo2, Float.valueOf(0.3048f));
        Scale.UnitTo unitTo3 = Scale.UnitTo.YD;
        Pair pair3 = TuplesKt.to(unitTo3, Float.valueOf(0.9144027f));
        Scale.UnitTo unitTo4 = Scale.UnitTo.MI;
        Pair pair4 = TuplesKt.to(unitTo4, Float.valueOf(1609.344f));
        Scale.UnitTo unitTo5 = Scale.UnitTo.MM;
        Float fValueOf = Float.valueOf(0.001f);
        Pair pair5 = TuplesKt.to(unitTo5, fValueOf);
        Scale.UnitTo unitTo6 = Scale.UnitTo.CM;
        Pair pair6 = TuplesKt.to(unitTo6, Float.valueOf(0.01f));
        Scale.UnitTo unitTo7 = Scale.UnitTo.M;
        Float fValueOf2 = Float.valueOf(1.0f);
        Pair pair7 = TuplesKt.to(unitTo7, fValueOf2);
        Scale.UnitTo unitTo8 = Scale.UnitTo.KM;
        Float fValueOf3 = Float.valueOf(1000.0f);
        a = MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, TuplesKt.to(unitTo8, fValueOf3));
        b = MapsKt.mapOf(TuplesKt.to(unitTo, Float.valueOf(39.3701f)), TuplesKt.to(unitTo2, Float.valueOf(3.28084f)), TuplesKt.to(unitTo3, Float.valueOf(1.09361f)), TuplesKt.to(unitTo4, Float.valueOf(6.213712E-4f)), TuplesKt.to(unitTo5, fValueOf3), TuplesKt.to(unitTo6, Float.valueOf(100.0f)), TuplesKt.to(unitTo7, fValueOf2), TuplesKt.to(unitTo8, fValueOf));
    }

    public static float a(Scale.UnitTo unitTo, Scale.UnitTo unitTo2, float f, boolean z) {
        unitTo.getClass();
        unitTo2.getClass();
        if (unitTo == unitTo2) {
            return f;
        }
        Float f2 = a.get(unitTo);
        if (f2 == null) {
            throw new IllegalArgumentException("Unrecognised unit " + unitTo);
        }
        float fFloatValue = f2.floatValue();
        Float f3 = b.get(unitTo2);
        if (f3 == null) {
            throw new IllegalArgumentException("Unrecognised unit " + unitTo2);
        }
        float fFloatValue2 = f3.floatValue();
        float f4 = f * fFloatValue;
        if (z) {
            f4 *= fFloatValue;
        }
        float f5 = f4 * fFloatValue2;
        return z ? f5 * fFloatValue2 : f5;
    }
}
