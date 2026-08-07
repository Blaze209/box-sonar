package com.box.android.preview.previousversion;

import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability;
import com.box.android.domain.services.IFileVersionService;
import com.box.android.domain.services.IPreviousVersionPreviewService;
import com.box.android.preview.preview.PreviewAnalytics;
import com.box.android.preview.previewtype.document.DocumentPreviewEnvironment;
import com.box.android.preview.previewtype.image.ImagePreviewEnvironment;
import com.box.android.preview.previewtype.video.VideoPreviewEnvironment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionEnvironment;", "", "previousVersionPreviewService", "Lcom/box/android/domain/services/IPreviousVersionPreviewService;", "fileVersionService", "Lcom/box/android/domain/services/IFileVersionService;", "fileActionsManager", "Lcom/box/android/coreservices/utilities/FileActionsManager;", "documentPreviewEnvironment", "Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;", "imagePreviewEnvironment", "Lcom/box/android/preview/previewtype/image/ImagePreviewEnvironment;", "videoPreviewEnvironment", "Lcom/box/android/preview/previewtype/video/VideoPreviewEnvironment;", "analytics", "Lcom/box/android/preview/preview/PreviewAnalytics;", "observability", "Lcom/box/android/domain/metrics/preview/PreviousVersionPreviewObservability;", "<init>", "(Lcom/box/android/domain/services/IPreviousVersionPreviewService;Lcom/box/android/domain/services/IFileVersionService;Lcom/box/android/coreservices/utilities/FileActionsManager;Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;Lcom/box/android/preview/previewtype/image/ImagePreviewEnvironment;Lcom/box/android/preview/previewtype/video/VideoPreviewEnvironment;Lcom/box/android/preview/preview/PreviewAnalytics;Lcom/box/android/domain/metrics/preview/PreviousVersionPreviewObservability;)V", "getPreviousVersionPreviewService", "()Lcom/box/android/domain/services/IPreviousVersionPreviewService;", "getFileVersionService", "()Lcom/box/android/domain/services/IFileVersionService;", "getFileActionsManager", "()Lcom/box/android/coreservices/utilities/FileActionsManager;", "getDocumentPreviewEnvironment", "()Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;", "getImagePreviewEnvironment", "()Lcom/box/android/preview/previewtype/image/ImagePreviewEnvironment;", "getVideoPreviewEnvironment", "()Lcom/box/android/preview/previewtype/video/VideoPreviewEnvironment;", "getAnalytics", "()Lcom/box/android/preview/preview/PreviewAnalytics;", "getObservability", "()Lcom/box/android/domain/metrics/preview/PreviousVersionPreviewObservability;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviousVersionEnvironment {
    public static final int $stable = 8;
    private final PreviewAnalytics analytics;
    private final DocumentPreviewEnvironment documentPreviewEnvironment;
    private final FileActionsManager fileActionsManager;
    private final IFileVersionService fileVersionService;
    private final ImagePreviewEnvironment imagePreviewEnvironment;
    private final PreviousVersionPreviewObservability observability;
    private final IPreviousVersionPreviewService previousVersionPreviewService;
    private final VideoPreviewEnvironment videoPreviewEnvironment;

    @Inject
    public PreviousVersionEnvironment(IPreviousVersionPreviewService previousVersionPreviewService, IFileVersionService fileVersionService, FileActionsManager fileActionsManager, DocumentPreviewEnvironment documentPreviewEnvironment, ImagePreviewEnvironment imagePreviewEnvironment, VideoPreviewEnvironment videoPreviewEnvironment, PreviewAnalytics analytics, PreviousVersionPreviewObservability observability) {
        Intrinsics.checkNotNullParameter(previousVersionPreviewService, "previousVersionPreviewService");
        Intrinsics.checkNotNullParameter(fileVersionService, "fileVersionService");
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        Intrinsics.checkNotNullParameter(documentPreviewEnvironment, "documentPreviewEnvironment");
        Intrinsics.checkNotNullParameter(imagePreviewEnvironment, "imagePreviewEnvironment");
        Intrinsics.checkNotNullParameter(videoPreviewEnvironment, "videoPreviewEnvironment");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(observability, "observability");
        this.previousVersionPreviewService = previousVersionPreviewService;
        this.fileVersionService = fileVersionService;
        this.fileActionsManager = fileActionsManager;
        this.documentPreviewEnvironment = documentPreviewEnvironment;
        this.imagePreviewEnvironment = imagePreviewEnvironment;
        this.videoPreviewEnvironment = videoPreviewEnvironment;
        this.analytics = analytics;
        this.observability = observability;
    }

    public final IPreviousVersionPreviewService getPreviousVersionPreviewService() {
        return this.previousVersionPreviewService;
    }

    public final IFileVersionService getFileVersionService() {
        return this.fileVersionService;
    }

    public final FileActionsManager getFileActionsManager() {
        return this.fileActionsManager;
    }

    public final DocumentPreviewEnvironment getDocumentPreviewEnvironment() {
        return this.documentPreviewEnvironment;
    }

    public final ImagePreviewEnvironment getImagePreviewEnvironment() {
        return this.imagePreviewEnvironment;
    }

    public final VideoPreviewEnvironment getVideoPreviewEnvironment() {
        return this.videoPreviewEnvironment;
    }

    public final PreviewAnalytics getAnalytics() {
        return this.analytics;
    }

    public final PreviousVersionPreviewObservability getObservability() {
        return this.observability;
    }
}
