package com.microsoft.intune.mam.client.app.backup;

import android.app.backup.BackupDataOutput;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public interface SharedPreferencesBackupHelperBehavior {
    void init(HookedSharedPreferencesBackupHelper hookedSharedPreferencesBackupHelper);

    void performBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2);
}
