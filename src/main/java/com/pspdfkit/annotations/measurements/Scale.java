package com.pspdfkit.annotations.measurements;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.pspdfkit.internal.bq;
import com.pspdfkit.internal.jni.NativeMeasurementCalculator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 '2\u00020\u0001:\u0003%&'BA\b\u0000\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB-\b\u0016\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\f\u0010\u0012J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010!\u001a\u00020\"H\u0096\u0080\u0004J\u0010\u0010#\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0000J\n\u0010$\u001a\u00020\nH\u0096\u0080\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/pspdfkit/annotations/measurements/Scale;", "", "_valueFrom", "", "_unitFrom", "Lcom/pspdfkit/annotations/measurements/Scale$UnitFrom;", "_valueTo", "_unitTo", "Lcom/pspdfkit/annotations/measurements/Scale$UnitTo;", "_fromDescription", "", "_toDescription", "<init>", "(FLcom/pspdfkit/annotations/measurements/Scale$UnitFrom;FLcom/pspdfkit/annotations/measurements/Scale$UnitTo;Ljava/lang/String;Ljava/lang/String;)V", "valueFrom", "unitFrom", "valueTo", "unitTo", "(FLcom/pspdfkit/annotations/measurements/Scale$UnitFrom;FLcom/pspdfkit/annotations/measurements/Scale$UnitTo;)V", "fromDescription", "toDescription", "getValueFrom", "()F", "getValueTo", "fromValueString", "getFromValueString", "()Ljava/lang/String;", "toValueString", "getToValueString", "displayString", "equals", "", "other", "hashCode", "", "numericEquals", "toString", "UnitFrom", "UnitTo", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Scale {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String _fromDescription;
    private final String _toDescription;
    private final UnitFrom _unitFrom;
    private final UnitTo _unitTo;
    private final float _valueFrom;
    private final float _valueTo;
    private final String displayString;
    public final String fromDescription;
    public final String toDescription;
    public final UnitFrom unitFrom;
    public final UnitTo unitTo;
    private final float valueFrom;
    private final float valueTo;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/pspdfkit/annotations/measurements/Scale$Companion;", "", "<init>", "()V", "fromStrings", "Lcom/pspdfkit/annotations/measurements/Scale;", "fromValueString", "", "unitFrom", "Lcom/pspdfkit/annotations/measurements/Scale$UnitFrom;", "toValueString", "unitTo", "Lcom/pspdfkit/annotations/measurements/Scale$UnitTo;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Scale fromStrings(String fromValueString, UnitFrom unitFrom, String toValueString, UnitTo unitTo) {
            fromValueString.getClass();
            unitFrom.getClass();
            toValueString.getClass();
            unitTo.getClass();
            Double numberFromString = NativeMeasurementCalculator.parseNumberFromString(fromValueString, null);
            if (numberFromString != null) {
                float fDoubleValue = (float) numberFromString.doubleValue();
                Double numberFromString2 = NativeMeasurementCalculator.parseNumberFromString(toValueString, null);
                if (numberFromString2 != null) {
                    return new Scale(Math.max(1.0E-5f, fDoubleValue), unitFrom, Math.max(1.0E-5f, (float) numberFromString2.doubleValue()), unitTo, fromValueString, toValueString);
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\n\u001a\u00020\u0003H\u0096\u0080\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rj\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000f"}, d2 = {"Lcom/pspdfkit/annotations/measurements/Scale$UnitFrom;", "", "displayText", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "IN", "MM", "CM", "PT", "toString", "isImperial", "", "()Z", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum UnitFrom {
        IN("in"),
        MM("mm"),
        CM("cm"),
        PT("pt");

        private final String displayText;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/pspdfkit/annotations/measurements/Scale$UnitFrom$Companion;", "", "<init>", "()V", "fromString", "Lcom/pspdfkit/annotations/measurements/Scale$UnitFrom;", "s", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final UnitFrom fromString(String s) {
                UnitFrom next;
                Iterator<UnitFrom> it = UnitFrom.getEntries().iterator();
                while (it.hasNext()) {
                    next = it.next();
                    if (StringsKt.equals(next.displayText, s, true)) {
                        return next;
                    }
                }
                next = null;
                return next;
            }

            private Companion() {
            }
        }

        UnitFrom(String str) {
            this.displayText = str;
        }

        @JvmStatic
        public static final UnitFrom fromString(String str) {
            return INSTANCE.fromString(str);
        }

        public static EnumEntries<UnitFrom> getEntries() {
            return $ENTRIES;
        }

        public final boolean isImperial() {
            return this == IN;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.displayText;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000f\u001a\u00020\u0003H\u0096\u0080\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0014"}, d2 = {"Lcom/pspdfkit/annotations/measurements/Scale$UnitTo;", "", "displayText", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "IN", "MM", "CM", "PT", "FT", "M", "YD", "KM", "MI", "toString", "isImperial", "", "()Z", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum UnitTo {
        IN("in"),
        MM("mm"),
        CM("cm"),
        PT("pt"),
        FT("ft"),
        M(CmcdData.OBJECT_TYPE_MANIFEST),
        YD("yd"),
        KM("km"),
        MI("mi");

        private final String displayText;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/pspdfkit/annotations/measurements/Scale$UnitTo$Companion;", "", "<init>", "()V", "fromString", "Lcom/pspdfkit/annotations/measurements/Scale$UnitTo;", "s", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final UnitTo fromString(String s) {
                UnitTo next;
                Iterator<UnitTo> it = UnitTo.getEntries().iterator();
                while (it.hasNext()) {
                    next = it.next();
                    if (StringsKt.equals(next.displayText, s, true)) {
                        return next;
                    }
                }
                next = null;
                return next;
            }

            private Companion() {
            }
        }

        UnitTo(String str) {
            this.displayText = str;
        }

        @JvmStatic
        public static final UnitTo fromString(String str) {
            return INSTANCE.fromString(str);
        }

        public static EnumEntries<UnitTo> getEntries() {
            return $ENTRIES;
        }

        public final boolean isImperial() {
            return SetsKt.setOf((Object[]) new UnitTo[]{IN, FT, YD, MI}).contains(this);
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.displayText;
        }
    }

    public Scale(float f, UnitFrom unitFrom, float f2, UnitTo unitTo, String str, String str2) {
        unitFrom.getClass();
        unitTo.getClass();
        this._valueFrom = f;
        this._unitFrom = unitFrom;
        this._valueTo = f2;
        this._unitTo = unitTo;
        this._fromDescription = str;
        this._toDescription = str2;
        this.unitFrom = unitFrom;
        this.unitTo = unitTo;
        this.fromDescription = str;
        this.toDescription = str2;
        this.valueFrom = f;
        this.valueTo = f2;
        this.displayString = getFromValueString() + " " + unitFrom + " : " + getToValueString() + " " + unitTo;
    }

    @JvmStatic
    public static final Scale fromStrings(String str, UnitFrom unitFrom, String str2, UnitTo unitTo) {
        return INSTANCE.fromStrings(str, unitFrom, str2, unitTo);
    }

    public boolean equals(Object other) {
        if (other instanceof Scale) {
            return Intrinsics.areEqual(getDisplayString(), ((Scale) other).getDisplayString());
        }
        return false;
    }

    public final String getFromValueString() {
        String str = this.fromDescription;
        if (str != null) {
            return str;
        }
        String str2 = bq.b.format(Float.valueOf(this._valueFrom));
        str2.getClass();
        return str2;
    }

    public final String getToValueString() {
        String str = this.toDescription;
        if (str != null) {
            return str;
        }
        String str2 = bq.b.format(Float.valueOf(this._valueTo));
        str2.getClass();
        return str2;
    }

    public final float getValueFrom() {
        return this.valueFrom;
    }

    public final float getValueTo() {
        return this.valueTo;
    }

    public int hashCode() {
        return getDisplayString().hashCode();
    }

    public final boolean numericEquals(Scale other) {
        return other != null && this.valueFrom == other.valueFrom && this.unitFrom == other.unitFrom && this.valueTo == other.valueTo && this.unitTo == other.unitTo;
    }

    /* JADX INFO: renamed from: toString, reason: from getter */
    public String getDisplayString() {
        return this.displayString;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Scale(float f, UnitFrom unitFrom, float f2, UnitTo unitTo) {
        this(Math.max(1.0E-5f, f), unitFrom, Math.max(1.0E-5f, f2), unitTo, null, null);
        unitFrom.getClass();
        unitTo.getClass();
    }
}
