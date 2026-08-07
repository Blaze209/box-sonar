package com.box.android.modelcontroller;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.UriPermission;
import android.net.Uri;
import android.text.TextUtils;
import androidx.documentfile.provider.DocumentFile;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.analytics.DownloadAnalyticsUtils;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.FileUtil;
import com.box.android.coreservices.exceptions.FileTransferException;
import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.dao.UploadModelBoxFile;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.BoxTransferFutureTask;
import com.box.android.coreservices.modelcontroller.BoxUploadControllerHelper;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.modelcontroller.messages.BoxDownloadFileMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxFileTransferMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxPreflightCheckMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxUploadFileMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.coreservices.utilities.PreviewOrigin;
import com.box.android.data.controller.impl.BaseModelController;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.exceptions.PermissionDeniedException;
import com.box.android.domain.identity.Crypto;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.preview.PreviewContentType;
import com.box.android.domain.utils.MimeTypeHelper;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.localrepo.LocalFiles;
import com.box.android.localrepo.LocalSharedPreferences;
import com.box.android.localrepo.LocalStatics;
import com.box.android.preview.BoxThumbnailRequests;
import com.box.androidsdk.content.BoxApiFile;
import com.box.androidsdk.content.BoxApiPreview;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxExtendedApiPreview;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.listeners.ProgressListener;
import com.box.androidsdk.content.models.BoxDocumentFile;
import com.box.androidsdk.content.models.BoxDownload;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxUploadSession;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.requests.BoxRequestDownload;
import com.box.androidsdk.content.requests.BoxRequestUpload;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsPreview;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.requests.BoxResponseBatch;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.requests.BoxRequestUploadNewVersionFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes12.dex */
public class MoCoBoxTransfers extends BaseModelController implements IMoCoBoxTransfers {
    private static final int PREFLIGHT_CHECK_MIN_SIZE = 200000;
    private final BoxThumbnailRequests boxThumbnailRequests;
    protected FeatureFlips featureFlips;
    BoxExtendedApiFile mBoxApiFile;
    BoxExtendedApiFolder mBoxApiFolder;
    protected BoxExtendedApiPreview mBoxApiPreview;
    protected BoxApiPrivate mBoxApiPrivate;
    protected IPreviewController mPreviewController;

    @Inject
    public MoCoBoxTransfers(IUserContextManager iUserContextManager, Context context, BoxThumbnailRequests boxThumbnailRequests, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxApiPrivate boxApiPrivate, BoxExtendedApiPreview boxExtendedApiPreview, IPreviewController iPreviewController, FeatureFlips featureFlips) {
        super(iUserContextManager, context);
        this.boxThumbnailRequests = boxThumbnailRequests;
        this.mBoxApiFile = boxExtendedApiFile;
        this.mBoxApiFolder = boxExtendedApiFolder;
        this.mBoxApiPrivate = boxApiPrivate;
        this.mBoxApiPreview = boxExtendedApiPreview;
        this.mPreviewController = iPreviewController;
        this.featureFlips = featureFlips;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkBasicError(BoxFileTransferMessage boxFileTransferMessage, ProgressReporter.FileTransferProgressListener fileTransferProgressListener) {
        if (boxFileTransferMessage.requiresWifi() && !CommonBoxUtil.isOnWifi()) {
            fileTransferProgressListener.onError(new FileTransferException(JobItem.ErrorType.WIFI_REQUIRED));
            boxFileTransferMessage.setException(new FileTransferException(JobItem.ErrorType.WIFI_REQUIRED));
            BoxLogUtils.d(IMoCoBoxTransfers.UPLOADS_TAG, "Pre-flight check failed due to wifi only requirement");
            return true;
        }
        File javaFilePayload = boxFileTransferMessage.getJavaFilePayload();
        if ((javaFilePayload instanceof UploadModelBoxFile.UriFile) || javaFilePayload == null || (javaFilePayload.isFile() && javaFilePayload.canRead() && javaFilePayload.length() > 0)) {
            return false;
        }
        fileTransferProgressListener.onError(new FileTransferException(JobItem.ErrorType.IO));
        boxFileTransferMessage.setException(new FileTransferException(JobItem.ErrorType.IO));
        BoxLogUtils.d(IMoCoBoxTransfers.UPLOADS_TAG, "Pre-flight check failed. Is item a file: " + javaFilePayload.isFile() + ", can read file: " + javaFilePayload.canRead());
        return true;
    }

    private BoxPreflightCheckMessage checkUpload(String str, String str2, String str3, boolean z, long j) {
        BoxPreflightCheckMessage boxPreflightCheckMessage = new BoxPreflightCheckMessage();
        try {
            if (z) {
                this.mBoxApiPrivate.getCanUploadFile().setName(str).setSize(j).setParent(str2).send();
            } else {
                this.mBoxApiPrivate.getCanUploadNewVersion(str2).setName(str).setSize(j).send();
            }
            boxPreflightCheckMessage.setPayload((Boolean) true);
            boxPreflightCheckMessage.setSuccess(true);
            return boxPreflightCheckMessage;
        } catch (Exception e) {
            boxPreflightCheckMessage.setPayload((Boolean) false);
            boxPreflightCheckMessage.setSuccess(false);
            boxPreflightCheckMessage.setException(e);
            return boxPreflightCheckMessage;
        }
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers
    public BoxTransferFutureTask<BoxFileTransferMessage> uploadFile(String str, String str2, UploadModelBoxFile.UriFile uriFile, boolean z, IMoCoBoxTransfers.TransferSourceType transferSourceType, ProgressReporter.FileTransferProgressListener fileTransferProgressListener, BoxExtendedApiFile boxExtendedApiFile, BoxUploadSession boxUploadSession, int i, long j) {
        final NewFileUploadController newFileUploadController = new NewFileUploadController(this, this.mUserContextManager, this.mBoxApiFile, uriFile, str2, str, fileTransferProgressListener, transferSourceType, z, i, j);
        if (boxUploadSession != null) {
            newFileUploadController.setMultiputSession(boxUploadSession);
        }
        return new BoxTransferFutureTask<BoxFileTransferMessage>(newFileUploadController, IBaseModelController.INSTANCE.getNextRequestId()) { // from class: com.box.android.modelcontroller.MoCoBoxTransfers.1
            @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
            public boolean cancel(boolean z2) {
                return newFileUploadController.cancel(z2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x0071 A[PHI: r3
      0x0071: PHI (r3v5 java.lang.String) = 
      (r3v0 java.lang.String)
      (r3v13 java.lang.String)
      (r3v13 java.lang.String)
      (r3v13 java.lang.String)
      (r3v13 java.lang.String)
      (r3v13 java.lang.String)
     binds: [B:20:0x0070, B:8:0x0028, B:53:0x0071, B:14:0x0060, B:16:0x0068, B:12:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    public boolean precheckUploadError(String str, String str2, String str3, boolean z, Long l, ProgressReporter.FileTransferProgressListener fileTransferProgressListener) {
        String parentId;
        boolean z2;
        BoxUser userInfo = this.mUserContextManager.getUserInfo();
        JobItem.ErrorType errorType = null;
        try {
            if (l.longValue() < 200000) {
                parentId = z ? str2 : getParentId(this.mBoxApiFile.getInfoRequest(str2).sendForCachedResult());
                if (parentId != null) {
                    try {
                        if ((!this.mBoxApiFolder.getInfoRequest(parentId).sendForCachedResult().getOwnedBy().getUserId().equals(userInfo.getUserId()) && !((LocalStatics) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_STATIC_VARIABLE)).isPreflightFolderPreviouslySuccessful(parentId)) || str.contains("\\") || str.contains("/")) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    z2 = true;
                }
            } else {
                z2 = true;
                parentId = null;
            }
        } catch (Exception unused2) {
            parentId = null;
        }
        String str4 = parentId;
        if (z2) {
            BoxPreflightCheckMessage boxPreflightCheckMessageCheckUpload = checkUpload(str, str2, str3 != null ? str3 : str4, z, l.longValue());
            if (!boxPreflightCheckMessageCheckUpload.wasSuccessful()) {
                int i = AnonymousClass6.$SwitchMap$com$box$android$coreservices$utilities$CoreServiceUtils$ErrorType[boxPreflightCheckMessageCheckUpload.getErrorType().ordinal()];
                if (i == 1) {
                    errorType = JobItem.ErrorType.PERMISSION;
                } else if (i == 2 || i == 3 || i == 4) {
                    errorType = JobItem.ErrorType.EXCEEDS_USER_UPLOAD_LIMIT;
                } else if (i == 5) {
                    errorType = JobItem.ErrorType.CONFLICTS_WITH_EXISTING;
                } else if (boxPreflightCheckMessageCheckUpload.getException() == null) {
                    errorType = JobItem.ErrorType.GENERIC_EXCEPTION;
                }
                if (errorType == null) {
                    fileTransferProgressListener.onError(boxPreflightCheckMessageCheckUpload.getException());
                } else {
                    fileTransferProgressListener.onError(new FileTransferException(errorType));
                }
                return true;
            }
            if (str4 != null) {
                ((LocalStatics) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_STATIC_VARIABLE)).updatePreflightFolderSuccess(str4);
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: com.box.android.modelcontroller.MoCoBoxTransfers$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$coreservices$utilities$CoreServiceUtils$ErrorType;

        static {
            int[] iArr = new int[CoreServiceUtils.ErrorType.values().length];
            $SwitchMap$com$box$android$coreservices$utilities$CoreServiceUtils$ErrorType = iArr;
            try {
                iArr[CoreServiceUtils.ErrorType.ACCESS_DENIED_ERR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$utilities$CoreServiceUtils$ErrorType[CoreServiceUtils.ErrorType.FILESIZE_LIMIT_ERR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$utilities$CoreServiceUtils$ErrorType[CoreServiceUtils.ErrorType.BOX_API_INSUFFICIENT_STORAGE_ERR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$utilities$CoreServiceUtils$ErrorType[CoreServiceUtils.ErrorType.ACCOUNT_SPACE_ERR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$utilities$CoreServiceUtils$ErrorType[CoreServiceUtils.ErrorType.NAME_EXISTS_ERR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public class NewVersionUploadController extends BoxUploadControllerHelper {
        private BoxFile mBoxFile;
        private boolean mCheckEtag;

        public NewVersionUploadController(IBaseModelController iBaseModelController, IUserContextManager iUserContextManager, BoxExtendedApiFile boxExtendedApiFile, UploadModelBoxFile.UriFile uriFile, String str, BoxFile boxFile, boolean z, ProgressReporter.FileTransferProgressListener fileTransferProgressListener, IMoCoBoxTransfers.TransferSourceType transferSourceType, boolean z2, int i, long j) {
            super(iBaseModelController, iUserContextManager, boxExtendedApiFile, uriFile, str, fileTransferProgressListener, transferSourceType, z2, i, j);
            this.mCheckEtag = z;
            this.mBoxFile = boxFile;
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxUploadControllerHelper
        protected BoxFolder getParentFolder() {
            return this.mBoxFile.getParent();
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxUploadControllerHelper
        protected BoxRequestUpload createUploadRequest() throws FileNotFoundException {
            BoxRequestUploadNewVersionFile uploadNewVersionRequest = this.mBoxApiFile.getUploadNewVersionRequest(this.mFileToUpload.getInputStream(), this.mBoxFile.getUserId(), this.mRequestHelper);
            if (!StringUtils.isEmpty(this.mFileName) && !this.mFileName.equals(this.mBoxFile.getName())) {
                uploadNewVersionRequest.setFileName(this.mFileName);
            }
            if (this.mCheckEtag && !TextUtils.isEmpty(this.mBoxFile.getEtag())) {
                uploadNewVersionRequest.setIfMatchEtag(this.mBoxFile.getEtag());
            }
            return uploadNewVersionRequest;
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxUploadControllerHelper
        protected BoxUploadSession getMultiputUploadSession() throws ExecutionException, InterruptedException, FileNotFoundException {
            BoxFutureTask<BoxUploadSession> task = this.mBoxApiFile.getCreateUploadVersionSessionRequest(this.mFileToUpload.getInputStream(), this.mFileName, this.mFileToUpload.length(), this.mBoxFile.getUserId()).toTask();
            task.run();
            BoxResponse boxResponse = task.get();
            if (boxResponse.isSuccess()) {
                return (BoxUploadSession) boxResponse.getResult();
            }
            return null;
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxUploadControllerHelper
        protected boolean hasBasicErrors(BoxUploadFileMessage boxUploadFileMessage) {
            if (MoCoBoxTransfers.this.checkBasicError(boxUploadFileMessage, this.mTransferListener)) {
                return true;
            }
            return MoCoBoxTransfers.this.precheckUploadError(this.mFileName, this.mBoxFile.getUserId(), getParentFolder() == null ? null : getParentFolder().getUserId(), false, Long.valueOf(this.mFileToUpload.length()), this.mTransferListener);
        }
    }

    public class NewFileUploadController extends BoxUploadControllerHelper {
        private String mFolderId;

        NewFileUploadController(IBaseModelController iBaseModelController, IUserContextManager iUserContextManager, BoxExtendedApiFile boxExtendedApiFile, UploadModelBoxFile.UriFile uriFile, String str, String str2, ProgressReporter.FileTransferProgressListener fileTransferProgressListener, IMoCoBoxTransfers.TransferSourceType transferSourceType, boolean z, int i, long j) {
            super(iBaseModelController, iUserContextManager, boxExtendedApiFile, uriFile, str, fileTransferProgressListener, transferSourceType, z, i, j);
            this.mFolderId = str2;
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxUploadControllerHelper
        protected BoxFolder getParentFolder() {
            try {
                return MoCoBoxTransfers.this.mBoxApiFolder.getInfoRequest(this.mFolderId).sendForCachedResult();
            } catch (BoxException unused) {
                return null;
            }
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxUploadControllerHelper
        protected BoxRequestUpload createUploadRequest() throws FileNotFoundException {
            return this.mBoxApiFile.getUploadFileRequest(this.mFileToUpload.getInputStream(), this.mFileName, this.mFolderId, this.mRequestHelper);
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxUploadControllerHelper
        protected BoxUploadSession getMultiputUploadSession() throws ExecutionException, InterruptedException, FileNotFoundException {
            BoxFutureTask<BoxUploadSession> task = this.mBoxApiFile.getCreateUploadSessionRequest(this.mFileToUpload.getInputStream(), this.mFileName, this.mFileToUpload.length(), this.mFolderId).toTask();
            task.run();
            BoxResponse boxResponse = task.get();
            if (boxResponse.isSuccess()) {
                return (BoxUploadSession) boxResponse.getResult();
            }
            return null;
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxUploadControllerHelper
        protected boolean hasBasicErrors(BoxUploadFileMessage boxUploadFileMessage) {
            if (MoCoBoxTransfers.this.checkBasicError(boxUploadFileMessage, this.mTransferListener)) {
                return true;
            }
            MoCoBoxTransfers moCoBoxTransfers = MoCoBoxTransfers.this;
            String str = this.mFileName;
            String str2 = this.mFolderId;
            return moCoBoxTransfers.precheckUploadError(str, str2, str2, true, Long.valueOf(this.mFileToUpload.length()), this.mTransferListener);
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxUploadControllerHelper
        protected void onSuccess(BoxUploadFileMessage boxUploadFileMessage) {
            boxUploadFileMessage.setParentFolderId(this.mFolderId);
        }
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers
    public BoxTransferFutureTask<BoxFileTransferMessage> uploadFileNewVersion(BoxFile boxFile, String str, UploadModelBoxFile.UriFile uriFile, boolean z, boolean z2, IMoCoBoxTransfers.TransferSourceType transferSourceType, ProgressReporter.FileTransferProgressListener fileTransferProgressListener, BoxExtendedApiFile boxExtendedApiFile, BoxUploadSession boxUploadSession, int i, long j) {
        final NewVersionUploadController newVersionUploadController = new NewVersionUploadController(this, this.mUserContextManager, this.mBoxApiFile, uriFile, str, boxFile, z2, fileTransferProgressListener, transferSourceType, z, i, j);
        if (boxUploadSession != null) {
            newVersionUploadController.setMultiputSession(boxUploadSession);
        }
        return new BoxTransferFutureTask<BoxFileTransferMessage>(newVersionUploadController, IBaseModelController.INSTANCE.getNextRequestId()) { // from class: com.box.android.modelcontroller.MoCoBoxTransfers.2
            @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
            public boolean cancel(boolean z3) {
                return newVersionUploadController.cancel(z3);
            }
        };
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers
    public BoxTransferFutureTask<BoxFileTransferMessage> savePreviewForOffline(String str, IUserContextManager iUserContextManager, ProgressReporter.FileTransferProgressListener fileTransferProgressListener) {
        return savePreviewForOffline(str, iUserContextManager, fileTransferProgressListener, this.mBoxApiPreview);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers
    public BoxTransferFutureTask<BoxFileTransferMessage> savePreviewForOffline(final String str, final IUserContextManager iUserContextManager, final ProgressReporter.FileTransferProgressListener fileTransferProgressListener, final BoxExtendedApiPreview boxExtendedApiPreview) {
        return new BoxTransferFutureTask<>(new Callable() { // from class: com.box.android.modelcontroller.MoCoBoxTransfers$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$savePreviewForOffline$1(boxExtendedApiPreview, str, fileTransferProgressListener, iUserContextManager);
            }
        }, IBaseModelController.INSTANCE.getNextRequestId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ BoxFileTransferMessage lambda$savePreviewForOffline$1(BoxExtendedApiPreview boxExtendedApiPreview, String str, final ProgressReporter.FileTransferProgressListener fileTransferProgressListener, final IUserContextManager iUserContextManager) throws Exception {
        BoxFileTransferMessage boxFileTransferMessage = new BoxFileTransferMessage(Controller.ACTION_MADE_FILE_AVAILABLE_OFFLINE, Controller.ACTION_MAKING_FILE_AVAILABLE_OFFLINE);
        BoxFile boxFileSendForCachedResult = boxExtendedApiPreview.getInfoRequest(str).sendForCachedResult();
        fileTransferProgressListener.setFileTransferMessage(boxFileTransferMessage);
        boxFileTransferMessage.initFromBoxFile(boxFileSendForCachedResult);
        if (!BoxModelOfflineManager.isOfflineUserSavedBlocking(boxFileSendForCachedResult, iUserContextManager)) {
            fileTransferProgressListener.onError(new CancellationException("no longer wanted by user"));
            return boxFileTransferMessage;
        }
        if (checkIsSaveOnDeviceDisabled()) {
            fileTransferProgressListener.onError(new PermissionDeniedException());
            return boxFileTransferMessage;
        }
        File cachedPreviewFile = this.mUserContextManager.getPreviewStorage().getCachedPreviewFile(boxFileSendForCachedResult, (String) null, (PreviewContentType) null);
        if (cachedPreviewFile != null && cachedPreviewFile.exists()) {
            fileTransferProgressListener.onCompleted(null);
            boxFileTransferMessage.setSuccess(true);
            return boxFileTransferMessage;
        }
        BoxRequestsPreview.PreviewBatchRequest offlineRequests = getOfflineRequests(this.mPreviewController, boxFileSendForCachedResult, iUserContextManager.getBoxSession(BoxBaseApplication.getInstance()));
        if (offlineRequests.hasMainDownloadRequest()) {
            offlineRequests.setProgressListener(new ProgressListener() { // from class: com.box.android.modelcontroller.MoCoBoxTransfers.3
                @Override // com.box.androidsdk.content.listeners.ProgressListener
                public void onProgressChanged(long j, long j2) {
                    fileTransferProgressListener.onProgressChanged(j, j2);
                }
            });
        }
        fileTransferProgressListener.onStarted(null);
        try {
            if (offlineRequests.hasMainDownloadRequest()) {
                BoxResponse boxResponse = ((BoxResponseBatch) performRemote(offlineRequests, new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.modelcontroller.MoCoBoxTransfers$$ExternalSyntheticLambda0
                    @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
                    public final void onCompleted(BoxResponse boxResponse2) {
                        MoCoBoxTransfers.lambda$savePreviewForOffline$0(iUserContextManager, boxResponse2);
                    }
                }).get().getResult()).getResponses().get(offlineRequests.getMainDownloadIndex());
                if (boxResponse.isSuccess()) {
                    boxFileTransferMessage.setBoxDownload((BoxDownload) boxResponse.getResult());
                    boxFileTransferMessage.setSuccess(true);
                    fileTransferProgressListener.onCompleted(null);
                    return boxFileTransferMessage;
                }
                boxFileTransferMessage.setSuccess(false);
                fileTransferProgressListener.onError(boxResponse.getException());
            }
            return boxFileTransferMessage;
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            boxFileTransferMessage.setSuccess(false);
            fileTransferProgressListener.onError(e);
            BoxLogUtils.e("MoCoBoxTransfers", "savePreviewForOffline", e);
            return boxFileTransferMessage;
        }
    }

    static /* synthetic */ void lambda$savePreviewForOffline$0(IUserContextManager iUserContextManager, BoxResponse boxResponse) {
        for (BoxResponse boxResponse2 : ((BoxResponseBatch) boxResponse.getResult()).getResponses()) {
            if (boxResponse2.getRequest() instanceof BoxRequestsFile.GetFileInfo) {
                iUserContextManager.getPreviewStorage().cacheMetadata((BoxItem) boxResponse2.getResult(), BoxApiPreview.METADATA_FILE_INFO_TAG);
            }
        }
    }

    protected BoxRequestsPreview.PreviewBatchRequest getOfflineRequests(IPreviewController iPreviewController, BoxFile boxFile, BoxSession boxSession) {
        BoxRequestsPreview.PreviewBatchRequest previewBatchRequest = new BoxRequestsPreview.PreviewBatchRequest();
        if (boxFile.getSha1() == null) {
            BoxRequestsFile.GetFileInfo getFileInfo = new BoxRequestsFile.GetFileInfo(boxFile.getUserId(), iPreviewController.getApiPreview().getFilesUrl(), boxSession);
            getFileInfo.setFields(BoxFile.ALL_FIELDS);
            previewBatchRequest.addRequest(getFileInfo);
        } else {
            BoxFile boxFile2 = (BoxFile) iPreviewController.getStorage().getMetadata(boxFile, BoxApiPreview.METADATA_FILE_INFO_TAG);
            if (boxFile2 == null || boxFile.getModifiedAt().after(boxFile2.getModifiedAt())) {
                iPreviewController.getStorage().cacheMetadata(boxFile, BoxApiPreview.METADATA_FILE_INFO_TAG);
            }
        }
        String fileExtension = CommonBoxUtil.getFileExtension(boxFile.getName(), "");
        if (SupportedFileExtensions.INSTANCE.isAudioExtension(fileExtension)) {
            previewBatchRequest.addMainDownloadRequest(iPreviewController.getApiPreview().getDownloadPreviewRequest(iPreviewController.getStorage().createPreviewOutputStream(boxFile), boxFile.getUserId(), boxFile.getFileVersion().getUserId(), BoxApiPreview.Extensions.MP3));
            return previewBatchRequest;
        }
        if (SupportedFileExtensions.INSTANCE.isPlayableVideo(fileExtension)) {
            addVideoDownloadRequest(previewBatchRequest, boxFile, iPreviewController);
            return previewBatchRequest;
        }
        if (SupportedFileExtensions.INSTANCE.isDocumentExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isIWorkExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isPresentationExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isSpreadsheetExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isMicrosoftExcelExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isMicrosoftPowerPointExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isMicrosoftWordExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isAutoCADExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isImageExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isVectorExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isAdobePhotoshopExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isAdobeIllustratorExtension(fileExtension)) {
            addDocumentImageRequest(previewBatchRequest, boxFile, iPreviewController, boxSession);
            return previewBatchRequest;
        }
        if (!SupportedFileExtensions.INSTANCE.isGifExtension(fileExtension) && !SupportedFileExtensions.INSTANCE.isCodeExtension(fileExtension)) {
            return previewBatchRequest;
        }
        previewBatchRequest.addMainDownloadRequest(getCacheFileRequest(boxSession, boxFile, iPreviewController.getStorage(), iPreviewController.getApiPreview()));
        return previewBatchRequest;
    }

    private BoxRequestsFile.DownloadFile getCacheFileRequest(BoxSession boxSession, BoxFile boxFile, IBoxStorage iBoxStorage, BoxApiPreview boxApiPreview) {
        if (boxFile == null || SdkUtils.isBlank(boxFile.getUserId())) {
            throw new IllegalArgumentException("Invalid item to cache image thumbnail. Must provide a BoxFile with a valid extension");
        }
        if (boxSession == null || boxSession.getAuthInfo() == null) {
            throw new IllegalArgumentException("A valid BoxSession must be provided to cache file");
        }
        return boxApiPreview.getDownloadRequest(iBoxStorage.createPreviewOutputStream(boxFile), boxFile.getUserId());
    }

    void addDocumentImageRequest(BoxRequestsPreview.PreviewBatchRequest previewBatchRequest, BoxFile boxFile, IPreviewController iPreviewController, BoxSession boxSession) {
        BoxRequestDownload cachePreviewRequest = getCachePreviewRequest(iPreviewController, boxFile, boxSession);
        previewBatchRequest.addMainDownloadRequest(cachePreviewRequest);
        previewBatchRequest.setMandatoryProgressListener(new ProgressForMetadataListener(boxFile, iPreviewController, getPreviewContentType(cachePreviewRequest, boxFile)));
    }

    public BoxRequestDownload getCachePreviewRequest(IPreviewController iPreviewController, BoxFile boxFile, BoxSession boxSession) {
        String fileExtension = CommonBoxUtil.getFileExtension(boxFile.getName(), "");
        if (SupportedFileExtensions.INSTANCE.isImageExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isVectorExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isAdobePhotoshopExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isAdobeIllustratorExtension(fileExtension)) {
            return this.boxThumbnailRequests.getCachePreviewRequest(iPreviewController, boxFile, boxSession);
        }
        if (iPreviewController == null || boxSession == null || boxSession.getAuthInfo() == null) {
            throw new IllegalArgumentException("A valid BoxSession must be provided to cache document preview");
        }
        BoxApiPreview.Extensions extensions = BoxApiPreview.Extensions.PDF;
        return iPreviewController.getApiPreview().getDownloadPreviewRequest(iPreviewController.getStorage().createPreviewOutputStream(boxFile, (String) null, createPreviewContentType(boxFile, extensions)), boxFile.getUserId(), boxFile.getFileVersion().getUserId(), extensions);
    }

    public PreviewContentType createPreviewContentType(BoxFile boxFile, BoxApiPreview.Extensions extensions) {
        if (extensions.toString().equals(CommonBoxUtil.getFileExtension(boxFile.getName(), ""))) {
            return PreviewOrigin.INSTANCE.original();
        }
        return PreviewOrigin.INSTANCE.representationWithExtension(extensions.toString(), null);
    }

    void addVideoDownloadRequest(BoxRequestsPreview.PreviewBatchRequest previewBatchRequest, BoxFile boxFile, IPreviewController iPreviewController) {
        PreviewContentType.Representation representationRepresentationWithExtension = PreviewOrigin.INSTANCE.representationWithExtension(BoxApiPreview.Extensions.MP4.toString(), null);
        previewBatchRequest.addMainDownloadRequest(iPreviewController.getApiPreview().getDownloadPreviewRequest(iPreviewController.getStorage().createPreviewOutputStream(boxFile, (String) null, representationRepresentationWithExtension), boxFile.getUserId(), boxFile.getFileVersion().getUserId(), BoxApiPreview.Extensions.MP4));
        previewBatchRequest.setMandatoryProgressListener(new ProgressForMetadataListener(boxFile, iPreviewController, representationRepresentationWithExtension));
    }

    public class ProgressForMetadataListener implements ProgressListener {
        BoxFile boxFile;
        PreviewContentType previewContentType;
        IPreviewController previewController;

        public ProgressForMetadataListener(BoxFile boxFile, IPreviewController iPreviewController, PreviewContentType previewContentType) {
            this.boxFile = boxFile;
            this.previewController = iPreviewController;
            this.previewContentType = previewContentType;
        }

        @Override // com.box.androidsdk.content.listeners.ProgressListener
        public void onProgressChanged(long j, long j2) {
            if (j == j2) {
                MoCoBoxTransfers.this.saveMetadata(this.boxFile, j2, this.previewController, this.previewContentType);
            }
        }
    }

    PreviewContentType getPreviewContentType(BoxRequestDownload boxRequestDownload, BoxFile boxFile) {
        if (boxRequestDownload instanceof BoxRequestsFile.DownloadThumbnail) {
            BoxRequestsFile.DownloadThumbnail downloadThumbnail = (BoxRequestsFile.DownloadThumbnail) boxRequestDownload;
            return this.boxThumbnailRequests.createPreviewContentType(downloadThumbnail.getFormat(), downloadThumbnail.getMinWidth().intValue());
        }
        if (boxRequestDownload instanceof BoxRequestsPreview.DownloadPreview) {
            return createPreviewContentType(boxFile, ((BoxRequestsPreview.DownloadPreview) boxRequestDownload).getPreviewExt());
        }
        return null;
    }

    void saveMetadata(BoxFile boxFile, long j, IPreviewController iPreviewController, PreviewContentType previewContentType) {
        BoxDocumentFile boxDocumentFile = new BoxDocumentFile((BoxFile) iPreviewController.getStorage().getMetadata(boxFile, BoxApiPreview.METADATA_FILE_INFO_TAG));
        boxDocumentFile.setContentLength(j);
        iPreviewController.getStorage().cacheMetadata(boxDocumentFile, "doc", previewContentType);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers
    public BoxTransferFutureTask<BoxFileTransferMessage> saveFileForOffline(String str, IUserContextManager iUserContextManager, ProgressReporter.FileTransferProgressListener fileTransferProgressListener) {
        return saveFileForOffline(str, iUserContextManager, fileTransferProgressListener, this.mBoxApiFile);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers
    public BoxTransferFutureTask<BoxFileTransferMessage> saveFileForOffline(final String str, final IUserContextManager iUserContextManager, final ProgressReporter.FileTransferProgressListener fileTransferProgressListener, final BoxApiFile boxApiFile) {
        return new BoxTransferFutureTask<>(new Callable<BoxFileTransferMessage>() { // from class: com.box.android.modelcontroller.MoCoBoxTransfers.4
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public BoxFileTransferMessage call() throws Exception {
                BoxFileTransferMessage boxFileTransferMessage = new BoxFileTransferMessage(Controller.ACTION_MADE_FILE_AVAILABLE_OFFLINE, Controller.ACTION_MAKING_FILE_AVAILABLE_OFFLINE);
                BoxFile boxFileSendForCachedResult = boxApiFile.getInfoRequest(str).sendForCachedResult();
                fileTransferProgressListener.setFileTransferMessage(boxFileTransferMessage);
                boxFileTransferMessage.initFromBoxFile(boxFileSendForCachedResult);
                if (!BoxModelOfflineManager.isOfflineUserSavedBlocking(boxFileSendForCachedResult, iUserContextManager)) {
                    fileTransferProgressListener.onError(new CancellationException("no longer wanted by user"));
                    return boxFileTransferMessage;
                }
                if (MoCoBoxTransfers.this.checkIsSaveOnDeviceDisabled()) {
                    fileTransferProgressListener.onError(new PermissionDeniedException());
                    return boxFileTransferMessage;
                }
                File offlineFile = iUserContextManager.getPreviewStorage().getOfflineFile(boxFileSendForCachedResult, "temp");
                if (!offlineFile.exists()) {
                    offlineFile.createNewFile();
                }
                try {
                    BoxRequestsFile.DownloadFile progressListener = boxApiFile.getDownloadRequest(new FileOutputStream(offlineFile, true), str).setProgressListener(new ProgressListener() { // from class: com.box.android.modelcontroller.MoCoBoxTransfers.4.1
                        @Override // com.box.androidsdk.content.listeners.ProgressListener
                        public void onProgressChanged(long j, long j2) {
                            fileTransferProgressListener.onProgressChanged(j, j2);
                        }
                    });
                    MoCoBoxTransfers.this.enableSha1Checks(progressListener, boxFileSendForCachedResult);
                    BoxDownload boxDownload = (BoxDownload) progressListener.send();
                    File offlineFile2 = iUserContextManager.getPreviewStorage().getOfflineFile(boxFileSendForCachedResult, null);
                    offlineFile.renameTo(offlineFile2);
                    boxFileTransferMessage.setBoxDownload(boxDownload);
                    boxFileTransferMessage.setJavaFilePayload(offlineFile2);
                    fileTransferProgressListener.onCompleted(null);
                    DownloadAnalyticsUtils.createBuilder(boxFileSendForCachedResult, BoxBaseApplication.getInstance().getApplicationContext()).logEvent(BoxAnalyticsParams.EVENT_OFFLINE_SUCCEEDED);
                    return boxFileTransferMessage;
                } catch (Exception e) {
                    fileTransferProgressListener.onError(e);
                    if (!(e instanceof BoxException) || !(e.getCause() instanceof InterruptedException)) {
                        DownloadAnalyticsUtils.createDownloadErrorBuilder(e, boxFileSendForCachedResult, BoxBaseApplication.getInstance().getApplicationContext()).logEvent(BoxAnalyticsParams.EVENT_OFFLINE_ERROR);
                    }
                    BoxLogUtils.e("MoCoBoxTransfers", "saveFileForOffline", e);
                    return boxFileTransferMessage;
                }
            }
        }, IBaseModelController.INSTANCE.getNextRequestId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableSha1Checks(BoxRequestsFile.DownloadFile downloadFile, BoxFile boxFile) {
        String id = boxFile.getFileVersion().getUserId();
        String sha1 = boxFile.getSha1();
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(sha1)) {
            return;
        }
        downloadFile.setVersion(id);
        downloadFile.setSha1(sha1);
    }

    protected LocalFiles.DownloadFiles getDownloadFiles() {
        return ((LocalFiles) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_FILES)).getDownloads();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIsSaveOnDeviceDisabled() {
        if (!BoxAccountManager.isSaveOnDeviceAdminDisabled(((LocalSharedPreferences) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_SHARED_PREFERENCES)).getSharedPreferences()) && !BoxAccountManager.doesSaveOnDeviceRequireEncryptedDevice(((LocalSharedPreferences) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_SHARED_PREFERENCES)).getSharedPreferences())) {
            return false;
        }
        LocalFiles.DownloadFiles downloadFiles = getDownloadFiles();
        downloadFiles.deleteAllEncryptedOfflineFiles();
        downloadFiles.clearEncryptionSalts(this.mUserContextManager);
        downloadFiles.deleteAllEncryptedCachedFiles();
        downloadFiles.deleteAllDecryptedWorkingFiles();
        return true;
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers
    public BoxTransferFutureTask<BoxDownloadFileMessage> makeWorkingFile(BoxFile boxFile, ProgressReporter.FileTransferProgressListener fileTransferProgressListener) {
        return exportFile(boxFile.getUserId(), getDownloadFiles().getDecryptedWorkingFile(boxFile), true, false, fileTransferProgressListener, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFileDownload(BoxFile boxFile, OutputStream outputStream, ProgressListener progressListener, BoxApiFile boxApiFile) throws BoxException {
        if (outputStream == null) {
            return;
        }
        BoxRequestsFile.DownloadFile downloadRequest = boxApiFile.getDownloadRequest(outputStream, boxFile.getUserId());
        enableSha1Checks(downloadRequest, boxFile);
        downloadRequest.setProgressListener(progressListener);
        downloadRequest.send();
    }

    boolean haveDownloadPermissionThroughSharedLink(BoxFile boxFile) {
        return (boxFile.getSharedLink() == null || boxFile.getSharedLink().getPermissions() == null || !boxFile.getPermissions().contains(BoxItem.Permission.CAN_DOWNLOAD) || ((CustomBoxSession) this.mUserContextManager.getBoxSession(BoxBaseApplication.getInstance())).getSharedLink() == null) ? false : true;
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers
    public BoxTransferFutureTask<BoxDownloadFileMessage> exportFile(final String str, final File file, final boolean z, final boolean z2, final ProgressReporter.FileTransferProgressListener fileTransferProgressListener, final IMoCoBoxTransfers.FileDestinationListener fileDestinationListener, final BoxApiFile boxApiFile) {
        return new BoxTransferFutureTask<>(new Callable<BoxDownloadFileMessage>() { // from class: com.box.android.modelcontroller.MoCoBoxTransfers.5
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code duplicated, block: B:66:0x0176  */
            /* JADX WARN: Code duplicated, block: B:68:0x017c  */
            /* JADX WARN: Code duplicated, block: B:69:0x0181  */
            /* JADX WARN: Code duplicated, block: B:71:0x0187  */
            /* JADX WARN: Code duplicated, block: B:72:0x018c  */
            /* JADX WARN: Code duplicated, block: B:75:0x0194  */
            /* JADX WARN: Code duplicated, block: B:82:0x01e6 A[Catch: Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:80:0x01b1, B:82:0x01e6, B:84:0x01ee, B:86:0x01f6, B:88:0x01fe, B:90:0x0206, B:93:0x021e, B:92:0x020e), top: B:103:0x01b1 }] */
            /* JADX WARN: Code duplicated, block: B:92:0x020e A[Catch: Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:80:0x01b1, B:82:0x01e6, B:84:0x01ee, B:86:0x01f6, B:88:0x01fe, B:90:0x0206, B:93:0x021e, B:92:0x020e), top: B:103:0x01b1 }] */
            @Override // java.util.concurrent.Callable
            public BoxDownloadFileMessage call() throws Exception {
                File uniqueDestinationFile;
                File offlineFile;
                File encryptedOfflineFile;
                File fileCreateTempFile;
                String fileExtension;
                BoxFile boxFileSendForCachedResult = boxApiFile.getInfoRequest(str).sendForCachedResult();
                BoxDownloadFileMessage boxDownloadFileMessage = new BoxDownloadFileMessage(Controller.ACTION_EXPORTED_FILE, Controller.ACTION_EXPORTING_FILE);
                fileTransferProgressListener.setFileTransferMessage(boxDownloadFileMessage);
                boxDownloadFileMessage.initFromBoxFile(boxFileSendForCachedResult);
                long nextRequestId = IBaseModelController.INSTANCE.getNextRequestId();
                boxDownloadFileMessage.setSuccess(false);
                boxDownloadFileMessage.setRequestId(nextRequestId);
                if (MoCoBoxTransfers.this.checkIsSaveOnDeviceDisabled()) {
                    fileTransferProgressListener.onError(new PermissionDeniedException());
                    return boxDownloadFileMessage;
                }
                if (!boxFileSendForCachedResult.getPermissions().contains(BoxItem.Permission.CAN_DOWNLOAD) && !MoCoBoxTransfers.this.haveDownloadPermissionThroughSharedLink(boxFileSendForCachedResult)) {
                    fileTransferProgressListener.onError(new PermissionDeniedException());
                    return boxDownloadFileMessage;
                }
                try {
                    if (z) {
                        uniqueDestinationFile = CommonBoxUtil.getEscapedFileForSD(file);
                    } else {
                        uniqueDestinationFile = MoCoBoxTransfers.getUniqueDestinationFile(file, boxFileSendForCachedResult, fileDestinationListener);
                    }
                } catch (IOException unused) {
                    fileTransferProgressListener.onError(new IOException());
                    uniqueDestinationFile = null;
                }
                if (uniqueDestinationFile == null) {
                    fileTransferProgressListener.onCompleted(null);
                    return boxDownloadFileMessage;
                }
                IMoCoBoxTransfers.FileDestinationListener fileDestinationListener2 = fileDestinationListener;
                if (fileDestinationListener2 != null) {
                    fileDestinationListener2.onFileKnown(uniqueDestinationFile);
                }
                LocalFiles.DownloadFiles downloadFiles = MoCoBoxTransfers.this.getDownloadFiles();
                if (!downloadFiles.isFileInDecryptedWorkingDir(boxFileSendForCachedResult)) {
                    offlineFile = MoCoBoxTransfers.this.mUserContextManager.getPreviewStorage().getOfflineFile(boxFileSendForCachedResult, null);
                    if (offlineFile == null && offlineFile.exists()) {
                        try {
                            MoCoBoxTransfers.this.copyToFile(offlineFile, uniqueDestinationFile);
                            boxDownloadFileMessage.setJavaFilePayload(uniqueDestinationFile);
                            boxDownloadFileMessage.setSuccess(true);
                            fileTransferProgressListener.onCompleted(null);
                            String fileExtension2 = CommonBoxUtil.getFileExtension(uniqueDestinationFile.getName(), "");
                            if (SupportedFileExtensions.INSTANCE.isImageExtension(fileExtension2) || SupportedFileExtensions.INSTANCE.isVectorExtension(fileExtension2) || SupportedFileExtensions.INSTANCE.isAdobePhotoshopExtension(fileExtension2) || SupportedFileExtensions.INSTANCE.isAdobeIllustratorExtension(fileExtension2) || SupportedFileExtensions.INSTANCE.isVideoExtension(fileExtension2) || SupportedFileExtensions.INSTANCE.isAudioExtension(fileExtension2)) {
                                BoxBaseApplication.getInstance().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(uniqueDestinationFile)));
                            }
                        } catch (IOException e) {
                            BoxLogUtils.logException(e);
                            if (downloadFiles.isFileCached(boxFileSendForCachedResult)) {
                                encryptedOfflineFile = downloadFiles.getEncryptedCacheFile(boxFileSendForCachedResult);
                            } else if (downloadFiles.isFileAvailableOffline(boxFileSendForCachedResult)) {
                                encryptedOfflineFile = downloadFiles.getEncryptedOfflineFile(boxFileSendForCachedResult);
                            } else {
                                encryptedOfflineFile = null;
                            }
                            FileUtils.deleteQuietly(encryptedOfflineFile);
                            if (!z2) {
                            }
                            fileCreateTempFile = File.createTempFile("~tmp_", null, downloadFiles.getTempDownloadDir());
                            MoCoBoxTransfers.this.doFileDownload(boxFileSendForCachedResult, new FileOutputStream(fileCreateTempFile), fileTransferProgressListener, boxApiFile);
                            MoCoBoxTransfers.this.RenameFile(fileCreateTempFile, uniqueDestinationFile);
                            downloadFiles.cleanOutStaleEncryptedFiles(boxFileSendForCachedResult, downloadFiles.getEncryptedCacheFile(boxFileSendForCachedResult));
                            boxDownloadFileMessage.setJavaFilePayload(uniqueDestinationFile);
                            boxDownloadFileMessage.setSuccess(true);
                            fileTransferProgressListener.onCompleted(null);
                            fileExtension = CommonBoxUtil.getFileExtension(uniqueDestinationFile.getName(), "");
                            if (!SupportedFileExtensions.INSTANCE.isImageExtension(fileExtension)) {
                                BoxBaseApplication.getInstance().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(uniqueDestinationFile)));
                            } else {
                                BoxBaseApplication.getInstance().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(uniqueDestinationFile)));
                            }
                            DownloadAnalyticsUtils.createBuilder(boxFileSendForCachedResult, BoxBaseApplication.getInstance().getApplicationContext()).logEvent(BoxAnalyticsParams.EVENT_DOWNLOAD_SUCCEEDED);
                        }
                    } else {
                        if (downloadFiles.isFileCached(boxFileSendForCachedResult)) {
                            encryptedOfflineFile = downloadFiles.getEncryptedCacheFile(boxFileSendForCachedResult);
                        } else if (downloadFiles.isFileAvailableOffline(boxFileSendForCachedResult)) {
                            encryptedOfflineFile = downloadFiles.getEncryptedOfflineFile(boxFileSendForCachedResult);
                        } else {
                            encryptedOfflineFile = null;
                        }
                        FileUtils.deleteQuietly(encryptedOfflineFile);
                        if (!z2 && !CommonBoxUtil.isOnWifi()) {
                            fileTransferProgressListener.onError(new FileTransferException(JobItem.ErrorType.WIFI_REQUIRED));
                            return boxDownloadFileMessage;
                        }
                        fileCreateTempFile = File.createTempFile("~tmp_", null, downloadFiles.getTempDownloadDir());
                        MoCoBoxTransfers.this.doFileDownload(boxFileSendForCachedResult, new FileOutputStream(fileCreateTempFile), fileTransferProgressListener, boxApiFile);
                        MoCoBoxTransfers.this.RenameFile(fileCreateTempFile, uniqueDestinationFile);
                        downloadFiles.cleanOutStaleEncryptedFiles(boxFileSendForCachedResult, downloadFiles.getEncryptedCacheFile(boxFileSendForCachedResult));
                        boxDownloadFileMessage.setJavaFilePayload(uniqueDestinationFile);
                        boxDownloadFileMessage.setSuccess(true);
                        fileTransferProgressListener.onCompleted(null);
                        fileExtension = CommonBoxUtil.getFileExtension(uniqueDestinationFile.getName(), "");
                        if (!SupportedFileExtensions.INSTANCE.isImageExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isVectorExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isAdobePhotoshopExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isAdobeIllustratorExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isVideoExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isAudioExtension(fileExtension)) {
                            BoxBaseApplication.getInstance().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(uniqueDestinationFile)));
                        }
                        DownloadAnalyticsUtils.createBuilder(boxFileSendForCachedResult, BoxBaseApplication.getInstance().getApplicationContext()).logEvent(BoxAnalyticsParams.EVENT_DOWNLOAD_SUCCEEDED);
                    }
                } else {
                    try {
                        File decryptedWorkingFile = downloadFiles.getDecryptedWorkingFile(boxFileSendForCachedResult);
                        if (!decryptedWorkingFile.equals(uniqueDestinationFile)) {
                            FileUtils.copyFile(decryptedWorkingFile, uniqueDestinationFile);
                        }
                        boxDownloadFileMessage.setJavaFilePayload(uniqueDestinationFile);
                        boxDownloadFileMessage.setSuccess(true);
                        fileTransferProgressListener.onCompleted(null);
                        String fileExtension3 = CommonBoxUtil.getFileExtension(uniqueDestinationFile.getName(), "");
                        if (SupportedFileExtensions.INSTANCE.isImageExtension(fileExtension3) || SupportedFileExtensions.INSTANCE.isVectorExtension(fileExtension3) || SupportedFileExtensions.INSTANCE.isAdobePhotoshopExtension(fileExtension3) || SupportedFileExtensions.INSTANCE.isAdobeIllustratorExtension(fileExtension3) || SupportedFileExtensions.INSTANCE.isVideoExtension(fileExtension3) || SupportedFileExtensions.INSTANCE.isAudioExtension(fileExtension3)) {
                            BoxBaseApplication.getInstance().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(uniqueDestinationFile)));
                        }
                    } catch (IOException e2) {
                        BoxLogUtils.logException(e2);
                        offlineFile = MoCoBoxTransfers.this.mUserContextManager.getPreviewStorage().getOfflineFile(boxFileSendForCachedResult, null);
                        if (offlineFile == null) {
                            if (downloadFiles.isFileCached(boxFileSendForCachedResult)) {
                                encryptedOfflineFile = downloadFiles.getEncryptedCacheFile(boxFileSendForCachedResult);
                            } else if (downloadFiles.isFileAvailableOffline(boxFileSendForCachedResult)) {
                                encryptedOfflineFile = downloadFiles.getEncryptedOfflineFile(boxFileSendForCachedResult);
                            } else {
                                encryptedOfflineFile = null;
                            }
                            FileUtils.deleteQuietly(encryptedOfflineFile);
                            if (!z2) {
                            }
                            fileCreateTempFile = File.createTempFile("~tmp_", null, downloadFiles.getTempDownloadDir());
                            try {
                                MoCoBoxTransfers.this.doFileDownload(boxFileSendForCachedResult, new FileOutputStream(fileCreateTempFile), fileTransferProgressListener, boxApiFile);
                                MoCoBoxTransfers.this.RenameFile(fileCreateTempFile, uniqueDestinationFile);
                                downloadFiles.cleanOutStaleEncryptedFiles(boxFileSendForCachedResult, downloadFiles.getEncryptedCacheFile(boxFileSendForCachedResult));
                                boxDownloadFileMessage.setJavaFilePayload(uniqueDestinationFile);
                                boxDownloadFileMessage.setSuccess(true);
                                fileTransferProgressListener.onCompleted(null);
                                fileExtension = CommonBoxUtil.getFileExtension(uniqueDestinationFile.getName(), "");
                                if (!SupportedFileExtensions.INSTANCE.isImageExtension(fileExtension)) {
                                    BoxBaseApplication.getInstance().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(uniqueDestinationFile)));
                                } else {
                                    BoxBaseApplication.getInstance().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(uniqueDestinationFile)));
                                }
                                DownloadAnalyticsUtils.createBuilder(boxFileSendForCachedResult, BoxBaseApplication.getInstance().getApplicationContext()).logEvent(BoxAnalyticsParams.EVENT_DOWNLOAD_SUCCEEDED);
                            } catch (Exception e3) {
                                fileCreateTempFile.delete();
                                fileTransferProgressListener.onError(e3);
                                if (!(e3 instanceof BoxException) || !(e3.getCause() instanceof InterruptedException)) {
                                    DownloadAnalyticsUtils.createDownloadErrorBuilder(e3, boxFileSendForCachedResult, BoxBaseApplication.getInstance().getApplicationContext()).logEvent(BoxAnalyticsParams.EVENT_DOWNLOAD_ERROR);
                                }
                            }
                        } else {
                            if (downloadFiles.isFileCached(boxFileSendForCachedResult)) {
                                encryptedOfflineFile = downloadFiles.getEncryptedCacheFile(boxFileSendForCachedResult);
                            } else if (downloadFiles.isFileAvailableOffline(boxFileSendForCachedResult)) {
                                encryptedOfflineFile = downloadFiles.getEncryptedOfflineFile(boxFileSendForCachedResult);
                            } else {
                                encryptedOfflineFile = null;
                            }
                            FileUtils.deleteQuietly(encryptedOfflineFile);
                            if (!z2) {
                            }
                            fileCreateTempFile = File.createTempFile("~tmp_", null, downloadFiles.getTempDownloadDir());
                            MoCoBoxTransfers.this.doFileDownload(boxFileSendForCachedResult, new FileOutputStream(fileCreateTempFile), fileTransferProgressListener, boxApiFile);
                            MoCoBoxTransfers.this.RenameFile(fileCreateTempFile, uniqueDestinationFile);
                            downloadFiles.cleanOutStaleEncryptedFiles(boxFileSendForCachedResult, downloadFiles.getEncryptedCacheFile(boxFileSendForCachedResult));
                            boxDownloadFileMessage.setJavaFilePayload(uniqueDestinationFile);
                            boxDownloadFileMessage.setSuccess(true);
                            fileTransferProgressListener.onCompleted(null);
                            fileExtension = CommonBoxUtil.getFileExtension(uniqueDestinationFile.getName(), "");
                            if (!SupportedFileExtensions.INSTANCE.isImageExtension(fileExtension)) {
                                BoxBaseApplication.getInstance().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(uniqueDestinationFile)));
                            } else {
                                BoxBaseApplication.getInstance().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(uniqueDestinationFile)));
                            }
                            DownloadAnalyticsUtils.createBuilder(boxFileSendForCachedResult, BoxBaseApplication.getInstance().getApplicationContext()).logEvent(BoxAnalyticsParams.EVENT_DOWNLOAD_SUCCEEDED);
                        }
                    }
                }
                return boxDownloadFileMessage;
            }
        }, IBaseModelController.INSTANCE.getNextRequestId());
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers
    public BoxTransferFutureTask<BoxDownloadFileMessage> exportFile(String str, File file, boolean z, boolean z2, ProgressReporter.FileTransferProgressListener fileTransferProgressListener, IMoCoBoxTransfers.FileDestinationListener fileDestinationListener) {
        return exportFile(str, file, z, z2, fileTransferProgressListener, fileDestinationListener, this.mBoxApiFile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RenameFile(File file, File file2) throws IOException {
        boolean zRenameTo = file.renameTo(file2);
        if (!zRenameTo) {
            file2.getParentFile().mkdirs();
            zRenameTo = file.renameTo(file2);
        }
        if (zRenameTo || !copyToFile(file, file2)) {
            return;
        }
        file.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean copyToFile(File file, File file2) throws IOException {
        try {
            FileUtils.copyFile(file, file2);
            return true;
        } catch (FileNotFoundException unused) {
            OutputStream contentProviderOutputStream = getContentProviderOutputStream(file2);
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                SdkUtils.copyStream(fileInputStream, contentProviderOutputStream);
                return true;
            } catch (InterruptedException e) {
                BoxLogUtils.e("content provider copy failed", e);
                Thread.currentThread().interrupt();
                return false;
            } finally {
                contentProviderOutputStream.close();
                fileInputStream.close();
            }
        }
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers
    public OutputStream getContentProviderOutputStream(File file) throws FileNotFoundException {
        ContentResolver contentResolver = BoxBaseApplication.getInstance().getContentResolver();
        DocumentFile contentProviderDocumentFile = getContentProviderDocumentFile(file, false);
        if (contentProviderDocumentFile != null) {
            return MAMContentResolverManagement.openOutputStream(contentResolver, contentProviderDocumentFile.getUri());
        }
        throw new FileNotFoundException("no matching uri");
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers
    public DocumentFile getContentProviderDocumentFile(File file, boolean z) throws FileNotFoundException {
        BoxBaseApplication boxBaseApplication = BoxBaseApplication.getInstance();
        List<UriPermission> persistedUriPermissions = BoxBaseApplication.getInstance().getContentResolver().getPersistedUriPermissions();
        String path = file.getParentFile().getPath();
        UriPermission uriPermission = null;
        String str = null;
        for (UriPermission uriPermission2 : persistedUriPermissions) {
            String fullPathFromTreeUri = FileUtil.getFullPathFromTreeUri(uriPermission2.getUri(), BoxBaseApplication.getInstance());
            if (fullPathFromTreeUri != null) {
                if (fullPathFromTreeUri.equals(path)) {
                    uriPermission = uriPermission2;
                    str = fullPathFromTreeUri;
                    break;
                }
                if (path.startsWith(fullPathFromTreeUri)) {
                    uriPermission = uriPermission2;
                    str = fullPathFromTreeUri;
                }
            }
        }
        if (uriPermission != null) {
            DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(boxBaseApplication, uriPermission.getUri());
            if (!str.equals(path)) {
                String[] strArrSplit = path.substring(str.length()).split(File.separator);
                for (String str2 : strArrSplit) {
                    if (!StringUtils.isEmpty(str2)) {
                        DocumentFile documentFileFindFile = documentFileFromTreeUri.findFile(str2);
                        if (documentFileFindFile == null) {
                            documentFileFindFile = documentFileFromTreeUri.createDirectory(str2);
                        }
                        if (documentFileFindFile != null) {
                            documentFileFromTreeUri = documentFileFindFile;
                            break;
                        }
                        DocumentFile[] documentFileArrListFiles = documentFileFromTreeUri.listFiles();
                        int length = documentFileArrListFiles.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                documentFileFromTreeUri = documentFileFindFile;
                                break;
                            }
                            DocumentFile documentFile = documentFileArrListFiles[i];
                            if (documentFile.getName().equals(str2)) {
                                documentFileFromTreeUri = documentFile;
                                break;
                            }
                            i++;
                        }
                        if (documentFileFromTreeUri == null) {
                            throw new FileNotFoundException("unable to resolve directory");
                        }
                    }
                }
            }
            if (z) {
                return documentFileFromTreeUri.createDirectory(file.getName());
            }
            return documentFileFromTreeUri.createFile(MimeTypeHelper.getTypeFromExt(CommonBoxUtil.getFileExtension(file.getName(), "txt")), file.getName());
        }
        throw new FileNotFoundException("no matching uri");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File getUniqueDestinationFile(File file, BoxFile boxFile, IMoCoBoxTransfers.FileDestinationListener fileDestinationListener) throws FileTransferException, IOException {
        String[] nameExtensionPath = CommonBoxUtil.getNameExtensionPath(file.getAbsolutePath());
        File file2 = new File(nameExtensionPath[2], nameExtensionPath[0] + "." + nameExtensionPath[1]);
        File file3 = new File(nameExtensionPath[2]);
        if (!file3.mkdirs() && !file3.isDirectory()) {
            throw new FileTransferException(JobItem.ErrorType.UNABLE_TO_LOAD_FOLDER);
        }
        int i = 0;
        while (file2.exists()) {
            try {
                if (Crypto.sha1(new FileInputStream(file2)).equals(boxFile.getSha1())) {
                    if (fileDestinationListener == null) {
                        return null;
                    }
                    fileDestinationListener.onFileKnown(file2);
                    return null;
                }
                continue;
            } catch (FileNotFoundException e) {
                BoxLogUtils.logException(e);
            } catch (IOException e2) {
                BoxLogUtils.logException(e2);
            }
            i++;
            file2 = CommonBoxUtil.getEscapedFileForSD(new File(file3, nameExtensionPath[0] + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + i + "." + nameExtensionPath[1]));
        }
        return file2;
    }
}
