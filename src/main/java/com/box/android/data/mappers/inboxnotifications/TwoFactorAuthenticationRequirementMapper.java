package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.TwoFactorAuthenticationRequirementDTO;
import com.box.android.domain.models.inboxnotifications.AcceptanceRequirementType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/TwoFactorAuthenticationRequirementMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$MFA;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/TwoFactorAuthenticationRequirementDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TwoFactorAuthenticationRequirementMapper {
    public static final TwoFactorAuthenticationRequirementMapper INSTANCE = new TwoFactorAuthenticationRequirementMapper();

    private TwoFactorAuthenticationRequirementMapper() {
    }

    public final AcceptanceRequirementType.MFA toDomain(TwoFactorAuthenticationRequirementDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        return new AcceptanceRequirementType.MFA(dto.getEnterpriseHasTwoFactorAuthEnabled(), dto.getUserHasTwoFactorAuthenticationEnabled());
    }

    public final TwoFactorAuthenticationRequirementDTO fromDomain(AcceptanceRequirementType.MFA model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return new TwoFactorAuthenticationRequirementDTO(model.getEnterpriseHasTwoFactorAuthEnabled(), model.getUserHasTwoFactorAuthenticationEnabled());
    }
}
