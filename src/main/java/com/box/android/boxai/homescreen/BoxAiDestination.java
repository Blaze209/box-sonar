package com.box.android.boxai.homescreen;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BoxAiDestination.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/boxai/homescreen/BoxAiDestination;", "", "<init>", "()V", "HomeScreen", "Companion", "Lcom/box/android/boxai/homescreen/BoxAiDestination$HomeScreen;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BoxAiDestination {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ BoxAiDestination(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BoxAiDestination() {
    }

    /* JADX INFO: compiled from: BoxAiDestination.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/homescreen/BoxAiDestination$HomeScreen;", "Lcom/box/android/boxai/homescreen/BoxAiDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class HomeScreen extends BoxAiDestination {
        public static final int $stable = 0;
        public static final HomeScreen INSTANCE = new HomeScreen();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HomeScreen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1641301467;
        }

        public String toString() {
            return "HomeScreen";
        }

        private HomeScreen() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: BoxAiDestination.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/boxai/homescreen/BoxAiDestination$Companion;", "", "<init>", "()V", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
