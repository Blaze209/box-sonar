package com.box.android.receiver;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class CommentsReplyReceiver_MembersInjector implements MembersInjector<CommentsReplyReceiver> {
    private final Provider<BoxApiPrivate> mApiPrivateProvider;
    private final Provider<IBaseModelController> mBaseModelControllerProvider;
    private final Provider<BoxExtendedApiFile> mFileApiProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private CommentsReplyReceiver_MembersInjector(Provider<BoxExtendedApiFile> provider, Provider<IBaseModelController> provider2, Provider<IUserContextManager> provider3, Provider<BoxApiPrivate> provider4) {
        this.mFileApiProvider = provider;
        this.mBaseModelControllerProvider = provider2;
        this.mUserContextManagerProvider = provider3;
        this.mApiPrivateProvider = provider4;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CommentsReplyReceiver commentsReplyReceiver) {
        injectMFileApi(commentsReplyReceiver, this.mFileApiProvider.get());
        injectMBaseModelController(commentsReplyReceiver, this.mBaseModelControllerProvider.get());
        injectMUserContextManager(commentsReplyReceiver, this.mUserContextManagerProvider.get());
        injectMApiPrivate(commentsReplyReceiver, this.mApiPrivateProvider.get());
    }

    public static MembersInjector<CommentsReplyReceiver> create(Provider<BoxExtendedApiFile> provider, Provider<IBaseModelController> provider2, Provider<IUserContextManager> provider3, Provider<BoxApiPrivate> provider4) {
        return new CommentsReplyReceiver_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectMFileApi(CommentsReplyReceiver commentsReplyReceiver, BoxExtendedApiFile boxExtendedApiFile) {
        commentsReplyReceiver.mFileApi = boxExtendedApiFile;
    }

    public static void injectMBaseModelController(CommentsReplyReceiver commentsReplyReceiver, IBaseModelController iBaseModelController) {
        commentsReplyReceiver.mBaseModelController = iBaseModelController;
    }

    public static void injectMUserContextManager(CommentsReplyReceiver commentsReplyReceiver, IUserContextManager iUserContextManager) {
        commentsReplyReceiver.mUserContextManager = iUserContextManager;
    }

    public static void injectMApiPrivate(CommentsReplyReceiver commentsReplyReceiver, BoxApiPrivate boxApiPrivate) {
        commentsReplyReceiver.mApiPrivate = boxApiPrivate;
    }
}
