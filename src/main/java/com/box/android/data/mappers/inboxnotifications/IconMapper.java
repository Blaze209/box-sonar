package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.IconDTO;
import com.box.android.data.api.models.inboxnotifications.ImageSourceDTO;
import com.box.android.domain.models.inboxnotifications.IconModel;
import com.box.android.domain.models.inboxnotifications.ImageSourceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/IconMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/IconModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/IconDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IconMapper {
    public static final IconMapper INSTANCE = new IconMapper();

    private IconMapper() {
    }

    public final IconModel toDomain(IconDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        String type = dto.getType();
        String alt = dto.getAlt();
        String tooltip = dto.getTooltip();
        ImageSourceModel domain = ImageSourceMapper.INSTANCE.toDomain(dto.getImageSource());
        ImageSourceDTO borderImageSource = dto.getBorderImageSource();
        return new IconModel(type, alt, tooltip, domain, borderImageSource != null ? ImageSourceMapper.INSTANCE.toDomain(borderImageSource) : null);
    }

    public final IconDTO fromDomain(IconModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String type = model.getType();
        String alt = model.getAlt();
        String tooltip = model.getTooltip();
        ImageSourceDTO imageSourceDTOFromDomain = ImageSourceMapper.INSTANCE.fromDomain(model.getImageSource());
        ImageSourceModel borderImageSource = model.getBorderImageSource();
        return new IconDTO(type, alt, tooltip, imageSourceDTOFromDomain, borderImageSource != null ? ImageSourceMapper.INSTANCE.fromDomain(borderImageSource) : null);
    }
}
