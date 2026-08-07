package com.box.android.preview.fileactions;

import com.box.android.base.cpl.IItemNameValidator;
import com.box.android.domain.services.IUpdateItemInfoService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoEnvironment;", "", "updateItemInfoService", "Lcom/box/android/domain/services/IUpdateItemInfoService;", "itemNameValidator", "Lcom/box/android/base/cpl/IItemNameValidator;", "<init>", "(Lcom/box/android/domain/services/IUpdateItemInfoService;Lcom/box/android/base/cpl/IItemNameValidator;)V", "getUpdateItemInfoService", "()Lcom/box/android/domain/services/IUpdateItemInfoService;", "getItemNameValidator", "()Lcom/box/android/base/cpl/IItemNameValidator;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdateItemInfoEnvironment {
    public static final int $stable = 8;
    private final IItemNameValidator itemNameValidator;
    private final IUpdateItemInfoService updateItemInfoService;

    @Inject
    public UpdateItemInfoEnvironment(IUpdateItemInfoService updateItemInfoService, IItemNameValidator itemNameValidator) {
        Intrinsics.checkNotNullParameter(updateItemInfoService, "updateItemInfoService");
        Intrinsics.checkNotNullParameter(itemNameValidator, "itemNameValidator");
        this.updateItemInfoService = updateItemInfoService;
        this.itemNameValidator = itemNameValidator;
    }

    public final IUpdateItemInfoService getUpdateItemInfoService() {
        return this.updateItemInfoService;
    }

    public final IItemNameValidator getItemNameValidator() {
        return this.itemNameValidator;
    }
}
