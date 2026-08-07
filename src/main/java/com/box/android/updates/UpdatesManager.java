package com.box.android.updates;

import androidx.appcompat.app.AppCompatActivity;
import com.box.android.updates.force.ForceUpdateEvaluator;
import com.box.android.updates.proposal.AppUpdateProposalManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdatesManager.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/updates/UpdatesManager;", "", "forceUpdateEvaluator", "Lcom/box/android/updates/force/ForceUpdateEvaluator;", "appUpdateProposalManager", "Lcom/box/android/updates/proposal/AppUpdateProposalManager;", "<init>", "(Lcom/box/android/updates/force/ForceUpdateEvaluator;Lcom/box/android/updates/proposal/AppUpdateProposalManager;)V", "handleUpdateProposal", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdatesManager {
    public static final int $stable = 8;
    private final AppUpdateProposalManager appUpdateProposalManager;
    private final ForceUpdateEvaluator forceUpdateEvaluator;

    @Inject
    public UpdatesManager(ForceUpdateEvaluator forceUpdateEvaluator, AppUpdateProposalManager appUpdateProposalManager) {
        Intrinsics.checkNotNullParameter(forceUpdateEvaluator, "forceUpdateEvaluator");
        Intrinsics.checkNotNullParameter(appUpdateProposalManager, "appUpdateProposalManager");
        this.forceUpdateEvaluator = forceUpdateEvaluator;
        this.appUpdateProposalManager = appUpdateProposalManager;
    }

    public final void handleUpdateProposal(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.forceUpdateEvaluator.shouldTriggerForceUpdate()) {
            return;
        }
        this.appUpdateProposalManager.handleUpdateProposal(activity);
    }
}
