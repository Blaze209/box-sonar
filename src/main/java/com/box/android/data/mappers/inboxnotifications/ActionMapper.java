package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.ActionDTO;
import com.box.android.data.api.models.inboxnotifications.IconDTO;
import com.box.android.domain.models.inboxnotifications.ActionModel;
import com.box.android.domain.models.inboxnotifications.IconModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/ActionMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/ActionDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ActionMapper {
    public static final ActionMapper INSTANCE = new ActionMapper();

    private ActionMapper() {
    }

    public final ActionModel toDomain(ActionDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        String type = dto.getType();
        boolean focus = dto.getFocus();
        IconDTO icon = dto.getIcon();
        return new ActionModel(type, focus, icon != null ? IconMapper.INSTANCE.toDomain(icon) : null, dto.getValue(), dto.getStyleLevel(), ActionHandlerMapper.INSTANCE.toDomain(dto.getActionHandler()));
    }

    public final ActionDTO fromDomain(ActionModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String type = model.getType();
        boolean focus = model.getFocus();
        IconModel icon = model.getIcon();
        return new ActionDTO(type, focus, icon != null ? IconMapper.INSTANCE.fromDomain(icon) : null, model.getValue(), model.getStyleLevel(), ActionHandlerMapper.INSTANCE.fromDomain(model.getActionHandler()));
    }
}
