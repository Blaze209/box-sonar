package com.microsoft.intune.mam.client.app.backup;

import android.app.backup.BackupDataOutput;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class MAMDefaultBackupAgent extends MAMBackupAgent {
    @Override // com.microsoft.intune.mam.client.app.backup.MAMBackupAgent, com.microsoft.intune.mam.client.app.backup.HookedBackupAgent
    public void onMAMBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException {
    }

    @Override // com.microsoft.intune.mam.client.app.backup.MAMBackupAgent, com.microsoft.intune.mam.client.app.backup.HookedBackupAgent
    public void onMAMRestore(MAMBackupDataInput mAMBackupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
    }
}
