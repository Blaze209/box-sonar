package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeCacheFileOperations {
    public abstract NativeCacheFileOperationError copyFile(String str, String str2);

    public abstract boolean fileExists(String str);

    public abstract NativeCacheFileSizeResult fileSize(String str);

    public abstract NativeCacheFileOperationError moveFile(String str, String str2);

    public abstract NativeCacheReadFileResult readFile(String str);

    public abstract NativeCacheFileOperationError removeFile(String str);

    public abstract NativeCacheFileOperationError writeFile(String str, byte[] bArr);
}
