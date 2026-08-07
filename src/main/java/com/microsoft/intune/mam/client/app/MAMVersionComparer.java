package com.microsoft.intune.mam.client.app;

import com.microsoft.intune.mam.client.MAMReleaseVersion;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMVersionComparer {
    public static final MAMVersionComparer INSTANCE = new MAMVersionComparer();
    private int mNumberOfReleasesSDKIsAhead;
    private final int mSDKVersion = 92;

    private MAMVersionComparer() {
        Integer mAMReleaseVersion = ((MAMReleaseVersion) MAMComponents.get(MAMReleaseVersion.class)).getMAMReleaseVersion();
        this.mNumberOfReleasesSDKIsAhead = (mAMReleaseVersion == null || 92 < mAMReleaseVersion.intValue()) ? 0 : 92 - mAMReleaseVersion.intValue();
    }

    public int getNumberOfReleasesSDKIsAhead() {
        return this.mNumberOfReleasesSDKIsAhead;
    }
}
