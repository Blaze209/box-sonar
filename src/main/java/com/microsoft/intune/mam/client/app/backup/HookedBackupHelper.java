package com.microsoft.intune.mam.client.app.backup;

import android.app.backup.BackupDataOutput;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedBackupHelper {
    Context getContext();

    String[] getFileNames();

    File getRootDirectory();

    boolean isValid();

    void performBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2);

    void performBackupReal(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2);
}
