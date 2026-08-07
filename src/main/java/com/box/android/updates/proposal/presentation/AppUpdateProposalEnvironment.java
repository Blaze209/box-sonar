package com.box.android.updates.proposal.presentation;

import com.box.android.updates.UpdatesManager;
import com.box.android.updates.proposal.AppUpdateProposalManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/updates/proposal/presentation/AppUpdateProposalEnvironment;", "", "updatesManager", "Lcom/box/android/updates/UpdatesManager;", "appUpdateProposalManager", "Lcom/box/android/updates/proposal/AppUpdateProposalManager;", "<init>", "(Lcom/box/android/updates/UpdatesManager;Lcom/box/android/updates/proposal/AppUpdateProposalManager;)V", "getUpdatesManager", "()Lcom/box/android/updates/UpdatesManager;", "getAppUpdateProposalManager", "()Lcom/box/android/updates/proposal/AppUpdateProposalManager;", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppUpdateProposalEnvironment {
    public static final int $stable = 8;
    private final AppUpdateProposalManager appUpdateProposalManager;
    private final UpdatesManager updatesManager;

    @Inject
    public AppUpdateProposalEnvironment(UpdatesManager updatesManager, AppUpdateProposalManager appUpdateProposalManager) {
        Intrinsics.checkNotNullParameter(updatesManager, "updatesManager");
        Intrinsics.checkNotNullParameter(appUpdateProposalManager, "appUpdateProposalManager");
        this.updatesManager = updatesManager;
        this.appUpdateProposalManager = appUpdateProposalManager;
    }

    public final UpdatesManager getUpdatesManager() {
        return this.updatesManager;
    }

    public final AppUpdateProposalManager getAppUpdateProposalManager() {
        return this.appUpdateProposalManager;
    }
}
