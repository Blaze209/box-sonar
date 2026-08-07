package com.box.android.updates.force;

import android.content.Context;
import android.content.Intent;
import com.box.android.domain.models.ForceUpdateReason;
import com.box.android.domain.services.IForceUpdateCoordinator;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.updates.force.ui.ForceUpdateActivity;
import com.box.androidsdk.content.utils.BoxLogUtils;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ForceUpdateCoordinator.kt */
/* JADX INFO: loaded from: classes13.dex */
@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\r\u0010\u000e\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/updates/force/ForceUpdateCoordinator;", "Lcom/box/android/domain/services/IForceUpdateCoordinator;", "forceUpdateEvaluator", "Lcom/box/android/updates/force/ForceUpdateEvaluator;", "appContext", "Landroid/content/Context;", "<init>", "(Lcom/box/android/updates/force/ForceUpdateEvaluator;Landroid/content/Context;)V", "enforceIfNeeded", "", "shouldValidateGQL", "", "onRemoteConfigUpdated", "onGQLValidationError", "openForceUpdateUI", "openForceUpdateUI$app_updates_generalProdRelease", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ForceUpdateCoordinator implements IForceUpdateCoordinator {
    public static final int $stable = 8;
    private final Context appContext;
    private final ForceUpdateEvaluator forceUpdateEvaluator;

    @Inject
    public ForceUpdateCoordinator(ForceUpdateEvaluator forceUpdateEvaluator, @ApplicationContext Context appContext) {
        Intrinsics.checkNotNullParameter(forceUpdateEvaluator, "forceUpdateEvaluator");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.forceUpdateEvaluator = forceUpdateEvaluator;
        this.appContext = appContext;
    }

    @Override // com.box.android.domain.services.IForceUpdateCoordinator
    public void enforceIfNeeded() {
        if (this.forceUpdateEvaluator.shouldTriggerForceUpdate()) {
            ForceUpdateReason forceUpdateReason = this.forceUpdateEvaluator.getForceUpdateReason();
            if (forceUpdateReason != null) {
                BoxLogUtils.d(ExtensionsKt.getTAG(this), "Force update triggered due to: " + forceUpdateReason);
                openForceUpdateUI$app_updates_generalProdRelease();
            } else {
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Force update triggered but force update reason is null");
            }
        }
    }

    @Override // com.box.android.domain.services.IForceUpdateCoordinator
    public boolean shouldValidateGQL() {
        return this.forceUpdateEvaluator.shouldValidateGQL();
    }

    @Override // com.box.android.domain.services.IForceUpdateCoordinator
    public void onRemoteConfigUpdated() {
        BoxLogUtils.d(ExtensionsKt.getTAG(this), "Remote Config updated");
        this.forceUpdateEvaluator.onRemoteConfigUpdated();
    }

    @Override // com.box.android.domain.services.IForceUpdateCoordinator
    public void onGQLValidationError() {
        BoxLogUtils.d(ExtensionsKt.getTAG(this), "GQL validation error detected");
        this.forceUpdateEvaluator.onGQLValidationError();
        enforceIfNeeded();
    }

    public final void openForceUpdateUI$app_updates_generalProdRelease() {
        Intent intentAddFlags = ForceUpdateActivity.INSTANCE.createIntent(this.appContext).addFlags(872415232);
        Intrinsics.checkNotNullExpressionValue(intentAddFlags, "addFlags(...)");
        this.appContext.startActivity(intentAddFlags);
    }
}
