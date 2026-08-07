package com.box.android.preview.previewtype.video;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.preview.annotations.cpl.AnnotationsEnvironment;
import com.box.android.preview.annotations.cpl.CreateAnnotationEnvironment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameAnnotationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationEnvironment;", "", "videoPlayersInteractor", "Lcom/box/android/preview/previewtype/video/VideoPlayerInteractor;", "createAnnotationEnvironment", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationEnvironment;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "frameExporter", "Lcom/box/android/preview/previewtype/video/FrameExporter;", "annotationsEnvironment", "Lcom/box/android/preview/annotations/cpl/AnnotationsEnvironment;", "<init>", "(Lcom/box/android/preview/previewtype/video/VideoPlayerInteractor;Lcom/box/android/preview/annotations/cpl/CreateAnnotationEnvironment;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/preview/previewtype/video/FrameExporter;Lcom/box/android/preview/annotations/cpl/AnnotationsEnvironment;)V", "getVideoPlayersInteractor", "()Lcom/box/android/preview/previewtype/video/VideoPlayerInteractor;", "getCreateAnnotationEnvironment", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationEnvironment;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "getFrameExporter", "()Lcom/box/android/preview/previewtype/video/FrameExporter;", "getAnnotationsEnvironment", "()Lcom/box/android/preview/annotations/cpl/AnnotationsEnvironment;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FrameAnnotationEnvironment {
    public static final int $stable = 8;
    private final AnnotationsEnvironment annotationsEnvironment;
    private final CreateAnnotationEnvironment createAnnotationEnvironment;
    private final FrameExporter frameExporter;
    private final IUserContextManager userContextManager;
    private final VideoPlayerInteractor videoPlayersInteractor;

    @Inject
    public FrameAnnotationEnvironment(VideoPlayerInteractor videoPlayersInteractor, CreateAnnotationEnvironment createAnnotationEnvironment, IUserContextManager userContextManager, FrameExporter frameExporter, AnnotationsEnvironment annotationsEnvironment) {
        Intrinsics.checkNotNullParameter(videoPlayersInteractor, "videoPlayersInteractor");
        Intrinsics.checkNotNullParameter(createAnnotationEnvironment, "createAnnotationEnvironment");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(frameExporter, "frameExporter");
        Intrinsics.checkNotNullParameter(annotationsEnvironment, "annotationsEnvironment");
        this.videoPlayersInteractor = videoPlayersInteractor;
        this.createAnnotationEnvironment = createAnnotationEnvironment;
        this.userContextManager = userContextManager;
        this.frameExporter = frameExporter;
        this.annotationsEnvironment = annotationsEnvironment;
    }

    public final VideoPlayerInteractor getVideoPlayersInteractor() {
        return this.videoPlayersInteractor;
    }

    public final CreateAnnotationEnvironment getCreateAnnotationEnvironment() {
        return this.createAnnotationEnvironment;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final FrameExporter getFrameExporter() {
        return this.frameExporter;
    }

    public final AnnotationsEnvironment getAnnotationsEnvironment() {
        return this.annotationsEnvironment;
    }
}
