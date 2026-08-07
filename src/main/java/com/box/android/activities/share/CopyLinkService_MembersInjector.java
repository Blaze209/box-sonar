package com.box.android.activities.share;

import com.box.android.coreservices.api.ShareController;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class CopyLinkService_MembersInjector implements MembersInjector<CopyLinkService> {
    private final Provider<ShareController> mControllerProvider;

    private CopyLinkService_MembersInjector(Provider<ShareController> provider) {
        this.mControllerProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CopyLinkService copyLinkService) {
        injectMController(copyLinkService, this.mControllerProvider.get());
    }

    public static MembersInjector<CopyLinkService> create(Provider<ShareController> provider) {
        return new CopyLinkService_MembersInjector(provider);
    }

    public static void injectMController(CopyLinkService copyLinkService, ShareController shareController) {
        copyLinkService.mController = shareController;
    }
}
