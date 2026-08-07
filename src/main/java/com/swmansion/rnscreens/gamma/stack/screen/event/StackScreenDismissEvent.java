package com.swmansion.rnscreens.gamma.stack.screen.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StackScreenDismissEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\t¨\u0006\r"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/screen/event/StackScreenDismissEvent;", "Lcom/swmansion/rnscreens/gamma/stack/screen/event/StackScreenLifecycleEvent;", "surfaceId", "", "viewId", StackScreenDismissEvent.EVENT_KEY_IS_NATIVE_DISMISS, "", "<init>", "(IIZ)V", "()Z", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackScreenDismissEvent extends StackScreenLifecycleEvent<StackScreenDismissEvent> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EVENT_KEY_IS_NATIVE_DISMISS = "isNativeDismiss";
    public static final String EVENT_NAME = "topDismiss";
    public static final String EVENT_REGISTRATION_NAME = "onDismiss";
    private final boolean isNativeDismiss;

    /* JADX INFO: renamed from: isNativeDismiss, reason: from getter */
    public final boolean getIsNativeDismiss() {
        return this.isNativeDismiss;
    }

    public StackScreenDismissEvent(int i, int i2, boolean z) {
        super(i, i2, EVENT_NAME, EVENT_REGISTRATION_NAME);
        this.isNativeDismiss = z;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenLifecycleEvent, com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean(EVENT_KEY_IS_NATIVE_DISMISS, this.isNativeDismiss);
        return writableMapCreateMap;
    }

    /* JADX INFO: compiled from: StackScreenDismissEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/screen/event/StackScreenDismissEvent$Companion;", "Lcom/swmansion/rnscreens/gamma/common/event/NamingAwareEventType;", "<init>", "()V", "EVENT_NAME", "", "EVENT_REGISTRATION_NAME", "EVENT_KEY_IS_NATIVE_DISMISS", "getEventName", "getEventRegistrationName", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements NamingAwareEventType {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        public String getEventName() {
            return StackScreenDismissEvent.EVENT_NAME;
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        /* JADX INFO: renamed from: getEventRegistrationName */
        public String getRegistrationName() {
            return StackScreenDismissEvent.EVENT_REGISTRATION_NAME;
        }
    }
}
