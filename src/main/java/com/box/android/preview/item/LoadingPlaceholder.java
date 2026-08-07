package com.box.android.preview.item;

import android.graphics.Bitmap;
import com.box.android.base.presentation.utilities.FileTypeIcon;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.metrics.hubs.HubsObservability;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemState.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/item/LoadingPlaceholder;", "", HubsObservability.HUB_ASSET_ICON, "Lcom/box/android/base/presentation/utilities/FileTypeIcon;", "thumbnail", "Landroid/graphics/Bitmap;", "<init>", "(Lcom/box/android/base/presentation/utilities/FileTypeIcon;Landroid/graphics/Bitmap;)V", "getIcon", "()Lcom/box/android/base/presentation/utilities/FileTypeIcon;", "getThumbnail", "()Landroid/graphics/Bitmap;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LoadingPlaceholder {
    public static final int $stable = 8;
    private final FileTypeIcon icon;
    private final Bitmap thumbnail;

    public static /* synthetic */ LoadingPlaceholder copy$default(LoadingPlaceholder loadingPlaceholder, FileTypeIcon fileTypeIcon, Bitmap bitmap, int i, Object obj) {
        if ((i & 1) != 0) {
            fileTypeIcon = loadingPlaceholder.icon;
        }
        if ((i & 2) != 0) {
            bitmap = loadingPlaceholder.thumbnail;
        }
        return loadingPlaceholder.copy(fileTypeIcon, bitmap);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FileTypeIcon getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Bitmap getThumbnail() {
        return this.thumbnail;
    }

    public final LoadingPlaceholder copy(FileTypeIcon icon, Bitmap thumbnail) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new LoadingPlaceholder(icon, thumbnail);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadingPlaceholder)) {
            return false;
        }
        LoadingPlaceholder loadingPlaceholder = (LoadingPlaceholder) other;
        return this.icon == loadingPlaceholder.icon && Intrinsics.areEqual(this.thumbnail, loadingPlaceholder.thumbnail);
    }

    public int hashCode() {
        int iHashCode = this.icon.hashCode() * 31;
        Bitmap bitmap = this.thumbnail;
        return iHashCode + (bitmap == null ? 0 : bitmap.hashCode());
    }

    public String toString() {
        return "LoadingPlaceholder(icon=" + this.icon + ", thumbnail=" + this.thumbnail + ")";
    }

    public LoadingPlaceholder(FileTypeIcon icon, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.icon = icon;
        this.thumbnail = bitmap;
    }

    public /* synthetic */ LoadingPlaceholder(FileTypeIcon fileTypeIcon, Bitmap bitmap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileTypeIcon, (i & 2) != 0 ? null : bitmap);
    }

    public final FileTypeIcon getIcon() {
        return this.icon;
    }

    public final Bitmap getThumbnail() {
        return this.thumbnail;
    }
}
