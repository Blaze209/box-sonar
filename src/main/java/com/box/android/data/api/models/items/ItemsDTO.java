package com.box.android.data.api.models.items;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxIterator;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003JR\u0010\u001b\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\b\b\u0003\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/box/android/data/api/models/items/ItemsDTO;", "", "entries", "", "Lcom/box/android/data/api/models/items/IItemDTO;", BoxIterator.FIELD_LIMIT, "", "offset", BoxIterator.FIELD_ORDER, "Lcom/box/android/data/api/models/items/OrderDTO;", "totalCount", "<init>", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;J)V", "getEntries", "()Ljava/util/List;", "getLimit", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOffset", "getOrder", "getTotalCount", "()J", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;J)Lcom/box/android/data/api/models/items/ItemsDTO;", "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ItemsDTO {
    private final List<IItemDTO> entries;
    private final Long limit;
    private final Long offset;
    private final List<OrderDTO> order;
    private final long totalCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ItemsDTO copy$default(ItemsDTO itemsDTO, List list, Long l, Long l2, List list2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = itemsDTO.entries;
        }
        if ((i & 2) != 0) {
            l = itemsDTO.limit;
        }
        if ((i & 4) != 0) {
            l2 = itemsDTO.offset;
        }
        if ((i & 8) != 0) {
            list2 = itemsDTO.order;
        }
        if ((i & 16) != 0) {
            j = itemsDTO.totalCount;
        }
        long j2 = j;
        return itemsDTO.copy(list, l, l2, list2, j2);
    }

    public final List<IItemDTO> component1() {
        return this.entries;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getOffset() {
        return this.offset;
    }

    public final List<OrderDTO> component4() {
        return this.order;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getTotalCount() {
        return this.totalCount;
    }

    public final ItemsDTO copy(@Json(name = "entries") List<? extends IItemDTO> entries, @Json(name = BoxIterator.FIELD_LIMIT) Long limit, @Json(name = "offset") Long offset, @Json(name = BoxIterator.FIELD_ORDER) List<OrderDTO> order, @Json(name = BoxIterator.FIELD_TOTAL_COUNT) long totalCount) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new ItemsDTO(entries, limit, offset, order, totalCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemsDTO)) {
            return false;
        }
        ItemsDTO itemsDTO = (ItemsDTO) other;
        return Intrinsics.areEqual(this.entries, itemsDTO.entries) && Intrinsics.areEqual(this.limit, itemsDTO.limit) && Intrinsics.areEqual(this.offset, itemsDTO.offset) && Intrinsics.areEqual(this.order, itemsDTO.order) && this.totalCount == itemsDTO.totalCount;
    }

    public int hashCode() {
        int iHashCode = this.entries.hashCode() * 31;
        Long l = this.limit;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.offset;
        int iHashCode3 = (iHashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        List<OrderDTO> list = this.order;
        return ((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31) + Long.hashCode(this.totalCount);
    }

    public String toString() {
        return "ItemsDTO(entries=" + this.entries + ", limit=" + this.limit + ", offset=" + this.offset + ", order=" + this.order + ", totalCount=" + this.totalCount + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemsDTO(@Json(name = "entries") List<? extends IItemDTO> entries, @Json(name = BoxIterator.FIELD_LIMIT) Long l, @Json(name = "offset") Long l2, @Json(name = BoxIterator.FIELD_ORDER) List<OrderDTO> list, @Json(name = BoxIterator.FIELD_TOTAL_COUNT) long j) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
        this.limit = l;
        this.offset = l2;
        this.order = list;
        this.totalCount = j;
    }

    public final List<IItemDTO> getEntries() {
        return this.entries;
    }

    public final Long getLimit() {
        return this.limit;
    }

    public final Long getOffset() {
        return this.offset;
    }

    public final List<OrderDTO> getOrder() {
        return this.order;
    }

    public final long getTotalCount() {
        return this.totalCount;
    }
}
