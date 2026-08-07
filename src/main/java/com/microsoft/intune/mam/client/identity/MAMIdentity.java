package com.microsoft.intune.mam.client.identity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class MAMIdentity implements Parcelable {
    private static final String EMPTY_AADID = "";
    private static final String EMPTY_AUTHORITY = "";
    private static final String EMPTY_TENANTID = "";
    private static final String EMPTY_UPN = "";
    private static final String SERIALIZED_FORMAT = ";%s;%s;%s;%s";
    private final String mAadId;
    private final String mAuthority;
    private final String mTenantId;
    private final String mUPN;
    private final List<String> mUpnList;
    private final boolean mValidated;
    public static final MAMIdentity EMPTY = new MAMIdentity("", "", "", "");
    public static final Parcelable.Creator<MAMIdentity> CREATOR = new Parcelable.Creator<MAMIdentity>() { // from class: com.microsoft.intune.mam.client.identity.MAMIdentity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MAMIdentity[] newArray(int i) {
            return new MAMIdentity[i];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MAMIdentity createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            return new MAMIdentity(arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected MAMIdentity(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, false);
    }

    protected MAMIdentity(String str, String str2, String str3, String str4, boolean z) {
        this(Collections.singletonList(str), str2, str3, str4, z);
    }

    protected MAMIdentity(Collection<String> collection, String str, String str2, String str3, boolean z) {
        ArrayList arrayList = new ArrayList(collection);
        this.mUpnList = arrayList;
        boolean z2 = false;
        if (arrayList.isEmpty()) {
            this.mUPN = "";
        } else {
            this.mUPN = (String) arrayList.get(0);
        }
        this.mAadId = canonicalize(str);
        this.mAuthority = str2;
        this.mTenantId = canonicalize(str3);
        if (z && isDataValid()) {
            z2 = true;
        }
        this.mValidated = z2;
    }

    private boolean isDataValid() {
        String str;
        String str2;
        return (!hasValidAadId() || (str = this.mTenantId) == null || str.isEmpty() || (str2 = this.mAuthority) == null || str2.isEmpty()) ? false : true;
    }

    public String rawUPN() {
        return this.mUPN;
    }

    public String canonicalUPN() {
        return canonicalize(this.mUPN);
    }

    public List<String> upns() {
        return this.mUpnList;
    }

    public boolean hasUPN(String str) {
        for (String str2 : this.mUpnList) {
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public String aadId() {
        return this.mAadId;
    }

    public boolean hasValidAadId() {
        String str = this.mAadId;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public String authority() {
        return this.mAuthority;
    }

    public String tenantId() {
        return this.mTenantId;
    }

    public boolean validated() {
        return this.mValidated;
    }

    public static String canonicalize(String str) {
        if (str != null) {
            return str.toLowerCase(Locale.getDefault());
        }
        return null;
    }

    public static boolean isNullOrEmpty(MAMIdentity mAMIdentity) {
        return mAMIdentity == null || EMPTY.equals(mAMIdentity);
    }

    public static boolean isValid(MAMIdentity mAMIdentity) {
        return mAMIdentity != null && mAMIdentity.hasValidAadId();
    }

    public String toString() {
        String str = this.mAadId;
        if (str == null) {
            return this.mUPN;
        }
        return String.format(SERIALIZED_FORMAT, this.mUPN, str, this.mAuthority, this.mTenantId);
    }

    public int hashCode() {
        if (!hasValidAadId()) {
            return canonicalUPN().hashCode();
        }
        return this.mAadId.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MAMIdentity)) {
            return false;
        }
        MAMIdentity mAMIdentity = (MAMIdentity) obj;
        if (hasValidAadId() && mAMIdentity.hasValidAadId()) {
            return aadId().equals(mAMIdentity.aadId());
        }
        if (hasValidAadId() || mAMIdentity.hasValidAadId()) {
            return false;
        }
        return canonicalUPN().equals(mAMIdentity.canonicalUPN());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.mUpnList);
        parcel.writeString(aadId());
        parcel.writeString(authority());
        parcel.writeString(tenantId());
        parcel.writeInt(validated() ? 1 : 0);
    }
}
