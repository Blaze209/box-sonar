package com.box.android.domain.models.observability;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApdexType.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/observability/ApdexScore;", "", "value", "", "<init>", "(D)V", "getValue", "()D", "Zero", "Half", "One", "Companion", "Lcom/box/android/domain/models/observability/ApdexScore$Half;", "Lcom/box/android/domain/models/observability/ApdexScore$One;", "Lcom/box/android/domain/models/observability/ApdexScore$Zero;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ApdexScore {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double value;

    public /* synthetic */ ApdexScore(double d, DefaultConstructorMarker defaultConstructorMarker) {
        this(d);
    }

    /* JADX INFO: compiled from: ApdexType.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/domain/models/observability/ApdexScore$Zero;", "Lcom/box/android/domain/models/observability/ApdexScore;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Zero extends ApdexScore {
        public static final Zero INSTANCE = new Zero();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Zero)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1896471606;
        }

        public String toString() {
            return "Zero";
        }

        private Zero() {
            super(0.0d, null);
        }
    }

    private ApdexScore(double d) {
        this.value = d;
    }

    public final double getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: ApdexType.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/domain/models/observability/ApdexScore$Half;", "Lcom/box/android/domain/models/observability/ApdexScore;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Half extends ApdexScore {
        public static final Half INSTANCE = new Half();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Half)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1895931329;
        }

        public String toString() {
            return "Half";
        }

        private Half() {
            super(0.5d, null);
        }
    }

    /* JADX INFO: compiled from: ApdexType.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/domain/models/observability/ApdexScore$One;", "Lcom/box/android/domain/models/observability/ApdexScore;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class One extends ApdexScore {
        public static final One INSTANCE = new One();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof One)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1308092184;
        }

        public String toString() {
            return "One";
        }

        private One() {
            super(1.0d, null);
        }
    }

    /* JADX INFO: compiled from: ApdexType.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/box/android/domain/models/observability/ApdexScore$Companion;", "", "<init>", "()V", "fromValue", "Lcom/box/android/domain/models/observability/ApdexScore;", "value", "", "(Ljava/lang/Double;)Lcom/box/android/domain/models/observability/ApdexScore;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ApdexScore fromValue(Double value) {
            if (Intrinsics.areEqual(value, 0.0d)) {
                return Zero.INSTANCE;
            }
            if (Intrinsics.areEqual(value, 0.5d)) {
                return Half.INSTANCE;
            }
            if (Intrinsics.areEqual(value, 1.0d)) {
                return One.INSTANCE;
            }
            if (value == null) {
                return null;
            }
            throw new IllegalArgumentException("Invalid ApdexScore value: " + value);
        }
    }
}
