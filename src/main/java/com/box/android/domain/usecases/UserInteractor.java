package com.box.android.domain.usecases;

import com.box.android.domain.services.IUserService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/domain/usecases/UserInteractor;", "", "userService", "Lcom/box/android/domain/services/IUserService;", "<init>", "(Lcom/box/android/domain/services/IUserService;)V", "createUser", "", "contextId", "", "shutdownUser", "logoutUser", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserInteractor {
    private final IUserService userService;

    @Inject
    public UserInteractor(IUserService userService) {
        Intrinsics.checkNotNullParameter(userService, "userService");
        this.userService = userService;
    }

    public final void createUser(String contextId) {
        Intrinsics.checkNotNullParameter(contextId, "contextId");
        this.userService.notifyUserCreate(contextId);
    }

    public final void shutdownUser() {
        this.userService.notifyShutdownUser();
    }

    public final void logoutUser() {
        this.userService.notifyLogoutUser();
    }
}
