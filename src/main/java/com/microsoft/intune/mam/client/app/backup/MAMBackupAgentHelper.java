package com.microsoft.intune.mam.client.app.backup;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.BackupHelper;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.app.MAMComponents;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMBackupAgentHelper extends BackupAgentHelper implements HookedBackupAgentHelper {
    private final BackupAgentHelperBehavior mBehavior = (BackupAgentHelperBehavior) MAMComponents.get(BackupAgentHelperBehavior.class);

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgentHelper
    public BackupAgentHelper asBackupAgentHelper() {
        return this;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        this.mBehavior.attachBaseContext(this, context);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgentHelper
    public final void attachBaseContextReal(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.backup.BackupAgent
    public final void onCreate() {
        this.mBehavior.onCreate();
    }

    @Override // android.app.backup.BackupAgentHelper, android.app.backup.BackupAgent
    public final void onBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException {
        this.mBehavior.onBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
    }

    @Override // android.app.backup.BackupAgentHelper, android.app.backup.BackupAgent
    public final void onRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        this.mBehavior.onRestore(backupDataInput, i, parcelFileDescriptor);
    }

    @Override // android.app.backup.BackupAgentHelper
    public final void addHelper(String str, BackupHelper backupHelper) {
        this.mBehavior.addHelper(str, backupHelper);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgentHelper
    public void onMAMCreate() {
        super.onCreate();
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgentHelper
    public void onMAMBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException {
        super.onBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgentHelper
    public void onMAMRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        super.onRestore(backupDataInput, i, parcelFileDescriptor);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgentHelper
    public void onMAMRestore(MAMBackupDataInput mAMBackupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        BackupDataInput backupDataInputAsBackupDataInput = mAMBackupDataInput.asBackupDataInput();
        try {
            MAMBackupDataInputHelper.track(backupDataInputAsBackupDataInput, mAMBackupDataInput);
            onMAMRestore(backupDataInputAsBackupDataInput, i, parcelFileDescriptor);
        } finally {
            MAMBackupDataInputHelper.remove(backupDataInputAsBackupDataInput);
        }
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgentHelper
    public void addMAMHelper(String str, BackupHelper backupHelper) {
        this.mBehavior.addHelper(str, backupHelper);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupAgentHelper
    public final void addHelperReal(String str, BackupHelper backupHelper) {
        super.addHelper(str, backupHelper);
    }
}
