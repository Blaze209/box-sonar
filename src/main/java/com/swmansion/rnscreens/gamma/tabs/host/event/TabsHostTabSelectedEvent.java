package com.swmansion.rnscreens.gamma.tabs.host.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType;
import com.swmansion.rnscreens.gamma.tabs.container.TabsActionOrigin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsHostTabSelectedEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u001dB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/host/event/TabsHostTabSelectedEvent;", "Lcom/facebook/react/uimanager/events/Event;", "Lcom/swmansion/rnscreens/gamma/common/event/NamingAwareEventType;", "surfaceId", "", "viewId", TabsHostTabSelectedEvent.EK_SELECTED_KEY, "", TabsHostTabSelectedEvent.EK_PROVENANCE, TabsHostTabSelectedEvent.EK_IS_REPEATED, "", TabsHostTabSelectedEvent.EK_HAS_TRIGGERED_SPECIAL_EFFECT, TabsHostTabSelectedEvent.EK_ACTION_ORIGIN, "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;", "<init>", "(IILjava/lang/String;IZZLcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;)V", "getSelectedScreenKey", "()Ljava/lang/String;", "getProvenance", "()I", "()Z", "getHasTriggeredSpecialEffect", "getActionOrigin", "()Lcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;", "getEventName", "getEventRegistrationName", "canCoalesce", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabsHostTabSelectedEvent extends Event<TabsHostTabSelectedEvent> implements NamingAwareEventType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EK_ACTION_ORIGIN = "actionOrigin";
    private static final String EK_HAS_TRIGGERED_SPECIAL_EFFECT = "hasTriggeredSpecialEffect";
    private static final String EK_IS_REPEATED = "isRepeated";
    private static final String EK_PROVENANCE = "provenance";
    private static final String EK_SELECTED_KEY = "selectedScreenKey";
    public static final String EVENT_NAME = "topTabSelected";
    public static final String EVENT_REGISTRATION_NAME = "onTabSelected";
    private final TabsActionOrigin actionOrigin;
    private final boolean hasTriggeredSpecialEffect;
    private final boolean isRepeated;
    private final int provenance;
    private final String selectedScreenKey;

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    public final String getSelectedScreenKey() {
        return this.selectedScreenKey;
    }

    public final int getProvenance() {
        return this.provenance;
    }

    /* JADX INFO: renamed from: isRepeated, reason: from getter */
    public final boolean getIsRepeated() {
        return this.isRepeated;
    }

    public final boolean getHasTriggeredSpecialEffect() {
        return this.hasTriggeredSpecialEffect;
    }

    public final TabsActionOrigin getActionOrigin() {
        return this.actionOrigin;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostTabSelectedEvent(int i, int i2, String selectedScreenKey, int i3, boolean z, boolean z2, TabsActionOrigin actionOrigin) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(selectedScreenKey, "selectedScreenKey");
        Intrinsics.checkNotNullParameter(actionOrigin, "actionOrigin");
        this.selectedScreenKey = selectedScreenKey;
        this.provenance = i3;
        this.isRepeated = z;
        this.hasTriggeredSpecialEffect = z2;
        this.actionOrigin = actionOrigin;
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
        writableMapCreateMap.putString(EK_SELECTED_KEY, this.selectedScreenKey);
        writableMapCreateMap.putInt(EK_PROVENANCE, this.provenance);
        writableMapCreateMap.putBoolean(EK_IS_REPEATED, this.isRepeated);
        writableMapCreateMap.putBoolean(EK_HAS_TRIGGERED_SPECIAL_EFFECT, this.hasTriggeredSpecialEffect);
        writableMapCreateMap.putString(EK_ACTION_ORIGIN, this.actionOrigin.toString());
        return writableMapCreateMap;
    }

    /* JADX INFO: compiled from: TabsHostTabSelectedEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/host/event/TabsHostTabSelectedEvent$Companion;", "Lcom/swmansion/rnscreens/gamma/common/event/NamingAwareEventType;", "<init>", "()V", "EVENT_NAME", "", "EVENT_REGISTRATION_NAME", "EK_SELECTED_KEY", "EK_PROVENANCE", "EK_IS_REPEATED", "EK_HAS_TRIGGERED_SPECIAL_EFFECT", "EK_ACTION_ORIGIN", "getEventName", "getEventRegistrationName", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements NamingAwareEventType {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        public String getEventName() {
            return TabsHostTabSelectedEvent.EVENT_NAME;
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        /* JADX INFO: renamed from: getEventRegistrationName */
        public String getRegistrationName() {
            return TabsHostTabSelectedEvent.EVENT_REGISTRATION_NAME;
        }
    }
}
