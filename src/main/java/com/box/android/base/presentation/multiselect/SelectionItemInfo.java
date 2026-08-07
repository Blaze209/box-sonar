package com.box.android.base.presentation.multiselect;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectionManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006'"}, d2 = {"Lcom/box/android/base/presentation/multiselect/SelectionItemInfo;", "Landroid/os/Parcelable;", "Lcom/box/android/domain/models/DomainModel;", "id", "", "name", "type", "sharedLinkUrl", "boxId", "itemSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "getSharedLinkUrl", "getBoxId", "getItemSource", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SelectionItemInfo implements Parcelable, DomainModel {
    public static final int $stable = 0;
    public static final Parcelable.Creator<SelectionItemInfo> CREATOR = new Creator();
    private final String boxId;
    private final String id;
    private final String itemSource;
    private final String name;
    private final String sharedLinkUrl;
    private final String type;

    /* JADX INFO: compiled from: SelectionManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SelectionItemInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SelectionItemInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SelectionItemInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SelectionItemInfo[] newArray(int i) {
            return new SelectionItemInfo[i];
        }
    }

    public static /* synthetic */ SelectionItemInfo copy$default(SelectionItemInfo selectionItemInfo, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = selectionItemInfo.id;
        }
        if ((i & 2) != 0) {
            str2 = selectionItemInfo.name;
        }
        if ((i & 4) != 0) {
            str3 = selectionItemInfo.type;
        }
        if ((i & 8) != 0) {
            str4 = selectionItemInfo.sharedLinkUrl;
        }
        if ((i & 16) != 0) {
            str5 = selectionItemInfo.boxId;
        }
        if ((i & 32) != 0) {
            str6 = selectionItemInfo.itemSource;
        }
        String str7 = str5;
        String str8 = str6;
        return selectionItemInfo.copy(str, str2, str3, str4, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSharedLinkUrl() {
        return this.sharedLinkUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBoxId() {
        return this.boxId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getItemSource() {
        return this.itemSource;
    }

    public final SelectionItemInfo copy(String id, String name, String type, String sharedLinkUrl, String boxId, String itemSource) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return new SelectionItemInfo(id, name, type, sharedLinkUrl, boxId, itemSource);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectionItemInfo)) {
            return false;
        }
        SelectionItemInfo selectionItemInfo = (SelectionItemInfo) other;
        return Intrinsics.areEqual(this.id, selectionItemInfo.id) && Intrinsics.areEqual(this.name, selectionItemInfo.name) && Intrinsics.areEqual(this.type, selectionItemInfo.type) && Intrinsics.areEqual(this.sharedLinkUrl, selectionItemInfo.sharedLinkUrl) && Intrinsics.areEqual(this.boxId, selectionItemInfo.boxId) && Intrinsics.areEqual(this.itemSource, selectionItemInfo.itemSource);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31;
        String str = this.sharedLinkUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.boxId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.itemSource;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "SelectionItemInfo(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", sharedLinkUrl=" + this.sharedLinkUrl + ", boxId=" + this.boxId + ", itemSource=" + this.itemSource + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.type);
        dest.writeString(this.sharedLinkUrl);
        dest.writeString(this.boxId);
        dest.writeString(this.itemSource);
    }

    public SelectionItemInfo(String id, String name, String type, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.name = name;
        this.type = type;
        this.sharedLinkUrl = str;
        this.boxId = str2;
        this.itemSource = str3;
    }

    public /* synthetic */ SelectionItemInfo(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final String getSharedLinkUrl() {
        return this.sharedLinkUrl;
    }

    public final String getBoxId() {
        return this.boxId;
    }

    public final String getItemSource() {
        return this.itemSource;
    }
}
