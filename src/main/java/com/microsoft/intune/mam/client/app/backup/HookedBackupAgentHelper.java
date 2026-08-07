package com.microsoft.intune.mam.client.app.backup;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.BackupHelper;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedBackupAgentHelper {
    void addHelperReal(String str, BackupHelper backupHelper);

    void addMAMHelper(String str, BackupHelper backupHelper);

    BackupAgentHelper asBackupAgentHelper();

    void attachBaseContextReal(Context context);

    void onMAMBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException;

    void onMAMCreate();

    void onMAMRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException;

    void onMAMRestore(MAMBackupDataInput mAMBackupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException;
}
