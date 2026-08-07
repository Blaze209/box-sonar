package com.box.android.fileactivity.presentation;

import com.box.android.domain.configuration.FeatureFlips;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityFeatureFlipProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/box/android/fileactivity/presentation/DelegatingFileActivityFeatureFlipProvider;", "Lcom/box/android/fileactivity/presentation/IFileActivityFeatureFlipProvider;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/domain/configuration/FeatureFlips;)V", "isThreadedRepliesEnabled", "", "()Z", "isVideoAnnotationsEnabled", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DelegatingFileActivityFeatureFlipProvider implements IFileActivityFeatureFlipProvider {
    public static final int $stable = 8;
    private final FeatureFlips featureFlips;

    public DelegatingFileActivityFeatureFlipProvider(FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.featureFlips = featureFlips;
    }

    @Override // com.box.android.fileactivity.presentation.IFileActivityFeatureFlipProvider
    public boolean isThreadedRepliesEnabled() {
        return this.featureFlips.getFileActivitiesModernization().getEnabled();
    }

    @Override // com.box.android.fileactivity.presentation.IFileActivityFeatureFlipProvider
    public boolean isVideoAnnotationsEnabled() {
        return this.featureFlips.getVideoAnnotations().getEnabled();
    }
}
