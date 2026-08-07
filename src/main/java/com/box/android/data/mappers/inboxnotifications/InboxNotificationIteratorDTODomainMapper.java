package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.InboxNotificationDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationIteratorDTO;
import com.box.android.domain.models.inboxnotifications.InboxNotificationIteratorModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationIteratorDTODomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/InboxNotificationIteratorDTODomainMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationIteratorModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationIteratorDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationIteratorDTODomainMapper {
    public static final InboxNotificationIteratorDTODomainMapper INSTANCE = new InboxNotificationIteratorDTODomainMapper();

    private InboxNotificationIteratorDTODomainMapper() {
    }

    public final InboxNotificationIteratorModel toDomain(InboxNotificationIteratorDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        int limit = dto.getLimit();
        List<InboxNotificationDTO> entries = dto.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(InboxNotificationDTODomainMapper.INSTANCE.toDomain((InboxNotificationDTO) it.next()));
        }
        return new InboxNotificationIteratorModel(limit, arrayList, dto.getNextMarker(), dto.getTopNotificationId());
    }

    public final InboxNotificationIteratorDTO fromDomain(InboxNotificationIteratorModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        int limit = model.getLimit();
        List<InboxNotificationModel> entries = model.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(InboxNotificationDTODomainMapper.INSTANCE.fromDomain((InboxNotificationModel) it.next()));
        }
        return new InboxNotificationIteratorDTO(model.getNextMarker(), limit, arrayList, model.getTopNotificationId());
    }
}
