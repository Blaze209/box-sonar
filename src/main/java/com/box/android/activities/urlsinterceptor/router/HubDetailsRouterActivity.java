package com.box.android.activities.urlsinterceptor.router;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.box.android.R;
import com.box.android.coreservices.models.BoxAccountSettings;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.utilities.BoxUtils;
import com.microsoft.intune.mam.client.app.MAMTaskStackBuilder;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubDetailsRouterActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0016\u001a\u00020\u0017H\u0014¢\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/box/android/activities/urlsinterceptor/router/HubDetailsRouterActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "setIntentServices", "(Lcom/box/android/coreservices/services/IntentServices;)V", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "setFeatureFlips", "(Lcom/box/android/domain/configuration/FeatureFlips;)V", "boxAccountSettings", "Lcom/box/android/coreservices/models/BoxAccountSettings;", "getBoxAccountSettings", "()Lcom/box/android/coreservices/models/BoxAccountSettings;", "setBoxAccountSettings", "(Lcom/box/android/coreservices/models/BoxAccountSettings;)V", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initializeNavigation", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class HubDetailsRouterActivity extends Hilt_HubDetailsRouterActivity {
    public static final int $stable = 8;

    @Inject
    public BoxAccountSettings boxAccountSettings;

    @Inject
    public FeatureFlips featureFlips;

    @Inject
    public IntentServices intentServices;

    public final IntentServices getIntentServices() {
        IntentServices intentServices = this.intentServices;
        if (intentServices != null) {
            return intentServices;
        }
        Intrinsics.throwUninitializedPropertyAccessException("intentServices");
        return null;
    }

    public final void setIntentServices(IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(intentServices, "<set-?>");
        this.intentServices = intentServices;
    }

    public final FeatureFlips getFeatureFlips() {
        FeatureFlips featureFlips = this.featureFlips;
        if (featureFlips != null) {
            return featureFlips;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlips");
        return null;
    }

    public final void setFeatureFlips(FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(featureFlips, "<set-?>");
        this.featureFlips = featureFlips;
    }

    public final BoxAccountSettings getBoxAccountSettings() {
        BoxAccountSettings boxAccountSettings = this.boxAccountSettings;
        if (boxAccountSettings != null) {
            return boxAccountSettings;
        }
        Intrinsics.throwUninitializedPropertyAccessException("boxAccountSettings");
        return null;
    }

    public final void setBoxAccountSettings(BoxAccountSettings boxAccountSettings) {
        Intrinsics.checkNotNullParameter(boxAccountSettings, "<set-?>");
        this.boxAccountSettings = boxAccountSettings;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.router_activity);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        showSpinner(getString(R.string.please_wait_dot_dot_dot));
        initializeNavigation();
    }

    private final void initializeNavigation() {
        List<String> pathSegments;
        Uri data = getIntent().getData();
        String str = (data == null || (pathSegments = data.getPathSegments()) == null) ? null : pathSegments.get(1);
        if (getFeatureFlips().getHubsFeatureFlip().getEnabled() && getBoxAccountSettings().isHubsGalleryEnabled() && str != null) {
            HubDetailsRouterActivity hubDetailsRouterActivity = this;
            Intent intentNavigationActivityIntent = getIntentServices().navigationActivityIntent(hubDetailsRouterActivity, getFeatureFlips().getMainScreenRedesign().getEnabled(), IntentServices.NavigationIntentTarget.HUBS);
            Intent intentHubDetailsActivityIntent = getIntentServices().hubDetailsActivityIntent(hubDetailsRouterActivity, str);
            TaskStackBuilder taskStackBuilderCreateTaskStackBuilder = MAMTaskStackBuilder.createTaskStackBuilder(hubDetailsRouterActivity);
            taskStackBuilderCreateTaskStackBuilder.addNextIntent(intentNavigationActivityIntent);
            taskStackBuilderCreateTaskStackBuilder.addNextIntent(intentHubDetailsActivityIntent);
            taskStackBuilderCreateTaskStackBuilder.startActivities();
        } else {
            BoxUtils.launchSafeExternalLink(this, getIntent().getData());
        }
        finish();
    }
}
