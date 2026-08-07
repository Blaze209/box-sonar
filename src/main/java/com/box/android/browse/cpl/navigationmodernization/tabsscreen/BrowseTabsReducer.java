package com.box.android.browse.cpl.navigationmodernization.tabsscreen;

import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseTabsReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$State;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action;", "environment", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsEnvironment;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Action", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseTabsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final BrowseTabsEnvironment environment;

    public BrowseTabsReducer(BrowseTabsEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: BrowseTabsReducer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$State;", "", "<init>", "()V", "equals", "", "other", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        public static final State INSTANCE = new State();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 69172836;
        }

        public String toString() {
            return "State";
        }

        private State() {
        }
    }

    /* JADX INFO: compiled from: BrowseTabsReducer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action;", "", "<init>", "()V", "ScreenViewed", "SettingsClicked", "SearchClicked", "TransferClicked", "AllTabChanged", "AllTabScreenViewed", "RecentsTabChanged", "RecentsTabScreenViewed", "OfflineTabChanged", "OfflineTabScreenViewed", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$AllTabChanged;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$AllTabScreenViewed;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$OfflineTabChanged;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$OfflineTabScreenViewed;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$RecentsTabChanged;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$RecentsTabScreenViewed;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$ScreenViewed;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$SearchClicked;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$SettingsClicked;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$TransferClicked;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BrowseTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$ScreenViewed;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ScreenViewed extends Action {
            public static final int $stable = 0;
            public static final ScreenViewed INSTANCE = new ScreenViewed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ScreenViewed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -684674309;
            }

            public String toString() {
                return "ScreenViewed";
            }

            private ScreenViewed() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: BrowseTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$SettingsClicked;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SettingsClicked extends Action {
            public static final int $stable = 0;
            public static final SettingsClicked INSTANCE = new SettingsClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SettingsClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 572570937;
            }

            public String toString() {
                return "SettingsClicked";
            }

            private SettingsClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$SearchClicked;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SearchClicked extends Action {
            public static final int $stable = 0;
            public static final SearchClicked INSTANCE = new SearchClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SearchClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 591097172;
            }

            public String toString() {
                return "SearchClicked";
            }

            private SearchClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$TransferClicked;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TransferClicked extends Action {
            public static final int $stable = 0;
            public static final TransferClicked INSTANCE = new TransferClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TransferClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1332383631;
            }

            public String toString() {
                return "TransferClicked";
            }

            private TransferClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$AllTabChanged;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AllTabChanged extends Action {
            public static final int $stable = 0;
            public static final AllTabChanged INSTANCE = new AllTabChanged();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AllTabChanged)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1173761579;
            }

            public String toString() {
                return "AllTabChanged";
            }

            private AllTabChanged() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$AllTabScreenViewed;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AllTabScreenViewed extends Action {
            public static final int $stable = 0;
            public static final AllTabScreenViewed INSTANCE = new AllTabScreenViewed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AllTabScreenViewed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1016218865;
            }

            public String toString() {
                return "AllTabScreenViewed";
            }

            private AllTabScreenViewed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$RecentsTabChanged;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RecentsTabChanged extends Action {
            public static final int $stable = 0;
            public static final RecentsTabChanged INSTANCE = new RecentsTabChanged();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RecentsTabChanged)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1413757548;
            }

            public String toString() {
                return "RecentsTabChanged";
            }

            private RecentsTabChanged() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$RecentsTabScreenViewed;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RecentsTabScreenViewed extends Action {
            public static final int $stable = 0;
            public static final RecentsTabScreenViewed INSTANCE = new RecentsTabScreenViewed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RecentsTabScreenViewed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -148891432;
            }

            public String toString() {
                return "RecentsTabScreenViewed";
            }

            private RecentsTabScreenViewed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$OfflineTabChanged;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OfflineTabChanged extends Action {
            public static final int $stable = 0;
            public static final OfflineTabChanged INSTANCE = new OfflineTabChanged();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OfflineTabChanged)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2092926697;
            }

            public String toString() {
                return "OfflineTabChanged";
            }

            private OfflineTabChanged() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action$OfflineTabScreenViewed;", "Lcom/box/android/browse/cpl/navigationmodernization/tabsscreen/BrowseTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OfflineTabScreenViewed extends Action {
            public static final int $stable = 0;
            public static final OfflineTabScreenViewed INSTANCE = new OfflineTabScreenViewed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OfflineTabScreenViewed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1243132659;
            }

            public String toString() {
                return "OfflineTabScreenViewed";
            }

            private OfflineTabScreenViewed() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, Action.ScreenViewed.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(null)));
        }
        if (Intrinsics.areEqual(action, Action.SettingsClicked.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass2(null)));
        }
        if (Intrinsics.areEqual(action, Action.SearchClicked.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass3(null)));
        }
        if (Intrinsics.areEqual(action, Action.TransferClicked.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass4(null)));
        }
        if (Intrinsics.areEqual(action, Action.AllTabChanged.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass5(null)));
        }
        if (Intrinsics.areEqual(action, Action.AllTabScreenViewed.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass6(null)));
        }
        if (Intrinsics.areEqual(action, Action.RecentsTabChanged.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass7(null)));
        }
        if (Intrinsics.areEqual(action, Action.RecentsTabScreenViewed.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass8(null)));
        }
        if (Intrinsics.areEqual(action, Action.OfflineTabChanged.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass9(null)));
        }
        if (!Intrinsics.areEqual(action, Action.OfflineTabScreenViewed.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass10(null)));
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$1", f = "BrowseTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BrowseTabsReducer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BrowseTabsReducer.this.environment.getAnalytics().browseScreenViewed();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$2", f = "BrowseTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BrowseTabsReducer.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BrowseTabsReducer.this.environment.getAnalytics().settingsClicked();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$3, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$3", f = "BrowseTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BrowseTabsReducer.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BrowseTabsReducer.this.environment.getAnalytics().searchClicked();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$4, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$4", f = "BrowseTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BrowseTabsReducer.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BrowseTabsReducer.this.environment.getAnalytics().transferClicked();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$5, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$5", f = "BrowseTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BrowseTabsReducer.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BrowseTabsReducer.this.environment.getAnalytics().allTabChanged();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$6, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$6", f = "BrowseTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BrowseTabsReducer.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BrowseTabsReducer.this.environment.getAnalytics().allTabScreenViewed();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$7, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$7", f = "BrowseTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BrowseTabsReducer.this.new AnonymousClass7(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BrowseTabsReducer.this.environment.getAnalytics().recentsTabChanged();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$8, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$8", f = "BrowseTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass8 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass8(Continuation<? super AnonymousClass8> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BrowseTabsReducer.this.new AnonymousClass8(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass8) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BrowseTabsReducer.this.environment.getAnalytics().recentsTabScreenViewed();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$9, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$9", f = "BrowseTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass9 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass9(Continuation<? super AnonymousClass9> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BrowseTabsReducer.this.new AnonymousClass9(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass9) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BrowseTabsReducer.this.environment.getAnalytics().offlineTabChanged();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$10, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsReducer$reduce$10", f = "BrowseTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass10 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass10(Continuation<? super AnonymousClass10> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BrowseTabsReducer.this.new AnonymousClass10(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass10) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BrowseTabsReducer.this.environment.getAnalytics().offlineTabScreenViewed();
            return Unit.INSTANCE;
        }
    }
}
