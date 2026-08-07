package com.box.android.data.api.models;

import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddToRecentsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/api/models/AddToRecentsDTO;", "", "item", "Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "interactionType", "", "<init>", "(Lcom/box/android/data/api/models/items/mini/ItemIdDTO;Ljava/lang/String;)V", "getItem", "()Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "getInteractionType", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AddToRecentsDTO {
    private final String interactionType;
    private final ItemIdDTO item;

    public static /* synthetic */ AddToRecentsDTO copy$default(AddToRecentsDTO addToRecentsDTO, ItemIdDTO itemIdDTO, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            itemIdDTO = addToRecentsDTO.item;
        }
        if ((i & 2) != 0) {
            str = addToRecentsDTO.interactionType;
        }
        return addToRecentsDTO.copy(itemIdDTO, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ItemIdDTO getItem() {
        return this.item;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getInteractionType() {
        return this.interactionType;
    }

    public final AddToRecentsDTO copy(@Json(name = "item") ItemIdDTO item, @Json(name = "interaction_type") String interactionType) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(interactionType, "interactionType");
        return new AddToRecentsDTO(item, interactionType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddToRecentsDTO)) {
            return false;
        }
        AddToRecentsDTO addToRecentsDTO = (AddToRecentsDTO) other;
        return Intrinsics.areEqual(this.item, addToRecentsDTO.item) && Intrinsics.areEqual(this.interactionType, addToRecentsDTO.interactionType);
    }

    public int hashCode() {
        return (this.item.hashCode() * 31) + this.interactionType.hashCode();
    }

    public String toString() {
        return "AddToRecentsDTO(item=" + this.item + ", interactionType=" + this.interactionType + ")";
    }

    public AddToRecentsDTO(@Json(name = "item") ItemIdDTO item, @Json(name = "interaction_type") String interactionType) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(interactionType, "interactionType");
        this.item = item;
        this.interactionType = interactionType;
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final ItemIdDTO getItem() {
        return this.item;
    }
}
