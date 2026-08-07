package com.box.android.activities.settings;

import com.box.android.base.presentation.fragments.BoxFragment_MembersInjector;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.vm.PushNotificationSettingsViewModelFactory;
import com.box.androidsdk.content.BoxApiUser;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class SettingsNotificationsFragment_MembersInjector implements MembersInjector<SettingsNotificationsFragment> {
    private final Provider<IBaseModelController> mBaseModelControllerProvider;
    private final Provider<BoxApiUser> mBoxApiUserProvider;
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<IMoCoBoxGlobalSettings> mGlobalSettingsProvider;
    private final Provider<PushNotificationSettingsViewModelFactory> mPushNotificationSettingsViewModelFactoryProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private SettingsNotificationsFragment_MembersInjector(Provider<IBaseModelController> provider, Provider<BoxApiUser> provider2, Provider<IUserContextManager> provider3, Provider<PushNotificationSettingsViewModelFactory> provider4, Provider<IMoCoBoxGlobalSettings> provider5, Provider<FeatureFlips> provider6, Provider<IUserContextManager> provider7) {
        this.mBaseModelControllerProvider = provider;
        this.mBoxApiUserProvider = provider2;
        this.mUserContextManagerProvider = provider3;
        this.mPushNotificationSettingsViewModelFactoryProvider = provider4;
        this.mGlobalSettingsProvider = provider5;
        this.mFeatureFlipsProvider = provider6;
        this.userContextManagerProvider = provider7;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SettingsNotificationsFragment settingsNotificationsFragment) {
        BoxFragment_MembersInjector.injectMBaseModelController(settingsNotificationsFragment, this.mBaseModelControllerProvider.get());
        BoxFragment_MembersInjector.injectMBoxApiUser(settingsNotificationsFragment, this.mBoxApiUserProvider.get());
        BoxFragment_MembersInjector.injectMUserContextManager(settingsNotificationsFragment, this.mUserContextManagerProvider.get());
        injectMPushNotificationSettingsViewModelFactory(settingsNotificationsFragment, this.mPushNotificationSettingsViewModelFactoryProvider.get());
        injectMGlobalSettings(settingsNotificationsFragment, this.mGlobalSettingsProvider.get());
        injectMFeatureFlips(settingsNotificationsFragment, this.mFeatureFlipsProvider.get());
        injectUserContextManager(settingsNotificationsFragment, this.userContextManagerProvider.get());
    }

    public static MembersInjector<SettingsNotificationsFragment> create(Provider<IBaseModelController> provider, Provider<BoxApiUser> provider2, Provider<IUserContextManager> provider3, Provider<PushNotificationSettingsViewModelFactory> provider4, Provider<IMoCoBoxGlobalSettings> provider5, Provider<FeatureFlips> provider6, Provider<IUserContextManager> provider7) {
        return new SettingsNotificationsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static void injectMPushNotificationSettingsViewModelFactory(SettingsNotificationsFragment settingsNotificationsFragment, PushNotificationSettingsViewModelFactory pushNotificationSettingsViewModelFactory) {
        settingsNotificationsFragment.mPushNotificationSettingsViewModelFactory = pushNotificationSettingsViewModelFactory;
    }

    public static void injectMGlobalSettings(SettingsNotificationsFragment settingsNotificationsFragment, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        settingsNotificationsFragment.mGlobalSettings = iMoCoBoxGlobalSettings;
    }

    public static void injectMFeatureFlips(SettingsNotificationsFragment settingsNotificationsFragment, FeatureFlips featureFlips) {
        settingsNotificationsFragment.mFeatureFlips = featureFlips;
    }

    public static void injectUserContextManager(SettingsNotificationsFragment settingsNotificationsFragment, IUserContextManager iUserContextManager) {
        settingsNotificationsFragment.userContextManager = iUserContextManager;
    }
}
