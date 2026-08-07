package com.box.android.coreservices.jobmanager.progresslisteners;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.tasks.BoxItemTask;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.android.coreservices.jobmanager.tasks.OfflineTask;
import com.box.android.coreservices.modelcontroller.messages.BoxFileTransferMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes9.dex */
public class LocalBroadcastTransferTaskProgressListener implements ProgressReporter.ProgressListener {
    private final LocalBroadcastManager mLocalBroadcastManager;
    private final AtomicLong mLastProgressUpdateTime = new AtomicLong();
    private final long THROTTLE_TIME = 300;

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
    public void onPaused(ProgressReporter progressReporter) {
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
    public void onStarted(ProgressReporter progressReporter) {
    }

    public LocalBroadcastTransferTaskProgressListener(LocalBroadcastManager localBroadcastManager) {
        this.mLocalBroadcastManager = localBroadcastManager;
    }

    private String getUpdateActionString(BoxTask boxTask) {
        if (boxTask instanceof OfflineTask) {
            return Controller.ACTION_MAKING_FILE_AVAILABLE_OFFLINE;
        }
        return "";
    }

    private String getErrorActionString(BoxTask boxTask) {
        if (boxTask instanceof OfflineTask) {
            return Controller.ACTION_MADE_FILE_AVAILABLE_OFFLINE;
        }
        return "";
    }

    private String getCompletedActionString(BoxTask boxTask) {
        if (boxTask instanceof OfflineTask) {
            return Controller.ACTION_MADE_FILE_AVAILABLE_OFFLINE;
        }
        return "";
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
    public void onProgressUpdated(ProgressReporter progressReporter, ProgressReporter.ProgressType progressType, long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.mLastProgressUpdateTime.get() + 300 > jCurrentTimeMillis) {
            return;
        }
        this.mLastProgressUpdateTime.set(jCurrentTimeMillis);
        if (progressReporter instanceof BoxItemTask) {
            BoxFileTransferMessage boxFileTransferMessage = new BoxFileTransferMessage(getUpdateActionString((BoxTask) progressReporter));
            boxFileTransferMessage.setFileId(((BoxItemTask) progressReporter).getItemId());
            boxFileTransferMessage.setBytesTransferred(progressReporter.getProgress(ProgressReporter.ProgressType.BYTES));
            boxFileTransferMessage.setFileSize(progressReporter.getMax(ProgressReporter.ProgressType.BYTES));
            this.mLocalBroadcastManager.sendBroadcast(boxFileTransferMessage);
        }
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
    public void onError(ProgressReporter progressReporter, Exception exc) {
        if (progressReporter instanceof BoxItemTask) {
            BoxFileTransferMessage boxFileTransferMessage = new BoxFileTransferMessage(getErrorActionString((BoxTask) progressReporter));
            boxFileTransferMessage.setFileId(((BoxItemTask) progressReporter).getItemId());
            boxFileTransferMessage.setSuccess(false);
            boxFileTransferMessage.setException(exc);
            boxFileTransferMessage.setBytesTransferred(progressReporter.getProgress(ProgressReporter.ProgressType.BYTES));
            boxFileTransferMessage.setFileSize(progressReporter.getMax(ProgressReporter.ProgressType.BYTES));
            this.mLocalBroadcastManager.sendBroadcast(boxFileTransferMessage);
        }
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
    public void onCompleted(ProgressReporter progressReporter) {
        if (progressReporter instanceof BoxItemTask) {
            BoxFileTransferMessage boxFileTransferMessage = new BoxFileTransferMessage(getCompletedActionString((BoxTask) progressReporter));
            boxFileTransferMessage.setFileId(((BoxItemTask) progressReporter).getItemId());
            boxFileTransferMessage.setSuccess(true);
            boxFileTransferMessage.setBytesTransferred(progressReporter.getProgress(ProgressReporter.ProgressType.BYTES));
            boxFileTransferMessage.setFileSize(progressReporter.getMax(ProgressReporter.ProgressType.BYTES));
            this.mLocalBroadcastManager.sendBroadcast(boxFileTransferMessage);
        }
    }
}
