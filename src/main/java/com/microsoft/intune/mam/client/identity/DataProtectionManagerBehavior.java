package com.microsoft.intune.mam.client.identity;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface DataProtectionManagerBehavior {
    MAMDataProtectionInfo getProtectionInfo(InputStream inputStream) throws IOException;

    MAMDataProtectionInfo getProtectionInfo(byte[] bArr) throws IOException;

    boolean isBackupAllowed(InputStream inputStream) throws IOException;

    boolean isBackupAllowed(byte[] bArr) throws IOException;

    InputStream protect(InputStream inputStream, MAMIdentity mAMIdentity) throws IOException;

    @Deprecated
    InputStream protect(InputStream inputStream, String str) throws IOException;

    byte[] protect(byte[] bArr, MAMIdentity mAMIdentity) throws IOException;

    @Deprecated
    byte[] protect(byte[] bArr, String str) throws IOException;

    InputStream unprotect(InputStream inputStream) throws IOException;

    byte[] unprotect(byte[] bArr) throws IOException;
}
