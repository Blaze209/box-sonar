package com.box.android.coreservices.modelcontroller;

import androidx.documentfile.provider.DocumentFile;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.dao.UploadModelBoxFile;
import com.box.android.coreservices.modelcontroller.messages.BoxDownloadFileMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxFileTransferMessage;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxApiFile;
import com.box.androidsdk.content.BoxExtendedApiPreview;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxUploadSession;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes9.dex */
public interface IMoCoBoxTransfers {
    public static final String UPLOADS_TAG = "Uploads";

    public interface FileDestinationListener {
        void onFileKnown(File file);
    }

    public enum TransferSourceType {
        DEFAULT,
        AUTO_CONTENT_UPLOAD,
        DOCUMENT_PROVIDER,
        FILE_CREATE
    }

    BoxTransferFutureTask<BoxDownloadFileMessage> exportFile(String str, File file, boolean z, boolean z2, ProgressReporter.FileTransferProgressListener fileTransferProgressListener, FileDestinationListener fileDestinationListener);

    BoxTransferFutureTask<BoxDownloadFileMessage> exportFile(String str, File file, boolean z, boolean z2, ProgressReporter.FileTransferProgressListener fileTransferProgressListener, FileDestinationListener fileDestinationListener, BoxApiFile boxApiFile);

    DocumentFile getContentProviderDocumentFile(File file, boolean z) throws FileNotFoundException;

    OutputStream getContentProviderOutputStream(File file) throws FileNotFoundException;

    BoxTransferFutureTask<BoxDownloadFileMessage> makeWorkingFile(BoxFile boxFile, ProgressReporter.FileTransferProgressListener fileTransferProgressListener);

    BoxTransferFutureTask<BoxFileTransferMessage> saveFileForOffline(String str, IUserContextManager iUserContextManager, ProgressReporter.FileTransferProgressListener fileTransferProgressListener);

    BoxTransferFutureTask<BoxFileTransferMessage> saveFileForOffline(String str, IUserContextManager iUserContextManager, ProgressReporter.FileTransferProgressListener fileTransferProgressListener, BoxApiFile boxApiFile);

    BoxTransferFutureTask<BoxFileTransferMessage> savePreviewForOffline(String str, IUserContextManager iUserContextManager, ProgressReporter.FileTransferProgressListener fileTransferProgressListener);

    BoxTransferFutureTask<BoxFileTransferMessage> savePreviewForOffline(String str, IUserContextManager iUserContextManager, ProgressReporter.FileTransferProgressListener fileTransferProgressListener, BoxExtendedApiPreview boxExtendedApiPreview);

    BoxTransferFutureTask<BoxFileTransferMessage> uploadFile(String str, String str2, UploadModelBoxFile.UriFile uriFile, boolean z, TransferSourceType transferSourceType, ProgressReporter.FileTransferProgressListener fileTransferProgressListener, BoxExtendedApiFile boxExtendedApiFile, BoxUploadSession boxUploadSession, int i, long j);

    BoxTransferFutureTask<BoxFileTransferMessage> uploadFileNewVersion(BoxFile boxFile, String str, UploadModelBoxFile.UriFile uriFile, boolean z, boolean z2, TransferSourceType transferSourceType, ProgressReporter.FileTransferProgressListener fileTransferProgressListener, BoxExtendedApiFile boxExtendedApiFile, BoxUploadSession boxUploadSession, int i, long j);
}
