package com.box.android.domain.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannedDocumentPage.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/ScannedPageProcessingResult;", "", "appliedFilterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "appliedPosition", "Lcom/box/android/domain/models/DocumentPosition;", "outputFile", "Ljava/io/File;", "<init>", "(Lcom/box/android/domain/models/DocumentPageFilterType;Lcom/box/android/domain/models/DocumentPosition;Ljava/io/File;)V", "getAppliedFilterType", "()Lcom/box/android/domain/models/DocumentPageFilterType;", "getAppliedPosition", "()Lcom/box/android/domain/models/DocumentPosition;", "getOutputFile", "()Ljava/io/File;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ScannedPageProcessingResult {
    private final DocumentPageFilterType appliedFilterType;
    private final DocumentPosition appliedPosition;
    private final File outputFile;

    public static /* synthetic */ ScannedPageProcessingResult copy$default(ScannedPageProcessingResult scannedPageProcessingResult, DocumentPageFilterType documentPageFilterType, DocumentPosition documentPosition, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            documentPageFilterType = scannedPageProcessingResult.appliedFilterType;
        }
        if ((i & 2) != 0) {
            documentPosition = scannedPageProcessingResult.appliedPosition;
        }
        if ((i & 4) != 0) {
            file = scannedPageProcessingResult.outputFile;
        }
        return scannedPageProcessingResult.copy(documentPageFilterType, documentPosition, file);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DocumentPageFilterType getAppliedFilterType() {
        return this.appliedFilterType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DocumentPosition getAppliedPosition() {
        return this.appliedPosition;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final File getOutputFile() {
        return this.outputFile;
    }

    public final ScannedPageProcessingResult copy(DocumentPageFilterType appliedFilterType, DocumentPosition appliedPosition, File outputFile) {
        Intrinsics.checkNotNullParameter(appliedFilterType, "appliedFilterType");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        return new ScannedPageProcessingResult(appliedFilterType, appliedPosition, outputFile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScannedPageProcessingResult)) {
            return false;
        }
        ScannedPageProcessingResult scannedPageProcessingResult = (ScannedPageProcessingResult) other;
        return this.appliedFilterType == scannedPageProcessingResult.appliedFilterType && Intrinsics.areEqual(this.appliedPosition, scannedPageProcessingResult.appliedPosition) && Intrinsics.areEqual(this.outputFile, scannedPageProcessingResult.outputFile);
    }

    public int hashCode() {
        int iHashCode = this.appliedFilterType.hashCode() * 31;
        DocumentPosition documentPosition = this.appliedPosition;
        return ((iHashCode + (documentPosition == null ? 0 : documentPosition.hashCode())) * 31) + this.outputFile.hashCode();
    }

    public String toString() {
        return "ScannedPageProcessingResult(appliedFilterType=" + this.appliedFilterType + ", appliedPosition=" + this.appliedPosition + ", outputFile=" + this.outputFile + ")";
    }

    public ScannedPageProcessingResult(DocumentPageFilterType appliedFilterType, DocumentPosition documentPosition, File outputFile) {
        Intrinsics.checkNotNullParameter(appliedFilterType, "appliedFilterType");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        this.appliedFilterType = appliedFilterType;
        this.appliedPosition = documentPosition;
        this.outputFile = outputFile;
    }

    public final DocumentPageFilterType getAppliedFilterType() {
        return this.appliedFilterType;
    }

    public final DocumentPosition getAppliedPosition() {
        return this.appliedPosition;
    }

    public final File getOutputFile() {
        return this.outputFile;
    }
}
