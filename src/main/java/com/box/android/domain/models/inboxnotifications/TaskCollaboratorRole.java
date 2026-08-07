package com.box.android.domain.models.inboxnotifications;

import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InboxNotificationTaskModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/TaskCollaboratorRole;", "", "jsonValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", BoxTaskCollaborator.ROLE_CREATOR, BoxTaskCollaborator.ROLE_ASSIGNEE, "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum TaskCollaboratorRole {
    CREATOR(BoxTaskCollaborator.ROLE_CREATOR),
    ASSIGNEE(BoxTaskCollaborator.ROLE_ASSIGNEE);

    private final String jsonValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<TaskCollaboratorRole> getEntries() {
        return $ENTRIES;
    }

    TaskCollaboratorRole(String str) {
        this.jsonValue = str;
    }

    public final String getJsonValue() {
        return this.jsonValue;
    }

    /* JADX INFO: compiled from: InboxNotificationTaskModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/TaskCollaboratorRole$Companion;", "", "<init>", "()V", "byName", "Lcom/box/android/domain/models/inboxnotifications/TaskCollaboratorRole;", "input", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TaskCollaboratorRole byName(String input) {
            Intrinsics.checkNotNullParameter(input, "input");
            for (TaskCollaboratorRole taskCollaboratorRole : TaskCollaboratorRole.getEntries()) {
                if (StringsKt.equals(taskCollaboratorRole.getJsonValue(), input, true)) {
                    return taskCollaboratorRole;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }
}
