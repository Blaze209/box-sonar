package com.microsoft.intune.mam.client.app.backup;

import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.FullBackupDataOutput;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.app.HookedContextWrapper;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedBackupAgent extends HookedContextWrapper {
    BackupAgent asBackupAgent();

    void onFullBackupReal(FullBackupDataOutput fullBackupDataOutput) throws IOException;

    void onMAMBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException;

    void onMAMCreate();

    void onMAMFullBackup(FullBackupDataOutput fullBackupDataOutput) throws IOException;

    void onMAMRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException;

    void onMAMRestore(MAMBackupDataInput mAMBackupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException;

    void onMAMRestore(MAMBackupDataInput mAMBackupDataInput, long j, ParcelFileDescriptor parcelFileDescriptor) throws IOException;

    void onMAMRestoreFile(ParcelFileDescriptor parcelFileDescriptor, long j, File file, int i, long j2, long j3) throws IOException;

    void onMAMRestoreFinished();

    void onRestoreFileReal(ParcelFileDescriptor parcelFileDescriptor, long j, File file, int i, long j2, long j3) throws IOException;
}
