package com.pspdfkit.document.library;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/pspdfkit/document/library/FileIndexItemDescriptor;", "", "documentPath", "", "documentUid", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDocumentPath", "()Ljava/lang/String;", "getDocumentUid", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class FileIndexItemDescriptor {
    public static final int $stable = 0;
    private final String documentPath;
    private final String documentUid;

    public FileIndexItemDescriptor(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.documentPath = str;
        this.documentUid = str2;
    }

    public static /* synthetic */ FileIndexItemDescriptor copy$default(FileIndexItemDescriptor fileIndexItemDescriptor, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileIndexItemDescriptor.documentPath;
        }
        if ((i & 2) != 0) {
            str2 = fileIndexItemDescriptor.documentUid;
        }
        return fileIndexItemDescriptor.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDocumentPath() {
        return this.documentPath;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDocumentUid() {
        return this.documentUid;
    }

    public final FileIndexItemDescriptor copy(String documentPath, String documentUid) {
        documentPath.getClass();
        documentUid.getClass();
        return new FileIndexItemDescriptor(documentPath, documentUid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileIndexItemDescriptor)) {
            return false;
        }
        FileIndexItemDescriptor fileIndexItemDescriptor = (FileIndexItemDescriptor) other;
        return Intrinsics.areEqual(this.documentPath, fileIndexItemDescriptor.documentPath) && Intrinsics.areEqual(this.documentUid, fileIndexItemDescriptor.documentUid);
    }

    public final String getDocumentPath() {
        return this.documentPath;
    }

    public final String getDocumentUid() {
        return this.documentUid;
    }

    public int hashCode() {
        return this.documentUid.hashCode() + (this.documentPath.hashCode() * 31);
    }

    public String toString() {
        return "FileIndexItemDescriptor(documentPath=" + this.documentPath + ", documentUid=" + this.documentUid + ")";
    }
}
