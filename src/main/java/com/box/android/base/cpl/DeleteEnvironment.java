package com.box.android.base.cpl;

import com.box.android.domain.services.ILocalItemService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/base/cpl/DeleteEnvironment;", "", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "<init>", "(Lcom/box/android/domain/services/ILocalItemService;)V", "getLocalItemService", "()Lcom/box/android/domain/services/ILocalItemService;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeleteEnvironment {
    public static final int $stable = 8;
    private final ILocalItemService localItemService;

    @Inject
    public DeleteEnvironment(ILocalItemService localItemService) {
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        this.localItemService = localItemService;
    }

    public final ILocalItemService getLocalItemService() {
        return this.localItemService;
    }
}
