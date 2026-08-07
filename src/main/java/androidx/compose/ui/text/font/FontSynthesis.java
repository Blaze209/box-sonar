package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FontSynthesis.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f\u0088\u0001\u0002¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/font/FontSynthesis;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "isWeightOn", "", "isWeightOn-impl$ui_text", "(I)Z", "isStyleOn", "isStyleOn-impl$ui_text", "equals", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class FontSynthesis {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int None = m9214constructorimpl(0);
    private static final int Weight = m9214constructorimpl(1);
    private static final int Style = m9214constructorimpl(2);
    private static final int All = m9214constructorimpl(65535);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontSynthesis m9213boximpl(int i) {
        return new FontSynthesis(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m9214constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m9215equalsimpl(int i, Object obj) {
        return (obj instanceof FontSynthesis) && i == ((FontSynthesis) obj).m9221unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m9216equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m9217hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: isStyleOn-impl$ui_text, reason: not valid java name */
    public static final boolean m9218isStyleOnimpl$ui_text(int i) {
        return (i & 2) != 0;
    }

    /* JADX INFO: renamed from: isWeightOn-impl$ui_text, reason: not valid java name */
    public static final boolean m9219isWeightOnimpl$ui_text(int i) {
        return (i & 1) != 0;
    }

    public boolean equals(Object other) {
        return m9215equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m9217hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m9221unboximpl() {
        return this.value;
    }

    private /* synthetic */ FontSynthesis(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public String toString() {
        return m9220toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m9220toStringimpl(int i) {
        if (m9216equalsimpl0(i, None)) {
            return "None";
        }
        if (m9216equalsimpl0(i, Weight)) {
            return "Weight";
        }
        if (m9216equalsimpl0(i, Style)) {
            return "Style";
        }
        return m9216equalsimpl0(i, All) ? "All" : "Invalid";
    }

    /* JADX INFO: compiled from: FontSynthesis.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/font/FontSynthesis$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNone-GVVA2EU", "()I", "I", "Weight", "getWeight-GVVA2EU", "Style", "getStyle-GVVA2EU", "All", "getAll-GVVA2EU", "valueOf", "value", "", "valueOf-9CiegCU", "(I)I", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNone-GVVA2EU, reason: not valid java name */
        public final int m9223getNoneGVVA2EU() {
            return FontSynthesis.None;
        }

        /* JADX INFO: renamed from: getWeight-GVVA2EU, reason: not valid java name */
        public final int m9225getWeightGVVA2EU() {
            return FontSynthesis.Weight;
        }

        /* JADX INFO: renamed from: getStyle-GVVA2EU, reason: not valid java name */
        public final int m9224getStyleGVVA2EU() {
            return FontSynthesis.Style;
        }

        /* JADX INFO: renamed from: getAll-GVVA2EU, reason: not valid java name */
        public final int m9222getAllGVVA2EU() {
            return FontSynthesis.All;
        }

        /* JADX INFO: renamed from: valueOf-9CiegCU, reason: not valid java name */
        public final int m9226valueOf9CiegCU(int value) {
            boolean z = true;
            if (value != 0 && value != 1 && value != 2 && value != 65535) {
                z = false;
            }
            if (!z) {
                InlineClassHelperKt.throwIllegalArgumentException("The given value=" + value + " is not recognized by FontSynthesis.");
            }
            return FontSynthesis.m9214constructorimpl(value);
        }
    }
}
