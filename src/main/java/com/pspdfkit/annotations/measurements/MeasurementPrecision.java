package com.pspdfkit.annotations.measurements;

import java.util.Locale;
import java.util.Map;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v0 com.pspdfkit.annotations.measurements.MeasurementPrecision, still in use, count: 1, list:
  (r1v0 com.pspdfkit.annotations.measurements.MeasurementPrecision) from 0x0084: INVOKE 
  (r1v0 com.pspdfkit.annotations.measurements.MeasurementPrecision)
  ("1")
  (r3v0 com.pspdfkit.annotations.measurements.MeasurementPrecision)
  ("0.1")
  (r5v0 com.pspdfkit.annotations.measurements.MeasurementPrecision)
  ("0.01")
  (r7v0 com.pspdfkit.annotations.measurements.MeasurementPrecision)
  ("0.001")
  (r9v0 com.pspdfkit.annotations.measurements.MeasurementPrecision)
  ("0.0001")
  (r11v0 com.pspdfkit.annotations.measurements.MeasurementPrecision)
  ("1 in")
  (r13v0 com.pspdfkit.annotations.measurements.MeasurementPrecision)
  ("½ in")
  (r15v0 com.pspdfkit.annotations.measurements.MeasurementPrecision)
  ("¼ in")
  (r0v8 com.pspdfkit.annotations.measurements.MeasurementPrecision)
  ("⅛ in")
  (r2v9 com.pspdfkit.annotations.measurements.MeasurementPrecision)
  ("1/16 in")
 STATIC call: java.util.Map.of(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):java.util.Map A[MD:<K, V>:(K, V, K, V, K, V, K, V, K, V, K, V, K, V, K, V, K, V, K, V):java.util.Map<K, V> (c), WRAPPED] (LINE:90)
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class MeasurementPrecision {
    WHOLE,
    ONE_DP,
    TWO_DP,
    THREE_DP,
    FOUR_DP,
    WHOLE_INCH,
    HALVES_INCH,
    QUARTERS_INCH,
    EIGHTHS_INCH,
    SIXTEENTHS_INCH;

    private static final Map<MeasurementPrecision, String> precisionDisplayStringMap = Map.of(new MeasurementPrecision(), "1", new MeasurementPrecision(), "0.1", new MeasurementPrecision(), "0.01", new MeasurementPrecision(), "0.001", new MeasurementPrecision(), "0.0001", new MeasurementPrecision(), "1 in", new MeasurementPrecision(), "½ in", new MeasurementPrecision(), "¼ in", new MeasurementPrecision(), "⅛ in", new MeasurementPrecision(), "1/16 in");

    static {
    }

    private MeasurementPrecision() {
        super(str, i);
    }

    public static MeasurementPrecision fromString(String str) {
        for (MeasurementPrecision measurementPrecision : values()) {
            if (measurementPrecision.toString().equalsIgnoreCase(str)) {
                return measurementPrecision;
            }
        }
        return null;
    }

    public static MeasurementPrecision precisionFromDisplayString(String str) {
        if (str == null) {
            return null;
        }
        for (Map.Entry<MeasurementPrecision, String> entry : precisionDisplayStringMap.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static String toDisplayString(MeasurementPrecision measurementPrecision) {
        String str = precisionDisplayStringMap.get(measurementPrecision);
        return str == null ? "" : str;
    }

    public static MeasurementPrecision valueOf(String str) {
        return (MeasurementPrecision) Enum.valueOf(MeasurementPrecision.class, str);
    }

    public static MeasurementPrecision[] values() {
        return (MeasurementPrecision[]) $VALUES.clone();
    }

    public static String toDisplayString(MeasurementPrecision measurementPrecision, Scale.UnitTo unitTo) {
        if (measurementPrecision != WHOLE && measurementPrecision != ONE_DP && measurementPrecision != TWO_DP && measurementPrecision != THREE_DP && measurementPrecision != FOUR_DP) {
            String lowerCase = unitTo.toString().toLowerCase(Locale.ROOT);
            switch (measurementPrecision.ordinal()) {
                case 5:
                    return "1 " + lowerCase;
                case 6:
                    return "½ " + lowerCase;
                case 7:
                    return "¼ " + lowerCase;
                case 8:
                    return "⅛ " + lowerCase;
                case 9:
                    return "1/16 " + lowerCase;
                default:
                    return toDisplayString(measurementPrecision);
            }
        }
        return toDisplayString(measurementPrecision);
    }

    public static MeasurementPrecision precisionFromDisplayString(String str, Scale.UnitTo unitTo) {
        if (str == null) {
            return null;
        }
        MeasurementPrecision measurementPrecisionPrecisionFromDisplayString = precisionFromDisplayString(str);
        if (measurementPrecisionPrecisionFromDisplayString != null) {
            return measurementPrecisionPrecisionFromDisplayString;
        }
        unitTo.toString().toLowerCase(Locale.ROOT);
        for (MeasurementPrecision measurementPrecision : values()) {
            if (toDisplayString(measurementPrecision, unitTo).equals(str)) {
                return measurementPrecision;
            }
        }
        return null;
    }
}
