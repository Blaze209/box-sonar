package com.microsoft.intune.mam.client.identity;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.app.MAMComponents;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMFileProtectionManager {
    private MAMFileProtectionManager() {
    }

    @Deprecated
    public static void protect(File file, String str) throws IOException {
        FileProtectionManagerBehavior fileProtectionManagerBehavior = (FileProtectionManagerBehavior) MAMComponents.get(FileProtectionManagerBehavior.class);
        if (fileProtectionManagerBehavior != null) {
            fileProtectionManagerBehavior.protect(file, str);
        }
    }

    public static void protectForOID(File file, String str) throws IOException {
        FileProtectionManagerBehavior fileProtectionManagerBehavior = (FileProtectionManagerBehavior) MAMComponents.get(FileProtectionManagerBehavior.class);
        if (fileProtectionManagerBehavior != null) {
            fileProtectionManagerBehavior.protect(file, ExternalIdentityUtils.identityFromOID(str));
        }
    }

    @Deprecated
    public static void protect(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        FileProtectionManagerBehavior fileProtectionManagerBehavior = (FileProtectionManagerBehavior) MAMComponents.get(FileProtectionManagerBehavior.class);
        if (fileProtectionManagerBehavior != null) {
            fileProtectionManagerBehavior.protect(parcelFileDescriptor, str);
        }
    }

    public static void protectForOID(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        FileProtectionManagerBehavior fileProtectionManagerBehavior = (FileProtectionManagerBehavior) MAMComponents.get(FileProtectionManagerBehavior.class);
        if (fileProtectionManagerBehavior != null) {
            fileProtectionManagerBehavior.protect(parcelFileDescriptor, ExternalIdentityUtils.identityFromOID(str));
        }
    }

    public static MAMFileProtectionInfo getProtectionInfo(File file) throws IOException {
        FileProtectionManagerBehavior fileProtectionManagerBehavior = (FileProtectionManagerBehavior) MAMComponents.get(FileProtectionManagerBehavior.class);
        if (fileProtectionManagerBehavior != null) {
            return fileProtectionManagerBehavior.getProtectionInfo(file);
        }
        return null;
    }

    public static MAMFileProtectionInfo getProtectionInfo(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        FileProtectionManagerBehavior fileProtectionManagerBehavior = (FileProtectionManagerBehavior) MAMComponents.get(FileProtectionManagerBehavior.class);
        if (fileProtectionManagerBehavior != null) {
            return fileProtectionManagerBehavior.getProtectionInfo(parcelFileDescriptor);
        }
        return null;
    }

    public static MAMFileProtectionInfo getProtectionInfo(Uri uri) throws IOException {
        FileProtectionManagerBehavior fileProtectionManagerBehavior = (FileProtectionManagerBehavior) MAMComponents.get(FileProtectionManagerBehavior.class);
        if (fileProtectionManagerBehavior != null) {
            return fileProtectionManagerBehavior.getProtectionInfo(uri);
        }
        return null;
    }

    public static boolean isBackupAllowed(File file) throws IOException {
        FileProtectionManagerBehavior fileProtectionManagerBehavior = (FileProtectionManagerBehavior) MAMComponents.get(FileProtectionManagerBehavior.class);
        if (fileProtectionManagerBehavior != null) {
            return fileProtectionManagerBehavior.isBackupAllowed(file);
        }
        return true;
    }
}
