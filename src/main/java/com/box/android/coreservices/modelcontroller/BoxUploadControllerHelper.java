package com.box.android.coreservices.modelcontroller;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.dao.UploadModelBoxFile;
import com.box.android.coreservices.modelcontroller.messages.BoxFileTransferMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxUploadFileMessage;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.listeners.ProgressListener;
import com.box.androidsdk.content.models.BoxError;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxIteratorUploadSessionParts;
import com.box.androidsdk.content.models.BoxUploadSession;
import com.box.androidsdk.content.models.BoxUploadSessionPart;
import com.box.androidsdk.content.requests.BoxRequestUpload;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.requests.requestobjects.IBoxRequestUploadFileHelper;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxUploadControllerHelper implements Callable<BoxFileTransferMessage> {
    private static final long MIN_MULTIPART_FILE_SIZE = 20000000;
    int mAttempt;
    private IBaseModelController mBaseModelController;
    protected BoxExtendedApiFile mBoxApiFile;
    private Thread mCurrentThread;
    protected String mFileName;
    protected UploadModelBoxFile.UriFile mFileToUpload;
    protected IBoxRequestUploadFileHelper mRequestHelper;
    private boolean mRequiresWifi;
    long mStartTime;
    protected ProgressReporter.FileTransferProgressListener mTransferListener;
    private IMoCoBoxTransfers.TransferSourceType mTransferSource;
    private BoxUploadSession mUploadSession;
    private IUserContextManager mUserContextManager;
    private final int STATUS_RANGE_NOT_SATISFIABLE = 416;
    private final String ERROR_RANGE_OVERLAP_EXISTING = "range_overlaps_existing_part";
    private ConcurrentLinkedQueue<FutureTask> mCurrentTasks = new ConcurrentLinkedQueue<FutureTask>() { // from class: com.box.android.coreservices.modelcontroller.BoxUploadControllerHelper.1
        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
        public boolean add(FutureTask futureTask) {
            if (BoxUploadControllerHelper.this.mIsCancelled) {
                futureTask.cancel(true);
            }
            return super.add(futureTask);
        }
    };
    private boolean mIsCancelled = false;

    protected abstract BoxRequestUpload createUploadRequest() throws FileNotFoundException;

    protected abstract BoxUploadSession getMultiputUploadSession() throws ExecutionException, InterruptedException, FileNotFoundException;

    protected abstract BoxFolder getParentFolder();

    protected abstract boolean hasBasicErrors(BoxUploadFileMessage boxUploadFileMessage);

    protected void onSuccess(BoxUploadFileMessage boxUploadFileMessage) throws ExecutionException, InterruptedException {
    }

    protected BoxUploadControllerHelper(IBaseModelController iBaseModelController, IUserContextManager iUserContextManager, BoxExtendedApiFile boxExtendedApiFile, UploadModelBoxFile.UriFile uriFile, String str, ProgressReporter.FileTransferProgressListener fileTransferProgressListener, IMoCoBoxTransfers.TransferSourceType transferSourceType, boolean z, int i, long j) {
        this.mBoxApiFile = boxExtendedApiFile;
        this.mFileToUpload = uriFile;
        this.mFileName = str;
        this.mTransferListener = fileTransferProgressListener;
        this.mTransferSource = transferSourceType;
        this.mRequiresWifi = z;
        this.mBaseModelController = iBaseModelController;
        this.mUserContextManager = iUserContextManager;
        this.mAttempt = i;
        this.mStartTime = j;
    }

    public void setMultiputSession(BoxUploadSession boxUploadSession) {
        this.mUploadSession = boxUploadSession;
    }

    private BoxResponse<BoxFile> sendUploadRequest() throws ExecutionException, InterruptedException, NoSuchAlgorithmException, FileNotFoundException {
        this.mRequestHelper = new IBoxRequestUploadFileHelper() { // from class: com.box.android.coreservices.modelcontroller.BoxUploadControllerHelper.2
            @Override // com.box.boxandroidlibv2private.requests.requestobjects.IBoxRequestUploadFileHelper
            public void checkBasicError() {
            }

            @Override // com.box.boxandroidlibv2private.requests.requestobjects.IBoxRequestUploadFileHelper
            public void addCustomProperties(HashMap<String, String> map) {
                if (BoxUploadControllerHelper.this.mTransferSource != IMoCoBoxTransfers.TransferSourceType.DEFAULT) {
                    map.put(BoxExtendedApiFile.ANALYTICS_PARAM_SOURCE_TYPE, BoxUploadControllerHelper.this.mTransferSource.name());
                }
            }
        };
        BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_GENERAL_STATS, BoxAnalyticsParams.ACTION_UPLOAD_STARTED, CommonBoxUtil.getConnectionType());
        BoxRequestUpload boxRequestUploadCreateUploadRequest = createUploadRequest();
        try {
            boxRequestUploadCreateUploadRequest.setSha1(SdkUtils.sha1(this.mFileToUpload.getInputStream()));
        } catch (IOException e) {
            BoxLogUtils.logException(IMoCoBoxTransfers.UPLOADS_TAG, "Could not open input stream for sha1", e);
        }
        boxRequestUploadCreateUploadRequest.setFields(BoxApiPrivate.FOLDER_FIELDS);
        boxRequestUploadCreateUploadRequest.setUploadSize(this.mFileToUpload.length());
        boxRequestUploadCreateUploadRequest.setProgressListener(this.mTransferListener);
        com.box.androidsdk.content.BoxFutureTask<E> task = boxRequestUploadCreateUploadRequest.toTask();
        this.mCurrentTasks.add(task);
        task.run();
        return (BoxResponse) task.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private BoxResponse<BoxFile> sendMultiputRequest() throws Exception {
        long jLongValue;
        com.box.androidsdk.content.BoxFutureTask boxFutureTask = null;
        Object[] objArr = 0;
        PartsInfo partsInfo = new PartsInfo(new HashSet(), 0L);
        ArrayList arrayList = new ArrayList();
        try {
            if (this.mFileToUpload.length() < MIN_MULTIPART_FILE_SIZE) {
                BoxLogUtils.v(IMoCoBoxTransfers.UPLOADS_TAG, "Using regular upload because file is smaller than multiput requirement");
                return null;
            }
            if (this.mUploadSession != null) {
                int i = 0;
                do {
                    BoxRequestsFile.ListUploadSessionParts listUploadSessionRequest = this.mBoxApiFile.getListUploadSessionRequest(this.mUploadSession);
                    listUploadSessionRequest.setOffset(i);
                    BoxIteratorUploadSessionParts boxIteratorUploadSessionPartsSend = listUploadSessionRequest.send();
                    i += 1000;
                    jLongValue = boxIteratorUploadSessionPartsSend.fullSize().longValue();
                    arrayList.addAll(boxIteratorUploadSessionPartsSend.getEntries());
                } while (i < jLongValue);
                partsInfo = getCompletedPartsInfoFromSession(this.mUploadSession, arrayList);
            } else {
                this.mUploadSession = getMultiputUploadSession();
            }
            BoxUploadSession boxUploadSession = this.mUploadSession;
            if (boxUploadSession == null) {
                BoxLogUtils.w(IMoCoBoxTransfers.UPLOADS_TAG, "Upload session creation failed, Abort!");
                return null;
            }
            this.mTransferListener.onSessionInitialized(boxUploadSession);
            MultiputProgressListener multiputProgressListener = new MultiputProgressListener(this.mTransferListener, this.mFileToUpload.length());
            multiputProgressListener.setResumedProgress(partsInfo.mTotalTransfered);
            for (int i2 = 0; i2 < this.mUploadSession.getTotalParts(); i2++) {
                if (!partsInfo.mFinishedPartIds.contains(Integer.valueOf(i2))) {
                    BoxRequestsFile.UploadSessionPart uploadSessionPartRequest = this.mBoxApiFile.getUploadSessionPartRequest(this.mFileToUpload.getInputStream(), this.mFileToUpload.length(), this.mUploadSession, i2);
                    uploadSessionPartRequest.setProgressListener(multiputProgressListener);
                    com.box.androidsdk.content.BoxFutureTask<BoxUploadSessionPart> task = uploadSessionPartRequest.toTask();
                    this.mCurrentTasks.add(task);
                    task.run();
                    BoxResponse boxResponse = task.get();
                    if (!boxResponse.isSuccess()) {
                        if ((boxResponse.getException() instanceof BoxException) && ((BoxException) boxResponse.getException()).getResponseCode() == 416 && ((BoxException) boxResponse.getException()).getAsBoxError().getError().equals("range_overlaps_existing_part")) {
                            BoxError.ErrorContext contextInfo = ((BoxException) boxResponse.getException()).getAsBoxError().getContextInfo();
                            if ((contextInfo.getConflictingPart() instanceof BoxUploadSessionPart) && contextInfo.getConflictingPart().getSize() == uploadSessionPartRequest.getPartSize()) {
                                BoxLogUtils.w(IMoCoBoxTransfers.UPLOADS_TAG, "Tried uploading part that was already uploaded to server");
                                arrayList.add(contextInfo.getConflictingPart());
                                multiputProgressListener.onPartCompleted();
                            }
                        }
                        this.mTransferListener.onError(boxResponse.getException());
                        BoxResponse<BoxFile> boxResponse2 = new BoxResponse<>(null, boxResponse.getException(), boxResponse.getRequest());
                        BoxLogUtils.e(IMoCoBoxTransfers.UPLOADS_TAG, "Upload part failed. Cause: " + boxResponse.getException().getMessage());
                        return boxResponse2;
                    }
                    arrayList.add((BoxUploadSessionPart) boxResponse.getResult());
                    multiputProgressListener.onPartCompleted();
                }
            }
            com.box.androidsdk.content.BoxFutureTask<E> task2 = this.mBoxApiFile.getCommitSessionRequest(arrayList, this.mUploadSession).setFields(BoxApiPrivate.FOLDER_FIELDS).toTask();
            this.mCurrentTasks.add(task2);
            task2.run();
            return (BoxResponse) task2.get();
        } catch (Exception e) {
            if (0 != 0 && !boxFutureTask.isCancelled()) {
                try {
                    (objArr == true ? 1 : 0).cancel(true);
                    throw e;
                } catch (Exception unused) {
                    throw e;
                }
            }
            throw e;
        }
    }

    public boolean cancel(boolean z) {
        boolean zCancel = true;
        this.mIsCancelled = true;
        Thread thread = this.mCurrentThread;
        if (thread != null) {
            thread.interrupt();
        }
        Iterator<FutureTask> it = this.mCurrentTasks.iterator();
        while (it.hasNext()) {
            try {
                zCancel &= it.next().cancel(z);
            } catch (Exception unused) {
            }
        }
        return zCancel;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public BoxFileTransferMessage call() throws Exception {
        this.mCurrentThread = Thread.currentThread();
        BoxUploadFileMessage boxUploadFileMessage = new BoxUploadFileMessage();
        boxUploadFileMessage.setRequestId(IBaseModelController.INSTANCE.getNextRequestId());
        boxUploadFileMessage.setDestinationFileName(this.mFileName);
        boxUploadFileMessage.setFileSize(this.mFileToUpload.length());
        boxUploadFileMessage.setRequiresWifi(this.mRequiresWifi);
        boxUploadFileMessage.setJavaFilePayload(this.mFileToUpload);
        boxUploadFileMessage.setTransferSource(this.mTransferSource);
        boxUploadFileMessage.setSuccess(false);
        this.mTransferListener.setFileTransferMessage(boxUploadFileMessage);
        if (this.mIsCancelled) {
            return boxUploadFileMessage;
        }
        try {
            if (hasBasicErrors(boxUploadFileMessage)) {
                if (boxUploadFileMessage.getException() == null) {
                    boxUploadFileMessage.setException(new Exception("Preflight checks failed"));
                }
                this.mTransferListener.onCompletedMessage(boxUploadFileMessage);
                return boxUploadFileMessage;
            }
        } catch (Exception e) {
            BoxLogUtils.logException(IMoCoBoxTransfers.UPLOADS_TAG, "Pre-upload checks failed", e);
        }
        try {
            try {
                BoxLogUtils.v(IMoCoBoxTransfers.UPLOADS_TAG, "Sending multi-put upload request");
                BoxResponse<BoxFile> boxResponseSendMultiputRequest = sendMultiputRequest();
                if (boxResponseSendMultiputRequest == null) {
                    BoxLogUtils.v(IMoCoBoxTransfers.UPLOADS_TAG, "Sending regular upload request");
                    boxResponseSendMultiputRequest = sendUploadRequest();
                } else {
                    boxUploadFileMessage.setIsMultiputUpload();
                }
                if (boxResponseSendMultiputRequest.isSuccess()) {
                    BoxFile boxFile = (BoxFile) boxResponseSendMultiputRequest.getResult();
                    boxUploadFileMessage.setFileId(boxFile.getUserId());
                    boxUploadFileMessage.setLocalMetadata("file", boxFile.getUserId(), this.mBaseModelController.getKeyValueStore());
                    boxUploadFileMessage.setPayload(boxFile);
                    boxUploadFileMessage.setSuccess(true);
                    onSuccess(boxUploadFileMessage);
                    this.mTransferListener.onCompleted(boxResponseSendMultiputRequest);
                    this.mFileToUpload.deleteIfTemporary(this.mUserContextManager);
                    BoxLogUtils.d(IMoCoBoxTransfers.UPLOADS_TAG, "Upload succeeded");
                } else {
                    boxUploadFileMessage.setSuccess(false);
                    boxUploadFileMessage.setException(boxResponseSendMultiputRequest.getException());
                    this.mTransferListener.onError(boxResponseSendMultiputRequest.getException());
                    BoxLogUtils.w(IMoCoBoxTransfers.UPLOADS_TAG, "Upload failed");
                }
                CoreServiceUtils.broadcastIntent(this.mUserContextManager, new BoxResponseMessage(boxResponseSendMultiputRequest, true));
            } catch (Exception e2) {
                if (e2 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                    BoxLogUtils.d(IMoCoBoxTransfers.UPLOADS_TAG, "Upload cancelled");
                } else {
                    BoxLogUtils.w(IMoCoBoxTransfers.UPLOADS_TAG, "Upload terminated exceptionally");
                }
                boxUploadFileMessage.setException(e2);
                this.mTransferListener.onError(e2);
            }
            logFinishUploadAnalytics(boxUploadFileMessage);
            this.mTransferListener.onCompletedMessage(boxUploadFileMessage);
            BoxLogUtils.d(IMoCoBoxTransfers.UPLOADS_TAG, "Upload completed");
            CoreServiceUtils.broadcastIntent(this.mUserContextManager, boxUploadFileMessage);
            return boxUploadFileMessage;
        } catch (Throwable th) {
            logFinishUploadAnalytics(boxUploadFileMessage);
            this.mTransferListener.onCompletedMessage(boxUploadFileMessage);
            BoxLogUtils.d(IMoCoBoxTransfers.UPLOADS_TAG, "Upload completed");
            throw th;
        }
    }

    private static class PartsInfo {
        private Set<Integer> mFinishedPartIds;
        private long mTotalTransfered;

        private PartsInfo(Set<Integer> set, long j) {
            this.mFinishedPartIds = set;
            this.mTotalTransfered = j;
        }
    }

    private PartsInfo getCompletedPartsInfoFromSession(BoxUploadSession boxUploadSession, List<BoxUploadSessionPart> list) {
        HashSet hashSet = new HashSet();
        long size = 0;
        if (list != null) {
            for (BoxUploadSessionPart boxUploadSessionPart : list) {
                hashSet.add(Integer.valueOf((int) (boxUploadSessionPart.getOffset() / ((long) boxUploadSession.getPartSize()))));
                size += boxUploadSessionPart.getSize();
            }
        }
        return new PartsInfo(hashSet, size);
    }

    private void logFinishUploadAnalytics(BoxUploadFileMessage boxUploadFileMessage) {
        try {
            String strName = boxUploadFileMessage.getTransferSource() != null ? boxUploadFileMessage.getTransferSource().name() : BoxAnalyticsParams.ACTION_DEFAULT_UPLOADED;
            if (!boxUploadFileMessage.wasSuccessful()) {
                BoxLogUtils.logException(IMoCoBoxTransfers.UPLOADS_TAG, "Upload error", boxUploadFileMessage.getException());
            }
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_GENERAL_STATS, "upload_completed_" + strName, CommonBoxUtil.getConnectionType(), (Integer) 1);
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_GENERAL_STATS, "upload_completed_" + strName, boxUploadFileMessage.isMultiputUpload() ? "multiput" : "non-multiput", (Integer) 1);
            if (boxUploadFileMessage.getTransferSource() == IMoCoBoxTransfers.TransferSourceType.AUTO_CONTENT_UPLOAD) {
                BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_GENERAL_STATS, BoxAnalyticsParams.ACTION_AUTO_CONTENT_UPLOADED, CommonBoxUtil.getFileExtension(boxUploadFileMessage.getFileName(), "").toLowerCase(), Integer.valueOf((int) boxUploadFileMessage.getFileSize()));
            } else {
                BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_GENERAL_STATS, BoxAnalyticsParams.ACTION_DEFAULT_UPLOADED, CommonBoxUtil.getFileExtension(boxUploadFileMessage.getFileName(), "").toLowerCase(), Integer.valueOf((int) boxUploadFileMessage.getFileSize()));
            }
        } catch (Exception e) {
            BoxLogUtils.logException(e);
        }
    }

    private static class MultiputProgressListener implements ProgressListener, BoxAppFutureTask.OnCompletedListener {
        private ProgressReporter.FileTransferProgressListener mFileListener;
        private long mFileSize;
        private long mPartProgress;
        private long mProgress;

        MultiputProgressListener(ProgressReporter.FileTransferProgressListener fileTransferProgressListener, long j) {
            this.mFileListener = fileTransferProgressListener;
            this.mFileSize = j;
        }

        void setResumedProgress(long j) {
            this.mProgress = j;
            this.mFileListener.onProgressChanged(j, this.mFileSize);
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
        public void onCompleted(BoxResponse boxResponse) {
            this.mFileListener.onCompleted(boxResponse);
        }

        @Override // com.box.androidsdk.content.listeners.ProgressListener
        public void onProgressChanged(long j, long j2) {
            this.mPartProgress = j;
            this.mFileListener.onProgressChanged(this.mProgress + j, this.mFileSize);
        }

        void onPartCompleted() {
            this.mProgress += this.mPartProgress;
            this.mPartProgress = 0L;
        }
    }
}
