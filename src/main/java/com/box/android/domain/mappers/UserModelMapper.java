package com.box.android.domain.mappers;

import com.box.android.domain.models.item.EnterpriseModel;
import com.box.android.domain.models.item.UserModel;
import com.box.androidsdk.content.models.BoxUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/domain/mappers/UserModelMapper;", "", "<init>", "()V", "toUserModel", "Lcom/box/android/domain/models/item/UserModel;", "Lcom/box/androidsdk/content/models/BoxUser;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserModelMapper {
    public static final UserModelMapper INSTANCE = new UserModelMapper();

    private UserModelMapper() {
    }

    public final UserModel toUserModel(BoxUser boxUser) {
        EnterpriseModel enterpriseModel;
        Intrinsics.checkNotNullParameter(boxUser, "<this>");
        if (boxUser.getEnterprise() != null) {
            String id = boxUser.getEnterprise().getUserId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            String name = boxUser.getEnterprise().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            enterpriseModel = new EnterpriseModel(id, name);
        } else {
            enterpriseModel = null;
        }
        String id2 = boxUser.getUserId();
        Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
        return new UserModel(id2, boxUser.getUserName(), boxUser.getLogin(), enterpriseModel, false, boxUser.getSpaceAmount(), boxUser.getSpaceUsed(), boxUser.getMaxUploadSize(), boxUser.getUserCreatedAt());
    }
}
