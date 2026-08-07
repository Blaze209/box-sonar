package com.swmansion.rnscreens.gamma.tabs.container;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsNavigationState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\r\u0010\u000f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "", "selectedScreenKey", "", "provenance", "", "<init>", "(Ljava/lang/String;I)V", "getSelectedScreenKey", "()Ljava/lang/String;", "getProvenance", "()I", "isEmpty", "", "isEmpty$react_native_screens_release", "isNotEmpty", "isNotEmpty$react_native_screens_release", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TabsNavigationState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TabsNavigationState EMPTY = new TabsNavigationState("", Integer.MIN_VALUE);
    private final int provenance;
    private final String selectedScreenKey;

    public static /* synthetic */ TabsNavigationState copy$default(TabsNavigationState tabsNavigationState, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tabsNavigationState.selectedScreenKey;
        }
        if ((i2 & 2) != 0) {
            i = tabsNavigationState.provenance;
        }
        return tabsNavigationState.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSelectedScreenKey() {
        return this.selectedScreenKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getProvenance() {
        return this.provenance;
    }

    public final TabsNavigationState copy(String selectedScreenKey, int provenance) {
        Intrinsics.checkNotNullParameter(selectedScreenKey, "selectedScreenKey");
        return new TabsNavigationState(selectedScreenKey, provenance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabsNavigationState)) {
            return false;
        }
        TabsNavigationState tabsNavigationState = (TabsNavigationState) other;
        return Intrinsics.areEqual(this.selectedScreenKey, tabsNavigationState.selectedScreenKey) && this.provenance == tabsNavigationState.provenance;
    }

    public int hashCode() {
        return (this.selectedScreenKey.hashCode() * 31) + Integer.hashCode(this.provenance);
    }

    public String toString() {
        return "TabsNavigationState(selectedScreenKey=" + this.selectedScreenKey + ", provenance=" + this.provenance + ")";
    }

    public TabsNavigationState(String selectedScreenKey, int i) {
        Intrinsics.checkNotNullParameter(selectedScreenKey, "selectedScreenKey");
        this.selectedScreenKey = selectedScreenKey;
        this.provenance = i;
    }

    public final String getSelectedScreenKey() {
        return this.selectedScreenKey;
    }

    public final int getProvenance() {
        return this.provenance;
    }

    public final boolean isEmpty$react_native_screens_release() {
        return this == EMPTY;
    }

    public final boolean isNotEmpty$react_native_screens_release() {
        return !isEmpty$react_native_screens_release();
    }

    /* JADX INFO: compiled from: TabsNavigationState.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "getEMPTY", "()Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TabsNavigationState getEMPTY() {
            return TabsNavigationState.EMPTY;
        }
    }
}
