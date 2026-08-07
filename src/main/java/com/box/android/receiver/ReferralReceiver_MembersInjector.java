package com.box.android.receiver;

import android.content.SharedPreferences;
import dagger.MembersInjector;
import dagger.internal.Provider;
import javax.inject.Named;

/* JADX INFO: loaded from: classes12.dex */
public final class ReferralReceiver_MembersInjector implements MembersInjector<ReferralReceiver> {
    private final Provider<String> mAppFlavorProvider;
    private final Provider<SharedPreferences> mGlobalSharedPreferencesProvider;

    private ReferralReceiver_MembersInjector(Provider<SharedPreferences> provider, Provider<String> provider2) {
        this.mGlobalSharedPreferencesProvider = provider;
        this.mAppFlavorProvider = provider2;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ReferralReceiver referralReceiver) {
        injectMGlobalSharedPreferences(referralReceiver, this.mGlobalSharedPreferencesProvider.get());
        injectMAppFlavor(referralReceiver, this.mAppFlavorProvider.get());
    }

    public static MembersInjector<ReferralReceiver> create(Provider<SharedPreferences> provider, Provider<String> provider2) {
        return new ReferralReceiver_MembersInjector(provider, provider2);
    }

    @Named("global-shared-preference")
    public static void injectMGlobalSharedPreferences(ReferralReceiver referralReceiver, SharedPreferences sharedPreferences) {
        referralReceiver.mGlobalSharedPreferences = sharedPreferences;
    }

    @Named("app-flavor")
    public static void injectMAppFlavor(ReferralReceiver referralReceiver, String str) {
        referralReceiver.mAppFlavor = str;
    }
}
