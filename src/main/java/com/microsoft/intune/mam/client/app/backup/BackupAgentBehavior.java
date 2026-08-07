package com.microsoft.intune.mam.client.app.backup;

import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.FullBackupDataOutput;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface BackupAgentBehavior {
    public static final String MAM_FILE_IDENTITY_KEY = "com.microsoft.intune.mam.MAMIdentity";

    void attachBaseContext(HookedBackupAgent hookedBackupAgent, Context context);

    void backupMAMFileIdentity(BackupDataOutput backupDataOutput, File... fileArr);

    void onBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException;

    void onCreate();

    void onFullBackup(FullBackupDataOutput fullBackupDataOutput) throws IOException;

    void onMAMFullBackup(FullBackupDataOutput fullBackupDataOutput) throws IOException;

    void onRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException;

    void onRestore(BackupDataInput backupDataInput, long j, ParcelFileDescriptor parcelFileDescriptor) throws IOException;

    void onRestoreFile(ParcelFileDescriptor parcelFileDescriptor, long j, File file, int i, long j2, long j3) throws IOException;

    void onRestoreFinished();
}
