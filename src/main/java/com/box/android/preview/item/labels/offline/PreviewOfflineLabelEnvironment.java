package com.box.android.preview.item.labels.offline;

import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.services.IOfflineService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelEnvironment;", "", "fileActionsManager", "Lcom/box/android/coreservices/utilities/FileActionsManager;", "offlineService", "Lcom/box/android/domain/services/IOfflineService;", "boxModelOfflineManagerWrapper", "Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "<init>", "(Lcom/box/android/coreservices/utilities/FileActionsManager;Lcom/box/android/domain/services/IOfflineService;Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;)V", "getFileActionsManager", "()Lcom/box/android/coreservices/utilities/FileActionsManager;", "getOfflineService", "()Lcom/box/android/domain/services/IOfflineService;", "getBoxModelOfflineManagerWrapper", "()Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PreviewOfflineLabelEnvironment {
    public static final int $stable = 8;
    private final BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper;
    private final FileActionsManager fileActionsManager;
    private final IOfflineService offlineService;

    public static /* synthetic */ PreviewOfflineLabelEnvironment copy$default(PreviewOfflineLabelEnvironment previewOfflineLabelEnvironment, FileActionsManager fileActionsManager, IOfflineService iOfflineService, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, int i, Object obj) {
        if ((i & 1) != 0) {
            fileActionsManager = previewOfflineLabelEnvironment.fileActionsManager;
        }
        if ((i & 2) != 0) {
            iOfflineService = previewOfflineLabelEnvironment.offlineService;
        }
        if ((i & 4) != 0) {
            boxModelOfflineManagerWrapper = previewOfflineLabelEnvironment.boxModelOfflineManagerWrapper;
        }
        return previewOfflineLabelEnvironment.copy(fileActionsManager, iOfflineService, boxModelOfflineManagerWrapper);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FileActionsManager getFileActionsManager() {
        return this.fileActionsManager;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IOfflineService getOfflineService() {
        return this.offlineService;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final BoxModelOfflineManagerWrapper getBoxModelOfflineManagerWrapper() {
        return this.boxModelOfflineManagerWrapper;
    }

    public final PreviewOfflineLabelEnvironment copy(FileActionsManager fileActionsManager, IOfflineService offlineService, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper) {
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        Intrinsics.checkNotNullParameter(offlineService, "offlineService");
        Intrinsics.checkNotNullParameter(boxModelOfflineManagerWrapper, "boxModelOfflineManagerWrapper");
        return new PreviewOfflineLabelEnvironment(fileActionsManager, offlineService, boxModelOfflineManagerWrapper);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewOfflineLabelEnvironment)) {
            return false;
        }
        PreviewOfflineLabelEnvironment previewOfflineLabelEnvironment = (PreviewOfflineLabelEnvironment) other;
        return Intrinsics.areEqual(this.fileActionsManager, previewOfflineLabelEnvironment.fileActionsManager) && Intrinsics.areEqual(this.offlineService, previewOfflineLabelEnvironment.offlineService) && Intrinsics.areEqual(this.boxModelOfflineManagerWrapper, previewOfflineLabelEnvironment.boxModelOfflineManagerWrapper);
    }

    public int hashCode() {
        return (((this.fileActionsManager.hashCode() * 31) + this.offlineService.hashCode()) * 31) + this.boxModelOfflineManagerWrapper.hashCode();
    }

    public String toString() {
        return "PreviewOfflineLabelEnvironment(fileActionsManager=" + this.fileActionsManager + ", offlineService=" + this.offlineService + ", boxModelOfflineManagerWrapper=" + this.boxModelOfflineManagerWrapper + ")";
    }

    @Inject
    public PreviewOfflineLabelEnvironment(FileActionsManager fileActionsManager, IOfflineService offlineService, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper) {
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        Intrinsics.checkNotNullParameter(offlineService, "offlineService");
        Intrinsics.checkNotNullParameter(boxModelOfflineManagerWrapper, "boxModelOfflineManagerWrapper");
        this.fileActionsManager = fileActionsManager;
        this.offlineService = offlineService;
        this.boxModelOfflineManagerWrapper = boxModelOfflineManagerWrapper;
    }

    public final FileActionsManager getFileActionsManager() {
        return this.fileActionsManager;
    }

    public final IOfflineService getOfflineService() {
        return this.offlineService;
    }

    public final BoxModelOfflineManagerWrapper getBoxModelOfflineManagerWrapper() {
        return this.boxModelOfflineManagerWrapper;
    }
}
