package io.split.android.engine.matchers.semver;

import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
class Semver {
    private static final String METADATA_DELIMITER = "+";
    private static final String PRE_RELEASE_DELIMITER = "-";
    private static final String VALUE_DELIMITER = "\\.";
    private boolean mIsStable;
    private Long mMajor;
    private String mMetadata;
    private Long mMinor;
    private Long mPatch;
    private String[] mPreRelease = new String[0];
    private final String mVersion;

    static Semver build(String version) {
        try {
            return new Semver(version);
        } catch (Exception e) {
            Logger.e("An error occurred during the creation of a Semver instance:", e.getMessage());
            return null;
        }
    }

    private Semver(String version) throws SemverParseException {
        setMajorMinorAndPatch(setAndRemovePreReleaseIfExists(setAndRemoveMetadataIfExists(version)));
        this.mVersion = setVersion();
    }

    public int compare(Semver toCompare) {
        if (this.mVersion.equals(toCompare.getVersion())) {
            return 0;
        }
        int iCompare = Long.compare(this.mMajor.longValue(), toCompare.mMajor.longValue());
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Long.compare(this.mMinor.longValue(), toCompare.mMinor.longValue());
        if (iCompare2 != 0) {
            return iCompare2;
        }
        int iCompare3 = Long.compare(this.mPatch.longValue(), toCompare.mPatch.longValue());
        if (iCompare3 != 0) {
            return iCompare3;
        }
        boolean z = this.mIsStable;
        if (!z && toCompare.mIsStable) {
            return -1;
        }
        if (z && !toCompare.mIsStable) {
            return 1;
        }
        int iMin = Math.min(this.mPreRelease.length, toCompare.mPreRelease.length);
        for (int i = 0; i < iMin; i++) {
            if (!this.mPreRelease[i].equals(toCompare.mPreRelease[i])) {
                if (isNumeric(this.mPreRelease[i]) && isNumeric(toCompare.mPreRelease[i])) {
                    return Long.compare(Long.parseLong(this.mPreRelease[i]), Long.parseLong(toCompare.mPreRelease[i]));
                }
                return this.mPreRelease[i].compareTo(toCompare.mPreRelease[i]);
            }
        }
        return Integer.compare(this.mPreRelease.length, toCompare.mPreRelease.length);
    }

    public String getVersion() {
        return this.mVersion;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Semver) {
            return this.mVersion.equals(((Semver) obj).getVersion());
        }
        return false;
    }

    private String setAndRemoveMetadataIfExists(String version) throws SemverParseException {
        int iIndexOf = version.indexOf("+");
        if (iIndexOf == -1) {
            return version;
        }
        String strSubstring = version.substring(iIndexOf + 1);
        this.mMetadata = strSubstring;
        if (strSubstring == null || strSubstring.isEmpty()) {
            throw new SemverParseException("Unable to convert to Semver, incorrect metadata");
        }
        return version.substring(0, iIndexOf);
    }

    private String setAndRemovePreReleaseIfExists(String vWithoutMetadata) throws SemverParseException {
        int iIndexOf = vWithoutMetadata.indexOf("-");
        if (iIndexOf == -1) {
            this.mIsStable = true;
            return vWithoutMetadata;
        }
        String[] strArrSplit = vWithoutMetadata.substring(iIndexOf + 1).split(VALUE_DELIMITER);
        this.mPreRelease = strArrSplit;
        if (strArrSplit == null || containsNullOrEmpty(strArrSplit)) {
            throw new SemverParseException("Unable to convert to Semver, incorrect pre release data");
        }
        return vWithoutMetadata.substring(0, iIndexOf);
    }

    private static boolean containsNullOrEmpty(String[] preRelease) {
        for (String str : preRelease) {
            if (str == null || str.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void setMajorMinorAndPatch(String version) throws SemverParseException {
        String[] strArrSplit = version.split(VALUE_DELIMITER);
        if (strArrSplit.length != 3) {
            Logger.e("Unable to convert to Semver, incorrect format: " + version);
            throw new SemverParseException("Unable to convert to Semver, incorrect format: " + version);
        }
        this.mMajor = Long.valueOf(Long.parseLong(strArrSplit[0]));
        this.mMinor = Long.valueOf(Long.parseLong(strArrSplit[1]));
        this.mPatch = Long.valueOf(Long.parseLong(strArrSplit[2]));
    }

    private String setVersion() {
        String str = this.mMajor + VALUE_DELIMITER + this.mMinor + VALUE_DELIMITER + this.mPatch;
        String[] strArr = this.mPreRelease;
        if (strArr != null && strArr.length != 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.mPreRelease;
                if (i >= strArr2.length) {
                    break;
                }
                if (isNumeric(strArr2[i])) {
                    String[] strArr3 = this.mPreRelease;
                    strArr3[i] = String.valueOf(Long.parseLong(strArr3[i]));
                }
                i++;
            }
            str = str + "-" + String.join(VALUE_DELIMITER, this.mPreRelease);
        }
        String str2 = this.mMetadata;
        return (str2 == null || str2.isEmpty()) ? str : str + "+" + this.mMetadata;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
