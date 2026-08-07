package com.microsoft.intune.mam.client.app.backup;

import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.FullBackupDataOutput;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.client.app.offline.OfflineBackupAgentBehavior;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMBackupAgent extends BackupAgent implements HookedBackupAgent {
    private BackupAgentBehavior mBehavior = (BackupAgentBehavior) MAMComponents.get(BackupAgentBehavior.class);
    private MAMIdentity mOfflineIdentity;

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgent
    public BackupAgent asBackupAgent() {
        return this;
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgent
    public abstract void onMAMBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException;

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        BackupAgentBehavior backupAgentBehavior = this.mBehavior;
        if (backupAgentBehavior == null || (backupAgentBehavior instanceof OfflineBackupAgentBehavior)) {
            MAMComponents.initialize(context);
            this.mBehavior = (BackupAgentBehavior) MAMComponents.get(BackupAgentBehavior.class);
        }
        this.mBehavior.attachBaseContext(this, context);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public final void attachBaseContextReal(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.backup.BackupAgent
    public final void onCreate() {
        this.mBehavior.onCreate();
    }

    @Override // android.app.backup.BackupAgent
    public final void onBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException {
        this.mBehavior.onBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
    }

    @Override // android.app.backup.BackupAgent
    public final void onFullBackup(FullBackupDataOutput fullBackupDataOutput) throws IOException {
        this.mBehavior.onFullBackup(fullBackupDataOutput);
    }

    @Override // android.app.backup.BackupAgent
    public final void onRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        this.mBehavior.onRestore(backupDataInput, i, parcelFileDescriptor);
    }

    @Override // android.app.backup.BackupAgent
    public final void onRestore(BackupDataInput backupDataInput, long j, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        this.mBehavior.onRestore(backupDataInput, j, parcelFileDescriptor);
    }

    @Override // android.app.backup.BackupAgent
    public final void onRestoreFile(ParcelFileDescriptor parcelFileDescriptor, long j, File file, int i, long j2, long j3) throws IOException {
        this.mBehavior.onRestoreFile(parcelFileDescriptor, j, file, i, j2, j3);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgent
    public void onMAMCreate() {
        super.onCreate();
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgent
    public void onMAMFullBackup(FullBackupDataOutput fullBackupDataOutput) throws IOException {
        this.mBehavior.onMAMFullBackup(fullBackupDataOutput);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgent
    @Deprecated
    public void onMAMRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        throw new IOException("The supported signature for onMAMRestore has changed as of SDK 5.0.0. Please call onMAMRestore with a MAMBackupDataInput in place of a BackupDataInput.");
    }

    @Deprecated
    public void onMAMRestore(BackupDataInput backupDataInput, long j, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        onMAMRestore(backupDataInput, (int) j, parcelFileDescriptor);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgent
    public void onMAMRestore(MAMBackupDataInput mAMBackupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        BackupDataInput backupDataInputAsBackupDataInput = mAMBackupDataInput.asBackupDataInput();
        try {
            MAMBackupDataInputHelper.track(backupDataInputAsBackupDataInput, mAMBackupDataInput);
            onMAMRestore(backupDataInputAsBackupDataInput, i, parcelFileDescriptor);
        } finally {
            MAMBackupDataInputHelper.remove(backupDataInputAsBackupDataInput);
        }
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgent
    public void onMAMRestore(MAMBackupDataInput mAMBackupDataInput, long j, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        BackupDataInput backupDataInputAsBackupDataInput = mAMBackupDataInput.asBackupDataInput();
        try {
            MAMBackupDataInputHelper.track(backupDataInputAsBackupDataInput, mAMBackupDataInput);
            onMAMRestore(backupDataInputAsBackupDataInput, j, parcelFileDescriptor);
        } finally {
            MAMBackupDataInputHelper.remove(backupDataInputAsBackupDataInput);
        }
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgent
    public void onMAMRestoreFile(ParcelFileDescriptor parcelFileDescriptor, long j, File file, int i, long j2, long j3) throws IOException {
        super.onRestoreFile(parcelFileDescriptor, j, file, i, j2, j3);
    }

    public final void backupMAMFileIdentity(BackupDataOutput backupDataOutput, File... fileArr) {
        this.mBehavior.backupMAMFileIdentity(backupDataOutput, fileArr);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgent
    public final void onFullBackupReal(FullBackupDataOutput fullBackupDataOutput) throws IOException {
        super.onFullBackup(fullBackupDataOutput);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgent
    public final void onRestoreFileReal(ParcelFileDescriptor parcelFileDescriptor, long j, File file, int i, long j2, long j3) throws IOException {
        super.onRestoreFile(parcelFileDescriptor, j, file, i, j2, j3);
    }

    @Override // android.app.backup.BackupAgent
    public final void onRestoreFinished() {
        this.mBehavior.onRestoreFinished();
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgent
    public void onMAMRestoreFinished() {
        super.onRestoreFinished();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public void setMAMOfflineIdentity(MAMIdentity mAMIdentity) {
        this.mOfflineIdentity = mAMIdentity;
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public MAMIdentity getMAMOfflineIdentity() {
        return this.mOfflineIdentity;
    }
}
