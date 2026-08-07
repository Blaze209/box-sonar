package com.box.android.domain.di;

import com.box.android.domain.preview.PreviewerTypeResolver;
import com.box.android.domain.preview.PreviewerTypeResolverImpl;
import com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityInteractor;
import com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityUseCase;
import com.box.android.domain.usecases.browse.CreateFolderInteractor;
import com.box.android.domain.usecases.browse.CreateFolderUseCase;
import com.box.android.domain.usecases.browse.FolderInteractor;
import com.box.android.domain.usecases.browse.FolderUseCase;
import com.box.android.domain.usecases.capture.CaptureFolderInteractor;
import com.box.android.domain.usecases.capture.CaptureFolderUseCase;
import com.box.android.domain.usecases.capture.CaptureHistoryInteractor;
import com.box.android.domain.usecases.capture.CaptureHistoryUseCase;
import com.box.android.domain.usecases.capture.CaptureLocalItemsInteractor;
import com.box.android.domain.usecases.capture.CaptureLocalItemsUseCase;
import com.box.android.domain.usecases.capture.DeleteCaptureHistoryInteractor;
import com.box.android.domain.usecases.capture.DeleteCaptureHistoryUseCase;
import com.box.android.domain.usecases.capture.LaunchIntoCaptureInteractor;
import com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase;
import com.box.android.domain.usecases.collections.GetFavoritesCollectionIdInteractor;
import com.box.android.domain.usecases.collections.GetFavoritesCollectionIdUseCase;
import com.box.android.domain.usecases.documentscanning.DocumentScanInteractor;
import com.box.android.domain.usecases.documentscanning.DocumentScanUseCase;
import com.box.android.domain.usecases.notes.ResolveNewNoteDataInteractor;
import com.box.android.domain.usecases.notes.ResolveNewNoteDataUseCase;
import com.box.android.domain.usecases.notes.ResolveNewNoteLocationInteractor;
import com.box.android.domain.usecases.notes.ResolveNewNoteLocationUseCase;
import com.box.android.domain.usecases.notes.SetDefaultNoteFolderInteractor;
import com.box.android.domain.usecases.notes.SetDefaultNoteFolderUseCase;
import com.box.android.domain.usecases.observability.MetricsInteractor;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.domain.usecases.observability.UploadLogsInteractor;
import com.box.android.domain.usecases.observability.UploadLogsUseCase;
import com.box.android.domain.usecases.pushnotifications.NotificationCategoriesInteractor;
import com.box.android.domain.usecases.pushnotifications.NotificationCategoriesUseCase;
import com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceInteractor;
import com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceUseCase;
import com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationInteractor;
import com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationUseCase;
import com.box.android.domain.usecases.thumbnail.ThumbnailPreviewInteractor;
import com.box.android.domain.usecases.thumbnail.ThumbnailPreviewUseCase;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;

/* JADX INFO: compiled from: DomainModule.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000¤\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H!¢\u0006\u0002\b\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH!¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H!¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H!¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH!¢\u0006\u0002\b\u001cJ\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H!¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H!¢\u0006\u0002\b&J\u0015\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H!¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H!¢\u0006\u0002\b0J\u0015\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H!¢\u0006\u0002\b5J\u0015\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H!¢\u0006\u0002\b:J\u0015\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H!¢\u0006\u0002\b?J\u0015\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH!¢\u0006\u0002\bDJ\u0015\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH!¢\u0006\u0002\bIJ\u0015\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH!¢\u0006\u0002\bNJ\u0015\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH!¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH!¢\u0006\u0002\bXJ\u0015\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H!¢\u0006\u0002\b]J\u0015\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH!¢\u0006\u0002\bbJ\u0015\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fH!¢\u0006\u0002\bg¨\u0006h"}, d2 = {"Lcom/box/android/domain/di/DomainModule;", "", "<init>", "()V", "provideNotificationCategoriesUseCase", "Lcom/box/android/domain/usecases/pushnotifications/NotificationCategoriesUseCase;", "notificationCategoriesInteractor", "Lcom/box/android/domain/usecases/pushnotifications/NotificationCategoriesInteractor;", "provideNotificationCategoriesUseCase$domain_prodRelease", "provideRegisterDeviceUseCase", "Lcom/box/android/domain/usecases/pushnotifications/RegisterPushDeviceUseCase;", "registerPushDeviceInteractor", "Lcom/box/android/domain/usecases/pushnotifications/RegisterPushDeviceInteractor;", "provideRegisterDeviceUseCase$domain_prodRelease", "provideUpdateDeviceRegistrationUseCase", "Lcom/box/android/domain/usecases/pushnotifications/UpdateDeviceRegistrationUseCase;", "updateDeviceRegistrationInteractor", "Lcom/box/android/domain/usecases/pushnotifications/UpdateDeviceRegistrationInteractor;", "provideUpdateDeviceRegistrationUseCase$domain_prodRelease", "provideMetricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "metricsInteractor", "Lcom/box/android/domain/usecases/observability/MetricsInteractor;", "provideMetricsUseCase$domain_prodRelease", "provideUploadLogsUseCase", "Lcom/box/android/domain/usecases/observability/UploadLogsUseCase;", "uploadLogsInteractor", "Lcom/box/android/domain/usecases/observability/UploadLogsInteractor;", "provideUploadLogsUseCase$domain_prodRelease", "providesCaptureHistoryUseCase", "Lcom/box/android/domain/usecases/capture/CaptureHistoryUseCase;", "captureHistoryInteractor", "Lcom/box/android/domain/usecases/capture/CaptureHistoryInteractor;", "providesCaptureHistoryUseCase$domain_prodRelease", "providesDeleteCaptureHistoryUseCase", "Lcom/box/android/domain/usecases/capture/DeleteCaptureHistoryUseCase;", "deleteCaptureHistoryInteractor", "Lcom/box/android/domain/usecases/capture/DeleteCaptureHistoryInteractor;", "providesDeleteCaptureHistoryUseCase$domain_prodRelease", "providesDocumentScanUseCase", "Lcom/box/android/domain/usecases/documentscanning/DocumentScanUseCase;", "documentScanInteractor", "Lcom/box/android/domain/usecases/documentscanning/DocumentScanInteractor;", "providesDocumentScanUseCase$domain_prodRelease", "provideLocalItemsUseCase", "Lcom/box/android/domain/usecases/capture/CaptureLocalItemsUseCase;", "createLocalItemsInteractor", "Lcom/box/android/domain/usecases/capture/CaptureLocalItemsInteractor;", "provideLocalItemsUseCase$domain_prodRelease", "provideLaunchIntoCaptureUseCase", "Lcom/box/android/domain/usecases/capture/LaunchIntoCaptureUseCase;", "launchIntoCaptureInteractor", "Lcom/box/android/domain/usecases/capture/LaunchIntoCaptureInteractor;", "provideLaunchIntoCaptureUseCase$domain_prodRelease", "provideCaptureFolderUseCase", "Lcom/box/android/domain/usecases/capture/CaptureFolderUseCase;", "captureFolderInteractor", "Lcom/box/android/domain/usecases/capture/CaptureFolderInteractor;", "provideCaptureFolderUseCase$domain_prodRelease", "provideFolderViewUseCase", "Lcom/box/android/domain/usecases/browse/FolderUseCase;", "folderInteractor", "Lcom/box/android/domain/usecases/browse/FolderInteractor;", "provideFolderViewUseCase$domain_prodRelease", "provideCreateFolderUseCase", "Lcom/box/android/domain/usecases/browse/CreateFolderUseCase;", "createFolderInteractor", "Lcom/box/android/domain/usecases/browse/CreateFolderInteractor;", "provideCreateFolderUseCase$domain_prodRelease", "providePreviewerTypeResolver", "Lcom/box/android/domain/preview/PreviewerTypeResolver;", "previewerTypeResolverImpl", "Lcom/box/android/domain/preview/PreviewerTypeResolverImpl;", "providePreviewerTypeResolver$domain_prodRelease", "provideGetBoxAiAvailabilityUseCase", "Lcom/box/android/domain/usecases/boxai/GetBoxAiAvailabilityUseCase;", "getBoxAiAvailabilityInteractor", "Lcom/box/android/domain/usecases/boxai/GetBoxAiAvailabilityInteractor;", "provideGetBoxAiAvailabilityUseCase$domain_prodRelease", "provideGetFavoritesCollectionIdUseCase", "Lcom/box/android/domain/usecases/collections/GetFavoritesCollectionIdUseCase;", "getFavoritesCollectionIdInteractor", "Lcom/box/android/domain/usecases/collections/GetFavoritesCollectionIdInteractor;", "provideGetFavoritesCollectionIdUseCase$domain_prodRelease", "provideResolveNewNoteDataUseCase", "Lcom/box/android/domain/usecases/notes/ResolveNewNoteDataUseCase;", "resolveNewNoteDataInteractor", "Lcom/box/android/domain/usecases/notes/ResolveNewNoteDataInteractor;", "provideResolveNewNoteDataUseCase$domain_prodRelease", "provideResolveNewNoteLocationUseCase", "Lcom/box/android/domain/usecases/notes/ResolveNewNoteLocationUseCase;", "resolveNewNoteLocationInteractor", "Lcom/box/android/domain/usecases/notes/ResolveNewNoteLocationInteractor;", "provideResolveNewNoteLocationUseCase$domain_prodRelease", "provideSetDefaultNoteFolderUseCase", "Lcom/box/android/domain/usecases/notes/SetDefaultNoteFolderUseCase;", "setDefaultNoteFolderInteractor", "Lcom/box/android/domain/usecases/notes/SetDefaultNoteFolderInteractor;", "provideSetDefaultNoteFolderUseCase$domain_prodRelease", "provideThumbnailPreviewUseCase", "Lcom/box/android/domain/usecases/thumbnail/ThumbnailPreviewUseCase;", "thumbnailPreviewInteractor", "Lcom/box/android/domain/usecases/thumbnail/ThumbnailPreviewInteractor;", "provideThumbnailPreviewUseCase$domain_prodRelease", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class DomainModule {
    @Binds
    public abstract CaptureFolderUseCase provideCaptureFolderUseCase$domain_prodRelease(CaptureFolderInteractor captureFolderInteractor);

    @Binds
    public abstract CreateFolderUseCase provideCreateFolderUseCase$domain_prodRelease(CreateFolderInteractor createFolderInteractor);

    @Binds
    public abstract FolderUseCase provideFolderViewUseCase$domain_prodRelease(FolderInteractor folderInteractor);

    @Binds
    public abstract GetBoxAiAvailabilityUseCase provideGetBoxAiAvailabilityUseCase$domain_prodRelease(GetBoxAiAvailabilityInteractor getBoxAiAvailabilityInteractor);

    @Binds
    public abstract GetFavoritesCollectionIdUseCase provideGetFavoritesCollectionIdUseCase$domain_prodRelease(GetFavoritesCollectionIdInteractor getFavoritesCollectionIdInteractor);

    @Binds
    public abstract LaunchIntoCaptureUseCase provideLaunchIntoCaptureUseCase$domain_prodRelease(LaunchIntoCaptureInteractor launchIntoCaptureInteractor);

    @Binds
    public abstract CaptureLocalItemsUseCase provideLocalItemsUseCase$domain_prodRelease(CaptureLocalItemsInteractor createLocalItemsInteractor);

    @Binds
    public abstract MetricsUseCase provideMetricsUseCase$domain_prodRelease(MetricsInteractor metricsInteractor);

    @Binds
    public abstract NotificationCategoriesUseCase provideNotificationCategoriesUseCase$domain_prodRelease(NotificationCategoriesInteractor notificationCategoriesInteractor);

    @Binds
    public abstract PreviewerTypeResolver providePreviewerTypeResolver$domain_prodRelease(PreviewerTypeResolverImpl previewerTypeResolverImpl);

    @Binds
    public abstract RegisterPushDeviceUseCase provideRegisterDeviceUseCase$domain_prodRelease(RegisterPushDeviceInteractor registerPushDeviceInteractor);

    @Binds
    public abstract ResolveNewNoteDataUseCase provideResolveNewNoteDataUseCase$domain_prodRelease(ResolveNewNoteDataInteractor resolveNewNoteDataInteractor);

    @Binds
    public abstract ResolveNewNoteLocationUseCase provideResolveNewNoteLocationUseCase$domain_prodRelease(ResolveNewNoteLocationInteractor resolveNewNoteLocationInteractor);

    @Binds
    public abstract SetDefaultNoteFolderUseCase provideSetDefaultNoteFolderUseCase$domain_prodRelease(SetDefaultNoteFolderInteractor setDefaultNoteFolderInteractor);

    @Binds
    public abstract ThumbnailPreviewUseCase provideThumbnailPreviewUseCase$domain_prodRelease(ThumbnailPreviewInteractor thumbnailPreviewInteractor);

    @Binds
    public abstract UpdateDeviceRegistrationUseCase provideUpdateDeviceRegistrationUseCase$domain_prodRelease(UpdateDeviceRegistrationInteractor updateDeviceRegistrationInteractor);

    @Binds
    public abstract UploadLogsUseCase provideUploadLogsUseCase$domain_prodRelease(UploadLogsInteractor uploadLogsInteractor);

    @Binds
    public abstract CaptureHistoryUseCase providesCaptureHistoryUseCase$domain_prodRelease(CaptureHistoryInteractor captureHistoryInteractor);

    @Binds
    public abstract DeleteCaptureHistoryUseCase providesDeleteCaptureHistoryUseCase$domain_prodRelease(DeleteCaptureHistoryInteractor deleteCaptureHistoryInteractor);

    @Binds
    public abstract DocumentScanUseCase providesDocumentScanUseCase$domain_prodRelease(DocumentScanInteractor documentScanInteractor);
}
