package com.box.android.receiver;

import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxDeviceConfigChangeInfoReceiver_MembersInjector implements MembersInjector<BoxDeviceConfigChangeInfoReceiver> {
    private final Provider<BoxApiPrivate> mPrivateApiProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private BoxDeviceConfigChangeInfoReceiver_MembersInjector(Provider<IUserContextManager> provider, Provider<BoxApiPrivate> provider2) {
        this.mUserContextManagerProvider = provider;
        this.mPrivateApiProvider = provider2;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BoxDeviceConfigChangeInfoReceiver boxDeviceConfigChangeInfoReceiver) {
        injectMUserContextManager(boxDeviceConfigChangeInfoReceiver, this.mUserContextManagerProvider.get());
        injectMPrivateApi(boxDeviceConfigChangeInfoReceiver, this.mPrivateApiProvider.get());
    }

    public static MembersInjector<BoxDeviceConfigChangeInfoReceiver> create(Provider<IUserContextManager> provider, Provider<BoxApiPrivate> provider2) {
        return new BoxDeviceConfigChangeInfoReceiver_MembersInjector(provider, provider2);
    }

    public static void injectMUserContextManager(BoxDeviceConfigChangeInfoReceiver boxDeviceConfigChangeInfoReceiver, IUserContextManager iUserContextManager) {
        boxDeviceConfigChangeInfoReceiver.mUserContextManager = iUserContextManager;
    }

    public static void injectMPrivateApi(BoxDeviceConfigChangeInfoReceiver boxDeviceConfigChangeInfoReceiver, BoxApiPrivate boxApiPrivate) {
        boxDeviceConfigChangeInfoReceiver.mPrivateApi = boxApiPrivate;
    }
}
