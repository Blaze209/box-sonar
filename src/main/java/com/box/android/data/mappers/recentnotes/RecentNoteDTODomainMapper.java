package com.box.android.data.mappers.recentnotes;

import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.recentnotes.RecentNoteDTO;
import com.box.android.data.mappers.FileDTOtoFileModelMapper;
import com.box.android.domain.mappers.RecentFileModelMapper;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.models.item.RecentItemModel;
import com.box.android.domain.usecases.InteractionType;
import com.box.androidsdk.content.utils.BoxDateFormat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecentNoteDTODomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/recentnotes/RecentNoteDTODomainMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/item/RecentFileModel;", "dto", "Lcom/box/android/data/api/models/recentnotes/RecentNoteDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentNoteDTODomainMapper {
    public static final RecentNoteDTODomainMapper INSTANCE = new RecentNoteDTODomainMapper();

    private RecentNoteDTODomainMapper() {
    }

    public final RecentFileModel toDomain(RecentNoteDTO dto) {
        InteractionType next;
        Intrinsics.checkNotNullParameter(dto, "dto");
        IItemDTO item = dto.getItem();
        FileDTO fileDTO = item instanceof FileDTO ? (FileDTO) item : null;
        if (fileDTO == null) {
            return null;
        }
        FileModel domain = FileDTOtoFileModelMapper.INSTANCE.toDomain(fileDTO);
        RecentFileModelMapper recentFileModelMapper = RecentFileModelMapper.INSTANCE;
        Iterator<InteractionType> it = InteractionType.getEntries().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(next.getValue(), dto.getInteractionType()));
        InteractionType interactionType = next;
        if (interactionType == null) {
            interactionType = InteractionType.PREVIEW;
        }
        String interactedAt = dto.getInteractedAt();
        return recentFileModelMapper.toRecentFileModel(domain, new RecentItemModel(interactionType, interactedAt != null ? BoxDateFormat.parse(interactedAt) : null, dto.getInteractionSharedLink()));
    }
}
