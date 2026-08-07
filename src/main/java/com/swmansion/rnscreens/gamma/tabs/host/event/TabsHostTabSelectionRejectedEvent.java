package com.swmansion.rnscreens.gamma.tabs.host.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType;
import com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationState;
import com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateRejectionReason;
import com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateUpdateRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsHostTabSelectionRejectedEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u001bB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/host/event/TabsHostTabSelectionRejectedEvent;", "Lcom/facebook/react/uimanager/events/Event;", "Lcom/swmansion/rnscreens/gamma/common/event/NamingAwareEventType;", "surfaceId", "", "viewId", "currentNavState", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "rejectedRequest", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateUpdateRequest;", TabsHostTabSelectionRejectedEvent.EK_REJECTION_REASON, "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateRejectionReason;", "<init>", "(IILcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateUpdateRequest;Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateRejectionReason;)V", "getCurrentNavState", "()Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "getRejectedRequest", "()Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateUpdateRequest;", "getRejectionReason", "()Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateRejectionReason;", "getEventName", "", "getEventRegistrationName", "canCoalesce", "", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabsHostTabSelectionRejectedEvent extends Event<TabsHostTabSelectionRejectedEvent> implements NamingAwareEventType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EK_PROVENANCE = "provenance";
    private static final String EK_REJECTED_BASE_PROVENANCE = "rejectedBaseProvenance";
    private static final String EK_REJECTED_KEY = "rejectedScreenKey";
    private static final String EK_REJECTION_REASON = "rejectionReason";
    private static final String EK_SELECTED_KEY = "selectedScreenKey";
    public static final String EVENT_NAME = "topTabSelectionRejected";
    public static final String EVENT_REGISTRATION_NAME = "onTabSelectionRejected";
    private final TabsNavigationState currentNavState;
    private final TabsNavigationStateUpdateRequest rejectedRequest;
    private final TabsNavigationStateRejectionReason rejectionReason;

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    public final TabsNavigationState getCurrentNavState() {
        return this.currentNavState;
    }

    public final TabsNavigationStateUpdateRequest getRejectedRequest() {
        return this.rejectedRequest;
    }

    public final TabsNavigationStateRejectionReason getRejectionReason() {
        return this.rejectionReason;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostTabSelectionRejectedEvent(int i, int i2, TabsNavigationState currentNavState, TabsNavigationStateUpdateRequest rejectedRequest, TabsNavigationStateRejectionReason rejectionReason) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(currentNavState, "currentNavState");
        Intrinsics.checkNotNullParameter(rejectedRequest, "rejectedRequest");
        Intrinsics.checkNotNullParameter(rejectionReason, "rejectionReason");
        this.currentNavState = currentNavState;
        this.rejectedRequest = rejectedRequest;
        this.rejectionReason = rejectionReason;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* JADX INFO: renamed from: getEventName */
    public String getName() {
        return EVENT_NAME;
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
    /* JADX INFO: renamed from: getEventRegistrationName */
    public String getRegistrationName() {
        return EVENT_REGISTRATION_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(EK_SELECTED_KEY, this.currentNavState.getSelectedScreenKey());
        writableMapCreateMap.putInt(EK_PROVENANCE, this.currentNavState.getProvenance());
        writableMapCreateMap.putString(EK_REJECTED_KEY, this.rejectedRequest.getSelectedScreenKey());
        writableMapCreateMap.putInt(EK_REJECTED_BASE_PROVENANCE, this.rejectedRequest.getBaseProvenance());
        writableMapCreateMap.putString(EK_REJECTION_REASON, this.rejectionReason.toString());
        return writableMapCreateMap;
    }

    /* JADX INFO: compiled from: TabsHostTabSelectionRejectedEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/host/event/TabsHostTabSelectionRejectedEvent$Companion;", "Lcom/swmansion/rnscreens/gamma/common/event/NamingAwareEventType;", "<init>", "()V", "EVENT_NAME", "", "EVENT_REGISTRATION_NAME", "EK_SELECTED_KEY", "EK_PROVENANCE", "EK_REJECTED_KEY", "EK_REJECTED_BASE_PROVENANCE", "EK_REJECTION_REASON", "getEventName", "getEventRegistrationName", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements NamingAwareEventType {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        public String getEventName() {
            return TabsHostTabSelectionRejectedEvent.EVENT_NAME;
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        /* JADX INFO: renamed from: getEventRegistrationName */
        public String getRegistrationName() {
            return TabsHostTabSelectionRejectedEvent.EVENT_REGISTRATION_NAME;
        }
    }
}
