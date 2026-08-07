package com.microsoft.intune.mam.client.app.offline;

import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.BackupHelper;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.app.backup.BackupAgentHelperBehavior;
import com.microsoft.intune.mam.client.app.backup.HookedBackupAgentHelper;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
final class OfflineBackupAgentHelperBehavior implements BackupAgentHelperBehavior {
    private HookedBackupAgentHelper mBackupAgentHelper;

    OfflineBackupAgentHelperBehavior() {
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentHelperBehavior
    public void attachBaseContext(HookedBackupAgentHelper hookedBackupAgentHelper, Context context) {
        this.mBackupAgentHelper = hookedBackupAgentHelper;
        hookedBackupAgentHelper.attachBaseContextReal(context);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentHelperBehavior
    public void onCreate() {
        if (MAMInfo.isPolicyRequired()) {
            return;
        }
        this.mBackupAgentHelper.onMAMCreate();
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentHelperBehavior
    public void onBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException {
        if (MAMInfo.isPolicyRequired()) {
            return;
        }
        this.mBackupAgentHelper.onMAMBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentHelperBehavior
    public void onRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        if (MAMInfo.isPolicyRequired()) {
            return;
        }
        this.mBackupAgentHelper.onMAMRestore(new OfflineBackupDataInput(backupDataInput), i, parcelFileDescriptor);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentHelperBehavior
    public void addHelper(String str, BackupHelper backupHelper) {
        if (MAMInfo.isPolicyRequired()) {
            return;
        }
        this.mBackupAgentHelper.addHelperReal(str, backupHelper);
    }
}
