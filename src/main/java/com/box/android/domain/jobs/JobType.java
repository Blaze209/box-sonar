package com.box.android.domain.jobs;

import kotlin.Metadata;

/* JADX INFO: compiled from: JobType.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/jobs/JobType;", "", "<init>", "()V", "UPLOAD_FILE_V2", "", "UPLOAD_FOLDER_V2", "CREATE_FOLDER", "DELETE_FILE", "COPY_FILE", "MOVE_FILE", "DOWNLOAD_FILE_LEGACY", "OFFLINE_FILE", "CHUNK_UPLOAD", "DOWNLOAD_FILE", "CHUNK_DOWNLOAD_JOB", "REMOVE_OFFLINE_JOB", "DELETE_COLLABORATION", "MOVE_ITEM", "COPY_ITEM", "DOWNLOAD_FOLDER", "AUTO_UPLOAD", "MARK_FOR_OFFLINE", "MARK_FOR_OFFLINE_FOLDER", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobType {
    public static final String AUTO_UPLOAD = "AutoUploadJob";
    public static final String CHUNK_DOWNLOAD_JOB = "ChunkDownloadJob";
    public static final String CHUNK_UPLOAD = "ChunkUploadJob";
    public static final String COPY_FILE = "CopyFileJob";
    public static final String COPY_ITEM = "CopyItem";
    public static final String CREATE_FOLDER = "create_folder";
    public static final String DELETE_COLLABORATION = "DeleteCollaboration";
    public static final String DELETE_FILE = "DeleteFileJob";
    public static final String DOWNLOAD_FILE = "DownloadFileJob";
    public static final String DOWNLOAD_FILE_LEGACY = "ExportBoxJob";
    public static final String DOWNLOAD_FOLDER = "DownloadFolder";
    public static final JobType INSTANCE = new JobType();
    public static final String MARK_FOR_OFFLINE = "MarkForOffline";
    public static final String MARK_FOR_OFFLINE_FOLDER = "MarkForOfflineFolder";
    public static final String MOVE_FILE = "MoveFileJob";
    public static final String MOVE_ITEM = "MoveItem";
    public static final String OFFLINE_FILE = "OfflineBoxJob";
    public static final String REMOVE_OFFLINE_JOB = "RemoveOfflineJob";
    public static final String UPLOAD_FILE_V2 = "UploadFileJobV2";
    public static final String UPLOAD_FOLDER_V2 = "UploadFolderJob";

    private JobType() {
    }
}
