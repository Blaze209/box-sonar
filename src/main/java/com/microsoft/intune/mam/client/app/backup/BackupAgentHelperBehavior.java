package com.microsoft.intune.mam.client.app.backup;

import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.BackupHelper;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface BackupAgentHelperBehavior {
    void addHelper(String str, BackupHelper backupHelper);

    void attachBaseContext(HookedBackupAgentHelper hookedBackupAgentHelper, Context context);

    void onBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException;

    void onCreate();

    void onRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException;
}
