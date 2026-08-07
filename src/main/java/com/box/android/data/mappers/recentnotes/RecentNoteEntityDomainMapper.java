package com.box.android.data.mappers.recentnotes;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.data.persistence.recentnotes.RecentNoteEntity;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.models.item.RecentItemModel;
import com.box.android.domain.usecases.InteractionType;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecentNoteEntityDomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/recentnotes/RecentNoteEntityDomainMapper;", "", "<init>", "()V", "toEntity", "Lcom/box/android/data/persistence/recentnotes/RecentNoteEntity;", "note", "Lcom/box/android/domain/models/item/RecentFileModel;", "toRecentItemModel", "Lcom/box/android/domain/models/item/RecentItemModel;", TypedValues.Custom.S_REFERENCE, "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentNoteEntityDomainMapper {
    public static final RecentNoteEntityDomainMapper INSTANCE = new RecentNoteEntityDomainMapper();

    private RecentNoteEntityDomainMapper() {
    }

    public final RecentNoteEntity toEntity(RecentFileModel note) {
        Intrinsics.checkNotNullParameter(note, "note");
        String strBoxIdOrThrow = note.boxIdOrThrow();
        Date interactedAt = note.getRecentItem().getInteractedAt();
        return new RecentNoteEntity(strBoxIdOrThrow, interactedAt != null ? Long.valueOf(interactedAt.getTime()) : null, note.getRecentItem().getInteractionType().getValue(), note.getRecentItem().getInteractionSharedLink());
    }

    public final RecentItemModel toRecentItemModel(RecentNoteEntity reference) {
        InteractionType next;
        Intrinsics.checkNotNullParameter(reference, "reference");
        Iterator<InteractionType> it = InteractionType.getEntries().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(next.getValue(), reference.getInteractionType()));
        InteractionType interactionType = next;
        if (interactionType == null) {
            interactionType = InteractionType.PREVIEW;
        }
        Long interactedAt = reference.getInteractedAt();
        return new RecentItemModel(interactionType, interactedAt != null ? new Date(interactedAt.longValue()) : null, reference.getInteractionSharedLink());
    }
}
