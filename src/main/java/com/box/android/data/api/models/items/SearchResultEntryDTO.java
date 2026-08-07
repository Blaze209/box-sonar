package com.box.android.data.api.models.items;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchResultsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/api/models/items/SearchResultEntryDTO;", "", "accessibleViaSharedLink", "", "item", "Lcom/box/android/data/api/models/items/IItemDTO;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/api/models/items/IItemDTO;)V", "getAccessibleViaSharedLink", "()Ljava/lang/String;", "getItem", "()Lcom/box/android/data/api/models/items/IItemDTO;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SearchResultEntryDTO {
    private final String accessibleViaSharedLink;
    private final IItemDTO item;

    public static /* synthetic */ SearchResultEntryDTO copy$default(SearchResultEntryDTO searchResultEntryDTO, String str, IItemDTO iItemDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchResultEntryDTO.accessibleViaSharedLink;
        }
        if ((i & 2) != 0) {
            iItemDTO = searchResultEntryDTO.item;
        }
        return searchResultEntryDTO.copy(str, iItemDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAccessibleViaSharedLink() {
        return this.accessibleViaSharedLink;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IItemDTO getItem() {
        return this.item;
    }

    public final SearchResultEntryDTO copy(@Json(name = "accessible_via_shared_link") String accessibleViaSharedLink, @Json(name = "item") IItemDTO item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return new SearchResultEntryDTO(accessibleViaSharedLink, item);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResultEntryDTO)) {
            return false;
        }
        SearchResultEntryDTO searchResultEntryDTO = (SearchResultEntryDTO) other;
        return Intrinsics.areEqual(this.accessibleViaSharedLink, searchResultEntryDTO.accessibleViaSharedLink) && Intrinsics.areEqual(this.item, searchResultEntryDTO.item);
    }

    public int hashCode() {
        String str = this.accessibleViaSharedLink;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.item.hashCode();
    }

    public String toString() {
        return "SearchResultEntryDTO(accessibleViaSharedLink=" + this.accessibleViaSharedLink + ", item=" + this.item + ")";
    }

    public SearchResultEntryDTO(@Json(name = "accessible_via_shared_link") String str, @Json(name = "item") IItemDTO item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.accessibleViaSharedLink = str;
        this.item = item;
    }

    public final String getAccessibleViaSharedLink() {
        return this.accessibleViaSharedLink;
    }

    public final IItemDTO getItem() {
        return this.item;
    }
}
