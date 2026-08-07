package com.box.android.domain.metrics;

import androidx.work.Data;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.ErrorRecoveryType;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.MetricKeysParam;
import com.box.android.domain.models.observability.JobManagerVersion;
import com.box.android.domain.models.observability.MoveCopyEvent;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204JobServiceHelper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ<\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018JZ\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0002J4\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J4\u0010#\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/box/android/domain/metrics/Gen204JobServiceHelper;", "", "gen204UploadEventLogger", "Lcom/box/android/domain/metrics/Gen204UploadEventLogger;", "gen204DownloadEventLogger", "Lcom/box/android/domain/metrics/Gen204DownloadEventLogger;", "gen204MoveCopyEventLogger", "Lcom/box/android/domain/metrics/Gen204MoveCopyEventLogger;", "gen204OfflineEventLogger", "Lcom/box/android/domain/metrics/Gen204OfflineEventLogger;", "<init>", "(Lcom/box/android/domain/metrics/Gen204UploadEventLogger;Lcom/box/android/domain/metrics/Gen204DownloadEventLogger;Lcom/box/android/domain/metrics/Gen204MoveCopyEventLogger;Lcom/box/android/domain/metrics/Gen204OfflineEventLogger;)V", "log", "", "jobType", "", "numberOfAutoRetries", "", "numberOfManualRetries", "logData", "Landroidx/work/Data;", "isAutoRetrying", "", "domainError", "Lcom/box/android/domain/models/DomainError;", "logForDownload", "fileId", "size", "", "startedTime", "ttuSinceStarted", "itemState", "logForMarkForOfflineFile", "itemId", "Lcom/box/android/domain/models/ItemId;", "logForMarkForOfflineFolder", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Gen204JobServiceHelper {
    private final Gen204DownloadEventLogger gen204DownloadEventLogger;
    private final Gen204MoveCopyEventLogger gen204MoveCopyEventLogger;
    private final Gen204OfflineEventLogger gen204OfflineEventLogger;
    private final Gen204UploadEventLogger gen204UploadEventLogger;

    @Inject
    public Gen204JobServiceHelper(Gen204UploadEventLogger gen204UploadEventLogger, Gen204DownloadEventLogger gen204DownloadEventLogger, Gen204MoveCopyEventLogger gen204MoveCopyEventLogger, Gen204OfflineEventLogger gen204OfflineEventLogger) {
        Intrinsics.checkNotNullParameter(gen204UploadEventLogger, "gen204UploadEventLogger");
        Intrinsics.checkNotNullParameter(gen204DownloadEventLogger, "gen204DownloadEventLogger");
        Intrinsics.checkNotNullParameter(gen204MoveCopyEventLogger, "gen204MoveCopyEventLogger");
        Intrinsics.checkNotNullParameter(gen204OfflineEventLogger, "gen204OfflineEventLogger");
        this.gen204UploadEventLogger = gen204UploadEventLogger;
        this.gen204DownloadEventLogger = gen204DownloadEventLogger;
        this.gen204MoveCopyEventLogger = gen204MoveCopyEventLogger;
        this.gen204OfflineEventLogger = gen204OfflineEventLogger;
    }

    public static /* synthetic */ void log$default(Gen204JobServiceHelper gen204JobServiceHelper, String str, int i, int i2, Data data, boolean z, DomainError domainError, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i3 & 32) != 0) {
            domainError = null;
        }
        gen204JobServiceHelper.log(str, i, i2, data, z2, domainError);
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0168  */
    /* JADX WARN: Code duplicated, block: B:73:0x016b  */
    public final void log(String jobType, int numberOfAutoRetries, int numberOfManualRetries, Data logData, boolean isAutoRetrying, DomainError domainError) {
        Data data;
        ItemId.Remote remote;
        boolean z;
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(logData, "logData");
        if (isAutoRetrying) {
            if ((domainError != null ? domainError.getErrorType() : null) != ErrorRecoveryType.AUTOMATIC) {
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Auto retrying but domain error recovery is not automatic");
            }
        }
        long time = new Date().getTime();
        String string = logData.getString(MetricKeysParam.METRIC_FILE_ID);
        ItemId itemIdCreate = string != null ? ItemId.INSTANCE.create(string) : null;
        String string2 = logData.getString(MetricKeysParam.METRIC_FOLDER_ID);
        if (string2 == null) {
            string2 = "";
        }
        long j = logData.getLong(MetricKeysParam.METRIC_TIME_ENQUEUED, time);
        long j2 = logData.getLong(MetricKeysParam.METRIC_TIME_STARTED, time);
        long j3 = time - j;
        long j4 = time - j2;
        switch (jobType.hashCode()) {
            case -1688547876:
                data = logData;
                this = this;
                if (!jobType.equals(JobType.UPLOAD_FILE_V2)) {
                }
                long j5 = data.getLong(MetricKeysParam.METRIC_FILE_SIZE, -2L);
                long j6 = data.getLong(MetricKeysParam.METRIC_BYTES_PROCESSED, -2L);
                if (data.getString(MetricKeysParam.METRIC_OVERWRITE_FILE_ID) != null) {
                    z = true;
                } else {
                    z = false;
                }
                this.gen204UploadEventLogger.logV2(jobType, itemIdCreate, string2, numberOfAutoRetries, numberOfManualRetries, j5, j6, j3, j4, isAutoRetrying, domainError, z, data.getBoolean(MetricKeysParam.METRIC_IS_USER_TRIGGERED_JOB, true));
                break;
            case -1456944423:
                if (jobType.equals(JobType.DOWNLOAD_FILE)) {
                    logForDownload(String.valueOf(itemIdCreate), logData.getLong(MetricKeysParam.METRIC_FILE_SIZE, 0L), j2, j4, numberOfAutoRetries, numberOfManualRetries, isAutoRetrying, domainError, logData.getString(MetricKeysParam.METRIC_ITEM_STATE));
                    break;
                }
                break;
            case -441630648:
                if (jobType.equals("CopyItem")) {
                    remote = itemIdCreate instanceof ItemId.Remote ? (ItemId.Remote) itemIdCreate : null;
                    if (remote != null) {
                        if (domainError == null) {
                            this.gen204MoveCopyEventLogger.success(MoveCopyEvent.EventType.Copy, remote, JobManagerVersion.V2);
                        } else {
                            this.gen204MoveCopyEventLogger.failure(MoveCopyEvent.EventType.Copy, remote, JobManagerVersion.V2, domainError.getSimpleClassName());
                        }
                    }
                    break;
                }
                break;
            case -289892619:
                if (jobType.equals(JobType.MARK_FOR_OFFLINE_FOLDER)) {
                    logForMarkForOfflineFolder(itemIdCreate, logData, numberOfAutoRetries, numberOfManualRetries, domainError);
                    break;
                }
                break;
            case -40091996:
                if (jobType.equals("MoveItem")) {
                    remote = itemIdCreate instanceof ItemId.Remote ? (ItemId.Remote) itemIdCreate : null;
                    if (remote != null) {
                        if (domainError == null) {
                            this.gen204MoveCopyEventLogger.success(MoveCopyEvent.EventType.Move, remote, JobManagerVersion.V2);
                        } else {
                            this.gen204MoveCopyEventLogger.failure(MoveCopyEvent.EventType.Move, remote, JobManagerVersion.V2, domainError.getSimpleClassName());
                        }
                    }
                    break;
                }
                break;
            case 174752590:
                if (!jobType.equals(JobType.UPLOAD_FOLDER_V2)) {
                }
                data = logData;
                long j7 = data.getLong(MetricKeysParam.METRIC_FILE_SIZE, -2L);
                long j8 = data.getLong(MetricKeysParam.METRIC_BYTES_PROCESSED, -2L);
                if (data.getString(MetricKeysParam.METRIC_OVERWRITE_FILE_ID) != null) {
                    z = true;
                } else {
                    z = false;
                }
                this.gen204UploadEventLogger.logV2(jobType, itemIdCreate, string2, numberOfAutoRetries, numberOfManualRetries, j7, j8, j3, j4, isAutoRetrying, domainError, z, data.getBoolean(MetricKeysParam.METRIC_IS_USER_TRIGGERED_JOB, true));
                break;
            case 943403245:
                if (!jobType.equals(JobType.AUTO_UPLOAD)) {
                }
                data = logData;
                long j9 = data.getLong(MetricKeysParam.METRIC_FILE_SIZE, -2L);
                long j10 = data.getLong(MetricKeysParam.METRIC_BYTES_PROCESSED, -2L);
                if (data.getString(MetricKeysParam.METRIC_OVERWRITE_FILE_ID) != null) {
                    z = true;
                } else {
                    z = false;
                }
                this.gen204UploadEventLogger.logV2(jobType, itemIdCreate, string2, numberOfAutoRetries, numberOfManualRetries, j9, j10, j3, j4, isAutoRetrying, domainError, z, data.getBoolean(MetricKeysParam.METRIC_IS_USER_TRIGGERED_JOB, true));
                break;
            case 1459562407:
                if (jobType.equals(JobType.MARK_FOR_OFFLINE)) {
                    logForMarkForOfflineFile(itemIdCreate, logData, numberOfAutoRetries, numberOfManualRetries, domainError);
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logForDownload(String fileId, long size, long startedTime, long ttuSinceStarted, int numberOfAutoRetries, int numberOfManualRetries, boolean isAutoRetrying, DomainError domainError, String itemState) {
        if (domainError == null) {
            this.gen204DownloadEventLogger.success(fileId, numberOfAutoRetries, numberOfManualRetries, size, Long.valueOf(startedTime), Long.valueOf(ttuSinceStarted), itemState);
        } else {
            this.gen204DownloadEventLogger.failure(fileId, numberOfAutoRetries, numberOfManualRetries, size, isAutoRetrying, DomainErrorKt.loggingMessage(domainError), Long.valueOf(startedTime), Long.valueOf(ttuSinceStarted), itemState);
        }
    }

    private final void logForMarkForOfflineFile(ItemId itemId, Data logData, int numberOfAutoRetries, int numberOfManualRetries, DomainError domainError) {
        ItemId.Remote remote = itemId instanceof ItemId.Remote ? (ItemId.Remote) itemId : null;
        if (remote != null) {
            String string = logData.getString("downloadOriginalStatus");
            String string2 = logData.getString("downloadPreviewStatus");
            String string3 = logData.getString(MetricKeysParam.METRIC_ITEM_STATE);
            if (domainError == null) {
                this.gen204OfflineEventLogger.fileSuccess(remote, string, string2, numberOfAutoRetries, numberOfManualRetries, string3);
            } else {
                this.gen204OfflineEventLogger.fileFailure(remote, DomainErrorKt.loggingMessage(domainError), string, string2, numberOfAutoRetries, numberOfManualRetries, string3);
            }
        }
    }

    private final void logForMarkForOfflineFolder(ItemId itemId, Data logData, int numberOfAutoRetries, int numberOfManualRetries, DomainError domainError) {
        ItemId.Remote remote = itemId instanceof ItemId.Remote ? (ItemId.Remote) itemId : null;
        if (remote != null) {
            int i = logData.getInt("totalFiles", 0);
            int i2 = logData.getInt("succeededFiles", 0);
            int i3 = logData.getInt("failedFiles", 0);
            if (domainError == null) {
                this.gen204OfflineEventLogger.folderSuccess(remote, i, i2, numberOfAutoRetries, numberOfManualRetries);
            } else {
                this.gen204OfflineEventLogger.folderFailure(remote, i, i2, i3, numberOfAutoRetries, numberOfManualRetries, DomainErrorKt.loggingMessage(domainError));
            }
        }
    }
}
