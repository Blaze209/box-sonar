package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.IconDTO;
import com.box.android.data.api.models.inboxnotifications.StatusDTO;
import com.box.android.data.api.models.inboxnotifications.TextDTO;
import com.box.android.domain.models.inboxnotifications.IconModel;
import com.box.android.domain.models.inboxnotifications.StatusModel;
import com.box.android.domain.models.inboxnotifications.TextModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/StatusMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/StatusModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/StatusDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StatusMapper {
    public static final StatusMapper INSTANCE = new StatusMapper();

    private StatusMapper() {
    }

    public final StatusModel toDomain(StatusDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        String type = dto.getType();
        IconDTO icon = dto.getIcon();
        IconModel domain = icon != null ? IconMapper.INSTANCE.toDomain(icon) : null;
        TextDTO text = dto.getText();
        return new StatusModel(type, domain, text != null ? TextMapper.INSTANCE.toDomain(text) : null);
    }

    public final StatusDTO fromDomain(StatusModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String type = model.getType();
        IconModel icon = model.getIcon();
        IconDTO iconDTOFromDomain = icon != null ? IconMapper.INSTANCE.fromDomain(icon) : null;
        TextModel text = model.getText();
        return new StatusDTO(type, iconDTOFromDomain, text != null ? TextMapper.INSTANCE.fromDomain(text) : null);
    }
}
