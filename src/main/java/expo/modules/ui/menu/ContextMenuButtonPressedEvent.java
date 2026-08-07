package expo.modules.ui.menu;

import expo.modules.kotlin.records.Field;
import expo.modules.ui.button.ButtonPressedEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextMenuRecords.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/ui/menu/ContextMenuButtonPressedEvent;", "Lexpo/modules/ui/button/ButtonPressedEvent;", "contextMenuElementID", "", "<init>", "(Ljava/lang/String;)V", "getContextMenuElementID$annotations", "()V", "getContextMenuElementID", "()Ljava/lang/String;", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ContextMenuButtonPressedEvent extends ButtonPressedEvent {
    public static final int $stable = 0;
    private final String contextMenuElementID;

    @Field
    public static /* synthetic */ void getContextMenuElementID$annotations() {
    }

    public final String getContextMenuElementID() {
        return this.contextMenuElementID;
    }

    public ContextMenuButtonPressedEvent(String contextMenuElementID) {
        Intrinsics.checkNotNullParameter(contextMenuElementID, "contextMenuElementID");
        this.contextMenuElementID = contextMenuElementID;
    }
}
