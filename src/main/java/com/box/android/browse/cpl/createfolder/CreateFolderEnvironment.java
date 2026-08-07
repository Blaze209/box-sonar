package com.box.android.browse.cpl.createfolder;

import com.box.android.base.cpl.IItemNameValidator;
import com.box.android.browse.utilities.ICreateFolderHelper;
import com.box.android.domain.usecases.browse.CreateFolderUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateFolderReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;", "", "createFolderUseCase", "Lcom/box/android/domain/usecases/browse/CreateFolderUseCase;", "createFolderHelper", "Lcom/box/android/browse/utilities/ICreateFolderHelper;", "itemNameValidator", "Lcom/box/android/base/cpl/IItemNameValidator;", "<init>", "(Lcom/box/android/domain/usecases/browse/CreateFolderUseCase;Lcom/box/android/browse/utilities/ICreateFolderHelper;Lcom/box/android/base/cpl/IItemNameValidator;)V", "getCreateFolderUseCase", "()Lcom/box/android/domain/usecases/browse/CreateFolderUseCase;", "getCreateFolderHelper", "()Lcom/box/android/browse/utilities/ICreateFolderHelper;", "getItemNameValidator", "()Lcom/box/android/base/cpl/IItemNameValidator;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateFolderEnvironment {
    public static final int $stable = 8;
    private final ICreateFolderHelper createFolderHelper;
    private final CreateFolderUseCase createFolderUseCase;
    private final IItemNameValidator itemNameValidator;

    @Inject
    public CreateFolderEnvironment(CreateFolderUseCase createFolderUseCase, ICreateFolderHelper createFolderHelper, IItemNameValidator itemNameValidator) {
        Intrinsics.checkNotNullParameter(createFolderUseCase, "createFolderUseCase");
        Intrinsics.checkNotNullParameter(createFolderHelper, "createFolderHelper");
        Intrinsics.checkNotNullParameter(itemNameValidator, "itemNameValidator");
        this.createFolderUseCase = createFolderUseCase;
        this.createFolderHelper = createFolderHelper;
        this.itemNameValidator = itemNameValidator;
    }

    public final CreateFolderUseCase getCreateFolderUseCase() {
        return this.createFolderUseCase;
    }

    public final ICreateFolderHelper getCreateFolderHelper() {
        return this.createFolderHelper;
    }

    public final IItemNameValidator getItemNameValidator() {
        return this.itemNameValidator;
    }
}
