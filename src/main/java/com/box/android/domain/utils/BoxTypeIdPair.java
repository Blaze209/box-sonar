package com.box.android.domain.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;

/* JADX INFO: loaded from: classes11.dex */
public class BoxTypeIdPair implements Parcelable {
    public static final Parcelable.Creator<BoxTypeIdPair> CREATOR = new Parcelable.Creator<BoxTypeIdPair>() { // from class: com.box.android.domain.utils.BoxTypeIdPair.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BoxTypeIdPair createFromParcel(Parcel parcel) {
            return new BoxTypeIdPair(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BoxTypeIdPair[] newArray(int i) {
            return new BoxTypeIdPair[i];
        }
    };
    private final String mItemId;
    private final String mType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BoxTypeIdPair(String str, String str2) {
        this.mType = str;
        this.mItemId = str2;
    }

    public BoxTypeIdPair(Parcel parcel) {
        this.mType = parcel.readString();
        this.mItemId = parcel.readString();
    }

    public static BoxTypeIdPair get(BoxItem boxItem) {
        return new BoxTypeIdPair(boxItem.getType(), boxItem.getUserId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BoxTypeIdPair boxTypeIdPair = (BoxTypeIdPair) obj;
            String str = this.mType;
            if (str == null ? boxTypeIdPair.mType != null : !str.equals(boxTypeIdPair.mType)) {
                return false;
            }
            String str2 = this.mItemId;
            if (str2 == null ? boxTypeIdPair.mItemId == null : str2.equals(boxTypeIdPair.mItemId)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.mItemId == null || this.mType == null) {
            return 0;
        }
        return (this.mType + this.mItemId).hashCode();
    }

    public String getType() {
        return this.mType;
    }

    public String getId() {
        return this.mItemId;
    }

    public BoxItem getItemLocal(BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiWeblink boxExtendedApiWeblink) {
        try {
            if (getType().equals("file")) {
                return boxExtendedApiFile.getInfoRequest(getId()).sendForCachedResult();
            }
            if (getType().equals("folder")) {
                return boxExtendedApiFolder.getInfoRequest(getId()).sendForCachedResult();
            }
            if (getType().equals(BoxBookmark.TYPE)) {
                return boxExtendedApiWeblink.getInfoRequest(getId()).sendForCachedResult();
            }
            return null;
        } catch (BoxException e) {
            BoxLogUtils.logException(e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mType);
        parcel.writeString(this.mItemId);
    }
}
