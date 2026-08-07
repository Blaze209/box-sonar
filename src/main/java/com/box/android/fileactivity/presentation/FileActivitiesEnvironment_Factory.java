package com.box.android.fileactivity.presentation;

import com.box.android.base.presentation.components.commentbar.CommentWithMentionsEnvironment;
import com.box.android.base.routing.preview.PreviewRouter;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.usecases.fileactivities.GetFileActivitiesInteractor;
import com.box.android.domain.usecases.fileactivities.annotation.DeleteAnnotationInteractor;
import com.box.android.domain.usecases.fileactivities.annotation.UpdateAnnotationInteractor;
import com.box.android.domain.usecases.fileactivities.comment.CreateCommentInteractor;
import com.box.android.domain.usecases.fileactivities.comment.CreateReplyInteractor;
import com.box.android.domain.usecases.fileactivities.comment.DeleteCommentInteractor;
import com.box.android.domain.usecases.fileactivities.comment.UpdateCommentInteractor;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FileActivitiesEnvironment_Factory implements Factory<FileActivitiesEnvironment> {
    private final Provider<CommentWithMentionsEnvironment> commentWithMentionsEnvironmentProvider;
    private final Provider<CreateCommentInteractor> createCommentInteractorProvider;
    private final Provider<CreateReplyInteractor> createReplyInteractorProvider;
    private final Provider<DeleteAnnotationInteractor> deleteAnnotationInteractorProvider;
    private final Provider<DeleteCommentInteractor> deleteCommentInteractorProvider;
    private final Provider<CreateReplyInteractor> deleteReplyInteractorProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<Gen204FileActivityEventLogger> fileActivityEventLoggerProvider;
    private final Provider<GetFileActivitiesInteractor> getFileActivitiesInteractorProvider;
    private final Provider<IRemoteItemService> itemServiceProvider;
    private final Provider<PreviewRouter> previewRouterProvider;
    private final Provider<UpdateAnnotationInteractor> updateAnnotationInteractorProvider;
    private final Provider<UpdateCommentInteractor> updateCommentInteractorProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private FileActivitiesEnvironment_Factory(Provider<GetFileActivitiesInteractor> provider, Provider<PreviewRouter> provider2, Provider<IUserContextManager> provider3, Provider<CreateCommentInteractor> provider4, Provider<UpdateCommentInteractor> provider5, Provider<DeleteCommentInteractor> provider6, Provider<CreateReplyInteractor> provider7, Provider<CreateReplyInteractor> provider8, Provider<UpdateAnnotationInteractor> provider9, Provider<DeleteAnnotationInteractor> provider10, Provider<Gen204FileActivityEventLogger> provider11, Provider<CommentWithMentionsEnvironment> provider12, Provider<FeatureFlips> provider13, Provider<IRemoteItemService> provider14) {
        this.getFileActivitiesInteractorProvider = provider;
        this.previewRouterProvider = provider2;
        this.userContextManagerProvider = provider3;
        this.createCommentInteractorProvider = provider4;
        this.updateCommentInteractorProvider = provider5;
        this.deleteCommentInteractorProvider = provider6;
        this.createReplyInteractorProvider = provider7;
        this.deleteReplyInteractorProvider = provider8;
        this.updateAnnotationInteractorProvider = provider9;
        this.deleteAnnotationInteractorProvider = provider10;
        this.fileActivityEventLoggerProvider = provider11;
        this.commentWithMentionsEnvironmentProvider = provider12;
        this.featureFlipsProvider = provider13;
        this.itemServiceProvider = provider14;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileActivitiesEnvironment get() {
        return newInstance(this.getFileActivitiesInteractorProvider.get(), this.previewRouterProvider.get(), this.userContextManagerProvider.get(), this.createCommentInteractorProvider.get(), this.updateCommentInteractorProvider.get(), this.deleteCommentInteractorProvider.get(), this.createReplyInteractorProvider.get(), this.deleteReplyInteractorProvider.get(), this.updateAnnotationInteractorProvider.get(), this.deleteAnnotationInteractorProvider.get(), this.fileActivityEventLoggerProvider.get(), this.commentWithMentionsEnvironmentProvider.get(), this.featureFlipsProvider.get(), this.itemServiceProvider.get());
    }

    public static FileActivitiesEnvironment_Factory create(Provider<GetFileActivitiesInteractor> provider, Provider<PreviewRouter> provider2, Provider<IUserContextManager> provider3, Provider<CreateCommentInteractor> provider4, Provider<UpdateCommentInteractor> provider5, Provider<DeleteCommentInteractor> provider6, Provider<CreateReplyInteractor> provider7, Provider<CreateReplyInteractor> provider8, Provider<UpdateAnnotationInteractor> provider9, Provider<DeleteAnnotationInteractor> provider10, Provider<Gen204FileActivityEventLogger> provider11, Provider<CommentWithMentionsEnvironment> provider12, Provider<FeatureFlips> provider13, Provider<IRemoteItemService> provider14) {
        return new FileActivitiesEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    public static FileActivitiesEnvironment newInstance(GetFileActivitiesInteractor getFileActivitiesInteractor, PreviewRouter previewRouter, IUserContextManager iUserContextManager, CreateCommentInteractor createCommentInteractor, UpdateCommentInteractor updateCommentInteractor, DeleteCommentInteractor deleteCommentInteractor, CreateReplyInteractor createReplyInteractor, CreateReplyInteractor createReplyInteractor2, UpdateAnnotationInteractor updateAnnotationInteractor, DeleteAnnotationInteractor deleteAnnotationInteractor, Gen204FileActivityEventLogger gen204FileActivityEventLogger, CommentWithMentionsEnvironment commentWithMentionsEnvironment, FeatureFlips featureFlips, IRemoteItemService iRemoteItemService) {
        return new FileActivitiesEnvironment(getFileActivitiesInteractor, previewRouter, iUserContextManager, createCommentInteractor, updateCommentInteractor, deleteCommentInteractor, createReplyInteractor, createReplyInteractor2, updateAnnotationInteractor, deleteAnnotationInteractor, gen204FileActivityEventLogger, commentWithMentionsEnvironment, featureFlips, iRemoteItemService);
    }
}
