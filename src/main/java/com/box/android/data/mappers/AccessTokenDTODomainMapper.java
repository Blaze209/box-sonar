package com.box.android.data.mappers;

import com.box.android.data.api.models.auth.AccessTokenDTO;
import com.box.android.domain.models.AuthenticationInfoModel;
import com.box.android.domain.models.item.UserModel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccessTokenDTODomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/mappers/AccessTokenDTODomainMapper;", "Lcom/box/android/data/mappers/DomainMapper;", "Lcom/box/android/domain/models/AuthenticationInfoModel;", "Lcom/box/android/data/api/models/auth/AccessTokenDTO;", "clientId", "", "userModel", "Lcom/box/android/domain/models/item/UserModel;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/item/UserModel;)V", "toDomain", "dataModel", "fromDomain", "domainModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AccessTokenDTODomainMapper implements DomainMapper<AuthenticationInfoModel, AccessTokenDTO> {
    private final String clientId;
    private final UserModel userModel;

    public AccessTokenDTODomainMapper(String clientId, UserModel userModel) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.clientId = clientId;
        this.userModel = userModel;
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public AuthenticationInfoModel toDomain(AccessTokenDTO dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        return new AuthenticationInfoModel(dataModel.getAccessToken(), dataModel.getRefreshToken(), dataModel.getExpiresIn(), this.clientId, this.userModel);
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public AccessTokenDTO fromDomain(AuthenticationInfoModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
