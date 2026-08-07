package com.box.android.domain.models.preview;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewData.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/domain/models/preview/PreviewData;", "", "url", "Ljava/net/URI;", "previewerType", "Lcom/box/android/domain/models/preview/PreviewerType;", "loadedFromCache", "", "<init>", "(Ljava/net/URI;Lcom/box/android/domain/models/preview/PreviewerType;Z)V", "getUrl", "()Ljava/net/URI;", "getPreviewerType", "()Lcom/box/android/domain/models/preview/PreviewerType;", "getLoadedFromCache", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PreviewData {
    private final boolean loadedFromCache;
    private final PreviewerType previewerType;
    private final URI url;

    public static /* synthetic */ PreviewData copy$default(PreviewData previewData, URI uri, PreviewerType previewerType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = previewData.url;
        }
        if ((i & 2) != 0) {
            previewerType = previewData.previewerType;
        }
        if ((i & 4) != 0) {
            z = previewData.loadedFromCache;
        }
        return previewData.copy(uri, previewerType, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final URI getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PreviewerType getPreviewerType() {
        return this.previewerType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getLoadedFromCache() {
        return this.loadedFromCache;
    }

    public final PreviewData copy(URI url, PreviewerType previewerType, boolean loadedFromCache) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(previewerType, "previewerType");
        return new PreviewData(url, previewerType, loadedFromCache);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewData)) {
            return false;
        }
        PreviewData previewData = (PreviewData) other;
        return Intrinsics.areEqual(this.url, previewData.url) && this.previewerType == previewData.previewerType && this.loadedFromCache == previewData.loadedFromCache;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + this.previewerType.hashCode()) * 31) + Boolean.hashCode(this.loadedFromCache);
    }

    public String toString() {
        return "PreviewData(url=" + this.url + ", previewerType=" + this.previewerType + ", loadedFromCache=" + this.loadedFromCache + ")";
    }

    public PreviewData(URI url, PreviewerType previewerType, boolean z) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(previewerType, "previewerType");
        this.url = url;
        this.previewerType = previewerType;
        this.loadedFromCache = z;
    }

    public final boolean getLoadedFromCache() {
        return this.loadedFromCache;
    }

    public final PreviewerType getPreviewerType() {
        return this.previewerType;
    }

    public final URI getUrl() {
        return this.url;
    }
}
