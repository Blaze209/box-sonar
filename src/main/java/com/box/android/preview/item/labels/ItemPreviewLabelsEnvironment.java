package com.box.android.preview.item.labels;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.preview.item.labels.offline.PreviewOfflineLabelEnvironment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewLabelsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/item/labels/ItemPreviewLabelsEnvironment;", "", "offlineLabelEnvironment", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelEnvironment;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelEnvironment;Lcom/box/android/domain/configuration/FeatureFlips;)V", "getOfflineLabelEnvironment", "()Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelEnvironment;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ItemPreviewLabelsEnvironment {
    public static final int $stable = 8;
    private final FeatureFlips featureFlips;
    private final PreviewOfflineLabelEnvironment offlineLabelEnvironment;

    public static /* synthetic */ ItemPreviewLabelsEnvironment copy$default(ItemPreviewLabelsEnvironment itemPreviewLabelsEnvironment, PreviewOfflineLabelEnvironment previewOfflineLabelEnvironment, FeatureFlips featureFlips, int i, Object obj) {
        if ((i & 1) != 0) {
            previewOfflineLabelEnvironment = itemPreviewLabelsEnvironment.offlineLabelEnvironment;
        }
        if ((i & 2) != 0) {
            featureFlips = itemPreviewLabelsEnvironment.featureFlips;
        }
        return itemPreviewLabelsEnvironment.copy(previewOfflineLabelEnvironment, featureFlips);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PreviewOfflineLabelEnvironment getOfflineLabelEnvironment() {
        return this.offlineLabelEnvironment;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }

    public final ItemPreviewLabelsEnvironment copy(PreviewOfflineLabelEnvironment offlineLabelEnvironment, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(offlineLabelEnvironment, "offlineLabelEnvironment");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        return new ItemPreviewLabelsEnvironment(offlineLabelEnvironment, featureFlips);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemPreviewLabelsEnvironment)) {
            return false;
        }
        ItemPreviewLabelsEnvironment itemPreviewLabelsEnvironment = (ItemPreviewLabelsEnvironment) other;
        return Intrinsics.areEqual(this.offlineLabelEnvironment, itemPreviewLabelsEnvironment.offlineLabelEnvironment) && Intrinsics.areEqual(this.featureFlips, itemPreviewLabelsEnvironment.featureFlips);
    }

    public int hashCode() {
        return (this.offlineLabelEnvironment.hashCode() * 31) + this.featureFlips.hashCode();
    }

    public String toString() {
        return "ItemPreviewLabelsEnvironment(offlineLabelEnvironment=" + this.offlineLabelEnvironment + ", featureFlips=" + this.featureFlips + ")";
    }

    @Inject
    public ItemPreviewLabelsEnvironment(PreviewOfflineLabelEnvironment offlineLabelEnvironment, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(offlineLabelEnvironment, "offlineLabelEnvironment");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.offlineLabelEnvironment = offlineLabelEnvironment;
        this.featureFlips = featureFlips;
    }

    public final PreviewOfflineLabelEnvironment getOfflineLabelEnvironment() {
        return this.offlineLabelEnvironment;
    }

    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }
}
