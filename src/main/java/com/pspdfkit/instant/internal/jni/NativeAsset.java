package com.pspdfkit.instant.internal.jni;

import com.pspdfkit.internal.z40;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeAsset {
    final String mFilePath;
    final String mIdentifier;
    final NativeAssetLoadState mLoadState;
    final String mMimeType;

    public NativeAsset(String str, String str2, String str3, NativeAssetLoadState nativeAssetLoadState) {
        this.mIdentifier = str;
        this.mFilePath = str2;
        this.mMimeType = str3;
        this.mLoadState = nativeAssetLoadState;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NativeAsset)) {
            return false;
        }
        NativeAsset nativeAsset = (NativeAsset) obj;
        return this.mIdentifier.equals(nativeAsset.mIdentifier) && this.mFilePath.equals(nativeAsset.mFilePath) && this.mMimeType.equals(nativeAsset.mMimeType) && this.mLoadState == nativeAsset.mLoadState;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public NativeAssetLoadState getLoadState() {
        return this.mLoadState;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public int hashCode() {
        return this.mLoadState.hashCode() + z40.a(this.mMimeType, z40.a(this.mFilePath, z40.a(this.mIdentifier, 527, 31), 31), 31);
    }

    public String toString() {
        return "NativeAsset{mIdentifier=" + this.mIdentifier + ",mFilePath=" + this.mFilePath + ",mMimeType=" + this.mMimeType + ",mLoadState=" + this.mLoadState + "}";
    }
}
