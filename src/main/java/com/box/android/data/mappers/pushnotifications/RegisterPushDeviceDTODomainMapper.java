package com.box.android.data.mappers.pushnotifications;

import com.box.android.data.api.models.pushnotifications.RegisterPushDeviceDTO;
import com.box.android.data.mappers.DomainMapper;
import com.box.android.domain.models.pushnotifications.PushDeviceModel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RegisterPushDeviceDTODomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/pushnotifications/RegisterPushDeviceDTODomainMapper;", "Lcom/box/android/data/mappers/DomainMapper;", "Lcom/box/android/domain/models/pushnotifications/PushDeviceModel;", "Lcom/box/android/data/api/models/pushnotifications/RegisterPushDeviceDTO;", "<init>", "()V", "fromDomain", "domainModel", "toDomain", "dataModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RegisterPushDeviceDTODomainMapper implements DomainMapper<PushDeviceModel, RegisterPushDeviceDTO> {
    public static final RegisterPushDeviceDTODomainMapper INSTANCE = new RegisterPushDeviceDTODomainMapper();

    private RegisterPushDeviceDTODomainMapper() {
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public RegisterPushDeviceDTO fromDomain(PushDeviceModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        return new RegisterPushDeviceDTO(domainModel.getToken(), null, domainModel.getLanguage(), domainModel.getVersion(), Boolean.valueOf(domainModel.getEnabled()), Boolean.valueOf(domainModel.getRegistered()), 2, null);
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public PushDeviceModel toDomain(RegisterPushDeviceDTO dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
