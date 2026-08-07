package expo.modules.ui.menu;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextMenu.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lexpo/modules/ui/menu/ContextMenuDispatchers;", "", "buttonPressed", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/ui/menu/ContextMenuButtonPressedEvent;", "switchCheckedChanged", "Lexpo/modules/ui/menu/ContextMenuSwitchValueChangeEvent;", "<init>", "(Lexpo/modules/kotlin/viewevent/ViewEventCallback;Lexpo/modules/kotlin/viewevent/ViewEventCallback;)V", "getButtonPressed", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "getSwitchCheckedChanged", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ContextMenuDispatchers {
    public static final int $stable = 8;
    private final ViewEventCallback<ContextMenuButtonPressedEvent> buttonPressed;
    private final ViewEventCallback<ContextMenuSwitchValueChangeEvent> switchCheckedChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContextMenuDispatchers copy$default(ContextMenuDispatchers contextMenuDispatchers, ViewEventCallback viewEventCallback, ViewEventCallback viewEventCallback2, int i, Object obj) {
        if ((i & 1) != 0) {
            viewEventCallback = contextMenuDispatchers.buttonPressed;
        }
        if ((i & 2) != 0) {
            viewEventCallback2 = contextMenuDispatchers.switchCheckedChanged;
        }
        return contextMenuDispatchers.copy(viewEventCallback, viewEventCallback2);
    }

    public final ViewEventCallback<ContextMenuButtonPressedEvent> component1() {
        return this.buttonPressed;
    }

    public final ViewEventCallback<ContextMenuSwitchValueChangeEvent> component2() {
        return this.switchCheckedChanged;
    }

    public final ContextMenuDispatchers copy(ViewEventCallback<ContextMenuButtonPressedEvent> buttonPressed, ViewEventCallback<ContextMenuSwitchValueChangeEvent> switchCheckedChanged) {
        Intrinsics.checkNotNullParameter(buttonPressed, "buttonPressed");
        Intrinsics.checkNotNullParameter(switchCheckedChanged, "switchCheckedChanged");
        return new ContextMenuDispatchers(buttonPressed, switchCheckedChanged);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContextMenuDispatchers)) {
            return false;
        }
        ContextMenuDispatchers contextMenuDispatchers = (ContextMenuDispatchers) other;
        return Intrinsics.areEqual(this.buttonPressed, contextMenuDispatchers.buttonPressed) && Intrinsics.areEqual(this.switchCheckedChanged, contextMenuDispatchers.switchCheckedChanged);
    }

    public int hashCode() {
        return (this.buttonPressed.hashCode() * 31) + this.switchCheckedChanged.hashCode();
    }

    public String toString() {
        return "ContextMenuDispatchers(buttonPressed=" + this.buttonPressed + ", switchCheckedChanged=" + this.switchCheckedChanged + ")";
    }

    public ContextMenuDispatchers(ViewEventCallback<ContextMenuButtonPressedEvent> buttonPressed, ViewEventCallback<ContextMenuSwitchValueChangeEvent> switchCheckedChanged) {
        Intrinsics.checkNotNullParameter(buttonPressed, "buttonPressed");
        Intrinsics.checkNotNullParameter(switchCheckedChanged, "switchCheckedChanged");
        this.buttonPressed = buttonPressed;
        this.switchCheckedChanged = switchCheckedChanged;
    }

    public final ViewEventCallback<ContextMenuButtonPressedEvent> getButtonPressed() {
        return this.buttonPressed;
    }

    public final ViewEventCallback<ContextMenuSwitchValueChangeEvent> getSwitchCheckedChanged() {
        return this.switchCheckedChanged;
    }
}
