package com.box.android.data.api.models.items.mini;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxItem;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderMiniDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u001b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001b\u0010\u0012\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0012\u0010\u0014¨\u0006\""}, d2 = {"Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "Lcom/box/android/data/api/models/items/mini/IFolderMiniDTO;", "id", "", "type", "name", BoxItem.FIELD_ETAG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getType", "getName", "setName", "getEtag", "setEtag", "isRoot", "", "()Z", "isRoot$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FolderMiniDTO implements IFolderMiniDTO {
    private String etag;
    private String id;

    /* JADX INFO: renamed from: isRoot$delegate, reason: from kotlin metadata */
    private final Lazy isRoot;
    private String name;
    private final String type;

    public static /* synthetic */ FolderMiniDTO copy$default(FolderMiniDTO folderMiniDTO, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = folderMiniDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = folderMiniDTO.type;
        }
        if ((i & 4) != 0) {
            str3 = folderMiniDTO.name;
        }
        if ((i & 8) != 0) {
            str4 = folderMiniDTO.etag;
        }
        return folderMiniDTO.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEtag() {
        return this.etag;
    }

    public final FolderMiniDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "name") String name, @Json(name = BoxItem.FIELD_ETAG) String etag) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new FolderMiniDTO(id, type, name, etag);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FolderMiniDTO)) {
            return false;
        }
        FolderMiniDTO folderMiniDTO = (FolderMiniDTO) other;
        return Intrinsics.areEqual(this.id, folderMiniDTO.id) && Intrinsics.areEqual(this.type, folderMiniDTO.type) && Intrinsics.areEqual(this.name, folderMiniDTO.name) && Intrinsics.areEqual(this.etag, folderMiniDTO.etag);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.etag;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "FolderMiniDTO(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", etag=" + this.etag + ")";
    }

    public FolderMiniDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "name") String str, @Json(name = BoxItem.FIELD_ETAG) String str2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
        this.name = str;
        this.etag = str2;
        this.isRoot = LazyKt.lazy(new Function0() { // from class: com.box.android.data.api.models.items.mini.FolderMiniDTO$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(FolderMiniDTO.isRoot_delegate$lambda$0(this.f$0));
            }
        });
    }

    public /* synthetic */ FolderMiniDTO(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    @Override // com.box.android.data.api.models.items.mini.IItemMiniDTO
    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    @Override // com.box.android.data.api.models.items.mini.IItemMiniDTO
    public String getType() {
        return this.type;
    }

    @Override // com.box.android.data.api.models.items.mini.IItemMiniDTO
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // com.box.android.data.api.models.items.mini.IItemMiniDTO
    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRoot_delegate$lambda$0(FolderMiniDTO folderMiniDTO) {
        return Intrinsics.areEqual(folderMiniDTO.getId(), "0");
    }

    @Override // com.box.android.data.api.models.items.mini.IFolderMiniDTO
    public boolean isRoot() {
        return ((Boolean) this.isRoot.getValue()).booleanValue();
    }
}
