package com.box.android.data.api.models.collections;

import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.requests.BoxRequestsMetadata;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MembershipOperationsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/api/models/collections/MembershipOperationDTO;", "", SerializedNames.OPERATION, "Lcom/box/android/data/api/models/collections/MembershipOperations;", "item", "Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "<init>", "(Lcom/box/android/data/api/models/collections/MembershipOperations;Lcom/box/android/data/api/models/items/mini/ItemIdDTO;)V", "getOperation", "()Lcom/box/android/data/api/models/collections/MembershipOperations;", "getItem", "()Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MembershipOperationDTO {
    private final ItemIdDTO item;
    private final MembershipOperations operation;

    public static /* synthetic */ MembershipOperationDTO copy$default(MembershipOperationDTO membershipOperationDTO, MembershipOperations membershipOperations, ItemIdDTO itemIdDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            membershipOperations = membershipOperationDTO.operation;
        }
        if ((i & 2) != 0) {
            itemIdDTO = membershipOperationDTO.item;
        }
        return membershipOperationDTO.copy(membershipOperations, itemIdDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MembershipOperations getOperation() {
        return this.operation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ItemIdDTO getItem() {
        return this.item;
    }

    public final MembershipOperationDTO copy(@Json(name = BoxRequestsMetadata.UpdateItemMetadata.BoxMetadataUpdateTask.OPERATION) MembershipOperations operation, @Json(name = "value") ItemIdDTO item) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(item, "item");
        return new MembershipOperationDTO(operation, item);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MembershipOperationDTO)) {
            return false;
        }
        MembershipOperationDTO membershipOperationDTO = (MembershipOperationDTO) other;
        return this.operation == membershipOperationDTO.operation && Intrinsics.areEqual(this.item, membershipOperationDTO.item);
    }

    public int hashCode() {
        return (this.operation.hashCode() * 31) + this.item.hashCode();
    }

    public String toString() {
        return "MembershipOperationDTO(operation=" + this.operation + ", item=" + this.item + ")";
    }

    public MembershipOperationDTO(@Json(name = BoxRequestsMetadata.UpdateItemMetadata.BoxMetadataUpdateTask.OPERATION) MembershipOperations operation, @Json(name = "value") ItemIdDTO item) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(item, "item");
        this.operation = operation;
        this.item = item;
    }

    public final ItemIdDTO getItem() {
        return this.item;
    }

    public final MembershipOperations getOperation() {
        return this.operation;
    }
}
