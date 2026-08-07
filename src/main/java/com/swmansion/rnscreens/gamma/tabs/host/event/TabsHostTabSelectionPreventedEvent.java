package com.swmansion.rnscreens.gamma.tabs.host.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType;
import com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsHostTabSelectionPreventedEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0016B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/host/event/TabsHostTabSelectionPreventedEvent;", "Lcom/facebook/react/uimanager/events/Event;", "Lcom/swmansion/rnscreens/gamma/common/event/NamingAwareEventType;", "surfaceId", "", "viewId", "currentNavState", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", TabsHostTabSelectionPreventedEvent.EK_PREVENTED_KEY, "", "<init>", "(IILcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;Ljava/lang/String;)V", "getCurrentNavState", "()Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "getPreventedScreenKey", "()Ljava/lang/String;", "getEventName", "getEventRegistrationName", "canCoalesce", "", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabsHostTabSelectionPreventedEvent extends Event<TabsHostTabSelectionPreventedEvent> implements NamingAwareEventType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EK_PREVENTED_KEY = "preventedScreenKey";
    private static final String EK_PROVENANCE = "provenance";
    private static final String EK_SELECTED_KEY = "selectedScreenKey";
    public static final String EVENT_NAME = "topTabSelectionPrevented";
    public static final String EVENT_REGISTRATION_NAME = "onTabSelectionPrevented";
    private final TabsNavigationState currentNavState;
    private final String preventedScreenKey;

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    public final TabsNavigationState getCurrentNavState() {
        return this.currentNavState;
    }

    public final String getPreventedScreenKey() {
        return this.preventedScreenKey;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostTabSelectionPreventedEvent(int i, int i2, TabsNavigationState currentNavState, String preventedScreenKey) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(currentNavState, "currentNavState");
        Intrinsics.checkNotNullParameter(preventedScreenKey, "preventedScreenKey");
        this.currentNavState = currentNavState;
        this.preventedScreenKey = preventedScreenKey;
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
        writableMapCreateMap.putString(EK_PREVENTED_KEY, this.preventedScreenKey);
        return writableMapCreateMap;
    }

    /* JADX INFO: compiled from: TabsHostTabSelectionPreventedEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/host/event/TabsHostTabSelectionPreventedEvent$Companion;", "Lcom/swmansion/rnscreens/gamma/common/event/NamingAwareEventType;", "<init>", "()V", "EVENT_NAME", "", "EVENT_REGISTRATION_NAME", "EK_SELECTED_KEY", "EK_PROVENANCE", "EK_PREVENTED_KEY", "getEventName", "getEventRegistrationName", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements NamingAwareEventType {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        public String getEventName() {
            return TabsHostTabSelectionPreventedEvent.EVENT_NAME;
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        /* JADX INFO: renamed from: getEventRegistrationName */
        public String getRegistrationName() {
            return TabsHostTabSelectionPreventedEvent.EVENT_REGISTRATION_NAME;
        }
    }
}
