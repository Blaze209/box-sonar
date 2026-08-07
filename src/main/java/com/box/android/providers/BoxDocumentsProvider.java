package com.box.android.providers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.common.C;
import com.box.android.R;
import com.box.android.activities.UploadOverwriteDialogActivity;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.activities.CreatePincodeActivity;
import com.box.android.base.presentation.activities.Pincode;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.controller.ExecutorPool;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.dao.UploadModelBoxFile;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.BoxTransferFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.modelcontroller.messages.BoxDownloadFileMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxFileTransferMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxPincodeMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxRecentItemsMessage;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.coreservices.utilities.Permissions;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.android.domain.utils.MimeTypeHelper;
import com.box.android.localrepo.DocumentProviderPreferences;
import com.box.android.utilities.LinkedBlockingLifoDeque;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import com.box.androidsdk.content.BoxApiSearch;
import com.box.androidsdk.content.BoxApiUser;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxDownload;
import com.box.androidsdk.content.models.BoxEvent;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.requests.BoxRequestUploadFile;
import com.box.boxandroidlibv2private.requests.requestobjects.IBoxRequestUploadFileHelper;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import com.microsoft.intune.mam.client.content.MAMDocumentsProvider;
import com.microsoft.intune.mam.policy.SaveLocation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes12.dex */
public class BoxDocumentsProvider extends MAMDocumentsProvider {
    public static final String AUTHORITY = "com.box.android.documents";
    private static final int CONFLICT_ERROR_CODE = 409;
    private static final int DOWNLOAD_THUMBNAIL_CORE_POOL_SIZE = 1;
    private static final int DOWNLOAD_THUMBNAIL_MAX_POOL_SIZE = 20;
    private static final int MAX_NUM_RECENTS = 20;
    private static final String ROOT = "root";

    @Inject
    protected IBaseModelController mBaseModelController;

    @Inject
    protected BoxApiPrivate mBoxApiPrivate;

    @Inject
    protected BoxApiSearch mBoxApiSearch;

    @Inject
    protected BoxApiUser mBoxApiUser;

    @Inject
    BoxExtendedApiFile mBoxExtendedApiFile;

    @Inject
    BoxExtendedApiFolder mBoxExtendedApiFolder;

    @Inject
    protected IBrowseController mBrowseController;
    private String mCurrentUserId;
    private ThreadPoolExecutor mExecutor;
    private LocalBroadcastManager mLocalBroadcastManager;

    @Inject
    protected IMoCoBoxRecentEvents mRecentEventsModelController;

    @Inject
    protected ThumbnailManager mThumbnailManager;

    @Inject
    protected IMoCoBoxTransfers mTransfersModelController;

    @Inject
    protected IUserContextManager mUserContextManager;
    private static final String[] DEFAULT_ROOT_PROJECTION = {"root_id", "mime_types", "flags", HubsObservability.HUB_ASSET_ICON, "title", "summary", "document_id", "available_bytes"};
    private static final String[] DEFAULT_DOCUMENT_PROJECTION = {"document_id", "mime_type", "_display_name", "last_modified", "flags", "_size", HubsObservability.HUB_ASSET_ICON};
    private static final String[] DEFAULT_UPDATE_TYPES = {BoxEvent.EVENT_TYPE_ITEM_UPLOAD, BoxEvent.EVENT_TYPE_ITEM_DOWNLOAD, BoxEvent.EVENT_TYPE_ITEM_MOVE, BoxEvent.EVENT_TYPE_ITEM_COPY, BoxEvent.EVENT_TYPE_ITEM_RENAME, BoxEvent.EVENT_TYPE_ITEM_SHARED};
    private static final String ROOT_FOLDER_DOC_ID = TypedId.getDocumentId("folder", "0");
    private static final ConcurrentHashMap<String, DownloadThumbnailRunnable> DOWNLOAD_THUMB_NAIL_MAP = new ConcurrentHashMap<>();
    private final Set<FileObserver> mFileObservers = new HashSet();
    private final Map<Uri, Boolean> mActiveRequestUris = new ConcurrentHashMap();
    private final AtomicInteger mThumbnailsChanged = new AtomicInteger(0);
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private Uri mLastNotifyUri = null;
    private final BroadcastReceiver mDocumentPincodeResponseReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.providers.BoxDocumentsProvider.1
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            if (intent instanceof BoxPincodeMessage) {
                BoxPincodeMessage boxPincodeMessage = (BoxPincodeMessage) intent;
                if (boxPincodeMessage.wasSuccessful() && BoxDocumentsProvider.this.mUserContextManager.getCurrentContextId().equals(boxPincodeMessage.getUserId())) {
                    BoxDocumentsProvider.this.getContext().getContentResolver().notifyChange(DocumentsContract.buildChildDocumentsUri(BoxDocumentsProvider.AUTHORITY, BoxDocumentsProvider.ROOT_FOLDER_DOC_ID), null);
                    if (BoxDocumentsProvider.this.mLocalBroadcastManager != null) {
                        BoxDocumentsProvider.this.mLocalBroadcastManager.unregisterReceiver(this);
                    }
                }
            }
        }
    };
    private final Runnable notifyThumbnailsFinishedRunnable = new Runnable() { // from class: com.box.android.providers.BoxDocumentsProvider.2
        @Override // java.lang.Runnable
        public void run() {
            if (BoxDocumentsProvider.this.mExecutor == null || BoxDocumentsProvider.this.mExecutor.getQueue().size() >= 1 || BoxDocumentsProvider.this.getContext() == null || BoxDocumentsProvider.this.mLastNotifyUri == null || BoxDocumentsProvider.this.mThumbnailsChanged.get() <= 0) {
                return;
            }
            BoxDocumentsProvider.this.mThumbnailsChanged.set(0);
            BoxDocumentsProvider.this.getContext().getContentResolver().notifyChange(BoxDocumentsProvider.this.mLastNotifyUri, null);
        }
    };

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    private static String[] resolveRootProjection(String[] strArr) {
        return strArr != null ? strArr : DEFAULT_ROOT_PROJECTION;
    }

    private static String[] resolveDocumentProjection(String[] strArr) {
        return strArr != null ? strArr : DEFAULT_DOCUMENT_PROJECTION;
    }

    static String getTypeForBoxItem(BoxItem boxItem) {
        if (boxItem instanceof BoxFolder) {
            return "vnd.android.document/directory";
        }
        return MimeTypeHelper.getTypeFromExt(CommonBoxUtil.getFileExtension(boxItem.getName(), ""));
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public ParcelFileDescriptor openDocumentMAM(String str, String str2, CancellationSignal cancellationSignal) throws FileNotFoundException {
        try {
            if (!verifyAuthenticationAndInit()) {
                throw new FileNotFoundException();
            }
            addFileToRecentsAsync(str);
            int parcelFileDescriptorMode = getParcelFileDescriptorMode(str2);
            String id = new TypedId(str).getId();
            try {
                BoxFile boxFile = (BoxFile) this.mBaseModelController.performRemote(this.mBoxExtendedApiFile.getInfoRequest(id)).get().getResult();
                if (!CoreServiceUtils.getIsSaveToLocationAllowed(SaveLocation.LOCAL, null) || BoxAccountManager.isSaveOnDeviceAdminDisabled(this.mUserContextManager.getUserSharedPrefs()) || !BoxAccountManager.isMobileOpenInEnabled(this.mUserContextManager)) {
                    BoxNotificationHelper.displayDialog(R.string.Feature_disabled, R.string.This_feature_has_been_disabled_by_your_or_your_administrator);
                    throw new FileNotFoundException();
                }
                if (BoxAccountManager.doesSaveOnDeviceRequireEncryptedDevice(this.mUserContextManager.getUserSharedPrefs())) {
                    BoxNotificationHelper.displayDialog(R.string.Feature_disabled, R.string.Encrypted_device_requird_for_this_feature);
                    throw new FileNotFoundException();
                }
                if (!Permissions.hasPermission(boxFile, Permissions.ACTION.DOWNLOAD, false, this.mUserContextManager.getUserSharedPrefs())) {
                    BoxPresentationUtils.displayToast(R.string.you_do_not_have_permission_to_open_or_download_this_item, BoxBaseApplication.getInstance().getApplicationContext(), new String[0]);
                    throw new FileNotFoundException();
                }
                final BoxTransferFutureTask<BoxDownloadFileMessage> boxTransferFutureTaskMakeWorkingFile = this.mTransfersModelController.makeWorkingFile(boxFile, new ProgressReporter.FileTransferProgressListener());
                if (cancellationSignal != null) {
                    cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: com.box.android.providers.BoxDocumentsProvider$$ExternalSyntheticLambda1
                        @Override // android.os.CancellationSignal.OnCancelListener
                        public final void onCancel() {
                            boxTransferFutureTaskMakeWorkingFile.cancel(true);
                        }
                    });
                }
                File javaFilePayload = ((BoxFileTransferMessage) boxTransferFutureTaskMakeWorkingFile.runAndGet()).getJavaFilePayload();
                ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(javaFilePayload, parcelFileDescriptorMode);
                if (parcelFileDescriptorMode != 268435456) {
                    addFileObserver(new DocumentFileObserver(javaFilePayload.getPath(), id, boxFile.getName(), cancellationSignal));
                }
                return parcelFileDescriptorOpen;
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                throw new FileNotFoundException(e.getMessage());
            }
        } catch (DifferentUserException unused) {
            throw new FileNotFoundException();
        } catch (PincodeExpiredException unused2) {
            throw new FileNotFoundException();
        }
    }

    private void addFileToRecentsAsync(String str) {
        final TypedId typedId = new TypedId(str);
        if (Objects.equals(typedId.getType(), "file")) {
            new Thread(new Runnable() { // from class: com.box.android.providers.BoxDocumentsProvider$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addFileToRecentsAsync$1(typedId);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addFileToRecentsAsync$1(TypedId typedId) {
        BoxResponse boxResponse;
        try {
            boxResponse = (BoxResponse) this.mBaseModelController.performLocal(this.mBoxExtendedApiFile.getInfoRequest(typedId.getId())).get();
            if (!boxResponse.isSuccess()) {
                boxResponse = (BoxResponse) this.mBaseModelController.performRemote(this.mBoxExtendedApiFile.getInfoRequest(typedId.getId())).get();
            }
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            boxResponse = null;
        }
        if (boxResponse == null || !boxResponse.isSuccess()) {
            return;
        }
        this.mRecentEventsModelController.addFileToRecents((BoxFile) boxResponse.getResult(), (String) null);
    }

    /* JADX WARN: Type inference failed for: r6v12, types: [com.box.android.providers.BoxDocumentsProvider$3] */
    @Override // com.microsoft.intune.mam.client.content.MAMDocumentsProvider, com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public Cursor querySearchDocumentsMAM(String str, String str2, String[] strArr) {
        boolean z;
        try {
            DocCursor docCursor = null;
            if (!verifyAuthenticationAndInit()) {
                return null;
            }
            final Uri uriBuildSearchDocumentsUri = DocumentsContract.buildSearchDocumentsUri(AUTHORITY, str, str2);
            this.mLastNotifyUri = uriBuildSearchDocumentsUri;
            if (!this.mActiveRequestUris.containsKey(uriBuildSearchDocumentsUri)) {
                z = true;
                this.mActiveRequestUris.put(uriBuildSearchDocumentsUri, true);
                docCursor = new DocCursor(new BoxIteratorItems(), resolveDocumentProjection(strArr), this.mBaseModelController.getKeyValueStore());
                new Thread() { // from class: com.box.android.providers.BoxDocumentsProvider.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException e) {
                            BoxLogUtils.logException(e);
                            Thread.currentThread().interrupt();
                        }
                        BoxDocumentsProvider.this.getContext().getContentResolver().notifyChange(uriBuildSearchDocumentsUri, null);
                    }
                }.start();
            } else {
                this.mActiveRequestUris.remove(uriBuildSearchDocumentsUri);
                z = false;
                try {
                    docCursor = new DocCursor((BoxIteratorItems) this.mBaseModelController.performRemote(this.mBoxApiSearch.getSearchRequest(str2)).get().getResult(), resolveDocumentProjection(strArr), this.mBaseModelController.getKeyValueStore());
                } catch (Exception e) {
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    BoxLogUtils.logException(e);
                }
            }
            if (docCursor != null) {
                docCursor.setIsLoading(z);
                docCursor.setNotificationUri(getContext().getContentResolver(), uriBuildSearchDocumentsUri);
            }
            return docCursor;
        } catch (DifferentUserException unused) {
            return DocCursor.buildErrorCursor(CommonBoxUtil.LS(R.string.you_do_not_have_permission_to_open_or_download_this_item), resolveDocumentProjection(strArr), this.mBaseModelController.getKeyValueStore());
        } catch (PincodeExpiredException unused2) {
            return DocCursor.buildErrorCursor(CommonBoxUtil.LS(R.string.you_do_not_have_permission_to_open_or_download_this_item), resolveDocumentProjection(strArr), this.mBaseModelController.getKeyValueStore());
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.box.android.providers.BoxDocumentsProvider$4] */
    private LoadingBoxIterator tryLocalAndRemote(BoxAppFutureTask<BoxFolder> boxAppFutureTask, final BoxAppFutureTask<BoxFolder> boxAppFutureTask2, final Uri uri) throws FileNotFoundException {
        BoxIteratorItems itemCollection;
        boolean z;
        try {
            BoxResponse boxResponse = boxAppFutureTask.get();
            if (!this.mActiveRequestUris.containsKey(uri)) {
                new Thread() { // from class: com.box.android.providers.BoxDocumentsProvider.4
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            if (boxAppFutureTask2.get().isSuccess()) {
                                BoxDocumentsProvider.this.mActiveRequestUris.put(uri, true);
                                BoxDocumentsProvider.this.getContext().getContentResolver().notifyChange(uri, null);
                            }
                        } catch (Exception e) {
                            if (e instanceof InterruptedException) {
                                Thread.currentThread().interrupt();
                            }
                            BoxLogUtils.logException(e);
                        }
                    }
                }.start();
                z = true;
                itemCollection = boxResponse.isSuccess() ? ((BoxFolder) boxResponse.getResult()).getItemCollection() : null;
            } else {
                this.mActiveRequestUris.remove(uri);
                if (boxResponse.isSuccess()) {
                    itemCollection = ((BoxFolder) boxResponse.getResult()).getItemCollection();
                    z = false;
                } else {
                    throw new FileNotFoundException();
                }
            }
            return new LoadingBoxIterator(itemCollection, z);
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            throw new FileNotFoundException();
        }
    }

    @Override // com.microsoft.intune.mam.client.content.MAMDocumentsProvider, com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public Cursor queryRecentDocumentsMAM(String str, String[] strArr) {
        try {
            if (!verifyAuthenticationAndInit()) {
                return new MatrixCursor(resolveDocumentProjection(strArr), 0);
            }
            this.mLastNotifyUri = DocumentsContract.buildRecentDocumentsUri(AUTHORITY, str);
            try {
                BoxRecentItemsMessage boxRecentItemsMessage = (BoxRecentItemsMessage) this.mRecentEventsModelController.getInterleavedRecentsAndEvents(false, 20, this.mUserContextManager.getCurrentContextId(), Arrays.asList(DEFAULT_UPDATE_TYPES)).get();
                if (boxRecentItemsMessage.wasSuccessful()) {
                    return new EventsDocCursor(boxRecentItemsMessage.getPayload(), resolveDocumentProjection(strArr));
                }
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                BoxLogUtils.logException(e);
            }
            return new MatrixCursor(resolveDocumentProjection(strArr), 0);
        } catch (DifferentUserException unused) {
            return DocCursor.buildErrorCursor(CommonBoxUtil.LS(R.string.you_do_not_have_permission_to_open_or_download_this_item), resolveDocumentProjection(strArr), this.mBaseModelController.getKeyValueStore());
        } catch (PincodeExpiredException unused2) {
            return DocCursor.buildErrorCursor(CommonBoxUtil.LS(R.string.you_do_not_have_permission_to_open_or_download_this_item), resolveDocumentProjection(strArr), this.mBaseModelController.getKeyValueStore());
        }
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public Cursor queryRootsMAM(String[] strArr) throws FileNotFoundException {
        long jLongValue;
        try {
            if (!verifyAuthenticationAndInit()) {
                throw new FileNotFoundException();
            }
            MatrixCursor matrixCursor = new MatrixCursor(resolveRootProjection(strArr));
            MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor.newRow();
            rowBuilderNewRow.add("root_id", ROOT);
            rowBuilderNewRow.add("summary", getContext().getString(R.string.documentsprovider_root_summary));
            rowBuilderNewRow.add("flags", 13);
            rowBuilderNewRow.add("title", getContext().getString(R.string.box_app_name));
            rowBuilderNewRow.add("document_id", TypedId.getDocumentId("folder", "0"));
            BoxUser boxUser = null;
            try {
                BoxResponse boxResponse = this.mBaseModelController.performLocal(this.mBoxApiUser.getUserInfoRequest(this.mUserContextManager.getCurrentContextId())).get();
                if (boxResponse.isSuccess()) {
                    boxUser = (BoxUser) boxResponse.getResult();
                }
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                BoxLogUtils.logException(e);
            }
            if (boxUser != null) {
                jLongValue = boxUser.getSpaceAmount().longValue() - boxUser.getSpaceUsed().longValue();
                rowBuilderNewRow.add("summary", boxUser.getLogin());
            } else {
                jLongValue = 0;
            }
            rowBuilderNewRow.add("available_bytes", Long.valueOf(jLongValue));
            rowBuilderNewRow.add(HubsObservability.HUB_ASSET_ICON, Integer.valueOf(R.mipmap.ic_launcher));
            matrixCursor.setNotificationUri(getContext().getContentResolver(), DocumentsContract.buildRootsUri(AUTHORITY));
            return matrixCursor;
        } catch (DifferentUserException unused) {
            return DocCursor.buildErrorCursor(CommonBoxUtil.LS(R.string.you_do_not_have_permission_to_open_or_download_this_item), resolveRootProjection(strArr), this.mBaseModelController.getKeyValueStore());
        } catch (PincodeExpiredException unused2) {
        }
    }

    private void startPincodeHandling() {
        Pincode.startPinCodeActivity(BoxBaseApplication.getInstance());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BoxPincodeMessage.ACTION_ENTERED_PINCODE);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(BoxBaseApplication.getInstance());
        this.mLocalBroadcastManager = localBroadcastManager;
        localBroadcastManager.registerReceiver(this.mDocumentPincodeResponseReceiver, intentFilter);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public Cursor queryChildDocumentsMAM(String str, String[] strArr, String str2) throws FileNotFoundException {
        DocCursor docCursor;
        try {
            if (!verifyAuthenticationAndInit()) {
                return null;
            }
            Uri uriBuildChildDocumentsUri = DocumentsContract.buildChildDocumentsUri(AUTHORITY, str);
            this.mLastNotifyUri = uriBuildChildDocumentsUri;
            String id = new TypedId(str).getId();
            LoadingBoxIterator loadingBoxIteratorTryLocalAndRemote = tryLocalAndRemote(this.mBaseModelController.performLocal(this.mBoxExtendedApiFolder.getFolderWithAllItems(id)), this.mBaseModelController.performRemote(this.mBoxExtendedApiFolder.getFolderWithAllItems(id)), uriBuildChildDocumentsUri);
            if (loadingBoxIteratorTryLocalAndRemote == null || loadingBoxIteratorTryLocalAndRemote.getBoxItems() == null) {
                docCursor = new DocCursor(new BoxIteratorItems(), resolveDocumentProjection(strArr), this.mBaseModelController.getKeyValueStore());
            } else {
                docCursor = new DocCursor(loadingBoxIteratorTryLocalAndRemote.getBoxItems(), resolveDocumentProjection(strArr), this.mBaseModelController.getKeyValueStore());
            }
            docCursor.setIsLoading(loadingBoxIteratorTryLocalAndRemote.isLoading());
            docCursor.setNotificationUri(getContext().getContentResolver(), uriBuildChildDocumentsUri);
            return docCursor;
        } catch (DifferentUserException unused) {
            return DocCursor.buildErrorCursor(CommonBoxUtil.LS(R.string.you_do_not_have_permission_to_open_or_download_this_item), resolveDocumentProjection(strArr), this.mBaseModelController.getKeyValueStore());
        } catch (PincodeExpiredException unused2) {
            startPincodeHandling();
            DocCursor docCursorBuildErrorCursor = DocCursor.buildErrorCursor(CommonBoxUtil.LS(R.string.you_do_not_have_permission_to_open_or_download_this_item), resolveDocumentProjection(strArr), this.mBaseModelController.getKeyValueStore());
            docCursorBuildErrorCursor.setNotificationUri(getContext().getContentResolver(), DocumentsContract.buildChildDocumentsUri(AUTHORITY, ROOT_FOLDER_DOC_ID));
            return docCursorBuildErrorCursor;
        }
    }

    @Override // com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public Cursor queryDocumentMAM(String str, String[] strArr) throws FileNotFoundException {
        BoxResponse boxResponse;
        BoxResponse boxResponse2;
        BoxResponse boxResponse3;
        try {
            DocCursor docCursor = null;
            if (!verifyAuthenticationAndInit()) {
                return null;
            }
            TypedId typedId = new TypedId(str);
            try {
                if (typedId.getType().equals("folder")) {
                    BoxRequestsFolder.GetFolderWithAllItems folderWithAllItems = this.mBoxExtendedApiFolder.getFolderWithAllItems(typedId.getId());
                    boxResponse = (BoxResponse) this.mBaseModelController.performLocal(folderWithAllItems).get();
                    try {
                        if (!boxResponse.isSuccess()) {
                            boxResponse = (BoxResponse) this.mBaseModelController.performRemote(folderWithAllItems).get();
                        }
                        boxResponse3 = null;
                    } catch (InterruptedException e) {
                        e = e;
                        boxResponse2 = null;
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                        boxResponse3 = boxResponse2;
                    } catch (ExecutionException e2) {
                        e = e2;
                        boxResponse2 = null;
                        e.printStackTrace();
                        boxResponse3 = boxResponse2;
                    }
                } else if (typedId.getType().equals("file")) {
                    BoxRequestsFile.GetFileInfo infoRequest = this.mBoxExtendedApiFile.getInfoRequest(typedId.getId());
                    BoxResponse boxResponse4 = (BoxResponse) this.mBaseModelController.performLocal(infoRequest).get();
                    try {
                        if (!boxResponse4.isSuccess()) {
                            boxResponse4 = (BoxResponse) this.mBaseModelController.performRemote(infoRequest).get();
                        }
                        boxResponse3 = boxResponse4;
                        boxResponse = null;
                    } catch (InterruptedException e3) {
                        e = e3;
                        boxResponse2 = boxResponse4;
                        boxResponse = null;
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                        boxResponse3 = boxResponse2;
                    } catch (ExecutionException e4) {
                        e = e4;
                        boxResponse2 = boxResponse4;
                        boxResponse = null;
                        e.printStackTrace();
                        boxResponse3 = boxResponse2;
                    }
                } else {
                    throw new FileNotFoundException();
                }
            } catch (InterruptedException e5) {
                e = e5;
                boxResponse = null;
                boxResponse2 = null;
            } catch (ExecutionException e6) {
                e = e6;
                boxResponse = null;
                boxResponse2 = null;
            }
            if (boxResponse3 != null && boxResponse3.isSuccess()) {
                docCursor = new DocCursor((BoxItem) boxResponse3.getResult(), resolveDocumentProjection(strArr));
            } else if (boxResponse != null && boxResponse.isSuccess()) {
                docCursor = new DocCursor((BoxItem) boxResponse.getResult(), resolveDocumentProjection(strArr));
            }
            if (docCursor != null) {
                docCursor.setNotificationUri(getContext().getContentResolver(), DocumentsContract.buildDocumentUri(AUTHORITY, str));
            }
            return docCursor;
        } catch (DifferentUserException unused) {
            throw new FileNotFoundException();
        } catch (PincodeExpiredException unused2) {
            return new DocCursor(BoxFolder.createFromId("0"), resolveDocumentProjection(strArr));
        }
    }

    @Override // com.microsoft.intune.mam.client.content.MAMDocumentsProvider, com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public String createDocumentMAM(String str, String str2, String str3) throws FileNotFoundException {
        try {
            if (!verifyAuthenticationAndInit()) {
                return null;
            }
            String id = new TypedId(str).getId();
            BoxResponse<? extends BoxItem> boxResponseTryCreateNewDocument = tryCreateNewDocument(str2, id, str3, false);
            if (boxResponseTryCreateNewDocument != null && !boxResponseTryCreateNewDocument.isSuccess()) {
                Exception exception = boxResponseTryCreateNewDocument.getException();
                if (!(exception instanceof BoxException) || ((BoxException) exception).getResponseCode() != 409) {
                    boxResponseTryCreateNewDocument = tryCreateNewDocument(str2, id, str3, true);
                }
            }
            if (boxResponseTryCreateNewDocument == null || !boxResponseTryCreateNewDocument.isSuccess()) {
                throw new FileNotFoundException();
            }
            return TypedId.getDocumentId("vnd.android.document/directory".equals(str2) ? "folder" : "file", ((BoxItem) boxResponseTryCreateNewDocument.getResult()).getUserId());
        } catch (DifferentUserException unused) {
            throw new FileNotFoundException();
        } catch (PincodeExpiredException unused2) {
            throw new FileNotFoundException();
        }
    }

    @Override // com.microsoft.intune.mam.client.content.MAMDocumentsProvider, com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public void deleteDocumentMAM(String str) throws FileNotFoundException {
        BoxResponse boxResponse;
        try {
            if (!verifyAuthenticationAndInit()) {
                throw new FileNotFoundException();
            }
            TypedId typedId = new TypedId(str);
            try {
                if (typedId.getType().equals("file")) {
                    boxResponse = (BoxResponse) this.mBaseModelController.performRemote(this.mBoxExtendedApiFile.getDeleteRequest(typedId.getId())).get();
                } else if (typedId.getType().equals("folder")) {
                    boxResponse = this.mBaseModelController.performRemote(this.mBoxExtendedApiFolder.getDeleteRequest(typedId.getId())).get();
                } else {
                    throw new FileNotFoundException();
                }
                if (!boxResponse.isSuccess()) {
                    throw new FileNotFoundException();
                }
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                throw new FileNotFoundException();
            }
        } catch (DifferentUserException unused) {
            throw new FileNotFoundException();
        } catch (PincodeExpiredException unused2) {
            throw new FileNotFoundException();
        }
    }

    @Override // android.provider.DocumentsProvider
    public String getDocumentType(String str) throws FileNotFoundException {
        try {
            if (!verifyAuthenticationAndInit()) {
                return null;
            }
            TypedId typedId = new TypedId(str);
            if (typedId.getType().equals("folder")) {
                return "vnd.android.document/directory";
            }
            if (typedId.getType().equals("file")) {
                try {
                    return getTypeForBoxItem((BoxFile) this.mBaseModelController.performLocal(this.mBoxExtendedApiFile.getInfoRequest(typedId.getId())).get().getResult());
                } catch (Exception e) {
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    throw new FileNotFoundException();
                }
            }
            throw new FileNotFoundException();
        } catch (DifferentUserException unused) {
            throw new FileNotFoundException();
        } catch (PincodeExpiredException unused2) {
            throw new FileNotFoundException();
        }
    }

    private int getParcelFileDescriptorMode(String str) {
        if (str.equals("rw") || str.equals("wr")) {
            return 805306368;
        }
        if (str.equals("w")) {
            return C.BUFFER_FLAG_LAST_SAMPLE;
        }
        return 268435456;
    }

    protected boolean verifyAuthenticationAndInit() throws DifferentUserException, PincodeExpiredException {
        if (!BoxBaseApplication.isInitialized()) {
            return false;
        }
        if (this.mUserContextManager.hasValidUserId()) {
            return checkIsUserEnabled();
        }
        BoxAuthentication.BoxAuthenticationInfo authInfo = this.mUserContextManager.getBoxSession(getContext()).getAuthInfo();
        if (authInfo != null) {
            try {
                this.mUserContextManager.createUser(authInfo.getUser().getUserId(), this.mBoxApiPrivate);
                return checkIsUserEnabled();
            } catch (IUserContextComponent.UserContextComponentCreationException unused) {
            }
        }
        return false;
    }

    private boolean checkIsUserEnabled() throws DifferentUserException, PincodeExpiredException {
        if (StringUtils.isEmpty(this.mCurrentUserId)) {
            this.mCurrentUserId = this.mUserContextManager.getCurrentContextId();
        } else {
            boolean zEquals = this.mCurrentUserId.equals(this.mUserContextManager.getCurrentContextId());
            this.mCurrentUserId = this.mUserContextManager.getCurrentContextId();
            if (!zEquals) {
                notifyRootChanged();
                throw new DifferentUserException();
            }
        }
        IUserContextManager iUserContextManager = this.mUserContextManager;
        if (iUserContextManager != null && CreatePincodeActivity.userHasSetPincode(iUserContextManager) && Pincode.shouldShow(this.mUserContextManager)) {
            throw new PincodeExpiredException();
        }
        return ((DocumentProviderPreferences) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.DOCUMENT_PROVIDER_PREFERENCES)).isDocumentProviderUserEnabled();
    }

    @Override // com.microsoft.intune.mam.client.content.MAMDocumentsProvider, com.microsoft.intune.mam.client.content.HookedDocumentsProvider
    public AssetFileDescriptor openDocumentThumbnailMAM(String str, Point point, CancellationSignal cancellationSignal) throws FileNotFoundException {
        String documentType = getDocumentType(str);
        TypedId typedId = new TypedId(str);
        if ("vnd.android.document/directory".equals(documentType)) {
            try {
                return getContext().getAssets().openFd("icon_folder_personal.png");
            } catch (IOException unused) {
                throw new FileNotFoundException();
            }
        }
        try {
            BoxResponse boxResponse = this.mBaseModelController.performLocal(this.mBoxExtendedApiFile.getInfoRequest(typedId.getId())).get();
            if (boxResponse.isSuccess()) {
                BoxFile boxFile = (BoxFile) boxResponse.getResult();
                DownloadThumbnailRunnable downloadThumbnailRunnable = DOWNLOAD_THUMB_NAIL_MAP.get(str);
                File downloadedFile = downloadThumbnailRunnable != null ? downloadThumbnailRunnable.getDownloadedFile() : null;
                if (downloadedFile != null && downloadedFile.exists()) {
                    return new AssetFileDescriptor(ParcelFileDescriptor.open(downloadedFile, 268435456), 0L, -1L);
                }
                downloadThumbnailTask(str, boxFile, cancellationSignal);
                return null;
            }
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            BoxLogUtils.logException(e);
        }
        throw new FileNotFoundException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyThumbnailsFinished() {
        this.mHandler.removeCallbacks(this.notifyThumbnailsFinishedRunnable);
        this.mHandler.postDelayed(this.notifyThumbnailsFinishedRunnable, 400L);
    }

    private void downloadThumbnailTask(final String str, BoxFile boxFile, CancellationSignal cancellationSignal) {
        if (this.mExecutor == null) {
            this.mExecutor = new ThreadPoolExecutor(1, 20, 600L, TimeUnit.SECONDS, new LinkedBlockingLifoDeque(20));
        }
        DownloadThumbnailRunnable downloadThumbnailRunnable = new DownloadThumbnailRunnable(str, boxFile);
        DOWNLOAD_THUMB_NAIL_MAP.put(str, downloadThumbnailRunnable);
        this.mExecutor.submit(downloadThumbnailRunnable);
        cancellationSignal.setOnCancelListener(new BoxThumbnailCancelListener() { // from class: com.box.android.providers.BoxDocumentsProvider.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.box.android.providers.BoxDocumentsProvider.BoxThumbnailCancelListener, android.os.CancellationSignal.OnCancelListener
            public void onCancel() {
                DownloadThumbnailRunnable downloadThumbnailRunnable2 = (DownloadThumbnailRunnable) BoxDocumentsProvider.DOWNLOAD_THUMB_NAIL_MAP.get(str);
                if (downloadThumbnailRunnable2 != null) {
                    downloadThumbnailRunnable2.cancel();
                }
                BoxDocumentsProvider.this.mExecutor.remove(downloadThumbnailRunnable2);
                super.onCancel();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAndWait(Thread thread, CancellationSignal cancellationSignal) {
        thread.start();
        while (thread.isAlive()) {
            if (cancellationSignal != null && cancellationSignal.isCanceled()) {
                thread.interrupt();
            } else {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    BoxLogUtils.logException(e);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFileObserver(FileObserver fileObserver) {
        fileObserver.stopWatching();
        this.mFileObservers.remove(fileObserver);
    }

    private void addFileObserver(FileObserver fileObserver) {
        fileObserver.startWatching();
        this.mFileObservers.add(fileObserver);
    }

    private BoxIterator<BoxItem> getChildrenFileFolders(String str, boolean z) throws FileNotFoundException {
        BoxRequestsFolder.GetFolderWithAllItems folderWithAllItems = this.mBoxExtendedApiFolder.getFolderWithAllItems(str);
        try {
            BoxResponse boxResponse = (z ? this.mBaseModelController.performRemote(folderWithAllItems) : this.mBaseModelController.performLocal(folderWithAllItems)).get();
            if (boxResponse.isSuccess()) {
                return ((BoxFolder) boxResponse.getResult()).getItemCollection();
            }
            throw new FileNotFoundException();
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            throw new FileNotFoundException();
        }
    }

    private BoxResponse<? extends BoxItem> tryCreateNewDocument(String str, String str2, String str3, boolean z) throws FileNotFoundException {
        return createNewDocument(str, str2, getUniqName(str3, getChildrenFileFolders(str2, z), str));
    }

    private BoxResponse<? extends BoxItem> createNewDocument(String str, String str2, String str3) {
        try {
            if ("vnd.android.document/directory".equals(str)) {
                return (BoxResponse) this.mBaseModelController.performRemote(this.mBoxExtendedApiFolder.getCreateRequest(str2, str3)).get();
            }
            BoxRequestUploadFile uploadFileRequest = this.mBoxExtendedApiFile.getUploadFileRequest(File.createTempFile("temp", null), str2, new IBoxRequestUploadFileHelper() { // from class: com.box.android.providers.BoxDocumentsProvider.6
                @Override // com.box.boxandroidlibv2private.requests.requestobjects.IBoxRequestUploadFileHelper
                public void checkBasicError() {
                }

                @Override // com.box.boxandroidlibv2private.requests.requestobjects.IBoxRequestUploadFileHelper
                public void addCustomProperties(HashMap<String, String> map) {
                    map.put(BoxExtendedApiFile.ANALYTICS_PARAM_SOURCE_TYPE, IMoCoBoxTransfers.TransferSourceType.DOCUMENT_PROVIDER.name());
                }
            });
            uploadFileRequest.setFileName(str3);
            return (BoxResponse) this.mBaseModelController.performRemote(uploadFileRequest).get();
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            BoxLogUtils.logException(e);
            return null;
        }
    }

    private String getUniqName(String str, BoxIterator<BoxItem> boxIterator, String str2) {
        String str3;
        String nameWithSuffix;
        HashSet hashSet = new HashSet();
        if (!str2.equals("vnd.android.document/directory")) {
            str3 = "file";
        } else {
            str3 = "folder";
        }
        int size = boxIterator.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            BoxItem boxItem = (BoxItem) boxIterator.get(i2);
            if (str3.equals(boxItem.getType())) {
                hashSet.add(boxItem.getName());
            }
        }
        if (!hashSet.contains(str)) {
            return addOnFileExtensionIfNecessary(str, str2);
        }
        do {
            i++;
            nameWithSuffix = getNameWithSuffix(str, i);
        } while (hashSet.contains(nameWithSuffix));
        return addOnFileExtensionIfNecessary(nameWithSuffix, str2);
    }

    private String addOnFileExtensionIfNecessary(String str, String str2) {
        if (StringUtils.isNotBlank(str) && str.contains(".")) {
            return str;
        }
        String extFromType = MimeTypeHelper.getExtFromType(str2);
        return StringUtils.isEmpty(extFromType) ? str : str + "." + extFromType;
    }

    private String getNameWithSuffix(String str, int i) {
        int iIndexOf = str.indexOf(46);
        return iIndexOf < 0 ? str + "(" + i + ")" : str.substring(0, iIndexOf) + "(" + i + ")" + str.substring(iIndexOf);
    }

    private void notifyRootChanged() {
        getContext().getContentResolver().notifyChange(DocumentsContract.buildRootsUri(AUTHORITY), null);
    }

    static class TypedId {
        private static final String TYPE_ID_DELIMITER = ",";
        private final String mId;
        private final String mType;

        public TypedId(String str) {
            String[] strArrSplit = str.split(",");
            this.mType = strArrSplit[0];
            this.mId = strArrSplit[1];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String getDocumentId(String str, String str2) {
            return str + "," + str2;
        }

        static String getDocumentId(BoxItem boxItem) {
            return getDocumentId(boxItem.getType(), boxItem.getUserId());
        }

        public String getType() {
            return this.mType;
        }

        public String getId() {
            return this.mId;
        }
    }

    private static class LoadingBoxIterator {
        private final BoxIterator<BoxItem> mBoxItems;
        private final boolean mIsLoading;

        public LoadingBoxIterator(BoxIterator<BoxItem> boxIterator, boolean z) {
            this.mBoxItems = boxIterator;
            this.mIsLoading = z;
        }

        public BoxIterator<BoxItem> getBoxItems() {
            return this.mBoxItems;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isLoading() {
            return this.mIsLoading;
        }
    }

    private static class DifferentUserException extends Exception {
        private static final long serialVersionUID = 1;

        private DifferentUserException() {
        }
    }

    private static class PincodeExpiredException extends Exception {
        private static final long serialVersionUID = 1;

        private PincodeExpiredException() {
        }
    }

    private class DocumentFileObserver extends FileObserver {
        private final File mFile;
        private final String mFileId;
        private final String mFileName;
        private boolean mIsRetrying;
        private final CancellationSignal mSignal;
        private boolean modified;

        public DocumentFileObserver(String str, String str2, String str3, CancellationSignal cancellationSignal) {
            super(str, 10);
            this.modified = false;
            this.mIsRetrying = false;
            this.mFile = new File(str);
            this.mFileId = str2;
            this.mFileName = str3;
            this.mSignal = cancellationSignal;
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if (i == 2) {
                this.modified = true;
            } else if (i == 8) {
                onCloseEvent();
            }
        }

        private void onCloseEvent() {
            try {
                if (this.modified) {
                    uploadNewVersion();
                }
            } catch (Exception e) {
                BoxLogUtils.logException(e);
            } finally {
                if (!this.mIsRetrying) {
                    FileUtils.deleteQuietly(this.mFile);
                }
                BoxDocumentsProvider.this.removeFileObserver(this);
            }
        }

        private void uploadNewVersion() {
            BoxDocumentsProvider.this.startAndWait(new Thread() { // from class: com.box.android.providers.BoxDocumentsProvider.DocumentFileObserver.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    final String string;
                    try {
                        BoxFile boxFile = (BoxFile) BoxDocumentsProvider.this.mBaseModelController.performLocal(BoxDocumentsProvider.this.mBoxExtendedApiFile.getInfoRequest(DocumentFileObserver.this.mFileId)).get().getResult();
                        BoxFileTransferMessage boxFileTransferMessage = (BoxFileTransferMessage) BoxDocumentsProvider.this.mTransfersModelController.uploadFileNewVersion(boxFile, DocumentFileObserver.this.mFileName, new UploadModelBoxFile.UriFile(DocumentFileObserver.this.mFile), false, true, IMoCoBoxTransfers.TransferSourceType.DOCUMENT_PROVIDER, new ProgressReporter.FileTransferProgressListener(), BoxDocumentsProvider.this.mBoxExtendedApiFile, null, -1, -1L).runAndGet();
                        Context contextRequireContext = BoxDocumentsProvider.this.requireContext();
                        if (boxFileTransferMessage.wasSuccessful()) {
                            string = contextRequireContext.getResources().getString(R.string.upload_completed_successfully);
                        } else {
                            Exception exception = boxFileTransferMessage.getException();
                            if ((exception instanceof BoxException) && ((BoxException) exception).getResponseCode() == 412) {
                                DocumentFileObserver.this.mIsRetrying = true;
                                Intent intentCreateLaunchIntent = UploadOverwriteDialogActivity.createLaunchIntent(contextRequireContext, boxFile, DocumentFileObserver.this.mFile.getAbsolutePath(), DocumentFileObserver.this.mFileName);
                                intentCreateLaunchIntent.addFlags(268435456);
                                contextRequireContext.startActivity(intentCreateLaunchIntent);
                                return;
                            }
                            string = contextRequireContext.getString(R.string.unable_to_upload_try_again_later);
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.providers.BoxDocumentsProvider.DocumentFileObserver.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(BoxDocumentsProvider.this.getContext(), string, 1).show();
                            }
                        });
                    } catch (InterruptedException e) {
                        BoxLogUtils.logException(e);
                        Thread.currentThread().interrupt();
                    } catch (ExecutionException e2) {
                        BoxLogUtils.logException(e2);
                    }
                }
            }, this.mSignal);
        }

        public int hashCode() {
            return this.mFileId.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof DocumentFileObserver) {
                return this.mFileId.equals(((DocumentFileObserver) obj).mFileId);
            }
            return false;
        }
    }

    public class DownloadThumbnailRunnable implements Runnable {
        protected final BoxFile mBoxFile;
        private final CountDownLatch mCountDownLatch = new CountDownLatch(1);
        protected final String mDocumentId;
        private BoxAppFutureTask<BoxDownload> mDownloadTask;
        protected File mFile;

        public DownloadThumbnailRunnable(String str, BoxFile boxFile) {
            this.mDocumentId = str;
            this.mBoxFile = boxFile;
        }

        public File getDownloadedFile() {
            return this.mFile;
        }

        public void cancel() {
            this.mCountDownLatch.countDown();
            ThreadPoolExecutor documentProviderThumbnailExecutor = ((ExecutorPool) BoxDocumentsProvider.this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getDocumentProviderThumbnailExecutor();
            if (documentProviderThumbnailExecutor != null) {
                documentProviderThumbnailExecutor.remove(this.mDownloadTask);
            }
        }

        public void complete() {
            BoxDocumentsProvider.this.mThumbnailsChanged.getAndIncrement();
            this.mCountDownLatch.countDown();
            BoxDocumentsProvider.this.notifyThumbnailsFinished();
        }

        @Override // java.lang.Runnable
        public void run() {
            BoxRequestsFile.DownloadThumbnail thumbnailRequest = BoxDocumentsProvider.this.mBrowseController.getThumbnailRequest(this.mBoxFile.getUserId(), BoxDocumentsProvider.this.mThumbnailManager.getThumbnailForBoxFile(this.mBoxFile));
            thumbnailRequest.setFormat(BoxRequestsFile.DownloadThumbnail.Format.PNG);
            File target = thumbnailRequest.getTarget();
            if (target.exists() && target.length() > 0) {
                this.mFile = target;
                BoxDocumentsProvider.this.notifyThumbnailsFinished();
                return;
            }
            ThreadPoolExecutor documentProviderThumbnailExecutor = ((ExecutorPool) BoxDocumentsProvider.this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getDocumentProviderThumbnailExecutor();
            if (documentProviderThumbnailExecutor != null) {
                BoxAppFutureTask<BoxDownload> boxAppFutureTask = new BoxAppFutureTask<>(thumbnailRequest);
                this.mDownloadTask = boxAppFutureTask;
                boxAppFutureTask.addOnCompletedListener(new BoxAppFutureTask.OnCompletedListener<BoxDownload>() { // from class: com.box.android.providers.BoxDocumentsProvider.DownloadThumbnailRunnable.1
                    @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
                    public void onCompleted(BoxResponse<BoxDownload> boxResponse) {
                        if (boxResponse.isSuccess()) {
                            DownloadThumbnailRunnable.this.mFile = ((BoxDownload) boxResponse.getResult()).getOutputFile();
                        }
                        DownloadThumbnailRunnable.this.complete();
                    }
                });
                documentProviderThumbnailExecutor.execute(this.mDownloadTask);
            }
            try {
                this.mCountDownLatch.await();
            } catch (InterruptedException e) {
                BoxLogUtils.logException(e);
                Thread.currentThread().interrupt();
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof DownloadThumbnailRunnable) {
                return this.mDocumentId.equals(((DownloadThumbnailRunnable) obj).mDocumentId);
            }
            return false;
        }

        public int hashCode() {
            return this.mDocumentId.hashCode();
        }
    }

    private class BoxThumbnailCancelListener implements CancellationSignal.OnCancelListener {
        private boolean mIsCancelled;

        private BoxThumbnailCancelListener() {
        }

        @Override // android.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            this.mIsCancelled = true;
        }

        public boolean isCancelled() {
            return this.mIsCancelled;
        }
    }
}
