package androidx.compose.ui.text.style;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.pspdfkit.annotations.NoteAnnotation;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LineBreak.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087@\u0018\u0000 \u001e2\u00020\u0001:\u0004\u001e\u001f !B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0004\u0010\fJ+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/style/LineBreak;", "", "mask", "", "constructor-impl", "(I)I", "strategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "strictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "wordBreak", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "(III)I", "getStrategy-fcGXIks", "getStrictness-usljTpc", "getWordBreak-jp8hJ3c", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-gijOMQM", "(IIII)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "Strategy", "Strictness", "WordBreak", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class LineBreak {
    private final int mask;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Simple = m9425constructorimpl(LineBreak_androidKt.packBytes(Strategy.INSTANCE.m9454getSimplefcGXIks(), Strictness.INSTANCE.m9465getNormalusljTpc(), WordBreak.INSTANCE.m9475getDefaultjp8hJ3c()));
    private static final int Heading = m9425constructorimpl(LineBreak_androidKt.packBytes(Strategy.INSTANCE.m9452getBalancedfcGXIks(), Strictness.INSTANCE.m9464getLooseusljTpc(), WordBreak.INSTANCE.m9476getPhrasejp8hJ3c()));
    private static final int Paragraph = m9425constructorimpl(LineBreak_androidKt.packBytes(Strategy.INSTANCE.m9453getHighQualityfcGXIks(), Strictness.INSTANCE.m9466getStrictusljTpc(), WordBreak.INSTANCE.m9475getDefaultjp8hJ3c()));
    private static final int Unspecified = m9425constructorimpl(0);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LineBreak m9424boximpl(int i) {
        return new LineBreak(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m9425constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m9429equalsimpl(int i, Object obj) {
        return (obj instanceof LineBreak) && i == ((LineBreak) obj).getMask();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m9430equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m9434hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m9429equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m9434hashCodeimpl(this.mask);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getMask() {
        return this.mask;
    }

    private /* synthetic */ LineBreak(int i) {
        this.mask = i;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m9426constructorimpl(int i, int i2, int i3) {
        return m9425constructorimpl(LineBreak_androidKt.packBytes(i, i2, i3));
    }

    /* JADX INFO: renamed from: getStrategy-fcGXIks, reason: not valid java name */
    public static final int m9431getStrategyfcGXIks(int i) {
        return Strategy.m9446constructorimpl(LineBreak_androidKt.unpackByte1(i));
    }

    /* JADX INFO: renamed from: getStrictness-usljTpc, reason: not valid java name */
    public static final int m9432getStrictnessusljTpc(int i) {
        return Strictness.m9457constructorimpl(LineBreak_androidKt.unpackByte2(i));
    }

    /* JADX INFO: renamed from: getWordBreak-jp8hJ3c, reason: not valid java name */
    public static final int m9433getWordBreakjp8hJ3c(int i) {
        return WordBreak.m9469constructorimpl(LineBreak_androidKt.unpackByte3(i));
    }

    /* JADX INFO: renamed from: copy-gijOMQM$default, reason: not valid java name */
    public static /* synthetic */ int m9428copygijOMQM$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = m9431getStrategyfcGXIks(i);
        }
        if ((i5 & 2) != 0) {
            i3 = m9432getStrictnessusljTpc(i);
        }
        if ((i5 & 4) != 0) {
            i4 = m9433getWordBreakjp8hJ3c(i);
        }
        return m9427copygijOMQM(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: copy-gijOMQM, reason: not valid java name */
    public static final int m9427copygijOMQM(int i, int i2, int i3, int i4) {
        return m9426constructorimpl(i2, i3, i4);
    }

    public String toString() {
        return m9435toStringimpl(this.mask);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m9435toStringimpl(int i) {
        return "LineBreak(strategy=" + ((Object) Strategy.m9450toStringimpl(m9431getStrategyfcGXIks(i))) + ", strictness=" + ((Object) Strictness.m9461toStringimpl(m9432getStrictnessusljTpc(i))) + ", wordBreak=" + ((Object) WordBreak.m9473toStringimpl(m9433getWordBreakjp8hJ3c(i))) + ')';
    }

    /* JADX INFO: compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Companion;", "", "<init>", "()V", "Simple", "Landroidx/compose/ui/text/style/LineBreak;", "getSimple-rAG3T2k$annotations", "getSimple-rAG3T2k", "()I", "I", "Heading", "getHeading-rAG3T2k$annotations", "getHeading-rAG3T2k", NoteAnnotation.PARAGRAPH, "getParagraph-rAG3T2k$annotations", "getParagraph-rAG3T2k", "Unspecified", "getUnspecified-rAG3T2k$annotations", "getUnspecified-rAG3T2k", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getHeading-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m9437getHeadingrAG3T2k$annotations() {
        }

        /* JADX INFO: renamed from: getParagraph-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m9438getParagraphrAG3T2k$annotations() {
        }

        /* JADX INFO: renamed from: getSimple-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m9439getSimplerAG3T2k$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m9440getUnspecifiedrAG3T2k$annotations() {
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getSimple-rAG3T2k, reason: not valid java name */
        public final int m9443getSimplerAG3T2k() {
            return LineBreak.Simple;
        }

        /* JADX INFO: renamed from: getHeading-rAG3T2k, reason: not valid java name */
        public final int m9441getHeadingrAG3T2k() {
            return LineBreak.Heading;
        }

        /* JADX INFO: renamed from: getParagraph-rAG3T2k, reason: not valid java name */
        public final int m9442getParagraphrAG3T2k() {
            return LineBreak.Paragraph;
        }

        /* JADX INFO: renamed from: getUnspecified-rAG3T2k, reason: not valid java name */
        public final int m9444getUnspecifiedrAG3T2k() {
            return LineBreak.Unspecified;
        }
    }

    /* JADX INFO: compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class Strategy {
        private final int value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Simple = m9446constructorimpl(1);
        private static final int HighQuality = m9446constructorimpl(2);
        private static final int Balanced = m9446constructorimpl(3);
        private static final int Unspecified = m9446constructorimpl(0);

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strategy m9445boximpl(int i) {
            return new Strategy(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m9446constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m9447equalsimpl(int i, Object obj) {
            return (obj instanceof Strategy) && i == ((Strategy) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m9448equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m9449hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m9447equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m9449hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* JADX INFO: compiled from: LineBreak.android.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy$Companion;", "", "<init>", "()V", "Simple", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "getSimple-fcGXIks", "()I", "I", "HighQuality", "getHighQuality-fcGXIks", "Balanced", "getBalanced-fcGXIks", "Unspecified", "getUnspecified-fcGXIks", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getSimple-fcGXIks, reason: not valid java name */
            public final int m9454getSimplefcGXIks() {
                return Strategy.Simple;
            }

            /* JADX INFO: renamed from: getHighQuality-fcGXIks, reason: not valid java name */
            public final int m9453getHighQualityfcGXIks() {
                return Strategy.HighQuality;
            }

            /* JADX INFO: renamed from: getBalanced-fcGXIks, reason: not valid java name */
            public final int m9452getBalancedfcGXIks() {
                return Strategy.Balanced;
            }

            /* JADX INFO: renamed from: getUnspecified-fcGXIks, reason: not valid java name */
            public final int m9455getUnspecifiedfcGXIks() {
                return Strategy.Unspecified;
            }
        }

        private /* synthetic */ Strategy(int i) {
            this.value = i;
        }

        public String toString() {
            return m9450toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m9450toStringimpl(int i) {
            if (m9448equalsimpl0(i, Simple)) {
                return "Strategy.Simple";
            }
            if (m9448equalsimpl0(i, HighQuality)) {
                return "Strategy.HighQuality";
            }
            if (m9448equalsimpl0(i, Balanced)) {
                return "Strategy.Balanced";
            }
            return m9448equalsimpl0(i, Unspecified) ? "Strategy.Unspecified" : "Invalid";
        }
    }

    /* JADX INFO: compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class Strictness {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Default = m9457constructorimpl(1);
        private static final int Loose = m9457constructorimpl(2);
        private static final int Normal = m9457constructorimpl(3);
        private static final int Strict = m9457constructorimpl(4);
        private static final int Unspecified = m9457constructorimpl(0);
        private final int value;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strictness m9456boximpl(int i) {
            return new Strictness(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m9457constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m9458equalsimpl(int i, Object obj) {
            return (obj instanceof Strictness) && i == ((Strictness) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m9459equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m9460hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m9458equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m9460hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* JADX INFO: compiled from: LineBreak.android.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "getDefault-usljTpc", "()I", "I", "Loose", "getLoose-usljTpc", ReactProgressBarViewManager.DEFAULT_STYLE, "getNormal-usljTpc", "Strict", "getStrict-usljTpc", "Unspecified", "getUnspecified-usljTpc", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getDefault-usljTpc, reason: not valid java name */
            public final int m9463getDefaultusljTpc() {
                return Strictness.Default;
            }

            /* JADX INFO: renamed from: getLoose-usljTpc, reason: not valid java name */
            public final int m9464getLooseusljTpc() {
                return Strictness.Loose;
            }

            /* JADX INFO: renamed from: getNormal-usljTpc, reason: not valid java name */
            public final int m9465getNormalusljTpc() {
                return Strictness.Normal;
            }

            /* JADX INFO: renamed from: getStrict-usljTpc, reason: not valid java name */
            public final int m9466getStrictusljTpc() {
                return Strictness.Strict;
            }

            /* JADX INFO: renamed from: getUnspecified-usljTpc, reason: not valid java name */
            public final int m9467getUnspecifiedusljTpc() {
                return Strictness.Unspecified;
            }
        }

        private /* synthetic */ Strictness(int i) {
            this.value = i;
        }

        public String toString() {
            return m9461toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m9461toStringimpl(int i) {
            if (m9459equalsimpl0(i, Default)) {
                return "Strictness.None";
            }
            if (m9459equalsimpl0(i, Loose)) {
                return "Strictness.Loose";
            }
            if (m9459equalsimpl0(i, Normal)) {
                return "Strictness.Normal";
            }
            if (m9459equalsimpl0(i, Strict)) {
                return "Strictness.Strict";
            }
            return m9459equalsimpl0(i, Unspecified) ? "Strictness.Unspecified" : "Invalid";
        }
    }

    /* JADX INFO: compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class WordBreak {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Default = m9469constructorimpl(1);
        private static final int Phrase = m9469constructorimpl(2);
        private static final int Unspecified = m9469constructorimpl(0);
        private final int value;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ WordBreak m9468boximpl(int i) {
            return new WordBreak(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m9469constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m9470equalsimpl(int i, Object obj) {
            return (obj instanceof WordBreak) && i == ((WordBreak) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m9471equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m9472hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m9470equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m9472hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* JADX INFO: compiled from: LineBreak.android.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "getDefault-jp8hJ3c", "()I", "I", "Phrase", "getPhrase-jp8hJ3c", "Unspecified", "getUnspecified-jp8hJ3c", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getDefault-jp8hJ3c, reason: not valid java name */
            public final int m9475getDefaultjp8hJ3c() {
                return WordBreak.Default;
            }

            /* JADX INFO: renamed from: getPhrase-jp8hJ3c, reason: not valid java name */
            public final int m9476getPhrasejp8hJ3c() {
                return WordBreak.Phrase;
            }

            /* JADX INFO: renamed from: getUnspecified-jp8hJ3c, reason: not valid java name */
            public final int m9477getUnspecifiedjp8hJ3c() {
                return WordBreak.Unspecified;
            }
        }

        private /* synthetic */ WordBreak(int i) {
            this.value = i;
        }

        public String toString() {
            return m9473toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m9473toStringimpl(int i) {
            if (m9471equalsimpl0(i, Default)) {
                return "WordBreak.None";
            }
            if (m9471equalsimpl0(i, Phrase)) {
                return "WordBreak.Phrase";
            }
            return m9471equalsimpl0(i, Unspecified) ? "WordBreak.Unspecified" : "Invalid";
        }
    }
}
