package com.box.android.domain.jobs;

import androidx.work.Data;
import com.box.android.data.jobs.JobWorker;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Date;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\f\u0010\rJ\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bJ\u0006\u0010\u0019\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/box/android/domain/jobs/JobRequest;", "", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "jobType", "", "earliestJobStartTime", "Ljava/util/Date;", "inputData", "Landroidx/work/Data;", "jobTags", "", "<init>", "(Lcom/box/android/domain/jobs/JobId;Ljava/lang/String;Ljava/util/Date;Landroidx/work/Data;Ljava/util/Set;)V", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getJobType", "()Ljava/lang/String;", "getEarliestJobStartTime", "()Ljava/util/Date;", "getInputData", "()Landroidx/work/Data;", "getJobTags", "()Ljava/util/Set;", "getTags", JobConstants.SHOW_NOTIFICATION, "", "Builder", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobRequest {
    private final Date earliestJobStartTime;
    private final Data inputData;
    private final JobId jobId;
    private final Set<String> jobTags;
    private final String jobType;

    public /* synthetic */ JobRequest(JobId jobId, String str, Date date, Data data, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        this(jobId, str, date, data, set);
    }

    private JobRequest(JobId jobId, String str, Date date, Data data, Set<String> set) {
        this.jobId = jobId;
        this.jobType = str;
        this.earliestJobStartTime = date;
        this.inputData = data;
        this.jobTags = set;
    }

    public final JobId getJobId() {
        return this.jobId;
    }

    public final String getJobType() {
        return this.jobType;
    }

    public final Date getEarliestJobStartTime() {
        return this.earliestJobStartTime;
    }

    public final Data getInputData() {
        return this.inputData;
    }

    public final Set<String> getJobTags() {
        return this.jobTags;
    }

    public final Set<String> getTags() {
        return this.jobTags;
    }

    /* JADX INFO: compiled from: JobRequest.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\tJ\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J7\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00061"}, d2 = {"Lcom/box/android/domain/jobs/JobRequest$Builder;", "", "jobType", "", "jobTags", "", "earliestJobStartTime", "Ljava/util/Date;", "inputData", "Landroidx/work/Data;", "<init>", "(Ljava/lang/String;Ljava/util/Set;Ljava/util/Date;Landroidx/work/Data;)V", "getJobType", "()Ljava/lang/String;", "getJobTags", "()Ljava/util/Set;", "setJobTags", "(Ljava/util/Set;)V", "getEarliestJobStartTime", "()Ljava/util/Date;", "setEarliestJobStartTime", "(Ljava/util/Date;)V", "getInputData", "()Landroidx/work/Data;", "setInputData", "(Landroidx/work/Data;)V", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "setTags", "", "setData", "data", "setEarliestStartTime", "startTime", "build", "Lcom/box/android/domain/jobs/JobRequest;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Builder {
        private Date earliestJobStartTime;
        private Data inputData;
        private final JobId jobId;
        private Set<String> jobTags;
        private final String jobType;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder copy$default(Builder builder, String str, Set set, Date date, Data data, int i, Object obj) {
            if ((i & 1) != 0) {
                str = builder.jobType;
            }
            if ((i & 2) != 0) {
                set = builder.jobTags;
            }
            if ((i & 4) != 0) {
                date = builder.earliestJobStartTime;
            }
            if ((i & 8) != 0) {
                data = builder.inputData;
            }
            return builder.copy(str, set, date, data);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getJobType() {
            return this.jobType;
        }

        public final Set<String> component2() {
            return this.jobTags;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Date getEarliestJobStartTime() {
            return this.earliestJobStartTime;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Data getInputData() {
            return this.inputData;
        }

        public final Builder copy(String jobType, Set<String> jobTags, Date earliestJobStartTime, Data inputData) {
            Intrinsics.checkNotNullParameter(jobType, "jobType");
            Intrinsics.checkNotNullParameter(jobTags, "jobTags");
            Intrinsics.checkNotNullParameter(earliestJobStartTime, "earliestJobStartTime");
            Intrinsics.checkNotNullParameter(inputData, "inputData");
            return new Builder(jobType, jobTags, earliestJobStartTime, inputData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) other;
            return Intrinsics.areEqual(this.jobType, builder.jobType) && Intrinsics.areEqual(this.jobTags, builder.jobTags) && Intrinsics.areEqual(this.earliestJobStartTime, builder.earliestJobStartTime) && Intrinsics.areEqual(this.inputData, builder.inputData);
        }

        public int hashCode() {
            return (((((this.jobType.hashCode() * 31) + this.jobTags.hashCode()) * 31) + this.earliestJobStartTime.hashCode()) * 31) + this.inputData.hashCode();
        }

        public String toString() {
            return "Builder(jobType=" + this.jobType + ", jobTags=" + this.jobTags + ", earliestJobStartTime=" + this.earliestJobStartTime + ", inputData=" + this.inputData + ")";
        }

        public Builder(String jobType, Set<String> jobTags, Date earliestJobStartTime, Data inputData) {
            Intrinsics.checkNotNullParameter(jobType, "jobType");
            Intrinsics.checkNotNullParameter(jobTags, "jobTags");
            Intrinsics.checkNotNullParameter(earliestJobStartTime, "earliestJobStartTime");
            Intrinsics.checkNotNullParameter(inputData, "inputData");
            this.jobType = jobType;
            this.jobTags = jobTags;
            this.earliestJobStartTime = earliestJobStartTime;
            this.inputData = inputData;
            this.jobId = new JobId(null, 1, null);
        }

        public final String getJobType() {
            return this.jobType;
        }

        public /* synthetic */ Builder(String str, Set set, Date date, Data data, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? SetsKt.emptySet() : set, (i & 4) != 0 ? new Date() : date, (i & 8) != 0 ? Data.EMPTY : data);
        }

        public final Set<String> getJobTags() {
            return this.jobTags;
        }

        public final void setJobTags(Set<String> set) {
            Intrinsics.checkNotNullParameter(set, "<set-?>");
            this.jobTags = set;
        }

        public final Date getEarliestJobStartTime() {
            return this.earliestJobStartTime;
        }

        public final void setEarliestJobStartTime(Date date) {
            Intrinsics.checkNotNullParameter(date, "<set-?>");
            this.earliestJobStartTime = date;
        }

        public final Data getInputData() {
            return this.inputData;
        }

        public final void setInputData(Data data) {
            Intrinsics.checkNotNullParameter(data, "<set-?>");
            this.inputData = data;
        }

        public final JobId getJobId() {
            return this.jobId;
        }

        public final void setTags(Set<String> jobTags) {
            Intrinsics.checkNotNullParameter(jobTags, "jobTags");
            this.jobTags = jobTags;
        }

        public final void setData(Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.inputData = data;
        }

        public final void setEarliestStartTime(Date startTime) {
            Intrinsics.checkNotNullParameter(startTime, "startTime");
            this.earliestJobStartTime = startTime;
        }

        public final JobRequest build() {
            return new JobRequest(this.jobId, this.jobType, this.earliestJobStartTime, this.inputData, this.jobTags, null);
        }
    }

    public final boolean showNotification() {
        return this.inputData.getBoolean(JobConstants.SHOW_NOTIFICATION, false);
    }
}
