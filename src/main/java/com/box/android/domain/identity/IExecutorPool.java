package com.box.android.domain.identity;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes11.dex */
public interface IExecutorPool extends IUserContextComponent {
    public static final int MAX_CONCURRENT_DOWNLOADS = 2;
    public static final int MAX_DOWNLOAD_QUEUE_SIZE = 10000;
    public static final int QUEUE_TIMEOUT = 600;

    ThreadPoolExecutor getApiExecutor();

    ThreadPoolExecutor getAudioRecordingCallbackExecutor();

    ThreadPoolExecutor getDocumentProviderThumbnailExecutor();

    ThreadPoolExecutor getFileTransferServiceExecutor();

    ThreadPoolExecutor getLocalModelExecutor();

    ThreadPoolExecutor getNotificationExecutor();

    ThreadPoolExecutor getOfflinePreviewExecutor();

    ThreadPoolExecutor getOfflineStatusExecutor();

    PreviewExecutor getPreviewExecutor();

    ThreadPoolExecutor getPriorityJobManagerExecutor();

    ThreadPoolExecutor getSyncExecutor();

    ThreadPoolExecutor getThumbnailsExecutor();

    @Override // com.box.android.domain.identity.IUserContextComponent
    void onHardDestroy();

    @Override // com.box.android.domain.identity.IUserContextComponent
    void onSoftDestroy();
}
