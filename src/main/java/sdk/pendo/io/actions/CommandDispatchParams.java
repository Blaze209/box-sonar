package sdk.pendo.io.actions;

import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/actions/CommandDispatchParams;", "", "eventType", "Lsdk/pendo/io/actions/PendoCommandEventType;", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "", "(Lsdk/pendo/io/actions/PendoCommandEventType;Ljava/lang/String;)V", "getEventType", "()Lsdk/pendo/io/actions/PendoCommandEventType;", "getReason", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CommandDispatchParams {
    private final PendoCommandEventType eventType;
    private final String reason;

    public CommandDispatchParams(PendoCommandEventType pendoCommandEventType, String str) {
        this.eventType = pendoCommandEventType;
        this.reason = str;
    }

    public boolean equals(Object other) {
        if (!(other instanceof CommandDispatchParams)) {
            return false;
        }
        CommandDispatchParams commandDispatchParams = (CommandDispatchParams) other;
        return Intrinsics.areEqual(commandDispatchParams.eventType, this.eventType) && Intrinsics.areEqual(commandDispatchParams.reason, this.reason);
    }

    public final PendoCommandEventType getEventType() {
        return this.eventType;
    }

    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        PendoCommandEventType pendoCommandEventType = this.eventType;
        int iHashCode = pendoCommandEventType != null ? pendoCommandEventType.hashCode() : 0;
        String str = this.reason;
        return iHashCode ^ (str != null ? str.hashCode() : 0);
    }
}
