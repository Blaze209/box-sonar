package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobFactory.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001By\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/box/android/data/jobs/JobFactory;", "", "createFolderJobFactory", "Lcom/box/android/data/jobs/CreateFolderJob$Factory;", "uploadFileJobV2Factory", "Lcom/box/android/data/jobs/UploadFileJobV2$Factory;", "deleteFileJobFactory", "Lcom/box/android/data/jobs/DeleteFileJob$Factory;", "chunkUploadJobFactory", "Lcom/box/android/data/jobs/ChunkUploadJob$Factory;", "downloadFileJobFactory", "Lcom/box/android/data/jobs/DownloadFileJob$Factory;", "chunkDownloadJobFactory", "Lcom/box/android/data/jobs/DownloadChunkJob$Factory;", "deleteCollaborationJobFactory", "Lcom/box/android/data/jobs/DeleteCollaborationJob$Factory;", "downloadFolderJobFactory", "Lcom/box/android/data/jobs/DownloadFolderJob$Factory;", "uploadFolderJobFactory", "Lcom/box/android/data/jobs/UploadFolderJob$Factory;", "moveItemJobFactory", "Lcom/box/android/data/jobs/MoveItemJob$Factory;", "copyItemJobFactory", "Lcom/box/android/data/jobs/CopyItemJob$Factory;", "autoUploadJobFactory", "Lcom/box/android/data/jobs/AutoUploadJob$Factory;", "markOfflineJobFactory", "Lcom/box/android/data/jobs/MarkForOfflineJob$Factory;", "markOfflineFolderJobFactory", "Lcom/box/android/data/jobs/MarkForOfflineFolderJob$Factory;", "<init>", "(Lcom/box/android/data/jobs/CreateFolderJob$Factory;Lcom/box/android/data/jobs/UploadFileJobV2$Factory;Lcom/box/android/data/jobs/DeleteFileJob$Factory;Lcom/box/android/data/jobs/ChunkUploadJob$Factory;Lcom/box/android/data/jobs/DownloadFileJob$Factory;Lcom/box/android/data/jobs/DownloadChunkJob$Factory;Lcom/box/android/data/jobs/DeleteCollaborationJob$Factory;Lcom/box/android/data/jobs/DownloadFolderJob$Factory;Lcom/box/android/data/jobs/UploadFolderJob$Factory;Lcom/box/android/data/jobs/MoveItemJob$Factory;Lcom/box/android/data/jobs/CopyItemJob$Factory;Lcom/box/android/data/jobs/AutoUploadJob$Factory;Lcom/box/android/data/jobs/MarkForOfflineJob$Factory;Lcom/box/android/data/jobs/MarkForOfflineFolderJob$Factory;)V", "createJob", "Lcom/box/android/data/jobs/Job;", "type", "", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobFactory {
    private final AutoUploadJob.Factory autoUploadJobFactory;
    private final DownloadChunkJob.Factory chunkDownloadJobFactory;
    private final ChunkUploadJob.Factory chunkUploadJobFactory;
    private final CopyItemJob.Factory copyItemJobFactory;
    private final CreateFolderJob.Factory createFolderJobFactory;
    private final DeleteCollaborationJob.Factory deleteCollaborationJobFactory;
    private final DeleteFileJob.Factory deleteFileJobFactory;
    private final DownloadFileJob.Factory downloadFileJobFactory;
    private final DownloadFolderJob.Factory downloadFolderJobFactory;
    private final MarkForOfflineFolderJob.Factory markOfflineFolderJobFactory;
    private final MarkForOfflineJob.Factory markOfflineJobFactory;
    private final MoveItemJob.Factory moveItemJobFactory;
    private final UploadFileJobV2.Factory uploadFileJobV2Factory;
    private final UploadFolderJob.Factory uploadFolderJobFactory;

    @Inject
    public JobFactory(CreateFolderJob.Factory createFolderJobFactory, UploadFileJobV2.Factory uploadFileJobV2Factory, DeleteFileJob.Factory deleteFileJobFactory, ChunkUploadJob.Factory chunkUploadJobFactory, DownloadFileJob.Factory downloadFileJobFactory, DownloadChunkJob.Factory chunkDownloadJobFactory, DeleteCollaborationJob.Factory deleteCollaborationJobFactory, DownloadFolderJob.Factory downloadFolderJobFactory, UploadFolderJob.Factory uploadFolderJobFactory, MoveItemJob.Factory moveItemJobFactory, CopyItemJob.Factory copyItemJobFactory, AutoUploadJob.Factory autoUploadJobFactory, MarkForOfflineJob.Factory markOfflineJobFactory, MarkForOfflineFolderJob.Factory markOfflineFolderJobFactory) {
        Intrinsics.checkNotNullParameter(createFolderJobFactory, "createFolderJobFactory");
        Intrinsics.checkNotNullParameter(uploadFileJobV2Factory, "uploadFileJobV2Factory");
        Intrinsics.checkNotNullParameter(deleteFileJobFactory, "deleteFileJobFactory");
        Intrinsics.checkNotNullParameter(chunkUploadJobFactory, "chunkUploadJobFactory");
        Intrinsics.checkNotNullParameter(downloadFileJobFactory, "downloadFileJobFactory");
        Intrinsics.checkNotNullParameter(chunkDownloadJobFactory, "chunkDownloadJobFactory");
        Intrinsics.checkNotNullParameter(deleteCollaborationJobFactory, "deleteCollaborationJobFactory");
        Intrinsics.checkNotNullParameter(downloadFolderJobFactory, "downloadFolderJobFactory");
        Intrinsics.checkNotNullParameter(uploadFolderJobFactory, "uploadFolderJobFactory");
        Intrinsics.checkNotNullParameter(moveItemJobFactory, "moveItemJobFactory");
        Intrinsics.checkNotNullParameter(copyItemJobFactory, "copyItemJobFactory");
        Intrinsics.checkNotNullParameter(autoUploadJobFactory, "autoUploadJobFactory");
        Intrinsics.checkNotNullParameter(markOfflineJobFactory, "markOfflineJobFactory");
        Intrinsics.checkNotNullParameter(markOfflineFolderJobFactory, "markOfflineFolderJobFactory");
        this.createFolderJobFactory = createFolderJobFactory;
        this.uploadFileJobV2Factory = uploadFileJobV2Factory;
        this.deleteFileJobFactory = deleteFileJobFactory;
        this.chunkUploadJobFactory = chunkUploadJobFactory;
        this.downloadFileJobFactory = downloadFileJobFactory;
        this.chunkDownloadJobFactory = chunkDownloadJobFactory;
        this.deleteCollaborationJobFactory = deleteCollaborationJobFactory;
        this.downloadFolderJobFactory = downloadFolderJobFactory;
        this.uploadFolderJobFactory = uploadFolderJobFactory;
        this.moveItemJobFactory = moveItemJobFactory;
        this.copyItemJobFactory = copyItemJobFactory;
        this.autoUploadJobFactory = autoUploadJobFactory;
        this.markOfflineJobFactory = markOfflineJobFactory;
        this.markOfflineFolderJobFactory = markOfflineFolderJobFactory;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Job createJob(String type, JobId jobId, Data inputData) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        switch (type.hashCode()) {
            case -1821171320:
                if (type.equals(JobType.CHUNK_DOWNLOAD_JOB)) {
                    return this.chunkDownloadJobFactory.createJob(jobId, inputData);
                }
                break;
            case -1688547876:
                if (type.equals(JobType.UPLOAD_FILE_V2)) {
                    return this.uploadFileJobV2Factory.createJob(jobId, inputData);
                }
                break;
            case -1456944423:
                if (type.equals(JobType.DOWNLOAD_FILE)) {
                    return this.downloadFileJobFactory.createJob(jobId, inputData);
                }
                break;
            case -734193866:
                if (type.equals(JobType.DOWNLOAD_FOLDER)) {
                    return this.downloadFolderJobFactory.createJob(jobId, inputData);
                }
                break;
            case -441630648:
                if (type.equals("CopyItem")) {
                    return this.copyItemJobFactory.createJob(jobId, inputData);
                }
                break;
            case -289892619:
                if (type.equals(JobType.MARK_FOR_OFFLINE_FOLDER)) {
                    return this.markOfflineFolderJobFactory.createJob(jobId, inputData);
                }
                break;
            case -260831146:
                if (type.equals(JobType.DELETE_FILE)) {
                    return this.deleteFileJobFactory.createJob(jobId, inputData);
                }
                break;
            case -40091996:
                if (type.equals("MoveItem")) {
                    return this.moveItemJobFactory.createJob(jobId, inputData);
                }
                break;
            case 174752590:
                if (type.equals(JobType.UPLOAD_FOLDER_V2)) {
                    return this.uploadFolderJobFactory.createJob(jobId, inputData);
                }
                break;
            case 943403245:
                if (type.equals(JobType.AUTO_UPLOAD)) {
                    return this.autoUploadJobFactory.createJob(jobId, inputData);
                }
                break;
            case 1422277178:
                if (type.equals(JobType.DELETE_COLLABORATION)) {
                    return this.deleteCollaborationJobFactory.createJob(jobId, inputData);
                }
                break;
            case 1459562407:
                if (type.equals(JobType.MARK_FOR_OFFLINE)) {
                    return this.markOfflineJobFactory.createJob(jobId, inputData);
                }
                break;
            case 1555758639:
                if (type.equals(JobType.CHUNK_UPLOAD)) {
                    return this.chunkUploadJobFactory.createJob(jobId, inputData);
                }
                break;
            case 2021369105:
                if (type.equals("create_folder")) {
                    return this.createFolderJobFactory.createJob(jobId, inputData);
                }
                break;
        }
        throw new IllegalArgumentException("JobType " + type + " was not recognized");
    }
}
