package com.box.android.data.api.models.items.mini;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxItem;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebLinkMiniDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/box/android/data/api/models/items/mini/WebLinkMiniDTO;", "Lcom/box/android/data/api/models/items/mini/IWebLinkMiniDTO;", "id", "", "type", "name", "url", BoxItem.FIELD_ETAG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getType", "getName", "setName", "getUrl", "getEtag", "setEtag", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WebLinkMiniDTO implements IWebLinkMiniDTO {
    private String etag;
    private String id;
    private String name;
    private final String type;
    private final String url;

    public static /* synthetic */ WebLinkMiniDTO copy$default(WebLinkMiniDTO webLinkMiniDTO, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = webLinkMiniDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = webLinkMiniDTO.type;
        }
        if ((i & 4) != 0) {
            str3 = webLinkMiniDTO.name;
        }
        if ((i & 8) != 0) {
            str4 = webLinkMiniDTO.url;
        }
        if ((i & 16) != 0) {
            str5 = webLinkMiniDTO.etag;
        }
        String str6 = str5;
        String str7 = str3;
        return webLinkMiniDTO.copy(str, str2, str7, str4, str6);
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
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEtag() {
        return this.etag;
    }

    public final WebLinkMiniDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "name") String name, @Json(name = "url") String url, @Json(name = BoxItem.FIELD_ETAG) String etag) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new WebLinkMiniDTO(id, type, name, url, etag);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebLinkMiniDTO)) {
            return false;
        }
        WebLinkMiniDTO webLinkMiniDTO = (WebLinkMiniDTO) other;
        return Intrinsics.areEqual(this.id, webLinkMiniDTO.id) && Intrinsics.areEqual(this.type, webLinkMiniDTO.type) && Intrinsics.areEqual(this.name, webLinkMiniDTO.name) && Intrinsics.areEqual(this.url, webLinkMiniDTO.url) && Intrinsics.areEqual(this.etag, webLinkMiniDTO.etag);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.url;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.etag;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "WebLinkMiniDTO(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", url=" + this.url + ", etag=" + this.etag + ")";
    }

    public WebLinkMiniDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "name") String str, @Json(name = "url") String str2, @Json(name = BoxItem.FIELD_ETAG) String str3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
        this.name = str;
        this.url = str2;
        this.etag = str3;
    }

    public /* synthetic */ WebLinkMiniDTO(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
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

    @Override // com.box.android.data.api.models.items.mini.IWebLinkMiniDTO
    public String getUrl() {
        return this.url;
    }

    @Override // com.box.android.data.api.models.items.mini.IItemMiniDTO
    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }
}
