package com.box.android.coreservices.modelcontroller.messages;

import android.os.Bundle;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.androidsdk.content.models.BoxDownload;
import com.box.androidsdk.content.models.BoxFile;
import java.io.File;

/* JADX INFO: loaded from: classes9.dex */
public class BoxFileTransferMessage extends BoxMessageWithLocalMetadata<BoxFile> {
    public static final String ACTION_CANCELLED_TRANSFER = "com.box.android.cancelledTransfer";
    public static final String ACTION_DISMISSED_TRANSFER = "com.box.android.dismissedTransfer";
    public static final String ARG_TRANSFER_SOURCE = "com.box.android.arg.transferSource";
    public static final String ARG_TRANSFER_TYPE = "com.box.android.arg.transferType";
    private static final String BYTES_TRANSFERRED = "com.box.android.boxfiletransfermessage.bytestransferred";
    private static final String DESTINATION_FOLDER_ID = "com.box.android.boxfiletransfermessage.destinationFolderId";
    private static final String FILE_NAME = "com.box.android.boxfiletransfermessage.fileName";
    private static final String FILE_SIZE = "com.box.android.boxfiletransfermessage.FileSize";
    private static final String IN_PROGRESS_ACTION = "com.box.android.boxfiletransfermessage.inProgressAction";
    private static final String JAVA_FILE = "com.box.android.boxfiletransfermessage.javafile";
    private static final String REQUIRES_WIFI = "com.box.android.boxfiletransfermessage.requiresWifi";

    public BoxFileTransferMessage(String str, String str2) {
        this(str);
        setInProgressAction(str2);
    }

    public BoxFileTransferMessage(String str) {
        setAction(str);
    }

    public BoxFileTransferMessage() {
    }

    public void initFromBoxFile(BoxFile boxFile) {
        setFileId(boxFile.getId());
        setFileSize(boxFile.getSize().longValue());
        setFileName(boxFile.getName());
        if (boxFile.getParent() != null) {
            setParentFolderId(boxFile.getParent().getId());
        }
    }

    public void setParentFolderId(String str) {
        putExtra(DESTINATION_FOLDER_ID, str);
    }

    public String getParentFolderId() {
        return getStringExtra(DESTINATION_FOLDER_ID);
    }

    public void setBoxDownload(BoxDownload boxDownload) {
        setFileName(boxDownload.getFileName());
        setFileSize(boxDownload.getContentLength().longValue());
        setJavaFilePayload(boxDownload.getOutputFile());
    }

    public void setFileId(String str) {
        setId(str);
    }

    public String getFileId() {
        return getId();
    }

    public double getFileSize() {
        return getDoubleExtra(FILE_SIZE, 0.0d);
    }

    public void setFileSize(double d) {
        putExtra(FILE_SIZE, d);
    }

    public Long getBytesTransferred() {
        return Long.valueOf(getLongExtra(BYTES_TRANSFERRED, -1L));
    }

    public void setBytesTransferred(long j) {
        putExtra(BYTES_TRANSFERRED, j);
    }

    public void setJavaFilePayload(File file) {
        putExtra(JAVA_FILE, file);
    }

    public File getJavaFilePayload() {
        return (File) getSerializableExtra(JAVA_FILE);
    }

    public void setFileName(String str) {
        putExtra(FILE_NAME, str);
    }

    public String getFileName() {
        return getStringExtra(FILE_NAME);
    }

    public IMoCoBoxTransfers.TransferSourceType getTransferSource() {
        return IMoCoBoxTransfers.TransferSourceType.values()[getIntExtra(ARG_TRANSFER_SOURCE, 0)];
    }

    public void setTransferSource(IMoCoBoxTransfers.TransferSourceType transferSourceType) {
        putExtra(ARG_TRANSFER_SOURCE, transferSourceType.ordinal());
    }

    public void setRequiresWifi(boolean z) {
        putExtra(REQUIRES_WIFI, z);
    }

    public boolean requiresWifi() {
        return getBooleanExtra(REQUIRES_WIFI, false);
    }

    public void setInProgressAction(String str) {
        putExtra(IN_PROGRESS_ACTION, str);
    }

    private String getInProgressAction() {
        return getStringExtra(IN_PROGRESS_ACTION);
    }

    public BoxFileTransferMessage getInProgressMessage() {
        try {
            BoxFileTransferMessage boxFileTransferMessage = (BoxFileTransferMessage) getClass().newInstance();
            boxFileTransferMessage.setAction(getAction());
            boxFileTransferMessage.setData(getData());
            boxFileTransferMessage.setType(getType());
            boxFileTransferMessage.setPackage(getPackage());
            boxFileTransferMessage.setComponent(getComponent());
            boxFileTransferMessage.setFlags(getFlags());
            if (getExtras() != null) {
                boxFileTransferMessage.putExtras(new Bundle(getExtras()));
            }
            boxFileTransferMessage.setAction(getInProgressAction());
            return boxFileTransferMessage;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
