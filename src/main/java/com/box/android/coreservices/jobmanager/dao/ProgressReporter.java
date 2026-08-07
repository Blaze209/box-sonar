package com.box.android.coreservices.jobmanager.dao;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.messages.BoxFileTransferMessage;
import com.box.androidsdk.content.models.BoxUploadSession;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;

/* JADX INFO: loaded from: classes9.dex */
public interface ProgressReporter {
    public static final long PROGRESS_FAILED = -2;
    public static final long PROGRESS_INDETERMINATE = -4;
    public static final long PROGRESS_UNKNOWN = -1;
    public static final long PROGRESS_UNSUPPORTED = -3;

    public interface JobProgressListener extends ProgressListener {
        void onTaskAdded(BoxTask boxTask);
    }

    public interface ProgressListener {
        void onCompleted(ProgressReporter progressReporter);

        void onError(ProgressReporter progressReporter, Exception exc);

        void onPaused(ProgressReporter progressReporter);

        void onProgressUpdated(ProgressReporter progressReporter, ProgressType progressType, long j, long j2);

        void onStarted(ProgressReporter progressReporter);
    }

    public enum ProgressType {
        BYTES,
        PERCENTAGE,
        NUM_FILES,
        NUM_TASKS
    }

    void addProgressListener(ProgressListener progressListener);

    long getMax(ProgressType progressType);

    long getProgress(ProgressType progressType);

    ProgressType[] getSupportedProgressTypes();

    void removeProgressListener(ProgressListener progressListener);

    public static class FileTransferProgressListener implements com.box.androidsdk.content.listeners.ProgressListener, BoxAppFutureTask.OnCompletedListener {
        private long mBytesTransferred;
        private Exception mException;
        private BoxFileTransferMessage mFileTransferMessage;
        private boolean mIsCompleted;
        private final LocalBroadcastManager mLocalBroadcastManager;
        protected long mTotalBytes;

        public void onCompletedMessage(BoxFileTransferMessage boxFileTransferMessage) {
        }

        public void onPaused(ProgressReporter progressReporter) {
        }

        public void onSessionInitialized(BoxUploadSession boxUploadSession) {
        }

        public void onStarted(ProgressReporter progressReporter) {
        }

        public FileTransferProgressListener() {
            this(0L);
        }

        public FileTransferProgressListener(long j) {
            this.mTotalBytes = j;
            this.mLocalBroadcastManager = LocalBroadcastManager.getInstance(ApplicationProvider.getApplication());
        }

        public long getBytesTransferred() {
            return this.mBytesTransferred;
        }

        public void setFileTransferMessage(BoxFileTransferMessage boxFileTransferMessage) {
            this.mFileTransferMessage = boxFileTransferMessage;
        }

        public void setBytesTransferred(long j) {
            this.mBytesTransferred = j;
            BoxFileTransferMessage boxFileTransferMessage = this.mFileTransferMessage;
            if (boxFileTransferMessage != null) {
                boxFileTransferMessage.setBytesTransferred(j);
                this.mLocalBroadcastManager.sendBroadcast(this.mFileTransferMessage.getInProgressMessage());
            }
        }

        public boolean hasCompleted() {
            return this.mIsCompleted;
        }

        public boolean hasError() {
            return this.mException != null;
        }

        public Exception getException() {
            return this.mException;
        }

        @Override // com.box.androidsdk.content.listeners.ProgressListener
        public void onProgressChanged(long j, long j2) {
            setBytesTransferred(j);
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
        public void onCompleted(BoxResponse boxResponse) {
            this.mIsCompleted = true;
            BoxFileTransferMessage boxFileTransferMessage = this.mFileTransferMessage;
            if (boxFileTransferMessage == null || boxResponse == null) {
                return;
            }
            boxFileTransferMessage.setSuccess(boxResponse.isSuccess());
            Exception exception = boxResponse.getException();
            this.mException = exception;
            if (exception != null) {
                this.mFileTransferMessage.setException(exception);
            }
            this.mLocalBroadcastManager.sendBroadcast(this.mFileTransferMessage);
        }

        public void onError(Exception exc) {
            this.mException = exc;
            BoxFileTransferMessage boxFileTransferMessage = this.mFileTransferMessage;
            if (boxFileTransferMessage != null) {
                boxFileTransferMessage.setException(exc);
                this.mFileTransferMessage.setSuccess(false);
                if (exc != null) {
                    BoxLogUtils.logException(exc);
                }
                this.mLocalBroadcastManager.sendBroadcast(this.mFileTransferMessage);
            }
        }
    }
}
