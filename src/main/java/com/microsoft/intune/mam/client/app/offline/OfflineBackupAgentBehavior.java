package com.microsoft.intune.mam.client.app.offline;

import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.FullBackupDataOutput;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.app.backup.BackupAgentBehavior;
import com.microsoft.intune.mam.client.app.backup.HookedBackupAgent;
import com.microsoft.intune.mam.client.app.backup.MAMBackupDataInput;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class OfflineBackupAgentBehavior implements BackupAgentBehavior {
    private HookedBackupAgent mBackupAgent;

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentBehavior
    public void backupMAMFileIdentity(BackupDataOutput backupDataOutput, File... fileArr) {
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentBehavior
    public void attachBaseContext(HookedBackupAgent hookedBackupAgent, Context context) {
        this.mBackupAgent = hookedBackupAgent;
        hookedBackupAgent.attachBaseContextReal(context);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentBehavior
    public void onCreate() {
        if (MAMInfo.isPolicyRequired()) {
            return;
        }
        this.mBackupAgent.onMAMCreate();
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentBehavior
    public void onBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException {
        if (MAMInfo.isPolicyRequired()) {
            return;
        }
        this.mBackupAgent.onMAMBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentBehavior
    public void onFullBackup(FullBackupDataOutput fullBackupDataOutput) throws IOException {
        if (MAMInfo.isPolicyRequired()) {
            return;
        }
        this.mBackupAgent.onMAMFullBackup(fullBackupDataOutput);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentBehavior
    public void onRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        if (MAMInfo.isPolicyRequired()) {
            return;
        }
        this.mBackupAgent.onMAMRestore((MAMBackupDataInput) new OfflineBackupDataInput(backupDataInput), i, parcelFileDescriptor);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentBehavior
    public void onRestore(BackupDataInput backupDataInput, long j, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        if (MAMInfo.isPolicyRequired()) {
            return;
        }
        this.mBackupAgent.onMAMRestore(new OfflineBackupDataInput(backupDataInput), j, parcelFileDescriptor);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentBehavior
    public void onRestoreFile(ParcelFileDescriptor parcelFileDescriptor, long j, File file, int i, long j2, long j3) throws IOException {
        if (MAMInfo.isPolicyRequired()) {
            return;
        }
        this.mBackupAgent.onMAMRestoreFile(parcelFileDescriptor, j, file, i, j2, j3);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentBehavior
    public void onMAMFullBackup(FullBackupDataOutput fullBackupDataOutput) throws IOException {
        this.mBackupAgent.onFullBackupReal(fullBackupDataOutput);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.BackupAgentBehavior
    public void onRestoreFinished() {
        this.mBackupAgent.onMAMRestoreFinished();
    }
}
