package com.box.android.domain.models.search;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesSearchFilters.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"removed", "Lcom/box/android/domain/models/search/FilesSearchFilters;", "filterToRemove", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterType;", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FilesSearchFiltersKt {
    public static final FilesSearchFilters removed(FilesSearchFilters filesSearchFilters, FilesSearchFilters.FilterType filterToRemove) {
        Intrinsics.checkNotNullParameter(filesSearchFilters, "<this>");
        Intrinsics.checkNotNullParameter(filterToRemove, "filterToRemove");
        if (filterToRemove instanceof FilesSearchFilters.FilterItemType) {
            return FilesSearchFilters.copy$default(filesSearchFilters, SetsKt.minus(filesSearchFilters.getItemTypes(), filterToRemove), null, null, 6, null);
        }
        if (filterToRemove instanceof FilesSearchFilters.ModifiedAfterDate) {
            return FilesSearchFilters.copy$default(filesSearchFilters, null, FilesSearchFilters.ModifiedAfterDate.Any.INSTANCE, null, 5, null);
        }
        return filterToRemove instanceof FilesSearchFilters.Size ? FilesSearchFilters.copy$default(filesSearchFilters, null, null, FilesSearchFilters.Size.Any.INSTANCE, 3, null) : filesSearchFilters;
    }
}
