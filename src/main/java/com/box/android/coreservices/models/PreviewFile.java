package com.box.android.coreservices.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewFile.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/coreservices/models/PreviewFile;", "", "path", "Ljava/net/URI;", "previewFileAttributes", "Lcom/box/android/coreservices/models/PreviewFileAttributes;", "isWatermarked", "", "isOffline", "<init>", "(Ljava/net/URI;Lcom/box/android/coreservices/models/PreviewFileAttributes;ZZ)V", "getPath", "()Ljava/net/URI;", "getPreviewFileAttributes", "()Lcom/box/android/coreservices/models/PreviewFileAttributes;", "()Z", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PreviewFile {
    private final boolean isOffline;
    private final boolean isWatermarked;
    private final URI path;
    private final PreviewFileAttributes previewFileAttributes;

    public static /* synthetic */ PreviewFile copy$default(PreviewFile previewFile, URI uri, PreviewFileAttributes previewFileAttributes, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = previewFile.path;
        }
        if ((i & 2) != 0) {
            previewFileAttributes = previewFile.previewFileAttributes;
        }
        if ((i & 4) != 0) {
            z = previewFile.isWatermarked;
        }
        if ((i & 8) != 0) {
            z2 = previewFile.isOffline;
        }
        return previewFile.copy(uri, previewFileAttributes, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final URI getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PreviewFileAttributes getPreviewFileAttributes() {
        return this.previewFileAttributes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsWatermarked() {
        return this.isWatermarked;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsOffline() {
        return this.isOffline;
    }

    public final PreviewFile copy(URI path, PreviewFileAttributes previewFileAttributes, boolean isWatermarked, boolean isOffline) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new PreviewFile(path, previewFileAttributes, isWatermarked, isOffline);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewFile)) {
            return false;
        }
        PreviewFile previewFile = (PreviewFile) other;
        return Intrinsics.areEqual(this.path, previewFile.path) && Intrinsics.areEqual(this.previewFileAttributes, previewFile.previewFileAttributes) && this.isWatermarked == previewFile.isWatermarked && this.isOffline == previewFile.isOffline;
    }

    public int hashCode() {
        int iHashCode = this.path.hashCode() * 31;
        PreviewFileAttributes previewFileAttributes = this.previewFileAttributes;
        return ((((iHashCode + (previewFileAttributes == null ? 0 : previewFileAttributes.hashCode())) * 31) + Boolean.hashCode(this.isWatermarked)) * 31) + Boolean.hashCode(this.isOffline);
    }

    public String toString() {
        return "PreviewFile(path=" + this.path + ", previewFileAttributes=" + this.previewFileAttributes + ", isWatermarked=" + this.isWatermarked + ", isOffline=" + this.isOffline + ")";
    }

    public PreviewFile(URI path, PreviewFileAttributes previewFileAttributes, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.previewFileAttributes = previewFileAttributes;
        this.isWatermarked = z;
        this.isOffline = z2;
    }

    public /* synthetic */ PreviewFile(URI uri, PreviewFileAttributes previewFileAttributes, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, previewFileAttributes, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }

    public final URI getPath() {
        return this.path;
    }

    public final PreviewFileAttributes getPreviewFileAttributes() {
        return this.previewFileAttributes;
    }

    public final boolean isWatermarked() {
        return this.isWatermarked;
    }

    public final boolean isOffline() {
        return this.isOffline;
    }
}
