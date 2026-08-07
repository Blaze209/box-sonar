package com.box.android.preview.preview;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/preview/PreviewConfig;", "", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "", "observabilityId", "isNewlyCreatedFile", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getSharedLink", "()Ljava/lang/String;", "getObservabilityId", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PreviewConfig {
    public static final int $stable = 0;
    private final boolean isNewlyCreatedFile;
    private final String observabilityId;
    private final String sharedLink;

    public PreviewConfig() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ PreviewConfig copy$default(PreviewConfig previewConfig, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = previewConfig.sharedLink;
        }
        if ((i & 2) != 0) {
            str2 = previewConfig.observabilityId;
        }
        if ((i & 4) != 0) {
            z = previewConfig.isNewlyCreatedFile;
        }
        return previewConfig.copy(str, str2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSharedLink() {
        return this.sharedLink;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getObservabilityId() {
        return this.observabilityId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsNewlyCreatedFile() {
        return this.isNewlyCreatedFile;
    }

    public final PreviewConfig copy(String sharedLink, String observabilityId, boolean isNewlyCreatedFile) {
        return new PreviewConfig(sharedLink, observabilityId, isNewlyCreatedFile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewConfig)) {
            return false;
        }
        PreviewConfig previewConfig = (PreviewConfig) other;
        return Intrinsics.areEqual(this.sharedLink, previewConfig.sharedLink) && Intrinsics.areEqual(this.observabilityId, previewConfig.observabilityId) && this.isNewlyCreatedFile == previewConfig.isNewlyCreatedFile;
    }

    public int hashCode() {
        String str = this.sharedLink;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.observabilityId;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.isNewlyCreatedFile);
    }

    public String toString() {
        return "PreviewConfig(sharedLink=" + this.sharedLink + ", observabilityId=" + this.observabilityId + ", isNewlyCreatedFile=" + this.isNewlyCreatedFile + ")";
    }

    public PreviewConfig(String str, String str2, boolean z) {
        this.sharedLink = str;
        this.observabilityId = str2;
        this.isNewlyCreatedFile = z;
    }

    public /* synthetic */ PreviewConfig(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z);
    }

    public final String getObservabilityId() {
        return this.observabilityId;
    }

    public final String getSharedLink() {
        return this.sharedLink;
    }

    public final boolean isNewlyCreatedFile() {
        return this.isNewlyCreatedFile;
    }
}
