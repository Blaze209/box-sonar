package com.box.android.data.mappers;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.domain.models.item.UserModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserMiniDTOtoUserDomainModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/UserMiniDTOtoUserDomainModelMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/item/UserModel;", "dataModel", "Lcom/box/android/data/api/models/UserMiniDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserMiniDTOtoUserDomainModelMapper {
    public static final UserMiniDTOtoUserDomainModelMapper INSTANCE = new UserMiniDTOtoUserDomainModelMapper();

    private UserMiniDTOtoUserDomainModelMapper() {
    }

    public final UserModel toDomain(UserMiniDTO dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        return new UserModel(dataModel.getId(), dataModel.getName(), dataModel.getLogin(), null, null, null, null, null, null);
    }
}
