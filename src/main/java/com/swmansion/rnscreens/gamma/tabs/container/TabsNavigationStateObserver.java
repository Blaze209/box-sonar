package com.swmansion.rnscreens.gamma.tabs.container;

import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: TabsNavigationStateObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateObserver;", "", "onNavigationStateUpdate", "", "navState", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "isRepeated", "", "hasTriggeredSpecialEffect", "actionOrigin", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;", "onNavigationStateUpdateRejected", "currentNavState", "rejectedRequest", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateUpdateRequest;", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateRejectionReason;", "onNavigationStateUpdatePrevented", "preventedScreenKey", "", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface TabsNavigationStateObserver {
    void onNavigationStateUpdate(TabsNavigationState navState, boolean isRepeated, boolean hasTriggeredSpecialEffect, TabsActionOrigin actionOrigin);

    void onNavigationStateUpdatePrevented(TabsNavigationState currentNavState, String preventedScreenKey);

    void onNavigationStateUpdateRejected(TabsNavigationState currentNavState, TabsNavigationStateUpdateRequest rejectedRequest, TabsNavigationStateRejectionReason reason);
}
