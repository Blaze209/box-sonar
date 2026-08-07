package com.box.android.base.presentation.components.commentbar;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimestampUtil.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/TimestampProcessingResult;", "", "processedText", "", "timestampDataList", "", "Lcom/box/android/base/presentation/components/commentbar/TimestampData;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getProcessedText", "()Ljava/lang/String;", "getTimestampDataList", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TimestampProcessingResult {
    public static final int $stable = 8;
    private final String processedText;
    private final List<TimestampData> timestampDataList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimestampProcessingResult copy$default(TimestampProcessingResult timestampProcessingResult, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timestampProcessingResult.processedText;
        }
        if ((i & 2) != 0) {
            list = timestampProcessingResult.timestampDataList;
        }
        return timestampProcessingResult.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProcessedText() {
        return this.processedText;
    }

    public final List<TimestampData> component2() {
        return this.timestampDataList;
    }

    public final TimestampProcessingResult copy(String processedText, List<TimestampData> timestampDataList) {
        Intrinsics.checkNotNullParameter(processedText, "processedText");
        Intrinsics.checkNotNullParameter(timestampDataList, "timestampDataList");
        return new TimestampProcessingResult(processedText, timestampDataList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimestampProcessingResult)) {
            return false;
        }
        TimestampProcessingResult timestampProcessingResult = (TimestampProcessingResult) other;
        return Intrinsics.areEqual(this.processedText, timestampProcessingResult.processedText) && Intrinsics.areEqual(this.timestampDataList, timestampProcessingResult.timestampDataList);
    }

    public int hashCode() {
        return (this.processedText.hashCode() * 31) + this.timestampDataList.hashCode();
    }

    public String toString() {
        return "TimestampProcessingResult(processedText=" + this.processedText + ", timestampDataList=" + this.timestampDataList + ")";
    }

    public TimestampProcessingResult(String processedText, List<TimestampData> timestampDataList) {
        Intrinsics.checkNotNullParameter(processedText, "processedText");
        Intrinsics.checkNotNullParameter(timestampDataList, "timestampDataList");
        this.processedText = processedText;
        this.timestampDataList = timestampDataList;
    }

    public final String getProcessedText() {
        return this.processedText;
    }

    public final List<TimestampData> getTimestampDataList() {
        return this.timestampDataList;
    }
}
