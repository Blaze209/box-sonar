package dev.chrisbanes.haze;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: compiled from: HazeChild.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00052\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Ldev/chrisbanes/haze/HazeInputScale;", "", "None", "Auto", "Fixed", "Companion", "Ldev/chrisbanes/haze/HazeInputScale$Auto;", "Ldev/chrisbanes/haze/HazeInputScale$Fixed;", "Ldev/chrisbanes/haze/HazeInputScale$None;", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ExperimentalHazeApi
public interface HazeInputScale {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: HazeChild.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ldev/chrisbanes/haze/HazeInputScale$None;", "Ldev/chrisbanes/haze/HazeInputScale;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class None implements HazeInputScale {
        public static final int $stable = 0;
        public static final None INSTANCE = new None();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof None)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 861709831;
        }

        public String toString() {
            return "None";
        }

        private None() {
        }
    }

    /* JADX INFO: compiled from: HazeChild.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ldev/chrisbanes/haze/HazeInputScale$Auto;", "Ldev/chrisbanes/haze/HazeInputScale;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Auto implements HazeInputScale {
        public static final int $stable = 0;
        public static final Auto INSTANCE = new Auto();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Auto)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 861328510;
        }

        public String toString() {
            return "Auto";
        }

        private Auto() {
        }
    }

    /* JADX INFO: compiled from: HazeChild.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0010"}, d2 = {"Ldev/chrisbanes/haze/HazeInputScale$Fixed;", "Ldev/chrisbanes/haze/HazeInputScale;", "scale", "", "constructor-impl", "(F)F", "getScale", "()F", "equals", "", "other", "", "hashCode", "", "toString", "", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class Fixed implements HazeInputScale {
        private final float scale;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Fixed m14476boximpl(float f) {
            return new Fixed(f);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m14478equalsimpl(float f, Object obj) {
            return (obj instanceof Fixed) && Float.compare(f, ((Fixed) obj).m14482unboximpl()) == 0;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m14479equalsimpl0(float f, float f2) {
            return Float.compare(f, f2) == 0;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m14480hashCodeimpl(float f) {
            return Float.hashCode(f);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m14481toStringimpl(float f) {
            return "Fixed(scale=" + f + ")";
        }

        public boolean equals(Object other) {
            return m14478equalsimpl(this.scale, other);
        }

        public int hashCode() {
            return m14480hashCodeimpl(this.scale);
        }

        public String toString() {
            return m14481toStringimpl(this.scale);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ float m14482unboximpl() {
            return this.scale;
        }

        private /* synthetic */ Fixed(float f) {
            this.scale = f;
        }

        public final float getScale() {
            return this.scale;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static float m14477constructorimpl(float f) {
            if (f <= 0.0f || f > 1.0f) {
                throw new IllegalArgumentException("scale needs to be in the range 0 < x <= 1f".toString());
            }
            return f;
        }
    }

    /* JADX INFO: compiled from: HazeChild.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ldev/chrisbanes/haze/HazeInputScale$Companion;", "", "<init>", "()V", "Default", "Ldev/chrisbanes/haze/HazeInputScale;", "getDefault$annotations", "getDefault", "()Ldev/chrisbanes/haze/HazeInputScale;", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @ExperimentalHazeApi
        public static /* synthetic */ void getDefault$annotations() {
        }

        private Companion() {
        }

        public final HazeInputScale getDefault() {
            return None.INSTANCE;
        }
    }
}
