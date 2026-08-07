package com.box.android.browse.cpl.itemsList.multiselect;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.browse.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MultiselectMenuAction.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuAction;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "BoxAi", "SelectAll", "CopyMove", "Delete", "Export", "SaveOffline", "RemoveOffline", "DeselectAll", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum MultiselectMenuAction {
    BoxAi(R.id.folder_box_ai),
    SelectAll(R.id.folder_batch_select),
    CopyMove(R.id.folder_batch_copy_move),
    Delete(R.id.folder_batch_delete),
    Export(R.id.folder_batch_export),
    SaveOffline(R.id.folder_batch_save_for_offline),
    RemoveOffline(R.id.folder_batch_remove_offline),
    DeselectAll(R.id.folder_batch_deselect);

    private final int id;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<MultiselectMenuAction> getEntries() {
        return $ENTRIES;
    }

    MultiselectMenuAction(int i) {
        this.id = i;
    }

    public final int getId() {
        return this.id;
    }

    /* JADX INFO: compiled from: MultiselectMenuAction.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuAction$Companion;", "", "<init>", "()V", TypedValues.TransitionType.S_FROM, "Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuAction;", "id", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MultiselectMenuAction from(int id) {
            for (MultiselectMenuAction multiselectMenuAction : MultiselectMenuAction.values()) {
                if (multiselectMenuAction.getId() == id) {
                    return multiselectMenuAction;
                }
            }
            return null;
        }
    }
}
