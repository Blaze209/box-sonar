package com.box.android.modelcontroller;

import android.content.Context;
import com.box.android.clientadmin.BoxAdminSettingsProvider;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class MoCoAdminSettings_Factory implements Factory<MoCoAdminSettings> {
    private final Provider<BoxAdminSettingsProvider> boxAdminSettingsProvider;
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private MoCoAdminSettings_Factory(Provider<Context> provider, Provider<IUserContextManager> provider2, Provider<BoxAdminSettingsProvider> provider3) {
        this.contextProvider = provider;
        this.userContextManagerProvider = provider2;
        this.boxAdminSettingsProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MoCoAdminSettings get() {
        return newInstance(this.contextProvider.get(), this.userContextManagerProvider.get(), this.boxAdminSettingsProvider.get());
    }

    public static MoCoAdminSettings_Factory create(Provider<Context> provider, Provider<IUserContextManager> provider2, Provider<BoxAdminSettingsProvider> provider3) {
        return new MoCoAdminSettings_Factory(provider, provider2, provider3);
    }

    public static MoCoAdminSettings newInstance(Context context, IUserContextManager iUserContextManager, BoxAdminSettingsProvider boxAdminSettingsProvider) {
        return new MoCoAdminSettings(context, iUserContextManager, boxAdminSettingsProvider);
    }
}
