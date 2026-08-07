package com.box.android.preview.fileactions;

import com.box.android.base.cpl.DeleteEnvironment;
import com.box.android.base.cpl.EndCollaborationEnvironment;
import com.box.android.base.presentation.components.fileactions.DownloadEnvironment;
import com.box.android.base.presentation.components.fileactions.OfflineFilesEnvironment;
import com.box.android.boxai.BoxAiEnvironment;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.services.IOfflineService;
import com.box.android.preview.fileactions.copylink.CopyLinkEnvironment;
import com.box.android.preview.fileactions.openin.OpenInEnvironment;
import com.box.android.preview.preview.PreviewAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActionsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001Bq\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsEnvironment;", "", "fileActionsManager", "Lcom/box/android/coreservices/utilities/FileActionsManager;", "offlineService", "Lcom/box/android/domain/services/IOfflineService;", "copyLinkEnvironment", "Lcom/box/android/preview/fileactions/copylink/CopyLinkEnvironment;", "deleteEnvironment", "Lcom/box/android/base/cpl/DeleteEnvironment;", "endCollaborationEnvironment", "Lcom/box/android/base/cpl/EndCollaborationEnvironment;", "updateItemInfoEnvironment", "Lcom/box/android/preview/fileactions/UpdateItemInfoEnvironment;", "openInEnvironment", "Lcom/box/android/preview/fileactions/openin/OpenInEnvironment;", "downloadEnvironment", "Lcom/box/android/base/presentation/components/fileactions/DownloadEnvironment;", "offlineFilesEnvironment", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesEnvironment;", "boxAiEnvironment", "Lcom/box/android/boxai/BoxAiEnvironment;", "analytics", "Lcom/box/android/preview/preview/PreviewAnalytics;", "boxModelOfflineManagerWrapper", "Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/coreservices/utilities/FileActionsManager;Lcom/box/android/domain/services/IOfflineService;Lcom/box/android/preview/fileactions/copylink/CopyLinkEnvironment;Lcom/box/android/base/cpl/DeleteEnvironment;Lcom/box/android/base/cpl/EndCollaborationEnvironment;Lcom/box/android/preview/fileactions/UpdateItemInfoEnvironment;Lcom/box/android/preview/fileactions/openin/OpenInEnvironment;Lcom/box/android/base/presentation/components/fileactions/DownloadEnvironment;Lcom/box/android/base/presentation/components/fileactions/OfflineFilesEnvironment;Lcom/box/android/boxai/BoxAiEnvironment;Lcom/box/android/preview/preview/PreviewAnalytics;Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;Lcom/box/android/domain/configuration/FeatureFlips;)V", "getFileActionsManager", "()Lcom/box/android/coreservices/utilities/FileActionsManager;", "getOfflineService", "()Lcom/box/android/domain/services/IOfflineService;", "getCopyLinkEnvironment", "()Lcom/box/android/preview/fileactions/copylink/CopyLinkEnvironment;", "getDeleteEnvironment", "()Lcom/box/android/base/cpl/DeleteEnvironment;", "getEndCollaborationEnvironment", "()Lcom/box/android/base/cpl/EndCollaborationEnvironment;", "getUpdateItemInfoEnvironment", "()Lcom/box/android/preview/fileactions/UpdateItemInfoEnvironment;", "getOpenInEnvironment", "()Lcom/box/android/preview/fileactions/openin/OpenInEnvironment;", "getDownloadEnvironment", "()Lcom/box/android/base/presentation/components/fileactions/DownloadEnvironment;", "getOfflineFilesEnvironment", "()Lcom/box/android/base/presentation/components/fileactions/OfflineFilesEnvironment;", "getBoxAiEnvironment", "()Lcom/box/android/boxai/BoxAiEnvironment;", "getAnalytics", "()Lcom/box/android/preview/preview/PreviewAnalytics;", "getBoxModelOfflineManagerWrapper", "()Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActionsEnvironment {
    public static final int $stable = 8;
    private final PreviewAnalytics analytics;
    private final BoxAiEnvironment boxAiEnvironment;
    private final BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper;
    private final CopyLinkEnvironment copyLinkEnvironment;
    private final DeleteEnvironment deleteEnvironment;
    private final DownloadEnvironment downloadEnvironment;
    private final EndCollaborationEnvironment endCollaborationEnvironment;
    private final FeatureFlips featureFlips;
    private final FileActionsManager fileActionsManager;
    private final OfflineFilesEnvironment offlineFilesEnvironment;
    private final IOfflineService offlineService;
    private final OpenInEnvironment openInEnvironment;
    private final UpdateItemInfoEnvironment updateItemInfoEnvironment;

    @Inject
    public FileActionsEnvironment(FileActionsManager fileActionsManager, IOfflineService offlineService, CopyLinkEnvironment copyLinkEnvironment, DeleteEnvironment deleteEnvironment, EndCollaborationEnvironment endCollaborationEnvironment, UpdateItemInfoEnvironment updateItemInfoEnvironment, OpenInEnvironment openInEnvironment, DownloadEnvironment downloadEnvironment, OfflineFilesEnvironment offlineFilesEnvironment, BoxAiEnvironment boxAiEnvironment, PreviewAnalytics analytics, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        Intrinsics.checkNotNullParameter(offlineService, "offlineService");
        Intrinsics.checkNotNullParameter(copyLinkEnvironment, "copyLinkEnvironment");
        Intrinsics.checkNotNullParameter(deleteEnvironment, "deleteEnvironment");
        Intrinsics.checkNotNullParameter(endCollaborationEnvironment, "endCollaborationEnvironment");
        Intrinsics.checkNotNullParameter(updateItemInfoEnvironment, "updateItemInfoEnvironment");
        Intrinsics.checkNotNullParameter(openInEnvironment, "openInEnvironment");
        Intrinsics.checkNotNullParameter(downloadEnvironment, "downloadEnvironment");
        Intrinsics.checkNotNullParameter(offlineFilesEnvironment, "offlineFilesEnvironment");
        Intrinsics.checkNotNullParameter(boxAiEnvironment, "boxAiEnvironment");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(boxModelOfflineManagerWrapper, "boxModelOfflineManagerWrapper");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.fileActionsManager = fileActionsManager;
        this.offlineService = offlineService;
        this.copyLinkEnvironment = copyLinkEnvironment;
        this.deleteEnvironment = deleteEnvironment;
        this.endCollaborationEnvironment = endCollaborationEnvironment;
        this.updateItemInfoEnvironment = updateItemInfoEnvironment;
        this.openInEnvironment = openInEnvironment;
        this.downloadEnvironment = downloadEnvironment;
        this.offlineFilesEnvironment = offlineFilesEnvironment;
        this.boxAiEnvironment = boxAiEnvironment;
        this.analytics = analytics;
        this.boxModelOfflineManagerWrapper = boxModelOfflineManagerWrapper;
        this.featureFlips = featureFlips;
    }

    public final FileActionsManager getFileActionsManager() {
        return this.fileActionsManager;
    }

    public final IOfflineService getOfflineService() {
        return this.offlineService;
    }

    public final CopyLinkEnvironment getCopyLinkEnvironment() {
        return this.copyLinkEnvironment;
    }

    public final DeleteEnvironment getDeleteEnvironment() {
        return this.deleteEnvironment;
    }

    public final EndCollaborationEnvironment getEndCollaborationEnvironment() {
        return this.endCollaborationEnvironment;
    }

    public final UpdateItemInfoEnvironment getUpdateItemInfoEnvironment() {
        return this.updateItemInfoEnvironment;
    }

    public final OpenInEnvironment getOpenInEnvironment() {
        return this.openInEnvironment;
    }

    public final DownloadEnvironment getDownloadEnvironment() {
        return this.downloadEnvironment;
    }

    public final OfflineFilesEnvironment getOfflineFilesEnvironment() {
        return this.offlineFilesEnvironment;
    }

    public final BoxAiEnvironment getBoxAiEnvironment() {
        return this.boxAiEnvironment;
    }

    public final PreviewAnalytics getAnalytics() {
        return this.analytics;
    }

    public final BoxModelOfflineManagerWrapper getBoxModelOfflineManagerWrapper() {
        return this.boxModelOfflineManagerWrapper;
    }

    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }
}
