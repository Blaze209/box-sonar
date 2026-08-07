package com.box.android.coreservices.modelcontroller.messages;

/* JADX INFO: loaded from: classes9.dex */
public class BoxFileTransferServiceMessage extends BoxMessage<Void> {
    public static final String ACTION_FILE_TRANSFER_PROGRESS = "com.box.android.fileTransferProgress";
    public static final String ACTION_FOLDER_TRANSFER_PROGRESS = "com.box.android.folderTransferProgress";
    public static final String ACTION_QUEUE_CHANGED = "com.box.android.controller.FileTransferService.ACTION_QUEUE_CHANGED";
    private static final String ARG_BYTES_IN_QUEUE = "bytes_in_queue";
    private static final String ARG_BYTES_TRANSFERRED = "bytes_transferred";
    private static final String ARG_FOLDER_ID = "folder_id";
    private static final String ARG_IS_IN_PROGRESS = "is_in_progress";
    private static final String ARG_NUM_ERROR = "num_error";
    private static final String ARG_NUM_IN_QUEUE = "num_in_queue";
    private static final String ARG_NUM_TRANSFER_FINISHED = "num__transfer_finished";

    public BoxFileTransferServiceMessage(String str) {
        setAction(str);
    }

    public long getBytesTransferred() {
        return getLongExtra(ARG_BYTES_TRANSFERRED, 0L);
    }

    public void setBytesTransferred(long j) {
        putExtra(ARG_BYTES_TRANSFERRED, j);
    }

    public void addBytesTransferred(long j) {
        setBytesTransferred(j + getBytesTransferred());
    }

    public long getBytesInQueue() {
        return getLongExtra(ARG_BYTES_IN_QUEUE, 0L);
    }

    public void setBytesInQueue(long j) {
        putExtra(ARG_BYTES_IN_QUEUE, j);
    }

    public void addBytesInQueue(long j) {
        setBytesInQueue(getBytesInQueue() + j);
    }

    public int getNumInQueue() {
        return getIntExtra(ARG_NUM_IN_QUEUE, 0);
    }

    public void setNumInQueue(int i) {
        putExtra(ARG_NUM_IN_QUEUE, i);
    }

    public void addNumInQueue(int i) {
        setNumInQueue(getNumInQueue() + i);
    }

    public boolean isInProgress() {
        return getBooleanExtra(ARG_IS_IN_PROGRESS, false);
    }

    public void setInProgress(boolean z) {
        putExtra(ARG_IS_IN_PROGRESS, z);
    }

    public int getNumError() {
        return getIntExtra(ARG_NUM_ERROR, 0);
    }

    public void setNumError(int i) {
        putExtra(ARG_NUM_ERROR, i);
    }

    public int getNumTransferFinished() {
        return getIntExtra(ARG_NUM_TRANSFER_FINISHED, 0);
    }

    public void setNumTransferFinished(int i) {
        putExtra(ARG_NUM_TRANSFER_FINISHED, i);
    }

    public String getFolderId() {
        return getStringExtra("folder_id");
    }

    public void setFolderId(String str) {
        putExtra("folder_id", str);
    }
}
