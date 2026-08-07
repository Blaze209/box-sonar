package com.box.android.domain.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LegacyJobModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/LegacyJobModel;", "Lcom/box/android/domain/models/DomainModel;", "itemDescriptor", "Lcom/box/android/domain/models/ItemDescriptor;", "jobInfo", "Lcom/box/android/domain/models/JobInfo;", "<init>", "(Lcom/box/android/domain/models/ItemDescriptor;Lcom/box/android/domain/models/JobInfo;)V", "getItemDescriptor", "()Lcom/box/android/domain/models/ItemDescriptor;", "getJobInfo", "()Lcom/box/android/domain/models/JobInfo;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LegacyJobModel implements DomainModel {
    private final ItemDescriptor itemDescriptor;
    private final JobInfo jobInfo;

    public static /* synthetic */ LegacyJobModel copy$default(LegacyJobModel legacyJobModel, ItemDescriptor itemDescriptor, JobInfo jobInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            itemDescriptor = legacyJobModel.itemDescriptor;
        }
        if ((i & 2) != 0) {
            jobInfo = legacyJobModel.jobInfo;
        }
        return legacyJobModel.copy(itemDescriptor, jobInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ItemDescriptor getItemDescriptor() {
        return this.itemDescriptor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final JobInfo getJobInfo() {
        return this.jobInfo;
    }

    public final LegacyJobModel copy(ItemDescriptor itemDescriptor, JobInfo jobInfo) {
        Intrinsics.checkNotNullParameter(itemDescriptor, "itemDescriptor");
        Intrinsics.checkNotNullParameter(jobInfo, "jobInfo");
        return new LegacyJobModel(itemDescriptor, jobInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LegacyJobModel)) {
            return false;
        }
        LegacyJobModel legacyJobModel = (LegacyJobModel) other;
        return Intrinsics.areEqual(this.itemDescriptor, legacyJobModel.itemDescriptor) && Intrinsics.areEqual(this.jobInfo, legacyJobModel.jobInfo);
    }

    public int hashCode() {
        return (this.itemDescriptor.hashCode() * 31) + this.jobInfo.hashCode();
    }

    public String toString() {
        return "LegacyJobModel(itemDescriptor=" + this.itemDescriptor + ", jobInfo=" + this.jobInfo + ")";
    }

    public LegacyJobModel(ItemDescriptor itemDescriptor, JobInfo jobInfo) {
        Intrinsics.checkNotNullParameter(itemDescriptor, "itemDescriptor");
        Intrinsics.checkNotNullParameter(jobInfo, "jobInfo");
        this.itemDescriptor = itemDescriptor;
        this.jobInfo = jobInfo;
    }

    public final ItemDescriptor getItemDescriptor() {
        return this.itemDescriptor;
    }

    public final JobInfo getJobInfo() {
        return this.jobInfo;
    }
}
