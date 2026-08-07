package com.pspdfkit.annotations.stamps;

import android.os.Parcel;
import android.os.Parcelable;
import com.pspdfkit.internal.jni.NativeStampAnnotationHelper;
import com.pspdfkit.internal.jni.NativeStampType;
import com.pspdfkit.internal.uw;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class StampType implements Parcelable {
    public static final StampType ACCEPTED;
    public static final StampType APPROVED;
    public static final StampType AS_IS;
    public static final StampType COMPLETED;
    public static final StampType CONFIDENTIAL;
    public static final Parcelable.Creator<StampType> CREATOR;
    public static final StampType DEPARTMENTAL;
    public static final StampType DRAFT;
    public static final StampType EXPERIMENTAL;
    public static final StampType EXPIRED;
    public static final StampType FINAL;
    public static final StampType FOR_COMMENT;
    public static final StampType FOR_PUBLIC_RELEASE;
    public static final StampType INFORMATION_ONLY;
    public static final StampType INITIAL_HERE;
    public static final StampType NOT_APPROVED;
    public static final StampType NOT_FOR_PUBLIC_RELEASE;
    public static final StampType PRELIMINARY_RESULTS;
    public static final StampType REJECTED;
    public static final StampType REVISED;
    public static final StampType SIGN_HERE;
    public static final StampType SOLD;
    private static final StampType[] STAMP_TYPES;
    public static final StampType TOP_SECRET;
    public static final StampType VOID;
    public static final StampType WITNESS;
    private boolean isInitialized = false;
    private String name;
    private NativeStampType nativeType;

    static {
        StampType stampType = new StampType(NativeStampType.APPROVED);
        APPROVED = stampType;
        StampType stampType2 = new StampType(NativeStampType.EXPERIMENTAL);
        EXPERIMENTAL = stampType2;
        StampType stampType3 = new StampType(NativeStampType.NOTAPPROVED);
        NOT_APPROVED = stampType3;
        StampType stampType4 = new StampType(NativeStampType.ASIS);
        AS_IS = stampType4;
        StampType stampType5 = new StampType(NativeStampType.EXPIRED);
        EXPIRED = stampType5;
        StampType stampType6 = new StampType(NativeStampType.NOTFORPUBLICRELEASE);
        NOT_FOR_PUBLIC_RELEASE = stampType6;
        StampType stampType7 = new StampType(NativeStampType.CONFIDENTIAL);
        CONFIDENTIAL = stampType7;
        StampType stampType8 = new StampType(NativeStampType.FINAL);
        FINAL = stampType8;
        StampType stampType9 = new StampType(NativeStampType.SOLD);
        SOLD = stampType9;
        StampType stampType10 = new StampType(NativeStampType.DEPARTMENTAL);
        DEPARTMENTAL = stampType10;
        StampType stampType11 = new StampType(NativeStampType.FORCOMMENT);
        FOR_COMMENT = stampType11;
        StampType stampType12 = new StampType(NativeStampType.TOPSECRET);
        TOP_SECRET = stampType12;
        StampType stampType13 = new StampType(NativeStampType.DRAFT);
        DRAFT = stampType13;
        StampType stampType14 = new StampType(NativeStampType.FORPUBLICRELEASE);
        FOR_PUBLIC_RELEASE = stampType14;
        StampType stampType15 = new StampType(NativeStampType.COMPLETED);
        COMPLETED = stampType15;
        StampType stampType16 = new StampType(NativeStampType.VOID);
        VOID = stampType16;
        StampType stampType17 = new StampType(NativeStampType.PRELIMINARYRESULTS);
        PRELIMINARY_RESULTS = stampType17;
        StampType stampType18 = new StampType(NativeStampType.INFORMATIONONLY);
        INFORMATION_ONLY = stampType18;
        StampType stampType19 = new StampType(NativeStampType.REVISED);
        REVISED = stampType19;
        StampType stampType20 = new StampType(NativeStampType.ACCEPTED);
        ACCEPTED = stampType20;
        StampType stampType21 = new StampType(NativeStampType.REJECTED);
        REJECTED = stampType21;
        StampType stampType22 = new StampType(NativeStampType.INITIALHERE);
        INITIAL_HERE = stampType22;
        StampType stampType23 = new StampType(NativeStampType.SIGNHERE);
        SIGN_HERE = stampType23;
        StampType stampType24 = new StampType(NativeStampType.WITNESS);
        WITNESS = stampType24;
        STAMP_TYPES = new StampType[]{stampType, stampType2, stampType3, stampType4, stampType5, stampType6, stampType7, stampType8, stampType9, stampType10, stampType11, stampType12, stampType13, stampType14, stampType15, stampType16, stampType17, stampType18, stampType19, stampType20, stampType21, stampType22, stampType23, stampType24};
        CREATOR = new Parcelable.Creator<StampType>() { // from class: com.pspdfkit.annotations.stamps.StampType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public StampType createFromParcel(Parcel parcel) {
                String string = parcel.readString();
                if (string == null) {
                    string = "";
                }
                return StampType.fromName(string);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public StampType[] newArray(int i) {
                return new StampType[i];
            }
        };
    }

    private StampType(NativeStampType nativeStampType) {
        uw.a(nativeStampType, "nativeType", null);
        this.nativeType = nativeStampType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StampType fromName(String str) {
        StampType stampTypeFromNativeStampType;
        uw.a(str, "name", null);
        NativeStampType stampType = NativeStampAnnotationHelper.create().getStampType(str);
        return (stampType == null || (stampTypeFromNativeStampType = fromNativeStampType(stampType)) == null) ? new StampType(str) : stampTypeFromNativeStampType;
    }

    private static StampType fromNativeStampType(NativeStampType nativeStampType) {
        uw.a(nativeStampType, "nativeStampType", null);
        for (StampType stampType : STAMP_TYPES) {
            if (stampType.getNativeType() == nativeStampType) {
                return stampType;
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StampType) {
            return Objects.equals(getName(), ((StampType) obj).getName());
        }
        return false;
    }

    public String getName() {
        String str;
        synchronized (this) {
            if (this.name == null && !this.isInitialized) {
                this.name = NativeStampAnnotationHelper.create().getPreferredIconName(this.nativeType);
                this.isInitialized = true;
            }
            str = this.name;
        }
        return str;
    }

    public NativeStampType getNativeType() {
        NativeStampType nativeStampType;
        synchronized (this) {
            if (this.nativeType == null && !this.isInitialized) {
                this.nativeType = NativeStampAnnotationHelper.create().getStampType(this.name);
                this.isInitialized = true;
            }
            nativeStampType = this.nativeType;
        }
        return nativeStampType;
    }

    public int hashCode() {
        return Objects.hash(getName());
    }

    public boolean isStandard() {
        return getNativeType() != null;
    }

    public String toString() {
        return "StampType{name='" + getName() + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
    }

    public StampType(String str) {
        uw.a(str, "name", null);
        this.name = str;
    }
}
