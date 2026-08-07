package com.box.android.domain.preview;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.preview.PreviewerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewerTypeResolver.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/domain/preview/PreviewerMapping;", "", "type", "Lcom/box/android/domain/models/preview/PreviewerType;", "content", "Lcom/box/android/domain/preview/PreviewContentType;", "<init>", "(Lcom/box/android/domain/models/preview/PreviewerType;Lcom/box/android/domain/preview/PreviewContentType;)V", "getType", "()Lcom/box/android/domain/models/preview/PreviewerType;", "getContent", "()Lcom/box/android/domain/preview/PreviewContentType;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PreviewerMapping {
    private final PreviewContentType content;
    private final PreviewerType type;

    public static /* synthetic */ PreviewerMapping copy$default(PreviewerMapping previewerMapping, PreviewerType previewerType, PreviewContentType previewContentType, int i, Object obj) {
        if ((i & 1) != 0) {
            previewerType = previewerMapping.type;
        }
        if ((i & 2) != 0) {
            previewContentType = previewerMapping.content;
        }
        return previewerMapping.copy(previewerType, previewContentType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PreviewerType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PreviewContentType getContent() {
        return this.content;
    }

    public final PreviewerMapping copy(PreviewerType type, PreviewContentType content) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        return new PreviewerMapping(type, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewerMapping)) {
            return false;
        }
        PreviewerMapping previewerMapping = (PreviewerMapping) other;
        return this.type == previewerMapping.type && Intrinsics.areEqual(this.content, previewerMapping.content);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.content.hashCode();
    }

    public String toString() {
        return "PreviewerMapping(type=" + this.type + ", content=" + this.content + ")";
    }

    public PreviewerMapping(PreviewerType type, PreviewContentType content) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        this.type = type;
        this.content = content;
    }

    public final PreviewContentType getContent() {
        return this.content;
    }

    public final PreviewerType getType() {
        return this.type;
    }
}
