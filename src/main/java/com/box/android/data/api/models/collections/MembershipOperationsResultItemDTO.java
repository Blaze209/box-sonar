package com.box.android.data.api.models.collections;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.ItemType;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MembershipOperationsResultDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/collections/MembershipOperationsResultItemDTO;", "", "id", "", "type", "Lcom/box/android/domain/models/item/ItemType;", "statusCode", "errorCode", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/domain/models/item/ItemType;", "getStatusCode", "getErrorCode", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MembershipOperationsResultItemDTO {
    private final String errorCode;
    private final String id;
    private final String statusCode;
    private final ItemType type;

    public static /* synthetic */ MembershipOperationsResultItemDTO copy$default(MembershipOperationsResultItemDTO membershipOperationsResultItemDTO, String str, ItemType itemType, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = membershipOperationsResultItemDTO.id;
        }
        if ((i & 2) != 0) {
            itemType = membershipOperationsResultItemDTO.type;
        }
        if ((i & 4) != 0) {
            str2 = membershipOperationsResultItemDTO.statusCode;
        }
        if ((i & 8) != 0) {
            str3 = membershipOperationsResultItemDTO.errorCode;
        }
        return membershipOperationsResultItemDTO.copy(str, itemType, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ItemType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStatusCode() {
        return this.statusCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    public final MembershipOperationsResultItemDTO copy(@Json(name = "id") String id, @Json(name = "type") ItemType type, @Json(name = "status_code") String statusCode, @Json(name = AuthenticationConstants.OAuth2.ERROR_CODE) String errorCode) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        return new MembershipOperationsResultItemDTO(id, type, statusCode, errorCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MembershipOperationsResultItemDTO)) {
            return false;
        }
        MembershipOperationsResultItemDTO membershipOperationsResultItemDTO = (MembershipOperationsResultItemDTO) other;
        return Intrinsics.areEqual(this.id, membershipOperationsResultItemDTO.id) && this.type == membershipOperationsResultItemDTO.type && Intrinsics.areEqual(this.statusCode, membershipOperationsResultItemDTO.statusCode) && Intrinsics.areEqual(this.errorCode, membershipOperationsResultItemDTO.errorCode);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.statusCode.hashCode()) * 31) + this.errorCode.hashCode();
    }

    public String toString() {
        return "MembershipOperationsResultItemDTO(id=" + this.id + ", type=" + this.type + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ")";
    }

    public MembershipOperationsResultItemDTO(@Json(name = "id") String id, @Json(name = "type") ItemType type, @Json(name = "status_code") String statusCode, @Json(name = AuthenticationConstants.OAuth2.ERROR_CODE) String errorCode) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.id = id;
        this.type = type;
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public final String getId() {
        return this.id;
    }

    public final ItemType getType() {
        return this.type;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }
}
