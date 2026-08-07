package com.box.android.notes.presentation.cpl;

import android.text.format.DateUtils;
import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.IdentifiedList;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.notes.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: NotesItemViewData.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u001e\u0010\f\u001a\u00020\r*\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000b*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0002\"\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"canBeFavorited", "", "Lcom/box/android/domain/models/item/ItemModel;", "toNotesItemViewDataList", "", "Lcom/box/android/notes/presentation/cpl/NotesItemViewData;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$State;", "currentTimeMillis", "", "toNotesItemViewData", "currentUserId", "", "calculateNoteReadStatus", "Lcom/box/android/notes/presentation/cpl/NoteReadStatus;", "getLastEditInfo", "readStatus", "modifiedDateToDisplay", "Ljava/util/Date;", "getModifiedDateToDisplay", "(Lcom/box/android/domain/models/item/ItemModel;)Ljava/util/Date;", "TYPING_THRESHOLD", "Lkotlin/time/Duration;", "J", "notes_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotesItemViewDataKt {
    private static final long TYPING_THRESHOLD;

    public static final boolean canBeFavorited(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "<this>");
        return ItemModelKt.isInFavorites(itemModel) || itemModel.isRooted();
    }

    public static final List<NotesItemViewData> toNotesItemViewDataList(NotesListReducer.State state, long j) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        IdentifiedList<ItemId.Remote, ItemReducer.State> items = state.getItemsListViewState().getItems();
        ArrayList arrayList = new ArrayList();
        Iterator<ItemReducer.State> it = items.iterator();
        while (it.hasNext()) {
            NotesItemViewData notesItemViewData = toNotesItemViewData(it.next().getItemModel(), j, state.getCurrentUserId());
            if (notesItemViewData != null) {
                arrayList.add(notesItemViewData);
            }
        }
        return arrayList;
    }

    public static final NotesItemViewData toNotesItemViewData(ItemModel itemModel, long j, String str) {
        FileModel fileModel;
        Intrinsics.checkNotNullParameter(itemModel, "<this>");
        ItemId.Remote remoteRemoteIdOrNull = itemModel.remoteIdOrNull();
        if (remoteRemoteIdOrNull == null || (fileModel = ItemModelKt.fileModel(itemModel)) == null) {
            return null;
        }
        NoteReadStatus noteReadStatusCalculateNoteReadStatus = calculateNoteReadStatus(itemModel, str, j);
        return new NotesItemViewData(remoteRemoteIdOrNull, fileModel.getNameWithoutExtension(), getLastEditInfo(fileModel, noteReadStatusCalculateNoteReadStatus, j), ItemModelKt.parentConsideringRootFolder(FileModel.copy$default(fileModel, null, null, false, false, null, null, null, null, null, null, null, true, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134215679, null)), ItemModelKt.isInFavorites(itemModel), canBeFavorited(itemModel), noteReadStatusCalculateNoteReadStatus);
    }

    private static final NoteReadStatus calculateNoteReadStatus(ItemModel itemModel, String str, long j) {
        Date modifiedDateToDisplay;
        if (str == null) {
            return NoteReadStatus.READ;
        }
        RecentFileModel recentFileModel = itemModel instanceof RecentFileModel ? (RecentFileModel) itemModel : null;
        if (recentFileModel != null && (modifiedDateToDisplay = getModifiedDateToDisplay(recentFileModel)) != null) {
            Date interactedAt = recentFileModel.getRecentItem().getInteractedAt();
            if (interactedAt != null && interactedAt.getTime() >= modifiedDateToDisplay.getTime()) {
                return NoteReadStatus.READ;
            }
            UserModel updatedBy = recentFileModel.getUpdatedBy();
            if (Intrinsics.areEqual(updatedBy != null ? updatedBy.getId() : null, str)) {
                return NoteReadStatus.READ;
            }
            if (j - modifiedDateToDisplay.getTime() < Duration.m16167getInWholeMillisecondsimpl(TYPING_THRESHOLD)) {
                return NoteReadStatus.TYPING;
            }
            return NoteReadStatus.UNREAD;
        }
        return NoteReadStatus.READ;
    }

    private static final String getLastEditInfo(ItemModel itemModel, NoteReadStatus noteReadStatus, long j) {
        Date modifiedDateToDisplay = getModifiedDateToDisplay(itemModel);
        if (modifiedDateToDisplay == null) {
            return null;
        }
        long jCoerceAtMost = RangesKt.coerceAtMost(modifiedDateToDisplay.getTime(), j);
        UserModel updatedBy = itemModel.getUpdatedBy();
        String name = updatedBy != null ? updatedBy.getName() : null;
        if (noteReadStatus == NoteReadStatus.TYPING) {
            return name != null ? CommonBoxUtil.LS(R.string.notes_item_being_edited_by, name) : CommonBoxUtil.LS(R.string.notes_item_being_edited);
        }
        String string = DateUtils.getRelativeTimeSpanString(jCoerceAtMost, j, 60000L, 262144).toString();
        return name != null ? CommonBoxUtil.LS(R.string.notes_item_last_edit_format, string, name) : string;
    }

    private static final Date getModifiedDateToDisplay(ItemModel itemModel) {
        Date contentModifiedDate = itemModel.getContentModifiedDate();
        return contentModifiedDate == null ? itemModel.getModifiedDate() : contentModifiedDate;
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        TYPING_THRESHOLD = DurationKt.toDuration(5, DurationUnit.MINUTES);
    }
}
