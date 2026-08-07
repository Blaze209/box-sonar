package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.TermsOfServiceDTO;
import com.box.android.data.api.models.inboxnotifications.TermsOfServiceRequirementDTO;
import com.box.android.domain.models.inboxnotifications.AcceptanceRequirementType;
import com.box.android.domain.models.inboxnotifications.TermsOfServiceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/TermsOfServiceRequirementMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$TermsOfService;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/TermsOfServiceRequirementDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TermsOfServiceRequirementMapper {
    public static final TermsOfServiceRequirementMapper INSTANCE = new TermsOfServiceRequirementMapper();

    private TermsOfServiceRequirementMapper() {
    }

    public final AcceptanceRequirementType.TermsOfService toDomain(TermsOfServiceRequirementDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        Boolean boolIsAccepted = dto.isAccepted();
        TermsOfServiceDTO termsOfService = dto.getTermsOfService();
        return new AcceptanceRequirementType.TermsOfService(boolIsAccepted, termsOfService != null ? TermsOfServiceMapper.INSTANCE.toDomain(termsOfService) : null);
    }

    public final TermsOfServiceRequirementDTO fromDomain(AcceptanceRequirementType.TermsOfService model) {
        Intrinsics.checkNotNullParameter(model, "model");
        Boolean boolIsAccepted = model.isAccepted();
        TermsOfServiceModel termsOfService = model.getTermsOfService();
        return new TermsOfServiceRequirementDTO(boolIsAccepted, termsOfService != null ? TermsOfServiceMapper.INSTANCE.fromDomain(termsOfService) : null);
    }
}
