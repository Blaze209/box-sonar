package com.box.android.fileactivity.presentation;

import com.box.android.base.presentation.components.commentbar.CommentWithMentionsEnvironment;
import com.box.android.base.routing.preview.PreviewRouter;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
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
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivitiesReducer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001By\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J\t\u0010>\u001a\u00020\u000bHÆ\u0003J\t\u0010?\u001a\u00020\rHÆ\u0003J\t\u0010@\u001a\u00020\u000fHÆ\u0003J\t\u0010A\u001a\u00020\u000fHÆ\u0003J\t\u0010B\u001a\u00020\u0012HÆ\u0003J\t\u0010C\u001a\u00020\u0014HÆ\u0003J\t\u0010D\u001a\u00020\u0016HÆ\u0003J\t\u0010E\u001a\u00020\u0018HÆ\u0003J\t\u0010F\u001a\u00020\u001aHÆ\u0003J\t\u0010G\u001a\u00020\u001cHÆ\u0003J\u0095\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cHÆ\u0001J\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020MHÖ\u0001J\t\u0010N\u001a\u00020OHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b8\u00109¨\u0006P"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesEnvironment;", "", "getFileActivitiesInteractor", "Lcom/box/android/domain/usecases/fileactivities/GetFileActivitiesInteractor;", "previewRouter", "Lcom/box/android/base/routing/preview/PreviewRouter;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "createCommentInteractor", "Lcom/box/android/domain/usecases/fileactivities/comment/CreateCommentInteractor;", "updateCommentInteractor", "Lcom/box/android/domain/usecases/fileactivities/comment/UpdateCommentInteractor;", "deleteCommentInteractor", "Lcom/box/android/domain/usecases/fileactivities/comment/DeleteCommentInteractor;", "createReplyInteractor", "Lcom/box/android/domain/usecases/fileactivities/comment/CreateReplyInteractor;", "deleteReplyInteractor", "updateAnnotationInteractor", "Lcom/box/android/domain/usecases/fileactivities/annotation/UpdateAnnotationInteractor;", "deleteAnnotationInteractor", "Lcom/box/android/domain/usecases/fileactivities/annotation/DeleteAnnotationInteractor;", "fileActivityEventLogger", "Lcom/box/android/domain/metrics/Gen204FileActivityEventLogger;", "commentWithMentionsEnvironment", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsEnvironment;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "<init>", "(Lcom/box/android/domain/usecases/fileactivities/GetFileActivitiesInteractor;Lcom/box/android/base/routing/preview/PreviewRouter;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/domain/usecases/fileactivities/comment/CreateCommentInteractor;Lcom/box/android/domain/usecases/fileactivities/comment/UpdateCommentInteractor;Lcom/box/android/domain/usecases/fileactivities/comment/DeleteCommentInteractor;Lcom/box/android/domain/usecases/fileactivities/comment/CreateReplyInteractor;Lcom/box/android/domain/usecases/fileactivities/comment/CreateReplyInteractor;Lcom/box/android/domain/usecases/fileactivities/annotation/UpdateAnnotationInteractor;Lcom/box/android/domain/usecases/fileactivities/annotation/DeleteAnnotationInteractor;Lcom/box/android/domain/metrics/Gen204FileActivityEventLogger;Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsEnvironment;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/services/IRemoteItemService;)V", "getGetFileActivitiesInteractor", "()Lcom/box/android/domain/usecases/fileactivities/GetFileActivitiesInteractor;", "getPreviewRouter", "()Lcom/box/android/base/routing/preview/PreviewRouter;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "getCreateCommentInteractor", "()Lcom/box/android/domain/usecases/fileactivities/comment/CreateCommentInteractor;", "getUpdateCommentInteractor", "()Lcom/box/android/domain/usecases/fileactivities/comment/UpdateCommentInteractor;", "getDeleteCommentInteractor", "()Lcom/box/android/domain/usecases/fileactivities/comment/DeleteCommentInteractor;", "getCreateReplyInteractor", "()Lcom/box/android/domain/usecases/fileactivities/comment/CreateReplyInteractor;", "getDeleteReplyInteractor", "getUpdateAnnotationInteractor", "()Lcom/box/android/domain/usecases/fileactivities/annotation/UpdateAnnotationInteractor;", "getDeleteAnnotationInteractor", "()Lcom/box/android/domain/usecases/fileactivities/annotation/DeleteAnnotationInteractor;", "getFileActivityEventLogger", "()Lcom/box/android/domain/metrics/Gen204FileActivityEventLogger;", "getCommentWithMentionsEnvironment", "()Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsEnvironment;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "getItemService", "()Lcom/box/android/domain/services/IRemoteItemService;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileActivitiesEnvironment {
    public static final int $stable = 8;
    private final CommentWithMentionsEnvironment commentWithMentionsEnvironment;
    private final CreateCommentInteractor createCommentInteractor;
    private final CreateReplyInteractor createReplyInteractor;
    private final DeleteAnnotationInteractor deleteAnnotationInteractor;
    private final DeleteCommentInteractor deleteCommentInteractor;
    private final CreateReplyInteractor deleteReplyInteractor;
    private final FeatureFlips featureFlips;
    private final Gen204FileActivityEventLogger fileActivityEventLogger;
    private final GetFileActivitiesInteractor getFileActivitiesInteractor;
    private final IRemoteItemService itemService;
    private final PreviewRouter previewRouter;
    private final UpdateAnnotationInteractor updateAnnotationInteractor;
    private final UpdateCommentInteractor updateCommentInteractor;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GetFileActivitiesInteractor getGetFileActivitiesInteractor() {
        return this.getFileActivitiesInteractor;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final DeleteAnnotationInteractor getDeleteAnnotationInteractor() {
        return this.deleteAnnotationInteractor;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Gen204FileActivityEventLogger getFileActivityEventLogger() {
        return this.fileActivityEventLogger;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final CommentWithMentionsEnvironment getCommentWithMentionsEnvironment() {
        return this.commentWithMentionsEnvironment;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final IRemoteItemService getItemService() {
        return this.itemService;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PreviewRouter getPreviewRouter() {
        return this.previewRouter;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CreateCommentInteractor getCreateCommentInteractor() {
        return this.createCommentInteractor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final UpdateCommentInteractor getUpdateCommentInteractor() {
        return this.updateCommentInteractor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DeleteCommentInteractor getDeleteCommentInteractor() {
        return this.deleteCommentInteractor;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final CreateReplyInteractor getCreateReplyInteractor() {
        return this.createReplyInteractor;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final CreateReplyInteractor getDeleteReplyInteractor() {
        return this.deleteReplyInteractor;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final UpdateAnnotationInteractor getUpdateAnnotationInteractor() {
        return this.updateAnnotationInteractor;
    }

    public final FileActivitiesEnvironment copy(GetFileActivitiesInteractor getFileActivitiesInteractor, PreviewRouter previewRouter, IUserContextManager userContextManager, CreateCommentInteractor createCommentInteractor, UpdateCommentInteractor updateCommentInteractor, DeleteCommentInteractor deleteCommentInteractor, CreateReplyInteractor createReplyInteractor, CreateReplyInteractor deleteReplyInteractor, UpdateAnnotationInteractor updateAnnotationInteractor, DeleteAnnotationInteractor deleteAnnotationInteractor, Gen204FileActivityEventLogger fileActivityEventLogger, CommentWithMentionsEnvironment commentWithMentionsEnvironment, FeatureFlips featureFlips, IRemoteItemService itemService) {
        Intrinsics.checkNotNullParameter(getFileActivitiesInteractor, "getFileActivitiesInteractor");
        Intrinsics.checkNotNullParameter(previewRouter, "previewRouter");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(createCommentInteractor, "createCommentInteractor");
        Intrinsics.checkNotNullParameter(updateCommentInteractor, "updateCommentInteractor");
        Intrinsics.checkNotNullParameter(deleteCommentInteractor, "deleteCommentInteractor");
        Intrinsics.checkNotNullParameter(createReplyInteractor, "createReplyInteractor");
        Intrinsics.checkNotNullParameter(deleteReplyInteractor, "deleteReplyInteractor");
        Intrinsics.checkNotNullParameter(updateAnnotationInteractor, "updateAnnotationInteractor");
        Intrinsics.checkNotNullParameter(deleteAnnotationInteractor, "deleteAnnotationInteractor");
        Intrinsics.checkNotNullParameter(fileActivityEventLogger, "fileActivityEventLogger");
        Intrinsics.checkNotNullParameter(commentWithMentionsEnvironment, "commentWithMentionsEnvironment");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        return new FileActivitiesEnvironment(getFileActivitiesInteractor, previewRouter, userContextManager, createCommentInteractor, updateCommentInteractor, deleteCommentInteractor, createReplyInteractor, deleteReplyInteractor, updateAnnotationInteractor, deleteAnnotationInteractor, fileActivityEventLogger, commentWithMentionsEnvironment, featureFlips, itemService);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileActivitiesEnvironment)) {
            return false;
        }
        FileActivitiesEnvironment fileActivitiesEnvironment = (FileActivitiesEnvironment) other;
        return Intrinsics.areEqual(this.getFileActivitiesInteractor, fileActivitiesEnvironment.getFileActivitiesInteractor) && Intrinsics.areEqual(this.previewRouter, fileActivitiesEnvironment.previewRouter) && Intrinsics.areEqual(this.userContextManager, fileActivitiesEnvironment.userContextManager) && Intrinsics.areEqual(this.createCommentInteractor, fileActivitiesEnvironment.createCommentInteractor) && Intrinsics.areEqual(this.updateCommentInteractor, fileActivitiesEnvironment.updateCommentInteractor) && Intrinsics.areEqual(this.deleteCommentInteractor, fileActivitiesEnvironment.deleteCommentInteractor) && Intrinsics.areEqual(this.createReplyInteractor, fileActivitiesEnvironment.createReplyInteractor) && Intrinsics.areEqual(this.deleteReplyInteractor, fileActivitiesEnvironment.deleteReplyInteractor) && Intrinsics.areEqual(this.updateAnnotationInteractor, fileActivitiesEnvironment.updateAnnotationInteractor) && Intrinsics.areEqual(this.deleteAnnotationInteractor, fileActivitiesEnvironment.deleteAnnotationInteractor) && Intrinsics.areEqual(this.fileActivityEventLogger, fileActivitiesEnvironment.fileActivityEventLogger) && Intrinsics.areEqual(this.commentWithMentionsEnvironment, fileActivitiesEnvironment.commentWithMentionsEnvironment) && Intrinsics.areEqual(this.featureFlips, fileActivitiesEnvironment.featureFlips) && Intrinsics.areEqual(this.itemService, fileActivitiesEnvironment.itemService);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.getFileActivitiesInteractor.hashCode() * 31) + this.previewRouter.hashCode()) * 31) + this.userContextManager.hashCode()) * 31) + this.createCommentInteractor.hashCode()) * 31) + this.updateCommentInteractor.hashCode()) * 31) + this.deleteCommentInteractor.hashCode()) * 31) + this.createReplyInteractor.hashCode()) * 31) + this.deleteReplyInteractor.hashCode()) * 31) + this.updateAnnotationInteractor.hashCode()) * 31) + this.deleteAnnotationInteractor.hashCode()) * 31) + this.fileActivityEventLogger.hashCode()) * 31) + this.commentWithMentionsEnvironment.hashCode()) * 31) + this.featureFlips.hashCode()) * 31) + this.itemService.hashCode();
    }

    public String toString() {
        return "FileActivitiesEnvironment(getFileActivitiesInteractor=" + this.getFileActivitiesInteractor + ", previewRouter=" + this.previewRouter + ", userContextManager=" + this.userContextManager + ", createCommentInteractor=" + this.createCommentInteractor + ", updateCommentInteractor=" + this.updateCommentInteractor + ", deleteCommentInteractor=" + this.deleteCommentInteractor + ", createReplyInteractor=" + this.createReplyInteractor + ", deleteReplyInteractor=" + this.deleteReplyInteractor + ", updateAnnotationInteractor=" + this.updateAnnotationInteractor + ", deleteAnnotationInteractor=" + this.deleteAnnotationInteractor + ", fileActivityEventLogger=" + this.fileActivityEventLogger + ", commentWithMentionsEnvironment=" + this.commentWithMentionsEnvironment + ", featureFlips=" + this.featureFlips + ", itemService=" + this.itemService + ")";
    }

    @Inject
    public FileActivitiesEnvironment(GetFileActivitiesInteractor getFileActivitiesInteractor, PreviewRouter previewRouter, IUserContextManager userContextManager, CreateCommentInteractor createCommentInteractor, UpdateCommentInteractor updateCommentInteractor, DeleteCommentInteractor deleteCommentInteractor, CreateReplyInteractor createReplyInteractor, CreateReplyInteractor deleteReplyInteractor, UpdateAnnotationInteractor updateAnnotationInteractor, DeleteAnnotationInteractor deleteAnnotationInteractor, Gen204FileActivityEventLogger fileActivityEventLogger, CommentWithMentionsEnvironment commentWithMentionsEnvironment, FeatureFlips featureFlips, IRemoteItemService itemService) {
        Intrinsics.checkNotNullParameter(getFileActivitiesInteractor, "getFileActivitiesInteractor");
        Intrinsics.checkNotNullParameter(previewRouter, "previewRouter");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(createCommentInteractor, "createCommentInteractor");
        Intrinsics.checkNotNullParameter(updateCommentInteractor, "updateCommentInteractor");
        Intrinsics.checkNotNullParameter(deleteCommentInteractor, "deleteCommentInteractor");
        Intrinsics.checkNotNullParameter(createReplyInteractor, "createReplyInteractor");
        Intrinsics.checkNotNullParameter(deleteReplyInteractor, "deleteReplyInteractor");
        Intrinsics.checkNotNullParameter(updateAnnotationInteractor, "updateAnnotationInteractor");
        Intrinsics.checkNotNullParameter(deleteAnnotationInteractor, "deleteAnnotationInteractor");
        Intrinsics.checkNotNullParameter(fileActivityEventLogger, "fileActivityEventLogger");
        Intrinsics.checkNotNullParameter(commentWithMentionsEnvironment, "commentWithMentionsEnvironment");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        this.getFileActivitiesInteractor = getFileActivitiesInteractor;
        this.previewRouter = previewRouter;
        this.userContextManager = userContextManager;
        this.createCommentInteractor = createCommentInteractor;
        this.updateCommentInteractor = updateCommentInteractor;
        this.deleteCommentInteractor = deleteCommentInteractor;
        this.createReplyInteractor = createReplyInteractor;
        this.deleteReplyInteractor = deleteReplyInteractor;
        this.updateAnnotationInteractor = updateAnnotationInteractor;
        this.deleteAnnotationInteractor = deleteAnnotationInteractor;
        this.fileActivityEventLogger = fileActivityEventLogger;
        this.commentWithMentionsEnvironment = commentWithMentionsEnvironment;
        this.featureFlips = featureFlips;
        this.itemService = itemService;
    }

    public final GetFileActivitiesInteractor getGetFileActivitiesInteractor() {
        return this.getFileActivitiesInteractor;
    }

    public final PreviewRouter getPreviewRouter() {
        return this.previewRouter;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final CreateCommentInteractor getCreateCommentInteractor() {
        return this.createCommentInteractor;
    }

    public final UpdateCommentInteractor getUpdateCommentInteractor() {
        return this.updateCommentInteractor;
    }

    public final DeleteCommentInteractor getDeleteCommentInteractor() {
        return this.deleteCommentInteractor;
    }

    public final CreateReplyInteractor getCreateReplyInteractor() {
        return this.createReplyInteractor;
    }

    public final CreateReplyInteractor getDeleteReplyInteractor() {
        return this.deleteReplyInteractor;
    }

    public final UpdateAnnotationInteractor getUpdateAnnotationInteractor() {
        return this.updateAnnotationInteractor;
    }

    public final DeleteAnnotationInteractor getDeleteAnnotationInteractor() {
        return this.deleteAnnotationInteractor;
    }

    public final Gen204FileActivityEventLogger getFileActivityEventLogger() {
        return this.fileActivityEventLogger;
    }

    public final CommentWithMentionsEnvironment getCommentWithMentionsEnvironment() {
        return this.commentWithMentionsEnvironment;
    }

    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }

    public final IRemoteItemService getItemService() {
        return this.itemService;
    }
}
