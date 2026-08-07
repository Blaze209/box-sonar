package com.box.android.updates.proposal;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import javax.inject.Inject;
import kotlin.Metadata;

/* JADX INFO: compiled from: AppUpdateProposalAnalytics.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/box/android/updates/proposal/AppUpdateProposalAnalytics;", "", "<init>", "()V", "updateProposalShown", "", "updateProposalAccepted", "updateProposalCannotBeShown", "updateProposalInstallFailed", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppUpdateProposalAnalytics {
    public static final int $stable = 0;

    @Inject
    public AppUpdateProposalAnalytics() {
    }

    public final void updateProposalShown() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_IN_APP_UPDATE_SHOWN);
    }

    public final void updateProposalAccepted() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_IN_APP_UPDATE_ACCEPTED);
    }

    public final void updateProposalCannotBeShown() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_IN_APP_UPDATE_CANNOT_SHOW);
    }

    public final void updateProposalInstallFailed() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_IN_APP_UPDATE_INSTALL_FAILED);
    }
}
