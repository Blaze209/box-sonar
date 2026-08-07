package com.box.android.data.persistence.jobs;

import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.DomainError;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\b\u0007\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u001e\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010%\"\u0004\b(\u0010)R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R \u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u00102R \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001bR\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001bR\u001e\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001d\"\u0004\b:\u0010;R\u001e\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001f\"\u0004\b=\u00102¨\u0006>"}, d2 = {"Lcom/box/android/data/persistence/jobs/JobEntity;", "", "id", "Lcom/box/android/domain/jobs/JobId;", "type", "", "inputData", "", "status", "Lcom/box/android/data/persistence/jobs/JobStatus;", "createdAt", "Ljava/util/Date;", "startDate", "earliestStartDate", "autoRetryCount", "", "manualRetryCount", "runningInfo", "errorInfo", "Lcom/box/android/domain/models/DomainError;", "parentID", "rootID", "sortKey", "logData", "<init>", "(Lcom/box/android/domain/jobs/JobId;Ljava/lang/String;[BLcom/box/android/data/persistence/jobs/JobStatus;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;II[BLcom/box/android/domain/models/DomainError;Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/jobs/JobId;Ljava/lang/String;[B)V", "getId", "()Lcom/box/android/domain/jobs/JobId;", "getType", "()Ljava/lang/String;", "getInputData", "()[B", "getStatus", "()Lcom/box/android/data/persistence/jobs/JobStatus;", "setStatus", "(Lcom/box/android/data/persistence/jobs/JobStatus;)V", "getCreatedAt", "()Ljava/util/Date;", "getStartDate", "getEarliestStartDate", "setEarliestStartDate", "(Ljava/util/Date;)V", "getAutoRetryCount", "()I", "setAutoRetryCount", "(I)V", "getManualRetryCount", "setManualRetryCount", "getRunningInfo", "setRunningInfo", "([B)V", "getErrorInfo", "()Lcom/box/android/domain/models/DomainError;", "setErrorInfo", "(Lcom/box/android/domain/models/DomainError;)V", "getParentID", "getRootID", "getSortKey", "setSortKey", "(Ljava/lang/String;)V", "getLogData", "setLogData", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobEntity {
    private int autoRetryCount;
    private final Date createdAt;
    private Date earliestStartDate;
    private DomainError errorInfo;
    private final JobId id;
    private final byte[] inputData;
    private byte[] logData;
    private int manualRetryCount;
    private final JobId parentID;
    private final JobId rootID;
    private byte[] runningInfo;
    private String sortKey;
    private final Date startDate;
    private JobStatus status;
    private final String type;

    public JobEntity(JobId id, String type, byte[] inputData, JobStatus status, Date createdAt, Date date, Date earliestStartDate, int i, int i2, byte[] bArr, DomainError domainError, JobId jobId, JobId rootID, String sortKey, byte[] logData) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(earliestStartDate, "earliestStartDate");
        Intrinsics.checkNotNullParameter(rootID, "rootID");
        Intrinsics.checkNotNullParameter(sortKey, "sortKey");
        Intrinsics.checkNotNullParameter(logData, "logData");
        this.id = id;
        this.type = type;
        this.inputData = inputData;
        this.status = status;
        this.createdAt = createdAt;
        this.startDate = date;
        this.earliestStartDate = earliestStartDate;
        this.autoRetryCount = i;
        this.manualRetryCount = i2;
        this.runningInfo = bArr;
        this.errorInfo = domainError;
        this.parentID = jobId;
        this.rootID = rootID;
        this.sortKey = sortKey;
        this.logData = logData;
    }

    public final JobId getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final byte[] getInputData() {
        return this.inputData;
    }

    public final JobStatus getStatus() {
        return this.status;
    }

    public final void setStatus(JobStatus jobStatus) {
        Intrinsics.checkNotNullParameter(jobStatus, "<set-?>");
        this.status = jobStatus;
    }

    public /* synthetic */ JobEntity(JobId jobId, String str, byte[] bArr, JobStatus jobStatus, Date date, Date date2, Date date3, int i, int i2, byte[] bArr2, DomainError domainError, JobId jobId2, JobId jobId3, String str2, byte[] bArr3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(jobId, str, bArr, jobStatus, (i3 & 16) != 0 ? new Date() : date, (i3 & 32) != 0 ? null : date2, (i3 & 64) != 0 ? new Date() : date3, (i3 & 128) != 0 ? 0 : i, (i3 & 256) != 0 ? 0 : i2, (i3 & 512) != 0 ? null : bArr2, (i3 & 1024) != 0 ? null : domainError, (i3 & 2048) != 0 ? null : jobId2, jobId3, str2, (i3 & 16384) != 0 ? Data.EMPTY.toByteArray() : bArr3);
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getStartDate() {
        return this.startDate;
    }

    public final Date getEarliestStartDate() {
        return this.earliestStartDate;
    }

    public final void setEarliestStartDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.earliestStartDate = date;
    }

    public final int getAutoRetryCount() {
        return this.autoRetryCount;
    }

    public final void setAutoRetryCount(int i) {
        this.autoRetryCount = i;
    }

    public final int getManualRetryCount() {
        return this.manualRetryCount;
    }

    public final void setManualRetryCount(int i) {
        this.manualRetryCount = i;
    }

    public final byte[] getRunningInfo() {
        return this.runningInfo;
    }

    public final void setRunningInfo(byte[] bArr) {
        this.runningInfo = bArr;
    }

    public final DomainError getErrorInfo() {
        return this.errorInfo;
    }

    public final void setErrorInfo(DomainError domainError) {
        this.errorInfo = domainError;
    }

    public final JobId getParentID() {
        return this.parentID;
    }

    public final JobId getRootID() {
        return this.rootID;
    }

    public final String getSortKey() {
        return this.sortKey;
    }

    public final void setSortKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sortKey = str;
    }

    public final byte[] getLogData() {
        return this.logData;
    }

    public final void setLogData(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.logData = bArr;
    }
}
