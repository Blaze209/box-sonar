package expo.modules.ui.menu;

import expo.modules.kotlin.records.Field;
import expo.modules.ui.ValueChangeEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextMenuRecords.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lexpo/modules/ui/menu/ContextMenuSwitchValueChangeEvent;", "Lexpo/modules/ui/ValueChangeEvent;", "value", "", "contextMenuElementID", "", "<init>", "(ZLjava/lang/String;)V", "getValue$annotations", "()V", "getValue", "()Z", "getContextMenuElementID$annotations", "getContextMenuElementID", "()Ljava/lang/String;", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextMenuSwitchValueChangeEvent extends ValueChangeEvent {
    public static final int $stable = 0;
    private final String contextMenuElementID;
    private final boolean value;

    @Field
    public static /* synthetic */ void getContextMenuElementID$annotations() {
    }

    @Field
    public static /* synthetic */ void getValue$annotations() {
    }

    public /* synthetic */ ContextMenuSwitchValueChangeEvent(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, str);
    }

    @Override // expo.modules.ui.ValueChangeEvent
    public boolean getValue() {
        return this.value;
    }

    public final String getContextMenuElementID() {
        return this.contextMenuElementID;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextMenuSwitchValueChangeEvent(boolean z, String contextMenuElementID) {
        super(false, 1, null);
        Intrinsics.checkNotNullParameter(contextMenuElementID, "contextMenuElementID");
        this.value = z;
        this.contextMenuElementID = contextMenuElementID;
    }
}
