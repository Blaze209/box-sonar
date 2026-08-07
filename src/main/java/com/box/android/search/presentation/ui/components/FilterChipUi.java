package com.box.android.search.presentation.ui.components;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.search.FilesSearchFilters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchResultsHeader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/box/android/search/presentation/ui/components/FilterChipUi;", "", "key", "", "labelRes", "", "chipToRemove", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterType;", "<init>", "(Ljava/lang/String;ILcom/box/android/domain/models/search/FilesSearchFilters$FilterType;)V", "getKey", "()Ljava/lang/String;", "getLabelRes", "()I", "getChipToRemove", "()Lcom/box/android/domain/models/search/FilesSearchFilters$FilterType;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
final /* data */ class FilterChipUi {
    private final FilesSearchFilters.FilterType chipToRemove;
    private final String key;
    private final int labelRes;

    public static /* synthetic */ FilterChipUi copy$default(FilterChipUi filterChipUi, String str, int i, FilesSearchFilters.FilterType filterType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = filterChipUi.key;
        }
        if ((i2 & 2) != 0) {
            i = filterChipUi.labelRes;
        }
        if ((i2 & 4) != 0) {
            filterType = filterChipUi.chipToRemove;
        }
        return filterChipUi.copy(str, i, filterType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLabelRes() {
        return this.labelRes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FilesSearchFilters.FilterType getChipToRemove() {
        return this.chipToRemove;
    }

    public final FilterChipUi copy(String key, int labelRes, FilesSearchFilters.FilterType chipToRemove) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(chipToRemove, "chipToRemove");
        return new FilterChipUi(key, labelRes, chipToRemove);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilterChipUi)) {
            return false;
        }
        FilterChipUi filterChipUi = (FilterChipUi) other;
        return Intrinsics.areEqual(this.key, filterChipUi.key) && this.labelRes == filterChipUi.labelRes && Intrinsics.areEqual(this.chipToRemove, filterChipUi.chipToRemove);
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + Integer.hashCode(this.labelRes)) * 31) + this.chipToRemove.hashCode();
    }

    public String toString() {
        return "FilterChipUi(key=" + this.key + ", labelRes=" + this.labelRes + ", chipToRemove=" + this.chipToRemove + ")";
    }

    public FilterChipUi(String key, int i, FilesSearchFilters.FilterType chipToRemove) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(chipToRemove, "chipToRemove");
        this.key = key;
        this.labelRes = i;
        this.chipToRemove = chipToRemove;
    }

    public final FilesSearchFilters.FilterType getChipToRemove() {
        return this.chipToRemove;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getLabelRes() {
        return this.labelRes;
    }
}
