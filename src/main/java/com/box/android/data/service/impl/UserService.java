package com.box.android.data.service.impl;

import com.box.android.data.user.UserData;
import com.box.android.domain.services.IUserService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/data/service/impl/UserService;", "Lcom/box/android/domain/services/IUserService;", "userData", "Lcom/box/android/data/user/UserData;", "<init>", "(Lcom/box/android/data/user/UserData;)V", "notifyUserCreate", "", "id", "", "notifyShutdownUser", "notifyLogoutUser", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserService implements IUserService {
    private final UserData userData;

    @Inject
    public UserService(UserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        this.userData = userData;
    }

    @Override // com.box.android.domain.services.IUserService
    public void notifyUserCreate(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.userData.createUser(id);
    }

    @Override // com.box.android.domain.services.IUserService
    public void notifyShutdownUser() {
        this.userData.shutdownUser();
    }

    @Override // com.box.android.domain.services.IUserService
    public void notifyLogoutUser() {
        this.userData.logout();
    }
}
