package com.box.android.preview.preview;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.services.IAudioPlaylistItemsService;
import com.box.android.domain.services.IGalleryItemsService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.usecases.preview.TrackRecentPreviewItemInteractor;
import com.box.android.preview.fileactions.FileActionsEnvironment;
import com.box.android.preview.item.ItemPreviewEnvironment;
import com.box.android.preview.preview.previewbar.bottombar.BottomBarEnvironment;
import com.box.android.preview.preview.previewbar.topbar.TopBarEnvironment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001Bi\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/box/android/preview/preview/PreviewEnvironment;", "", "itemPreviewEnvironment", "Lcom/box/android/preview/item/ItemPreviewEnvironment;", "jobManager", "Lcom/box/android/coreservices/jobmanager/JobManager;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "fileActionsManager", "Lcom/box/android/coreservices/utilities/FileActionsManager;", "trackRecentPreviewItemInteractor", "Lcom/box/android/domain/usecases/preview/TrackRecentPreviewItemInteractor;", "itemService", "Lcom/box/android/domain/services/ILocalItemService;", "analytics", "Lcom/box/android/preview/preview/PreviewAnalytics;", "fileActionsEnvironment", "Lcom/box/android/preview/fileactions/FileActionsEnvironment;", "galleryItemsService", "Lcom/box/android/domain/services/IGalleryItemsService;", "audioPlaylistItemsService", "Lcom/box/android/domain/services/IAudioPlaylistItemsService;", "topBarEnvironment", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarEnvironment;", "bottomBarEnvironment", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarEnvironment;", "<init>", "(Lcom/box/android/preview/item/ItemPreviewEnvironment;Lcom/box/android/coreservices/jobmanager/JobManager;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/coreservices/utilities/FileActionsManager;Lcom/box/android/domain/usecases/preview/TrackRecentPreviewItemInteractor;Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/preview/preview/PreviewAnalytics;Lcom/box/android/preview/fileactions/FileActionsEnvironment;Lcom/box/android/domain/services/IGalleryItemsService;Lcom/box/android/domain/services/IAudioPlaylistItemsService;Lcom/box/android/preview/preview/previewbar/topbar/TopBarEnvironment;Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarEnvironment;)V", "getItemPreviewEnvironment", "()Lcom/box/android/preview/item/ItemPreviewEnvironment;", "getJobManager", "()Lcom/box/android/coreservices/jobmanager/JobManager;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "getFileActionsManager", "()Lcom/box/android/coreservices/utilities/FileActionsManager;", "getTrackRecentPreviewItemInteractor", "()Lcom/box/android/domain/usecases/preview/TrackRecentPreviewItemInteractor;", "getItemService", "()Lcom/box/android/domain/services/ILocalItemService;", "getAnalytics", "()Lcom/box/android/preview/preview/PreviewAnalytics;", "getFileActionsEnvironment", "()Lcom/box/android/preview/fileactions/FileActionsEnvironment;", "getGalleryItemsService", "()Lcom/box/android/domain/services/IGalleryItemsService;", "getAudioPlaylistItemsService", "()Lcom/box/android/domain/services/IAudioPlaylistItemsService;", "getTopBarEnvironment", "()Lcom/box/android/preview/preview/previewbar/topbar/TopBarEnvironment;", "getBottomBarEnvironment", "()Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarEnvironment;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewEnvironment {
    public static final int $stable = 8;
    private final PreviewAnalytics analytics;
    private final IAudioPlaylistItemsService audioPlaylistItemsService;
    private final BottomBarEnvironment bottomBarEnvironment;
    private final FeatureFlips featureFlips;
    private final FileActionsEnvironment fileActionsEnvironment;
    private final FileActionsManager fileActionsManager;
    private final IGalleryItemsService galleryItemsService;
    private final ItemPreviewEnvironment itemPreviewEnvironment;
    private final ILocalItemService itemService;
    private final JobManager jobManager;
    private final TopBarEnvironment topBarEnvironment;
    private final TrackRecentPreviewItemInteractor trackRecentPreviewItemInteractor;

    @Inject
    public PreviewEnvironment(ItemPreviewEnvironment itemPreviewEnvironment, JobManager jobManager, FeatureFlips featureFlips, FileActionsManager fileActionsManager, TrackRecentPreviewItemInteractor trackRecentPreviewItemInteractor, ILocalItemService itemService, PreviewAnalytics analytics, FileActionsEnvironment fileActionsEnvironment, IGalleryItemsService galleryItemsService, IAudioPlaylistItemsService audioPlaylistItemsService, TopBarEnvironment topBarEnvironment, BottomBarEnvironment bottomBarEnvironment) {
        Intrinsics.checkNotNullParameter(itemPreviewEnvironment, "itemPreviewEnvironment");
        Intrinsics.checkNotNullParameter(jobManager, "jobManager");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        Intrinsics.checkNotNullParameter(trackRecentPreviewItemInteractor, "trackRecentPreviewItemInteractor");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(fileActionsEnvironment, "fileActionsEnvironment");
        Intrinsics.checkNotNullParameter(galleryItemsService, "galleryItemsService");
        Intrinsics.checkNotNullParameter(audioPlaylistItemsService, "audioPlaylistItemsService");
        Intrinsics.checkNotNullParameter(topBarEnvironment, "topBarEnvironment");
        Intrinsics.checkNotNullParameter(bottomBarEnvironment, "bottomBarEnvironment");
        this.itemPreviewEnvironment = itemPreviewEnvironment;
        this.jobManager = jobManager;
        this.featureFlips = featureFlips;
        this.fileActionsManager = fileActionsManager;
        this.trackRecentPreviewItemInteractor = trackRecentPreviewItemInteractor;
        this.itemService = itemService;
        this.analytics = analytics;
        this.fileActionsEnvironment = fileActionsEnvironment;
        this.galleryItemsService = galleryItemsService;
        this.audioPlaylistItemsService = audioPlaylistItemsService;
        this.topBarEnvironment = topBarEnvironment;
        this.bottomBarEnvironment = bottomBarEnvironment;
    }

    public final ItemPreviewEnvironment getItemPreviewEnvironment() {
        return this.itemPreviewEnvironment;
    }

    public final JobManager getJobManager() {
        return this.jobManager;
    }

    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }

    public final FileActionsManager getFileActionsManager() {
        return this.fileActionsManager;
    }

    public final TrackRecentPreviewItemInteractor getTrackRecentPreviewItemInteractor() {
        return this.trackRecentPreviewItemInteractor;
    }

    public final ILocalItemService getItemService() {
        return this.itemService;
    }

    public final PreviewAnalytics getAnalytics() {
        return this.analytics;
    }

    public final FileActionsEnvironment getFileActionsEnvironment() {
        return this.fileActionsEnvironment;
    }

    public final IGalleryItemsService getGalleryItemsService() {
        return this.galleryItemsService;
    }

    public final IAudioPlaylistItemsService getAudioPlaylistItemsService() {
        return this.audioPlaylistItemsService;
    }

    public final TopBarEnvironment getTopBarEnvironment() {
        return this.topBarEnvironment;
    }

    public final BottomBarEnvironment getBottomBarEnvironment() {
        return this.bottomBarEnvironment;
    }
}
