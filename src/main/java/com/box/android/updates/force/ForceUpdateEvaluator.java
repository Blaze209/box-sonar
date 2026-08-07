package com.box.android.updates.force;

import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.domain.configuration.IForceUpdateRepository;
import com.box.android.domain.metrics.ForceUpdateObservability;
import com.box.android.domain.models.ForceUpdateReason;
import com.box.android.domain.services.IAppInfoService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.updates.force.analytics.ForceUpdateAnalytics;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ForceUpdateEvaluator.kt */
/* JADX INFO: loaded from: classes13.dex */
@Singleton
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001b\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/box/android/updates/force/ForceUpdateEvaluator;", "", "repository", "Lcom/box/android/domain/configuration/IForceUpdateRepository;", "versionValidator", "Lcom/box/android/updates/force/ForceUpdateVersionValidator;", "observability", "Lcom/box/android/domain/metrics/ForceUpdateObservability;", "analytics", "Lcom/box/android/updates/force/analytics/ForceUpdateAnalytics;", "appInfoService", "Lcom/box/android/domain/services/IAppInfoService;", "<init>", "(Lcom/box/android/domain/configuration/IForceUpdateRepository;Lcom/box/android/updates/force/ForceUpdateVersionValidator;Lcom/box/android/domain/metrics/ForceUpdateObservability;Lcom/box/android/updates/force/analytics/ForceUpdateAnalytics;Lcom/box/android/domain/services/IAppInfoService;)V", "getCurrentAppVersion", "", "value", "Lcom/box/android/domain/models/ForceUpdateReason;", "forceUpdateReason", "getForceUpdateReason", "()Lcom/box/android/domain/models/ForceUpdateReason;", "onRemoteConfigUpdated", "", "onGQLValidationError", "shouldTriggerForceUpdate", "", "shouldValidateGQL", "evaluateBlockReason", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ForceUpdateEvaluator {
    public static final int $stable = 8;
    private final ForceUpdateAnalytics analytics;
    private final IAppInfoService appInfoService;
    private volatile ForceUpdateReason forceUpdateReason;
    private final ForceUpdateObservability observability;
    private final IForceUpdateRepository repository;
    private final ForceUpdateVersionValidator versionValidator;

    @Inject
    public ForceUpdateEvaluator(IForceUpdateRepository repository, ForceUpdateVersionValidator versionValidator, ForceUpdateObservability observability, ForceUpdateAnalytics analytics, IAppInfoService appInfoService) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(versionValidator, "versionValidator");
        Intrinsics.checkNotNullParameter(observability, "observability");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(appInfoService, "appInfoService");
        this.repository = repository;
        this.versionValidator = versionValidator;
        this.observability = observability;
        this.analytics = analytics;
        this.appInfoService = appInfoService;
        evaluateBlockReason();
    }

    private final String getCurrentAppVersion() {
        String appVersionName = this.appInfoService.getAppVersionName();
        if (appVersionName == null) {
            appVersionName = "";
        }
        return StringsKt.trim((CharSequence) appVersionName).toString();
    }

    public final ForceUpdateReason getForceUpdateReason() {
        return this.forceUpdateReason;
    }

    public final void onRemoteConfigUpdated() {
        evaluateBlockReason();
    }

    public final void onGQLValidationError() {
        this.repository.recordGQLValidationError(getCurrentAppVersion());
        evaluateBlockReason();
    }

    public final boolean shouldTriggerForceUpdate() {
        return this.forceUpdateReason != null;
    }

    public final boolean shouldValidateGQL() {
        return this.repository.isForceUpdateFeatureEnabled() && this.repository.isGQLValidationEnabled() && this.repository.getGQLValidationAfterMonths() <= BuildConfigProvider.monthsSinceBuild$default(BuildConfigProvider.INSTANCE, 0L, 1, null);
    }

    private final void evaluateBlockReason() {
        ForceUpdateReason forceUpdateReason;
        String currentAppVersion = getCurrentAppVersion();
        BoxLogUtils.v(ExtensionsKt.getTAG(this), "Evaluating force update reason for version: '" + currentAppVersion + "'");
        if (!this.repository.isForceUpdateFeatureEnabled()) {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Remote Config feature disabled, clearing force update reason");
            this.forceUpdateReason = null;
            this.repository.saveLastTrackedForceUpdateReason(null);
            return;
        }
        ForceUpdateReason lastTrackedForceUpdateReason = this.repository.getLastTrackedForceUpdateReason();
        String minSupportedVersion = this.repository.getMinSupportedVersion();
        Set<String> unsupportedVersions = this.repository.getUnsupportedVersions();
        boolean zIsGQLValidationEnabled = this.repository.isGQLValidationEnabled();
        boolean zHasGQLValidationError = this.repository.hasGQLValidationError(currentAppVersion);
        if (this.versionValidator.isBelowMinVersion(currentAppVersion, minSupportedVersion)) {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Version '" + currentAppVersion + "' blocked - below min version '" + minSupportedVersion + "'");
            forceUpdateReason = ForceUpdateReason.MIN_VERSION;
        } else if (this.versionValidator.isInBlocklist(currentAppVersion, unsupportedVersions)) {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Version '" + currentAppVersion + "' blocked - in blocklist " + unsupportedVersions);
            forceUpdateReason = ForceUpdateReason.BLOCKLIST;
        } else if (zIsGQLValidationEnabled && zHasGQLValidationError) {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Version '" + currentAppVersion + "' blocked - GQL validation error");
            forceUpdateReason = ForceUpdateReason.GQL_VALIDATION;
        } else {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Version '" + currentAppVersion + "' allowed");
            forceUpdateReason = null;
        }
        if (lastTrackedForceUpdateReason == null && forceUpdateReason != null) {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Force update state transition detected (null -> " + forceUpdateReason + "), tracking analytics");
            this.observability.logForceUpdateTriggered(forceUpdateReason);
            this.analytics.forceUpdateDialogTriggered(forceUpdateReason);
            this.repository.saveLastTrackedForceUpdateReason(forceUpdateReason);
        } else if (forceUpdateReason == null && lastTrackedForceUpdateReason != null) {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Force update no longer needed, clearing tracked reason");
            this.repository.saveLastTrackedForceUpdateReason(null);
        }
        this.forceUpdateReason = forceUpdateReason;
    }
}
