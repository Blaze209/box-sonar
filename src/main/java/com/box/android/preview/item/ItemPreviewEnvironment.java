package com.box.android.preview.item;

import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.domain.services.IBoxAiService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IOfflineService;
import com.box.android.domain.services.IPreviewService;
import com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityUseCase;
import com.box.android.domain.usecases.thumbnail.ThumbnailPreviewUseCase;
import com.box.android.preview.item.labels.ItemPreviewLabelsEnvironment;
import com.box.android.preview.preview.PreviewAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNotesEnvironment;
import com.box.android.preview.previewtype.code.CodePreviewEnvironment;
import com.box.android.preview.previewtype.document.DocumentPreviewEnvironment;
import com.box.android.preview.previewtype.gif.GifPreviewEnvironment;
import com.box.android.preview.previewtype.image.ImagePreviewEnvironment;
import com.box.android.preview.previewtype.video.VideoPreviewEnvironment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0091\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#¢\u0006\u0004\b$\u0010%J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0007HÆ\u0003J\t\u0010K\u001a\u00020\tHÆ\u0003J\t\u0010L\u001a\u00020\u000bHÆ\u0003J\t\u0010M\u001a\u00020\rHÆ\u0003J\t\u0010N\u001a\u00020\u000fHÆ\u0003J\t\u0010O\u001a\u00020\u0011HÆ\u0003J\t\u0010P\u001a\u00020\u0013HÆ\u0003J\t\u0010Q\u001a\u00020\u0015HÆ\u0003J\t\u0010R\u001a\u00020\u0017HÆ\u0003J\t\u0010S\u001a\u00020\u0019HÆ\u0003J\t\u0010T\u001a\u00020\u001bHÆ\u0003J\t\u0010U\u001a\u00020\u001dHÆ\u0003J\t\u0010V\u001a\u00020\u001fHÆ\u0003J\t\u0010W\u001a\u00020!HÆ\u0003J\t\u0010X\u001a\u00020#HÆ\u0003J³\u0001\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#HÆ\u0001J\u0013\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010]\u001a\u00020^HÖ\u0001J\t\u0010_\u001a\u00020`HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bF\u0010G¨\u0006a"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewEnvironment;", "", "previewService", "Lcom/box/android/domain/services/IPreviewService;", "itemService", "Lcom/box/android/domain/services/ILocalItemService;", "offlineService", "Lcom/box/android/domain/services/IOfflineService;", "thumbnailPreviewInteractor", "Lcom/box/android/domain/usecases/thumbnail/ThumbnailPreviewUseCase;", "documentPreviewEnvironment", "Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;", "imagePreviewEnvironment", "Lcom/box/android/preview/previewtype/image/ImagePreviewEnvironment;", "gifPreviewEnvironment", "Lcom/box/android/preview/previewtype/gif/GifPreviewEnvironment;", "labelsEnvironment", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsEnvironment;", "videoPreviewEnvironment", "Lcom/box/android/preview/previewtype/video/VideoPreviewEnvironment;", "codePreviewEnvironment", "Lcom/box/android/preview/previewtype/code/CodePreviewEnvironment;", "boxNotesEnvironment", "Lcom/box/android/preview/previewtype/boxnote/BoxNotesEnvironment;", "fileActionsManager", "Lcom/box/android/coreservices/utilities/FileActionsManager;", "observability", "Lcom/box/android/domain/metrics/preview/PreviewObservability;", "boxAiService", "Lcom/box/android/domain/services/IBoxAiService;", "analytics", "Lcom/box/android/preview/preview/PreviewAnalytics;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "getBoxAiAvailabilityUseCase", "Lcom/box/android/domain/usecases/boxai/GetBoxAiAvailabilityUseCase;", "<init>", "(Lcom/box/android/domain/services/IPreviewService;Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/domain/services/IOfflineService;Lcom/box/android/domain/usecases/thumbnail/ThumbnailPreviewUseCase;Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;Lcom/box/android/preview/previewtype/image/ImagePreviewEnvironment;Lcom/box/android/preview/previewtype/gif/GifPreviewEnvironment;Lcom/box/android/preview/item/labels/ItemPreviewLabelsEnvironment;Lcom/box/android/preview/previewtype/video/VideoPreviewEnvironment;Lcom/box/android/preview/previewtype/code/CodePreviewEnvironment;Lcom/box/android/preview/previewtype/boxnote/BoxNotesEnvironment;Lcom/box/android/coreservices/utilities/FileActionsManager;Lcom/box/android/domain/metrics/preview/PreviewObservability;Lcom/box/android/domain/services/IBoxAiService;Lcom/box/android/preview/preview/PreviewAnalytics;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/usecases/boxai/GetBoxAiAvailabilityUseCase;)V", "getPreviewService", "()Lcom/box/android/domain/services/IPreviewService;", "getItemService", "()Lcom/box/android/domain/services/ILocalItemService;", "getOfflineService", "()Lcom/box/android/domain/services/IOfflineService;", "getThumbnailPreviewInteractor", "()Lcom/box/android/domain/usecases/thumbnail/ThumbnailPreviewUseCase;", "getDocumentPreviewEnvironment", "()Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;", "getImagePreviewEnvironment", "()Lcom/box/android/preview/previewtype/image/ImagePreviewEnvironment;", "getGifPreviewEnvironment", "()Lcom/box/android/preview/previewtype/gif/GifPreviewEnvironment;", "getLabelsEnvironment", "()Lcom/box/android/preview/item/labels/ItemPreviewLabelsEnvironment;", "getVideoPreviewEnvironment", "()Lcom/box/android/preview/previewtype/video/VideoPreviewEnvironment;", "getCodePreviewEnvironment", "()Lcom/box/android/preview/previewtype/code/CodePreviewEnvironment;", "getBoxNotesEnvironment", "()Lcom/box/android/preview/previewtype/boxnote/BoxNotesEnvironment;", "getFileActionsManager", "()Lcom/box/android/coreservices/utilities/FileActionsManager;", "getObservability", "()Lcom/box/android/domain/metrics/preview/PreviewObservability;", "getBoxAiService", "()Lcom/box/android/domain/services/IBoxAiService;", "getAnalytics", "()Lcom/box/android/preview/preview/PreviewAnalytics;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "getGetBoxAiAvailabilityUseCase", "()Lcom/box/android/domain/usecases/boxai/GetBoxAiAvailabilityUseCase;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ItemPreviewEnvironment {
    public static final int $stable = 8;
    private final PreviewAnalytics analytics;
    private final IBoxAiService boxAiService;
    private final BoxNotesEnvironment boxNotesEnvironment;
    private final CodePreviewEnvironment codePreviewEnvironment;
    private final DocumentPreviewEnvironment documentPreviewEnvironment;
    private final FeatureFlips featureFlips;
    private final FileActionsManager fileActionsManager;
    private final GetBoxAiAvailabilityUseCase getBoxAiAvailabilityUseCase;
    private final GifPreviewEnvironment gifPreviewEnvironment;
    private final ImagePreviewEnvironment imagePreviewEnvironment;
    private final ILocalItemService itemService;
    private final ItemPreviewLabelsEnvironment labelsEnvironment;
    private final PreviewObservability observability;
    private final IOfflineService offlineService;
    private final IPreviewService previewService;
    private final ThumbnailPreviewUseCase thumbnailPreviewInteractor;
    private final VideoPreviewEnvironment videoPreviewEnvironment;

    public static /* synthetic */ ItemPreviewEnvironment copy$default(ItemPreviewEnvironment itemPreviewEnvironment, IPreviewService iPreviewService, ILocalItemService iLocalItemService, IOfflineService iOfflineService, ThumbnailPreviewUseCase thumbnailPreviewUseCase, DocumentPreviewEnvironment documentPreviewEnvironment, ImagePreviewEnvironment imagePreviewEnvironment, GifPreviewEnvironment gifPreviewEnvironment, ItemPreviewLabelsEnvironment itemPreviewLabelsEnvironment, VideoPreviewEnvironment videoPreviewEnvironment, CodePreviewEnvironment codePreviewEnvironment, BoxNotesEnvironment boxNotesEnvironment, FileActionsManager fileActionsManager, PreviewObservability previewObservability, IBoxAiService iBoxAiService, PreviewAnalytics previewAnalytics, FeatureFlips featureFlips, GetBoxAiAvailabilityUseCase getBoxAiAvailabilityUseCase, int i, Object obj) {
        GetBoxAiAvailabilityUseCase getBoxAiAvailabilityUseCase2;
        FeatureFlips featureFlips2;
        IPreviewService iPreviewService2 = (i & 1) != 0 ? itemPreviewEnvironment.previewService : iPreviewService;
        ILocalItemService iLocalItemService2 = (i & 2) != 0 ? itemPreviewEnvironment.itemService : iLocalItemService;
        IOfflineService iOfflineService2 = (i & 4) != 0 ? itemPreviewEnvironment.offlineService : iOfflineService;
        ThumbnailPreviewUseCase thumbnailPreviewUseCase2 = (i & 8) != 0 ? itemPreviewEnvironment.thumbnailPreviewInteractor : thumbnailPreviewUseCase;
        DocumentPreviewEnvironment documentPreviewEnvironment2 = (i & 16) != 0 ? itemPreviewEnvironment.documentPreviewEnvironment : documentPreviewEnvironment;
        ImagePreviewEnvironment imagePreviewEnvironment2 = (i & 32) != 0 ? itemPreviewEnvironment.imagePreviewEnvironment : imagePreviewEnvironment;
        GifPreviewEnvironment gifPreviewEnvironment2 = (i & 64) != 0 ? itemPreviewEnvironment.gifPreviewEnvironment : gifPreviewEnvironment;
        ItemPreviewLabelsEnvironment itemPreviewLabelsEnvironment2 = (i & 128) != 0 ? itemPreviewEnvironment.labelsEnvironment : itemPreviewLabelsEnvironment;
        VideoPreviewEnvironment videoPreviewEnvironment2 = (i & 256) != 0 ? itemPreviewEnvironment.videoPreviewEnvironment : videoPreviewEnvironment;
        CodePreviewEnvironment codePreviewEnvironment2 = (i & 512) != 0 ? itemPreviewEnvironment.codePreviewEnvironment : codePreviewEnvironment;
        BoxNotesEnvironment boxNotesEnvironment2 = (i & 1024) != 0 ? itemPreviewEnvironment.boxNotesEnvironment : boxNotesEnvironment;
        FileActionsManager fileActionsManager2 = (i & 2048) != 0 ? itemPreviewEnvironment.fileActionsManager : fileActionsManager;
        PreviewObservability previewObservability2 = (i & 4096) != 0 ? itemPreviewEnvironment.observability : previewObservability;
        IBoxAiService iBoxAiService2 = (i & 8192) != 0 ? itemPreviewEnvironment.boxAiService : iBoxAiService;
        IPreviewService iPreviewService3 = iPreviewService2;
        PreviewAnalytics previewAnalytics2 = (i & 16384) != 0 ? itemPreviewEnvironment.analytics : previewAnalytics;
        FeatureFlips featureFlips3 = (i & 32768) != 0 ? itemPreviewEnvironment.featureFlips : featureFlips;
        if ((i & 65536) != 0) {
            featureFlips2 = featureFlips3;
            getBoxAiAvailabilityUseCase2 = itemPreviewEnvironment.getBoxAiAvailabilityUseCase;
        } else {
            getBoxAiAvailabilityUseCase2 = getBoxAiAvailabilityUseCase;
            featureFlips2 = featureFlips3;
        }
        return itemPreviewEnvironment.copy(iPreviewService3, iLocalItemService2, iOfflineService2, thumbnailPreviewUseCase2, documentPreviewEnvironment2, imagePreviewEnvironment2, gifPreviewEnvironment2, itemPreviewLabelsEnvironment2, videoPreviewEnvironment2, codePreviewEnvironment2, boxNotesEnvironment2, fileActionsManager2, previewObservability2, iBoxAiService2, previewAnalytics2, featureFlips2, getBoxAiAvailabilityUseCase2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final IPreviewService getPreviewService() {
        return this.previewService;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final CodePreviewEnvironment getCodePreviewEnvironment() {
        return this.codePreviewEnvironment;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final BoxNotesEnvironment getBoxNotesEnvironment() {
        return this.boxNotesEnvironment;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final FileActionsManager getFileActionsManager() {
        return this.fileActionsManager;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final PreviewObservability getObservability() {
        return this.observability;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final IBoxAiService getBoxAiService() {
        return this.boxAiService;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final PreviewAnalytics getAnalytics() {
        return this.analytics;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final GetBoxAiAvailabilityUseCase getGetBoxAiAvailabilityUseCase() {
        return this.getBoxAiAvailabilityUseCase;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ILocalItemService getItemService() {
        return this.itemService;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final IOfflineService getOfflineService() {
        return this.offlineService;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ThumbnailPreviewUseCase getThumbnailPreviewInteractor() {
        return this.thumbnailPreviewInteractor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DocumentPreviewEnvironment getDocumentPreviewEnvironment() {
        return this.documentPreviewEnvironment;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ImagePreviewEnvironment getImagePreviewEnvironment() {
        return this.imagePreviewEnvironment;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final GifPreviewEnvironment getGifPreviewEnvironment() {
        return this.gifPreviewEnvironment;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ItemPreviewLabelsEnvironment getLabelsEnvironment() {
        return this.labelsEnvironment;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final VideoPreviewEnvironment getVideoPreviewEnvironment() {
        return this.videoPreviewEnvironment;
    }

    public final ItemPreviewEnvironment copy(IPreviewService previewService, ILocalItemService itemService, IOfflineService offlineService, ThumbnailPreviewUseCase thumbnailPreviewInteractor, DocumentPreviewEnvironment documentPreviewEnvironment, ImagePreviewEnvironment imagePreviewEnvironment, GifPreviewEnvironment gifPreviewEnvironment, ItemPreviewLabelsEnvironment labelsEnvironment, VideoPreviewEnvironment videoPreviewEnvironment, CodePreviewEnvironment codePreviewEnvironment, BoxNotesEnvironment boxNotesEnvironment, FileActionsManager fileActionsManager, PreviewObservability observability, IBoxAiService boxAiService, PreviewAnalytics analytics, FeatureFlips featureFlips, GetBoxAiAvailabilityUseCase getBoxAiAvailabilityUseCase) {
        Intrinsics.checkNotNullParameter(previewService, "previewService");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(offlineService, "offlineService");
        Intrinsics.checkNotNullParameter(thumbnailPreviewInteractor, "thumbnailPreviewInteractor");
        Intrinsics.checkNotNullParameter(documentPreviewEnvironment, "documentPreviewEnvironment");
        Intrinsics.checkNotNullParameter(imagePreviewEnvironment, "imagePreviewEnvironment");
        Intrinsics.checkNotNullParameter(gifPreviewEnvironment, "gifPreviewEnvironment");
        Intrinsics.checkNotNullParameter(labelsEnvironment, "labelsEnvironment");
        Intrinsics.checkNotNullParameter(videoPreviewEnvironment, "videoPreviewEnvironment");
        Intrinsics.checkNotNullParameter(codePreviewEnvironment, "codePreviewEnvironment");
        Intrinsics.checkNotNullParameter(boxNotesEnvironment, "boxNotesEnvironment");
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        Intrinsics.checkNotNullParameter(observability, "observability");
        Intrinsics.checkNotNullParameter(boxAiService, "boxAiService");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(getBoxAiAvailabilityUseCase, "getBoxAiAvailabilityUseCase");
        return new ItemPreviewEnvironment(previewService, itemService, offlineService, thumbnailPreviewInteractor, documentPreviewEnvironment, imagePreviewEnvironment, gifPreviewEnvironment, labelsEnvironment, videoPreviewEnvironment, codePreviewEnvironment, boxNotesEnvironment, fileActionsManager, observability, boxAiService, analytics, featureFlips, getBoxAiAvailabilityUseCase);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemPreviewEnvironment)) {
            return false;
        }
        ItemPreviewEnvironment itemPreviewEnvironment = (ItemPreviewEnvironment) other;
        return Intrinsics.areEqual(this.previewService, itemPreviewEnvironment.previewService) && Intrinsics.areEqual(this.itemService, itemPreviewEnvironment.itemService) && Intrinsics.areEqual(this.offlineService, itemPreviewEnvironment.offlineService) && Intrinsics.areEqual(this.thumbnailPreviewInteractor, itemPreviewEnvironment.thumbnailPreviewInteractor) && Intrinsics.areEqual(this.documentPreviewEnvironment, itemPreviewEnvironment.documentPreviewEnvironment) && Intrinsics.areEqual(this.imagePreviewEnvironment, itemPreviewEnvironment.imagePreviewEnvironment) && Intrinsics.areEqual(this.gifPreviewEnvironment, itemPreviewEnvironment.gifPreviewEnvironment) && Intrinsics.areEqual(this.labelsEnvironment, itemPreviewEnvironment.labelsEnvironment) && Intrinsics.areEqual(this.videoPreviewEnvironment, itemPreviewEnvironment.videoPreviewEnvironment) && Intrinsics.areEqual(this.codePreviewEnvironment, itemPreviewEnvironment.codePreviewEnvironment) && Intrinsics.areEqual(this.boxNotesEnvironment, itemPreviewEnvironment.boxNotesEnvironment) && Intrinsics.areEqual(this.fileActionsManager, itemPreviewEnvironment.fileActionsManager) && Intrinsics.areEqual(this.observability, itemPreviewEnvironment.observability) && Intrinsics.areEqual(this.boxAiService, itemPreviewEnvironment.boxAiService) && Intrinsics.areEqual(this.analytics, itemPreviewEnvironment.analytics) && Intrinsics.areEqual(this.featureFlips, itemPreviewEnvironment.featureFlips) && Intrinsics.areEqual(this.getBoxAiAvailabilityUseCase, itemPreviewEnvironment.getBoxAiAvailabilityUseCase);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.previewService.hashCode() * 31) + this.itemService.hashCode()) * 31) + this.offlineService.hashCode()) * 31) + this.thumbnailPreviewInteractor.hashCode()) * 31) + this.documentPreviewEnvironment.hashCode()) * 31) + this.imagePreviewEnvironment.hashCode()) * 31) + this.gifPreviewEnvironment.hashCode()) * 31) + this.labelsEnvironment.hashCode()) * 31) + this.videoPreviewEnvironment.hashCode()) * 31) + this.codePreviewEnvironment.hashCode()) * 31) + this.boxNotesEnvironment.hashCode()) * 31) + this.fileActionsManager.hashCode()) * 31) + this.observability.hashCode()) * 31) + this.boxAiService.hashCode()) * 31) + this.analytics.hashCode()) * 31) + this.featureFlips.hashCode()) * 31) + this.getBoxAiAvailabilityUseCase.hashCode();
    }

    public String toString() {
        return "ItemPreviewEnvironment(previewService=" + this.previewService + ", itemService=" + this.itemService + ", offlineService=" + this.offlineService + ", thumbnailPreviewInteractor=" + this.thumbnailPreviewInteractor + ", documentPreviewEnvironment=" + this.documentPreviewEnvironment + ", imagePreviewEnvironment=" + this.imagePreviewEnvironment + ", gifPreviewEnvironment=" + this.gifPreviewEnvironment + ", labelsEnvironment=" + this.labelsEnvironment + ", videoPreviewEnvironment=" + this.videoPreviewEnvironment + ", codePreviewEnvironment=" + this.codePreviewEnvironment + ", boxNotesEnvironment=" + this.boxNotesEnvironment + ", fileActionsManager=" + this.fileActionsManager + ", observability=" + this.observability + ", boxAiService=" + this.boxAiService + ", analytics=" + this.analytics + ", featureFlips=" + this.featureFlips + ", getBoxAiAvailabilityUseCase=" + this.getBoxAiAvailabilityUseCase + ")";
    }

    @Inject
    public ItemPreviewEnvironment(IPreviewService previewService, ILocalItemService itemService, IOfflineService offlineService, ThumbnailPreviewUseCase thumbnailPreviewInteractor, DocumentPreviewEnvironment documentPreviewEnvironment, ImagePreviewEnvironment imagePreviewEnvironment, GifPreviewEnvironment gifPreviewEnvironment, ItemPreviewLabelsEnvironment labelsEnvironment, VideoPreviewEnvironment videoPreviewEnvironment, CodePreviewEnvironment codePreviewEnvironment, BoxNotesEnvironment boxNotesEnvironment, FileActionsManager fileActionsManager, PreviewObservability observability, IBoxAiService boxAiService, PreviewAnalytics analytics, FeatureFlips featureFlips, GetBoxAiAvailabilityUseCase getBoxAiAvailabilityUseCase) {
        Intrinsics.checkNotNullParameter(previewService, "previewService");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(offlineService, "offlineService");
        Intrinsics.checkNotNullParameter(thumbnailPreviewInteractor, "thumbnailPreviewInteractor");
        Intrinsics.checkNotNullParameter(documentPreviewEnvironment, "documentPreviewEnvironment");
        Intrinsics.checkNotNullParameter(imagePreviewEnvironment, "imagePreviewEnvironment");
        Intrinsics.checkNotNullParameter(gifPreviewEnvironment, "gifPreviewEnvironment");
        Intrinsics.checkNotNullParameter(labelsEnvironment, "labelsEnvironment");
        Intrinsics.checkNotNullParameter(videoPreviewEnvironment, "videoPreviewEnvironment");
        Intrinsics.checkNotNullParameter(codePreviewEnvironment, "codePreviewEnvironment");
        Intrinsics.checkNotNullParameter(boxNotesEnvironment, "boxNotesEnvironment");
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        Intrinsics.checkNotNullParameter(observability, "observability");
        Intrinsics.checkNotNullParameter(boxAiService, "boxAiService");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(getBoxAiAvailabilityUseCase, "getBoxAiAvailabilityUseCase");
        this.previewService = previewService;
        this.itemService = itemService;
        this.offlineService = offlineService;
        this.thumbnailPreviewInteractor = thumbnailPreviewInteractor;
        this.documentPreviewEnvironment = documentPreviewEnvironment;
        this.imagePreviewEnvironment = imagePreviewEnvironment;
        this.gifPreviewEnvironment = gifPreviewEnvironment;
        this.labelsEnvironment = labelsEnvironment;
        this.videoPreviewEnvironment = videoPreviewEnvironment;
        this.codePreviewEnvironment = codePreviewEnvironment;
        this.boxNotesEnvironment = boxNotesEnvironment;
        this.fileActionsManager = fileActionsManager;
        this.observability = observability;
        this.boxAiService = boxAiService;
        this.analytics = analytics;
        this.featureFlips = featureFlips;
        this.getBoxAiAvailabilityUseCase = getBoxAiAvailabilityUseCase;
    }

    public final IPreviewService getPreviewService() {
        return this.previewService;
    }

    public final ILocalItemService getItemService() {
        return this.itemService;
    }

    public final IOfflineService getOfflineService() {
        return this.offlineService;
    }

    public final ThumbnailPreviewUseCase getThumbnailPreviewInteractor() {
        return this.thumbnailPreviewInteractor;
    }

    public final DocumentPreviewEnvironment getDocumentPreviewEnvironment() {
        return this.documentPreviewEnvironment;
    }

    public final ImagePreviewEnvironment getImagePreviewEnvironment() {
        return this.imagePreviewEnvironment;
    }

    public final GifPreviewEnvironment getGifPreviewEnvironment() {
        return this.gifPreviewEnvironment;
    }

    public final ItemPreviewLabelsEnvironment getLabelsEnvironment() {
        return this.labelsEnvironment;
    }

    public final VideoPreviewEnvironment getVideoPreviewEnvironment() {
        return this.videoPreviewEnvironment;
    }

    public final CodePreviewEnvironment getCodePreviewEnvironment() {
        return this.codePreviewEnvironment;
    }

    public final BoxNotesEnvironment getBoxNotesEnvironment() {
        return this.boxNotesEnvironment;
    }

    public final FileActionsManager getFileActionsManager() {
        return this.fileActionsManager;
    }

    public final PreviewObservability getObservability() {
        return this.observability;
    }

    public final IBoxAiService getBoxAiService() {
        return this.boxAiService;
    }

    public final PreviewAnalytics getAnalytics() {
        return this.analytics;
    }

    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }

    public final GetBoxAiAvailabilityUseCase getGetBoxAiAvailabilityUseCase() {
        return this.getBoxAiAvailabilityUseCase;
    }
}
