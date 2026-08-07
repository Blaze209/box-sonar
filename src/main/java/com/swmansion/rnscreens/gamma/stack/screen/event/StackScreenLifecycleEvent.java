package com.swmansion.rnscreens.gamma.stack.screen.event;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackScreenLifecycleEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/screen/event/StackScreenLifecycleEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/react/uimanager/events/Event;", "Lcom/swmansion/rnscreens/gamma/common/event/NamingAwareEventType;", "surfaceId", "", "viewId", "name", "", "registrationName", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "getCoalescingKey", "", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "getEventName", "getEventRegistrationName", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class StackScreenLifecycleEvent<T extends Event<T>> extends Event<T> implements NamingAwareEventType {
    private final String name;
    private final String registrationName;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackScreenLifecycleEvent(int i, int i2, String name, String registrationName) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(registrationName, "registrationName");
        this.name = name;
        this.registrationName = registrationName;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        return Arguments.createMap();
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* JADX INFO: renamed from: getEventName, reason: from getter */
    public String getName() {
        return this.name;
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
    /* JADX INFO: renamed from: getEventRegistrationName, reason: from getter */
    public String getRegistrationName() {
        return this.registrationName;
    }
}
