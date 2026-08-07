package com.box.android.data.api.models.comment;

import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxComment;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentV2RequestDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/api/models/comment/CommentV2RequestDTO;", "", "message", "", "taggedMessage", "item", "Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/items/mini/ItemIdDTO;)V", "getMessage", "()Ljava/lang/String;", "getTaggedMessage", "getItem", "()Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CommentV2RequestDTO {
    private final ItemIdDTO item;
    private final String message;
    private final String taggedMessage;

    public CommentV2RequestDTO() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CommentV2RequestDTO copy$default(CommentV2RequestDTO commentV2RequestDTO, String str, String str2, ItemIdDTO itemIdDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commentV2RequestDTO.message;
        }
        if ((i & 2) != 0) {
            str2 = commentV2RequestDTO.taggedMessage;
        }
        if ((i & 4) != 0) {
            itemIdDTO = commentV2RequestDTO.item;
        }
        return commentV2RequestDTO.copy(str, str2, itemIdDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTaggedMessage() {
        return this.taggedMessage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ItemIdDTO getItem() {
        return this.item;
    }

    public final CommentV2RequestDTO copy(@Json(name = "message") String message, @Json(name = BoxComment.FIELD_TAGGED_MESSAGE) String taggedMessage, @Json(name = "item") ItemIdDTO item) {
        return new CommentV2RequestDTO(message, taggedMessage, item);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentV2RequestDTO)) {
            return false;
        }
        CommentV2RequestDTO commentV2RequestDTO = (CommentV2RequestDTO) other;
        return Intrinsics.areEqual(this.message, commentV2RequestDTO.message) && Intrinsics.areEqual(this.taggedMessage, commentV2RequestDTO.taggedMessage) && Intrinsics.areEqual(this.item, commentV2RequestDTO.item);
    }

    public int hashCode() {
        String str = this.message;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.taggedMessage;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ItemIdDTO itemIdDTO = this.item;
        return iHashCode2 + (itemIdDTO != null ? itemIdDTO.hashCode() : 0);
    }

    public String toString() {
        return "CommentV2RequestDTO(message=" + this.message + ", taggedMessage=" + this.taggedMessage + ", item=" + this.item + ")";
    }

    public CommentV2RequestDTO(@Json(name = "message") String str, @Json(name = BoxComment.FIELD_TAGGED_MESSAGE) String str2, @Json(name = "item") ItemIdDTO itemIdDTO) {
        this.message = str;
        this.taggedMessage = str2;
        this.item = itemIdDTO;
    }

    public /* synthetic */ CommentV2RequestDTO(String str, String str2, ItemIdDTO itemIdDTO, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : itemIdDTO);
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTaggedMessage() {
        return this.taggedMessage;
    }

    public final ItemIdDTO getItem() {
        return this.item;
    }
}
