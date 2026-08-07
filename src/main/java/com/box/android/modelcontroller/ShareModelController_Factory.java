package com.box.android.modelcontroller;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.requests.BoxApiFeatures;
import com.box.android.requests.BoxApiInvitee;
import com.box.androidsdk.content.BoxApiBookmark;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollaboration;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class ShareModelController_Factory implements Factory<ShareModelController> {
    private final Provider<BoxApiBookmark> bookmarkApiProvider;
    private final Provider<BoxExtendedApiCollaboration> collabApiProvider;
    private final Provider<Context> contextProvider;
    private final Provider<BoxApiFeatures> featuresApiProvider;
    private final Provider<BoxExtendedApiFile> fileApiProvider;
    private final Provider<BoxExtendedApiFolder> folderApiProvider;
    private final Provider<BoxApiInvitee> inviteeApiProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private ShareModelController_Factory(Provider<IUserContextManager> provider, Provider<Context> provider2, Provider<BoxExtendedApiFolder> provider3, Provider<BoxExtendedApiFile> provider4, Provider<BoxApiBookmark> provider5, Provider<BoxApiInvitee> provider6, Provider<BoxExtendedApiCollaboration> provider7, Provider<BoxApiFeatures> provider8) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
        this.folderApiProvider = provider3;
        this.fileApiProvider = provider4;
        this.bookmarkApiProvider = provider5;
        this.inviteeApiProvider = provider6;
        this.collabApiProvider = provider7;
        this.featuresApiProvider = provider8;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ShareModelController get() {
        return newInstance(this.userContextManagerProvider.get(), this.contextProvider.get(), this.folderApiProvider.get(), this.fileApiProvider.get(), this.bookmarkApiProvider.get(), this.inviteeApiProvider.get(), this.collabApiProvider.get(), this.featuresApiProvider.get());
    }

    public static ShareModelController_Factory create(Provider<IUserContextManager> provider, Provider<Context> provider2, Provider<BoxExtendedApiFolder> provider3, Provider<BoxExtendedApiFile> provider4, Provider<BoxApiBookmark> provider5, Provider<BoxApiInvitee> provider6, Provider<BoxExtendedApiCollaboration> provider7, Provider<BoxApiFeatures> provider8) {
        return new ShareModelController_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ShareModelController newInstance(IUserContextManager iUserContextManager, Context context, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiFile boxExtendedApiFile, BoxApiBookmark boxApiBookmark, BoxApiInvitee boxApiInvitee, BoxExtendedApiCollaboration boxExtendedApiCollaboration, BoxApiFeatures boxApiFeatures) {
        return new ShareModelController(iUserContextManager, context, boxExtendedApiFolder, boxExtendedApiFile, boxApiBookmark, boxApiInvitee, boxExtendedApiCollaboration, boxApiFeatures);
    }
}
