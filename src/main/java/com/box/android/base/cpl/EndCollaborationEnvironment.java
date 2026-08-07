package com.box.android.base.cpl;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ILocalItemService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EndCollaborationReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/base/cpl/EndCollaborationEnvironment;", "", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/domain/identity/IUserContextManager;)V", "getLocalItemService", "()Lcom/box/android/domain/services/ILocalItemService;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EndCollaborationEnvironment {
    public static final int $stable = 8;
    private final ILocalItemService localItemService;
    private final IUserContextManager userContextManager;

    @Inject
    public EndCollaborationEnvironment(ILocalItemService localItemService, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.localItemService = localItemService;
        this.userContextManager = userContextManager;
    }

    public final ILocalItemService getLocalItemService() {
        return this.localItemService;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }
}
