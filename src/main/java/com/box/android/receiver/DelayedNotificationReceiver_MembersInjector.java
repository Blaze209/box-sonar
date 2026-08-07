package com.box.android.receiver;

import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IAppInBackgroundService;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class DelayedNotificationReceiver_MembersInjector implements MembersInjector<DelayedNotificationReceiver> {
    private final Provider<BoxApiPrivate> mApiPrivateProvider;
    private final Provider<IAppInBackgroundService> mAppInBgServiceProvider;
    private final Provider<IMoCoBoxGlobalSettings> mGlobalSettingsProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private DelayedNotificationReceiver_MembersInjector(Provider<IUserContextManager> provider, Provider<BoxApiPrivate> provider2, Provider<IMoCoBoxGlobalSettings> provider3, Provider<IAppInBackgroundService> provider4) {
        this.mUserContextManagerProvider = provider;
        this.mApiPrivateProvider = provider2;
        this.mGlobalSettingsProvider = provider3;
        this.mAppInBgServiceProvider = provider4;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DelayedNotificationReceiver delayedNotificationReceiver) {
        injectMUserContextManager(delayedNotificationReceiver, this.mUserContextManagerProvider.get());
        injectMApiPrivate(delayedNotificationReceiver, this.mApiPrivateProvider.get());
        injectMGlobalSettings(delayedNotificationReceiver, this.mGlobalSettingsProvider.get());
        injectMAppInBgService(delayedNotificationReceiver, this.mAppInBgServiceProvider.get());
    }

    public static MembersInjector<DelayedNotificationReceiver> create(Provider<IUserContextManager> provider, Provider<BoxApiPrivate> provider2, Provider<IMoCoBoxGlobalSettings> provider3, Provider<IAppInBackgroundService> provider4) {
        return new DelayedNotificationReceiver_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectMUserContextManager(DelayedNotificationReceiver delayedNotificationReceiver, IUserContextManager iUserContextManager) {
        delayedNotificationReceiver.mUserContextManager = iUserContextManager;
    }

    public static void injectMApiPrivate(DelayedNotificationReceiver delayedNotificationReceiver, BoxApiPrivate boxApiPrivate) {
        delayedNotificationReceiver.mApiPrivate = boxApiPrivate;
    }

    public static void injectMGlobalSettings(DelayedNotificationReceiver delayedNotificationReceiver, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        delayedNotificationReceiver.mGlobalSettings = iMoCoBoxGlobalSettings;
    }

    public static void injectMAppInBgService(DelayedNotificationReceiver delayedNotificationReceiver, IAppInBackgroundService iAppInBackgroundService) {
        delayedNotificationReceiver.mAppInBgService = iAppInBackgroundService;
    }
}
