package com.microsoft.intune.mam.client.app.offline;

import android.app.backup.BackupDataOutput;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.app.backup.FileBackupHelperBehavior;
import com.microsoft.intune.mam.client.app.backup.HookedFileBackupHelper;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineFileBackupHelperBehavior implements FileBackupHelperBehavior {
    private HookedFileBackupHelper mHelper;

    @Override // com.microsoft.intune.mam.client.app.backup.FileBackupHelperBehavior
    public void init(HookedFileBackupHelper hookedFileBackupHelper) {
        this.mHelper = hookedFileBackupHelper;
    }

    @Override // com.microsoft.intune.mam.client.app.backup.FileBackupHelperBehavior
    public void performBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) {
        this.mHelper.performBackupReal(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
    }
}
