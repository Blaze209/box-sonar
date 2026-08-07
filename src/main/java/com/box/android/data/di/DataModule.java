package com.box.android.data.di;

import androidx.core.app.NotificationCompat;
import com.box.android.coreservices.modelcontroller.BatchOperationsService;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.data.controller.impl.BaseModelController;
import com.box.android.data.controller.impl.BoxPreviewController;
import com.box.android.data.controller.impl.CommentControllerBridge;
import com.box.android.data.controller.impl.LegacyCommentsController;
import com.box.android.data.jobs.IMoveCopyJobInputValidator;
import com.box.android.data.jobs.JobManagerBridgeService;
import com.box.android.data.jobs.JobService;
import com.box.android.data.jobs.JobWorkerFactory;
import com.box.android.data.jobs.MoveCopyJobInputValidator;
import com.box.android.data.observability.OpenTelemetryInstrumentation;
import com.box.android.data.observability.OpenTelemetryInstrumentationImpl;
import com.box.android.data.observability.RumInstrumentation;
import com.box.android.data.observability.SplunkRumInstrumentation;
import com.box.android.data.persistence.FileSystem;
import com.box.android.data.persistence.ForceUpdateRepository;
import com.box.android.data.persistence.IFileSystem;
import com.box.android.data.persistence.offline.OfflineStateStorage;
import com.box.android.data.service.ContentFileService;
import com.box.android.data.service.UploadFileProvider;
import com.box.android.data.service.impl.AnnotationsService;
import com.box.android.data.service.impl.ApdexScoreProvider;
import com.box.android.data.service.impl.AppRestrictionsManager;
import com.box.android.data.service.impl.AuthenticationService;
import com.box.android.data.service.impl.BVEManager;
import com.box.android.data.service.impl.CaptureHistoryFilesService;
import com.box.android.data.service.impl.CapturePreferencesService;
import com.box.android.data.service.impl.CaptureThumbnailService;
import com.box.android.data.service.impl.ClientSettingsService;
import com.box.android.data.service.impl.CollectionsService;
import com.box.android.data.service.impl.CommentService;
import com.box.android.data.service.impl.CreateFolderService;
import com.box.android.data.service.impl.DefaultNoteFolderService;
import com.box.android.data.service.impl.DeleteFileService;
import com.box.android.data.service.impl.DocumentScanService;
import com.box.android.data.service.impl.FileActivitiesService;
import com.box.android.data.service.impl.FileMetadataService;
import com.box.android.data.service.impl.FileVersionService;
import com.box.android.data.service.impl.GeniusScanLicenseService;
import com.box.android.data.service.impl.HubsService;
import com.box.android.data.service.impl.InboxCollaborationService;
import com.box.android.data.service.impl.InboxNotificationService;
import com.box.android.data.service.impl.ItemCollaborationsService;
import com.box.android.data.service.impl.LegacyBridgeService;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.MetricsLoggingService;
import com.box.android.data.service.impl.OAuthAccessTokenService;
import com.box.android.data.service.impl.ObservabilityService;
import com.box.android.data.service.impl.OfflineFilesPolicyEnforcer;
import com.box.android.data.service.impl.OfflineService;
import com.box.android.data.service.impl.PreviewSettingsService;
import com.box.android.data.service.impl.PushNotificationSettingsService;
import com.box.android.data.service.impl.RecentNotesService;
import com.box.android.data.service.impl.RecentsService;
import com.box.android.data.service.impl.RemoteItemService;
import com.box.android.data.service.impl.RepresentationsService;
import com.box.android.data.service.impl.SearchService;
import com.box.android.data.service.impl.SessionManager;
import com.box.android.data.service.impl.SharedLinkService;
import com.box.android.data.service.impl.TabPersistenceService;
import com.box.android.data.service.impl.TaskService;
import com.box.android.data.service.impl.UpdateItemInfoService;
import com.box.android.data.service.impl.UploadFileService;
import com.box.android.data.service.impl.UserService;
import com.box.android.data.service.impl.WatermarkService;
import com.box.android.data.service.impl.boxai.BoxAiService;
import com.box.android.data.service.impl.preview.AudioPlaylistItemsService;
import com.box.android.data.service.impl.preview.BridgedPreviewService;
import com.box.android.data.service.impl.preview.FileWithRepresentationsService;
import com.box.android.data.service.impl.preview.GalleryItemsService;
import com.box.android.data.service.impl.preview.PreviousVersionPreviewService;
import com.box.android.data.service.impl.thumbnail.ThumbnailService;
import com.box.android.data.utilities.BoxUriSupportChecker;
import com.box.android.data.webBridgeAuth.BoxWebBridgeAuthenticator;
import com.box.android.domain.configuration.IForceUpdateRepository;
import com.box.android.domain.controller.ICommentControllerBridge;
import com.box.android.domain.controller.ILegacyCommentsController;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.offline.IOfflineStateStorage;
import com.box.android.domain.services.AuthTokenService;
import com.box.android.domain.services.IAnnotationsService;
import com.box.android.domain.services.IApdexScoreProvider;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.services.IAudioPlaylistItemsService;
import com.box.android.domain.services.IAuthenticationService;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.services.IBaseModelControllerService;
import com.box.android.domain.services.IBatchOperationsService;
import com.box.android.domain.services.IBoxAiService;
import com.box.android.domain.services.ICaptureHistoryFilesService;
import com.box.android.domain.services.ICapturePreferencesService;
import com.box.android.domain.services.ICaptureThumbnailService;
import com.box.android.domain.services.IClientSettingsService;
import com.box.android.domain.services.ICollectionsService;
import com.box.android.domain.services.ICommentService;
import com.box.android.domain.services.IContentFileService;
import com.box.android.domain.services.ICreateFolderService;
import com.box.android.domain.services.IDefaultNoteFolderService;
import com.box.android.domain.services.IDeleteFileService;
import com.box.android.domain.services.IDocumentScanService;
import com.box.android.domain.services.IFileActivitiesService;
import com.box.android.domain.services.IFileMetadataService;
import com.box.android.domain.services.IFileVersionService;
import com.box.android.domain.services.IFileWithRepresentationsService;
import com.box.android.domain.services.IGalleryItemsService;
import com.box.android.domain.services.IGeniusScanLicenseService;
import com.box.android.domain.services.IHubsService;
import com.box.android.domain.services.IInboxCollaborationService;
import com.box.android.domain.services.IInboxNotificationService;
import com.box.android.domain.services.IItemCollaborationsService;
import com.box.android.domain.services.IJobManagerBridgeService;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.IJobWorkerFactory;
import com.box.android.domain.services.ILegacyBridgeService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IMetricsLoggingService;
import com.box.android.domain.services.IObservabilityService;
import com.box.android.domain.services.IOfflineFilesPolicyEnforcer;
import com.box.android.domain.services.IOfflineService;
import com.box.android.domain.services.IPreviewService;
import com.box.android.domain.services.IPreviewSettingsService;
import com.box.android.domain.services.IPreviousVersionPreviewService;
import com.box.android.domain.services.IPushNotificationSettingsService;
import com.box.android.domain.services.IRecentNotesService;
import com.box.android.domain.services.IRecentsService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IRepresentationsService;
import com.box.android.domain.services.ISearchService;
import com.box.android.domain.services.ISessionManager;
import com.box.android.domain.services.ISharedLinkService;
import com.box.android.domain.services.ITabPersistenceService;
import com.box.android.domain.services.ITaskService;
import com.box.android.domain.services.IThumbnailService;
import com.box.android.domain.services.IUpdateItemInfoService;
import com.box.android.domain.services.IUploadFileProvider;
import com.box.android.domain.services.IUploadFileService;
import com.box.android.domain.services.IUserService;
import com.box.android.domain.services.IWatermarkService;
import com.box.android.domain.utils.IBoxUriSupportChecker;
import com.box.android.domain.webBridgeAuth.BoxCsrfTokenManager;
import com.box.android.domain.webBridgeAuth.IBoxCsrfTokenManager;
import com.box.android.domain.webBridgeAuth.IBoxWebBridgeAuthenticator;
import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: compiled from: DataModule.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000ä\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH'J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH'J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H'J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H'J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H'J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H'J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H'J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H'J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H'J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H'J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH'J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH'J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH'J\u0010\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH'J\u0010\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH'J\u0010\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH'J\u0010\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H'J\u0010\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_H'J\u0010\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020cH'J\u0010\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH'J\u0010\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020kH'J\u0010\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020oH'J\u0010\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020sH'J\u0010\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020wH'J\u0010\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020{H'J\u0010\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u007fH'J\u0014\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H'J\u0014\u0010\u0084\u0001\u001a\u00030\u0085\u00012\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H'J\u0014\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H'J\u0014\u0010\u008c\u0001\u001a\u00030\u008d\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H'J\u0014\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H'J\u0014\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H'J\u0014\u0010\u0098\u0001\u001a\u00030\u0099\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H'J\u0014\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H'J\u0014\u0010 \u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030£\u0001H'J\u0012\u0010¤\u0001\u001a\u00030¥\u00012\u0006\u0010j\u001a\u00020kH'J\u0014\u0010¦\u0001\u001a\u00030§\u00012\b\u0010¨\u0001\u001a\u00030©\u0001H'J\u0014\u0010ª\u0001\u001a\u00030«\u00012\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H'J\u0014\u0010®\u0001\u001a\u00030¯\u00012\b\u0010°\u0001\u001a\u00030±\u0001H'J\u0014\u0010²\u0001\u001a\u00030³\u00012\b\u0010´\u0001\u001a\u00030µ\u0001H'J\u0014\u0010¶\u0001\u001a\u00030·\u00012\b\u0010¸\u0001\u001a\u00030¹\u0001H'J\u0014\u0010º\u0001\u001a\u00030»\u00012\b\u0010¼\u0001\u001a\u00030½\u0001H'J\u0014\u0010¾\u0001\u001a\u00030¿\u00012\b\u0010À\u0001\u001a\u00030Á\u0001H'J\u0014\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010Ä\u0001\u001a\u00030Å\u0001H'J\u0014\u0010Æ\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u0001H'J\u0014\u0010Ê\u0001\u001a\u00030Ë\u00012\b\u0010Ì\u0001\u001a\u00030Í\u0001H'J\u0014\u0010Î\u0001\u001a\u00030Ï\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H'J\u0014\u0010Ò\u0001\u001a\u00030Ó\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u0001H'J\u0014\u0010Ö\u0001\u001a\u00030×\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001H'J\u0014\u0010Ú\u0001\u001a\u00030Û\u00012\b\u0010Ü\u0001\u001a\u00030Ý\u0001H'J\u0014\u0010Þ\u0001\u001a\u00030ß\u00012\b\u0010à\u0001\u001a\u00030á\u0001H'J\u0014\u0010â\u0001\u001a\u00030ã\u00012\b\u0010ä\u0001\u001a\u00030å\u0001H'J\u0014\u0010æ\u0001\u001a\u00030ç\u00012\b\u0010è\u0001\u001a\u00030é\u0001H'J\u0014\u0010ê\u0001\u001a\u00030ë\u00012\b\u0010ì\u0001\u001a\u00030í\u0001H'J\u0014\u0010î\u0001\u001a\u00030ï\u00012\b\u0010ð\u0001\u001a\u00030ñ\u0001H'J\u0014\u0010ò\u0001\u001a\u00030ó\u00012\b\u0010ô\u0001\u001a\u00030õ\u0001H'J\u0014\u0010ö\u0001\u001a\u00030÷\u00012\b\u0010ø\u0001\u001a\u00030ù\u0001H'J\u0014\u0010ú\u0001\u001a\u00030û\u00012\b\u0010ü\u0001\u001a\u00030ý\u0001H'J\u0014\u0010þ\u0001\u001a\u00030ÿ\u00012\b\u0010\u0080\u0002\u001a\u00030\u0081\u0002H'J\u0014\u0010\u0082\u0002\u001a\u00030\u0083\u00022\b\u0010\u0080\u0002\u001a\u00030\u0084\u0002H'J\u0014\u0010\u0085\u0002\u001a\u00030\u0086\u00022\b\u0010\u0087\u0002\u001a\u00030\u0088\u0002H'J\u0014\u0010\u0089\u0002\u001a\u00030\u008a\u00022\b\u0010\u008b\u0002\u001a\u00030\u008c\u0002H'J\u0014\u0010\u008d\u0002\u001a\u00030\u008e\u00022\b\u0010\u008f\u0002\u001a\u00030\u0090\u0002H'J\u0014\u0010\u0091\u0002\u001a\u00030\u0092\u00022\b\u0010\u0093\u0002\u001a\u00030\u0094\u0002H'J\u0014\u0010\u0095\u0002\u001a\u00030\u0096\u00022\b\u0010\u0097\u0002\u001a\u00030\u0098\u0002H'J\u0014\u0010\u0099\u0002\u001a\u00030\u009a\u00022\b\u0010\u009b\u0002\u001a\u00030\u009c\u0002H'J\u0014\u0010\u009d\u0002\u001a\u00030\u009e\u00022\b\u0010\u009f\u0002\u001a\u00030 \u0002H'¨\u0006¡\u0002"}, d2 = {"Lcom/box/android/data/di/DataModule;", "", "<init>", "()V", "provideCollectionResourceService", "Lcom/box/android/domain/services/ICollectionsService;", "collectionsResourceService", "Lcom/box/android/data/service/impl/CollectionsService;", "provideLegacyBridgeService", "Lcom/box/android/domain/services/ILegacyBridgeService;", "legacyBridgeService", "Lcom/box/android/data/service/impl/LegacyBridgeService;", "provideUserService", "Lcom/box/android/domain/services/IUserService;", "userService", "Lcom/box/android/data/service/impl/UserService;", "provideSessionManager", "Lcom/box/android/domain/services/ISessionManager;", "sessionService", "Lcom/box/android/data/service/impl/SessionManager;", "provideAnnotationsService", "Lcom/box/android/domain/services/IAnnotationsService;", "annotationsService", "Lcom/box/android/data/service/impl/AnnotationsService;", "provideFileActivitiesService", "Lcom/box/android/domain/services/IFileActivitiesService;", "fileActivitiesService", "Lcom/box/android/data/service/impl/FileActivitiesService;", "providePushNotificationSettingsService", "Lcom/box/android/domain/services/IPushNotificationSettingsService;", "pushNotificationSettingsService", "Lcom/box/android/data/service/impl/PushNotificationSettingsService;", "provideInboxNotificationService", "Lcom/box/android/domain/services/IInboxNotificationService;", "inboxNotificationService", "Lcom/box/android/data/service/impl/InboxNotificationService;", "provideRepresentationsService", "Lcom/box/android/domain/services/IRepresentationsService;", "representationsService", "Lcom/box/android/data/service/impl/RepresentationsService;", "provideAuthenticationService", "Lcom/box/android/domain/services/IAuthenticationService;", "authenticationService", "Lcom/box/android/data/service/impl/AuthenticationService;", "provideObservabilityService", "Lcom/box/android/domain/services/IObservabilityService;", "observabilityService", "Lcom/box/android/data/service/impl/ObservabilityService;", "provideFileSystem", "Lcom/box/android/data/persistence/IFileSystem;", "fileSystem", "Lcom/box/android/data/persistence/FileSystem;", "provideMetricsLoggingService", "Lcom/box/android/domain/services/IMetricsLoggingService;", "metricsLoggingService", "Lcom/box/android/data/service/impl/MetricsLoggingService;", "providesUploadFileService", "Lcom/box/android/domain/services/IUploadFileService;", "uploadFileService", "Lcom/box/android/data/service/impl/UploadFileService;", "providesUploadFileProvider", "Lcom/box/android/domain/services/IUploadFileProvider;", "uploadFileProvider", "Lcom/box/android/data/service/UploadFileProvider;", "providesContentFileService", "Lcom/box/android/domain/services/IContentFileService;", "contentFileService", "Lcom/box/android/data/service/ContentFileService;", "provideDeleteFileService", "Lcom/box/android/domain/services/IDeleteFileService;", "deleteFileService", "Lcom/box/android/data/service/impl/DeleteFileService;", "provideUpdateItemInfoService", "Lcom/box/android/domain/services/IUpdateItemInfoService;", "updateItemInfoService", "Lcom/box/android/data/service/impl/UpdateItemInfoService;", "provideFileMetadataService", "Lcom/box/android/domain/services/IFileMetadataService;", "fileMetadataService", "Lcom/box/android/data/service/impl/FileMetadataService;", "provideSharedLinkService", "Lcom/box/android/domain/services/ISharedLinkService;", "sharedLinkService", "Lcom/box/android/data/service/impl/SharedLinkService;", "provideItemCollaborationsService", "Lcom/box/android/domain/services/IItemCollaborationsService;", "itemCollaborationsService", "Lcom/box/android/data/service/impl/ItemCollaborationsService;", "provideInboxCollaborationService", "Lcom/box/android/domain/services/IInboxCollaborationService;", "inboxCollaborationService", "Lcom/box/android/data/service/impl/InboxCollaborationService;", "provideDocumentScanService", "Lcom/box/android/domain/services/IDocumentScanService;", "documentScanService", "Lcom/box/android/data/service/impl/DocumentScanService;", "provideCaptureHistoryFilesService", "Lcom/box/android/domain/services/ICaptureHistoryFilesService;", "captureHistoryFilesService", "Lcom/box/android/data/service/impl/CaptureHistoryFilesService;", "providesCreateFolderService", "Lcom/box/android/domain/services/ICreateFolderService;", "folderService", "Lcom/box/android/data/service/impl/CreateFolderService;", "providesBaseModelController", "Lcom/box/android/coreservices/modelcontroller/IBaseModelController;", "baseModelController", "Lcom/box/android/data/controller/impl/BaseModelController;", "provideLocalItemService", "Lcom/box/android/domain/services/ILocalItemService;", "localItemService", "Lcom/box/android/data/service/impl/LocalItemService;", "provideCommentService", "Lcom/box/android/domain/services/ICommentService;", "commentService", "Lcom/box/android/data/service/impl/CommentService;", "provideTaskService", "Lcom/box/android/domain/services/ITaskService;", "taskService", "Lcom/box/android/data/service/impl/TaskService;", "provideRecentsService", "Lcom/box/android/domain/services/IRecentsService;", "recentsService", "Lcom/box/android/data/service/impl/RecentsService;", "provideRecentNotesService", "Lcom/box/android/domain/services/IRecentNotesService;", "recentNotesService", "Lcom/box/android/data/service/impl/RecentNotesService;", "provideDefaultNoteFolderService", "Lcom/box/android/domain/services/IDefaultNoteFolderService;", "defaultNoteFolderService", "Lcom/box/android/data/service/impl/DefaultNoteFolderService;", "provideOfflineService", "Lcom/box/android/domain/services/IOfflineService;", "offlineService", "Lcom/box/android/data/service/impl/OfflineService;", "provideOfflineFilesPolicyEnforcer", "Lcom/box/android/domain/services/IOfflineFilesPolicyEnforcer;", "offlineFilesPolicyEnforcer", "Lcom/box/android/data/service/impl/OfflineFilesPolicyEnforcer;", "providePreviousVersionPreviewService", "Lcom/box/android/domain/services/IPreviousVersionPreviewService;", "previousVersionPreviewService", "Lcom/box/android/data/service/impl/preview/PreviousVersionPreviewService;", "provideFileVersionService", "Lcom/box/android/domain/services/IFileVersionService;", "fileVersionService", "Lcom/box/android/data/service/impl/FileVersionService;", "provideJobService", "Lcom/box/android/domain/services/IJobService;", "jobService", "Lcom/box/android/data/jobs/JobService;", "provideJobManagerBridgeService", "Lcom/box/android/domain/services/IJobManagerBridgeService;", "jobManagerBridgeService", "Lcom/box/android/data/jobs/JobManagerBridgeService;", "provideJobWorkerFactory", "Lcom/box/android/domain/services/IJobWorkerFactory;", "jobWorkerFactory", "Lcom/box/android/data/jobs/JobWorkerFactory;", "provideLastCaptureThumbnailService", "Lcom/box/android/domain/services/ICaptureThumbnailService;", "captureThumbnailService", "Lcom/box/android/data/service/impl/CaptureThumbnailService;", "provideBaseModelControllerService", "Lcom/box/android/domain/services/IBaseModelControllerService;", "provideBatchOperationsService", "Lcom/box/android/domain/services/IBatchOperationsService;", "batchOperationsService", "Lcom/box/android/coreservices/modelcontroller/BatchOperationsService;", "provideLegacyCommentController", "Lcom/box/android/domain/controller/ILegacyCommentsController;", "legacyCommentsController", "Lcom/box/android/data/controller/impl/LegacyCommentsController;", "provideCommentControllerBridge", "Lcom/box/android/domain/controller/ICommentControllerBridge;", "commentControllerBridge", "Lcom/box/android/data/controller/impl/CommentControllerBridge;", "capturePreferenceService", "Lcom/box/android/domain/services/ICapturePreferencesService;", "capturePreferencesService", "Lcom/box/android/data/service/impl/CapturePreferencesService;", "provideAppRestrictionsManager", "Lcom/box/android/domain/services/IAppRestrictionsManager;", "appRestrictionsManager", "Lcom/box/android/data/service/impl/AppRestrictionsManager;", "provideBVEManager", "Lcom/box/android/domain/services/IBVEManager;", "bveManager", "Lcom/box/android/data/service/impl/BVEManager;", "provideRemoteItemService", "Lcom/box/android/domain/services/IRemoteItemService;", "remoteItemService", "Lcom/box/android/data/service/impl/RemoteItemService;", "providePreviewService", "Lcom/box/android/domain/services/IPreviewService;", "previewService", "Lcom/box/android/data/service/impl/preview/BridgedPreviewService;", "provideThumbnailService", "Lcom/box/android/domain/services/IThumbnailService;", "thumbnailService", "Lcom/box/android/data/service/impl/thumbnail/ThumbnailService;", "provideFileWithRepresentationsService", "Lcom/box/android/domain/services/IFileWithRepresentationsService;", "fileWithRepresentationsService", "Lcom/box/android/data/service/impl/preview/FileWithRepresentationsService;", "provideGalleryItemsService", "Lcom/box/android/domain/services/IGalleryItemsService;", "galleryItemsService", "Lcom/box/android/data/service/impl/preview/GalleryItemsService;", "provideAudioPlaylistItemsService", "Lcom/box/android/domain/services/IAudioPlaylistItemsService;", "audioPlaylistItemsService", "Lcom/box/android/data/service/impl/preview/AudioPlaylistItemsService;", "provideBoxAiService", "Lcom/box/android/domain/services/IBoxAiService;", "boxAiService", "Lcom/box/android/data/service/impl/boxai/BoxAiService;", "provideSearchService", "Lcom/box/android/domain/services/ISearchService;", "searchService", "Lcom/box/android/data/service/impl/SearchService;", "provideGeniusScanLicenseService", "Lcom/box/android/domain/services/IGeniusScanLicenseService;", NotificationCompat.CATEGORY_SERVICE, "Lcom/box/android/data/service/impl/GeniusScanLicenseService;", "providesPreviewSettingsService", "Lcom/box/android/domain/services/IPreviewSettingsService;", "previewSettingsService", "Lcom/box/android/data/service/impl/PreviewSettingsService;", "provideRumInstrumentation", "Lcom/box/android/data/observability/RumInstrumentation;", "splunkRumInstrumentation", "Lcom/box/android/data/observability/SplunkRumInstrumentation;", "provideClientSettingsService", "Lcom/box/android/domain/services/IClientSettingsService;", "clientSettingsService", "Lcom/box/android/data/service/impl/ClientSettingsService;", "provideBoxPreviewController", "Lcom/box/android/domain/controller/IPreviewController;", "boxPreviewController", "Lcom/box/android/data/controller/impl/BoxPreviewController;", "provideOpenTelemetryService", "Lcom/box/android/data/observability/OpenTelemetryInstrumentation;", "openTelemetryServiceImpl", "Lcom/box/android/data/observability/OpenTelemetryInstrumentationImpl;", "provideApdexScoreProvider", "Lcom/box/android/domain/services/IApdexScoreProvider;", "apdexScoreProvider", "Lcom/box/android/data/service/impl/ApdexScoreProvider;", "provideHubsService", "Lcom/box/android/domain/services/IHubsService;", "hubsService", "Lcom/box/android/data/service/impl/HubsService;", "provideBoxUriSupportChecker", "Lcom/box/android/domain/utils/IBoxUriSupportChecker;", "boxUriSupportChecker", "Lcom/box/android/data/utilities/BoxUriSupportChecker;", "provideBoxWebBridgeAuthenticator", "Lcom/box/android/domain/webBridgeAuth/IBoxWebBridgeAuthenticator;", "Lcom/box/android/data/webBridgeAuth/BoxWebBridgeAuthenticator;", "provideBoxSessionValidator", "Lcom/box/android/domain/webBridgeAuth/IBoxCsrfTokenManager;", "boxCsrfTokenManager", "Lcom/box/android/domain/webBridgeAuth/BoxCsrfTokenManager;", "provideForceUpdateRepository", "Lcom/box/android/domain/configuration/IForceUpdateRepository;", "forceUpdateRepository", "Lcom/box/android/data/persistence/ForceUpdateRepository;", "provideMoveCopyJobInputValidator", "Lcom/box/android/data/jobs/IMoveCopyJobInputValidator;", "moveCopyJobInputValidator", "Lcom/box/android/data/jobs/MoveCopyJobInputValidator;", "provideAuthTokenService", "Lcom/box/android/domain/services/AuthTokenService;", "oAuthAccessTokenService", "Lcom/box/android/data/service/impl/OAuthAccessTokenService;", "bindOfflineStateStorage", "Lcom/box/android/domain/offline/IOfflineStateStorage;", "roomStorage", "Lcom/box/android/data/persistence/offline/OfflineStateStorage;", "provideWatermarkService", "Lcom/box/android/domain/services/IWatermarkService;", "watermarkService", "Lcom/box/android/data/service/impl/WatermarkService;", "provideTabPersistenceService", "Lcom/box/android/domain/services/ITabPersistenceService;", "tabPersistenceService", "Lcom/box/android/data/service/impl/TabPersistenceService;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class DataModule {
    @Singleton
    @Binds
    public abstract IOfflineStateStorage bindOfflineStateStorage(OfflineStateStorage roomStorage);

    @Binds
    public abstract ICapturePreferencesService capturePreferenceService(CapturePreferencesService capturePreferencesService);

    @Binds
    public abstract IAnnotationsService provideAnnotationsService(AnnotationsService annotationsService);

    @Binds
    public abstract IApdexScoreProvider provideApdexScoreProvider(ApdexScoreProvider apdexScoreProvider);

    @Binds
    public abstract IAppRestrictionsManager provideAppRestrictionsManager(AppRestrictionsManager appRestrictionsManager);

    @Binds
    public abstract IAudioPlaylistItemsService provideAudioPlaylistItemsService(AudioPlaylistItemsService audioPlaylistItemsService);

    @Binds
    public abstract AuthTokenService provideAuthTokenService(OAuthAccessTokenService oAuthAccessTokenService);

    @Binds
    public abstract IAuthenticationService provideAuthenticationService(AuthenticationService authenticationService);

    @Binds
    public abstract IBVEManager provideBVEManager(BVEManager bveManager);

    @Binds
    public abstract IBaseModelControllerService provideBaseModelControllerService(BaseModelController baseModelController);

    @Binds
    public abstract IBatchOperationsService provideBatchOperationsService(BatchOperationsService batchOperationsService);

    @Binds
    public abstract IBoxAiService provideBoxAiService(BoxAiService boxAiService);

    @Singleton
    @Binds
    public abstract IPreviewController provideBoxPreviewController(BoxPreviewController boxPreviewController);

    @Binds
    public abstract IBoxCsrfTokenManager provideBoxSessionValidator(BoxCsrfTokenManager boxCsrfTokenManager);

    @Binds
    public abstract IBoxUriSupportChecker provideBoxUriSupportChecker(BoxUriSupportChecker boxUriSupportChecker);

    @Binds
    public abstract IBoxWebBridgeAuthenticator provideBoxWebBridgeAuthenticator(BoxWebBridgeAuthenticator boxUriSupportChecker);

    @Binds
    public abstract ICaptureHistoryFilesService provideCaptureHistoryFilesService(CaptureHistoryFilesService captureHistoryFilesService);

    @Binds
    public abstract IClientSettingsService provideClientSettingsService(ClientSettingsService clientSettingsService);

    @Binds
    public abstract ICollectionsService provideCollectionResourceService(CollectionsService collectionsResourceService);

    @Binds
    public abstract ICommentControllerBridge provideCommentControllerBridge(CommentControllerBridge commentControllerBridge);

    @Binds
    public abstract ICommentService provideCommentService(CommentService commentService);

    @Binds
    public abstract IDefaultNoteFolderService provideDefaultNoteFolderService(DefaultNoteFolderService defaultNoteFolderService);

    @Binds
    public abstract IDeleteFileService provideDeleteFileService(DeleteFileService deleteFileService);

    @Binds
    public abstract IDocumentScanService provideDocumentScanService(DocumentScanService documentScanService);

    @Binds
    public abstract IFileActivitiesService provideFileActivitiesService(FileActivitiesService fileActivitiesService);

    @Binds
    public abstract IFileMetadataService provideFileMetadataService(FileMetadataService fileMetadataService);

    @Binds
    public abstract IFileSystem provideFileSystem(FileSystem fileSystem);

    @Binds
    public abstract IFileVersionService provideFileVersionService(FileVersionService fileVersionService);

    @Binds
    public abstract IFileWithRepresentationsService provideFileWithRepresentationsService(FileWithRepresentationsService fileWithRepresentationsService);

    @Binds
    public abstract IForceUpdateRepository provideForceUpdateRepository(ForceUpdateRepository forceUpdateRepository);

    @Binds
    public abstract IGalleryItemsService provideGalleryItemsService(GalleryItemsService galleryItemsService);

    @Binds
    public abstract IGeniusScanLicenseService provideGeniusScanLicenseService(GeniusScanLicenseService service);

    @Binds
    public abstract IHubsService provideHubsService(HubsService hubsService);

    @Binds
    public abstract IInboxCollaborationService provideInboxCollaborationService(InboxCollaborationService inboxCollaborationService);

    @Binds
    public abstract IInboxNotificationService provideInboxNotificationService(InboxNotificationService inboxNotificationService);

    @Binds
    public abstract IItemCollaborationsService provideItemCollaborationsService(ItemCollaborationsService itemCollaborationsService);

    @Binds
    public abstract IJobManagerBridgeService provideJobManagerBridgeService(JobManagerBridgeService jobManagerBridgeService);

    @Binds
    public abstract IJobService provideJobService(JobService jobService);

    @Binds
    public abstract IJobWorkerFactory provideJobWorkerFactory(JobWorkerFactory jobWorkerFactory);

    @Binds
    public abstract ICaptureThumbnailService provideLastCaptureThumbnailService(CaptureThumbnailService captureThumbnailService);

    @Binds
    public abstract ILegacyBridgeService provideLegacyBridgeService(LegacyBridgeService legacyBridgeService);

    @Binds
    public abstract ILegacyCommentsController provideLegacyCommentController(LegacyCommentsController legacyCommentsController);

    @Binds
    public abstract ILocalItemService provideLocalItemService(LocalItemService localItemService);

    @Binds
    public abstract IMetricsLoggingService provideMetricsLoggingService(MetricsLoggingService metricsLoggingService);

    @Binds
    public abstract IMoveCopyJobInputValidator provideMoveCopyJobInputValidator(MoveCopyJobInputValidator moveCopyJobInputValidator);

    @Binds
    public abstract IObservabilityService provideObservabilityService(ObservabilityService observabilityService);

    @Binds
    public abstract IOfflineFilesPolicyEnforcer provideOfflineFilesPolicyEnforcer(OfflineFilesPolicyEnforcer offlineFilesPolicyEnforcer);

    @Binds
    public abstract IOfflineService provideOfflineService(OfflineService offlineService);

    @Binds
    public abstract OpenTelemetryInstrumentation provideOpenTelemetryService(OpenTelemetryInstrumentationImpl openTelemetryServiceImpl);

    @Binds
    public abstract IPreviewService providePreviewService(BridgedPreviewService previewService);

    @Binds
    public abstract IPreviousVersionPreviewService providePreviousVersionPreviewService(PreviousVersionPreviewService previousVersionPreviewService);

    @Binds
    public abstract IPushNotificationSettingsService providePushNotificationSettingsService(PushNotificationSettingsService pushNotificationSettingsService);

    @Binds
    public abstract IRecentNotesService provideRecentNotesService(RecentNotesService recentNotesService);

    @Binds
    public abstract IRecentsService provideRecentsService(RecentsService recentsService);

    @Binds
    public abstract IRemoteItemService provideRemoteItemService(RemoteItemService remoteItemService);

    @Binds
    public abstract IRepresentationsService provideRepresentationsService(RepresentationsService representationsService);

    @Binds
    public abstract RumInstrumentation provideRumInstrumentation(SplunkRumInstrumentation splunkRumInstrumentation);

    @Binds
    public abstract ISearchService provideSearchService(SearchService searchService);

    @Binds
    public abstract ISessionManager provideSessionManager(SessionManager sessionService);

    @Binds
    public abstract ISharedLinkService provideSharedLinkService(SharedLinkService sharedLinkService);

    @Binds
    public abstract ITabPersistenceService provideTabPersistenceService(TabPersistenceService tabPersistenceService);

    @Binds
    public abstract ITaskService provideTaskService(TaskService taskService);

    @Binds
    public abstract IThumbnailService provideThumbnailService(ThumbnailService thumbnailService);

    @Binds
    public abstract IUpdateItemInfoService provideUpdateItemInfoService(UpdateItemInfoService updateItemInfoService);

    @Binds
    public abstract IUserService provideUserService(UserService userService);

    @Binds
    public abstract IWatermarkService provideWatermarkService(WatermarkService watermarkService);

    @Binds
    public abstract IBaseModelController providesBaseModelController(BaseModelController baseModelController);

    @Binds
    public abstract IContentFileService providesContentFileService(ContentFileService contentFileService);

    @Binds
    public abstract ICreateFolderService providesCreateFolderService(CreateFolderService folderService);

    @Binds
    public abstract IPreviewSettingsService providesPreviewSettingsService(PreviewSettingsService previewSettingsService);

    @Binds
    public abstract IUploadFileProvider providesUploadFileProvider(UploadFileProvider uploadFileProvider);

    @Binds
    public abstract IUploadFileService providesUploadFileService(UploadFileService uploadFileService);
}
