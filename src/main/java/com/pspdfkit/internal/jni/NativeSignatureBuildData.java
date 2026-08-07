package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeSignatureBuildData {
    final String mDate;
    final Integer mMinimumVersion;
    final String mName;
    final boolean mNonEmbeddedFontNoWarn;
    final String mOperatingSystem;
    final boolean mPreRelease;
    final Integer mRevision;
    final String mRevisionText;
    final boolean mTrustedMode;

    public NativeSignatureBuildData(String str, String str2, Integer num, String str3, String str4, boolean z, boolean z2, boolean z3, Integer num2) {
        this.mName = str;
        this.mDate = str2;
        this.mRevision = num;
        this.mRevisionText = str3;
        this.mOperatingSystem = str4;
        this.mPreRelease = z;
        this.mNonEmbeddedFontNoWarn = z2;
        this.mTrustedMode = z3;
        this.mMinimumVersion = num2;
    }

    public String getDate() {
        return this.mDate;
    }

    public Integer getMinimumVersion() {
        return this.mMinimumVersion;
    }

    public String getName() {
        return this.mName;
    }

    public boolean getNonEmbeddedFontNoWarn() {
        return this.mNonEmbeddedFontNoWarn;
    }

    public String getOperatingSystem() {
        return this.mOperatingSystem;
    }

    public boolean getPreRelease() {
        return this.mPreRelease;
    }

    public Integer getRevision() {
        return this.mRevision;
    }

    public String getRevisionText() {
        return this.mRevisionText;
    }

    public boolean getTrustedMode() {
        return this.mTrustedMode;
    }

    public String toString() {
        return "NativeSignatureBuildData{mName=" + this.mName + ",mDate=" + this.mDate + ",mRevision=" + this.mRevision + ",mRevisionText=" + this.mRevisionText + ",mOperatingSystem=" + this.mOperatingSystem + ",mPreRelease=" + this.mPreRelease + ",mNonEmbeddedFontNoWarn=" + this.mNonEmbeddedFontNoWarn + ",mTrustedMode=" + this.mTrustedMode + ",mMinimumVersion=" + this.mMinimumVersion + "}";
    }
}
