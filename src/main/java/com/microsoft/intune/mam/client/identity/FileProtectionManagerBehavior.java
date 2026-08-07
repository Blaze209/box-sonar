package com.microsoft.intune.mam.client.identity;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface FileProtectionManagerBehavior {
    MAMFileProtectionInfo getProtectionInfo(Uri uri) throws IOException;

    MAMFileProtectionInfo getProtectionInfo(ParcelFileDescriptor parcelFileDescriptor) throws IOException;

    MAMFileProtectionInfo getProtectionInfo(File file) throws IOException;

    boolean isBackupAllowed(File file) throws IOException;

    void protect(ParcelFileDescriptor parcelFileDescriptor, MAMIdentity mAMIdentity) throws IOException;

    @Deprecated
    void protect(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException;

    void protect(File file, MAMIdentity mAMIdentity) throws IOException;

    @Deprecated
    void protect(File file, String str) throws IOException;
}
