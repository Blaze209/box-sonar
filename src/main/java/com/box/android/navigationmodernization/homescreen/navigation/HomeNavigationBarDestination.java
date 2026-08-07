package com.box.android.navigationmodernization.homescreen.navigation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HomeNavigationBarDestination.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "", "<init>", "()V", "Browse", "Notes", "Hubs", "Collections", "BoxAi", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination$BoxAi;", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination$Browse;", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination$Collections;", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination$Hubs;", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination$Notes;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class HomeNavigationBarDestination {
    public static final int $stable = 0;

    public /* synthetic */ HomeNavigationBarDestination(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HomeNavigationBarDestination() {
    }

    /* JADX INFO: compiled from: HomeNavigationBarDestination.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination$Browse;", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Browse extends HomeNavigationBarDestination {
        public static final int $stable = 0;
        public static final Browse INSTANCE = new Browse();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Browse)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 88438279;
        }

        public String toString() {
            return "Browse";
        }

        private Browse() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: HomeNavigationBarDestination.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination$Notes;", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Notes extends HomeNavigationBarDestination {
        public static final int $stable = 0;
        public static final Notes INSTANCE = new Notes();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Notes)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1676417956;
        }

        public String toString() {
            return "Notes";
        }

        private Notes() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: HomeNavigationBarDestination.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination$Hubs;", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Hubs extends HomeNavigationBarDestination {
        public static final int $stable = 0;
        public static final Hubs INSTANCE = new Hubs();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hubs)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 192451803;
        }

        public String toString() {
            return "Hubs";
        }

        private Hubs() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: HomeNavigationBarDestination.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination$Collections;", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Collections extends HomeNavigationBarDestination {
        public static final int $stable = 0;
        public static final Collections INSTANCE = new Collections();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Collections)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2000192456;
        }

        public String toString() {
            return "Collections";
        }

        private Collections() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: HomeNavigationBarDestination.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination$BoxAi;", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BoxAi extends HomeNavigationBarDestination {
        public static final int $stable = 0;
        public static final BoxAi INSTANCE = new BoxAi();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BoxAi)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1665338422;
        }

        public String toString() {
            return "BoxAi";
        }

        private BoxAi() {
            super(null);
        }
    }
}
