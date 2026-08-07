package com.box.android.preview.item;

import com.box.android.coreservices.utilities.FileActionsManager;
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
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class ItemPreviewEnvironment_Factory implements Factory<ItemPreviewEnvironment> {
    private final Provider<PreviewAnalytics> analyticsProvider;
    private final Provider<IBoxAiService> boxAiServiceProvider;
    private final Provider<BoxNotesEnvironment> boxNotesEnvironmentProvider;
    private final Provider<CodePreviewEnvironment> codePreviewEnvironmentProvider;
    private final Provider<DocumentPreviewEnvironment> documentPreviewEnvironmentProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<FileActionsManager> fileActionsManagerProvider;
    private final Provider<GetBoxAiAvailabilityUseCase> getBoxAiAvailabilityUseCaseProvider;
    private final Provider<GifPreviewEnvironment> gifPreviewEnvironmentProvider;
    private final Provider<ImagePreviewEnvironment> imagePreviewEnvironmentProvider;
    private final Provider<ILocalItemService> itemServiceProvider;
    private final Provider<ItemPreviewLabelsEnvironment> labelsEnvironmentProvider;
    private final Provider<PreviewObservability> observabilityProvider;
    private final Provider<IOfflineService> offlineServiceProvider;
    private final Provider<IPreviewService> previewServiceProvider;
    private final Provider<ThumbnailPreviewUseCase> thumbnailPreviewInteractorProvider;
    private final Provider<VideoPreviewEnvironment> videoPreviewEnvironmentProvider;

    private ItemPreviewEnvironment_Factory(Provider<IPreviewService> provider, Provider<ILocalItemService> provider2, Provider<IOfflineService> provider3, Provider<ThumbnailPreviewUseCase> provider4, Provider<DocumentPreviewEnvironment> provider5, Provider<ImagePreviewEnvironment> provider6, Provider<GifPreviewEnvironment> provider7, Provider<ItemPreviewLabelsEnvironment> provider8, Provider<VideoPreviewEnvironment> provider9, Provider<CodePreviewEnvironment> provider10, Provider<BoxNotesEnvironment> provider11, Provider<FileActionsManager> provider12, Provider<PreviewObservability> provider13, Provider<IBoxAiService> provider14, Provider<PreviewAnalytics> provider15, Provider<FeatureFlips> provider16, Provider<GetBoxAiAvailabilityUseCase> provider17) {
        this.previewServiceProvider = provider;
        this.itemServiceProvider = provider2;
        this.offlineServiceProvider = provider3;
        this.thumbnailPreviewInteractorProvider = provider4;
        this.documentPreviewEnvironmentProvider = provider5;
        this.imagePreviewEnvironmentProvider = provider6;
        this.gifPreviewEnvironmentProvider = provider7;
        this.labelsEnvironmentProvider = provider8;
        this.videoPreviewEnvironmentProvider = provider9;
        this.codePreviewEnvironmentProvider = provider10;
        this.boxNotesEnvironmentProvider = provider11;
        this.fileActionsManagerProvider = provider12;
        this.observabilityProvider = provider13;
        this.boxAiServiceProvider = provider14;
        this.analyticsProvider = provider15;
        this.featureFlipsProvider = provider16;
        this.getBoxAiAvailabilityUseCaseProvider = provider17;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemPreviewEnvironment get() {
        return newInstance(this.previewServiceProvider.get(), this.itemServiceProvider.get(), this.offlineServiceProvider.get(), this.thumbnailPreviewInteractorProvider.get(), this.documentPreviewEnvironmentProvider.get(), this.imagePreviewEnvironmentProvider.get(), this.gifPreviewEnvironmentProvider.get(), this.labelsEnvironmentProvider.get(), this.videoPreviewEnvironmentProvider.get(), this.codePreviewEnvironmentProvider.get(), this.boxNotesEnvironmentProvider.get(), this.fileActionsManagerProvider.get(), this.observabilityProvider.get(), this.boxAiServiceProvider.get(), this.analyticsProvider.get(), this.featureFlipsProvider.get(), this.getBoxAiAvailabilityUseCaseProvider.get());
    }

    public static ItemPreviewEnvironment_Factory create(Provider<IPreviewService> provider, Provider<ILocalItemService> provider2, Provider<IOfflineService> provider3, Provider<ThumbnailPreviewUseCase> provider4, Provider<DocumentPreviewEnvironment> provider5, Provider<ImagePreviewEnvironment> provider6, Provider<GifPreviewEnvironment> provider7, Provider<ItemPreviewLabelsEnvironment> provider8, Provider<VideoPreviewEnvironment> provider9, Provider<CodePreviewEnvironment> provider10, Provider<BoxNotesEnvironment> provider11, Provider<FileActionsManager> provider12, Provider<PreviewObservability> provider13, Provider<IBoxAiService> provider14, Provider<PreviewAnalytics> provider15, Provider<FeatureFlips> provider16, Provider<GetBoxAiAvailabilityUseCase> provider17) {
        return new ItemPreviewEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    public static ItemPreviewEnvironment newInstance(IPreviewService iPreviewService, ILocalItemService iLocalItemService, IOfflineService iOfflineService, ThumbnailPreviewUseCase thumbnailPreviewUseCase, DocumentPreviewEnvironment documentPreviewEnvironment, ImagePreviewEnvironment imagePreviewEnvironment, GifPreviewEnvironment gifPreviewEnvironment, ItemPreviewLabelsEnvironment itemPreviewLabelsEnvironment, VideoPreviewEnvironment videoPreviewEnvironment, CodePreviewEnvironment codePreviewEnvironment, BoxNotesEnvironment boxNotesEnvironment, FileActionsManager fileActionsManager, PreviewObservability previewObservability, IBoxAiService iBoxAiService, PreviewAnalytics previewAnalytics, FeatureFlips featureFlips, GetBoxAiAvailabilityUseCase getBoxAiAvailabilityUseCase) {
        return new ItemPreviewEnvironment(iPreviewService, iLocalItemService, iOfflineService, thumbnailPreviewUseCase, documentPreviewEnvironment, imagePreviewEnvironment, gifPreviewEnvironment, itemPreviewLabelsEnvironment, videoPreviewEnvironment, codePreviewEnvironment, boxNotesEnvironment, fileActionsManager, previewObservability, iBoxAiService, previewAnalytics, featureFlips, getBoxAiAvailabilityUseCase);
    }
}
