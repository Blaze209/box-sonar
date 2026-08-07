package com.swmansion.rnscreens.gamma.tabs.container;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsNavigationState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateUpdateRequest;", "", "selectedScreenKey", "", "baseProvenance", "", "actionOrigin", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;", "<init>", "(Ljava/lang/String;ILcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;)V", "getSelectedScreenKey", "()Ljava/lang/String;", "getBaseProvenance", "()I", "getActionOrigin", "()Lcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TabsNavigationStateUpdateRequest {
    private final TabsActionOrigin actionOrigin;
    private final int baseProvenance;
    private final String selectedScreenKey;

    public static /* synthetic */ TabsNavigationStateUpdateRequest copy$default(TabsNavigationStateUpdateRequest tabsNavigationStateUpdateRequest, String str, int i, TabsActionOrigin tabsActionOrigin, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tabsNavigationStateUpdateRequest.selectedScreenKey;
        }
        if ((i2 & 2) != 0) {
            i = tabsNavigationStateUpdateRequest.baseProvenance;
        }
        if ((i2 & 4) != 0) {
            tabsActionOrigin = tabsNavigationStateUpdateRequest.actionOrigin;
        }
        return tabsNavigationStateUpdateRequest.copy(str, i, tabsActionOrigin);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSelectedScreenKey() {
        return this.selectedScreenKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getBaseProvenance() {
        return this.baseProvenance;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TabsActionOrigin getActionOrigin() {
        return this.actionOrigin;
    }

    public final TabsNavigationStateUpdateRequest copy(String selectedScreenKey, int baseProvenance, TabsActionOrigin actionOrigin) {
        Intrinsics.checkNotNullParameter(selectedScreenKey, "selectedScreenKey");
        Intrinsics.checkNotNullParameter(actionOrigin, "actionOrigin");
        return new TabsNavigationStateUpdateRequest(selectedScreenKey, baseProvenance, actionOrigin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabsNavigationStateUpdateRequest)) {
            return false;
        }
        TabsNavigationStateUpdateRequest tabsNavigationStateUpdateRequest = (TabsNavigationStateUpdateRequest) other;
        return Intrinsics.areEqual(this.selectedScreenKey, tabsNavigationStateUpdateRequest.selectedScreenKey) && this.baseProvenance == tabsNavigationStateUpdateRequest.baseProvenance && this.actionOrigin == tabsNavigationStateUpdateRequest.actionOrigin;
    }

    public int hashCode() {
        return (((this.selectedScreenKey.hashCode() * 31) + Integer.hashCode(this.baseProvenance)) * 31) + this.actionOrigin.hashCode();
    }

    public String toString() {
        return "TabsNavigationStateUpdateRequest(selectedScreenKey=" + this.selectedScreenKey + ", baseProvenance=" + this.baseProvenance + ", actionOrigin=" + this.actionOrigin + ")";
    }

    public TabsNavigationStateUpdateRequest(String selectedScreenKey, int i, TabsActionOrigin actionOrigin) {
        Intrinsics.checkNotNullParameter(selectedScreenKey, "selectedScreenKey");
        Intrinsics.checkNotNullParameter(actionOrigin, "actionOrigin");
        this.selectedScreenKey = selectedScreenKey;
        this.baseProvenance = i;
        this.actionOrigin = actionOrigin;
    }

    public final String getSelectedScreenKey() {
        return this.selectedScreenKey;
    }

    public final int getBaseProvenance() {
        return this.baseProvenance;
    }

    public final TabsActionOrigin getActionOrigin() {
        return this.actionOrigin;
    }
}
