package com.box.android.updates.force.ui;

import com.box.android.updates.force.ForceUpdateActionHandler;
import com.box.android.updates.force.ForceUpdateDialogConfigProvider;
import com.box.android.updates.force.analytics.ForceUpdateAnalytics;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class ForceUpdateActivity_MembersInjector implements MembersInjector<ForceUpdateActivity> {
    private final Provider<ForceUpdateAnalytics> analyticsProvider;
    private final Provider<ForceUpdateDialogConfigProvider> dialogConfigProvider;
    private final Provider<ForceUpdateActionHandler> forceUpdateActionHandlerProvider;

    private ForceUpdateActivity_MembersInjector(Provider<ForceUpdateActionHandler> provider, Provider<ForceUpdateDialogConfigProvider> provider2, Provider<ForceUpdateAnalytics> provider3) {
        this.forceUpdateActionHandlerProvider = provider;
        this.dialogConfigProvider = provider2;
        this.analyticsProvider = provider3;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ForceUpdateActivity forceUpdateActivity) {
        injectForceUpdateActionHandler(forceUpdateActivity, this.forceUpdateActionHandlerProvider.get());
        injectDialogConfigProvider(forceUpdateActivity, this.dialogConfigProvider.get());
        injectAnalytics(forceUpdateActivity, this.analyticsProvider.get());
    }

    public static MembersInjector<ForceUpdateActivity> create(Provider<ForceUpdateActionHandler> provider, Provider<ForceUpdateDialogConfigProvider> provider2, Provider<ForceUpdateAnalytics> provider3) {
        return new ForceUpdateActivity_MembersInjector(provider, provider2, provider3);
    }

    public static void injectForceUpdateActionHandler(ForceUpdateActivity forceUpdateActivity, ForceUpdateActionHandler forceUpdateActionHandler) {
        forceUpdateActivity.forceUpdateActionHandler = forceUpdateActionHandler;
    }

    public static void injectDialogConfigProvider(ForceUpdateActivity forceUpdateActivity, ForceUpdateDialogConfigProvider forceUpdateDialogConfigProvider) {
        forceUpdateActivity.dialogConfigProvider = forceUpdateDialogConfigProvider;
    }

    public static void injectAnalytics(ForceUpdateActivity forceUpdateActivity, ForceUpdateAnalytics forceUpdateAnalytics) {
        forceUpdateActivity.analytics = forceUpdateAnalytics;
    }
}
