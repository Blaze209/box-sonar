package com.geniusscansdk.structureddata;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StructuredDataResult.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/geniusscansdk/structureddata/StructuredDataResult;", "Ljava/io/Serializable;", "receipt", "Lcom/geniusscansdk/structureddata/StructuredDataReceipt;", "readableCodes", "", "Lcom/geniusscansdk/structureddata/ReadableCode;", "<init>", "(Lcom/geniusscansdk/structureddata/StructuredDataReceipt;Ljava/util/List;)V", "getReceipt", "()Lcom/geniusscansdk/structureddata/StructuredDataReceipt;", "getReadableCodes", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class StructuredDataResult implements Serializable {
    private final List<ReadableCode> readableCodes;
    private final StructuredDataReceipt receipt;

    /* JADX WARN: Multi-variable type inference failed */
    public StructuredDataResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StructuredDataResult copy$default(StructuredDataResult structuredDataResult, StructuredDataReceipt structuredDataReceipt, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            structuredDataReceipt = structuredDataResult.receipt;
        }
        if ((i & 2) != 0) {
            list = structuredDataResult.readableCodes;
        }
        return structuredDataResult.copy(structuredDataReceipt, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StructuredDataReceipt getReceipt() {
        return this.receipt;
    }

    public final List<ReadableCode> component2() {
        return this.readableCodes;
    }

    public final StructuredDataResult copy(StructuredDataReceipt receipt, List<ReadableCode> readableCodes) {
        Intrinsics.checkNotNullParameter(readableCodes, "readableCodes");
        return new StructuredDataResult(receipt, readableCodes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StructuredDataResult)) {
            return false;
        }
        StructuredDataResult structuredDataResult = (StructuredDataResult) other;
        return Intrinsics.areEqual(this.receipt, structuredDataResult.receipt) && Intrinsics.areEqual(this.readableCodes, structuredDataResult.readableCodes);
    }

    public int hashCode() {
        StructuredDataReceipt structuredDataReceipt = this.receipt;
        return ((structuredDataReceipt == null ? 0 : structuredDataReceipt.hashCode()) * 31) + this.readableCodes.hashCode();
    }

    public String toString() {
        return "StructuredDataResult(receipt=" + this.receipt + ", readableCodes=" + this.readableCodes + ")";
    }

    public StructuredDataResult(StructuredDataReceipt structuredDataReceipt, List<ReadableCode> readableCodes) {
        Intrinsics.checkNotNullParameter(readableCodes, "readableCodes");
        this.receipt = structuredDataReceipt;
        this.readableCodes = readableCodes;
    }

    public final StructuredDataReceipt getReceipt() {
        return this.receipt;
    }

    public /* synthetic */ StructuredDataResult(StructuredDataReceipt structuredDataReceipt, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : structuredDataReceipt, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<ReadableCode> getReadableCodes() {
        return this.readableCodes;
    }
}
