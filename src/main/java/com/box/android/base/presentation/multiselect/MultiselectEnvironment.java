package com.box.android.base.presentation.multiselect;

import com.box.android.coreservices.utilities.BoxAccountManagerHelper;
import com.box.android.domain.identity.IUserContextManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiselectReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "boxAccountManagerHelper", "Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;", "selectionManager", "Lcom/box/android/base/presentation/multiselect/SelectionManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;Lcom/box/android/base/presentation/multiselect/SelectionManager;)V", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "getBoxAccountManagerHelper", "()Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;", "getSelectionManager", "()Lcom/box/android/base/presentation/multiselect/SelectionManager;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MultiselectEnvironment {
    public static final int $stable = 8;
    private final BoxAccountManagerHelper boxAccountManagerHelper;
    private final SelectionManager selectionManager;
    private final IUserContextManager userContextManager;

    @Inject
    public MultiselectEnvironment(IUserContextManager userContextManager, BoxAccountManagerHelper boxAccountManagerHelper, SelectionManager selectionManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(boxAccountManagerHelper, "boxAccountManagerHelper");
        Intrinsics.checkNotNullParameter(selectionManager, "selectionManager");
        this.userContextManager = userContextManager;
        this.boxAccountManagerHelper = boxAccountManagerHelper;
        this.selectionManager = selectionManager;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final BoxAccountManagerHelper getBoxAccountManagerHelper() {
        return this.boxAccountManagerHelper;
    }

    public final SelectionManager getSelectionManager() {
        return this.selectionManager;
    }
}
