package com.microsoft.intune.mam.client.app.offline;

import android.app.backup.BackupDataOutput;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.app.backup.HookedSharedPreferencesBackupHelper;
import com.microsoft.intune.mam.client.app.backup.SharedPreferencesBackupHelperBehavior;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineSharedPreferencesBackupHelperBehavior implements SharedPreferencesBackupHelperBehavior {
    private HookedSharedPreferencesBackupHelper mHelper;

    @Override // com.microsoft.intune.mam.client.app.backup.SharedPreferencesBackupHelperBehavior
    public void init(HookedSharedPreferencesBackupHelper hookedSharedPreferencesBackupHelper) {
        this.mHelper = hookedSharedPreferencesBackupHelper;
    }

    @Override // com.microsoft.intune.mam.client.app.backup.SharedPreferencesBackupHelperBehavior
    public void performBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) {
        this.mHelper.performBackupReal(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
    }
}
