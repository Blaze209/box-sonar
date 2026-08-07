package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.ActionDTO;
import com.box.android.data.api.models.inboxnotifications.ActionHandlerDTO;
import com.box.android.data.api.models.inboxnotifications.TextDTO;
import com.box.android.domain.models.inboxnotifications.ActionHandlerModel;
import com.box.android.domain.models.inboxnotifications.ActionModel;
import com.box.android.domain.models.inboxnotifications.TextModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/ActionHandlerMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/ActionHandlerModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/ActionHandlerDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ActionHandlerMapper {
    public static final ActionHandlerMapper INSTANCE = new ActionHandlerMapper();

    private ActionHandlerMapper() {
    }

    public final ActionHandlerModel toDomain(ActionHandlerDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        String type = dto.getType();
        String uri = dto.getUri();
        String actionId = dto.getActionId();
        TextDTO title = dto.getTitle();
        ArrayList arrayList = null;
        TextModel domain = title != null ? TextMapper.INSTANCE.toDomain(title) : null;
        TextDTO message = dto.getMessage();
        TextModel domain2 = message != null ? TextMapper.INSTANCE.toDomain(message) : null;
        List<ActionDTO> actions = dto.getActions();
        if (actions != null) {
            List<ActionDTO> list = actions;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(ActionMapper.INSTANCE.toDomain((ActionDTO) it.next()));
            }
            arrayList = arrayList2;
        }
        return new ActionHandlerModel(type, uri, actionId, domain, domain2, arrayList);
    }

    public final ActionHandlerDTO fromDomain(ActionHandlerModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String type = model.getType();
        String uri = model.getUri();
        String actionId = model.getActionId();
        TextModel title = model.getTitle();
        ArrayList arrayList = null;
        TextDTO textDTOFromDomain = title != null ? TextMapper.INSTANCE.fromDomain(title) : null;
        TextModel message = model.getMessage();
        TextDTO textDTOFromDomain2 = message != null ? TextMapper.INSTANCE.fromDomain(message) : null;
        List<ActionModel> actions = model.getActions();
        if (actions != null) {
            List<ActionModel> list = actions;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(ActionMapper.INSTANCE.fromDomain((ActionModel) it.next()));
            }
            arrayList = arrayList2;
        }
        return new ActionHandlerDTO(type, uri, actionId, textDTOFromDomain, textDTOFromDomain2, arrayList);
    }
}
