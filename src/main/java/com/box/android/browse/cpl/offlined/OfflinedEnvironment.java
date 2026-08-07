package com.box.android.browse.cpl.offlined;

import com.box.android.domain.usecases.browse.OfflinedViewInteractor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflinedReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedEnvironment;", "", "actionableItemsListEnvironment", "Lcom/box/android/browse/cpl/offlined/ActionableOfflinedViewEnvironment;", "offlinedViewInteractor", "Lcom/box/android/domain/usecases/browse/OfflinedViewInteractor;", "<init>", "(Lcom/box/android/browse/cpl/offlined/ActionableOfflinedViewEnvironment;Lcom/box/android/domain/usecases/browse/OfflinedViewInteractor;)V", "getActionableItemsListEnvironment", "()Lcom/box/android/browse/cpl/offlined/ActionableOfflinedViewEnvironment;", "getOfflinedViewInteractor", "()Lcom/box/android/domain/usecases/browse/OfflinedViewInteractor;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflinedEnvironment {
    public static final int $stable = 8;
    private final ActionableOfflinedViewEnvironment actionableItemsListEnvironment;
    private final OfflinedViewInteractor offlinedViewInteractor;

    @Inject
    public OfflinedEnvironment(ActionableOfflinedViewEnvironment actionableItemsListEnvironment, OfflinedViewInteractor offlinedViewInteractor) {
        Intrinsics.checkNotNullParameter(actionableItemsListEnvironment, "actionableItemsListEnvironment");
        Intrinsics.checkNotNullParameter(offlinedViewInteractor, "offlinedViewInteractor");
        this.actionableItemsListEnvironment = actionableItemsListEnvironment;
        this.offlinedViewInteractor = offlinedViewInteractor;
    }

    public final ActionableOfflinedViewEnvironment getActionableItemsListEnvironment() {
        return this.actionableItemsListEnvironment;
    }

    public final OfflinedViewInteractor getOfflinedViewInteractor() {
        return this.offlinedViewInteractor;
    }
}
