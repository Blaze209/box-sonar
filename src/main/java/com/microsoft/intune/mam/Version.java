package com.microsoft.intune.mam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class Version implements Parcelable {
    public static final Parcelable.Creator<Version> CREATOR = new Parcelable.Creator<Version>() { // from class: com.microsoft.intune.mam.Version.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Version createFromParcel(Parcel parcel) {
            return new Version(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Version[] newArray(int i) {
            return new Version[i];
        }
    };
    protected long[] mComponents;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Version(String str) throws NumberFormatException {
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length == 0) {
            throw new NumberFormatException("version string cannot be empty");
        }
        this.mComponents = new long[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            this.mComponents[i] = Long.valueOf(strArrSplit[i]).longValue();
        }
    }

    public Version(long... jArr) {
        this.mComponents = jArr;
    }

    private Version(Parcel parcel) {
        int[] iArrCreateIntArray = parcel.createIntArray();
        this.mComponents = new long[iArrCreateIntArray.length];
        int i = 0;
        while (true) {
            long[] jArr = this.mComponents;
            if (i >= jArr.length) {
                return;
            }
            jArr[i] = iArrCreateIntArray[i];
            i++;
        }
    }

    public int getNumComponents() {
        return this.mComponents.length;
    }

    long[] getComponents() {
        return this.mComponents;
    }

    public boolean isOtherEqualOrNewer(Version version) {
        long[] jArr;
        int i = 0;
        while (true) {
            jArr = this.mComponents;
            if (i >= jArr.length) {
                break;
            }
            long[] jArr2 = version.mComponents;
            if (i >= jArr2.length) {
                break;
            }
            long j = jArr[i];
            long j2 = jArr2[i];
            if (j > j2) {
                return false;
            }
            if (j != j2) {
                return true;
            }
            i++;
        }
        long[] jArr3 = version.mComponents;
        int length = jArr3.length;
        if (length < jArr.length && jArr[length] != 0) {
            int i2 = length - 1;
            if (jArr3[i2] <= jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public boolean isOtherNewer(Version version) {
        return isOtherEqualOrNewer(version) && !version.isOtherEqualOrNewer(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            long[] jArr = this.mComponents;
            if (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i < this.mComponents.length) {
                    sb.append(".");
                }
            } else {
                return sb.toString();
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int[] iArr = new int[this.mComponents.length];
        int i2 = 0;
        while (true) {
            long[] jArr = this.mComponents;
            if (i2 < jArr.length) {
                iArr[i2] = (int) jArr[i2];
                i2++;
            } else {
                parcel.writeIntArray(iArr);
                return;
            }
        }
    }
}
