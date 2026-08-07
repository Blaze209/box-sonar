package com.microsoft.intune.mam.client.app.offline;

import android.app.backup.BackupDataInput;
import com.microsoft.intune.mam.client.app.backup.MAMBackupDataInput;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineBackupDataInput implements MAMBackupDataInput {
    private BackupDataInput mBackupDataInput;

    public OfflineBackupDataInput(BackupDataInput backupDataInput) {
        this.mBackupDataInput = backupDataInput;
    }

    @Override // com.microsoft.intune.mam.client.app.backup.MAMBackupDataInput
    public int getDataSize() {
        return this.mBackupDataInput.getDataSize();
    }

    @Override // com.microsoft.intune.mam.client.app.backup.MAMBackupDataInput
    public String getKey() {
        return this.mBackupDataInput.getKey();
    }

    @Override // com.microsoft.intune.mam.client.app.backup.MAMBackupDataInput
    public int readEntityData(byte[] bArr, int i, int i2) throws IOException {
        return this.mBackupDataInput.readEntityData(bArr, i, i2);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.MAMBackupDataInput
    public boolean readNextHeader() throws IOException {
        return this.mBackupDataInput.readNextHeader();
    }

    @Override // com.microsoft.intune.mam.client.app.backup.MAMBackupDataInput
    public void skipEntityData() throws IOException {
        this.mBackupDataInput.skipEntityData();
    }

    @Override // com.microsoft.intune.mam.client.app.backup.MAMBackupDataInput
    public BackupDataInput asBackupDataInput() {
        return this.mBackupDataInput;
    }
}
