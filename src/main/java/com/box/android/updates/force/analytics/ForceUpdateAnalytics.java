package com.box.android.updates.force.analytics;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.ForceUpdateReason;
import com.box.android.updates.force.ForceUpdateDialogConfig;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ForceUpdateAnalytics.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0007H\u0002¨\u0006\u0012"}, d2 = {"Lcom/box/android/updates/force/analytics/ForceUpdateAnalytics;", "", "<init>", "()V", "forceUpdateDialogTriggered", "", "forceUpdateReason", "Lcom/box/android/domain/models/ForceUpdateReason;", "logDialogShown", "config", "Lcom/box/android/updates/force/ForceUpdateDialogConfig;", "forceUpdateRegularDialogShown", "forceUpdateEmmDialogShown", "forceUpdateDialogUpdateTapped", "forceUpdateDialogCloseAppTapped", "forceUpdateDialogGooglePlayTapped", "toAnalyticsReason", "", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ForceUpdateAnalytics {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: ForceUpdateAnalytics.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ForceUpdateReason.values().length];
            try {
                iArr[ForceUpdateReason.MIN_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ForceUpdateReason.BLOCKLIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ForceUpdateReason.GQL_VALIDATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public ForceUpdateAnalytics() {
    }

    public final void forceUpdateDialogTriggered(ForceUpdateReason forceUpdateReason) {
        Intrinsics.checkNotNullParameter(forceUpdateReason, "forceUpdateReason");
        BoxAmplitudeAnalytics.ForceUpdateEventPropertyBuilder forceUpdateEventPropertyBuilderCreateForceUpdateEventPropertyBuilder = BoxAmplitudeAnalytics.createForceUpdateEventPropertyBuilder();
        forceUpdateEventPropertyBuilderCreateForceUpdateEventPropertyBuilder.setBlockReason(toAnalyticsReason(forceUpdateReason));
        forceUpdateEventPropertyBuilderCreateForceUpdateEventPropertyBuilder.logEvent(BoxAnalyticsParams.EVENT_FORCE_UPDATE_TRIGGERED);
    }

    public final void logDialogShown(ForceUpdateDialogConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.isEmmDialog()) {
            forceUpdateEmmDialogShown();
        } else {
            forceUpdateRegularDialogShown();
        }
    }

    private final void forceUpdateRegularDialogShown() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_FORCE_UPDATE_REGULAR_DIALOG_SHOWN);
    }

    private final void forceUpdateEmmDialogShown() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_FORCE_UPDATE_EMM_DIALOG_SHOWN);
    }

    public final void forceUpdateDialogUpdateTapped() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_FORCE_UPDATE_DIALOG_UPDATE_TAPPED);
    }

    public final void forceUpdateDialogCloseAppTapped() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_FORCE_UPDATE_DIALOG_CLOSE_APP_TAPPED);
    }

    public final void forceUpdateDialogGooglePlayTapped() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_FORCE_UPDATE_DIALOG_APPSTORE_TAPPED);
    }

    private final String toAnalyticsReason(ForceUpdateReason forceUpdateReason) {
        int i = WhenMappings.$EnumSwitchMapping$0[forceUpdateReason.ordinal()];
        if (i == 1) {
            return "min_version";
        }
        if (i == 2) {
            return "blocklist";
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "gql_validation";
    }
}
