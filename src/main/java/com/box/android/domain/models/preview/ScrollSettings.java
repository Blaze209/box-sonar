package com.box.android.domain.models.preview;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.observability.DiagnosisParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScrollSettings.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/domain/models/preview/ScrollSettings;", "", DiagnosisParams.DIAGNOSIS_MODE, "Lcom/box/android/domain/models/preview/PageScrollMode;", "direction", "Lcom/box/android/domain/models/preview/PageScrollDirection;", "<init>", "(Lcom/box/android/domain/models/preview/PageScrollMode;Lcom/box/android/domain/models/preview/PageScrollDirection;)V", "getMode", "()Lcom/box/android/domain/models/preview/PageScrollMode;", "getDirection", "()Lcom/box/android/domain/models/preview/PageScrollDirection;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ScrollSettings {
    private final PageScrollDirection direction;
    private final PageScrollMode mode;

    public static /* synthetic */ ScrollSettings copy$default(ScrollSettings scrollSettings, PageScrollMode pageScrollMode, PageScrollDirection pageScrollDirection, int i, Object obj) {
        if ((i & 1) != 0) {
            pageScrollMode = scrollSettings.mode;
        }
        if ((i & 2) != 0) {
            pageScrollDirection = scrollSettings.direction;
        }
        return scrollSettings.copy(pageScrollMode, pageScrollDirection);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PageScrollMode getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PageScrollDirection getDirection() {
        return this.direction;
    }

    public final ScrollSettings copy(PageScrollMode mode, PageScrollDirection direction) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(direction, "direction");
        return new ScrollSettings(mode, direction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollSettings)) {
            return false;
        }
        ScrollSettings scrollSettings = (ScrollSettings) other;
        return this.mode == scrollSettings.mode && this.direction == scrollSettings.direction;
    }

    public int hashCode() {
        return (this.mode.hashCode() * 31) + this.direction.hashCode();
    }

    public String toString() {
        return "ScrollSettings(mode=" + this.mode + ", direction=" + this.direction + ")";
    }

    public ScrollSettings(PageScrollMode mode, PageScrollDirection direction) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.mode = mode;
        this.direction = direction;
    }

    public final PageScrollDirection getDirection() {
        return this.direction;
    }

    public final PageScrollMode getMode() {
        return this.mode;
    }
}
