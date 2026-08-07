package com.microsoft.intune.mam.client.identity;

import com.microsoft.intune.mam.client.app.MAMComponents;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMDataProtectionManager {
    private MAMDataProtectionManager() {
    }

    @Deprecated
    public static InputStream protect(InputStream inputStream, String str) throws IOException {
        return ((DataProtectionManagerBehavior) MAMComponents.get(DataProtectionManagerBehavior.class)).protect(inputStream, str);
    }

    public static InputStream protectForOID(InputStream inputStream, String str) throws IOException {
        return ((DataProtectionManagerBehavior) MAMComponents.get(DataProtectionManagerBehavior.class)).protect(inputStream, ExternalIdentityUtils.identityFromOID(str));
    }

    @Deprecated
    public static byte[] protect(byte[] bArr, String str) throws IOException {
        return ((DataProtectionManagerBehavior) MAMComponents.get(DataProtectionManagerBehavior.class)).protect(bArr, str);
    }

    public static byte[] protectForOID(byte[] bArr, String str) throws IOException {
        return ((DataProtectionManagerBehavior) MAMComponents.get(DataProtectionManagerBehavior.class)).protect(bArr, ExternalIdentityUtils.identityFromOID(str));
    }

    public static InputStream unprotect(InputStream inputStream) throws IOException {
        return ((DataProtectionManagerBehavior) MAMComponents.get(DataProtectionManagerBehavior.class)).unprotect(inputStream);
    }

    public static byte[] unprotect(byte[] bArr) throws IOException {
        return ((DataProtectionManagerBehavior) MAMComponents.get(DataProtectionManagerBehavior.class)).unprotect(bArr);
    }

    public static MAMDataProtectionInfo getProtectionInfo(InputStream inputStream) throws IOException {
        return ((DataProtectionManagerBehavior) MAMComponents.get(DataProtectionManagerBehavior.class)).getProtectionInfo(inputStream);
    }

    public static MAMDataProtectionInfo getProtectionInfo(byte[] bArr) throws IOException {
        return ((DataProtectionManagerBehavior) MAMComponents.get(DataProtectionManagerBehavior.class)).getProtectionInfo(bArr);
    }

    public static boolean isBackupAllowed(byte[] bArr) throws IOException {
        return ((DataProtectionManagerBehavior) MAMComponents.get(DataProtectionManagerBehavior.class)).isBackupAllowed(bArr);
    }

    public static boolean isBackupAllowed(InputStream inputStream) throws IOException {
        return ((DataProtectionManagerBehavior) MAMComponents.get(DataProtectionManagerBehavior.class)).isBackupAllowed(inputStream);
    }
}
