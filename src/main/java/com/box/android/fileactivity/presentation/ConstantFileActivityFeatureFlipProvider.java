package com.box.android.fileactivity.presentation;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FileActivityFeatureFlipProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/fileactivity/presentation/ConstantFileActivityFeatureFlipProvider;", "Lcom/box/android/fileactivity/presentation/IFileActivityFeatureFlipProvider;", "isThreadedRepliesEnabled", "", "isVideoAnnotationsEnabled", "<init>", "(ZZ)V", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConstantFileActivityFeatureFlipProvider implements IFileActivityFeatureFlipProvider {
    public static final int $stable = 0;
    private final boolean isThreadedRepliesEnabled;
    private final boolean isVideoAnnotationsEnabled;

    /* JADX WARN: Illegal instructions before constructor call */
    public ConstantFileActivityFeatureFlipProvider() {
        boolean z = false;
        this(z, z, 3, null);
    }

    public static /* synthetic */ ConstantFileActivityFeatureFlipProvider copy$default(ConstantFileActivityFeatureFlipProvider constantFileActivityFeatureFlipProvider, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = constantFileActivityFeatureFlipProvider.isThreadedRepliesEnabled;
        }
        if ((i & 2) != 0) {
            z2 = constantFileActivityFeatureFlipProvider.isVideoAnnotationsEnabled;
        }
        return constantFileActivityFeatureFlipProvider.copy(z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsThreadedRepliesEnabled() {
        return this.isThreadedRepliesEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsVideoAnnotationsEnabled() {
        return this.isVideoAnnotationsEnabled;
    }

    public final ConstantFileActivityFeatureFlipProvider copy(boolean isThreadedRepliesEnabled, boolean isVideoAnnotationsEnabled) {
        return new ConstantFileActivityFeatureFlipProvider(isThreadedRepliesEnabled, isVideoAnnotationsEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConstantFileActivityFeatureFlipProvider)) {
            return false;
        }
        ConstantFileActivityFeatureFlipProvider constantFileActivityFeatureFlipProvider = (ConstantFileActivityFeatureFlipProvider) other;
        return this.isThreadedRepliesEnabled == constantFileActivityFeatureFlipProvider.isThreadedRepliesEnabled && this.isVideoAnnotationsEnabled == constantFileActivityFeatureFlipProvider.isVideoAnnotationsEnabled;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isThreadedRepliesEnabled) * 31) + Boolean.hashCode(this.isVideoAnnotationsEnabled);
    }

    public String toString() {
        return "ConstantFileActivityFeatureFlipProvider(isThreadedRepliesEnabled=" + this.isThreadedRepliesEnabled + ", isVideoAnnotationsEnabled=" + this.isVideoAnnotationsEnabled + ")";
    }

    public ConstantFileActivityFeatureFlipProvider(boolean z, boolean z2) {
        this.isThreadedRepliesEnabled = z;
        this.isVideoAnnotationsEnabled = z2;
    }

    public /* synthetic */ ConstantFileActivityFeatureFlipProvider(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    @Override // com.box.android.fileactivity.presentation.IFileActivityFeatureFlipProvider
    public boolean isThreadedRepliesEnabled() {
        return this.isThreadedRepliesEnabled;
    }

    @Override // com.box.android.fileactivity.presentation.IFileActivityFeatureFlipProvider
    public boolean isVideoAnnotationsEnabled() {
        return this.isVideoAnnotationsEnabled;
    }
}
